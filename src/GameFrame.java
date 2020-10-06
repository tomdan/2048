import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame implements ActionListener {

    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 400;
    
    static final int MENU_PANEL_WIDTH = 50;
    static final int MENU_PANEL_HEIGHT = 50;
    static final Color MENU_PANEL_COLOR = new Color(200, 200, 200);
    
    ImageIcon myFrameIcon = new ImageIcon("img/icon.jpg");
    
    // COMPONENTS
    Board gameBoard = new Board();
    JPanel menuPanel = new JPanel();
    JButton newGameButton = new JButton("Nowa gra");
    
    GameFrame() {

        // FRAME OPTIONS
        this.setTitle("My 2048 game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setIconImage(myFrameIcon.getImage());
        
        // NEW GAME BUTTON
        newGameButton.setBounds(10, 10, 150, 30);
        newGameButton.setFocusable(false);
        newGameButton.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        newGameButton.addActionListener(this);
        
        // MENU PANEL
        menuPanel.setPreferredSize(new Dimension(MENU_PANEL_WIDTH, MENU_PANEL_HEIGHT));
        menuPanel.setLayout(null);
        menuPanel.setBackground(MENU_PANEL_COLOR);
        menuPanel.add(newGameButton);
        
        // FRAME COMPONENTS
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(gameBoard, BorderLayout.CENTER);
        
        // FRAME VISIBLE AND CENTER
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            gameBoard.startNewGame();
        }
    }
    
}
