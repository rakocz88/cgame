package com.pilaf.cgame.shared.valueobject;

public enum SaneLevel {
    TERRORIZED(0), SHAKEN(1), UNSTABLE(2), RESTLESS(3), MOTIVATED(4);
    private int lvl;

    SaneLevel(int lvl) {
        this.lvl = lvl;
    }
}
