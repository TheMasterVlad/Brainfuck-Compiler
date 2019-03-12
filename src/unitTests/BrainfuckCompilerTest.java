package unitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import brainfuck_compiler.Code;
import brainfuck_compiler.Compiler;

public class BrainfuckCompilerTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private Code testcode;
	
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outContent));
	    testcode = new Code();
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void test_compiler1() {
		
		testcode.setCodeline("-[--->+<]>-.-[----->+++<]>.----.++++++++++++.-[->+++<]>."+
				"[-->+++<]>-.[--->+<]>-.++[---->+<]>++.-[--->++<]>-.+++++.++++++.+++[->+++<]"+
				">.+++++++++++++.----.+++++.-----------.+.+++++++.[------->++<]>.---[->++++<]>.+++[->+++<]>"+
				".[--->+<]>----.+.[---->+<]>+++.---[->++++<]>.+[->+++<]>++.--[--->+<]>--.--------.[->++++++++++<]>.");
		new Compiler(testcode).compile(testcode);
		assertEquals("TeamDev internship test task.", outContent.toString());
	}
	
	@Test
	public void test_compiler2() {
		
		testcode.setCodeline("[-]");
		new Compiler(testcode).compile(testcode);
		assertEquals("", outContent.toString());
	}
	
	@Test
	public void test_compiler3() {
		
		testcode.setCodeline("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++");
		new Compiler(testcode).compile(testcode);
		assertEquals("Hello World!", outContent.toString());
	}
	
	@Test
	public void test_compiler4() {
		
		testcode.setCodeline("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.+++++++++++++++++" + 
				"++++++++++++.+++++++..+++.------------------------------------------------------------------------" + 
				"-------.+++++++++++++++++++++++++++++++++++++++++++++++++++++++.++++++++++++++++++" + 
				"++++++.+++.------.--------.--------------------------------------------------------" + 
				"-----------.-----------------------");
		new Compiler(testcode).compile(testcode);
		assertEquals("Hello World!", outContent.toString());
	}
	
	@Test
	public void test_compiler5() {
		
		testcode.setCodeline("-[------->+<]>.+[-->+<]>++.[->+++<]>+.+[->+++<]>.--[--->+<]>-.+[----->+<]>.------------.+++.+" + 
		".--[--->+<]>-.---[->++++<]>-.----.--.--------.--[--->+<]>-.---[->++++<]>+.-------.-----.+++++++++++.[---->+<]>+++.---"+
				"[->++++<]>.+++[->+++<]>.[--->+<]>----.+.-.+[++>---<]>.");
		new Compiler(testcode).compile(testcode);
		assertEquals("I've made some unit tests.", outContent.toString());
	}

}
