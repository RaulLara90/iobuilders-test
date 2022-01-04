package com.iobuilder.bank.domain.wallet.mapper;

import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletDto toDto(Wallet wallet){
        WalletDto walletDto = new WalletDto();
        BeanUtils.copyProperties(wallet,walletDto);
        return walletDto;
    }

    public Wallet toDomain(WalletDto walletDto){
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(walletDto,wallet);
        return wallet;
    }
}