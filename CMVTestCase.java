public class CMVTestCase {
    public static void main(String[] args) {

        // Testcase for lic0 with 3 points should return false
        assert lic0TestCase() == false;
    }

    public static boolean lic0TestCase() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 5);
        Point p3 = new Point(2, 3);
        Parameters parametersLic0 = new Parameters();
        parametersLic0.LENGTH1 = 2;
        CMV cmvLIC0 = new CMV(3, new Point[] { p1, p2, p3 }, parametersLic0);
        return cmvLIC0.lic0();
    }
}
