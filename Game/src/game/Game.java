package game;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends JFrame {
    
    private static Game game_game;
    private static long last_frame_time;
    private static Image Julian;
    private static Image Phasha;
    private static Image end;
    private static float drop_left = 200;
    private static float drop_top = 0;
    private static float drop_v = 200;
    private static int score = 0;
    

    public static void main(String[] args) throws IOException{
        Julian = ImageIO.read(Game.class.getResourceAsStream("Julian.jpg"));
        Phasha = ImageIO.read(Game.class.getResourceAsStream("Phasha.jpg"));
        end = ImageIO.read(Game.class.getResourceAsStream("end.jpg"));
        game_game = new Game();
        game_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_game.setLocation(200, 50);
        game_game.setSize(735, 413);
        game_game.setResizable(false);
        last_frame_time = System.nanoTime();
        GameField game_field = new GameField();
        game_field.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                int x = e.getX();
                int y = e.getY();
                float drop_right = drop_left + Phasha.getWidth(null);
                float drop_bottom = drop_top + Phasha.getHeight(null);
                boolean is_drop = x >= drop_left  && x <= drop_right && y >=drop_top && y <= drop_bottom;

                if (is_drop){
                    drop_top = 0;
                    drop_left = (int) (Math.random() * (game_field.getWidth() - end.getWidth(null)));
                    drop_v = drop_v + 10;
                    score++;
                    game_game.setTitle("Score " + score);
                }
            }
        });
        game_game.add(game_field);
        game_game.setVisible(true);

    }
    
    public static void onRepaint (Graphics g){
        long current_time = System.nanoTime();
        float delt_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;
        drop_top = drop_top + drop_v * delt_time;
        g.drawImage(Julian, 0, 0, null);
        g.drawImage(Phasha, (int) drop_left, (int) drop_top, null);
        if(drop_top > game_game.getHeight()) g.drawImage(end, 120, 10, null);
        
    
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
