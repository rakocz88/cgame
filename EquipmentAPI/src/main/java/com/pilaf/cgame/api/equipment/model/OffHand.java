package com.pilaf.cgame.api.equipment.model;

import com.pilaf.cgame.shared.interfaces.HandUsable;
import com.pilaf.cgame.shared.interfaces.Item;
import lombok.Value;

@Value
public class OffHand implements HandUsable, Item {

    @Override
    public int getSpeedPenalty() {
        return 0;
    }
}
