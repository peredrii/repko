package mycol;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.*;


public class Columns extends Applet {

	Model model;
	View view;
	Controller controller;
	ScheduledExecutorService serv; 
	
	@Override
	public void init() {
		model = new Model();
		view = new View((Graphics2D)getGraphics(), (BufferedImage)createImage(Glass.WIDTH * Glass.cellSize, Glass.HEIGHT * Glass.cellSize));
		controller = new Controller(model, view);
		
		model.addListener(controller);
		view.setListener(controller);
		addKeyListener(new KeyListener(controller));

		model.newGame();
		serv = Executors.newSingleThreadScheduledExecutor();
		serv.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				controller.moveDown();
			}
		}, 1, 1, TimeUnit.SECONDS);
	}

	@Override
	public void paint(Graphics g) {
		view.drawField(model.state.glass);
		view.drawFigure(model.state.figure);
		requestFocus();
	}
}
