package test.pum_tests;
import src.CMV;
import src.PUM;
import src.FUV;
import src.MissileSystem;
import src.Parameters;
import src.Point;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

     /*
     * Tests for PUM
     */

     @Test
     public void calculatePUMtest(){
         //LCM & CMV needed
         boolean[] cmv = new boolean[15];
         cmv[1] = true; 
         cmv[12] = true;
 
         int[][] lcm = {
             {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         };
 
         boolean[][] expected = new boolean[15][15];
         expected[1][2] = true;
         expected[2][1] = true;
         expected[1][1] = true;
         expected[1][0] = true;
         expected[0][1] = true;
         expected[12][12] = true;
         expected[1][12] = true;
         expected[12][1] = true;
         assertArrayEquals(new PUM(lcm,cmv).get() , expected);
     }
 
 
    
    
}
