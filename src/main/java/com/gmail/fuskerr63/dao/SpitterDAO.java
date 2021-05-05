package com.gmail.fuskerr63.dao;

import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SpitterDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public SpitterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_SPITTER_SQL =
            "INSERT INTO spitter (name, username, password, email, update_by_email) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_SPITTER_BY_USERNAME =
            "SELECT * FROM spitter WHERE username=?";

    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(
                INSERT_SPITTER_SQL,
                spitter.getName(),
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getEmail(),
                spitter.isUpdateByEmail()
        );
    }

    public Spitter getSpitterByUsername(String username) {
        return jdbcTemplate.queryForObject(SELECT_SPITTER_BY_USERNAME, new SpitterRowMapper(), username);
    }

    private class SpitterRowMapper implements RowMapper<Spitter> {
        @Override
        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spitter(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getBoolean("update_by_email")
            );
        }
    }
}
