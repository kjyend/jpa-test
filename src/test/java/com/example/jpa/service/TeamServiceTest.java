package com.example.jpa.service;

import com.example.jpa.entity.Team;
import com.example.jpa.entity.User;
import com.example.jpa.repository.TeamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@Transactional
@SpringBootTest
class TeamServiceTest {
    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    public void setup(){
        IntStream.rangeClosed(1,10).forEach(i->{
            Team team = new Team("team" + i);

            IntStream.rangeClosed(1,3).forEach(j->{
                team.addUser("user"+i+j);
            });
            teamRepository.save(team);
        });
    }
    @AfterEach
    public void cleanAll(){
        teamRepository.deleteAll();
    }
    
    @Test
    @DisplayName("N+1문제 생성")
    void test(){
        System.out.println("------------ POST 전체 조회 요청 ------------");
        List<Team> teams = teamRepository.findAll();
        System.out.println("------------ POST 전체 조회 완료. [1번의 쿼리 발생]------------\n\n");

        System.out.println("------------ POST에 달린 comment 내용 조회 요청 [조회된 POST의 개수(N=10) 만큼 추가적인 쿼리 발생]------------");
        teams.forEach(team -> {
            team.getUsers().forEach(user -> {
                System.out.println("이름 : "+user.getName());
            });
        });

        System.out.println("------------ POST에 달린 comment 내용 조회 완료 ------------\n\n");
    }
}