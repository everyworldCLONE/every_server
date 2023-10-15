package com.example.every_server.dto.response;

import com.example.every_server.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumListDto {
    private Long id;
    private String img;

    public static AlbumListDto from(Album album){
        return AlbumListDto.builder()
                .id(album.getAlbumId())
                .img(album.getImg())
                .build();
    }
}
