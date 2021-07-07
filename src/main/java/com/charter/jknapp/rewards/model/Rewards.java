package com.charter.jknapp.rewards.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rewards {

    private long transactionId;

    private long customerId;

    private long singlePoints;

    private long doublePoints;

    public long getTotalPoints() {
        return singlePoints + doublePoints;
    }

}
