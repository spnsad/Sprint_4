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
}