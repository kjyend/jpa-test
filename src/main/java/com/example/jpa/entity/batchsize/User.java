package com.example.jpa.entity.batchsize;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public User(String name, Team team) {
        this.name = name;
        this.team = team;
    }
}
