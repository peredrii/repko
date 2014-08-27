package mycol;

public class Logic implements EventProcessor{
	State state;
	
	Logic(State state) {
		this.state = state; 
	}
	
	public void newGame() {
		state.init();
	}
	
	public void moveLeft() {
		if (!state.glass.check(state.figure.x - 1, state.figure.y)) {
			return;
		}
		state.moveFigureLeft();
	}
	
	public void moveRight() {
		if (!state.glass.check(state.figure.x + 1, state.figure.y)) {
			return;
		}
		state.moveFigureRight();
	}
	
	public void moveDown() {
		if (!state.glass.check(state.figure.x, state.figure.y + 1)) {
			state.pasteFigure();
//			for (int i = 0; i < 3; i++) {
//				state.glass.checkLines();
//			}
			while (state.glass.checkLines()) {
				state.glass.reFill();
			}
			if (!state.glass.check(Glass.WIDTH / 2, 0)) {
				return;
			}
			state.figure.generate();
		}
		state.moveFigureDown();
	}
	
	public void changeColorUp() {
		state.changeColorUp();
	}

	public void changeColorDown() {
		state.changeColorDown();
	}
	
	
}
