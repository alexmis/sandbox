package org.mial.training.robot;

import org.mial.training.quoter.Quoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TalkingRobotImpl implements TalkingRobot {

    @Autowired
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
