package simulation;

import java.util.Random;

public class ConstantAnimator extends Animator {

    private int speed;
    private int accumulated;

    public ConstantAnimator(double speed) {
        this.setSpeed(speed);
    }

    @Override
    public int getNextMotion(int count) {
        if(count == 0) accumulated = 0;
        int motion = speed/40;
        int odds = 40 - (speed%40 - accumulated) - count;
        Random generator = new Random();
        if(generator.nextInt(40-count) >= odds){
            motion++;
            accumulated++;
        }
        System.out.println("round: " + (40-count));
        System.out.println("    odds = " + odds);
        System.out.println("    motion = " + motion);
        return motion;
    }

    public Animator setSpeed(double speed) {
        this.speed = (int) Math.round(speed*100);
        return this;
    }

    public Animator setAcceleration(double acceleration) {
        return this;
    }
}
