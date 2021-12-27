
public class Praktikum {

    private static String embossingName;

    public static void main(String[] args) {

        Account account = new Account(embossingName);
        System.out.println(account.checkNameToEmboss());
    }
}