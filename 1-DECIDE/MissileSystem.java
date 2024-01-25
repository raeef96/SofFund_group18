public class MissileSystem{

    /* CONSTANTS */
    public double PI = Math.PI;
    public int NUMPOINTS;
    public enum Connectors {NOTUSED , ORR , ANDD}
    public Point[] POINTS;

    public boolean[][] LCM;
    public boolean[] PUV;
    public Parameters PARAMETERS;
    

    /* Constructor */
    public MissileSystem(int NUMPOINTS, Point[] POINTS, boolean[][] LCM, boolean[] PUV, Parameters PARAMETERS) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.LCM = LCM;
        this.PUV = PUV;
        this.PARAMETERS = PARAMETERS;
    }


    //Values to be calculated
    public boolean[] CMV;
    public boolean[][] PUM;
    public boolean[] FUV;
    public boolean LAUNCH = false;

    public boolean[] calculateCMV(){

        return false;
    }

    public boolean[][] calculatePUM(){
        return false;
    }

    public boolean[] calculateFUV(){
        return false;
    }


    
    /* decide wether to launch the missiles */
    public void decide(){
        LAUNCH = true;
        /* write LAUNCH result to stdout */
    }

    

}