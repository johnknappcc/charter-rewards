package com.charter.jknapp.rewards.controller;

import com.charter.jknapp.rewards.model.Rewards;
import com.charter.jknapp.rewards.model.Transaction;
import com.charter.jknapp.rewards.service.RewardsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class RewardsController {

    private RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @PostMapping("/rewards")
    public ResponseEntity<Rewards> getRewards(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(rewardsService.calculate(transaction));
    }

}
