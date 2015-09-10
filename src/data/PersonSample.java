package data;

import java.util.List;

public class PersonSample implements Sample{

    private List<SampleWalk> walkSamples;
    private String nome;

    public PersonSample(int index, List<SampleWalk> samples) {
        this.walkSamples = samples;
        this.nome = "Pessoa " + index/2;
        if(index%2 == 0)
            this.nome += " Constante";
        else
            this.nome += " Acelerada";
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
    
    @Override
    public String toString() {
        return nome;
    }
}
