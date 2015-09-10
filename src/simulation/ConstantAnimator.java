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
        return motion;
    }

    public Animator setSpeed(double speed) {
        this.speed = (int) Math.round(speed*Animator.meterToPixels());
        return this;
    }

    public Animator setAcceleration(double acceleration) {
        return this;
    }
}
