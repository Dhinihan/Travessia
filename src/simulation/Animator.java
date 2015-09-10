package simulation;

public abstract class Animator {

    private static int n = 3;

    public static Animator create(double speed, double acceleration) {
        if(acceleration ==0)
            return new ConstantAnimator(speed);
        return new AcceleratedAnimator(speed, acceleration);
    }

    public abstract int getNextMotion(int count);

    public abstract Animator setSpeed(double speed);

    public abstract Animator setAcceleration(double acceleration);

    public static double meterToPixels() {
        return 300.0/n;
    }
    
    public static void defineNumberOfMarks(int numberOfMarks) {
        n = numberOfMarks;
    }

}
