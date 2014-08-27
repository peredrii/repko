package mycol;

import java.awt.Color;

public class Glass {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 40;
	public static final int LEFTBORDER = 1;
	public static final int TOPBORDER = 1;

	int field[][];
	static int cellSize = 12;
	static Color colors[] = { Color.black, Color.blue, Color.cyan, Color.green,
			Color.magenta, Color.orange, Color.red, Color.white };

	Glass() {
		field = new int[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				field[i][j] = 0;
			}
		}
	}

	int getCell(int x, int y) {
		if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
			return field[y][x];
		}
		return -10;
	}

	void clear() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				field[i][j] = 0;
			}
		}
	}

	boolean checkLines() {
		boolean flag = false;
		boolean marked[][] = new boolean[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (checkItem(j, i) && field[i][j] != 0) {
					marked[i][j] = true;
					flag = true;
				}
			}
		}

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (marked[i][j]) {
					field[i][j] = 0; // here before -1
				}
			}
		}

		// call beautiful drawcells??????????
		return flag;
	}

	boolean checkItem(int x, int y) {
		int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

		for (int i = 0; i < dy.length; i++) {
			if (getCell(x, y) != 0
					&& getCell(x, y) == getCell(x + dx[i], y + dy[i])
					&& (getCell(x, y) == getCell(x + 2 * dx[i], y + 2 * dy[i]) || getCell(
							x, y) == getCell(x - dx[i], y - dy[i]))) {
				return true;
			}
		}
		return false;
	}

	boolean check(int x, int y) {
		return x < WIDTH && x >= 0 && y >= 0 && (y + 2) < HEIGHT
				&& field[y][x] == 0 && field[y + 1][x] == 0
				&& field[y + 2][x] == 0;
	}

	void reFill() {
		for (int k = 0; k < field.length; k++) {
			for (int i = 0; i < field.length - 1; i++) {
				for (int j = 0; j < field[0].length; j++) {
					if (field[i + 1][j] == 0) {
						int var = field[i + 1][j];
						field[i + 1][j] = field[i][j];
						field[i][j] = var;
					}
				}
			}
		}
	}

}
