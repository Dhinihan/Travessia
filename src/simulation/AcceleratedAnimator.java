package simulation;

public class AcceleratedAnimator extends ConstantAnimator {

    private double acceleration;
    private double speed;

    public AcceleratedAnimator(double speed, double acceleration) {
        super(speed);
        this.speed = speed;
        this.acceleration = acceleration; 
    }

    @Override
    public int getNextMotion(int count) {
        this.speed += acceleration*Animator.meterToPixels()/40;
        return (int) Math.round(this.speed/40);
    }
    
    public Animator setAcceleration(double acceleration){
        this.acceleration = acceleration;
        return this;
    }
    
    public Animator setSpeed(double speed){
        this.speed = speed;
        return this;
    }
}
