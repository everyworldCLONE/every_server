package com.example.every_server.controller;

import com.example.every_server.dto.request.MembershipBenefitDto;
import com.example.every_server.dto.request.MembershipDto;
import com.example.every_server.dto.request.MembershipScheduleDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.service.MembershipService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/membership")
@Api(tags = "membership 페이지")
public class MembershipController {

    private final MembershipService membershipService;

    @PostMapping("/content")
    public String createContent(@RequestBody MembershipDto membershipDto) {
        membershipService.createContent(membershipDto);
        return "membershipDto 컨텐츠 작성 성공";
    }

    @PostMapping("/schedule")
    public String createSchedule(@RequestBody MembershipScheduleDto membershipScheduleDto) {
        membershipService.createSchedule(membershipScheduleDto);
        return "Schedule 컨텐츠 작성 성공";
    }

    @PostMapping("/benefit")
    public String createBenefit(@RequestBody MembershipBenefitDto membershipBenefitDto) {
        membershipService.createBenefit(membershipBenefitDto);
        return "Benefit 컨텐츠 작성 성공";
    }

    @GetMapping("/content")
    public ResponseDto<?> getContentList(@RequestParam(required = false, defaultValue = "kr") String language){
        return membershipService.getContentList(language);
    }

    @GetMapping("/schedule")
    public ResponseDto<?> getScheduleList(@RequestParam(required = false, defaultValue = "kr") String language){
        return membershipService.getScheduleList(language);
    }

    @GetMapping("/benefit")
    public ResponseDto<?> getBenefitList(@RequestParam(required = false, defaultValue = "kr") String language){
        return membershipService.getBenefitList(language);
    }
}
