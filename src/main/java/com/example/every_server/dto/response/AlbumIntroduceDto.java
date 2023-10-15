package com.example.every_server.dto.response;

import com.example.every_server.entity.AlbumIntroduce;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumIntroduceDto {
     private String title;
     private String content;
     private String img;

     public static AlbumIntroduceDto from(AlbumIntroduce albumIntroduce){
         return AlbumIntroduceDto.builder()
                 .title(albumIntroduce.getTitle())
                 .content(albumIntroduce.getContent())
                 .img(albumIntroduce.getImg())
                 .build();
     }
}
