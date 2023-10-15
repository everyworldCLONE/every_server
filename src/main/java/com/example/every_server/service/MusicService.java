package com.example.every_server.service;

import com.example.every_server.dto.request.MusicDto;
import com.example.every_server.dto.response.AlbumInfoDto;
import com.example.every_server.dto.response.AlbumListDto;
import com.example.every_server.entity.Album;
import com.example.every_server.entity.AlbumIntroduce;
import com.example.every_server.entity.Music;
import com.example.every_server.global.common.Convert;
import com.example.every_server.repository.AlbumIntroduceRepository;
import com.example.every_server.repository.AlbumRepository;
import com.example.every_server.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MusicService {

    private final AlbumRepository albumRepository;
    private final AlbumIntroduceRepository albumIntroduceRepository;
    private final MusicRepository musicRepository;

    @Transactional
    public void createContent(MusicDto musicDto) {

        Album album = albumRepository.findByTitle(Convert.ToJson(musicDto.getTitle())).orElseGet(()->albumRepository.save(Album.from(musicDto)));

        List<Music> list = new ArrayList<>();
        for (int i = 0; i < musicDto.getMusicTitle().size(); i++) {
            list.add(Music.from(musicDto,i,album));
        }

        musicRepository.saveAll(list);
        albumIntroduceRepository.save(AlbumIntroduce.from(musicDto,album));
    }

    public List<AlbumListDto> getAlbumList() {
        return albumRepository.findAll().stream().map(AlbumListDto::from).collect(Collectors.toList());
    }

    public AlbumInfoDto getAlbumInfo(Long albumId, String language) {
        Album album = albumRepository.findByAlbumId(albumId).orElseThrow();
        AlbumIntroduce albumIntroduce = albumIntroduceRepository.findByAlbumAndLanguage(album,language);
        List<Music> musicList = musicRepository.findAllByAlbumAndLanguage(album,language);
        return AlbumInfoDto.from(album,albumIntroduce,musicList);
    }
}
