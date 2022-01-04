package com.iobuilder.bank.application;

import com.iobuilder.bank.application.impl.CreateWalletUseCaseImpl;
import com.iobuilder.bank.domain.wallet.mapper.WalletMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CreateWalletUseCaseImplTest {

    @InjectMocks
    private CreateWalletUseCaseImpl createWalletUseCase;
    @Mock
    private WalletService walletService;
    @Mock
    private WalletMapper walletMapper;
    @Mock
    private Wallet wallet;
    @Mock
    private WalletDto walletDto;

    @Test
    public void transfer() {
        when(walletMapper.toDto(any())).thenReturn(walletDto);
        when(walletMapper.toDomain(any())).thenReturn(wallet);
        when(walletService.createWallet(any())).thenReturn(wallet);
        WalletDto res = createWalletUseCase.createWallet(walletDto);
        assertNotNull(res);
    }

}