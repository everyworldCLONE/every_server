package com.example.every_server.dto.response;

import com.example.every_server.entity.Nft;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NftDto {
    private String name;
    private String nftUrl;

    public static NftDto from(Nft nft){
        return NftDto.builder()
                .name(nft.getName())
                .nftUrl(nft.getUrl())
                .build();
    }
}
