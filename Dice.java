package wuerfelspiel;
import java.util.Random;
import java.util.Scanner;

public class Dice {


    Scanner enter = new Scanner(System.in);
    public int randomNumber(){
        System.out.println("Press Enter to roll a die!");
        enter.nextLine();
        System.out.print("You rolled a ");
        Random random = new Random();
        int rand = random.nextInt(6) + 1;
        System.out.println(rand + "!");
        return rand;
    }
            
}
