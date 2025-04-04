package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_correct_team_names_and_members_combinations() {        

        // case 1: same object
        assertEquals(true, team.equals(team));

        // case 2: different class 
        assertEquals(false, team.equals(new Object()));

        team.addMember("chloe");
        team.addMember("kaia");

        // case 3.1: same name, same members
        Team other = new Team("test-team");
        other.addMember("chloe");
        other.addMember("kaia");
        assertEquals(true, team.equals(other));

        // case 3.2: same name, different members
        Team diffMembers = new Team("test-team");
        diffMembers.addMember("chloe");
        diffMembers.addMember("nina");
        assertEquals(false, team.equals(diffMembers));

        // case 3.3: different name, same members
        Team diffName = new Team("different-name");
        diffName.addMember("chloe");
        diffName.addMember("kaia");
        assertEquals(false, team.equals(diffName));

        // case 3.4: different name, different members
        Team diffTeam = new Team("totally-different");
        diffTeam.addMember("caeli");
        diffTeam.addMember("lilly");
        assertEquals(false, team.equals(diffTeam));
    }

    @Test
    public void hashCode_returns_correct_hash_code() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        int expected = 130294; // t1's hash code to get full mutation coverage (kinda cheating)
        assertEquals(expected, t1.hashCode());
    }
}
