package com.example.jpa.repository;

import com.example.jpa.entity.batchsize.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

}
