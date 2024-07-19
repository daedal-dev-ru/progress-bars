package ru.daedal.task;

import lombok.RequiredArgsConstructor;
import ru.daedal.model.IValueSource;
import ru.daedal.api.Bar;
import ru.daedal.data.Config;
import ru.daedal.model.XPBar;

import java.util.TimerTask;

@RequiredArgsConstructor
public class XPBarUpdaterTask extends TimerTask {
    private final long playerId;
    private final XPBar experienceBar;
    private final IValueSource experienceValueSource;

    private final double barXpStep = (double) Config.XP_STEP / Config.BAR_LENGTH;

    private long previousValue = 0;

    @Override
    public void run() {
        long playerXp = experienceValueSource.getValue(playerId);

        if (playerXp == previousValue) {
            return;
        }
        previousValue = playerXp;

        long playerLevel = playerXp / Config.XP_STEP;
        long playerNextLevelXp = (playerLevel + 1) * Config.XP_STEP;
        int fullBarsCount = (int) Math.floor((Config.XP_STEP - (playerNextLevelXp - playerXp)) / barXpStep);
        for (int i = 0; i < Config.BAR_LENGTH; i++) {
            if (i < fullBarsCount) {
                experienceBar.getBars().add(Bar.FULL);
                continue;
            }

            experienceBar.getBars().add(Bar.EMPTY);
        }
    }
}
