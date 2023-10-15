package com.example.every_server.entity;

import com.example.every_server.dto.request.MusicDto;
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
public class Music extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id", nullable = false)
    private Long musicId;

    @Column
    private String musicTitle;

    @Column
    private String musicContent;

    @Column
    private String musicUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    public static Music from(MusicDto musicDto, int idx, Album album) {
        Music music = Music.builder()
                .musicTitle(musicDto.getMusicTitle().get(idx))
                .musicContent(musicDto.getMusicContent().get(idx))
                .musicUrl(musicDto.getMusicUrl().get(idx))
                .album(album)
                .build();

        music.language = musicDto.getLanguage();
        return music;
    }
}
