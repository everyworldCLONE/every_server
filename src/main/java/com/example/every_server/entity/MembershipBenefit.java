package com.example.every_server.entity;

import com.example.every_server.dto.request.MembershipBenefitDto;
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
public class MembershipBenefit extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "benefit_id", nullable = false)
    private Long benefitId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "img")
    private String img;

    public static MembershipBenefit from(MembershipBenefitDto membershipBenefitDto) {
        MembershipBenefit membershipBenefit = MembershipBenefit.builder()
                .title(membershipBenefitDto.getTitle())
                .content(membershipBenefitDto.getContent())
                .img(membershipBenefitDto.getImg())
                .build();

        membershipBenefit.language = membershipBenefitDto.getLanguage();

        return membershipBenefit;
    }
}

