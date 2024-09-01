import processing.core.PApplet;
import processing.core.PImage;

public class MainMenu {

    public void menu(PApplet p, PImage image, PImage button1) {
        p.image(image, 150, 50, 600, 550);
        p.image(button1, 312, 210, 280, 70);
        p.textSize(20);
        p.fill(0, 50, 200);
        p.text("Start a new game", 370, 250);

        p.image(button1, 312, 285, 280, 70);
        p.textSize(20);
        p.fill(0, 50, 200);
        p.text("Load a saved game", 370, 330);
    }

    public void gender(PApplet p, PImage button2) {
        p.image(button2, 230, 615, 250, 70);
        p.textSize(20);
        p.fill(0, 50, 200);
        p.text("Wizard", 320, 655);

        p.image(button2, 480, 615, 250, 70);
        p.textSize(20);
        p.fill(0, 50, 200);
        p.text("Witch", 575, 655);

    }
}
