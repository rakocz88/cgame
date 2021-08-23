package com.pilaf.cgame.shared.valueobject;

public enum DiceLvl {
    POOR(0), COMMON(1), JOURNEYMAN(2), ADVANCED(3),
    PROFESSIONAL(4), EXPERT(5), MASTER(6), GRANDMASTER(7);

    private int lvl;

    DiceLvl(int lvl) {
        this.lvl = lvl;
    }
}
