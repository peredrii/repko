package mycol;

public class State {
	Glass glass;
	Figure figure;

	State() {
		glass = new Glass();
		figure = new Figure();
	}

	void init() {
		figure.generate();
	}

	void moveFigureLeft() {
		figure.x--;
	}

	void moveFigureRight() {
		figure.x++;
	}

	void moveFigureDown() {
		figure.y++;
	}

	void pasteFigure() {
		glass.field[figure.y][figure.x] = figure.color[0];
		glass.field[figure.y + 1][figure.x] = figure.color[1];
		glass.field[figure.y + 2][figure.x] = figure.color[2];
	}

	void changeColorUp() {
		int varg = figure.color[0];
        figure.color[0] = figure.color[1];
        figure.color[1] = figure.color[2];
        figure.color[2] = varg;
	}
	
	void changeColorDown() {
		int varg = figure.color[2];
		figure.color[2] = figure.color[1];
		figure.color[1] = figure.color[0];
		figure.color[0] = varg;
	}

}
