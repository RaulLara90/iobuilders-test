package com.iobuilder.bank.domain.wallet;

import com.iobuilder.bank.domain.wallet.mapper.WalletEntityMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class WalletEntityMapperTest {

    @InjectMocks
    private WalletEntityMapper walletEntityMapper;
    private WalletEntity walletEntity;
    private Wallet wallet;

    @BeforeEach
    public void init() {

        String STR = "STR";
        UUID ID = UUID.randomUUID();
        wallet = new Wallet();
        wallet.setAccountNumber(STR);
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setId(ID);
        wallet.setOwnerId(ID);
        walletEntity = new WalletEntity();
        walletEntity.setAccountNumber(STR);
        walletEntity.setBalance(BigDecimal.ZERO);
        walletEntity.setId(ID);
        walletEntity.setOwnerId(ID);
    }

    @Test
    public void toDomain() {
        Wallet wallet = walletEntityMapper.toDomain(walletEntity);
        assertNotNull(wallet);
        assertEquals(wallet.getAccountNumber(), walletEntity.getAccountNumber());
        assertEquals(wallet.getBalance(), walletEntity.getBalance());
        assertEquals(wallet.getId(), walletEntity.getId());
        assertEquals(wallet.getOwnerId(), walletEntity.getOwnerId());
    }

    @Test
    public void toEntity() {
        WalletEntity walletEntity = walletEntityMapper.toEntity(wallet);
        assertNotNull(wallet);
        assertEquals(wallet.getAccountNumber(), walletEntity.getAccountNumber());
        assertEquals(wallet.getBalance(), walletEntity.getBalance());
        assertEquals(wallet.getId(), walletEntity.getId());
        assertEquals(wallet.getOwnerId(), walletEntity.getOwnerId());
    }
}
