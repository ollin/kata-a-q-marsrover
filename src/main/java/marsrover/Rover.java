package marsrover;

public class Rover {

    private String endPunkt = "N:0:0";

    private String direction = "N";
    private int x;
    private int y;

    String endPunkt() {
        return this.endPunkt;
    }

    void move(char[] commands) {
        for (char command : commands) {
            if (command == 'f') {
                moveForward();
            } else if  (command == 'b') {
                moveBackword();
            } else if (command == 'r') {
                rotateRight();
            } else if (command == 'l'){
                rotateLeft();
            } else {
                throw new RuntimeException("Unknown command");
            }
            
        }
        this.endPunkt = direction + ":" + x + ":" + y;
    }


    private void rotateLeft() {
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

    private void rotateRight() {
        if ("N".equals(direction)) {
            direction = "E";
        } else if ("E".equals(direction)) {
            direction = "S";
        } else if ("S".equals(direction)) {
            direction = "W";
        } else {
            direction = "N";
        }
    }

    private void moveForward() {
        if ("N".equals(direction)) {
            this.y++;
        } else if ("E".equals(direction)) {
            this.x++;
        } else if ("W".equals(direction)) {
            this.x--;
        }else if ("S".equals(direction)){
            this.y--;
        }
    }
    
    private void moveBackword() {
        if ("N".equals(direction)) {
            this.y--;
        } else if ("E".equals(direction)) {
            this.x--;
        } else if ("W".equals(direction)) {
            this.x++;
        }else if ("S".equals(direction)){
            this.y++;
        }
    }
}

