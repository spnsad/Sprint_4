import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameToEmbossTest {

    private final String embossingName;
    private final boolean expectedEmbossResult;
    private final String caseName;

    public CheckNameToEmbossTest(String embossingName, boolean expectedEmbossResult, String caseName) {
        this.embossingName = embossingName;
        this.expectedEmbossResult = expectedEmbossResult;
        this.caseName = caseName;
    }

    @Parameterized.Parameters(name = "{2}, ожидаемый результат - {1}")
    public static Object[][] getEmbossResult() {
        return new Object[][] {
                {"К Р", true, "Длина имени 3 символа, 1 пробел"},
                {"Абвгдежз Ийклмнопрс", true, "Длина имени 19 символов, 1 пробел"},
                {"АБВ", false, "Длина имени 3 символа, без пробелов"},
                {"АбвгдежзИйклмнопрст", false, "Длина имени 19 символов, без пробелов"},
                {"КиануРивз ", false, "Длина имени от 3 до 19 символов, пробел в конце"},
                {" КиануРивз", false, "Длина имени от 3 до 19 символов, пробел в начале"},
                {"Я Киану Ривз", false, "Длина имени от 3 до 19 символов, >1 пробелов"},
                {"Я ", false, "Длина имени < 3 символов, 1 пробел"},
                {"Абвгдежз Ийклмнопрст", false, "Длина имени > 19 символов, 1 пробел"},
        };
    }

    @Test
    public void doesNameCanBeEmboss(){
        Account account = new Account(embossingName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedEmbossResult, actual);
    }

    @Test
    public void doesNameCanBeEmbossByPattern(){
        Account account = new Account(embossingName);
        boolean actual = account.checkNameToEmbossByPattern();
        assertEquals(expectedEmbossResult, actual);
    }
}
