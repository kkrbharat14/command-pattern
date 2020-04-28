package com.example.command;

public class NoCommand implements Command {

	@Override
	public void execute() {
		// Does nothing
	}

	@Override
	public void undo() {
		// Does nothing
	}

}
