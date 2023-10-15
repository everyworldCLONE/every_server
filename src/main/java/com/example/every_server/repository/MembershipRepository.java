package com.example.every_server.repository;

import com.example.every_server.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long>{

    List<Membership> findAllByLanguage(String language);
}
