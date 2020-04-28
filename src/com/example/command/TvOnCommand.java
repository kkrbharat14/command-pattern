package com.example.command;

import com.example.receiver.TV;

public class TvOnCommand implements Command {
	private TV tv;
	
	public TvOnCommand(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		this.tv.on();
	}

	@Override
	public void undo() {
		this.tv.off();
	}

}
