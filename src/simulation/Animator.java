package simulation;

public abstract class Animator {

    public static Animator create(double speed, double acceleration) {
        if(acceleration ==0)
            return new ConstantAnimator(speed);
        return new AcceleratedAnimator(speed, acceleration);
    }

    public abstract int getNextMotion(int count);

    public abstract Animator setSpeed(double speed);

    public abstract Animator setAcceleration(double acceleration);

}
