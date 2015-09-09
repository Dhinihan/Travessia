package data;

import java.util.List;

public class PersonSample {

    private List<SampleWalk> walkSamples;

    public PersonSample(List<SampleWalk> samples) {
        this.walkSamples = samples;
    }

    public SampleWalk getWalkSample(int index) {
        return walkSamples.get(index);
    }

    public double getAverageVelocity() {
        double velocity = 0;
        for (SampleWalk sampleWalk : walkSamples) {
            velocity += sampleWalk.getVelocity();
        }
        return velocity/walkSamples.size();
    }

    public double getAverageAcceleration() {
        double acceleration = 0;
        for (SampleWalk sampleWalk : walkSamples) {
            acceleration += sampleWalk.getAcceleration();
        }
        return acceleration/walkSamples.size();
    }
}
