package test;

import src.CMV;
import src.Parameters;
import src.Point;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLIC {

    /* There exists no set of two consecutive data points
    that are a distance greater than the length LENGTH1 = 2 apart*/
    @Test
    public void lic0TestNoConsecutiveDistanceGreaterThan2ShouldReturnFalse() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Parameters param = new Parameters();
        param.LENGTH1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic0());
    } 

    /* There exists at least one set of two consecutive data points
    that are a distance greater than the length LENGTH1 = 2 apart*/
    @Test
    public void lic0TestOneConsecutiveDistanceGreaterThan2ShouldReturnTrue() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(10, 10);
        Parameters param = new Parameters();
        param.LENGTH1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic0());
    } 

    /* The length variable should fullfill: LENGTH1 >= 0*/
    @Test
    public void lic0TestNegativeLENGTH1ShouldThrowIllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        Parameters param = new Parameters();
        param.LENGTH1 = -1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic0();} );
    } 

    /* There exists no set of three consecutive data points
    that cannot all be contained within or on a circle of radius RADIUS1 */
    @Test
    public void lic1TestThreeConsecutiveWithinRADIUS1ShouldReturnFalse() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.RADIUS1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertFalse(cmv.lic1());
    } 

    /* There exists at least one set of three consecutive data points
    that cannot all be contained within or on a circle of radius RADIUS1 */
    @Test
    public void lic1TestThreeConsecutiveCannotFitWithinRADIUS1ShouldReturnTrue() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(10, 1);
        Parameters param = new Parameters();
        param.RADIUS1 = 2;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertTrue(cmv.lic1());
    } 

    /* The parameter variable RADIUS1 >= 0 */
    @Test
    public void lic1TestNegativeRADIUS1ShouldThrowIllegalArgumentException() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(3, 1);
        Parameters param = new Parameters();
        param.RADIUS1 = -1;
        CMV cmv = new CMV(3, new Point[] { p1, p2, p3 }, param);
        
        assertThrows(IllegalArgumentException.class, () -> {cmv.lic1();} );
    } 

    @Test
    public void lic2Test() {

    } 

    @Test
    public void lic3Test() {

    } 

    @Test
    public void lic4Test() {

    } 

    @Test
    public void lic5Test() {

    } 

    @Test
    public void lic6Test() {

    } 

    @Test
    public void lic7Test() {

    } 

    @Test
    public void lic8Test() {

    } 

    @Test
    public void lic9Test() {

    } 

    @Test
    public void lic10Test() {

    } 

    @Test
    public void lic11Test() {

    } 

    @Test
    public void lic12Test() {

    } 

    @Test
    public void lic13Test() {

    } 

    @Test
    public void lic14Test() {

    } 

}
