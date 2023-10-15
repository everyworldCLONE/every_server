package com.example.every_server.repository;

import com.example.every_server.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>{
    Optional<Album> findByAlbumId(Long albumId);
    Optional<Album> findByTitle(String title);
}
