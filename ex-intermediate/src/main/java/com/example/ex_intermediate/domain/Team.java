package com.example.ex_intermediate.domain;

/**
 * 各球団情報を定義
 * 
 * @author Yutaka Nishizawa
 * 
 */
public class Team {
    // id
    private Integer id;
    // リーグ名
    private String leaguename;
    // チーム名
    private String teamname;
    // 本拠地スタジアム
    private String headquarters;
    // 創立日
    private String inauguration;
    // 球団の歴史
    private String history;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeaguename() {
        return leaguename;
    }

    public void setLeaguename(String leaguename) {
        this.leaguename = leaguename;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getInauguration() {
        return inauguration;
    }

    public void setInauguration(String inauguration) {
        this.inauguration = inauguration;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

}
