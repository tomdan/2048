import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class Tile extends JLabel {
	
	static final int TILE_WIDTH = 50;
    static final int TILE_HEIGHT = 50;
    
    private int powerOfTwo;
    
    Tile(){
    	this.setSize(TILE_WIDTH, TILE_HEIGHT);
        this.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        
        this.setPowerOfTwo(0);
    }

	public int getPowerOfTwo() {
		return powerOfTwo;
	}

	public void setPowerOfTwo(int powerOfTwo) {
		this.powerOfTwo = powerOfTwo;
		
		// set the correct text on the tile label
		if (powerOfTwo == 0) {
            this.setText(" ");
        } else {
            this.setText(Integer.toString((int)(Math.pow(2,powerOfTwo))));
        }
	}
    
}