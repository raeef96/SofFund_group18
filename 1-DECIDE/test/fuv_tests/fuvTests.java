package test.fuv_tests;
import src.CMV;
import src.PUM;
import src.FUV;
import src.MissileSystem;
import src.Parameters;
import src.Point;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

public class fuvTests {
     /*
    * Tests for FUV
    */
    @Test
    public void calculateFUVTest(){

        /* Create a PUM (size 15x15) */
        boolean[][] PUM = new boolean[15][15];
        for (int index = 0; index < 15; index++){
            PUM[2][index] = true;
            PUM[4][index] = true;
        }
        PUM[4][14] = false;
        
        
        /* Create a PUV (size 15) */
        boolean[] PUV = {false, false, true, true, true, true, true, true, true, true, true, true, true, true, true};

        /* FUV should look like this based on PUM and PUV */
        boolean[] expectedFUV = {true, true, true, false, false, false, false, false, false, false, false, false, false, false, false};

        FUV fuvObj = new FUV(PUV, PUM);
        
        assertArrayEquals(expectedFUV, fuvObj.get());
    }

    
}
