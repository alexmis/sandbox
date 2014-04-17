package org.mial.training;

import org.mial.training.quoter.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BenchmarkMain {

    /**
     * Run jvisualvm
     * <p/>
     * (Tool -> Plugins: add JavaVM-MBeans plugin )
     * Open process:
     * Tab MBeans:
     * benchmark -> change value benchmarkFlag
     */
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Quoter terminatorQuoter = (Quoter) context.getBean("terminatorQuoter");

        while (true) {
            terminatorQuoter.sayQuote();
            Thread.sleep(10);
        }
    }
}
