import java.util.HashMap;
import java.util.Scanner;


public class compress {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, String> name = new HashMap<String, String>();
        String user_id = input.nextLine();
        String pass = input.nextLine();
        name.put(user_id, pass);
        String user_id1 = input.nextLine();
        String pass1 = input.nextLine();
        for (String m : name.keySet()) {
            if (user_id1.equals(m.toString()) && pass1.equals(name.get(m).toString())) {
                P2_javatest n = new P2_javatest();
            }
        }
    }

}
