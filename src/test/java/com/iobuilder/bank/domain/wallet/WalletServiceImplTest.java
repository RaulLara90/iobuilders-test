package com.iobuilder.bank.domain.wallet;

import com.iobuilder.bank.domain.wallet.mapper.WalletEntityMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletEntity;
import com.iobuilder.bank.domain.wallet.service.impl.WalletServiceImpl;
import com.iobuilder.bank.infrastructure.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class WalletServiceImplTest {

    @InjectMocks
    private WalletServiceImpl walletService;
    @Mock
    private WalletRepository walletRepository;
    @Mock
    private WalletEntityMapper walletEntityMapper;
    @Mock
    private Wallet wallet;
    @Mock
    private WalletEntity walletEntity;

    private final String STR = "STR";
    private final UUID ID = UUID.randomUUID();

    @Test
    public void createWallet() {
        when(walletEntityMapper.toDomain(any())).thenReturn(wallet);
        when(walletEntityMapper.toEntity(any())).thenReturn(walletEntity);
        when(walletRepository.save(any())).thenReturn(walletEntity);
        Wallet res = walletService.createWallet(wallet);
        assertNotNull(res);
    }

    @Test
    public void getWallet() {
        when(walletEntityMapper.toDomain(any())).thenReturn(wallet);
        when(walletRepository.findById(any())).thenReturn(Optional.of(walletEntity));
        Wallet res = walletService.getWallet(ID);
        assertNotNull(res);
    }

    @Test
    public void getWalletByAccount() {
        when(walletEntityMapper.toDomain(any())).thenReturn(wallet);
        when(walletRepository.findByAccountNumber(any())).thenReturn(walletEntity);
        Wallet res = walletService.getWalletByAccount(STR);
        assertNotNull(res);
    }

    @Test
    public void getBalance() {
        when(walletEntity.getBalance()).thenReturn(BigDecimal.TEN);
        when(walletRepository.findById(any())).thenReturn(Optional.of(walletEntity));
        BigDecimal res = walletService.getBalance(ID);
        assertNotNull(res);
    }

    @Test
    public void deposit() {
        when(walletEntityMapper.toDomain(any())).thenReturn(wallet);
        when(walletEntity.getBalance()).thenReturn(BigDecimal.TEN);
        when(walletRepository.findById(any())).thenReturn(Optional.of(walletEntity));
        when(walletRepository.save(any())).thenReturn(walletEntity);
        Wallet res = walletService.deposit(ID, BigDecimal.ONE);
        assertNotNull(res);
    }


    @Test
    public void save() {
        when(walletEntityMapper.toEntity(any())).thenReturn(walletEntity);
        when(walletEntityMapper.toDomain(any())).thenReturn(wallet);
        when(walletRepository.save(any())).thenReturn(walletEntity);
        Wallet res = walletService.save(wallet);
        assertNotNull(res);
    }

}