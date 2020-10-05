import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
	
	// BOARD_SIZE is the number of tiles on the game board, used in two-dimensional array of tiles
	static final int BOARD_SIZE = 4;
    // the gap of tiles on board, used in the GridLayout
    static final int TILE_GAP = 5;
    
    // Tiles on the board - Tiles[column][row]
    Tile[][] tiles = new Tile[BOARD_SIZE][BOARD_SIZE];
    
    Random random_number = new Random();
    
	Board() {

        this.setFocusable(true);
        this.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE, TILE_GAP, TILE_GAP));
    
        // adds all tiles to the game board panel
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                tiles[j][i] = new Tile();
                this.add(tiles[j][i]);
            }
        }
        
        this.put2or4Tile();
        this.put2or4Tile();
	}
	
	//this function puts a new tile
	public void put2or4Tile() {
        int row = 0;
        int column = 0;
        int x2or4 = random_number.nextInt(100);
        int counter = 0;

        // the counter is the number of empty tiles
        for (int c = 0; c < BOARD_SIZE; c++) {
            for (int r = 0; r < BOARD_SIZE; r++) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    counter++;
                }
            }
        }

        // 80% tile = 2, 20% tile = 4
        if (x2or4 < 80) {
            x2or4 = 1;
        } else {
            x2or4 = 2;
        }

        // if the game board has any empty tile, this function puts a new tile
        if (counter > 0) {
            do {
                row = random_number.nextInt(BOARD_SIZE);
                column = random_number.nextInt(BOARD_SIZE);
            } while (tiles[column][row].getPowerOfTwo() != 0);
            tiles[column][row].setPowerOfTwo(x2or4);
        }
    }
	
}
