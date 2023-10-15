package com.example.every_server.controller;


import com.example.every_server.dto.request.MusicDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.service.MusicService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/music")
@Api(tags = "music 페이지")
public class MusicController {

    private final MusicService musicService;

    @PostMapping()
    public String createContent(@RequestBody MusicDto musicDto) {
        musicService.createContent(musicDto);
        return "music 컨텐츠 작성 성공";
    }

    @GetMapping
    public ResponseDto<?> albumList(){
        return ResponseDto.success(musicService.getAlbumList());
    }

    @GetMapping("/{albumId}")
    public ResponseDto<?> getAlbumInfo(@PathVariable Long albumId, @RequestParam(required = false, defaultValue = "kr") String language){
        return ResponseDto.success(musicService.getAlbumInfo(albumId,language));
    }

}
