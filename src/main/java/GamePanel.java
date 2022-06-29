import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@SuppressWarnings("serial")
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
    GameAudio audioClips = new GameAudio();


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
        	JOptionPane.showMessageDialog(null, "GANASTE");
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
            	JOptionPane.showMessageDialog(null, "ESTA JUEGO FUE CREADO CON : Graphics"+"\n"+" que es la clase base abstracta para todos"+"\n"+" los contextos gráficos que permiten que una "+"\n"+"aplicación se dibuje en componentes que se realizan "+"\n"+"en varios dispositivos, así como en imágenes fuera de pantalla");
                return dice3;
            case 4:
            	JOptionPane.showMessageDialog(null, "LENGUAJE EN EL QUE FUE CREADO :"+"\n"+" Java es un lenguaje de programación y una plataforma informática"+"\n"+" que fue comercializada por primera vez en 1995 por Sun Microsystems."+"\n"+" Hay muchas aplicaciones y sitios web que no funcionarán,"+"\n"+" probablemente, a menos que tengan Java instalado, y cada"+"\n"+" día se crean más. Java es rápido, seguro y fiable");
                return dice4;
            case 5:
            	JOptionPane.showMessageDialog(null, " PLUGINS USADO : "+"\n"+" WindowBuilder es uno de mis plugins preferidos para desarrollar"+"\n"+" interfaces gráficas Java en Eclipse. Es bastante intuitivo, "+"\n"+"permite configuraciones de varias líneas de código con un sólo clic"+"\n"+" y el resultado es aceptable.");
                return dice5;
            case 6:
            	JOptionPane.showMessageDialog(null, "SISTEMA DE AUDIO DEL JUEGO : "+"\n"+" Clipinterfaz que representa un tipo especial de línea de "+"\n"+" datos cuyos datos de audio se pueden cargar antes de la reproducción,  "+"\n"+"en lugar de transmitirse en tiempo real.\r\n"
            			+ "Debido a que los datos están precargados y tienen "+"\n"+" una duración conocida, puede configurar un clip para que comience  "+"\n"+"a reproducirse en cualquier posición de sus datos de audio. También puede crear "+"\n"+" un bucle para que, cuando se reproduzca el clip, se reproduzca repetidamente. "+"\n"+" Los bucles se especifican con un fotograma de muestra inicial y final,  "+"\n"+"junto con el número de veces que se debe reproducir el bucle.");
                return dice6;
            default:
                return stop;
        }
    }
}
