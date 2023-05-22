package Controllers;

import Models.PlayerDetails;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<PlayerDetails> yetToPlay;

    public PlayerDetails getStriker() {
        return striker;
    }

    public void setStriker(PlayerDetails striker) {
        this.striker = striker;
    }

    public PlayerDetails getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        this.nonStriker = nonStriker;
    }

    private PlayerDetails striker;
    private PlayerDetails nonStriker;

    public PlayerBattingController(Queue<PlayerDetails> player11){
        this.yetToPlay=new LinkedList<>();
        this.yetToPlay.addAll(player11);
    }

    public void getNextPlayer() throws Exception{
        if(yetToPlay.isEmpty()){
            throw new Exception();
        }
        if(striker==null){
            yetToPlay.poll();
        }
        if(nonStriker==null){
            yetToPlay.poll();
        }
    }
}
