package com.pilaf.cgame.shared.valueobject;

public enum FatigueLevel {
    FINISHED(0), WORN_OUT(1), TIRED(2) , SLIGHTLY_TIRED(3), FRESH(4);
    private int lvl;

    FatigueLevel(int lvl) {
        this.lvl = lvl;
    }
}
