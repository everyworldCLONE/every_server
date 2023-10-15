package com.example.every_server.repository;

import com.example.every_server.entity.Nft;
import com.example.every_server.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NftRepository extends JpaRepository<Nft,Long>{
    List<Nft> findAllByWallet(Wallet wallet);
}
