package marsrover.commands;

import marsrover.Rover;

public class RotateLeftCommand extends Command {

	public RotateLeftCommand(Rover rover) {
		super(rover);
	}

	@Override
	public void execute() {
		String direction = rover.getDirection();
		if (Directions.NORTH.equals(direction)) {
			rover.setDirection(Directions.WEST);
		} else if (Directions.EAST.equals(direction)) {
			rover.setDirection(Directions.NORTH);
		} else if (Directions.SOUTH.equals(direction)) {
			rover.setDirection(Directions.EAST);
		} else {
			rover.setDirection(Directions.SOUTH);
		}
	}
}
