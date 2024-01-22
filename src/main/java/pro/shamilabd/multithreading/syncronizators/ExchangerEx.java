package pro.shamilabd.multithreading.syncronizators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
public class ExchangerEx {
    private static List<Action> actions;

    public static void main(String[] args) {
        actions = new ArrayList<>();
        actions.add(Action.KAMEN);
        actions.add(Action.NOJNICI);
        actions.add(Action.BUMAGA);
        Exchanger<Action> justice = new Exchanger<>();
        Gamer gamer1 = new Gamer("Dima", justice, actions);
        Gamer gamer2 = new Gamer("Anna", justice, actions);
        gamer1.start();
        gamer2.start();
    }
}

enum Action {
    KAMEN, NOJNICI, BUMAGA
}

class Gamer extends Thread {
    private String name;
    private Exchanger<Action> exchanger;
    private Random random;
    private List<Action> actions;

    public Gamer(String name, Exchanger<Action> exchanger, List<Action> actions) {
        this.name = name;
        this.exchanger = exchanger;
        this.actions = actions;
        random = new Random();
    }

    @Override
    public void run() {
        Action rivalAction = null;
        Action myAction = actions.get(random.nextInt(3));
        System.out.println(name + " выбрал " + myAction);
        try {
            rivalAction = exchanger.exchange(myAction);
            whoWin(myAction, rivalAction);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void whoWin(Action myAction, Action rivalAction) {
        if ((myAction == Action.BUMAGA && rivalAction == Action.KAMEN)
                || (myAction == Action.KAMEN && rivalAction == Action.NOJNICI)
                || (myAction == Action.NOJNICI && rivalAction == Action.BUMAGA)) {
            System.out.println("Победил " + name);
        } else if (myAction == rivalAction) {
            System.out.println("Ничья"); // тут косяк, 2 раза выйдет
        }
    }
}