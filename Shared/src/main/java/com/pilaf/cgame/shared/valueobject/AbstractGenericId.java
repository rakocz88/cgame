package com.pilaf.cgame.shared.valueobject;

import lombok.Data;

import java.util.UUID;

@Data
public class AbstractGenericId implements GenericId {
    private UUID id;

    AbstractGenericId(UUID id){
        this.id = id;
    }

}
