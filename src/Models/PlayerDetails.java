package Models;

public class PlayerDetails {
    public Person person;
    public PlayerType playerType;
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;

    public PlayerDetails(Person person, PlayerType playerType){
        this.person = person;
        this.playerType = playerType;
        battingScoreCard = new BattingScoreCard();
        bowlingScoreCard = new BowlingScoreCard();
    }


    public void printBattingScoreCard(){
        System.out.println("Player name: "+ person.name + "---- total runs: "+ battingScoreCard.totalRuns + "----total balls played: "+battingScoreCard.totalBallsPlayed + "--total 4's: "+battingScoreCard.totalFours+ "total 6's: "+battingScoreCard.totalSix + ((battingScoreCard.wicketDetails!=null) ? battingScoreCard.wicketDetails.takenBy.person.name : "not out"));
    }

    public void printBowlingScoreCard(){
        System.out.println("Player name: "+person.name + "--total overs bowled: "+bowlingScoreCard.totalOversCount+"--total runs given: "+bowlingScoreCard.runsGiven + "--wickets taken: "+ bowlingScoreCard.wicketsTaken);
    }
}
