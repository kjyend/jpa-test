package com.example.jpa.entity.fetchjoin;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Builder
    public Pet(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
    }
}
