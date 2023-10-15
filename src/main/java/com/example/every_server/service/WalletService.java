package com.example.every_server.service;

import com.example.every_server.dto.request.WalletDto;
import com.example.every_server.dto.response.NftDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.dto.response.WalletInfoDto;
import com.example.every_server.entity.Nft;
import com.example.every_server.entity.Wallet;
import com.example.every_server.repository.NftRepository;
import com.example.every_server.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WalletService {

   private final WalletRepository walletRepository;

   private final NftRepository nftRepository;

    public ResponseDto<WalletInfoDto> createWallet(WalletDto walletDto) {
        Wallet wallet = walletRepository.findByName(walletDto.getWalletName()).orElseGet(()->walletRepository.save(Wallet.from(walletDto)));

        List<Nft> Nftlist = nftRepository.findAllByWallet(wallet);

        List<NftDto> list = Nftlist.stream().map(NftDto::from).collect(Collectors.toList());

        return ResponseDto.success(WalletInfoDto.from(wallet,list));
    }
}
