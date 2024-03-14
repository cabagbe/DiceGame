package wuerfelspiel;
import java.util.*;
import java.util.stream.Collectors;

public class Scoreboard {

    HashMap<Player, Integer> playersscores = new HashMap<>();

    public void updateMap(Player p, Integer score){

        playersscores.put(p,score);
    }

    public LinkedHashMap<String,Integer> sortHashMap(){


        playersscores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int place =  1;

        LinkedHashMap<String, Integer> placing = new LinkedHashMap<>();

        for (Map.Entry<Player, Integer> entry : playersscores.entrySet()) {  // geht die ganze HashMap durch
            String name = entry.getKey().getName();                         // holt sich Namen Attribut von Key
            placing.put(name, place);
            place++;
        }

        return placing;

    }

    public HashMap<Player, Integer> getScoreboard() {
        return playersscores;
    }
}
