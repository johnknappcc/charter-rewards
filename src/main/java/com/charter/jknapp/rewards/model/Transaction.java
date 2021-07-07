package com.charter.jknapp.rewards.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Transaction {

    private long id;

    private long customerId;

    private BigDecimal amount;

    private LocalDate date;

}
