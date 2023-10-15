package com.example.every_server.repository;

import com.example.every_server.entity.Album;
import com.example.every_server.entity.AlbumIntroduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumIntroduceRepository extends JpaRepository<AlbumIntroduce,Long>{
    AlbumIntroduce findByAlbumAndLanguage(Album album,String language);
}
