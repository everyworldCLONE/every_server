package com.example.every_server.dto.response;

import com.example.every_server.entity.Home;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeContentListDto {
    private List<String> title;
    private List<String> img;
    private List<String> content;

    public static HomeContentListDto from(Home home){
        return HomeContentListDto.builder()
                .title(Convert.ToList(home.getTitle()))
                .content(Convert.ToList(home.getContent()))
                .img(Convert.ToList(home.getImg()))
                .build();
    }
}
