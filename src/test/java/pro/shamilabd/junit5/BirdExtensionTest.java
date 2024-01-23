package pro.shamilabd.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BirdExtensionTest {

    @Mock
    Beak beak;
    @InjectMocks
    SimpleBird titmouse;

    @Test
    public void automaticMock() {
        System.out.println("--- Automatic extension mock test ---");
        when(beak.getColor()).thenReturn("red");

        String beakColor = titmouse.getBeak().getColor();

        Assertions.assertEquals("red", beakColor);
    }

    @Test
    public void paramInjectTest(@Mock Beak beak2) {
        System.out.println("--- param inject test ---");
        when(beak2.getColor()).thenReturn("red");
        SimpleBird titmouse2 = new SimpleBird(beak2);

        String beakColor = titmouse2.getBeak().getColor();

        Assertions.assertEquals("red", beakColor);
    }
}
