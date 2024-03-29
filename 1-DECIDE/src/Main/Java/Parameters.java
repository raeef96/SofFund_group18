package src.Main.Java;

public class Parameters {
    //All variables and their default values
    public double LENGTH1 = 1;
    public double RADIUS1 = 1;
    public double EPSILON = 1;
    public double AREA1 = 1;
    public int Q_PTS = 2;
    public int QUADS = 2;
    public int DIST = 1;
    public int N_PTS = 3;
    public int K_PTS = 1;
    public int A_PTS = 1;
    public int B_PTS = 1;
    public int C_PTS = 1;
    public int D_PTS = 1;
    public int E_PTS = 1;
    public int F_PTS = 1;
    public int G_PTS = 1;
    public int LENGTH2 = 1;
    public int RADIUS2 = 1;
    public int AREA2 = 1;


    /*
     * Create a parameter object with the default values of all variables
     */
    public Parameters(){}

    /*
     * Create a parameter object specifying the value of all variables
     */
    public Parameters(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int Q_PTS, int QUADS, int DIST, int N_PTS, int K_PTS, int A_PTS, int B_PTS, int C_PTS, int D_PTS, int E_PTS, int F_PTS, int G_PTS, int LENGTH2, int RADIUS2, int AREA2){
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.EPSILON = EPSILON;
        this.AREA1 = AREA1;
        this.Q_PTS = Q_PTS;
        this.QUADS = QUADS;
        this.DIST = DIST;
        this.N_PTS = N_PTS;
        this.K_PTS = K_PTS;
        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.C_PTS = C_PTS;
        this.D_PTS = D_PTS;
        this.E_PTS = E_PTS;
        this.F_PTS = F_PTS;
        this.G_PTS = G_PTS;
        this.LENGTH2 = LENGTH2;
        this.RADIUS2 = RADIUS2;
        this.AREA2 = AREA2;
    }
    
}
