package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private Participants defaultParticipants = Participants.of(List.of("pobi", "honux", "crong", "jk"));
    private LadderPrizes defaultLadderPrizes = LadderPrizes.of(List.of("꽝", "5000", "꽝", "3000"));

    @DisplayName("높이만큼 HorizonLine 을 가진다.")
    @Test
    public void hasHorizonLineTest() {
        Ladder ladder = new Ladder(LadderHeight.of(5), defaultParticipants, defaultLadderPrizes);

        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @DisplayName("최소 높이 보다 작은 높이가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    public void createLessThanMinHeight() {
        assertThatThrownBy(() -> {
            Ladder ladder = new Ladder(LadderHeight.of(1), defaultParticipants, defaultLadderPrizes);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 참여 사용자 수 보다 작은 사용자 수가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    public void createLessThanMinStratPositon() {
        Participants participants = Participants.of(List.of("pobi"));
        LadderPrizes ladderPrizes = LadderPrizes.of(List.of("꽝"));

        assertThatThrownBy(() -> {
            Ladder ladder = new Ladder(LadderHeight.of(3), participants, ladderPrizes);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가로라인의 짧은 라인(ShortLine)는 (입렫된 사용자의 수 - 1) 개까지 만든다.")
    @Test
    public void createShortLineInHorizonLine() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes);

        assertThat(ladder.getShortLineCountInHorizonLine(0)).isEqualTo(3);
        assertThat(ladder.getShortLineCountInHorizonLine(1)).isEqualTo(3);
        assertThat(ladder.getShortLineCountInHorizonLine(2)).isEqualTo(3);
    }

    @DisplayName("입력되는 Horizon Line 높이와 사다리 시작점에서 오른쪽에 ShortLine 의 유무를 알 수 있다.")
    @Test
    public void isEnabledShortLineOfRightTest() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes, () -> true);

        assertThat(ladder.isEnabledShortLineOfRight(0, 0)).isTrue();
        assertThat(ladder.isEnabledShortLineOfRight(1, 1)).isFalse();
    }

    @DisplayName("입력되는 Horizon Line 높이와 사다리 시작점에서 왼쪽에 ShortLine 의 유무를 알 수 있다.")
    @Test
    public void isEnabledShortLineOfLeftTest() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes, () -> true);

        assertThat(ladder.isEnabledShortLineOfLeft(0, 0)).isFalse();
        assertThat(ladder.isEnabledShortLineOfLeft(1, 1)).isTrue();
    }

    @DisplayName("게임을 진행하고 최종 사다리 위치 index 를 리턴한다.")
    @Test
    public void playTest() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes, () -> true);

        assertThat(ladder.play(3)).isEqualTo(2);
    }

    @DisplayName("모든 startPosition에 대해서 게임을 진행하고 사다리 위치 index 들을 리턴한다.")
    @Test
    public void playTestAll() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes, () -> true);

        List<Integer> result = ladder.playAll();

        assertThat(result).containsSequence(1, 0, 3, 2);
    }

    @DisplayName("사용자의 수와 Prizes의 수가 다르면 IllegalArgument 예외가 발생한다.")
    @Test
    public void countSameParticipantsAndPrizesTest() {
        LadderPrizes ladderPrizes = LadderPrizes.of(List.of("꽝"));

        assertThatThrownBy(() -> {
            new Ladder(LadderHeight.of(3), defaultParticipants, ladderPrizes);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
