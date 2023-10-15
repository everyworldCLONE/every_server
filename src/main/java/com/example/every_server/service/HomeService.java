package com.example.every_server.service;

import com.example.every_server.dto.request.HomeContentDto;
import com.example.every_server.dto.response.HomeContentListDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.entity.Home;
import com.example.every_server.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;
    public void createContent(HomeContentDto homeContentDto) {
        homeRepository.save(Home.from(homeContentDto));
    }

    @Transactional
    public ResponseDto<?> getContentList(String language) {
        List<Home> list = homeRepository.findAllByLanguage(language);

        List<HomeContentListDto> contentList = list.stream().map(HomeContentListDto::from).collect(Collectors.toList());

        return ResponseDto.success(contentList);
    }
}
