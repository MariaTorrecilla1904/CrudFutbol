package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
