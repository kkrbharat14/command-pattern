package com.example.test;

import com.example.command.Command;
import com.example.command.LightOffCommand;
import com.example.command.LightOnCommand;
import com.example.command.MacroCommand;
import com.example.command.TVOffCommand;
import com.example.command.TvOnCommand;
import com.example.invoker.RemoteControl;
import com.example.receiver.Light;
import com.example.receiver.TV;

public class CommandPatternTest {
	public static void main(String[] args) {
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		
		TV tv = new TV();
		TvOnCommand tvOnCommand = new TvOnCommand(tv);
		TVOffCommand tvOffCommand = new TVOffCommand(tv);
			
		Command[] partyOn = {tvOnCommand, lightOffCommand};
		Command[] partyOff = {tvOffCommand, lightOnCommand};
		MacroCommand commandPartyOn = new MacroCommand(partyOn);
		MacroCommand commandpartyOff = new MacroCommand(partyOff);
		
		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
		remoteControl.setCommand(1, tvOnCommand, tvOffCommand);
		remoteControl.setCommand(2, commandPartyOn, commandpartyOff);
		
		remoteControl.onButton(0);
		remoteControl.onButton(1);
		
		remoteControl.offButton(0);
		remoteControl.offButton(1);
		
		remoteControl.undoButon();
		//Party On
		remoteControl.onButton(2);
	}
}
