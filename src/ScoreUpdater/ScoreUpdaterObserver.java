package ScoreUpdater;

import Models.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ball);
}
