package data.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import data.SampleWalk;

public class SampleWalkTest {

    private double data[][];
    
    public SampleWalkTest() {
        double data[][] = {{0, 1.1, 1.95, 3.06}, 
                           {1, 1.07, 1.75, 2.1}, 
                           {0, 2.1, 3.8, 5.5},
                           {1, 1.9, 2.9, 3.45}};
        
        this.data = data;
    }
    
    @Test
    public void dataAccessTest() {
        SampleWalk amostra = createSample(0);
        Assert.assertEquals(1.1, amostra.getFirstMark(), 0.01);
        Assert.assertEquals(1.95, amostra.getSecondMark(), 0.01);
        Assert.assertEquals(3.06, amostra.getThirdMark(), 0.01);
        amostra = createSample(1);
        Assert.assertEquals(1.07, amostra.getFirstMark(), 0.01);
        Assert.assertEquals(1.75, amostra.getSecondMark(), 0.01);
        Assert.assertEquals(2.1, amostra.getThirdMark(), 0.01);
    }
    
    @Test
    public void typeAccessTest() {
        SampleWalk amostra = createSample(0);
        Assert.assertTrue(amostra.isUniform());
        amostra = createSample(1);
        Assert.assertFalse(amostra.isUniform());
    }
    
    @Test
    public void velocityTest() {
        SampleWalk amostra = createSample(0);
        Assert.assertEquals(1.943, amostra.getVelocity(), 0.001);
        amostra = createSample(2);
        Assert.assertEquals(1.032, amostra.getVelocity(), 0.001);
        amostra = createSample(1);
        Assert.assertEquals(0.0, amostra.getVelocity(), 0.001);
    }
    
    @Test
    public void accelerationTest() {
        SampleWalk amostra = createSample(1);
        Assert.assertEquals(2.942, amostra.getAcceleration(), 0.001);
        amostra = createSample(3);
        Assert.assertEquals(1.022, amostra.getAcceleration(), 0.001);
        amostra = createSample(0);
        Assert.assertEquals(0.0, amostra.getAcceleration(), 0.001);
    }

    private SampleWalk createSample(int dataIndex) {
        List<Double> list = new ArrayList<Double>();
        for (double n : data[dataIndex])
            list.add(n);
        return new SampleWalk(list);
    }
}
