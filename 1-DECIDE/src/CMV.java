package src;

public class CMV {
    private int NUMPOINTS;
    private Point[] points;
    private Parameters parameters;
    private static double PI = Math.PI;
    // add a cmv boolean array of length 15
    private boolean[] cmvArr;
    

    public CMV(int NUMPOINTS, Point[] points, Parameters parameters) {
        if (NUMPOINTS != points.length)
            throw new IllegalArgumentException("NUMPOINTS has to be equal to the length of points");
        
        this.NUMPOINTS = NUMPOINTS;
        this.points = points;
        this.parameters = parameters;
        this.cmvArr = new boolean[15];
    }

    public boolean[] getCMV(){
        cmvArr[0] = lic0();
        cmvArr[1] = lic1();
        cmvArr[2] = lic2();
        cmvArr[3] = lic3();
        cmvArr[4] = lic4();
        cmvArr[5] = lic5();
        cmvArr[6] = lic6();
        cmvArr[7] = lic7();
        cmvArr[8] = lic8();
        cmvArr[9] = lic9();
        cmvArr[10] = lic10();
        cmvArr[11] = lic11();
        cmvArr[12] = lic12();
        cmvArr[13] = lic13();
        cmvArr[14] = lic14();

        return cmvArr;
    }

    public boolean lic0() {
        if (parameters.LENGTH1 < 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        for (int index = 0; index < NUMPOINTS - 1; index++) {
            double currX = points[index].getX();
            double currY = points[index].getY();
            double nextX = points[index + 1].getX();
            double nextY = points[index + 1].getY();
            
            double distance = Math.sqrt(Math.pow((nextX - currX), 2) + Math.pow((nextY - currY), 2));
            if (distance > parameters.LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public boolean lic1() {
        if (parameters.RADIUS1 < 0)
            throw new IllegalArgumentException("Radius must be greater than 0");

        for (int i = 0; i < NUMPOINTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];

            if (inACircle(p1, p2, p3, parameters.RADIUS1)) {
                return true;
            }
        }
        return false;
    }

    // function that checks if there exists a set of 3 consecutive points that form
    // an angle
    public boolean lic2() {
        if (parameters.EPSILON < 0 || parameters.EPSILON >= PI) {
            throw new IllegalArgumentException("EPSILON must be in the range [0, PI)");
        }

        for (int i = 0; i < NUMPOINTS - 2; i++) {

            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];
            if (!(p1.getX() == p2.getX() && p1.getY() == p2.getY())
                    & !(p2.getX() == p3.getX() && p2.getY() == p3.getY())) { // check if points are not the same as p2
                double angle = calcAngle(p1, p2, p3); // angle in radians
                if (angle < (PI - parameters.EPSILON) || angle > (PI + parameters.EPSILON)) { // check if angle is
                                                                                              // within range
                    return true;
                }
            }
        }
        return false;
    }

    // function that checks if there exists a set of 3 consecutive points that are
    // in the area of a traingle of area
    public boolean lic3() {
        if (parameters.AREA1 < 0) {
            throw new IllegalArgumentException("Area must be greater than 0");
        }
        for (int i = 0; i < NUMPOINTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];
            double add = p1.getX() * p2.getY() + p2.getX() * p3.getY() + p3.getX() * p1.getY();
            double sub = p1.getX() * p3.getY() + p2.getX() * p1.getY() + p3.getX() * p2.getY();

            double area = Math.abs(add - sub) * 0.5; // area of triangle

            if (area <= parameters.AREA1) {
                return true;
            }
        }
        return false;
    }

    // function that checks if there exists a set of Q PTS consecutive points that
    // lie in more than QUADS quadrants
    public boolean lic4() {
        if (parameters.QUADS < 1 || parameters.QUADS > 3) {
            throw new IllegalArgumentException("QUADS must be in the range [1, 3]");
        } else if (parameters.Q_PTS < 2 || parameters.Q_PTS > NUMPOINTS) {
            throw new IllegalArgumentException("Q_PTS must be in the range [2, NUMPOINTS]");
        }

        for (int i = 0; i < NUMPOINTS - parameters.Q_PTS + 1; i++) {
            int[] quad = new int[4];
            for (int j = i; j < i + parameters.Q_PTS; j++) {
                int q = getQuad(points[j]);
                quad[q] = 1; // set quadrant to 1 if point is in quadrant
            }
            int sum = 0;
            for (int k = 0; k < 4; k++) {
                sum += quad[k];
            }
            if (sum > parameters.QUADS) {
                return true;
            }
        }
        return false;

    }

    //
    public boolean lic5() {
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];

            if (p2.getX() - p1.getX() < 0) {
                return true;
            }
        }
        return false;

    }

    public boolean lic6() {
        if (parameters.DIST < 0) {
            throw new IllegalArgumentException("DIST must be greater than 0");
        } else if (parameters.N_PTS < 3 || parameters.N_PTS > NUMPOINTS) {
            throw new IllegalArgumentException("N_PTS must be in the range [3, NUMPOINTS]");
        }

        if (NUMPOINTS < 3) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - parameters.N_PTS + 1; i++) {
            Point[] pointsConsecutive = new Point[parameters.N_PTS];
            for (int j = i; j < i + parameters.N_PTS; j++) {
                pointsConsecutive[j] = points[j];
            }
            // needs to be fixed or checked
            Point first = pointsConsecutive[0];
            Point last = pointsConsecutive[parameters.N_PTS - 1];
            if (first.getX() == last.getX() && first.getY() == last.getY()) {
                double distance = 0;
                for (int k = 1; k < parameters.N_PTS - 1; k++) {
                    distance += Math.sqrt(Math.pow((first.getX() - pointsConsecutive[k].getX()), 2)
                            + Math.pow((first.getY() - pointsConsecutive[k].getY()), 2));
                    if (distance > parameters.DIST) {
                        return true;
                    }
                }
            } else {
                double distance = 0;
                // coeficents A, B,C for line equation ax + by + c = 0
                double a = last.getY() - first.getY();
                double b = first.getX() - last.getX();
                double c = first.getX() * last.getY() - last.getX() * first.getY();
                for (int j = 0; j < parameters.N_PTS - 1; j++) {
                    distance = Math.abs(a * pointsConsecutive[j].getX() + b * pointsConsecutive[j].getY() + c)
                            / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                    if (distance > parameters.DIST) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean lic7() {
        if (parameters.K_PTS > 1 || parameters.K_PTS > NUMPOINTS - 2) {
            throw new IllegalArgumentException("K_PTS must be in the range [1, NUMPOINTS-2]");
        }

        if (NUMPOINTS < 3) {
            return false;
        }
        for (int i = 0; i < NUMPOINTS - parameters.K_PTS - 1; i++) {
            int j = i + parameters.K_PTS + 1;
            double currX = points[i].getX();
            double currY = points[i].getY();
            double nextX = points[j].getX();
            double nextY = points[j].getY();
            double distance = Math.sqrt(Math.pow((nextX - currX), 2) + Math.pow((nextY - currY), 2));
            if (distance <= parameters.LENGTH1) {
                return true;
            }

        }

        return false; // no two points satisfying LIC7 condition
    }

    public boolean lic8() {

        if (parameters.A_PTS < 1)
            throw new IllegalArgumentException("A_PTS must be at least 1");

        if (parameters.B_PTS < 1)
            throw new IllegalArgumentException("B_PTS must be at least 1");

        if (parameters.A_PTS + parameters.B_PTS > (NUMPOINTS - 3))
            throw new IllegalArgumentException("A_PTS + B_PTS must be less than or equal to NUMPOINTS-3");

        if (NUMPOINTS < 5) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - parameters.A_PTS - parameters.B_PTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + parameters.A_PTS + 1];
            Point p3 = points[i + parameters.A_PTS + parameters.B_PTS + 2];

            if (!inACircle(p1, p2, p3, parameters.RADIUS1)) {
                return true;
            }

        }
        return false;
    }

    // helper function that returns the quadrant of a point
    public static int getQuad(Point p1) {
        double x = p1.getX();
        double y = p1.getY();

        if (x >= 0 && y >= 0)
            return 0;
        if (x < 0 && y >= 0)
            return 1;
        if (x <= 0 && y < 0)
            return 2;
        if (x > 0 && y < 0)
            return 3;
        return 0; // Default to quadrant I for points on axes
    }

    public static boolean inACircle(Point p1, Point p2, Point p3, double r) {
        Point center = calcCenter(p1, p2, p3);
        double a = Math.pow((p1.getX() - center.getX()), 2) + Math.pow((p1.getY() - center.getY()), 2);
        double b = Math.pow((p2.getX() - center.getX()), 2) + Math.pow((p2.getY() - center.getY()), 2);
        double c = Math.pow((p3.getX() - center.getX()), 2) + Math.pow((p3.getY() - center.getY()), 2);

        if (a <= r * r && b <= r * r && c <= r * r) {
            return true;
        }
        return false;
    }

    public static Point calcCenter(Point p1, Point p2, Point p3) {
        double A = p1.getX() * p1.getX() + p1.getY() * p1.getY();
        double B = p2.getX() * p2.getX() + p2.getY() * p2.getY();
        double C = p3.getX() * p3.getX() + p3.getY() * p3.getY();

        double aux1 = (A * (p3.getY() - p2.getY()) + B * (p1.getY() - p3.getY()) + C * (p2.getY() - p1.getY()));
        double aux2 = -(A * (p3.getX() - p2.getX()) + B * (p1.getX() - p3.getX()) + C * (p2.getX() - p1.getX()));
        double div = (2 * (p1.getX() * (p3.getY() - p2.getY()) + p2.getX() * (p1.getY() - p3.getY())
                + p3.getX() * (p2.getY() - p1.getY())));

        if (div == 0) {
            return p2; // points are colinear i.e all on same line, return p2 as center
        }

        return new Point(aux1 / div, aux2 / div);

    }

    public boolean lic9() {

        if (parameters.C_PTS < 1)
            throw new IllegalArgumentException("C_PTS must be at least 1");

        if (parameters.D_PTS < 1)
            throw new IllegalArgumentException("D_PTS must be at least 1");

        if (parameters.C_PTS + parameters.D_PTS > (NUMPOINTS - 3))
            throw new IllegalArgumentException("C_PTS + D_PTS must be less than or equal to NUMPOINTS-3");

        if (NUMPOINTS < 5) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - parameters.C_PTS - parameters.D_PTS - 2; i++) {

            Point vertex = points[i + parameters.C_PTS + 1];
            Point p1 = points[i];
            Point p3 = points[i + parameters.C_PTS + parameters.D_PTS + 2];

            double angle = calcAngle(p1, vertex, p3);

            if (angle < (PI - parameters.EPSILON) || angle > (PI + parameters.EPSILON)) {
                return true;
            }

        }

        return false;

    }

    public static double calcAngle(Point p1, Point vertex, Point p3) {
        double angle = Math.atan2(p3.getY() - vertex.getY(), p3.getX() - vertex.getX())
                - Math.atan2(p1.getY() - vertex.getY(), p1.getX() - vertex.getX());
        if (angle < 0) {
            angle += 2 * PI;
        }
        return angle;
    }

    public boolean lic10() {

        if (parameters.E_PTS < 1)
            throw new IllegalArgumentException("E_PTS must be at least 1");
        if (parameters.F_PTS < 1)
            throw new IllegalArgumentException("F_PTS must be at least 1");
        if (parameters.E_PTS + parameters.F_PTS > NUMPOINTS - 3)
            throw new IllegalArgumentException("E_PTS + F_PTS must be less than or equal to NUMPOINTS-3");

        if (NUMPOINTS < 5) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - parameters.E_PTS - parameters.F_PTS - 2; i++) {

            Point p1 = points[i];
            Point p2 = points[i + parameters.E_PTS + 1];
            Point p3 = points[i + parameters.E_PTS + parameters.F_PTS + 2];

            double area = calcArea(p1, p2, p3);

            if (area > parameters.AREA1) {
                return true;
            }

        }

        return false;

    }

    public double calcArea(Point p1, Point p2, Point p3) {
        double area = Math.abs((p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY())
                + p3.getX() * (p1.getY() - p2.getY())) / 2.0);
        return area;
    }

    public boolean lic11() {

        if (parameters.G_PTS < 1 || parameters.G_PTS > NUMPOINTS - 2)
            throw new IllegalArgumentException("G_PTS must be at least 1 and not larger than NUMPOINTS-2");

        if (NUMPOINTS < 3) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - parameters.G_PTS - 1; i++) {

            int p2Index = i + parameters.G_PTS + 1;

            double p1_x = points[i].getX();
            double p2_x = points[p2Index].getX();
            if (p2_x - p1_x < 0) {
                return true;
            }

        }

        return false;

    }

    public boolean lic12() {
        if (parameters.LENGTH2 < 0)
            throw new IllegalArgumentException("Length2 must be larger than 0 ");
        {

        }
        if (NUMPOINTS < 3) {
            return false;
        }
        boolean isGreaterThanLength1 = false;
        boolean isGreaterThanLength2 = false;
        for (int i = 0; i < NUMPOINTS - parameters.K_PTS - 1; i++) {

            int p2Index = i + parameters.K_PTS + 1;
            double distance = Math.sqrt(Math.pow((points[i].getX() - points[p2Index].getX()), 2)
                    + Math.pow((points[i].getY() - points[p2Index].getY()), 2));
            if (distance > parameters.LENGTH1) {
                isGreaterThanLength1 = true;
            }

            if (distance < parameters.LENGTH2) {
                isGreaterThanLength2 = true;
            }

            if (isGreaterThanLength1 && isGreaterThanLength2) {
                return true;
            }

        }

        return false;

    }

    public boolean lic13() {

        if (parameters.RADIUS2 < 0)
            throw new IllegalArgumentException("Radius2 must be larger than 0");

        if (NUMPOINTS < 5) {
            return false;
        }

        boolean isNotInACircleRadius1 = false;
        boolean isInACircleRadius2 = false;

        for (int i = 0; i < NUMPOINTS - parameters.A_PTS - parameters.B_PTS - 1; i++) {

            Point p1 = points[i];
            Point p2 = points[i + parameters.A_PTS + 1];
            Point p3 = points[i + parameters.A_PTS + parameters.B_PTS + 2];

            if (!inACircle(p1, p2, p3, parameters.RADIUS1)) {
                isNotInACircleRadius1 = true;
            }

            if (inACircle(p1, p2, p3, parameters.RADIUS2)) {
                isInACircleRadius2 = true;
            }

            if (isInACircleRadius2 && isNotInACircleRadius1) {
                return true;
            }
        }
        return false;
    }

    public boolean lic14() {
        if (parameters.AREA2 < 0)
            throw new IllegalArgumentException("Area2 must be larger than 0");

        if (NUMPOINTS < 5) {
            return false;
        }

        boolean isLargerThanArea1 = false;
        boolean isLessThanArea2 = false;

        for (int i = 0; i < NUMPOINTS - parameters.E_PTS - parameters.F_PTS - 1; i++) {

            Point p1 = points[i];
            Point p2 = points[i + parameters.E_PTS + 1];
            Point p3 = points[i + parameters.E_PTS + parameters.F_PTS + 2];

            double area = calcArea(p1, p2, p3);

            if (area > parameters.AREA1) {
                isLargerThanArea1 = true;
            }

            if (area < parameters.AREA2) {
                isLessThanArea2 = true;
            }

            if (isLargerThanArea1 && isLessThanArea2) {
                return true;
            }
        }
        return false;
    }

}