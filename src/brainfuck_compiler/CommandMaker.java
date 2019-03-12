package brainfuck_compiler;

public interface CommandMaker {
	Command createCommand(Code code); //factory method
}
