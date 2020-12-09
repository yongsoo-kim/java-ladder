package my.project.dto;

import my.project.domain.Reward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    public static final String DELIMITER = ",";
    public static final int FOR_REMOVE_EMPTY = 2;

    private final List<Reward> rewards;

    public Rewards(String rewards) {
        this.rewards = Arrays.stream(rewards.split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getReward(int ladderArrayIndex) {
        int listIndex = ladderArrayIndex / FOR_REMOVE_EMPTY;
        return rewards.get(listIndex);
    }
}
