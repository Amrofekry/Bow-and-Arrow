
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;


public class Targets {

    PApplet pApplet;
    Random random = new Random();
    float trX, trY;
    boolean trVis = true, trVis2 = true;
    static int Trspll = 0, Trspll2 = 0;
    PImage target1;
    int[] tryXArray = {200, 250, 300, 350, 400, 450, 500, 550, 600, 650};

    Targets(int level, PApplet pApplet, PImage tr1, int i) {
        this.pApplet = pApplet;
        target1 = tr1;
        if (level == 1) {
            this.trX = tryXArray[i];
            this.trY = 700;
        } else if (level == 2) {
            this.trX = random.nextFloat(155, 850);
            this.trY = random.nextFloat(700, 1000);
        }
    }

    void showTarget(float spellX, float spellY, ArrayList<Targets> targets) {
        // Check if the target is outside the desired range
        if (spellX + 150 >= trX && spellX <= trX + 100 && spellY + 50 >= trY && spellY <= trY + 50) {
            // Mark the target as hit
            Trspll++;
            targets.remove(this);
            // Remove the target from the ArrayList
            trVis = false; // Set visibility to false
        } else {
            this.pApplet.image(target1, trX, trY, 100, 100);
        }
        // Load the target image only if it's visible
    }

    void showTarget2(float spellX, float spellY, ArrayList<Targets> targets) {
        // Check if the target is outside the desired range
        if (spellX + 150 >= trX && spellX <= trX + 100 && spellY + 50 >= trY && spellY <= trY + 50) {
            trVis = false;
            targets.remove(this);
            Trspll2++;        // number of target hit the spell

        }
        else {
            this.pApplet.image(target1, trX, trY, 100, 100);
        }
        // Load the target image only if it's visible
    }

    void moveTarget() {
        // Move the target horizontally
        if (trVis && trY > -100) {
            trY -= 2;
        } else if (trY == -100) {
            trY = 700f;
        }
    }

    void moveTarget2() {
        if (trVis2 && trY >= -100) {
            trY -= 2;
        } else if (trY <= -100) {
            trY = random.nextFloat(700, 1000);
        }
    }
}