package test;

import src.CMV;
import src.PUM;
import src.FUV;
import src.MissileSystem;
import src.Parameters;
import src.Point;
import java.util.Random;

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

    /* 
    There exists no set of two data points separated by exactly K_PTS
    consecutive intervening points that are a distance greater than the length, LENGTH1,
    apart. The condition is not met when NUMPOINTS < 3.
    */
    @Test
    public void lic7Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(2, 1);
        Parameters param = new Parameters();
        param.K_PTS = 1;
        param.LENGTH1 = 10;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic7());
    } 

    /* 
    There exists at least one set of two data points separated by exactly K_PTS
    consecutive intervening points that are a distance greater than the length, LENGTH1,
    apart. The condition is not met when NUMPOINTS < 3.
    */
    @Test
    public void lic7Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(10, 1);
        Parameters param = new Parameters();
        param.K_PTS = 1;
        param.LENGTH1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic7());
    } 

    /* The condition (1 ≤ K_PTS ≤ (NUMPOINTS−2)) should be met for LIC7 */
    @Test
    public void lic7Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(2, 1);
        Parameters param = new Parameters();
        param.K_PTS = 10;
        param.LENGTH1 = 10;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic7();} );
    }

    /* 
    There exists no set of three data points separated by exactly
    A_PTS and B_PTS consecutive intervening points, respectively, that cannot
    be contained within or on a circle of radius RADIUS1. The condition is not
    met when NUMPOINTS < 5.
    */
    @Test
    public void lic8Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 1);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.A_PTS = 1;
        param.B_PTS = 2;
        param.RADIUS1 = 10;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertFalse(cmv.lic8());
    } 

    /* 
    There exists at least one set of three data points separated by exactly
    A_PTS and B_PTS consecutive intervening points, respectively, that cannot
    be contained within or on a circle of radius RADIUS1. The condition is not
    met when NUMPOINTS < 5.
    */
    @Test
    public void lic8Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(10, 1);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(20, 1);
        Parameters param = new Parameters();
        param.A_PTS = 1;
        param.B_PTS = 2;
        param.RADIUS1 = 1;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertTrue(cmv.lic8());
    } 

    /* The condition (1 <= A_PTS, 1 <= B_PTS) should be met for LIC8 */
    @Test
    public void lic8Test_IllegalArgumentException1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(1, 1);
        Parameters param = new Parameters();
        param.A_PTS = 0;
        param.B_PTS = -1;
        param.RADIUS1 = 1;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic8();} );
    }

    
    /* The condition (A_PTS + B_PTS <= (NUMPOINTS−3)) should be met for LIC8 */
    @Test
    public void lic8Test_IllegalArgumentException2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(1, 1);
        Parameters param = new Parameters();
        param.A_PTS = 2;
        param.B_PTS = 2;
        param.RADIUS1 = 1;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic8();} );
    }

    /*
    There exists no set of three data points separated by
    exactly C_PTS and D_PTS consecutive intervening points, respectively,
    that form an angle such that:
        angle < (PI−EPSILON)
    or
        angle > (PI+EPSILON)
    The second point of the set of three points is always the vertex of
    the angle. If either the first point or the last point (or both) coincide
    with the vertex, the angle is undefined and the LIC is not satisfied by
    those three points. When NUMPOINTS < 5, the condition is not met.
    */
    @Test
    public void lic9Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.C_PTS = 1;
        param.D_PTS = 2;
        param.EPSILON = (3.0/4) * Math.PI;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertFalse(cmv.lic9());
    } 

    /*
    There exists at least one set of three data points separated by
    exactly C_PTS and D_PTS consecutive intervening points, respectively,
    that form an angle such that:
        angle < (PI−EPSILON)
    or
        angle > (PI+EPSILON)
    The second point of the set of three points is always the vertex of
    the angle. If either the first point or the last point (or both) coincide
    with the vertex, the angle is undefined and the LIC is not satisfied by
    those three points. When NUMPOINTS < 5, the condition is not met.
    */
    @Test
    public void lic9Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.C_PTS = 1;
        param.D_PTS = 2;
        param.EPSILON = (1.0/4) * Math.PI;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertTrue(cmv.lic9());
    }

    /*
    The condition (1 <= C_PTS, 1 <= D_PTS) has to be fullfilled for LIC9
    */
    @Test
    public void lic9Test_IllegalArgumentException1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.C_PTS = 0;
        param.D_PTS = -1;
        param.EPSILON = (3.0/4) * Math.PI;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic9();} );
    }
  
    /*
    The condition (C_PTS + D_PTS <= (NUMPOINTS−3)) has to be fullfilled for LIC9
    */
    @Test
    public void lic9Test_IllegalArgumentException2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.C_PTS = 2;
        param.D_PTS = 2;
        param.EPSILON = (3.0/4) * Math.PI;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic9();} );
    }

    /* 
    There exists no set of three data points separated by
    exactly E_PTS and F_PTS consecutive intervening points, respectively,
    that are the vertices of a triangle with area greater than AREA1.
    The condition is not met when NUMPOINTS < 5.
    */
    @Test
    public void lic10Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.E_PTS = 1;
        param.F_PTS = 2;
        param.AREA1 = 10;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertFalse(cmv.lic10());
    } 

    /* 
    There exists at least one set of three data points separated by
    exactly E_PTS and F_PTS consecutive intervening points, respectively,
    that are the vertices of a triangle with area greater than AREA1.
    The condition is not met when NUMPOINTS < 5.
    */
    @Test
    public void lic10Test_True() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(10, 10);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(20, 1);
        Parameters param = new Parameters();
        param.E_PTS = 1;
        param.F_PTS = 2;
        param.AREA1 = 1;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertTrue(cmv.lic10());
    } 

    /* The condition (1 <= E_PTS, 1 <= F_PTS) has to be fullfilled for LIC10*/
    @Test
    public void lic10Test_IllegalArgumentException1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.E_PTS = 0;
        param.F_PTS = -1;
        param.AREA1 = 10;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic10();} );
    }

    /* The condition (E_PTS + F_PTS <= (NUMPOINTS−3)) has to be fullfilled for LIC10*/
    @Test
    public void lic10Test_IllegalArgumentException2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(10, 10);
        Point p5 = new Point(10, 10);
        Point p6 = new Point(3, 1);
        Parameters param = new Parameters();
        param.E_PTS = 2;
        param.F_PTS = 2;
        param.AREA1 = 10;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic10();} );
    }

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
    There exists no set of three data points, separated by exactly
    A_PTS and B_PTS consecutive intervening points, respectively, that
    cannot be contained within or on a circle of radius RADIUS1. In addition,
    there exists no set of three data points separated by exactly
    A_PTS and B_PTS consecutive intervening points, respectively, that can be
    contained in or on a circle of radius RADIUS2.
    */
    @Test
    public void lic13Test_False() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(4, 4);
        Point p5 = new Point(5, 5);
        Point p6 = new Point(6, 6);
        Parameters param = new Parameters();
        param.A_PTS = 1;
        param.B_PTS = 1;
        param.RADIUS1 = 2;
        param.RADIUS2 = 2;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);

        assertFalse(cmv.lic13());
    }

    /*
    There exists at least one set of three data points, separated by exactly
    A_PTS and B_PTS consecutive intervening points, respectively, that
    cannot be contained within or on a circle of radius RADIUS1. In addition,
    there exists at least one set of three data points separated by exactly
    A_PTS and B_PTS consecutive intervening points, respectively, that can be
    contained in or on a circle of radius RADIUS2.
    */
    @Test
    public void lic13Test_True() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(3, 1);
        Point p5 = new Point(4, 4);
        Point p6 = new Point(4, 0);
        Parameters param = new Parameters();
        param.A_PTS = 1;
        param.B_PTS = 1;
        param.RADIUS1 = 1;
        param.RADIUS2 = 1;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);

        assertTrue(cmv.lic13());
    }

    /* Ensure 0 <= RADIUS2 */
    @Test
    public void lic13Test_IllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(3, 1);
        Point p6 = new Point(3, 2);
        Parameters param = new Parameters();
        param.A_PTS = 1;
        param.B_PTS = 1;
        param.RADIUS1 = 1;
        param.RADIUS2 = -2;
        CMV cmv = new CMV(6, new Point[] { p1, p2, p3, p4, p5, p6 }, param);

        assertThrows(IllegalArgumentException.class, () -> {cmv.lic13();} );
    }

    /*
    There exists no set of three data points, separated by exactly E_PTS
    and F_PTS consecutive intervening points, respectively, that are the vertices
    of a triangle with area greater than AREA1. Inaddition, there exist no three data
    points separated by exactly E_PTS and F_PTS consecutive intervening points,
    respectively, that are the vertices of a triangle with area less than AREA2.
    */
    @Test
    public void lic14Test_False() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(5, 10);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(10,0);
        Parameters param = new Parameters();
        param.E_PTS = 1;
        param.F_PTS = 1;
        param.AREA1 = 10;
        param.AREA2 = 40;
        CMV cmv = new CMV(5, new Point[] { p1, p2, p3, p4, p5 }, param);

        assertFalse(cmv.lic14());
    }

    /*
    There exists at least one set of three data points, separated by exactly E_PTS
    and F_PTS consecutive intervening points, respectively, that are the vertices
    of a triangle with area greater than AREA1. Inaddition, there exist three data
    points (which can be the same or different from the three data points just
    mentioned) separated by exactly E_PTS and F_PTS consecutive intervening points,
    respectively, that are the vertices of a triangle with area less than AREA2.
    */
    @Test
    public void lic14Test_True() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(5, 10);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(10,0);
        Parameters param = new Parameters();
        param.E_PTS = 1;
        param.F_PTS = 1;
        param.AREA1 = 10;
        param.AREA2 = 100;
        CMV cmv = new CMV(5, new Point[] { p1, p2, p3, p4, p5 }, param);

        assertTrue(cmv.lic14());
    }

    /* Ensure that 0 <= AREA2 */
    @Test
    public void lic14Test_IllegalArgumentException() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(5, 10);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(10,0);
        Parameters param = new Parameters();
        param.E_PTS = 1;
        param.F_PTS = 1;
        param.AREA1 = 10;
        param.AREA2 = -100;
        CMV cmv = new CMV(5, new Point[] { p1, p2, p3, p4, p5 }, param);

        assertThrows(IllegalArgumentException.class, () -> {cmv.lic14();} );
    }
  
    /*
    * Tests so that an equilateral triangle with edge length equal to the radius does not fit in the circle.
    */
    @Test
    public void testInACircleWithEquilaterTriangle(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(2,Math.sqrt(12)); 
        double radius = 2;
        Parameters param = new Parameters();
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3}, param);

        assertFalse(cmv.inACircle(p1, p2, p3, radius));
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
     * Tests that the program decides to launch when all values in PUV is false
     */
    @Test
    public void decideLaunchWhenPUVisFalse(){
        Random rand = new Random();
        // ANDD = 0, ORR = 1, NOTUSED = 2

        //Randomize lcm
        int[][] lcm = new int[15][15];
        for(int i = 0 ; i < lcm.length ; i++){
            for (int j = 0 ; j < lcm[0].length ; j++){
                lcm[i][j] = rand.nextInt(3); //random value in range [0,2];;
            }
        }
        
        boolean[] puv = new boolean[15];
        for(int i = 0 ; i < puv.length ; i++){
            puv[i] = false;
        }

        int NUMPOINTS = 3;
        
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Point[] points = {p1, p2, p3};
        Parameters parameters = new Parameters();

        MissileSystem system = new MissileSystem(NUMPOINTS, points, lcm, puv, parameters);
        assertTrue(system.decide());
    }

    /*
    * Tests that the program decides to launch when all values in LCM is NOTUSED
    */
    @Test
    public void decideLaunchWhenAllValuesInLCMisNOTUSED(){
        Random rand = new Random(); 
        // ANDD = 0, ORR = 1, NOTUSED = 2
        int[][] lcm = new int[15][15];
        for(int i = 0 ; i < lcm.length ; i++){
            for (int j = 0 ; j < lcm[0].length ; j++){
                lcm[i][j] = 2;
            }
        }
        boolean[] puv = new boolean[15];
        for(int i = 0 ; i < puv.length ; i++){
            puv[i] = rand.nextBoolean();
        }

        int NUMPOINTS = 3;
        
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Point[] points = {p1, p2, p3};
        Parameters parameters = new Parameters();

        MissileSystem system = new MissileSystem(NUMPOINTS, points, lcm, puv, parameters);
        assertTrue(system.decide());
    }

    
    /*
    * Tests that the program decides to not launch when:
    * -All conditions are not met
    * -All values in LCM is set to ANDD
    * -All values in puv is set to ORR
    */
    @Test
    public void decideNotLaunch(){
        // ANDD = 0, ORR = 1, NOTUSED = 2
        int[][] lcm = new int[15][15];
        for(int i = 0 ; i < lcm.length ; i++){
            for (int j = 0 ; j < lcm[0].length ; j++){
                lcm[i][j] = 0;
            }
        }
        
        boolean[] puv = new boolean[15];
        for(int i = 0 ; i < puv.length ; i++){
            puv[i] = true;
        }

        int NUMPOINTS = 3;
        
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 1);
        Point[] points = {p1, p2, p3};
        Parameters parameters = new Parameters();

        MissileSystem system = new MissileSystem(NUMPOINTS, points, lcm, puv, parameters);
        assertFalse(system.decide());
    }

    
    /*
    * Tests for the entire program
    */
    @Test
    public void decideLaunch1() {
        int NUMPOINTS = 6;
        Point p1 = new Point(3, 1);
        Point p2 = new Point(-5, 9);
        Point p3 = new Point(9, 14);
        Point p4 = new Point(0, 1);
        Point p5 = new Point(4, 3);
        Point p6 = new Point(2, 3);
        Point[] points = {p1,p2,p3,p4,p5,p6};

        Parameters param = new Parameters(
            10, //LENGTH1
            2, //RADIUS1
            (1.0/2)*Math.PI, // EPSILON
            3, // AREA1
            3, // Q_PTS
            1, //QUADS
            1, //DIST
            4, //N_PTS
            1, //K_PTS
            1, //A_PTS
            2, //B_PTS
            2, //C_PTS
            1, //D_PTS
            1, //E_PTS
            1, //F_PTS
            2, //G_PTS
            3, //LENGTH2
            4, //RADIUS2
            3 //AREA2
        );
        
        // LIC 13 is false

        // ANDD = 0, ORR = 1, NOTUSED = 2

        int[][] lcm = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        boolean[] puv = {true, true, true, true, true,
                         true, true, true, true, true,
                         true, true, true, false, true};
    
        MissileSystem system = new MissileSystem(NUMPOINTS, points, lcm, puv, param);
        assertTrue(system.decide());
    }

    @Test
    public void decideLaunch2() {
        int NUMPOINTS = 9;
        Point p1 = new Point(3, 1);
        Point p2 = new Point(-5, 9);
        Point p3 = new Point(9, 14);
        Point p4 = new Point(0, 1);
        Point p5 = new Point(4, 3);
        Point p6 = new Point(2, 3);
        Point p7 = new Point(0.002, 9);
        Point p8 = new Point(3, 7.1);
        Point p9 = new Point(-1, 4.2);
        Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9};

        Parameters param = new Parameters(
            20, //LENGTH1
            10, //RADIUS1
            Math.PI/2, // EPSILON
            3, // AREA1
            3, // Q_PTS
            1, //QUADS
            1, //DIST
            4, //N_PTS
            1, //K_PTS
            1, //A_PTS
            2, //B_PTS
            2, //C_PTS
            1, //D_PTS
            1, //E_PTS
            1, //F_PTS
            2, //G_PTS
            3, //LENGTH2
            4, //RADIUS2
            3 //AREA2
        );

        // LIC 0, 7, 8, 12, 13 is false

        // ANDD = 0, ORR = 1, NOTUSED = 2

        int[][] lcm = {
            {0, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        boolean[] puv = {true, false, false, false, true,
                         false, false, false, false, false,
                         false, false, false, false, false};
    
        MissileSystem system = new MissileSystem(NUMPOINTS, points, lcm, puv, param);
        assertTrue(system.decide());
    }

    @Test
    public void decideLaunch3() {
        int NUMPOINTS = 9;
        Point p1 = new Point(0.1, -0.003);
        Point p2 = new Point(3.1415, 13.223);
        Point p3 = new Point(9.82, 2.72);
        Point p4 = new Point(-4.29, -0.001);
        Point p5 = new Point(3, 1);
        Point p6 = new Point(7, 3.1);
        Point p7 = new Point(0.002, 9);
        Point p8 = new Point(2.42, -7.1);
        Point p9 = new Point(-1, 4.20);
        Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9};

        Parameters param = new Parameters(
            1, //LENGTH1
            10, //RADIUS1
            Math.PI/2, // EPSILON
            3, // AREA1
            3, // Q_PTS
            1, //QUADS
            1, //DIST
            4, //N_PTS
            1, //K_PTS
            2, //A_PTS
            1, //B_PTS
            2, //C_PTS
            3, //D_PTS
            1, //E_PTS
            2, //F_PTS
            2, //G_PTS
            3, //LENGTH2
            1, //RADIUS2
            3 //AREA2
        );

        // LIC 12, 13, 14 is false

        // ANDD = 0, ORR = 1, NOTUSED = 2

        int[][] lcm = {
            {0, 1, 0, 1, 1, 0, 1, 2, 2, 1, 2, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 0}
        };

        boolean[] puv = {true, false, false, false, true, 
                         false, false, false, false, false,
                         false, false, true, true, true};
    
        MissileSystem system = new MissileSystem(NUMPOINTS, points, lcm, puv, param);
        assertTrue(system.decide());
    }

    /* 
    This tests the decide function for input which should cause the system to not launch
    */
    @Test
    public void decideNotLaunch1() {
        Point p1 = new Point(3, 1);
        Point p2 = new Point(6, 3);
        Point p3 = new Point(8, 8);
        Point p4 = new Point(0, 0);
        Point p5 = new Point(-4, 3);
        Point p6 = new Point(2, 3);
        Point p7 = new Point(-2, 3);
        Point p8 = new Point(6, -3);
        Point p9 = new Point(2, 30);

        Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9};

        Parameters param = new Parameters(
            10, //LENGTH1
            2, //RADIUS1
            (1.0/2)*Math.PI, // EPSILON
            3, // AREA1
            3, // Q_PTS
            1, //QUADS
            1, //DIST
            4, //N_PTS
            1, //K_PTS
            1, //A_PTS
            2, //B_PTS
            2, //C_PTS
            1, //D_PTS
            1, //E_PTS
            1, //F_PTS
            2, //G_PTS
            3, //LENGTH2
            4, //RADIUS2
            3 //AREA2
        );

        // ANDD = 0, ORR = 1, NOTUSED = 2
        int[][] lcm = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2}
        }; // lcm[13][14] = lcm[14][13] = 1 ORR . lcm[14][13] and lcm[13][14] requires that either lic13 or lic14 is true
        

        boolean[] puv = {false, false, true, true, true,
                         true, false, true, false, true,
                         true, true, true, true, true}; // because puv[13] and puv[14] is true that means that the condition is active for the launch decision


        // our arbitary parameters and coordinates generate a cmv where lic13 and lic14 are false
        
        MissileSystem system = new MissileSystem(points.length, points, lcm, puv, param);
        assertFalse(system.decide());
    }

    /* 
    This tests the decide function for input which should cause the system to not launch
    */
    @Test
    public void decideNotLaunch2() {
        Point p1 = new Point(3, 1);
        Point p2 = new Point(6.5, 13);
        Point p3 = new Point(8, 8.01);
        Point p4 = new Point(9, 9);
        Point p5 = new Point(-4, 3);
        Point p6 = new Point(2.560, 3);
        Point p7 = new Point(-2, 3);
        Point p8 = new Point(12, -12);
        Point p9 = new Point(1, 3.66);

        Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9};

        Parameters param = new Parameters(
            100, //LENGTH1
            2, //RADIUS1
            (1.0/3)*Math.PI, // EPSILON
            3, // AREA1
            3, // Q_PTS
            1, //QUADS
            1, //DIST
            3, //N_PTS
            1, //K_PTS
            1, //A_PTS
            3, //B_PTS
            2, //C_PTS
            1, //D_PTS
            1, //E_PTS
            2, //F_PTS
            2, //G_PTS
            3, //LENGTH2
            4, //RADIUS2
            6 //AREA2
        );

        // ANDD = 0, ORR = 1, NOTUSED = 2
        int[][] lcm = {
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        }; // lcm[0][1] = lcm[1][0] = 0 ANDD. lcm[0][1] and lcm[1][0] requires that both lic0 or lic are true
        

        boolean[] puv = {false, true, true, true, true,
                         true, true, false, true, true,
                         true, true, false, false, false}; // because puv[1] is true that means that the condition is active for the launch decision


        // our arbitary parameters and coordinates generate a cmv where these LIC's become false:
        // lic 0, 7, 12, 13, 14 
         
        MissileSystem system = new MissileSystem(points.length, points, lcm, puv, param);
        assertFalse(system.decide());
    }
}

