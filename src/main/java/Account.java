import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name.length()<= 19 && name.length()>=3) {
            if (!name.startsWith(" ") && !name.endsWith(" ")) {
                if(name.length() - name.replace(" ", "").length() == 1){
                    return true;
                }
                else {
                    System.out.println("В имени должен быть один пробел");
                    return false;
                }
            }
            else {
                System.out.println("Первый и последний символы не должны быть пробелами");
                return false;
            }
        }
        else {
            System.out.println("В имени должно быть не меньше 3 и не больше 19 символов");
            return false;
        }
    }

    private static final String namePattern = "(?=.{3,19}$)[а-яА-Яa-zA-z]+\\s{1}[а-яА-Яa-zA-z]+";
    private static final Pattern pattern = Pattern.compile(namePattern);
    public boolean checkNameToEmbossByPattern() {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}