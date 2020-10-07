import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class Tile extends JLabel {

	static final Color TILE_0 = new Color(150, 150, 150);
	static final Color TILE_2 = new Color(255, 255, 150);
	static final Color TILE_4 = new Color(255, 255, 75);
	static final Color TILE_8 = new Color(255, 150, 150);
	static final Color TILE_16 = new Color(255, 75, 75);
	static final Color TILE_32 = new Color(255, 150, 255);
	static final Color TILE_64 = new Color(255, 75, 255);
	static final Color TILE_128 = new Color(150, 150, 255);
	static final Color TILE_256 = new Color(75, 75, 255);
	static final Color TILE_512 = new Color(150, 255, 255);
	static final Color TILE_1024 = new Color(75, 255, 255);
	static final Color TILE_2048 = new Color(150, 255, 150);
	static final Color TILE_4096 = new Color(75, 255, 75);

	static final int TILE_WIDTH = 50;
	static final int TILE_HEIGHT = 50;

	private int powerOfTwo;

	Tile() {
		this.setSize(TILE_WIDTH, TILE_HEIGHT);
		this.setFont(new Font("MV Boli", Font.PLAIN, 20));
		this.setVerticalAlignment(CENTER);
		this.setHorizontalAlignment(CENTER);
		this.setBackground(TILE_0);
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
			this.setText(Integer.toString((int) (Math.pow(2, powerOfTwo))));
		}

		// set color of the tile
		switch (powerOfTwo) {
			case 0:
				this.setBackground(TILE_0);
				break;
			case 1:
				this.setBackground(TILE_2);
				break;
			case 2:
				this.setBackground(TILE_4);
				break;
			case 3:
				this.setBackground(TILE_8);
				break;
			case 4:
				this.setBackground(TILE_16);
				break;
			case 5:
				this.setBackground(TILE_32);
				break;
			case 6:
				this.setBackground(TILE_64);
				break;
			case 7:
				this.setBackground(TILE_128);
				break;
			case 8:
				this.setBackground(TILE_256);
				break;
			case 9:
				this.setBackground(TILE_512);
				break;
			case 10:
				this.setBackground(TILE_1024);
				break;
			case 11:
				this.setBackground(TILE_2048);
				break;
			case 12:
				this.setBackground(TILE_4096);
				break;
		}
	}
}