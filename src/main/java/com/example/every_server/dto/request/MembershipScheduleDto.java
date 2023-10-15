package com.example.every_server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipScheduleDto {
    private String title;
    private List<String> content;
    private String status;
    private String language;

}
