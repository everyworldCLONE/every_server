package com.example.every_server.repository;

import com.example.every_server.entity.MembershipSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipScheduleRepository extends JpaRepository<MembershipSchedule,Long>{

    List<MembershipSchedule> findAllByLanguage(String language);
}
