package brainfuck_compiler;
import java.util.HashMap;
import java.util.Map;

//Invoker  
public class Compiler{
	private Command incrementPointer;
	private Command decrementPointer;
	private Command incrementByte;
	private Command decrementByte;
	private Command print;
	private Command loopstart;
	private Command loopend;
	
	private Map<Character, Command> operators = new HashMap<>();
	
	public Compiler(Code code) {
		this.incrementPointer = new IncrementPointerCommandMaker().createCommand(code);
		this.decrementPointer = new DecrementPointerCommandMaker().createCommand(code);
		this.incrementByte = new IncrementByteCommandMaker().createCommand(code);
		this.decrementByte = new DecrementByteCommandMaker().createCommand(code);
		this.print = new PrintCommandMaker().createCommand(code);
		this.loopstart = new LoopStartCommandMaker().createCommand(code);
		this.loopend = new LoopEndCommandMaker().createCommand(code);
		setOperators();
	}
	
	private void setOperators() {
		operators.put('+', incrementByte);
		operators.put('-', decrementByte);
		operators.put('<', decrementPointer);
		operators.put('>', incrementPointer);
		operators.put('.', print);
		operators.put('[', loopstart);
		operators.put(']', loopend);
	}
	
	public void compile(Code code) {
		String codeline = code.getCodeline();
		for(; code.getLineIterator() < codeline.length();code.increaseLineIterator()) {
			for (Map.Entry<Character, Command> operator : operators.entrySet()) {
				if(codeline.charAt(code.getLineIterator()) == operator.getKey()) {
					operator.getValue().execute();
	            } 
			}
		}
	}
}
