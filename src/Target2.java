import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;

public class Target2 {

    PApplet pApplet;
    Random random = new Random();
    PImage target2;

    float trX, trY;
    float acceleration = 0;
    boolean trVis = true, trVis2 = true;
    static int Trspll2 = 0;

    Target2(PApplet pApplet, PImage tr2) {
        this.pApplet = pApplet;
        target2 = tr2;
        this.trY = random.nextFloat(700, 1000);
        this.trX = random.nextFloat(155, 850);


    }
    void showTarget2(float spellX, float spellY, ArrayList<Target2> targets2) {
        // Check if the target is outside the desired range
        if (spellX + 150 >= trX && spellX <= trX + 100 && spellY + 50 >= trY && spellY <= trY + 50) {
            trVis = false;
            targets2.remove(this);
            Trspll2++;        // number of target hit the spell

        }
        else{
            this.pApplet.image(target2, trX, trY, 100, 100);
        }
        // Load the target image only if it's visible
    }
    void moveTarget2() {
        if (trVis2 && trY >= -100) {
            // Decrease speed for even indices
            trY -= (float) (0.1)*(acceleration += (float) 0.05);
        } else if (trY <= -100) {
            trY -=  random.nextFloat(700, 1000);
        }
    }
}