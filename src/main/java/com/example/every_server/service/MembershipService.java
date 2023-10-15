package com.example.every_server.service;

import com.example.every_server.dto.request.MembershipBenefitDto;
import com.example.every_server.dto.request.MembershipDto;
import com.example.every_server.dto.request.MembershipScheduleDto;
import com.example.every_server.dto.response.MembershipBenefitInfoDto;
import com.example.every_server.dto.response.MembershipContentDto;
import com.example.every_server.dto.response.MembershipScheduleInfoDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.entity.Membership;
import com.example.every_server.entity.MembershipBenefit;
import com.example.every_server.entity.MembershipSchedule;
import com.example.every_server.repository.MembershipBenefitRepository;
import com.example.every_server.repository.MembershipRepository;
import com.example.every_server.repository.MembershipScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final MembershipScheduleRepository membershipScheduleRepository;
    private final MembershipBenefitRepository membershipBenefitRepository;


    public void createContent(MembershipDto membershipDto) {
        membershipRepository.save(Membership.from(membershipDto));
    }

    public ResponseDto<?> getContentList(String language) {
        List<Membership> list = membershipRepository.findAllByLanguage(language);

        List<MembershipContentDto> contentList = list.stream().map(MembershipContentDto::from).collect(Collectors.toList());

        return ResponseDto.success(contentList);
    }

    public void createSchedule(MembershipScheduleDto membershipScheduleDto) {
        membershipScheduleRepository.save(MembershipSchedule.from(membershipScheduleDto));
    }

    public ResponseDto<?> getScheduleList(String language) {
        List<MembershipSchedule> list = membershipScheduleRepository.findAllByLanguage(language);

        List<MembershipScheduleInfoDto> contentList = list.stream().map(MembershipScheduleInfoDto::from).collect(Collectors.toList());

        return ResponseDto.success(contentList);
    }

    public void createBenefit(MembershipBenefitDto membershipBenefitDto) {
        membershipBenefitRepository.save(MembershipBenefit.from(membershipBenefitDto));
    }

    public ResponseDto<?> getBenefitList(String language) {
        List<MembershipBenefit> list = membershipBenefitRepository.findAllByLanguage(language);

        List<MembershipBenefitInfoDto> contentList = list.stream().map(MembershipBenefitInfoDto::from).collect(Collectors.toList());

        return ResponseDto.success(contentList);
    }
}
