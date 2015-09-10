package data;


public class AverageSample implements Sample {

    private double speed;
    private double acceleration;
    private String nome;

    public AverageSample(double speed, double acceleration, String nome) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.nome = nome;
    }

    @Override
    public double getAverageVelocity() {
        return speed;
    }

    @Override
    public double getAverageAcceleration() {
        return acceleration;
    }
    
    @Override
    public String toString() {
        return nome;
    }

}
