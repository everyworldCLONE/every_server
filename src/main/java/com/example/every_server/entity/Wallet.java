package com.example.every_server.entity;

import com.example.every_server.dto.request.WalletDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id", nullable = false)
    private Long walletId;

    @Column
    private String name;

    @Column
    private Long money;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nft> nftList;

    public static Wallet from(WalletDto walletDto){
        return Wallet.builder()
                .name(walletDto.getWalletName())
                .money(0L)
                .build();
    }
}
