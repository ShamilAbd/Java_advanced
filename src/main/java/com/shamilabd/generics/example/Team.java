package com.shamilabd.generics.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Player & Comparable> {
    private String name;
    private List<T> command = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(T newPlayer) {
        command.add(newPlayer);
    }

    public void playResult(Team<T> otherTeam) {
        Random randomGenerator = new Random();
        String winName;
        int dice = randomGenerator.nextInt(3);
        if (dice == 0) {
            winName = this.name;
        } else if (dice == 1) {
            winName = otherTeam.name;
        } else {
            winName = "no one - draw";
        }
        System.out.println("Who won: " + winName);
    }
}
