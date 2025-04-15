package winter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Winter extends JFrame {
    private static Winter game_game;
    private static long last_frame_time;
    private static Image Fon;
    private static Image Fon2;
    private static Image Snow;
    private static Image Snow2;
    private static Image Snow3;
    private static Image Snow4;
    private static float drop_left = (int) (Math.random() * 100);
    private static float drop_left2 = (int) (Math.random() * 100);
    private static float drop_left3 = (int) (Math.random() * 100);
    private static float drop_left4 = (int) (Math.random() * 100);
    private static float drop_top = 100;
    private static float drop_v = 500;
    

    public static void main(String[] args) throws IOException{
        Fon = ImageIO.read(Winter.class.getResourceAsStream("Fon.jpg"));
        Fon2 = ImageIO.read(Winter.class.getResourceAsStream("tatk.jpg"));
        Snow = ImageIO.read(Winter.class.getResourceAsStream("Snow.png"));
        Snow2 = ImageIO.read(Winter.class.getResourceAsStream("Snow.png"));
        Snow3 = ImageIO.read(Winter.class.getResourceAsStream("Snow.png"));
        Snow4 = ImageIO.read(Winter.class.getResourceAsStream("Snow.png"));
        game_game = new Winter();
        game_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_game.setLocation(200, 50);
        game_game.setSize(1024, 640);
        game_game.setResizable(false);
        last_frame_time = System.nanoTime();
        GameField game_field = new GameField();
        ImageIcon icon = new ImageIcon(Fon2);
        game_game.setIconImage(icon.getImage());
        game_game.setTitle("Welcome to the winter forest");
        game_game.add(game_field);
        game_game.setVisible(true);

    }
    
    public static void onRepaint (Graphics g){
        long current_time = System.nanoTime();
        float delt_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;
        drop_top = drop_top + drop_v * delt_time;
        g.drawImage(Fon, 0, 0, null);
        g.drawImage(Snow, (int) drop_left, (int) drop_top - 200, null);
        g.drawImage(Snow3, (int) drop_left2, (int) drop_top - 100, null);
        g.drawImage(Snow2, (int) drop_left3, (int) drop_top - 120, null);
        g.drawImage(Snow4, (int) drop_left4, (int) drop_top - 5, null);
        if(drop_top > game_game.getHeight()){
            drop_top = -200;
            drop_left = (int) (Math.random() * 1000);
            g.drawImage(Snow, (int) drop_left, (int) drop_top, null);
            drop_left2 = (int) (Math.random() * 1000);
            g.drawImage(Snow3, (int) drop_left2, (int) drop_top, null);
            drop_left3 = (int) (Math.random() * 1000);
            g.drawImage(Snow2, (int) drop_left3, (int) drop_top, null);
            drop_left4 = (int) (Math.random() * 1000);
            g.drawImage(Snow4, (int) drop_left4, (int) drop_top, null);
        }
        
    
    }  
    public static class GameField extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        onRepaint(g);
        repaint();
    }
 }
}

