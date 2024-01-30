package src;

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

    public boolean[] calculateCMV(){

        return false;
    }

    public boolean[][] calculatePUM(){
        return false;
    }

    public boolean[] calculateFUV(){
        return false;
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
    * Decides whether or not the missile should be launched based on the input
    * @return whether or not the missile should be launched
    */
    public boolean decide(){
        boolean[] CMV = calculateCMV();
        PUM pum = new PUM(LCM, CMV);

        FUV fuv = new FUV(PUV, pum.get());
        return launch(fuv.get());
    }

    

}