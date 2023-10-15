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
public class AlbumIntroduce extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_introduce_id", nullable = false)
    private Long albumIntroduceId;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;


    public static AlbumIntroduce from(MusicDto musicDto, Album album){
        String title = musicDto.getAlbumIntroduceTile() != null ? musicDto.getAlbumIntroduceTile() : "" ;
        String content = musicDto.getAlbumIntroduceContent() != null ? musicDto.getAlbumIntroduceContent() : "" ;
        String img = musicDto.getAlbumIntroduceImg() != null ? musicDto.getAlbumIntroduceImg() : "" ;

        AlbumIntroduce albumIntroduce = AlbumIntroduce.builder()
                .title(title)
                .img(img)
                .content(content)
                .album(album)
                .build();

        albumIntroduce.language = musicDto.getLanguage();
        return albumIntroduce;
    }
}
