package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Chloe A.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "chloeandersen-ucsb";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("s25-14");
        team.addMember("Andrew Z.");
        team.addMember("Chloe A.");
        team.addMember("Karen Y.");
        team.addMember("Ryan C.");
        team.addMember("Shruthi S.");
        team.addMember("Siddhi M.");
        return team;
    }
}
