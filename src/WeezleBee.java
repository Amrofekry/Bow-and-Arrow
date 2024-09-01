import ddf.minim.Minim;
import processing.core.*;
import processing.video.*;
import ddf.minim.AudioPlayer;

import processing.data.JSONObject;
import processing.event.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WeezleBee extends PApplet {
    MC mc = new MC();
    Levels levels = new Levels();
    MainMenu menu = new MainMenu();
    Mana ma = new Mana();
    Minim loader = new Minim(this);// For sound
    AudioPlayer Background, intro, preOut, out;
    JSONObject object = new JSONObject();
    JSONObject jsonObject;
    ArrayList<Spells> spells = new ArrayList<>(); // List to store spells
    ArrayList<Targets> targets = new ArrayList<>(); // List to store targets
    ArrayList<Target2> targets2 = new ArrayList<>();
    Movie video, Outro;
    int start = 0, gender, level = 0, score, i=0;
    public int flag1 = 0, flag2 = 0;// variable to track mouseDragged & mouseCLicked function
    float flag3 = 0, spY;//variable to track mouseWheel function
    boolean x = true, skip = false ,skip1 = false, skip2 = false;
    PImage landscape1, parch, landscape2, landscape3, landscape4,landscape5, levle2, mmc1, mmc2, fmc1, fmc2, target1, target2, spell1, pre, instructions, mt, outro, finalscore, button1, button2;


    public static void main(String[] args) {
        PApplet.main("WeezleBee");
    }

    public void settings() {
        size(900, 700, P2D);
         smooth(100);// Draws all geometry with smooth (anti-aliased) edges
    }

    public void setup() {
        video = new Movie(this, "pics/XiaoYing_Video_1713429266457_HD.mp4");
        video.play();
        Outro = new Movie(this,"pics/lv_0_20240420204649.mp4");
        landscape1 = loadImage("pics\\wallpaperflare.com_wallpaper.jpg");
        parch = loadImage("pics\\1712674803026.png");
        landscape2 = loadImage("pics\\IMG-20240409-WA0018.jpg");
        landscape3 = loadImage("pics/wallpaperflare.com_wallpaper (6).jpg");
        landscape4 = loadImage("pics/9803ae1857931b10cc1b3f5f7817b430.jpg");
        landscape5= loadImage("pics/Picsart_24-04-20_10-56-36-398.jpg");
        levle2 = loadImage("pics/3d597879868753bb32ff79bf6eb328ef.jpg");
        pre = loadImage("pics/Picsart_24-04-11_10-27-09-026.png");
        mmc1 = loadImage("pics/1712144387028.png");
        fmc1 = loadImage("pics/1712144378552.png");
        mmc2 = loadImage("pics/1712592087333.png");
        fmc2 = loadImage("pics/1712739346308.png");
        target2 = loadImage("pics/Picsart_24-04-11_00-54-56-942.png");
        target1 = loadImage("pics/target1.png");
        spell1 = loadImage("pics/IMG_20240411_012551.png");
        instructions = loadImage("pics/Picsart_24-04-19_21-02-40-736.png");
        mt = loadImage("pics/empty.png");
        finalscore = loadImage("pics/Picsart_24-04-22_07-37-52-134.jpg");
        outro= loadImage("pics/5afc0960b06d4a677ae63108cb99e0fa.jpg");
        button1 = loadImage("pics/IMG_20240420_224116.png");
        button2 = loadImage("pics/IMG_20240420_224135.png");
        Background = loader.loadFile("pics/Hedwig_s Theme(MP3_160K).mp3");
        intro = loader.loadFile("pics/intro.mp3");
        preOut = loader.loadFile("pics/HD Dumbledore_s _Happiness can be found_ even in the darkest of times.._ clip(MP3_160K).mp3");
        out = loader.loadFile("pics/outro.mp3");
        jsonObject = loadJSONObject("json\\user.json");
        for (int i = 0; i < 10; i++) {
            Targets newTarget = new Targets(1, this, target1, i);
            targets.add(newTarget);
        }
        for (int i = 0; i < 10; i++) {
            Target2 newTarget = new Target2(this, target2);
            targets2.add(newTarget);
        }

    }

    public void draw() {
        if (x) {
            switch (start) {
                case 0:
                    image(video,0,0);
                    intro.play();
                   if (video.time() > 16){
                      intro.close();
                       video.stop();
                        start = 1;
                    }
                    break;
                case 1:
                    Background.play();
                    background(landscape1);
                    menu.menu(this, parch, button1);
                    if (mouseX >= 360 && mouseX <= 560 && mouseY >= 225 && mouseY <= 260 && mousePressed) {
                        start = 2;
                    }
                    if (mouseX >= 350 && mouseX <= 550 && mouseY >= 300 && mouseY <= 350 && mousePressed) {
                        start = 3;
                    }
                    break;
                case 2:
                    if (gender == 0) {
                        background(landscape2);
                        menu.gender(this, button2);
                        if (mouseX >= 250 && mouseX <= 450 && mouseY >= 625 && mouseY <= 675 && mousePressed) {
                            gender = 1;
                            x = false;
                        }

                        if (mouseX >= 500 && mouseX <= 700 && mouseY >= 625 && mouseY <= 675 && mousePressed) {
                            gender = 2;
                            x = false;
                        }
                    }
                    try {
                        object.put("gender", gender);
                        object.put("score", score);
                        FileWriter file = new FileWriter("json\\user.json", false);
                        file.write(object.toString());
                        file.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    if (jsonObject.size() != 0) {
                        level = jsonObject.getInt("level");
                        gender = jsonObject.getInt("gender");
                        score = jsonObject.getInt("score");
                        if (level ==2) {
                            targets.clear();
                            for (int i = 0; i < 20; i++) {
                                Targets newTarget = new Targets(2, this, target1, i);
                                targets.add(newTarget);
                            }
                        }
                        x = false;
                    } else if (jsonObject.size() == 0) {
                        if (gender == 0) {
                            background(landscape2);
                            menu.gender(this, button2);
                            if (mouseX >= 250 && mouseX <= 450 && mouseY >= 625 && mouseY <= 675 && mousePressed) {
                                gender = 1;
                            }

                            if (mouseX >= 500 && mouseX <= 700 && mouseY >= 625 && mouseY <= 675 && mousePressed) {
                                gender = 2;
                            }
                        }
                        try {
                            object.put("gender", gender);
                            object.put("level", level);
                            object.put("score", score);
                            FileWriter file = new FileWriter("json\\user.json", false);
                            file.write(object.toString());
                            file.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        x = false;
                    }
                    break;
                default:
                    break;
            }
        } else {
            switch (level) {
                case 0:
                    level = levels.pre(this, landscape3, pre, instructions);
                    try {
                        object.put("level", level);
                        FileWriter file = new FileWriter("json\\user.json", false);
                        file.write(object.toString());
                        file.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 1:
                    level = levels.level1(this, mc, parch, gender, flag3, landscape4, mmc1, mmc2, fmc1, fmc2, spell1, spells, targets, spY, mt);
                    flag1 = 0;// returning flag used to track mouseDragged function to 0
                    flag2 = 0;// returning flag used to track mouseClicked function to 0
                    if(level == 2) {
                        Spells.getNumberOfSpells(0);
                        spells.clear();
                        for (int i = 0; i < 20; i++) {
                            Targets newTarget = new Targets(2,this, target1, i);
                            targets.add(newTarget);
                        }
                        try {
                            object.put("gender", gender);
                            object.put("level", level);
                            object.put("score", levels.score1);
                            FileWriter file = new FileWriter("json\\user.json", false);
                            file.write(object.toString());
                            file.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;
                case 2:
                    level = levels.level2(this, mc, parch, gender, flag3, levle2, mmc1, mmc2, fmc1, fmc2, target2, spell1, spells, targets, targets2 , spY, target1, mt);
                    score = levels.score1 + levels.score2;

                    try {
                        object.put("level", level);
                        object.put("finalScore", score);
                        object.put("score2", levels.score2);
                        FileWriter file = new FileWriter("json\\user.json", false);
                        file.write(object.toString());
                        file.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    switch (i){
                        case 0:
                            background(finalscore);
                            text(score, 750, 350);
                            if (keyPressed && skip){
                                i++;
                            }
                            skip = true;
                        case 1:
                            background(landscape5);
                            if (keyPressed && skip1){
                                i++;
                            }
                            skip1 = true;
                            break;
                        case 2:
                            Background.close();
                            preOut.play();
                            background(outro);
                            if (keyPressed && skip2){
                                preOut.close();
                                i++;
                            }
                            delay(100);
                            skip2 = true;
                            break;
                        case 3:
                            level = 4;
                            break;
                    }
                        break;
                case 4:
                    Outro.play();
                    out.play();
                    image(Outro, 0, 0, 900, 700);
                    if(Outro.time() >6) {
                        out.close();
                        exit();
                    }
            }
        }
    }

    public void mousePressed() {
        if (level == 1 || level == 2) {
            if (mouseButton == LEFT) {
                // Create a new Spells object and add it to the spells ArrayList when mouse is pressed
                if (mouseX > 150 && ma.mana > 0 && Spells.getNumberOfSpells(1) < 20) { // Ensure spells are not created when clicking on the menu or buttons
                    Spells newSpell = new Spells(0, mc.CharachterY); // Adjust the initial position as needed
                    spells.add(newSpell);
                    ma.manaLose();
                    spY = mc.CharachterY;
                }
            } else if (mouseButton == RIGHT) {
                // Reset mana to 100 when right mouse button is pressed
                ma.mana = ma.mana_Max;
            }

        }
    }
    public void movieEvent(Movie movie){
        movie.read();
    }
    public void keyReleased()
    {
        levels.skip = true;
    }
    public void mouseDragged() {
        flag1 = 1;
    }

    public void mouseClicked() {
        flag2 = 1;
    }

    public void mouseWheel(MouseEvent event) {
        flag3 = event.getCount();
    }
}
