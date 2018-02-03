package marsrover.commands;

import marsrover.Rover;

public  class RotateRightCommand extends Command {

	public RotateRightCommand(Rover rover) {
		super(rover);
	}
	
	@Override
	public void execute() {
		String direction = rover.getDirection();
		if (Directions.NORTH.equals(direction)) {
			rover.setDirection(Directions.EAST);
		} else if (Directions.EAST.equals(direction)) {
			rover.setDirection(Directions.SOUTH);
		} else if (Directions.SOUTH.equals(direction)) {
			rover.setDirection(Directions.WEST);
		} else {
			rover.setDirection(Directions.NORTH);
		}
	}

}
