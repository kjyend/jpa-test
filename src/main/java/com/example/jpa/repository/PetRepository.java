package com.example.jpa.repository;

import com.example.jpa.entity.fetchjoin.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {

    @Override
    @Query("select DISTINCT p from Pet p join fetch p.owner")
    List<Pet> findAll();
}
