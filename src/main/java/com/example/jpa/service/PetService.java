package com.example.jpa.service;

import com.example.jpa.entity.batchsize.Team;
import com.example.jpa.entity.fetchjoin.Pet;
import com.example.jpa.repository.PetRepository;
import com.example.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private PetRepository petRepository;

    public List<Pet> findAll(){
        return petRepository.findAll();
    }
}
