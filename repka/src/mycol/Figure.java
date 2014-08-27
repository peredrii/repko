package mycol;

import java.util.Random;

public class Figure {
	int x;
    int y;
    int color[] = new int[3];
    Random r = new Random();

    void generate() {
        y = 0;
        x = Glass.WIDTH / 2;
        color[0] = Math.abs(r.nextInt()) % 7 + 1;
        color[1] = Math.abs(r.nextInt()) % 7 + 1;
        color[2] = Math.abs(r.nextInt()) % 7 + 1;
    }
}
