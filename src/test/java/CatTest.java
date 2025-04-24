import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline mockFeline;

    @Test
    public void catSoundIsMeow() {
        assertEquals("Мяу", new Cat(mockFeline).getSound());
    }

    @Test
    public void getFoodCallsFeline() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Мясо"));
        assertEquals(List.of("Мясо"), new Cat(mockFeline).getFood());
    }
}