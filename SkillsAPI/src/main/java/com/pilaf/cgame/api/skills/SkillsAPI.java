package com.pilaf.cgame.api.skills;

import com.pilaf.cgame.api.skills.model.Skill;
import com.pilaf.cgame.shared.valueobject.SkillId;

public interface SkillsAPI {

        Skill getSkill(SkillId skillId, int lvl);


}
