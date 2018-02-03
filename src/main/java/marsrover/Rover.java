package marsrover;

import java.util.HashMap;
import java.util.Map;

import marsrover.commands.BackwardCommand;
import marsrover.commands.Command;
import marsrover.commands.ForwardCommand;
import marsrover.commands.Movements;
import marsrover.commands.RotateLeftCommand;
import marsrover.commands.RotateRightCommand;
import marsrover.commands.Rotation;

public class Rover {

	private Map<String, Command> commandMap = new HashMap<>();
	private String endPunkt = "N:0:0";
	private String direction = "N";

	Rover() {
		initCommandMap();
	}

	private void initCommandMap() {
		commandMap.put(Movements.FORWARD, new ForwardCommand(this));
		commandMap.put(Movements.BACKWARD, new BackwardCommand(this));
		commandMap.put(Rotation.RIGHT, new RotateRightCommand(this));
		commandMap.put(Rotation.LEFT, new RotateLeftCommand(this));
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int y;

	String endPunkt() {
		return this.endPunkt;
	}

	void move(char[] commands) {
		for (char command : commands) {
			Command roverCommand = commandMap.get(String.valueOf(command));
			if (roverCommand != null) {
				roverCommand.execute();
				this.endPunkt = direction + ":" + x + ":" + y;
			}else {
				throw new RuntimeException("Unknown command");
			}
		}
	}
}

