package marsrover;

public class Rover {

    private String endPunkt = "N:0:0";

    private String direction = "N";
    private int y;

    String endPunkt() {
        return this.endPunkt;
    }

    void move(char[] commands) {
        for (char command : commands) {
            if (command == 'f') {
                this.y++;
            } else if (command == 'r') {
                if ("N".equals(direction)) {
                    direction = "E";
                } else if ("E".equals(direction)) {
                    direction = "S";
                } else if ("S".equals(direction)) {
                    direction = "W";
                } else {
                    direction = "N";
                }
            } else {
                if ("N".equals(direction)) {
                    direction = "W";
                } else if ("E".equals(direction)) {
                    direction = "N";
                } else if ("S".equals(direction)) {
                    direction = "E";
                } else {
                    direction = "S";
                }
            }
        }
        this.endPunkt = direction + ":0:" + y;
    }
}
