import processing.core.*;

import java.util.ArrayList;

public class Levels {
    PFont font;
    int level, spell, spell1, score1, score2, totalHits = 0, totalHits2 = 0, j = 0;
    float spll;
    boolean skip = false;

    public int pre(PApplet p, PImage pre, PImage dialogue, PImage inst) {
        switch (j) {
            case 0:
                p.background(pre);
                p.image(dialogue, 150, 50, 600, 550);
                font = p.createFont("Arial", 16, true);
                p.textFont(font);

                p.textAlign(p.CENTER, p.CENTER);
                p.fill(0, 102, 204); // Ocean blue text
                p.text("Press any key to continue", 450, 680);
                if (p.keyPressed) {
                    j++;
                }
                break;
            case 1:
                p.background(pre);
                p.image(inst, 150, 50, 600, 550);
                font = p.createFont("Arial", 16, true);
                p.textFont(font);

                p.textAlign(p.CENTER, p.CENTER);
                p.fill(0, 102, 204); // Ocean blue text
                p.text("Press any key to continue", 450, 680);
                if (p.keyPressed && skip) {
                    j++;
                }
                break;
            case 2:
                level = 1;
                break;
        }
        return level;
    }

    public int level1(PApplet p, MC mc, PImage parch, int gender, float flag3, PImage landscape, PImage mmc1, PImage mmc2, PImage fmc1, PImage fmc2, PImage sp1, ArrayList<Spells> spells, ArrayList<Targets> targets, float spY, PImage mt) {
        if (level != 2){
            level = 1;
        }
        if (totalHits < 10) {
            p.image(landscape, 0, 0, 900, 700);
            p.stroke(0);
            p.line(151, 0, 151, 700);
            p.text("Spells Shot:", 750, 50);// Showing number of spells shot
            p.text(Spells.getNumberOfSpells(1), 850, 50);

            for (Spells spell : spells) {
                PImage spellImage = spell.spellShoot(p, sp1); // Get the spell image
                if (spellImage != null) {
                    p.image(spellImage, spell.spX + 50, spell.spY + 30, 150, 50); // Draw the spell image
                    spll = spell.spellMove();// Move the spell
                }
            }
            p.image(mc.GenderSelect(p, gender, mmc1, fmc1, mt), 0, mc.CharachterY, 150, 150);
            mc.MoveCharacter(p, flag3);
            p.image(mc.CharacterShoot(p, gender, mmc2, fmc2), 0, mc.CharachterY, 150, 150);

            for (int i=0; i< targets.size(); i++ ) {

                targets.get(i).moveTarget();
                targets.get(i).showTarget(spll, spY, targets);

                totalHits = Targets.Trspll;
            }

            spell = Spells.getNumberOfSpells(1);


        } else if (p.keyPressed) {
            totalHits2 = 0;
            level = 2;
        } else if (totalHits == 10 || spell == 20) { // Level1 Ended
            p.image(landscape, 0, 0, 900, 700);
            p.image(parch, 150, 60, 600, 550);
            score1 = totalHits * 10 + (20 - spell) * 10;
            Spells.getNumberOfSpells(0);
            p.fill(250, 250, 0);
            p.rect(350, 260, 200, 50, 20);
            p.fill(0, 50, 200);
            p.textSize(30);
            p.text("Score:", 430, 280);
            p.text(score1, 510, 280);
// Grades
            if (score1 <= 300 && score1 >= 270) {
                p.text("Outstanding!", 460, 360);
            } else if (score1 < 270 && score1 >= 240) {
                p.text("Exceeds Expectations!", 450, 360);
            } else if (score1 < 240 && score1 >= 200) {
                p.text("Acceptable!", 460, 360);
            } else if (score1 < 200 && score1 >= 170) {
                p.text("Poor!", 460, 360);
            } else if (score1 < 170 && score1 >= 140) {
                p.text("Dreadful!", 460, 360);
            } else if (score1 < 140) {
                p.text("Troll!", 460, 360);
            }
        }
        return level;
    }

    public int level2(PApplet p, MC mc, PImage parch, int gender, float flag3, PImage landscape, PImage mmc1, PImage mmc2, PImage fmc1, PImage fmc2, PImage tr2, PImage sp1, ArrayList<Spells> spells, ArrayList<Targets> targets, ArrayList<Target2> targets2, float spY, PImage tr1, PImage mt) {
        if (level != 3){
            level = 2;
        }
        if (totalHits2 < 15) {
            p.image(landscape, 0, 0, 900, 700);
            p.stroke(0);
            p.line(151, 0, 151, 700);
            p.text("Spells Shot:", 750, 50);// Showing number of spells shot
            p.text(Spells.getNumberOfSpells(1), 850, 50);

            for (Spells spell : spells) {
                PImage spellImage = spell.spellShoot(p, sp1); // Get the spell image
                if (spellImage != null) {
                    p.image(spellImage, spell.spX + 50, spell.spY + 30, 150, 50); // Draw the spell image
                    spll = spell.spellMove(); // Move the spell
                }
            }
            p.image(mc.GenderSelect(p ,gender, mmc1, fmc1, mt), 0, mc.CharachterY, 150, 150);
            mc.MoveCharacter(p, flag3);
            p.image(mc.CharacterShoot(p, gender, mmc2, fmc2), 0, mc.CharachterY, 150, 150);


            for (int i =0; i < 6; i++) {
                targets.get(i).showTarget2(spll, spY, targets);
                targets.get(i).moveTarget2();
            }
            for (int i =0; i < 4; i++) {

                targets2.get(i).showTarget2(spll, spY, targets2);
                targets2.get(i).moveTarget2();

            }
            spell1 = Spells.getNumberOfSpells(1);
            totalHits2 = Target2.Trspll2 + Targets.Trspll2;


        } else if (p.keyPressed && level == 2) {
            level = 3;
        } else if (totalHits2 == 15 || spell1 ==20) {// Level1 Ended
            p.image(landscape, 0, 0, 900, 700);
            p.image(parch, 150, 50, 600, 550);
            score2 = totalHits2 * 10 + (21 - spell) * 10;
            p.fill(250, 250, 0);
            p.rect(350, 260, 200, 50, 20);
            p.fill(0, 50, 200);
            p.textSize(30);
            p.text("Score:", 430, 280);
            p.text(score2, 510, 280);
            // Grades
            if (score2 <= 400 && score2 >= 370) {
                p.text("Outstanding!", 460, 360);
            } else if (score2 < 370 && score2 >= 340) {
                p.text("Exceeds Expectations!", 450, 360);
            } else if (score2 < 340 && score2 >= 300) {
                p.text("Acceptable!", 460, 360);
            } else if (score2 < 300 && score2 >= 270) {
                p.text("Poor!", 460, 360);
            } else if (score2 < 270 && score2 >= 240) {
                p.text("Dreadful!", 460, 360);
            } else if (score2 < 240) {
                p.text("Troll!", 460, 360);
            }
        }

        return level;
    }

}