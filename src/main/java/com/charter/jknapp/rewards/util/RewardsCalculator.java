package com.charter.jknapp.rewards.util;

import com.charter.jknapp.rewards.model.Rewards;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RewardsCalculator {

    public static Rewards calculate(BigDecimal transactionAmount,
                                    BigDecimal singlePointsThreshold,
                                    BigDecimal doublePointsThreshold) {

        Rewards rewards = Rewards.builder().build();

        BigDecimal doublePointsAmount = zeroify(transactionAmount.subtract(doublePointsThreshold));
        rewards.setDoublePoints(doublePointsAmount.setScale(0, RoundingMode.HALF_UP).longValue() * 2);

        BigDecimal singlePointsRemainder = zeroify(transactionAmount.
                subtract(doublePointsAmount).
                subtract(singlePointsThreshold));

        rewards.setSinglePoints(singlePointsRemainder.setScale(0, RoundingMode.HALF_UP).longValue());

        return rewards;

    }

    private static BigDecimal zeroify(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        } else {
            return amount;
        }
    }

}
