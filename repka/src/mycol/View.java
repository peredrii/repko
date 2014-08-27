package mycol;

import java.awt.*;
import java.awt.image.BufferedImage;

public class View {
	EventProcessor listener;
	Graphics2D gr;
	Image img;	
	static Graphics buf;
	
	View(Graphics2D g, BufferedImage image) {
		gr = g;
		img = image;
		buf = img.getGraphics();
	}

	public void updateState(State state) {
		drawField(state.glass);
		drawFigure(state.figure);
		gr.drawImage(img, 0, 0, null);
	}

	public void setListener(EventProcessor p) {
		listener = p;
	}
	
    void drawField(Glass glass) {
        for (int i = 0; i < Glass.HEIGHT; i++) {
            for (int j = 0; j < Glass.WIDTH; j++) {
                drawCell(buf, j, i, glass.field[i][j]);
            }
        }
    }

    void drawFigure(Figure f) {
        drawCell(buf, f.x, f.y, f.color[0]);
        drawCell(buf, f.x, f.y + 1, f.color[1]);
        drawCell(buf, f.x, f.y + 2, f.color[2]);
    }

    static void drawCell(Graphics g, int x, int y, int colorNumber) {
        g.setColor(Glass.colors[colorNumber]);
        g.fillRect(Glass.LEFTBORDER + x * Glass.cellSize, Glass.TOPBORDER + y * Glass.cellSize, Glass.cellSize, Glass.cellSize);
        g.setColor(Color.black);
        g.drawRect(Glass.LEFTBORDER + x * Glass.cellSize, Glass.TOPBORDER + y * Glass.cellSize,Glass. cellSize, Glass.cellSize);
    }

}
