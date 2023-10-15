package com.example.every_server.dto.response;

import com.example.every_server.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletInfoDto {
    private String walletName;
    private List<NftDto> nftList;
    private boolean nftExist;

    public static WalletInfoDto from(Wallet wallet,List<NftDto> nftList) {
        return WalletInfoDto.builder()
                .walletName(wallet.getName())
                .nftList(nftList)
                .nftExist(nftList.size() != 0)
                .build();
    }
}
