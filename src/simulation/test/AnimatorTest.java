package simulation.test;

import org.junit.Assert;
import org.junit.Test;

import simulation.Animator;

public class AnimatorTest {

//    @Test
//    public void constantSpeedtest() {
//        int x = 0;
//        double speed = 1.63; 
//        Animator animator = Animator.create(speed, 0);
//        for(int i = 0; i < 40; i++)
//            x += animator.getNextMotion(i);
//        Assert.assertEquals(163, x);
//        x = 0;
//        animator.setSpeed(1.87);
//        for(int i = 0; i < 80; i++)
//            x += animator.getNextMotion(i%40);
//        Assert.assertEquals(187*2, x);
//        x = 0;
//        animator.setSpeed(1.98);
//        for(int i = 0; i < 120; i++)
//            x += animator.getNextMotion(i%40);
//        Assert.assertEquals(198*3, x);
//    }
    
    @Test
    public void constantAccelerationtest() {
        int x = 0;
        double acceleration = 1.19; 
        Animator animator = Animator.create(0, acceleration);
        for(int i = 0; i < 40; i++){
            x += animator.getNextMotion(i);
            System.out.println("    x = " + x);
        }
        Assert.assertTrue(x > 59*0.95);
        Assert.assertTrue(x < 59*1.05);
        x = 0;
        animator.setAcceleration(1.52).setSpeed(0);
        for(int i = 0; i < 80; i++){
            x += animator.getNextMotion(i);
            System.out.println("    x = " + x);
        }
        Assert.assertTrue(x > 304*0.95);
        Assert.assertTrue(x < 304*1.05);
        x = 0;
        animator.setAcceleration(1.77).setSpeed(0);
        for(int i = 0; i < 120; i++){
            x += animator.getNextMotion(i);
            System.out.println("    x = " + x);
        }
        Assert.assertTrue(x > 796.6*0.95);
        Assert.assertTrue(x < 796.5*1.05);
        
    }

}
