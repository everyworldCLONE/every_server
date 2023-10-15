package com.example.every_server.dto.response;

import com.example.every_server.entity.Album;
import com.example.every_server.entity.AlbumIntroduce;
import com.example.every_server.entity.Music;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumInfoDto {
    private List<String> title;
    private String img;
    private boolean introduceCheck;
    private AlbumIntroduceDto introduce;
    private List<List<String>> musicList;

    public static AlbumInfoDto from(Album album, AlbumIntroduce albumIntroduce, List<Music> musicList) {
        boolean check = albumIntroduce.getTitle().equals("") && albumIntroduce.getContent().equals("") && albumIntroduce.getImg().equals("");
        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < musicList.size(); i++) {
            List<String> tempList = new ArrayList<>();

            tempList.add(i+1+"");
            tempList.add(musicList.get(i).getMusicTitle());
            tempList.add(musicList.get(i).getMusicContent());
            tempList.add(musicList.get(i).getMusicUrl());

            list.add(tempList);
        }

        return AlbumInfoDto.builder()
                .title(Convert.ToList(album.getTitle()))
                .img(album.getImg())
                .introduceCheck(!check)
                .introduce(AlbumIntroduceDto.from(albumIntroduce))
                .musicList(list)
                .build();
    }
}
