package lingyun.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class ParentJdbcTemaplate {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
