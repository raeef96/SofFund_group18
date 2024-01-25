public class MissileSystem{

    /* CONSTANTS */
    public static double PI = Math.PI;
    public static int NUMPOINTS;
    public enum Connectors {NOTUSED , ORR , ANDD}
    public static Point[] POINTS;

    public static int[][] LCM;
    public static int[] PUV;

    // parameters for the struct PARAMETERS
    public double LENGTH1;
    public double RADIUS1;
    public double EPSILON;
    public double AREA1;
    public int Q_PTS;
    public int QUADS;
    public int DIST;
    public int N_PTS;
    public int K_PTS;
    public int A_PTS;
    public int B_PTS;
    public int C_PTS;
    public int D_PTS;
    public int E_PTS;
    public int F_PTS;
    public int G_PTS;
    public int LENGTH2;
    public int RADIUS2;
    public int AREA2;
    

    public class Point{
        private int x;
        private int y;
        
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
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

    
    /*  */
    public void decide(){
        LAUNCH = true;
        /* write LAUNCH result to stdout */
    }

    public static void main(String[] args){
        //Read input data

        
    }

}