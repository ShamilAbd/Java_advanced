package pro.shamilabd.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class BirdTest {

    @Mock
    Beak beak; // for annotatedMock()

    @Test
    public void simpleMock() {
        System.out.println("--- Simple mock test ---");
//        Beak beak = new Beak("slim", 50, "gray"); // original
        Beak beak = mock(Beak.class); // mock
        when(beak.getColor()).thenReturn("red");
        Bird titmouse = new Bird("Tom", 2, "yellow", beak);

        String beakColor = titmouse.getBeak().getColor();

        Assertions.assertEquals("red", beakColor);
    }

    public void annotatedMock() {
        System.out.println("--- Annotated mock test ---");
        when(beak.getColor()).thenReturn("red");
        Bird titmouse = new Bird("Tom", 2, "yellow", beak);

        String beakColor = titmouse.getBeak().getColor();

        Assertions.assertEquals("red", beakColor);

    }
}
