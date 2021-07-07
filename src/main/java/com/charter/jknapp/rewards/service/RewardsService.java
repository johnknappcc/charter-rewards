package com.charter.jknapp.rewards.service;

import com.charter.jknapp.rewards.model.Rewards;
import com.charter.jknapp.rewards.model.Transaction;
import com.charter.jknapp.rewards.util.RewardsCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class RewardsService {

    private long monthsWindow;
    private BigDecimal singlePointsThreshold;
    private BigDecimal doublePointsThreshold;

    public RewardsService(@Value("${rewards.monthsWindow}") long monthsWindow,
                          @Value("${rewards.singlePointThreshold}") BigDecimal singlePointThreshold,
                          @Value("${rewards.doublePointThreshold}") BigDecimal doublePointsThreshold) {

        this.monthsWindow = monthsWindow;
        this.singlePointsThreshold = singlePointThreshold;
        this.doublePointsThreshold = doublePointsThreshold;
    }

    public Rewards calculate(Transaction transaction) {
        LocalDate cutoffDate = LocalDate.now().minusMonths(monthsWindow);

        if (transaction.getDate().isAfter(cutoffDate)) {
            Rewards rewards = RewardsCalculator.calculate(transaction.getAmount(),
                    singlePointsThreshold,
                    doublePointsThreshold);
            rewards.setCustomerId(transaction.getCustomerId());
            rewards.setTransactionId(transaction.getId());
            return rewards;
        } else {
            return Rewards.builder()
                    .customerId(transaction.getCustomerId())
                    .transactionId(transaction.getId()).build();
        }
    }

}
