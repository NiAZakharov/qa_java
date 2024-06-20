import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    public String animalKind;
    public List<String> animalFood;

    public AnimalTest(String animalKind, List<String> animalFood) {
        this.animalKind = animalKind;
        this.animalFood = animalFood;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Млекопитающее", List.of("Все что видит", "Бобы", "Листья")}
        };
    }

    @Test ()
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        try {
            assertEquals(animalFood, animal.getFood(animalKind));
        } catch (Exception e) {
            assertEquals(
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage());
        }
    }

    @Test
    public void getAnimalFamilyTest() {
        Animal animal = new Animal();
        assertEquals("",
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }

    @Test(expected = Exception.class)
    public void createAnimalThrowsException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("");
    }


}
