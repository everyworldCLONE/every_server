package com.example.every_server.entity;

import com.example.every_server.dto.request.MusicDto;
import com.example.every_server.global.common.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", nullable = false)
    private Long albumId;

    @Column
    private String title;

    @Column
    private String img;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlbumIntroduce> AlbumIntroduce;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Music> music;

    public static Album from(MusicDto musicDto){
        String title = Convert.ToJson(musicDto.getTitle());

        Album album = Album.builder()
                .title(title)
                .img(musicDto.getImg())
                .build();

        album.language = musicDto.getLanguage();
        return album;
    }
}
