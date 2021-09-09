package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<String> playerNames;
    private final List<String> prizeNames;
    private final List<LadderStep> ladderSteps;

    private Ladder(LadderDrawingSettings settings) {
        this.playerNames = settings.getPlayerNames();
        this.prizeNames = settings.getPrizeNames();
        this.ladderSteps = createLadderSteps(settings);
    }

    public static Ladder from(LadderDrawingSettings settings) {
        return new Ladder(settings);
    }

    private List<LadderStep> createLadderSteps(LadderDrawingSettings settings) {
        return Stream.generate(() -> new LadderStep(settings))
            .limit(settings.getLadderHeight())
            .collect(Collectors.toUnmodifiableList());
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }
}
