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
public class MusicDto {
    private List<String> title;
    private String img;
    private String albumIntroduceTile;
    private String albumIntroduceContent;
    private String albumIntroduceImg;
    private List<String> musicTitle;
    private List<String> musicContent;
    private List<String> musicUrl;
    private String language;
}
