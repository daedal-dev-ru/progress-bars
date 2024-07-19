package ru.daedal.model;

import ru.daedal.data.PlayerDatabase;

public class PlayerDatabaseSource implements IValueSource {
    @Override
    public long getValue(long playerId) {
        return PlayerDatabase.playerXp.get(playerId);
    }
}