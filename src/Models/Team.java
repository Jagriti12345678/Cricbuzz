package Models;

import Controllers.PlayerBattingController;
import Controllers.PlayerBowlingController;

import java.util.List;
import java.util.Queue;

public class Team {
    public String teamName;
    Queue<PlayerDetails> playing11;
    List<PlayerDetails> bench;
    PlayerBowlingController playerBowlingCOntroller;
    PlayerBattingController playerBattingController;
    public boolean isWinner;

    public Team(String teamName, Queue<PlayerDetails> playing11, List<PlayerDetails> bench, List<PlayerDetails> bowlers){
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        playerBattingController = new PlayerBattingController(playing11);
        playerBowlingCOntroller = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void nextBatsMan() throws Exception{
        playerBattingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverPerBowler){
        playerBowlingCOntroller.getNextBowler(maxOverPerBowler);
    }

    public PlayerDetails getStriker(){
        return playerBattingController.getStriker();
    }

    public PlayerDetails getNonStriker(){
        return playerBattingController.getNonStriker();
    }

    public void setStriker(PlayerDetails player){
        playerBattingController.setStriker(player);
    }

    public void setNonStriker(PlayerDetails player){
        playerBattingController.setNonStriker(player);
    }

    public void printBattingScoreCard(){
        for(PlayerDetails playerDetails: playing11){
            playerDetails.printBattingScoreCard();
        }
    }

    public PlayerDetails getCurrentBowler(){
        return playerBowlingCOntroller.getCurrBowler();
    }

    public void printBowlingScoreCard(){
        for(PlayerDetails playerDetails: playing11){
            playerDetails.printBowlingScoreCard();
        }
    }

    public int getTotalRuns(){
        int totalRuns=0;
        for(PlayerDetails playerDetails: playing11){
            totalRuns+= playerDetails.battingScoreCard.totalRuns;
        }
        return totalRuns;
    }
}
