package com.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.entity.Courses;

public interface DaoCourse extends JpaRepository<Courses, Integer>{

}
