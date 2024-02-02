package test.decide_tests;
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


    
