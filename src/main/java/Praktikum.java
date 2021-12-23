import org.junit.Assert;

public class Praktikum {

    private static String embossingName;

    public static void main(String[] args) {

        Account account = new Account(embossingName);
        Assert.assertTrue("Имя не может быть напечатано", account.checkNameToEmboss());
    }
}