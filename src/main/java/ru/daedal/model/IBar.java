package ru.daedal.model;

public interface IBar {
    long getPlayerId();

    void startUpdate();
    void stopUpdate();

    String toString();
}