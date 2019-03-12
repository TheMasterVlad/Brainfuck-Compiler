package brainfuck_compiler;
public class BrainfuckCompiler {

    public static void main(String[] args) {
    	Code code = new Code();
    	code.setCodeline("-[--->+<]>-.-[----->+++<]>.----.++++++++++++.-[->+++<]>."+
    	  "[-->+++<]>-.[--->+<]>-.++[---->+<]>++.-[--->++<]>-.+++++.++++++.+++[->+++<]"+
    	  ">.+++++++++++++.----.+++++.-----------.+.+++++++.[------->++<]>.---[->++++<]>.+++[->+++<]>"+
    	  ".[--->+<]>----.+.[---->+<]>+++.---[->++++<]>.+[->+++<]>++.--[--->+<]>--.--------.[->++++++++++<]>.");
    	Compiler compiler = new Compiler(code);
    	compiler.compile(code);
    }
}


//ConcreteComand
class incrementPointerCommand implements Command{
	private Code codeline;
	public incrementPointerCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.incrementPointer();
	}
}
//ConcreteComand
class decrementPointerCommand implements Command{
	private Code codeline;
	public decrementPointerCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.decrementPointer();
	}
}
//ConcreteComand
class incrementByteCommand implements Command{
	private Code codeline;
	public incrementByteCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.incrementByte();
	}
}
//ConcreteComand
class decrementByteCommand implements Command{
	private Code codeline;
	public decrementByteCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.decrementByte();
	}
}
//ConcreteComand
class printCommand implements Command{
	private Code codeline;
	public printCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.print();
	}
}
//ConcreteComand
class loopStartCommand implements Command{
	private Code codeline;
	public loopStartCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.loopStart();
	}
}
//ConcreteComand
class loopEndCommand implements Command{
	private Code codeline;
	public loopEndCommand(Code codeline){ this.codeline = codeline;}
	@Override
	public void execute() {
		codeline.loopEnd();
	}
}


//ConcreteComandMaker
class IncrementPointerCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new incrementPointerCommand(code);
	}
}
//ConcreteComandMaker
class DecrementPointerCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new decrementPointerCommand(code);
	}
}
//ConcreteComandMaker
class IncrementByteCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new incrementByteCommand(code);
	}
}
//ConcreteComandMaker
class DecrementByteCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new decrementByteCommand(code);
	}
}
//ConcreteComandMaker
class PrintCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new printCommand(code);
	}
}
class LoopStartCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new loopStartCommand(code);
	}
}
class LoopEndCommandMaker implements CommandMaker{
	public Command createCommand(Code code){ 
		return new loopEndCommand(code);
	}
}