package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class End_of_the_loopTest {
	String testcode;
	 public int endOfTheLoop(int basePosition) {
			int loopCounter = 0;
			for(int i = basePosition + 1; i < testcode.length(); i++) {
				if (testcode.charAt(i) == '[') loopCounter++;
				if (testcode.charAt(i) == ']' && loopCounter == 0) {
					loopCounter = i;
					break;
				} else	if (testcode.charAt(i) == ']' && loopCounter > 0) {
					loopCounter--;
				} 
			}
			return loopCounter;
		}
	
	@Test
	public void test1() {
		testcode = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
		assertEquals(48, endOfTheLoop(8));
		assertEquals(33, endOfTheLoop(14));
		assertEquals(45, endOfTheLoop(43));
	}
	
	@Test
	public void test2() {
		testcode = "-[--->+<]>-.-[----->+++<]>.----.++++++++++++.-[->+++<]>.[-->+++<]>-.[--->+<]>-.++[---->+<]>++."+
		"-[--->++<]>-.+++++.++++++.+++[->+++<]>.+++++++++++++.----.+++++.-----------.+.+++++++.[------->++<]>.---[->++++<]>.++"+
				"+[->+++<]>.[--->+<]>----.+.[---->+<]>+++.---[->++++<]>.+[->+++<]>++.--[--->+<]>--.--------.[->++++++++++<]>.";
		assertEquals(8, endOfTheLoop(1));
		assertEquals(24, endOfTheLoop(17));
	}
}
