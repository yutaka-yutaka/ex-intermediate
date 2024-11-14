package com.example.ex_intermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ex_intermediate.domain.Team;
import com.example.ex_intermediate.repository.TeamRepository;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    /**
     * findAll()を呼び出し
     *
     * @author Yutaka Nishizawa
     */
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    /**
     * findbyId()を呼び出し
     *
     * @author Yutaka Nishizawa
     */
    public Team findbyId(@PathVariable Integer id) {
        return teamRepository.findbyId(id);
    }

}
