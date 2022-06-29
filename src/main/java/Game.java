import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("serial")
public class Game extends JFrame {
    GamePanel panel;
    Image icon;

    static ArrayList<Integer> arrayXPosition = new ArrayList<>();
    static ArrayList<Integer> arrayYPosition = new ArrayList<>();
    GameAudio audioClips = new GameAudio();

    public Game() {

        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/maqueta.png"))).getImage();

        panel = new GamePanel();


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("GAME-CODE");
        this.setIconImage(icon);

        JButton diceButton = new JButton();
        diceButton.setBounds(250,250,95,30);
        diceButton.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images/dice.gif"))));
        diceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                audioClips.playAudioClip("/audio/rolling-dice.wav");

                int diceNumber = 1 + (int)(Math.random() * 6);
                diceButton.setIcon(panel.ImageOfDice(diceNumber));
                repaint();
            }
        });

        panel.add(diceButton);
        this.add(panel);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);

    }

	public static void createArraysPositions(){
        var x = 60;
        var y = 120;
        for (int i = 0; i < 5; i++) {
            arrayXPosition.add(x);
            arrayYPosition.add(y+20);
            x += 60;
        }
        y += 100;
        for (int i = 0; i < 5; i++) {
            arrayXPosition.add(x+20);
            arrayYPosition.add(y);
            y += 60;
        }
        x = 300;
        for (int i = 0; i < 5; i++) {
            arrayXPosition.add(x);
            arrayYPosition.add(y+20);
            x -= 60;
        }
        
    }
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createArraysPositions();
                new Game().setVisible(false);
                UsuarioPanel ventana = new UsuarioPanel();
        		ventana.setVisible(true);
        		ventana.setLocationRelativeTo(null);
            }
        });
    }
}
