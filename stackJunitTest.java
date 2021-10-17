package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stackJunitTest {

	@Test
	void test() {
		ResizeableArrayStack<Integer> test = new ResizeableArrayStack<>();
		int output = test.evaluatePostfix("ab*ca-/de*+");
		
		LinkedStack<String>  testStack = new LinkedStack<>();
		String output2 = testStack.convertToPostfix("a*b/(c-a)+d*e");
		assertAll(()->assertEquals(33, output), () -> assertEquals("ab*ca-/de*+", output2));
	}


}
