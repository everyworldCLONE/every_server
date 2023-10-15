package com.example.every_server.dto.response;

import com.example.every_server.entity.MembershipSchedule;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipScheduleInfoDto {
    private String title;
    private List<String> content;
    private String status;


    public static MembershipScheduleInfoDto from(MembershipSchedule membershipSchedule) {
        return MembershipScheduleInfoDto.builder()
                .title(membershipSchedule.getTitle())
                .content(Convert.ToList(membershipSchedule.getContent()))
                .status(membershipSchedule.getStatus())
                .build();
    }
}
