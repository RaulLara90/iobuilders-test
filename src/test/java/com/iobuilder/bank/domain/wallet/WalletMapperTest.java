package com.iobuilder.bank.domain.wallet;

import com.iobuilder.bank.domain.wallet.mapper.WalletMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
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
public class WalletMapperTest {

    @InjectMocks
    private WalletMapper walletMapper;
    private WalletDto walletDto;
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
        walletDto = new WalletDto();
        walletDto.setAccountNumber(STR);
        walletDto.setBalance(BigDecimal.ZERO);
        walletDto.setId(ID);
        walletDto.setOwnerId(ID);
    }

    @Test
    public void toDomain() {
        Wallet wallet = walletMapper.toDomain(walletDto);
        assertNotNull(wallet);
        assertEquals(wallet.getAccountNumber(), walletDto.getAccountNumber());
        assertEquals(wallet.getBalance(), walletDto.getBalance());
        assertEquals(wallet.getId(), walletDto.getId());
        assertEquals(wallet.getOwnerId(), walletDto.getOwnerId());
    }

    @Test
    public void toDto() {
        WalletDto walletDto = walletMapper.toDto(wallet);
        assertNotNull(walletDto);
        assertEquals(wallet.getAccountNumber(), walletDto.getAccountNumber());
        assertEquals(wallet.getBalance(), walletDto.getBalance());
        assertEquals(wallet.getId(), walletDto.getId());
        assertEquals(wallet.getOwnerId(), walletDto.getOwnerId());
    }
}
