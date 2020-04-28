package com.example.command;

import com.example.receiver.TV;

public class TVOffCommand implements Command {
	
	private TV tv;
	
	public TVOffCommand(TV tv) {
		this.tv = tv;
	}
		
	@Override
	public void execute() {
		this.tv.off();
	}

	@Override
	public void undo() {
		this.tv.on();
	}

}
