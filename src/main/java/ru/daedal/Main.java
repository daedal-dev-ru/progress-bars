package ru.daedal;

import ru.daedal.model.XPBar;
import ru.daedal.task.PrintXPTableTask;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        XPBar bar0 = new XPBar(0);
        XPBar bar1 = new XPBar(1);
        XPBar bar2 = new XPBar(2);
        XPBar bar3 = new XPBar(3);

        Timer timer = new Timer();
        timer.schedule(new PrintXPTableTask(), 0L, 800L);
    }
}