package src;

public class MissileSystem{

    /* CONSTANTS */
    public double PI = Math.PI;
    public int NUMPOINTS;
    public enum Connectors {NOTUSED , ORR , ANDD}
    public Point[] POINTS;

    public int[][] LCM;
    public boolean[] PUV;
    public Parameters PARAMETERS;
    

    /* Constructor */
    public MissileSystem(int NUMPOINTS, Point[] POINTS, int[][] LCM, boolean[] PUV, Parameters PARAMETERS) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.LCM = LCM;
        this.PUV = PUV;
        this.PARAMETERS = PARAMETERS;
    }



    /*
    * Makes the final decision on whether or not the missile should be launched based on the FUV
    * @param the final unlocking vector 
    * @return whether or not the missile should be launched
    */
    public boolean launch(boolean[] fuv){
        for(boolean parameter : fuv){
            if(!parameter){
                return false;
            }
        }
        return true;
    }


    
    /*
    * Decides if missile should be launched based on the input parameters, points, LCM and PUV.
    * @return whether or not the missile should be launched
    */
    public boolean decide(){
        boolean[] cmv = new CMV(POINTS.length, POINTS, PARAMETERS).getCMV();
        boolean[][] pum = new PUM(LCM, cmv).get();
        boolean[] fuv = new FUV(PUV, pum).get();
        return launch(fuv);
    }
    

    public static void main(String args[]){

        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(1, 3);
        Point p4 = new Point(1, 4);
        Point p5 = new Point(1, 5);
        Point p6 = new Point(2, 1);
        Point p7 = new Point(3, 1);
        Point p8 = new Point(4, 1);
        Point p9 = new Point(5, 1);
        Point p10 = new Point(6, 1);
        Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};

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

        Parameters parameters = new Parameters();

        MissileSystem system = new MissileSystem(points.length, points, lcm, puv, parameters);

        system.decide();
    }

}