package com.gmail.fuskerr63.dao;

import com.gmail.fuskerr63.domain.Spitter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SpitterDAO {
    JdbcTemplate jdbcTemplate;

    @Inject
    public SpitterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_SPITTER_SQL =
            "INSERT INTO spitter (name, username, password, email, update_by_email, is_image_upload) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SELECT_SPITTER_BY_USERNAME =
            "SELECT * FROM spitter WHERE username=?";

    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(
                INSERT_SPITTER_SQL,
                spitter.getName(),
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getEmail(),
                spitter.isUpdateByEmail(),
                spitter.isImageUpload()
        );
    }

    public Spitter getSpitterByUsername(String username) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SPITTER_BY_USERNAME, new SpitterRowMapper(), username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
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
                    resultSet.getBoolean("update_by_email"),
                    resultSet.getBoolean("is_image_upload")
            );
        }
    }
}
