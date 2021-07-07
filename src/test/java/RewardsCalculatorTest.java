import com.charter.jknapp.rewards.model.Rewards;
import com.charter.jknapp.rewards.util.RewardsCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardsCalculatorTest {

    public static final BigDecimal singlePointsThreshold = new BigDecimal("50");

    public static final BigDecimal doublePointsThreshold = new BigDecimal("100");

    private Rewards calcRewards(String amount) {
        return RewardsCalculator.calculate(new BigDecimal(amount),
                singlePointsThreshold,
                doublePointsThreshold);
    }

    @Test
    public void calculate_under50NoRewards() {
        assertEquals(calcRewards("49").getTotalPoints(), 0L);
    }

    @Test
    public void calculate_20RewardsPoints() {
        assertEquals(calcRewards("70").getTotalPoints(), 20L);
    }

    @Test
    public void calculate_50RewardsPoints() {
        assertEquals(calcRewards("100.11").getTotalPoints(), 50L);
    }

    @Test
    public void calculate_90RewardsPoints() {
        assertEquals(calcRewards("120").getTotalPoints(), 90L);
    }

    @Test
    public void calculate_850RewardsPoints() {
        assertEquals(calcRewards("500").getTotalPoints(), 850L);
    }

    @Test
    public void calculateIndividualRewardsPoints() {
        Rewards rewards = calcRewards("120");
        assertEquals(rewards.getSinglePoints(), 50L);
        assertEquals(rewards.getDoublePoints(), 40L);
    }

}
