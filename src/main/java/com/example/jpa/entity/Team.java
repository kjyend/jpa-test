package com.example.jpa.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }

    public User addUser(String name){
        User user = new User(name, this);
        this.users.add(user);
        return user;
    }
}
