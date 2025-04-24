import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final Boolean expectedHasMane;
    private final Class<? extends Exception> expectedException;
    private static final Predator mockPredator = mock(Predator.class);

    public LionParameterizedTest(String sex, Boolean expectedHasMane,
                                 Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedException = expectedException;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, null},    // корректный самец
                {"Самка", false, null},   // корректная самка
                {"Неизвестно", null, Exception.class} // некорректный пол
        });
    }

    @Test
    public void testLionCreation() throws Exception {
        if (expectedException != null) {
            assertThrows(expectedException, () -> new Lion(sex, mockPredator));
        } else {
            Lion lion = new Lion(sex, mockPredator);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        if (expectedException == null) {
            List<String> expectedFood = List.of("Мясо");
            when(mockPredator.eatMeat()).thenReturn(expectedFood);

            Lion lion = new Lion(sex, mockPredator);
            assertEquals(expectedFood, lion.getFood());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        if (expectedException == null) {
            when(mockPredator.getKittens()).thenReturn(3);
            Lion lion = new Lion(sex, mockPredator);
            assertEquals(3, lion.getKittens());
        }
    }
}