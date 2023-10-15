package com.example.every_server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipBenefitDto {
    private String title;
    private String img;
    private String content;
    private String language;
}
