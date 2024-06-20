import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void getEatMeatTest() throws Exception {
        Feline feline = new Feline();
        assertEquals(
                "Рацион хищника нарушен",
                feline.eatMeat(),
                feline.getFood("Хищник"));
    }

    @Test
    public void getFamilyReturnIsCorrect() {
        String expectedFelineFamilyReturn = "Кошачьи";
        assertEquals(
                "Это животное не принадлежит к семейству кошачьих",
                new Feline().getFamily(),
                expectedFelineFamilyReturn);
    }

    @Test
    public void getKittensCountIsCorrect() {
        int expectedCountOfKittens = 7;
        assertEquals(
                "Неверное количество котят",
                new Feline().getKittens(expectedCountOfKittens),
                expectedCountOfKittens);
    }

    @Test
    public void getKittensIsDefaultValue() {
        int expectedCountOfKittens = 1;
        assertEquals(
                "Неверное количество котят",
                new Feline().getKittens(),
                expectedCountOfKittens);
    }
}
