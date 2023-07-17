package com.example.jpa.service;

import com.example.jpa.entity.batchsize.Team;
import com.example.jpa.entity.fetchjoin.Owner;
import com.example.jpa.entity.fetchjoin.Pet;
import com.example.jpa.repository.OwnerRepository;
import com.example.jpa.repository.PetRepository;
import com.example.jpa.repository.TeamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PetServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;
    @BeforeEach
    public void setup(){
        IntStream.rangeClosed(1,3).forEach(i->{
            Owner owner = new Owner("owner" + i);

            IntStream.rangeClosed(1,3).forEach(j->{
                owner.addPet("pet"+i+j);
            });
        ownerRepository.save(owner);
        });
    }

    @AfterEach
    public void cleanAll(){
        ownerRepository.deleteAll();
    }


    @Test
    @DisplayName("N+1문제 생성")
    void test(){
        em.flush();
        em.clear();
        System.out.println("------------ POST 전체 조회 요청 ------------");
        List<Pet> pets = petRepository.findAll();
        System.out.println("------------ POST 전체 조회 완료 ------------");

        System.out.println("------------ COMMENT와 연관된 POST 조회 [ N + 1 문제 발생 ] ------------");
        pets.stream().forEach(pet -> {
            pet.getOwner().getName();
        });
        System.out.println("------------ COMMENT와 연관된 POST 조회 완료 ------------\n\n");

    }
}