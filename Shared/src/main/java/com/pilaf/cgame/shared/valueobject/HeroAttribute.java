package com.pilaf.cgame.shared.valueobject;

import lombok.Value;

@Value
public class HeroAttribute {
    HeroAttributeType heroAttributeType;
    Integer value;
}
