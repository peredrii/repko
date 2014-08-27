package mycol;

import java.awt.Graphics;

public class A {
	int mas[][];
	Graphics g;
	A(int n, int m) {
		mas = new int[n][m];
	}

	boolean marked;

	int get(int x, int y) {
		if (x >= 0 && x < mas.length && y >= 0 && y < mas[0].length) {
			return mas[x][y];
		}
		return -1;
	}

	boolean check(int x, int y) {
		if (x >= 0 && x < mas.length && y >= 0 && y < mas[0].length) {
			return true;
		}
		return false;
	}

	boolean checkItem(int x, int y) {
		int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		
		int a = get(x, y);
		
		for (int i = 0; i < dy.length; i++) {
			if (a != -1 && a == get(x + dx[i], y + dy[i])
					&& (a == get(x + 2 * dx[i], y + 2 * dy[i]) || a == get(x - dx[i], y - dy[i]))) {
				return true;
			}

		}
		return false;
	}

	boolean checkLines() {
		boolean flag = false;
		boolean marked[][] = new boolean[mas.length][mas[0].length];
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[0].length; j++) {
				if (checkItem(i, j) && mas[i][j] != 0) {
					marked[i][j] = true;
					flag = true;
				}
			}
		}

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[0].length; j++) {
				if (marked[i][j]) {
					mas[i][j] = 0;
				}
			}
		}

		// call beautiful drawcells??????????
		return flag;
	}
	
    void reFill() {
    	for (int i = mas.length - 1; i > 0; i--) {
			for (int j = 0; j < mas[0].length; j++) {
				if (mas[i][j] == -1)
				{
					int var = mas[i][j];
					mas[i][j] = mas[i - 1][j];
					mas[i - 1][j] = var;
				}
			}
		}
    	
    	for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[0].length; j++) {
				if (mas[i][j] == - 1) {
					mas[i][j] = 0;
				}
			}
		}
    }
    
    void re(){
    	for (int k = 0; k < mas.length; k++) {
			
		
    	for (int i = 0; i < mas.length - 1; i++) {
			for (int j = 0; j < mas[0].length; j++) {
				if (mas[i + 1][j] == 0)
				{
					int var = mas[i + 1][j];
					mas[i + 1][j] = mas[i][j];
					mas[i][j] = var;
				}
			}
		}
    	}
    }

	public static void main(String[] args) {
		A a = new A(5, 3);
		a.mas[0][0] = 0;
		a.mas[0][1] = 1;
		a.mas[0][2] = 0;
		a.mas[1][0] = 0;
		a.mas[1][1] = 0;
		a.mas[1][2] = 0;
		a.mas[2][0] = 0;
		a.mas[2][1] = 2;
		a.mas[2][2] = 0;
		a.mas[3][0] = 0;
		a.mas[3][1] = 2;
		a.mas[3][2] = 0;
		a.mas[4][0] = 3;
		a.mas[4][1] = 3;
		a.mas[4][2] = 3;
		
		for (int i = 0; i < a.mas.length; i++) {
			for (int j = 0; j < a.mas[0].length; j++) {
				System.out.print(a.mas[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		a.checkLines();
		a.re();
//		a.reFill();
		for (int i = 0; i < a.mas.length; i++) {
			for (int j = 0; j < a.mas[0].length; j++) {
				System.out.print(a.mas[i][j]);
			}
			System.out.println();
		}
	}
}
