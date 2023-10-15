package com.example.every_server.entity;

import com.example.every_server.dto.request.MembershipScheduleDto;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembershipSchedule extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status ;

    public static MembershipSchedule from(MembershipScheduleDto membershipScheduleDto) {
        MembershipSchedule membershipSchedule = MembershipSchedule.builder()
                .title(membershipScheduleDto.getTitle())
                .content(Convert.ToJson(membershipScheduleDto.getContent()))
                .status(membershipScheduleDto.getStatus())
                .build();

        membershipSchedule.language = membershipScheduleDto.getLanguage();

        return membershipSchedule;
    }
}

