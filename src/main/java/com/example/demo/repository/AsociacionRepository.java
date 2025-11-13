package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Asociacion;

@Repository
public interface AsociacionRepository extends JpaRepository<Asociacion,Long> {
}
