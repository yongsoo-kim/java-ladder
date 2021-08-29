package nextstep.ladder.domain;

import nextstep.ladder.strategy.DrawLineStrategy;

public class LadderColumn {

    private final boolean hasVerticalLine;

    public LadderColumn(boolean hasVerticalLine) {
        this.hasVerticalLine = hasVerticalLine;
    }

    public LadderColumn() {
        this(false);
    }

    public static LadderColumn drawLine(DrawLineStrategy strategy) {
        return new LadderColumn(strategy.drawLine());
    }

    public boolean value() {
        return hasVerticalLine;
    }
}
