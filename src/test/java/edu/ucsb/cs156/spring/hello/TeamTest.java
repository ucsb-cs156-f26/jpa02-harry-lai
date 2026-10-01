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
    public void getTeam_returns_team_with_correct_name(){
        Team t = Developer.getTeam();
        assertEquals("f26-04", t.getName());
    }
   
    @Test
    public void getTeam_returns_team_with_correct_members(){
        Team t = Developer.getTeam();
        assert(t.getMembers().contains("Austin"));
        assert(t.getMembers().contains("Haoting"));
        assert(t.getMembers().contains("Harry"));
        assert(t.getMembers().contains("Jonathan"));
        assert(t.getMembers().contains("Sarah"));
        assert(t.getMembers().contains("Athena"));
    }

    @Test
    public void boolean_team_equals_test() {
        assertEquals(true, team.equals(team));
        assertEquals(true, team.equals(new Team("test-team")));

        assertEquals(false, team.equals(null));
        assertEquals(false, team.equals("test-team"));
        assertEquals(false, team.equals(new Team("another-team")));

        Team differentMembers = new Team("test-team");
        differentMembers.addMember("Harry");
        assertEquals(false, team.equals(differentMembers));
    }

    @Test
    public void team_string_test() {
        Team t1 = new Team("test-team");
        String expected = "Team(name=test-team, members=[])";
        assertEquals(expected, t1.toString());
    }

    @Test
    public void get_Hash_code_test() {
        Team t1 = new Team("test-team");
        assert(t1.hashCode() == (t1.getName().hashCode() | t1.getMembers().hashCode()));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
