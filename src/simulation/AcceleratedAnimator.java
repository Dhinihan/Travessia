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
        this.speed += acceleration*100/40;
        System.out.println("double = " + this.speed);
        System.out.println("int = " + Math.round(this.speed));
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
