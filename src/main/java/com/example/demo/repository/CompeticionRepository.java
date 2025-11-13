package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Competicion;

@Repository
public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
}
