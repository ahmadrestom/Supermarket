package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.category;

public interface CategoryRepository extends JpaRepository<category, Integer>{

}
