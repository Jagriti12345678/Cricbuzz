package MatchDetails;

import Models.Innings;
import Models.Team;

import java.util.Date;

public class Match {
    public Team teamA;
    public Team teamB;
    public Innings[] innings;
    public MatchType matchType;
    public Team tossWinner;
    String venue;
    Date matchDate;

    public Match(Team teamA, Team teamB, Date matchDate, String venue, MatchType matchType){
        this.teamA=teamA;
        this.teamB=teamB;
        this.matchDate=matchDate;
        this.venue=venue;
        this.matchType=matchType;
        this.innings=new Innings[2];
    }

    public void startMatch(){
        Team tosswinner=toss(teamA, teamB);
        for (int inning=1; inning<=2; inning++){
            Innings inningDetails;
            Team battingTeam;
            Team bowlingTeam;
            boolean isChasing=false;

            if(inning==1){
                battingTeam=tossWinner;
                bowlingTeam=tosswinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails=new Innings(battingTeam, bowlingTeam, matchType);
                inningDetails.start(-1);
            }else{
                bowlingTeam=tosswinner;
                battingTeam=tosswinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails=new Innings(battingTeam, bowlingTeam, matchType);
                if(bowlingTeam.getTotalRuns()>battingTeam.getTotalRuns()){
                    bowlingTeam.isWinner=true;
                }
            }
            //inningDetails[inningDetails-1]=innings;
            innings[inning-1] = inningDetails;
            System.out.println();
            System.out.println("Inning: " + inning + "--total runs: " + battingTeam.getTotalRuns());
            System.out.println("Scorecard: " + battingTeam.getTeamName()+ "--");
            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("ScoreCard: " + bowlingTeam.getTeamName() + "--");
            bowlingTeam.printBowlingScoreCard();
        }
        System.out.println();
        if(teamA.isWinner){
            System.out.println("winner is: "+ teamA.getTeamName());
        }else{
            System.out.println("winner is: " + teamB.getTeamName());
        }

    }

    private Team toss(Team A, Team B){
        if(Math.random()<0.5){
            return teamA;
        }else{
            return teamB;
        }
    }
}
