package com.example.invoker;

import com.example.command.Command;
import com.example.command.NoCommand;

public class RemoteControl {
	private Command[] onCommands;
	private Command[] offCommands;
	private Command undoCommand;
	
	public RemoteControl() {
		this.onCommands = new Command[3];
		this.offCommands = new Command[3];
		
		for(int i=0;i<=2;i++) {
			this.onCommands[i] = new NoCommand();
			this.offCommands[i] = new NoCommand();	
		}
		this.undoCommand = new NoCommand();
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		this.onCommands[slot] = onCommand;
		this.offCommands[slot] = offCommand;
;	}
	
	public void offButton(int slot) {
		this.offCommands[slot].execute();
		this.undoCommand = this.offCommands[slot];
	}
	
	public void onButton(int slot) {
		this.onCommands[slot].execute();
		this.undoCommand = this.onCommands[slot];
	}
	
	public void undoButon() {
		this.undoCommand.undo();
	}
}
