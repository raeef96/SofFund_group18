package src;

import java.util.Random;

public class Main {

    private static int seed = 1; /* Set the random seed */
    private static Random generator = new Random(seed);
    private static int NUMPOINTS = 5;


    private static Parameters PARAMETERS = new Parameters(2.4,3.3,0.001,22.1,1,3,7,8,5,3,2,2,2,2,2,2,3,4,7);

    private static boolean[][] LCM = {
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true},
    };
    private static boolean[] PUV = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,};


    /* Randomly create coordinate values between 0 and 10 */
    private static Point[] createRandomPoints(int NUMPOINTS, int factor){
        Point[] POINTS = new Point[NUMPOINTS]; 
        for (int i=0; i<NUMPOINTS; i++){
            Point newPoint = new Point(generator.nextDouble()*factor, generator.nextDouble()*factor);
            POINTS[i] = newPoint;
        }
        return POINTS;
    }

    public static void main(String[] args){
        
        MissileSystem system1 = new MissileSystem(NUMPOINTS, createRandomPoints(NUMPOINTS, 10), LCM, PUV, PARAMETERS);
        system1.decide();
        
        
    }
}
