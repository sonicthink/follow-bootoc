package com.github.kevinjom.bootoc.support;

import org.flywaydb.core.Flyway;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FlywayMigrationStrategySupport implements FlywayMigrationStrategy {
    @Value("${db.master.url}")
    private String masterDbUrl;

    @Value("${db.name}")
    private String dbName;

    @Override
    public void migrate(Flyway flyway) {
        createDbIfNecessary();
        flyway.migrate();
    }

    private void createDbIfNecessary() {
        DataSource rootDataSource = new SimpleDriverDataSource(new Driver(), masterDbUrl);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(rootDataSource);

        boolean existed = jdbcTemplate.queryForList("select datname from pg_catalog.pg_database where datname=?", dbName).size() > 0;
        if (!existed) {
            jdbcTemplate.execute("create database " + dbName + " with encoding 'UTF8'");
        }
    }
}
