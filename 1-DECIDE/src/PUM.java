<<<<<<< HEAD:1-DECIDE/src/PUM.java
package src;

public class PUM {
    private boolean[][] pum = new boolean[15][15];
    public PUM(int[][] LCM, boolean[] CMV) {
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                //PUM conditions for NOTUSED
                if(LCM[i][j] == 0) { //Value for NOTUSED might need to change
                    pum[i][j] = true;
                }
                //PUM conditions for ANDD
                else if(LCM[i][j] == 1) { //Value for ANDD might need to change
                    if(CMV[i] == true && CMV[j] == true) {
                        pum[i][j] = true;
                    }
                    else {
                        pum[i][j] = false;
                    }
                }
                //PUM conditions for ORR
                else if(LCM[i][j] == 2) { //Value for ORR might need to change
                    if(CMV[i] == true || CMV[j] == true) {
                        pum[i][j] = true;
                    }
                    else {
                        pum[i][j] = false;
                    }
                }
            }
        }
    }

    public boolean at(int y, int x) {
        return this.pum[y][x];
    }
=======
public class PUM {
    private boolean[][] pum = new boolean[15][15];
    public PUM(int[][] LCM, boolean[] CMV) {
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                //PUM conditions for NOTUSED
                if(LCM[i][j] == 0) { //Value for NOTUSED might need to change
                    pum[i][j] = true;
                }
                //PUM conditions for ANDD
                else if(LCM[i][j] == 1) { //Value for ANDD might need to change
                    if(CMV[i] == true && CMV[j] == true) {
                        pum[i][j] = true;
                    }
                    else {
                        pum[i][j] = false;
                    }
                }
                //PUM conditions for ORR
                else if(LCM[i][j] == 2) { //Value for ORR might need to change
                    if(CMV[i] == true || CMV[j] == true) {
                        pum[i][j] = true;
                    }
                    else {
                        pum[i][j] = false;
                    }
                }
            }
        }
    }

    public boolean at(int y, int x) {
        return this.pum[y][x];
    }

    public boolean[][] get(){
        return this.pum;
    }
>>>>>>> main:1-DECIDE/PUM.java
}