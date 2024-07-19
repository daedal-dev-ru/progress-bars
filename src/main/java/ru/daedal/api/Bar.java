package ru.daedal.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.daedal.data.Config;

@Getter
@RequiredArgsConstructor
public enum Bar {
    FULL(Config.BAR_FULL),
    EMPTY(Config.BAR_EMPTY);

    private final String value;
}