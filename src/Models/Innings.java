package Models;

import MatchDetails.MatchType;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    public Team battingTeam;
    public  Team bowlingTeam;
    List<OverDetails> overs;
    MatchType matchType;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType){
        this.battingTeam=battingTeam;
        this.bowlingTeam=bowlingTeam;
        this.matchType=matchType;
        overs=new ArrayList<>();
    }

    public void start(int runsToWin){
        try{
            battingTeam.nextBatsMan();
        }catch (Exception e){

        }

        int noOfOver=matchType.noOfOvers();
        for(int overNo=1 ; overNo<=noOfOver; overNo++){
            OverDetails over=new OverDetails(overNo,bowlingTeam.getCurrentBowler());
            overs.add(over);
            try{
                boolean won=over.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won==true){
                    break;
                }
            }catch(Exception e){
                break;
            }

            PlayerDetails temp=battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);

        }
    }
    public int runsToWin(){
        return battingTeam.getTotalRuns();
    }
}
