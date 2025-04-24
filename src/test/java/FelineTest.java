import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {
    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", new Feline().getFamily());
    }

    @Test
    public void getKittensWithoutArgReturnsOne() {
        assertEquals(1, new Feline().getKittens());
    }

    @Test
    public void getKittensWithArgReturnsSameNumber() {
        assertEquals(3, new Feline().getKittens(3));
    }
}