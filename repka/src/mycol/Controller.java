package mycol;

public class Controller implements ModelListener, EventProcessor {

	Model model;
	View view;
	
	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	

	@Override
	public void updateState(State state) {
		view.updateState(state);
	}

	@Override
	public void newGame() {
		model.newGame();
	}

	@Override
	public void moveLeft() {
		model.moveLeft();
	}

	@Override
	public void moveRight() {
		model.moveRight();
	}

	@Override
	public void moveDown() {
		model.moveDown();
	}

	@Override
	public void changeColorUp() {
		model.changeColorUp();
	}

	@Override
	public void changeColorDown() {
		model.changeColorDown();
	}

}
