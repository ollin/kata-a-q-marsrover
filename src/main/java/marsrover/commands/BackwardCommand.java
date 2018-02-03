package marsrover.commands;

import marsrover.Rover;

public class BackwardCommand extends Command {

	public BackwardCommand(Rover rover) {
		super(rover);
	}

	@Override
	public void execute() {
		String direction = rover.getDirection();
		if (Directions.NORTH.equals(direction)) {
			rover.setY(rover.getY() - 1);
		} else if (Directions.EAST.equals(direction)) {
			rover.setX(rover.getX() - 1);
		} else if (Directions.WEST.equals(direction)) {
			rover.setX(rover.getX() + 1);
		} else if (Directions.SOUTH.equals(direction)) {
			rover.setY(rover.getY() + 1);
		}
	}
}
