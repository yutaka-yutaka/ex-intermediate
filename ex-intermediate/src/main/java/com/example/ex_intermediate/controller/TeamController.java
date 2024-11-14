package com.example.ex_intermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_intermediate.domain.Team;
import com.example.ex_intermediate.service.TeamService;

@Controller
@RequestMapping("")
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * 全チームを取得
     * 
     * @author Yutaka Nishizawa
     */
    @GetMapping
    public String findAll(Model model) {
        List<Team> teams = teamService.findAll(); // チームのリストを取得
        model.addAttribute("teams", teams); // モデルにチームリストを追加
        return "teamList";
    }

    /**
     * チームごとの情報を表示
     *
     * @author Yutaka Nishizawa
     */
    @GetMapping("/{id}")
    public String findbyId(@PathVariable Integer id, Model model) {
        Team team = teamService.findbyId(id);
        
        String historyWithBreaks = team.getHistory().replace("\n", "<br>");
        model.addAttribute("team", team);
        model.addAttribute("historyWithBreaks", historyWithBreaks);
        return "teamDetail";
    }

}
