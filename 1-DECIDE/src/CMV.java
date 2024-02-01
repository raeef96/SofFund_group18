package src;


// create a CMV class

public class CMV {
    private int NUMPOINTS;
    private Point[] points;
    private Parameters parameters;
    private static double PI = Math.PI;
    // add a cmv boolean array of length 15
    private boolean[] cmvArr;
    


    // constructor with NUMPOINTS, points, and parameters
 
    public CMV(int NUMPOINTS, Point[] points, Parameters parameters, boolean[] cmvArr) {


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

    // boolean function that checks if condition 0 is met
    public boolean lic0() {
        if (parameters.LENGTH1 < 0) {
            throw new IllegalArgumentException("Length must be greater than 0"); // throw an exception if the length is negative
        }
        // this for gets two consecitive data points
        for (int index = 0; index < NUMPOINTS - 1; index++) {
            double currX = points[index].getX();
            double currY = points[index].getY();
            double nextX = points[index + 1].getX();
            double nextY = points[index + 1].getY();

            // calculate the distance between the data points
            double distance = Math.sqrt(Math.pow((nextX - currX), 2) + Math.pow((nextY - currY), 2));

            // if the distance is greater than the length, return true
            if (distance > parameters.LENGTH1) {
                return true;
            }
        }
        return false;
    }

    // boolean function that checks if condition 1 is met
    public boolean lic1() {
        if (parameters.RADIUS1 < 0)
            throw new IllegalArgumentException("Radius must be greater than 0"); // throw an exception if the radius is negative
        
        // this for loop gets three consecutive data points
        for (int i = 0; i < NUMPOINTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];
            
            //if the three points are in a circle with radius RADIUS1 return true
            if (inACircle(p1, p2, p3, parameters.RADIUS1)) {
                return true;
            }
        }
        return false;
    }

    // boolean function that checks if condition 2 is met
    public boolean lic2() {
        if (parameters.EPSILON < 0 || parameters.EPSILON >= PI) {
            throw new IllegalArgumentException("EPSILON must be in the range [0, PI)"); // throw an exception if the epsilon is not in the range [0, PI)
        }

        // this for loop gets three consecutive data points
        for (int i = 0; i < NUMPOINTS - 2; i++) {

            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];
            // if the three points are not collinear, calculate the angle between the three points
            if (!(p1.getX() == p2.getX() && p1.getY() == p2.getY())
                    & !(p2.getX() == p3.getX() && p2.getY() == p3.getY())) { 
                double angle = calcAngle(p1, p2, p3); 

                // if the angle is less than or greater than PI - EPSILON or PI + EPSILON, return true
                if (angle < (PI - parameters.EPSILON) || angle > (PI + parameters.EPSILON)) { 
                    return true;
                }
            }
        }
        return false;
    }

    // boolean function that checks if condition 3 is met
    public boolean lic3() {
        if (parameters.AREA1 < 0) {
            throw new IllegalArgumentException("Area must be greater than 0"); // throw an exception if the area is negative
        }
        // this for loop gets three consecutive data points
        for (int i = 0; i < NUMPOINTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            Point p3 = points[i + 2];
            // calculate the area of the triangle formed by the three points
            double add = p1.getX() * p2.getY() + p2.getX() * p3.getY() + p3.getX() * p1.getY();
            double sub = p1.getX() * p3.getY() + p2.getX() * p1.getY() + p3.getX() * p2.getY();

            double area = Math.abs(add - sub) * 0.5; // area of triangle

            if (area <= parameters.AREA1) { // if the area is less than or equal to the area, return true
                return true;
            }
        }
        return false;
    }

    // boolean function that checks if condition 4 is met
    public boolean lic4() {
        if (parameters.QUADS < 1 || parameters.QUADS > 3) {
            throw new IllegalArgumentException("QUADS must be in the range [1, 3]"); // throw an exception if the number of quadrants is not in the range [1, 3]
        } else if (parameters.Q_PTS < 2 || parameters.Q_PTS > NUMPOINTS) {
            throw new IllegalArgumentException("Q_PTS must be in the range [2, NUMPOINTS]"); // throw an exception if the number of points per quadrant is not in the range [2, NUMPOINTS]
        }

        // this for loop gets NUMPOINTS - Q_PTS + 1 points
        for (int i = 0; i < NUMPOINTS - parameters.Q_PTS + 1; i++) {
            int[] quad = new int[4];
            for (int j = i; j < i + parameters.Q_PTS; j++) {
                int q = getQuad(points[j]);
                quad[q] = 1; // set quadrant to 1 if point is in quadrant
            }
            int sum = 0;
            for (int k = 0; k < 4; k++) { // sum the values in quad
                sum += quad[k];
            }
            if (sum > parameters.QUADS) { // if the sum is greater than the number of quadrants, return true
                return true;
            }
        }
        return false;

    }

    // boolean function that checks if condition 5 is met
    public boolean lic5() {
        // this for loop gets two consecutive data points
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];

            if (p2.getX() - p1.getX() < 0) { // if the x-coordinate of the next point is less than the x-coordinate of the current point, return true
                return true;
            }
        }
        return false;

    }

    // boolean function that checks if condition 6 is met
    public boolean lic6() {
        if (parameters.DIST < 0) {
            throw new IllegalArgumentException("DIST must be greater than 0"); // throw an exception if the distance is negative
        } else if (parameters.N_PTS < 3 || parameters.N_PTS > NUMPOINTS) {
            throw new IllegalArgumentException("N_PTS must be in the range [3, NUMPOINTS]"); // throw an exception if N_PTS is not in the range [3, NUMPOINTS]
        }

        if (NUMPOINTS < 3) { // return false if there are less than 3 points
            return false;
        }

        // this foor loop finds N_PTS consecutive points
        for (int i = 0; i < NUMPOINTS - parameters.N_PTS + 1; i++) {
            Point[] pointsConsecutive = new Point[parameters.N_PTS];
            for (int j = i; j < i + parameters.N_PTS; j++) {
                pointsConsecutive[j] = points[j]; // append consecutive points to pointsConsecutive
            }
            // needs to be fixed or checked
            Point first = pointsConsecutive[0]; // first point in consecutive points
            Point last = pointsConsecutive[parameters.N_PTS - 1]; // last point in consecutive points
            if (first.getX() == last.getX() && first.getY() == last.getY()) { // if the first and last point in consecutive points are the same
                double distance = 0;
                for (int k = 1; k < parameters.N_PTS - 1; k++) { // calculate the distance between the identical point and the other points in consecutive points
                    distance += Math.sqrt(Math.pow((first.getX() - pointsConsecutive[k].getX()), 2)
                            + Math.pow((first.getY() - pointsConsecutive[k].getY()), 2)); // increment the distance
                    if (distance > parameters.DIST) { // if distance is greater than DIST, return true
                        return true;
                    }
                }
            } else { // if the first and last point in consecutive points are not the same
                double distance = 0;
                // coeficents A, B,C for line equation ax + by + c = 0
                double a = last.getY() - first.getY();
                double b = first.getX() - last.getX();
                double c = first.getX() * last.getY() - last.getX() * first.getY();
                for (int j = 0; j < parameters.N_PTS - 1; j++) { // calculate distance between points in consecutive points and the line formed from first and last
                    distance = Math.abs(a * pointsConsecutive[j].getX() + b * pointsConsecutive[j].getY() + c)
                            / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                    if (distance > parameters.DIST) { // if at least one distance is greater than DIST, return true
                        return true;
                    }
                }
            }
        }

        return false;
    }


    // boolean function that checks if condition 7 is met
    public boolean lic7() {
        if (parameters.K_PTS > 1 || parameters.K_PTS > NUMPOINTS - 2) {
            throw new IllegalArgumentException("K_PTS must be in the range [1, NUMPOINTS-2]"); // throw an exception if K_PTS is not in the range [1, NUMPOINTS-2]
        }

        if (NUMPOINTS < 3) { // return false if there are less than 3 points
            return false;
        }

        // this for loop gets 2 data points that are seperated with exatcly K_PTS 
        for (int i = 0; i < NUMPOINTS - parameters.K_PTS - 1; i++) {
            int j = i + parameters.K_PTS + 1;
            double currX = points[i].getX();
            double currY = points[i].getY();
            double nextX = points[j].getX();
            double nextY = points[j].getY();
            double distance = Math.sqrt(Math.pow((nextX - currX), 2) + Math.pow((nextY - currY), 2)); // calculate the distance between the two points
            if (distance <= parameters.LENGTH1) { // if the distance is less than or equal to LENGTH1, return true
                return true;
            }

        }

        return false; 
    }

    // boolean function that checks if condition 8 is met
    public boolean lic8() {

        if (parameters.A_PTS < 1)
            throw new IllegalArgumentException("A_PTS must be at least 1"); // throw an exception if A_PTS is less than 1

        if (parameters.B_PTS < 1)
            throw new IllegalArgumentException("B_PTS must be at least 1"); // throw an exception if B_PTS is less than 1

        if (parameters.A_PTS + parameters.B_PTS > (NUMPOINTS - 3))
            throw new IllegalArgumentException("A_PTS + B_PTS must be less than or equal to NUMPOINTS-3"); // throw an exception if A_PTS + B_PTS is greater than NUMPOINTS-3

        if (NUMPOINTS < 5) {
            return false; // return false if there are less than 5 points
        }


        // this for loop gets 3 data points that are seperated by A_PTS and B_PTS
        for (int i = 0; i < NUMPOINTS - parameters.A_PTS - parameters.B_PTS - 2; i++) {
            Point p1 = points[i];
            Point p2 = points[i + parameters.A_PTS + 1];
            Point p3 = points[i + parameters.A_PTS + parameters.B_PTS + 2];

            if (!inACircle(p1, p2, p3, parameters.RADIUS1)) {
                return true; // return true if the points are not in a circle
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

    // helper function that returns true if the points are in a circle with radius r
    public static boolean inACircle(Point p1, Point p2, Point p3, double r) {
        Point center = calcCenter(p1, p2, p3); // calculate the center of the circle
        double a = Math.pow((p1.getX() - center.getX()), 2) + Math.pow((p1.getY() - center.getY()), 2); 
        double b = Math.pow((p2.getX() - center.getX()), 2) + Math.pow((p2.getY() - center.getY()), 2);
        double c = Math.pow((p3.getX() - center.getX()), 2) + Math.pow((p3.getY() - center.getY()), 2);

        if (a <= r * r && b <= r * r && c <= r * r) {
            return true; // return true if the points are in a circle with radius r
        }
        return false;
    }

    // helper function that calculates the center of a circle with the three points
    public static Point calcCenter(Point p1, Point p2, Point p3) {
        double A = p1.getX() * p1.getX() + p1.getY() * p1.getY(); // calculate A, B, C for the equation of the circle
        double B = p2.getX() * p2.getX() + p2.getY() * p2.getY();
        double C = p3.getX() * p3.getX() + p3.getY() * p3.getY();

        double aux1 = (A * (p3.getY() - p2.getY()) + B * (p1.getY() - p3.getY()) + C * (p2.getY() - p1.getY())); // calculate aux1, aux2 for the equation of the circle
        double aux2 = -(A * (p3.getX() - p2.getX()) + B * (p1.getX() - p3.getX()) + C * (p2.getX() - p1.getX()));
        double div = (2 * (p1.getX() * (p3.getY() - p2.getY()) + p2.getX() * (p1.getY() - p3.getY()) // calculate div for the equation of the circle
                + p3.getX() * (p2.getY() - p1.getY())));

        if (div == 0) {
            return p2; // points are colinear i.e all on same line, return p2 as center
        }

        return new Point(aux1 / div, aux2 / div); // return the center of the circle as a point

    }

    // boolean function that checks if condition 9 is met
    public boolean lic9() {

        if (parameters.C_PTS < 1)
            throw new IllegalArgumentException("C_PTS must be at least 1"); // throw an exception if C_PTS is less than 1

        if (parameters.D_PTS < 1)
            throw new IllegalArgumentException("D_PTS must be at least 1"); // throw an exception if D_PTS is less than 1

        if (parameters.C_PTS + parameters.D_PTS > (NUMPOINTS - 3))
            throw new IllegalArgumentException("C_PTS + D_PTS must be less than or equal to NUMPOINTS-3"); // throw an exception if C_PTS + D_PTS is greater than NUMPOINTS-3

        if (NUMPOINTS < 5) {
            return false; // return false if there are less than 5 points
        }
        
        // for loop that gets 3 data points that are seperated by C_PTS and D_PTS
        for (int i = 0; i < NUMPOINTS - parameters.C_PTS - parameters.D_PTS - 2; i++) {

            Point vertex = points[i + parameters.C_PTS + 1]; // vertex
            Point p1 = points[i];
            Point p3 = points[i + parameters.C_PTS + parameters.D_PTS + 2];

            double angle = calcAngle(p1, vertex, p3); // calculate the angle between the vertex and the points

            if (angle < (PI - parameters.EPSILON) || angle > (PI + parameters.EPSILON)) { 
                return true; // return true if the angle is not between PI-EPSILON and PI+EPSILON
            }

        }

        return false;

    }

    // helper function that calculates the angle between the vertex and the points
    public static double calcAngle(Point p1, Point vertex, Point p3) {
        double angle = Math.atan2(p3.getY() - vertex.getY(), p3.getX() - vertex.getX()) // we use atan2 to calculate the angle between the vertex and the points
                - Math.atan2(p1.getY() - vertex.getY(), p1.getX() - vertex.getX());
        if (angle < 0) {
            angle += 2 * PI; // if the angle is negative, add 2PI to the angle
        }
        return angle; // return the angle
    }


    // boolean function that checks if condition 10 is met
    public boolean lic10() {

        if (parameters.E_PTS < 1)
            throw new IllegalArgumentException("E_PTS must be at least 1"); // throw an exception if E_PTS is less than 1
        if (parameters.F_PTS < 1)
            throw new IllegalArgumentException("F_PTS must be at least 1"); // throw an exception if F_PTS is less than 1
        if (parameters.E_PTS + parameters.F_PTS > NUMPOINTS - 3)
            throw new IllegalArgumentException("E_PTS + F_PTS must be less than or equal to NUMPOINTS-3"); // throw an exception if E_PTS + F_PTS is greater than NUMPOINTS-3

        if (NUMPOINTS < 5) {
            return false; // return false if there are less than 5 points
        }

        // for loop that gets 3 data points that are seperated by E_PTS and F_PTS
        for (int i = 0; i < NUMPOINTS - parameters.E_PTS - parameters.F_PTS - 2; i++) {

            Point p1 = points[i];
            Point p2 = points[i + parameters.E_PTS + 1];
            Point p3 = points[i + parameters.E_PTS + parameters.F_PTS + 2];

            double area = calcArea(p1, p2, p3); // calculate the area of the triangle formed by the three points

            if (area > parameters.AREA1) {
                return true; // return true if the area is greater than AREA1
            }

        }

        return false;

    }

    // helper function that calculates the area of the triangle formed by the three points
    public double calcArea(Point p1, Point p2, Point p3) {
        double area = Math.abs((p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY())
                + p3.getX() * (p1.getY() - p2.getY())) / 2.0); // we calculate the area using the shoelace formula
        return area;
    }

    // boolean function that checks if condition 11 is met
    public boolean lic11() {

        if (parameters.G_PTS < 1 || parameters.G_PTS > NUMPOINTS - 2)
            throw new IllegalArgumentException("G_PTS must be at least 1 and not larger than NUMPOINTS-2"); // throw an exception if G_PTS is less than 1 or larger than NUMPOINTS-2

        if (NUMPOINTS < 3) {
            return false; // return false if there are less than 3 points
        }

        // for loop that gets 2 data points that are seperated by G_PTS
        for (int i = 0; i < NUMPOINTS - parameters.G_PTS - 1; i++) {

            int p2Index = i + parameters.G_PTS + 1;

            double p1_x = points[i].getX();
            double p2_x = points[p2Index].getX();
            if (p2_x - p1_x < 0) {
                return true; // return true if x of p2 is larger than x of p1
            }

        }

        return false;

    }

    // boolean function that checks if condition 12 is met
    public boolean lic12() {
        if (parameters.LENGTH2 < 0)
            throw new IllegalArgumentException("Length2 must be larger than 0 "); // throw an exception if LENGTH2 is less than 0
        {

        }
        if (NUMPOINTS < 3) {
            return false; // return false if there are less than 3 points
        }

        // two boolean variables that are used to check if the distance between two points is greater than LENGTH1 or LENGTH2
        boolean isGreaterThanLength1 = false;
        boolean isGreaterThanLength2 = false;
        // for loop that gets 2 data points that are seperated by K_PTS
        for (int i = 0; i < NUMPOINTS - parameters.K_PTS - 1; i++) {

            int p2Index = i + parameters.K_PTS + 1;
            double distance = Math.sqrt(Math.pow((points[i].getX() - points[p2Index].getX()), 2)
                    + Math.pow((points[i].getY() - points[p2Index].getY()), 2)); // calculate the distance between the two points
            if (distance > parameters.LENGTH1) {
                isGreaterThanLength1 = true; // set isGreaterThanLength1 to true if the distance is greater than LENGTH1
            }

            if (distance < parameters.LENGTH2) {
                isGreaterThanLength2 = true; // set isGreaterThanLength2 to true if the distance is less than LENGTH2
            }

            if (isGreaterThanLength1 && isGreaterThanLength2) {
                return true; //return true if both isGreaterThanLength1 and isGreaterThanLength2 are true
            }

        }

        return false;

    }

    // boolean function that checks if condition 13 is met
    public boolean lic13() {

        if (parameters.RADIUS2 < 0)
            throw new IllegalArgumentException("Radius2 must be larger than 0"); // throw an exception if RADIUS2 is less than 0

        if (NUMPOINTS < 5) {
            return false; // return false 
        }
        // two boolean variables that are used to check if the distance between two points are in  a circle with radius RADIUS1 or RADIUS2
        boolean isNotInACircleRadius1 = false;
        boolean isInACircleRadius2 = false;
        
        // for loop that gets 3 data points that are seperated by A_PTS and B_PTS
        for (int i = 0; i < NUMPOINTS - parameters.A_PTS - parameters.B_PTS - 1; i++) {

            Point p1 = points[i];
            Point p2 = points[i + parameters.A_PTS + 1];
            Point p3 = points[i + parameters.A_PTS + parameters.B_PTS + 2];

            if (!inACircle(p1, p2, p3, parameters.RADIUS1)) {
                isNotInACircleRadius1 = true; // set isNotInACircleRadius1 to true if the points are not in a circle with radius RADIUS1
            }

            if (inACircle(p1, p2, p3, parameters.RADIUS2)) {
                isInACircleRadius2 = true; // set isInACircleRadius2 to true if the points are in a circle with radius RADIUS2
            }

            if (isInACircleRadius2 && isNotInACircleRadius1) {
                return true; // return true if both isNotInACircleRadius1 and isInACircleRadius2 are true
            }
        }
        return false;
    }

    // boolean function that checks if condition 14 is met
    public boolean lic14() {
        if (parameters.AREA2 < 0)
            throw new IllegalArgumentException("Area2 must be larger than 0"); // throw an exception if AREA2 is less than 0

        if (NUMPOINTS < 5) {
            return false; // retun false if there are less than 5 points
        }

        // two boolean variables that are used to check if the area of the triangle is larger than AREA1 or less than AREA2
        boolean isLargerThanArea1 = false;
        boolean isLessThanArea2 = false;

        // for loop that gets 3 data points that are seperated by E_PTS and F_PTS
        for (int i = 0; i < NUMPOINTS - parameters.E_PTS - parameters.F_PTS - 1; i++) {

            Point p1 = points[i];
            Point p2 = points[i + parameters.E_PTS + 1];
            Point p3 = points[i + parameters.E_PTS + parameters.F_PTS + 2];

            double area = calcArea(p1, p2, p3); // calculate the area of the triangle

            if (area > parameters.AREA1) {
                isLargerThanArea1 = true; // set isLargerThanArea1 to true if the area is larger than AREA1
            }

            if (area < parameters.AREA2) {
                isLessThanArea2 = true; // set isLessThanArea2 to true if the area is less than AREA2
            }

            if (isLargerThanArea1 && isLessThanArea2) {
                return true; // return true if both isLargerThanArea1 and isLessThanArea2 are true
            }
        }
        return false;
    }

}