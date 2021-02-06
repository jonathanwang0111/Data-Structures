import java.util.*;

public class CoordinateGraph {

    public class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void printPoint() {
            System.out.println("(" + x + ", " + y + ")");
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public float slopeTo(Point b) {
            float deltaX = b.getX() - this.x;
            float deltaY = b.getY() - this.y;
            if (deltaX == 0) {
                return 100000000;
            }
            return deltaY / deltaX;
        }

        public float intercept(float slope) {
            return this.y - this.x * slope;
        }
    }

    private Point[] pointList;
    private int count;
    public CoordinateGraph() {
        this.pointList = new Point[100];
        this.count = 0;
    }

    public Point addPoint(int x, int y) {
        Point p = new Point(x, y);
        this.pointList[this.count] = p;
        this.count++;
        return p;
    }

    public void printPoints() {
        for (int i = 0; i < this.count; i++) {
            this.pointList[i].printPoint();
        }
    }

    public void findBestLine() {
        float bestLineSlope = 0;
        float bestLineInter = 0;
        int majority = 0;
        for (int i = 0; i < this.count - 2; i++) {
            Point a = this.pointList[i];
            for (int j = i + 1; j < this.count - 1; j++) {
                Point b = this.pointList[j];
                float slope = a.slopeTo(b);
                float intercept = a.intercept(slope);
                int count = 0;
                for (int k = j + 1; k < this.count; k++) {
                    Point c = this.pointList[k];
                    float cslope = c.slopeTo(b);
                    float cinter = c.intercept(cslope);
                    if (cslope == slope && cinter == intercept) {
                        count++;
                    }
                }
                if (count > majority) {
                    majority = count;
                    bestLineSlope = slope;
                    bestLineInter = intercept;
                }
            }
        }
        System.out.println("Best Line: m = " + bestLineSlope + ", b = " + bestLineInter);
    }
    public static void main(String[] args) {
        CoordinateGraph g = new CoordinateGraph();
        g.addPoint(1, 1);
        g.addPoint(2, 1);
        g.addPoint(2, 2);
        g.addPoint(3, 3);
        g.addPoint(5, 11);
        g.addPoint(2, 5);
        g.addPoint(3, 7);
        g.addPoint(1, 3);
        g.addPoint(0, 1);
        g.findBestLine();
    }
}