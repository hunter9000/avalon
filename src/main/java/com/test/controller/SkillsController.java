package com.test.controller;

public class SkillsController {

    @RestController(name="/api/skills" GET)
    // get all the skills
    @RestController(name="/api/skills/{charId}", GET)
    // get this char's owned skills
    @RestController(name="/api/skills", POST)
    // purchase the given skill
}
