import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GamePanel extends JPanel {

    Graphics2D g2D;
    ImageIcon stop;
    Image dice;
    Image icono;
    Image animatedDice;
    ImageIcon dice1;
    ImageIcon dice2;
    ImageIcon dice3;
    ImageIcon dice4;
    ImageIcon dice5;
    ImageIcon dice6;
    Image personBlue;

    int actualXPosition = 5;
    int actualYPosition = 150;
    int counterPositions = -1;
    Audio audioClips = new Audio();


    GamePanel() {

        icono = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/icono.png"))).getImage();
        animatedDice = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/dice.gif"))).getImage();
        dice1 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/d1.png")));
        dice2 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/d2.png")));
        dice3 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/d3.png")));
        dice4 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/d4.png")));
        dice5 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/d5.png")));
        dice6 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/d6.png")));
        stop = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/stop.png")));
        personBlue = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/piece_blue.png"))).getImage();
        dice = animatedDice;
        this.setPreferredSize(new Dimension(500, 650));
    }


    public void paint(Graphics g) {

        super.paint(g);
        g2D = (Graphics2D) g;
        var x = 60;
        var y = 120;
        for (int i = 0; i < 5; i++) {
            g2D.setPaint(Color.blue);
            g2D.fillRect(x, y, 50, 100);
            x += 60;
        }
        y += 100;
        for (int i = 0; i < 5; i++) {
            g2D.setPaint(Color.green);
            g2D.fillRect(x, y, 100, 50);
            y += 60;
        }
        x = 300;
        for (int i = 0; i < 5; i++) {
            g2D.setPaint(Color.pink);
            g2D.fillRect(x, y, 50, 100);
            x -= 60;
        }
        g2D.drawImage(icono, 120, 270, this);
        g2D.drawImage(personBlue, actualXPosition, actualYPosition, this);
        g2D.setFont(new Font("Ink Free", Font.BOLD, 50));
        g2D.drawString("Pulsa ->", 0, 60);

    }

    public ImageIcon ImageOfDice(int number) {
        counterPositions += number;
        if (counterPositions > Game.arrayXPosition.size() || counterPositions > Game.arrayYPosition.size()) {
            System.out.println("HA GANADO..");
            actualXPosition = Game.arrayXPosition.get(14);
            actualYPosition = Game.arrayYPosition.get(14);
            audioClips.playAudioClip("/audio/bell.wav");
            return stop;
        } else {
            audioClips.playAudioClip("/audio/pops.wav");
            actualXPosition = Game.arrayXPosition.get(counterPositions);
            actualYPosition = Game.arrayYPosition.get(counterPositions);
        }

        switch (number) {
            case 1:
                return dice1;
            case 2:
                return dice2;
            case 3:
                return dice3;
            case 4:
                return dice4;
            case 5:
                return dice5;
            case 6:
                return dice6;
            default:
                return stop;
        }
    }
}
