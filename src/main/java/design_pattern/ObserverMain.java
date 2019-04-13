package design_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {
        Subject f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new Lemonde());
        f.notifyObservers(" The queen said her favourite book is Java 8 inAction");

        Feed feedLambda = new Feed();
        feedLambda.registerObserver((tweet -> {
            if (tweet != null && tweet.contains("money"))
                System.out.println("Breaking news in NY!" + tweet);
        }));
        feedLambda.registerObserver((tweet -> {
            if (tweet != null && tweet.contains("queen"))
                System.out.println("Yet another new in London..." + tweet);
        }));
        feedLambda.registerObserver((tweet -> {
            if (tweet != null && tweet.contains("wine"))
                System.out.println("Today cheese,wine and news!" + tweet);
        }));
        feedLambda.notifyObservers(" Money money money,give me money");
    }

    interface Observer {
        void inform(String tweet);
    }

    interface Subject {
        void registerObserver(Observer o);

        void notifyObservers(String tweet);
    }

    private static class NYTimes implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("money"))
                System.out.println("Breaking news in NY!" + tweet);
        }
    }

    private static class Guardian implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("queen"))
                System.out.println("Yet another new inLondon..." + tweet);
        }
    }

    private static class Lemonde implements Observer {
        @Override
        public void inform(String tweet) {
            if (tweet != null && tweet.contains("wine"))
                System.out.println("Today cheese,wine and news!" + tweet);
        }
    }

    private static class Feed implements Subject {
        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer o) {
            this.observers.add(o);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.inform(tweet));
        }
    }
}
