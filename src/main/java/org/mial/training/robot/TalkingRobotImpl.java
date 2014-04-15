package org.mial.training.robot;

import org.mial.training.quoter.Quoter;

import java.util.List;

public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    @Override
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }
}
