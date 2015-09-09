package data;

import java.util.List;

public class SampleWalk {

    private double firstMark;
    private double secondMark;
    private double thirdMark;
    private boolean uniform;

    public SampleWalk(List<Double> list) {
        this.uniform = list.get(0) < 0.5;
        this.firstMark = list.get(1);
        this.secondMark = list.get(2);
        this.thirdMark = list.get(3);
    }

    public double getFirstMark() {
        return firstMark;
    }
    
    public double getSecondMark() {
        return secondMark;
    }

    public double getThirdMark() {
        return thirdMark;
    }

    public boolean isUniform() {
        return uniform;
    }

    public double getVelocity() {
        if(uniform)
            return uniformVelocity();
        return 0;
    }

    /* v = x/t */
    private double uniformVelocity() {
        double constantVelocity = 0;
        constantVelocity += 2 / firstMark;
        constantVelocity += 4 / secondMark;
        constantVelocity += 6 / thirdMark;
        return constantVelocity / 3;
    }

    public double getAcceleration() {
        if(uniform)    
            return 0;
        return constantAcceleration();
    }
    /* a = 2*x/t^2 */
    private double constantAcceleration() {
        double constantAcceleration = 0;
        constantAcceleration += 2*2 / (firstMark*firstMark);
        constantAcceleration += 2*4 / (secondMark*secondMark);
        constantAcceleration += 2*6 / (thirdMark*thirdMark);
        return constantAcceleration / 3;
    }
}