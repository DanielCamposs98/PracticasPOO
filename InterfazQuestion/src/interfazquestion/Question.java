package interfazquestion;


import java.util.Random;

public class Question implements SharedConstants {

    Random R = new Random();

    public int ask() {
        int prob = (int) (100 * R.nextDouble());
        if (prob < 30) {
            return NO;
        } else if (prob < 60) {
            return YES;
        } else if (prob < 75) {
            return LATER;
        } else if (prob < 85) {
            return SOON;
        } else {
            return NEVER;
        }
    }

}
