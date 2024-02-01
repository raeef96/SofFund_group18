package test;

import src.CMV;
import src.PUM;
import src.FUV;
import src.Parameters;
import src.Point;

import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    /* 
        Test all LIC conditions
    */

    /* There exists no set of two consecutive data points
    that are a distance greater than the length LENGTH1 = 2 apart*/
    @Test
    public void lic0Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Parameters param = new Parameters();
        param.LENGTH1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic0());
    } 

    /* There exists at least one set of two consecutive data points
    that are a distance greater than the length LENGTH1 = 2 apart*/
    @Test
    public void lic0Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(10, 10);
        Parameters param = new Parameters();
        param.LENGTH1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
       
        assertTrue(cmv.lic0());
    } 

    /* The length variable should fullfill: LENGTH1 >= 0, for LIC0*/
    @Test
    public void lic0Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Parameters param = new Parameters();
        param.LENGTH1 = -1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic0();} );
    } 

    /* There exists no set of three consecutive data points
    that cannot all be contained within or on a circle of radius RADIUS1 */
    @Test
    public void lic1Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.RADIUS1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic1());
    } 

    /* There exists at least one set of three consecutive data points
    that cannot all be contained within or on a circle of radius RADIUS1 */
    @Test
    public void lic1Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(10, 1);
        Parameters param = new Parameters();
        param.RADIUS1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic1());
    } 

    /* The parameter variable RADIUS1 >= 0, for LIC1 */
    @Test
    public void lic1Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.RADIUS1 = -1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic1();} );
    } 

    /* There exists no set of three consecutive data points
    which form an angle such that: 
    angle < (PI−EPSILON)
    or
    angle > (PI+EPSILON)
    */
    @Test
    public void lic2Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.EPSILON = (3.0/4) * Math.PI;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic2());
    } 

    /* There exists at least one set of three consecutive data points
    which form an angle such that: 
    angle < (PI−EPSILON)
    or
    angle > (PI+EPSILON)
    */
    @Test
    public void lic2Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.EPSILON = (1.0/4) * Math.PI;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic2());
    }

    /* The parameter EPSILON fullfill: 0 <= EPSILON < PI, for LIC2 */
    @Test
    public void lic2Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.EPSILON = -1*Math.PI;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic2();} );
    } 

    /*
    There exists no set of three consecutive data points
    that are the vertices of a triangle with area greater than AREA1.
    */
    @Test
    public void lic3Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.AREA1 = 10;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic3());
    } 

    /*
    There exists at least one set of three consecutive data points
    that are the vertices of a triangle with area greater than AREA1.
    */
    @Test
    public void lic3Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(5, 5);
        Point p3 = new Point(10, 1);
        Parameters param = new Parameters();
        param.AREA1 = 1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic3());
    } 

    /* Ensure that AREA1 fullfills: (0 <= AREA1), for LIC3 */
    @Test
    public void lic3Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.AREA1 = -1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic3();} );
    } 

    /*
    There exists no set of Q_PTS consecutive data points that lie in more than QUADS
    quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
    of decision will be by quadrant number, i.e., I, II, III, IV.
    */
    @Test
    public void lic4Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(-1, 2);
        Parameters param = new Parameters();
        param.Q_PTS = 3;
        param.QUADS = 2;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);
        
        assertFalse(cmv.lic4());
    } 

    /*
    There exists at least one set of Q_PTS consecutive data points that lie in more than QUADS
    quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
    of decision will be by quadrant number, i.e., I, II, III, IV.
    */
    @Test
    public void lic4Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point p3 = new Point(-1, -1);
        Point p4 = new Point(1, 2);
        Parameters param = new Parameters();
        param.Q_PTS = 3;
        param.QUADS = 2;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);
        
        assertTrue(cmv.lic4());
    } 

    /* Ensure that (2 <= Q_PTS <= NUMPOINTS), for LIC4 */
    @Test
    public void lic4Test_IllegalArgumentException1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(-1, -1);
        Parameters param = new Parameters();
        param.Q_PTS = 1;
        param.QUADS = 2;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic4();} );
    } 

    /* Ensure that (1 <= QUADS <= 3), for LIC4 */
    @Test
    public void lic4Test_IllegalArgumentException2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, 1);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(-1, -1);
        Parameters param = new Parameters();
        param.Q_PTS = 3;
        param.QUADS = 4;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic4();} );
    }

    /*
    There exists no set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]),
    such that X[j] - X[i] < 0. (where i = j-1)
    */
    @Test
    public void lic5Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 1);
        Parameters param = new Parameters();
        CMV cmv = new CMV(2, new Point[] { p1, p2}, param);
        
        assertFalse(cmv.lic5());
    } 

    /*
    There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]),
    such that X[j] - X[i] < 0. (where i = j-1)
    */
    @Test
    public void lic5Test_True() {
        Point p1 = new Point(10, 1);
        Point p2 = new Point(1, 1);
        Parameters param = new Parameters();
        CMV cmv = new CMV(2, new Point[] { p1, p2}, param);
        
        assertTrue(cmv.lic5());
    } 

    /*
    There exists no set of N_PTS consecutive data points such that
    at least one of the points lies a distance greater than DIST from the line
    joining the first and last of these N_PTS points. If the first and last
    points of these N_PTS are identical, then the calculated distance
    to compare with DIST will be the distance from the coincident point to all
    other points of the N_PTS consecutive points.
    */
    @Test
    public void lic6Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.N_PTS = 3;
        param.DIST = 10;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic6());
    } 

    /*
    There exists at least one set of N PTS consecutive data points such that
    at least one of the points lies a distance greater than DIST from the line
    joining the first and last of these N_PTS points. If the first and last
    points of these N_PTS are identical, then the calculated distance
    to compare with DIST will be the distance from the coincident point to all
    other points of the N_PTS consecutive points.
    */
    @Test
    public void lic6Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.N_PTS = 3;
        param.DIST = 3;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic6());
    } 

    /* Ensure that (3 ≤ N PTS ≤ NUMPOINTS), for LIC6 */
    @Test
    public void lic6Test_IllegalArgumentException1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.N_PTS = 2;
        param.DIST = 10;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic6();} );
    }

    /* Ensure that (0 ≤ DIST), for LIC6 */
    @Test
    public void lic6Test_IllegalArgumentException2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.N_PTS = 3;
        param.DIST = -1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic6();} );
    }

    




    /* There exists at least one set of two data points separated by exactly K_PTS
    consecutive intervening points that are a distance greater than the length, LENGTH1,
    apart. The condition is not met when NUMPOINTS < 3.
    */
    

    /* 1 ≤ K PTS ≤ (NUMPOINTS−2) */


    /*
    There exists no set of two data points,
    (X[i],Y[i]) and (X[j],Y[j]), separated by exactly
    G_PTS consecutive intervening points, such that X[j]- X[i] < 0.
    (where i < j )
    */
    @Test
    public void lic11Test_False() {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(1, 5);
        Point p3 = new Point(1, 4);
        Point p4 = new Point(1, 1);
        Parameters param = new Parameters();
        param.G_PTS = 2;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);

        assertFalse(cmv.lic11());
    }

    /*
    There exists at least one set of two data points,
    (X[i],Y[i]) and (X[j],Y[j]), separated by exactly
    G_PTS consecutive intervening points, such that X[j]- X[i] < 0.
    (where i < j )
    */
    @Test
    public void lic11Test_True() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(1, 5);
        Point p3 = new Point(6, 4);
        Point p4 = new Point(1, 1);
        Parameters param = new Parameters();
        param.G_PTS = 2;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);

        assertTrue(cmv.lic11());
    }

    /* Ensure that 1 <= G_PTS <= NUMPOINTS - 2 */
    @Test
    public void lic11Test_IllegalArgumentException() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(1, 5);
        Point p3 = new Point(6, 4);
        Point p4 = new Point(1, 1);
        Parameters param = new Parameters();
        param.G_PTS = 3;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);

        assertThrows(IllegalArgumentException.class, () -> {cmv.lic11();} );
    }

    /*
    There exists no set of two data points, separated by exactly K_PTS
    consecutive intervening points, which are a distance greater than the length,
    LENGTH1, apart. In addition, there exists no set of two data points,
    separated by exactly K_PTS consecutive intervening points, that are a distance
    less than the length, LENGTH2, apart.
    */
    @Test
    public void lic12Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, 4);
        Parameters param = new Parameters();
        param.K_PTS = 1;
        param.LENGTH1 = 3;
        param.LENGTH2 = 3;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);

        assertFalse(cmv.lic12());
    }

    /*
    There exists at least one set of two data points, separated by exactly K_PTS
    consecutive intervening points, which are a distance greater than the length,
    LENGTH1, apart. In addition, there exists at least one set of two data points
    (which can be the same or different from the two data points just mentioned),
    separated by exactly K_PTS consecutive intervening points, that are a distance
    less than the length, LENGTH2, apart. Both parts must be true for the LIC to
    be true.
    */
    @Test
    public void lic12Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(1, 5);
        Point p4 = new Point(3, 3);
        Parameters param = new Parameters();
        param.K_PTS = 1;
        param.LENGTH1 = 3;
        param.LENGTH2 = 3;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);

        assertTrue(cmv.lic12());
    }

    /* Ensure that 0 <= LENGTH2 */
    @Test
    public void lic12Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(1, 5);
        Point p4 = new Point(3, 3);
        Parameters param = new Parameters();
        param.K_PTS = 1;
        param.LENGTH1 = 3;
        param.LENGTH2 = -3;
        CMV cmv = new CMV(4, new Point[] { p1, p2, p3, p4 }, param);

        assertThrows(IllegalArgumentException.class, () -> {cmv.lic12();} );
    }

    /*
    * Test CalculateCMV
    */


    /*
     * Tests for PUM
     */

    @Test
    public void calculatePUMtest(){
        //LCM & CMV needed
        boolean[] cmv = new boolean[15];
        cmv[1] = true; 
        cmv[12] = true;

        int[][] lcm = {
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        boolean[][] expected = new boolean[15][15];
        expected[1][2] = true;
        expected[2][1] = true;
        expected[1][1] = true;
        expected[1][0] = true;
        expected[0][1] = true;
        expected[12][12] = true;
        expected[1][12] = true;
        expected[12][1] = true;
        assertArrayEquals(new PUM(lcm,cmv).get() , expected);
    }


    /*
    * Tests for FUV
    */
    @Test
    public void calculateFUVTest(){

        /* Create a PUM (size 15x15) */
        boolean[][] PUM = new boolean[15][15];
        for (int index = 0; index < 15; index++){
            PUM[2][index] = true;
            PUM[4][index] = true;
        }
        PUM[4][14] = false;
        
        
        /* Create a PUV (size 15) */
        boolean[] PUV = {false, false, true, true, true, true, true, true, true, true, true, true, true, true, true};

        /* FUV should look like this based on PUM and PUV */
        boolean[] expectedFUV = {true, true, true, false, false, false, false, false, false, false, false, false, false, false, false};

        FUV fuvObj = new FUV(PUV, PUM);
        
        assertArrayEquals(expectedFUV, fuvObj.get());
    }


    /*
    * Tests for the entire program
    */
}
