package goldmine2;

import static org.junit.Assert.*;

import org.junit.Test;


public class Test2 {

	@Test
	public void test() {
		Goldmine2 goldmine = new Goldmine2();

		assert (goldmine.solve("matrix.txt") == 12);	
		assert (goldmine.solve("matrix2.txt") == 32);
		assert (goldmine.solve("matrix3.txt") == 16);
		assert (goldmine.solve("matrix4.txt") == 83);
		assert (goldmine.solve("matrix5.txt") == 144);
	}

}
