package marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.google.common.truth.Truth.assertThat;

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