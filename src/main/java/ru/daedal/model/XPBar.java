package ru.daedal.model;

import lombok.Getter;
import ru.daedal.service.BarService;
import ru.daedal.task.XPBarUpdaterTask;
import ru.daedal.api.Bar;
import ru.daedal.data.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class XPBar implements IBar {
    @Getter
    private final List<Bar> bars = new ArrayList<>();

    @Getter
    private List<Bar> cache;
    private String cachedString;

    @Getter
    private long playerId;

    private final XPBarUpdaterTask updaterTask;

    public XPBar(long playerId) {
        BarService.add(this);
        this.playerId = playerId;
        this.updaterTask = new XPBarUpdaterTask(playerId, this, new PlayerDatabaseSource());
        startUpdate();
    }

    @Override
    public void startUpdate() {
        Timer timer = new Timer();
        timer.schedule(updaterTask, 0L, Config.BAR_UPDATE_PERIOD);
    }

    @Override
    public void stopUpdate() {
        this.updaterTask.cancel();
    }

    @Override
    public String toString() {
        if (cache != null) {
            if (bars.lastIndexOf(Bar.FULL) == cache.lastIndexOf(Bar.FULL) ) { return cachedString; }
        }

        StringBuilder sb = new StringBuilder();
        bars.forEach(bar -> sb.append(bar.getValue()));

        this.cache = bars;
        this.cachedString = sb.toString();

        return sb.toString();
    }
}
