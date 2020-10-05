import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
	
	// BOARD_SIZE is the number of tiles on the game board, used in two-dimensional array of tiles
	static final int BOARD_SIZE = 4;
    // the gap of tiles on board, used in the GridLayout
    static final int TILE_GAP = 5;
    
    // Tiles on the board - Tiles[column][row]
    Tile[][] tiles = new Tile[BOARD_SIZE][BOARD_SIZE];
    
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
	}
}
