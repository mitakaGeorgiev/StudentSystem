package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}
