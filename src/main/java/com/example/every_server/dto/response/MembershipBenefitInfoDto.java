package com.example.every_server.dto.response;

import com.example.every_server.dto.request.MembershipBenefitDto;
import com.example.every_server.entity.MembershipBenefit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipBenefitInfoDto {
    private String title;
    private String img;
    private String content;

    public static MembershipBenefitInfoDto from(MembershipBenefit membershipBenefit) {
        return MembershipBenefitInfoDto.builder()
                .title(membershipBenefit.getTitle())
                .content(membershipBenefit.getContent())
                .img(membershipBenefit.getImg())
                .build();
    }
}
