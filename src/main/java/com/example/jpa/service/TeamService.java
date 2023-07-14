package com.example.jpa.service;

import com.example.jpa.entity.Team;
import com.example.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;

    public List<Team> findAll(){
        return teamRepository.findAll();
    }
}
