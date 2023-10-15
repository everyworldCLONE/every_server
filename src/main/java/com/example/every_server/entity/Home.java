package com.example.every_server.entity;

import com.example.every_server.dto.request.HomeContentDto;
import com.example.every_server.global.common.Convert;
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
public class Home extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id", nullable = false)
    private Long homeId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "img")
    private String img;

    public static Home from(HomeContentDto homeContentDto){
        String title = Convert.ToJson(homeContentDto.getTitle());
        String content = Convert.ToJson(homeContentDto.getContent());
        String img = Convert.ToJson(homeContentDto.getImg());
        Home home = Home.builder().title(title).content(content).img(img).build();
        home.language = homeContentDto.getLanguage();
        return home;
    }
}
