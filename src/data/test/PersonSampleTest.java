package data.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import data.PersonSample;
import data.SampleWalk;

public class PersonSampleTest {
 
    private List<SampleWalk> uniformSamples;
    private List<SampleWalk> acceleratedSamples;

    public PersonSampleTest() {
        
        double uniformData[][] = {{0, 1.17, 2.67, 4.51},
                                  {0, 1.32, 2.08, 3.91},
                                  {0, 1.63, 3.01, 4.4},
                                  {0, 1.42, 2.72, 4.34},
                                  {0, 1.58, 3, 4.53}};
        
        double acceleratedData[][] = {{1, 1.37, 2.61, 3.41},
                                      {1, 1.78, 2.45, 3.37},
                                      {1, 1.71, 2.56, 3.53},
                                      {1, 1.71, 2.78, 3.25},
                                      {1, 1.5, 2.54, 3.01}};
        
        this.uniformSamples = createSampleCollection(uniformData);
        this.acceleratedSamples = createSampleCollection(acceleratedData);
    }
    
    @Test
    public void AccessTest() {
        PersonSample sample = new PersonSample(this.uniformSamples);
        Assert.assertEquals(uniformSamples.get(3), sample.getWalkSample(3));
        Assert.assertEquals(uniformSamples.get(1), sample.getWalkSample(1));
    }
    
    @Test
    public void VelocityTest() {
        PersonSample sample = new PersonSample(this.uniformSamples);
        Assert.assertEquals(1.441, sample.getAverageVelocity(), 0.001);
        sample = new PersonSample(this.acceleratedSamples);
        Assert.assertEquals(0, sample.getAverageVelocity(), 0.001);
    }
    
    @Test
    public void AccelerationTest() {
        PersonSample sample = new PersonSample(this.acceleratedSamples);
        Assert.assertEquals(1.295, sample.getAverageAcceleration(), 0.001);
        sample = new PersonSample(this.uniformSamples);
        Assert.assertEquals(0, sample.getAverageAcceleration(), 0.001);
    }

    private List<SampleWalk> createSampleCollection(double[][] data) {
        
        List<SampleWalk> uniformSamples = new ArrayList<SampleWalk>();
        for (double[] sample : data){
            ArrayList<Double> list = new ArrayList<Double>();
            for (double n : sample)
                list.add(n);
            uniformSamples.add(new SampleWalk(list));
        }
        return uniformSamples;
    }
}
