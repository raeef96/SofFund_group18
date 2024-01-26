public class FUV {
    private boolean[] fuv = new boolean[size];
    
    //Generates the Final Unlocking Vector
    public FUV(boolean[] PUV, boolean[][] PUM) {
        boolean invalid_row = false;
        for(int i = 0; i < 15; i++) {
            if(PUV[i] == false) {
                fuv[i] = true;
            }
            //Checks if all values are true in row i of PUM
            else {
                for(int j = 0; j < 15; j++) {
                    if(PUM[i][j] == false) {
                        invalid_row = true;
                        break;
                    }
                }
                if(invalid_row) {
                    fuv[i] = false;
                    invalid_row = false;
                }
                else {
                    fuv[i] = true;
                }
            }
        }
    }

    //Accessing the elements
    public boolean at(int i) {
        return this.fuv[i];
    }
}