package com.example.jpa.repository;

import com.example.jpa.entity.fetchjoin.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
