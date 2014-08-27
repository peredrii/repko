package mycol;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyListener extends KeyAdapter{
	Controller controller;
	
    public KeyListener(Controller control){
    	controller = control;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch(e.getKeyCode()){
        case KeyEvent.VK_UP:
            controller.changeColorUp();
            break;
        case KeyEvent.VK_DOWN:
            controller.changeColorDown();
            break;
        case KeyEvent.VK_LEFT:
        	controller.moveLeft();
        	break;
        case KeyEvent.VK_RIGHT:
        	controller.moveRight();
        	break;
        case KeyEvent.VK_SPACE:
        	controller.moveDown();
        }
    }
}
