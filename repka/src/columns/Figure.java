package columns;

import java.applet.*;
import java.awt.*;
import java.util.*;

class Figure {
	static int x = Columns.Width / 2 + 1;
	static int y = 1;
	static int c[] = new int[3];
	static Random r = new Random();

	Figure() {
		x = Columns.Width / 2 + 1;
		y = 1;
		//c[0] = 0;
		c[0] = Math.abs(r.nextInt()) % 7 + 1;
		c[1] = Math.abs(r.nextInt()) % 7 + 1;
		c[2] = Math.abs(r.nextInt()) % 7 + 1;
	}
}
