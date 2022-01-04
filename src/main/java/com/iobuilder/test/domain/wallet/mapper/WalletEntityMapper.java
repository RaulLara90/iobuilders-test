package com.iobuilder.test.domain.wallet.mapper;

import com.iobuilder.test.domain.wallet.model.Wallet;
import com.iobuilder.test.domain.wallet.model.WalletEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class WalletEntityMapper {

 public Wallet toDomain(WalletEntity walletEntity){
   Wallet wallet = new Wallet();
   BeanUtils.copyProperties(walletEntity,wallet);
   return wallet;
 }

  public WalletEntity toEntity(Wallet wallet){
   WalletEntity walletEntity = new WalletEntity();
   BeanUtils.copyProperties(wallet,walletEntity);
    return walletEntity;
  }
}