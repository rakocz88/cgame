package com.pilaf.cgame.shared.valueobject;

import com.pilaf.cgame.shared.interfaces.MutableParameter;
import com.pilaf.cgame.shared.valueobject.HeroAttribute;
import com.pilaf.cgame.shared.valueobject.HeroAttributeType;
import lombok.Value;

import java.util.EnumMap;
import java.util.Map;

@Value
public class HeroAttributesMap implements MutableParameter {

    private  Map<HeroAttributeType, Integer> heroAttributeMap;

    public Map<HeroAttributeType, Integer> init(){
        Map<HeroAttributeType, Integer> heroAttributeMap = new EnumMap(HeroAttributeType.class);
        heroAttributeMap.put(HeroAttributeType.STRENTH, 2);
        heroAttributeMap.put(HeroAttributeType.CONSTITUTION, 2);
        heroAttributeMap.put(HeroAttributeType.DEXTERIXY, 2);
        heroAttributeMap.put(HeroAttributeType.FLAIR, 2);
        heroAttributeMap.put(HeroAttributeType.KNOWLEDGE, 2);
        heroAttributeMap.put(HeroAttributeType.OBSERVATION, 2);
        heroAttributeMap.put(HeroAttributeType.PERSONALITY, 2);
        return heroAttributeMap;
    };

    public Map<HeroAttributeType, Integer> init(
            HeroAttribute strenthAttribute,
            HeroAttribute constitutionAttribute,
            HeroAttribute dexterityAttribute,
            HeroAttribute flairAttribute,
            HeroAttribute knowledgeAttribute,
            HeroAttribute observationAttribute,
            HeroAttribute personalityAttribute
    ){
        Map<HeroAttributeType, Integer> heroAttributeMap = new EnumMap(HeroAttributeType.class);
        heroAttributeMap.put(HeroAttributeType.STRENTH, strenthAttribute.getValue());
        heroAttributeMap.put(HeroAttributeType.CONSTITUTION, constitutionAttribute.getValue());
        heroAttributeMap.put(HeroAttributeType.DEXTERIXY, dexterityAttribute.getValue());
        heroAttributeMap.put(HeroAttributeType.FLAIR, flairAttribute.getValue());
        heroAttributeMap.put(HeroAttributeType.KNOWLEDGE, knowledgeAttribute.getValue());
        heroAttributeMap.put(HeroAttributeType.OBSERVATION, observationAttribute.getValue());
        heroAttributeMap.put(HeroAttributeType.PERSONALITY, personalityAttribute.getValue());
        return heroAttributeMap;
    };


    public Map<HeroAttributeType, Integer> get(){
        return heroAttributeMap;
    }

    public Integer getAttributeValue(HeroAttributeType heroAttributeType){
        return heroAttributeMap.get(heroAttributeType);
    }
}
