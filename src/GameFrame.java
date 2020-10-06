import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 400;
    
    ImageIcon myFrameIcon = new ImageIcon("img/icon.jpg");
    
    GameFrame() {

        // FRAME OPTIONS
        this.setTitle("My 2048 game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setIconImage(myFrameIcon.getImage());
        
        // FRAME COMPONENTS
        this.add(new Board());
        
        // FRAME VISIBLE AND CENTER
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
}
