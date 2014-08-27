package mycol;

import static org.junit.Assert.*;
import org.junit.Test;

public class LogicTest {

	@Test
	public void testName() throws Exception {
		State state = new State();
		Logic l = new Logic(state);
		assertEquals(state, l.state);
	}
	
	@Test
	public void testEq() throws Exception {
		State state = new State();
		Logic l = new Logic(state);
		assertEquals(state.figure.x, l.state.figure.x);
	}
	
	@Test
	public void test() {
		State state = new State();
		Logic l = new Logic(state);
		assertEquals(state, l.state);
		l.newGame();
		l.state.figure.x = 0;
		l.moveLeft();
		assertEquals(0, l.state.figure.x);
	}

}
