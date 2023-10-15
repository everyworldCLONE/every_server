package com.example.every_server.controller;


import com.example.every_server.dto.request.WalletDto;
import com.example.every_server.dto.response.ResponseDto;
import com.example.every_server.dto.response.WalletInfoDto;
import com.example.every_server.service.WalletService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
@Api(tags = "wallet 페이지")
public class WalletController {

    private final WalletService walletService;
//    @Autowired
//    @Qualifier("jasyptStringEncryptor")
//    StringEncryptor stringEncryptor;

    @PostMapping()
    public ResponseDto<WalletInfoDto> createWallet(@RequestBody WalletDto walletDto) {
        return walletService.createWallet(walletDto);
    }

}
