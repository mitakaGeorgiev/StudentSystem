package com.example.demo.service;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentsAndCreditsView;

@Repository
public interface StudentsAndCreditsViewRepository extends ReadOnlyRepository<StudentsAndCreditsView, Long>{

}
