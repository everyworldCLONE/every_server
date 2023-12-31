package com.example.every_server.repository;

import com.example.every_server.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long>{
    Optional<Wallet> findByName(String walletName);
}
