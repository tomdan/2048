import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {
	
	static final int TILE_WIDTH = 50;
    static final int TILE_HEIGHT = 50;
    
    Tile(){
    	this.setSize(TILE_WIDTH, TILE_HEIGHT);
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }
    
}
