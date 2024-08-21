package com.projects.igritdatacollector;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DataBaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testDataBaseConnection() throws SQLException {
        assertThat(dataSource).isNotNull();

        try (var connection = dataSource.getConnection()) {
            assertThat(connection).isNotNull();

        }
    }

    @Test
    void testTablesCreation() {
        String sql = "SELECT count(*) FROM information_schema.tables WHERE table_name = 'listing'";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        assertThat(count).isEqualTo(1);
    }

}
