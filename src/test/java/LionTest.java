import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class LionTest {

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(2);
        assertEquals(
                "Количество котят не равно",
                2,
                lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertEquals(
                "У взрослых львов должна быть грива",
                true,
                lion.doesHaveMane());
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(feline, "Самец");
        assertEquals(
                "Рацион хищника нарушен",
                List.of("Животные", "Птицы", "Рыба"),
                lion.getFood());
    }

    @Test(expected = Exception.class)
    public void createLionThrowsException() throws Exception {
        new Lion(feline, "Нечто");
    }

}
