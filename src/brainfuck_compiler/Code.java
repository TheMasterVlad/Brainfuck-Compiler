package brainfuck_compiler;
import java.util.Stack;

//Receiver
public class Code {
	private final int LENGTH = 30000;
    private byte[] mem = new byte[LENGTH];
    private String code;
    private int dataPointer;
    private int lineIterator;
    private Stack<Integer> loopStack;
    
    public Code() {
    	lineIterator = 0;
    	loopStack = new Stack<Integer>();
    }
    
    public void setCodeline(String code) {
    	this.code = code;
    }
    
    public void increaseLineIterator() {
    	this.lineIterator++;
    }
    
    public int getLineIterator() {
    	return lineIterator;
    }
    
    public String getCodeline() {
    	return code;
    }
    
    public void incrementPointer() {
		dataPointer = (dataPointer == LENGTH-1) ? 0 : dataPointer + 1;
	}
    public void decrementPointer() {
		dataPointer = (dataPointer == 0) ? LENGTH-1 : dataPointer - 1;
	}
    public void incrementByte() {
		mem[dataPointer]++;
	}
    public void decrementByte() {
		mem[dataPointer]--;
	}
    public void print() {
		System.out.print((char) mem[dataPointer]);
	}
	
    public void loopStart() {
		if(mem[dataPointer] != 0) {
			loopStack.push(lineIterator);		
		} else { 
			lineIterator = endOfTheLoop(lineIterator);
		}
	}
	
    public void loopEnd() {
		if(mem[dataPointer] != 0) {
			lineIterator = loopStack.peek();
		} else if (!loopStack.isEmpty()) 
			loopStack.pop();
	}
	
	private int endOfTheLoop(int basePosition) {
		int loopCounter = 0;
		for(int i = basePosition + 1; i < code.length(); i++) {
			if (code.charAt(i) == '[') loopCounter++;
			if (code.charAt(i) == ']' && loopCounter == 0) {
				loopCounter = i;
				break;
			} else	if (code.charAt(i) == ']' && loopCounter > 0) {
				loopCounter--;
			} 
		}
		return loopCounter;
	}
	
}
