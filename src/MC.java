import processing.core.*;

public class MC {
    PImage Charachter;
    float CharachterY;

    PImage GenderSelect(PApplet mc ,int gender, PImage wizard, PImage witch, PImage mt) {
        if (gender == 1)
            Charachter = wizard;// First picture of Wizard
        else if (gender == 2)
            Charachter = witch;// First picture of Witch
        if (mc.mousePressed) {
                Charachter = mt;
        }
        return Charachter;
    }

    PImage CharacterShoot(PApplet mc, int gender, PImage wizard, PImage witch) {
        if (mc.mousePressed) {
            if (gender == 1 && mc.mouseX > 150)
                Charachter = wizard;// Second picture of Wizard
            else if (gender == 2 && mc.mouseX > 150)
                Charachter = witch;// Second picture of Wizard Witch
        }
        return Charachter;
    }

    void MoveCharacter(PApplet mc, float flag) {
        if (flag > 0 && CharachterY > 0) {
            CharachterY -= 5;
        } else if (flag < 0 && CharachterY < mc.height) {
            CharachterY += 5;
        }
    }
}