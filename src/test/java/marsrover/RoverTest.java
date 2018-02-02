package marsrover;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoverTest {

    @Test
    void without_move_rover_should_finish_at_given_startpoint() {
        // given
        String expectedEndPoint = "N:0:0";
        // when
        String endPunkt = new Rover().endPunkt();
        // then
        assertThat(endPunkt).isEqualTo(expectedEndPoint);
    }

    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"f, N:0:1"
            ,"ff, N:0:2"
            ,"fff, N:0:3"
    })
    void shouldMoveForward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"b, N:0:-1"
            ,"bb, N:0:-2"
            ,"bbb, N:0:-3"
    })
    void shouldMoveBackward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "r, E:0:0"
            ,"rr, S:0:0"
            ,"rrr, W:0:0"
            ,"rrrr, N:0:0"
            ,"rrrrr, E:0:0"
    })
    void shouldTurnRight(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }


    @ParameterizedTest
    @CsvSource({
            "l, W:0:0"
            ,"ll, S:0:0"
            ,"lll, E:0:0"
            ,"llll, N:0:0"
            ,"lllll, W:0:0"
    })
    void shouldTurnLeft(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"rf, E:1:0"
            ,"rff, E:2:0"
            ,"rfff, E:3:0"
    })
    void shouldTurnRightAndMoveForward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"lf, W:-1:0"
            ,"lff, W:-2:0"
            ,"lfff, W:-3:0"
    })
    void shouldTurnLeftAndMoveForward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"llf, S:0:-1"
            ,"llff, S:0:-2"
            ,"llfff, S:0:-3"
    })
    void shouldTurnLeftTwiceAndMoveForward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"rb, E:-1:0"
            ,"rbb, E:-2:0"
            ,"rbbb, E:-3:0"
    })
    void shouldTurnRightAndMoveBackward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"lb, W:1:0"
            ,"lbb, W:2:0"
            ,"lbbb, W:3:0"
    })
    void shouldTurnLeftAndMoveBackward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @ParameterizedTest
    @CsvSource({
            "'', N:0:0"
            ,"llb, S:0:1"
            ,"llbb, S:0:2"
            ,"llbbb, S:0:3"
    })
    void shouldTurnLeftTwiceAndMoveBackward(String commands, String expectedEndPoint) {
        testMove(commands, expectedEndPoint);
    }
    
    @Test
    void testUnknownDirection() {
    		try {
    			new Rover().move("rf?".toCharArray());
    		}catch (RuntimeException e) {
    			assertEquals(e.getMessage(), "Unknown command");
    		}
    }
    

    private void testMove(String commands, String expectedEndPoint) {
        // given
        Rover rover = new Rover();
        // when
        rover.move(commands.toCharArray());
        String endPunkt= rover.endPunkt();
        // then
        assertThat(endPunkt).isEqualTo(expectedEndPoint);
    }
    
}