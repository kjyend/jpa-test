package com.example.jpa.entity.fetchjoin;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Owner {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    @Builder
    public Owner(String name) {
        this.name = name;
    }

    public Pet addPet(String name){
        Pet pet=new Pet(name,this);
        this.pets.add(pet);
        return pet;
    }
}
