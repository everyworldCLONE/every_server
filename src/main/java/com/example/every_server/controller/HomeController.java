package com.example.every_server.controller;


import com.example.every_server.dto.request.HomeContentDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.service.HomeService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/home")
@Api(tags = "home 페이지")
public class HomeController {

    private final HomeService homeService;

    @PostMapping()
    public String createContent(@RequestBody HomeContentDto homeContentDto) {
        homeService.createContent(homeContentDto);
        return "컨텐츠 작성 성공";
    }

    @GetMapping()
    public ResponseDto<?> getContentList(@RequestParam(required = false, defaultValue = "kr") String language){
        return homeService.getContentList(language);
    }
}
