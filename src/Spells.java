import processing.core.PApplet;
import processing.core.PImage;

public class Spells {
    PImage spell;
    float spX;
    float spY;
    private static int numberOfSpells = 0;

    Spells(float initialX, float initialY) {
        spX = initialX;
        spY = initialY;
        numberOfSpells++;
    }

    PImage spellShoot(PApplet sp, PImage spell1) {
        if (sp.mousePressed && sp.mouseX > 150) {
            spell = spell1;
        }
        return spell;
    }

    float spellMove() {
        spX += 5;
        return spX;
    }

    public static int getNumberOfSpells(int mode) {
        if (mode == 0) {
            numberOfSpells = 0;
        }
        return numberOfSpells;

    }
}