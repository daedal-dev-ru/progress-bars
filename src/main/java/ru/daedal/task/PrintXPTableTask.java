package ru.daedal.task;

import ru.daedal.model.IBar;
import ru.daedal.service.BarService;

import java.util.TimerTask;

public class PrintXPTableTask extends TimerTask {
    private final String pattern = "Experience of player %d: %s";

    @Override
    public void run() {
        System.out.println("------------------------------------------------------------");
        for (IBar xpBar : BarService.getBars()) {
            System.out.printf((pattern) + "%n", xpBar.getPlayerId(), xpBar);
        }
        System.out.println("------------------------------------------------------------");
    }
}
