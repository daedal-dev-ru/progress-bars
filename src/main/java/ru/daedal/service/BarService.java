package ru.daedal.service;

import lombok.Getter;
import ru.daedal.model.IBar;

import java.util.HashSet;
import java.util.Set;

public class BarService {
    @Getter
    private static final Set<IBar> bars = new HashSet<>();

    public static void add(IBar bar) {
        bars.add(bar);
    }

    public static void remove(IBar bar) {
        bars.remove(bar);
    }
}
