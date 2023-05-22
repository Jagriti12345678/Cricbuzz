package Controllers;

import Models.PlayerDetails;

import java.util.*;

public class PlayerBowlingController {

    Deque<PlayerDetails> bowlersList;
    PlayerDetails currBowler;
    Map<PlayerDetails, Integer> bowlerVsOverCount;

    public PlayerBowlingController(List<PlayerDetails> bowlers){
        setBowlersList(bowlers);
    }

    public void setBowlersList(List<PlayerDetails> playerDetails){
        bowlersList=new LinkedList<>();
        bowlerVsOverCount= new HashMap<>();
        for(PlayerDetails bowler: bowlersList){
            this.bowlersList.addLast(bowler);
            this.bowlerVsOverCount.put(bowler,0);
        }
    }

    public PlayerDetails getCurrBowler() {
        return currBowler;
    }

    public void getNextBowler(int maxOverCountPerBowler){
        PlayerDetails playerDetails=bowlersList.poll();
        if(bowlerVsOverCount.get(playerDetails) + 1== maxOverCountPerBowler){
            currBowler=playerDetails;
        }else{
            currBowler=playerDetails;
            bowlersList.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }

    }
}
