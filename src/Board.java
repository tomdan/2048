import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
	
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
        this.addKeyListener(new MyKeyAdapter());
    
        // adds all tiles to the game board panel
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                tiles[j][i] = new Tile();
                this.add(tiles[j][i]);
            }
        }
        
        this.startNewGame();
        
	}
	
	public void startNewGame() {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                tiles[k][i].setPowerOfTwo(0);
            }
        }

        this.put2or4Tile();
        this.put2or4Tile();
    }
	
	// this function puts a new tile
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
	
	// this is the function that moves the tiles
	public void move(char direction) {
        boolean done_move = true;
        switch (direction) { // direction is UP RIGHT DOWN LEFT
            case 'U': // UP MOVE
                for (int c = 0; c < BOARD_SIZE; c++) {
                    done_move = true;
                    while (done_move) {
                        done_move = false;
                        for (int r = 0; r < BOARD_SIZE - 1; r++) {
                            if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c][r + 1].getPowerOfTwo() != 0) {
                                tiles[c][r].setPowerOfTwo(tiles[c][r + 1].getPowerOfTwo());
                                tiles[c][r + 1].setPowerOfTwo(0);
                                done_move = true;
                            }
                        }
                    }
                }
                break;
            case 'D': // DOWN MOVE
                for (int c = 0; c < BOARD_SIZE; c++) {
                    done_move = true;
                    while (done_move) {
                        done_move = false;
                        for (int r = BOARD_SIZE - 1; r > 0; r--) {
                            if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c][r - 1].getPowerOfTwo() != 0) {
                                tiles[c][r].setPowerOfTwo(tiles[c][r - 1].getPowerOfTwo());
                                tiles[c][r - 1].setPowerOfTwo(0);
                                done_move = true;
                            }
                        }
                    }
                }
                break;
            case 'L': // LEFT MOVE
                for (int r = 0; r < BOARD_SIZE; r++) {
                    done_move = true;
                    while (done_move) {
                        done_move = false;
                        for (int c = 0; c < BOARD_SIZE - 1; c++) {
                            if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c + 1][r].getPowerOfTwo() != 0) {
                                tiles[c][r].setPowerOfTwo(tiles[c + 1][r].getPowerOfTwo());
                                tiles[c + 1][r].setPowerOfTwo(0);
                                done_move = true;
                            }
                        }
                    }
                }
                break;
            case 'R': // RIGHT MOVE
                for (int r = 0; r < BOARD_SIZE; r++) {
                    done_move = true;
                    while (done_move) {
                        done_move = false;
                        for (int c = BOARD_SIZE - 1; c > 0; c--) {
                            if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c - 1][r].getPowerOfTwo() != 0) {
                                tiles[c][r].setPowerOfTwo(tiles[c - 1][r].getPowerOfTwo());
                                tiles[c - 1][r].setPowerOfTwo(0);
                                done_move = true;
                            }
                        }
                    }
                }
                break;
        }
    }

	void leftMerge() {
        int current_column = -1;
        for (int r = 0; r < BOARD_SIZE; r++) {
            current_column = -1;
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_column == -1
                        || tiles[current_column][r].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_column = c;
                } else if (tiles[current_column][r].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    tiles[current_column][r].setPowerOfTwo(tiles[current_column][r].getPowerOfTwo() + 1);
                    tiles[c][r].setPowerOfTwo(0);
                    current_column = -1;
                }
            }
        }
    }
	
	void rightMerge() {
        int current_column = -1;
        for (int r = 0; r < BOARD_SIZE; r++) {
            current_column = -1;
            for (int c = BOARD_SIZE - 1; c >= 0; c--) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_column == -1
                        || tiles[current_column][r].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_column = c;
                } else if (tiles[current_column][r].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    tiles[current_column][r].setPowerOfTwo(tiles[current_column][r].getPowerOfTwo() + 1);
                    tiles[c][r].setPowerOfTwo(0);
                    current_column = -1;
                }
            }
        }
    }
	
	void upMerge() {
        int current_row = -1;
        for (int c = 0; c < BOARD_SIZE; c++) {
            current_row = -1;
            for (int r = 0; r < BOARD_SIZE; r++) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_row == -1 || tiles[c][current_row].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_row = r;
                } else if (tiles[c][current_row].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    tiles[c][current_row].setPowerOfTwo(tiles[c][current_row].getPowerOfTwo() + 1);
                    tiles[c][r].setPowerOfTwo(0);
                    current_row = -1;
                }
            }
        }
    }
	
	void downMerge() {
        int current_row = -1;
        for (int c = 0; c < BOARD_SIZE; c++) {
            current_row = -1;
            for (int r = BOARD_SIZE - 1; r >= 0; r--) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_row == -1 || tiles[c][current_row].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_row = r;
                } else if (tiles[c][current_row].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    tiles[c][current_row].setPowerOfTwo(tiles[c][current_row].getPowerOfTwo() + 1);
                    tiles[c][r].setPowerOfTwo(0);
                    current_row = -1;
                }
            }
        }
    }
	
	boolean leftMoveTest() {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE - 1; c++) {
                if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c + 1][r].getPowerOfTwo() != 0) {
                    return true;
                }
            }
        }
        return false;
    }

	boolean rightMoveTest() {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = BOARD_SIZE - 1; c > 0; c--) {
                if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c - 1][r].getPowerOfTwo() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
	
	boolean upMoveTest() {
        for (int c = 0; c < BOARD_SIZE; c++) {
            for (int r = 0; r < BOARD_SIZE - 1; r++) {
                if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c][r + 1].getPowerOfTwo() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
	
	boolean downMoveTest() {
        for (int c = 0; c < BOARD_SIZE; c++) {
            for (int r = BOARD_SIZE - 1; r > 0; r--) {
                if (tiles[c][r].getPowerOfTwo() == 0 && tiles[c][r - 1].getPowerOfTwo() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
	
	boolean leftMergeTest() {
        int current_column = -1;
        for (int r = 0; r < BOARD_SIZE; r++) {
            current_column = -1;
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_column == -1
                        || tiles[current_column][r].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_column = c;
                } else if (tiles[current_column][r].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    return true;
                }
            }
        }
        return false;
    }
	
	boolean rightMergeTest() {
        int current_column = -1;
        for (int r = 0; r < BOARD_SIZE; r++) {
            current_column = -1;
            for (int c = BOARD_SIZE - 1; c >= 0; c--) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_column == -1
                        || tiles[current_column][r].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_column = c;
                } else if (tiles[current_column][r].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    return true;
                }
            }
        }
        return false;
    }
	
	boolean upMergeTest() {
        int current_row = -1;
        for (int c = 0; c < BOARD_SIZE; c++) {
            current_row = -1;
            for (int r = 0; r < BOARD_SIZE; r++) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_row == -1 || tiles[c][current_row].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_row = r;
                } else if (tiles[c][current_row].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    return true;
                }
            }
        }
        return false;
    }
	
	boolean downMergeTest() {
        int current_row = -1;
        for (int c = 0; c < BOARD_SIZE; c++) {
            current_row = -1;
            for (int r = BOARD_SIZE - 1; r >= 0; r--) {
                if (tiles[c][r].getPowerOfTwo() == 0) {
                    continue;
                } else if (current_row == -1 || tiles[c][current_row].getPowerOfTwo() != tiles[c][r].getPowerOfTwo()) {
                    current_row = r;
                } else if (tiles[c][current_row].getPowerOfTwo() == tiles[c][r].getPowerOfTwo()) {
                    return true;
                }
            }
        }
        return false;
    }
	
	@Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
	
	public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                	if (leftMoveTest() || leftMergeTest()) {
                        leftMerge();
                        move('L');
                        put2or4Tile();
                    }
                	break;
                case KeyEvent.VK_RIGHT:
                	if (rightMoveTest() || rightMergeTest()) {
                        rightMerge();
                        move('R');
                        put2or4Tile();
                    }
                	break;
                case KeyEvent.VK_UP:
                	if (upMoveTest() || upMergeTest()) {
                        upMerge();
                        move('U');
                        put2or4Tile();
                    }
                    break;
                case KeyEvent.VK_DOWN:
                	if (downMoveTest() || downMergeTest()) {
                        downMerge();
                        move('D');
                        put2or4Tile();
                    }
                    break;
            }
        }
    }
	
}
