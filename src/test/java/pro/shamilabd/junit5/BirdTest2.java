package pro.shamilabd.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BirdTest2 {

    @Mock
    Beak beak;
    @InjectMocks
    SimpleBird titmouse;
    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    public void automaticMock() {
        System.out.println("--- Automatic mock test ---");
        when(beak.getColor()).thenReturn("red");
//        Bird titmouse = new Bird("Tom", 2, "yellow", beak);

        String beakColor = titmouse.getBeak().getColor();

        Assertions.assertEquals("red", beakColor);
    }
}
