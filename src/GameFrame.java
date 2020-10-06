import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 400;
    
    static final int MENU_PANEL_WIDTH = 50;
    static final int MENU_PANEL_HEIGHT = 50;
    static final Color MENU_PANEL_COLOR = new Color(200, 200, 200);
    
    ImageIcon myFrameIcon = new ImageIcon("img/icon.jpg");
    
    JPanel menuPanel = new JPanel();
    
    GameFrame() {

        // FRAME OPTIONS
        this.setTitle("My 2048 game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setIconImage(myFrameIcon.getImage());
        
        // MENU PANEL
        menuPanel.setPreferredSize(new Dimension(MENU_PANEL_WIDTH, MENU_PANEL_HEIGHT));
        menuPanel.setLayout(null);
        menuPanel.setBackground(MENU_PANEL_COLOR);
        
        // FRAME COMPONENTS
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(new Board(), BorderLayout.CENTER);
        
        // FRAME VISIBLE AND CENTER
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
}
