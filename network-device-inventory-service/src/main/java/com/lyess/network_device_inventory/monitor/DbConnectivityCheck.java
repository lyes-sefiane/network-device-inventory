package com.lyess.network_device_inventory.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-04-15 12:05 p.m.
 */
@Component
public class DbConnectivityCheck implements HealthIndicator {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DbConnectivityCheck(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Health health() {
        int checkResult = check();
        if(checkResult != 1) {
            return Health.down().withDetail("DB Connectivity", "Fail").build();
        }
        return Health.up().withDetail("DB Connectivity", "Success").build();
    }

    private int check() {
       List<Object> results = jdbcTemplate.query("select 1", new SingleColumnRowMapper<>());
       return results.size();
    }
}
