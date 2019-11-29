package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private List<Point> points;

    public LadderLine(int pointSize) {
        this.points = createPoints(pointSize);
    }

    private List<Point> createPoints(int spotSize) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = initFirst(points);
        initNext(points, firstPoint, spotSize);
        initLast(points);

        return points;
    }

    private Point initFirst(List<Point> points) {
        Point point = Point.ofFirst(createBoolean());
        points.add(point);
        return point;
    }

    private void initNext(List<Point> points, Point point, int spotSize) {
        for (int i = 1; i < spotSize; i++) {
            point = point.createNext(createBoolean());
            points.add(point);
        }
    }

    private void initLast(List<Point> points) {
        points.get(points.size() - 1).changeToLastPoint();
    }

    private boolean createBoolean() {
        return new Random().nextInt(2) == 0;
    }

    public int move(int current) {
        return points.get(current).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
    }
}