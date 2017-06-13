package avalon.controller;

import avalon.model.SkillModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class SkillsController {

    @RequestMapping(value="/api/skills", method=RequestMethod.GET)
    // get all the skills
    public List<SkillModel> getAllSkills() {
        return null;
    }

    @RequestMapping(value="/api/skills/{charId}", method=RequestMethod.GET)
    // get this char's owned skills
    public List<SkillModel> getCharSkills() {
        return null;
    }

    @RequestMapping(value="/api/skills", method=RequestMethod.POST)
    // purchase the given skill
    public void purchaseSkill() {

    }

}
