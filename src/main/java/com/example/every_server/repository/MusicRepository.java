package com.example.every_server.repository;

import com.example.every_server.entity.Album;
import com.example.every_server.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long>{
    List<Music> findAllByAlbumAndLanguage(Album album, String language);
}
