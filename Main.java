package wuerfelspiel;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("⚀ ⚁ ⚂ ⚃ ⚄ ⚅ CODE START ⚅ ⚄ ⚃ ⚂ ⚁ ⚀");
        System.out.println(" ");
        System.out.println("Welcome to my first Java program ever! (^０^)ノ");
        System.out.println("This is a game where you roll a dice every turn. Each roll will be added to your score.");
        System.out.println("The person with the highest score wins! ヾ(・ω・)メ(・ω・)ノ");
        System.out.println(" ");
        System.out.println("⬇ In order to play, please enter your names. Once you're done, type 'stop'! ⬇");

        Scanner s = new Scanner (System.in);
        String line;
        Scoreboard scoreboard = new Scoreboard();

        while ((line=s.nextLine())!=null){

            if (line.contentEquals("stop"))

                break;

            Player p = new Player();
            p.setName(line);
            scoreboard.updateMap(p,0);
            System.out.println("You entered: "+ line + "! What a pretty name! ♥");
            System.out.println("Player " + line +  " successfully added to player list!");
            System.out.println(" ");
            System.out.println("Type another name, or type 'stop'!");
        }

        System.out.println("OK! ＼(＾▽＾)／");

        System.out.println("How many rounds would you like to play?");
        int turnNumber = 0;

        try {
            turnNumber = s.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("That's not a number, dude...(¯ . ¯;)");
            System.out.println("Restart the game and try again.");
            System. exit(0);
        }

        System.out.println("Got it!");

        Dice diceRoll = new Dice();
        int rand;

        System.out.println("⚀ ⚁ ⚂ ⚃ ⚄ ⚅ GAME START ⚅ ⚄ ⚃ ⚂ ⚁ ⚀");

        for (int i=1; i<=turnNumber;i++) {

            HashMap<Player,Integer> playersscores = scoreboard.getScoreboard();


            for (Map.Entry<Player, Integer> entry : playersscores.entrySet()) {
                Player key = entry.getKey();
                String name = entry.getKey().getName();
                Integer score = entry.getValue();
                System.out.println(" ");
                System.out.println("★ " + "It's your turn, " + name + "! ★");
                rand = diceRoll.randomNumber();
                scoreboard.updateMap(key, score+rand);
                Integer value = entry.getValue();
                System.out.println( name + ", your score has been updated to " + value + "!" );
            }
            System.out.println(" ");
            System.out.println("Round " + i + " is over!");
            System.out.println(" ");
        }

        System.out.println("⚀ ⚁ ⚂ ⚃ ⚄ ⚅ GAME END ⚅ ⚄ ⚃ ⚂ ⚁ ⚀");
        System.out.println(" ");
        System.out.println("⬇ YOUR RANKING ⬇");
        System.out.println(" ");

        LinkedHashMap<String, Integer> placements = scoreboard.sortHashMap();


        for (Map.Entry<String, Integer> entry : placements.entrySet()) {
                Integer place = entry.getValue();
                String name = entry.getKey();
                System.out.println("★ " + place + ". place: " + name + "!" + " ★");
            }

        System.out.println(" ");
        System.out.println("Thanks for playing! (*/ω＼)");
        System.out.println(" ");
        System.out.println("⚀ ⚁ ⚂ ⚃ ⚄ ⚅ CODE END ⚅ ⚄ ⚃ ⚂ ⚁ ⚀");

        }


    }
