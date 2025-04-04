package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Chloe A.", Developer.getName());
    }
    
    @Test
    public void getGithubId_returns_correct_github_id() {
        assertEquals("chloeandersen-ucsb", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s25-14", t.getName());
        assertTrue(t.getMembers().contains("Andrew Z."), "Team should contain Andrew Z.");
        assertTrue(t.getMembers().contains("Chloe A."), "Team should contain Chloe A.");
        assertTrue(t.getMembers().contains("Karen Y."), "Team should contain Karen Y.");
        assertTrue(t.getMembers().contains("Ryan C."), "Team should contain Ryan C.");
        assertTrue(t.getMembers().contains("Shruthi S."), "Team should contain Shruthi S.");
        assertTrue(t.getMembers().contains("Siddhi M."), "Team should contain Siddhi M.");
    }
}
