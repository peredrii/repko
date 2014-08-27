package mycol;

import java.util.LinkedList;
import java.util.List;

public class Model implements EventProcessor {
	State state;
	Logic logic;
	private List <ModelListener> listeners;
	
	Model() {
		listeners = new LinkedList<>();
		state = new State();
		logic = new Logic(state);
	}
	
	void init() {
		state.init();
		// mb logic.newGame(); ??????????????
	}

	@Override
	public void newGame() {
		logic.newGame();
	}
	
	@Override
	public void moveLeft() {
		logic.moveLeft();
		updateState();
	}

	@Override
	public void moveRight() {
		logic.moveRight();
		updateState();
	}

	@Override
	public void moveDown() {
		logic.moveDown();
		updateState();
	}

	@Override
	public void changeColorUp() {
		logic.changeColorUp();
		updateState();
	}

	@Override
	public void changeColorDown() {
		logic.changeColorDown();
		updateState();
	}

	private void updateState() {
		for (ModelListener listener : listeners) {
			listener.updateState(state);
		}		
	}

	public void addListener(ModelListener controller) {
		listeners.add(controller);
	}


}
