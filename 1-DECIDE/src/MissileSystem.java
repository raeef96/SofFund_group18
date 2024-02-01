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
    

}