package marsrover.commands;

import marsrover.Rover;

public abstract class Command {
	
	protected Rover rover;
	
	public Command(Rover rover) {
		this.rover = rover;
	}

	public abstract void execute();
}
