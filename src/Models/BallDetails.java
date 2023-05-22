package Models;

import ScoreUpdater.BattingScoreUpdater;
import ScoreUpdater.BowlingScoreUpdater;
import ScoreUpdater.ScoreUpdaterObserver;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    public int ballNumber;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public Wicket wicket;
    public RunType runType;
    public BallType ballType;
    List<ScoreUpdaterObserver> scoreUpdaterObservers= new ArrayList<>();

    public BallDetails(int ballNumber){
        this.ballNumber=ballNumber;
        scoreUpdaterObservers.add(new BattingScoreUpdater());
        scoreUpdaterObservers.add(new BowlingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over){
        playedBy=battingTeam.getStriker();
        this.bowledBy=over.bowledBy;
        ballType=BallType.NORMAL;

        if(isWicketTaken()){
            runType=RunType.ZERO;
            wicket=new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over, this);
            battingTeam.setStriker(null);
        }else{
            runType=getRunType();
        }

        if(runType == RunType.ONE || runType == RunType.THREE){
            PlayerDetails temp=battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }

        notifyUpdaters(this);
    }

    public void notifyUpdaters(BallDetails ballDetails){
        for(ScoreUpdaterObserver observer: scoreUpdaterObservers){
            observer.update(ballDetails);
        }
    }

    public boolean isWicketTaken(){
        if(Math.random()<0.2){
            return true;
        }else{
            return false;
        }
    }

    public RunType getRunType(){
        double x=Math.random();
        if(x<=0.2){
            return RunType.ONE;
        }
        if(x>0.3 && x<=0.5){
            return RunType.TWO;
        }
        if(x>0.5 && x<=0.8){
            return RunType.FOUR;
        }else{
            return RunType.SIX;
        }
    }


}
