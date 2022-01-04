package com.iobuilder.bank.domain.movement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Movements")
public class MovementEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name = "wallet_id")
    private UUID walletId;
    @Column(name = "origin_account")
    private String originAccount;
    @Column(name = "destination_account")
    private String destinationAccount;
    private String concept;
    private String type;
    private BigDecimal amount;
    @Column(name = "operation_date")
    private LocalDate operationDate;
}
