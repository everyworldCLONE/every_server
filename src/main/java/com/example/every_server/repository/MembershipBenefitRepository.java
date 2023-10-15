package com.example.every_server.repository;

import com.example.every_server.entity.MembershipBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipBenefitRepository extends JpaRepository<MembershipBenefit,Long>{

    List<MembershipBenefit> findAllByLanguage(String language);
}
