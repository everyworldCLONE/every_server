package com.example.every_server.repository;

import com.example.every_server.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<Home,Long>{
    List<Home> findAllByLanguage(String language);
}
