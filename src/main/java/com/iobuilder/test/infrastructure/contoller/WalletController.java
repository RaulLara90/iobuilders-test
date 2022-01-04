package com.iobuilder.test.infrastructure.contoller;

import com.iobuilder.test.infrastructure.dto.AmountDto;
import com.iobuilder.test.infrastructure.dto.TransferDto;
import com.iobuilder.test.domain.wallet.model.WalletDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;


@RequestMapping("/wallets")
public interface WalletController {

    @ApiOperation(value = "Creation of a wallet", notes = "", response = WalletDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = WalletDto.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<WalletDto> createWallet(@RequestBody WalletDto walletDto);

    @ApiOperation(value = "Wallet Status", response = WalletDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = WalletDto.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})
    @PostMapping(value = "/{walletId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<WalletDto> getWallet(@PathVariable UUID walletId);

    @ApiOperation(value = "Deposit", notes = "", response = WalletDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = WalletDto.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})
    @PostMapping(value = "{walletId}/deposit",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<WalletDto> deposit(@PathVariable UUID walletId, @RequestBody AmountDto amountDto);

    @ApiOperation(value = "Transfer", notes = "", response = TransferDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TransferDto.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})
    @PostMapping(value = "{walletId}/transfer",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<WalletDto> transfer(@PathVariable UUID walletId, @RequestBody TransferDto transferDto);
}
