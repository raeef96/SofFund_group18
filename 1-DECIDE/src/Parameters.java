package src;

public class Parameters {

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

    public Parameters(){
        LENGTH1 = 1;
        RADIUS1 = 1;
        EPSILON = 1;
        AREA1 = 1;
        Q_PTS = 2;
        QUADS = 2;
        DIST = 1;
        N_PTS = 3;
        K_PTS = 1;
        A_PTS = 1;
        B_PTS = 1;
        C_PTS = 1;
        D_PTS = 1;
        E_PTS = 1;
        F_PTS = 1;
        G_PTS = 1;
        LENGTH2 = 1;
        RADIUS2 = 1;
        AREA2 = 1;
    }
    
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
