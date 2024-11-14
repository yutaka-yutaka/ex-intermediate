package com.example.ex_intermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ex_intermediate.domain.Team;

/**
 * TeamオブジェクトにDB情報をセット
 *
 * @author Yutaka Nishizawa
 */

@Repository
@Transactional
public class TeamRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Team> T_ROW_MAPPER = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeaguename(rs.getString("league_name"));
        team.setTeamname(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
    };

    /**
     * 全チームの情報をリストで取得
     *
     * @author Yutaka Nishizawa
     */
    public List<Team> findAll() {

        String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration ASC;";

        List<Team> teamList = template.query(sql, T_ROW_MAPPER);

        return teamList;
    }

    /**
     * チーム情報をチームIDで取得
     *
     * @author Yutaka Nishizawa
     */
    public Team findbyId(Integer id) {
        String sql = "SELECT * FROM teams WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return template.queryForObject(sql, params, T_ROW_MAPPER);
    }

}
