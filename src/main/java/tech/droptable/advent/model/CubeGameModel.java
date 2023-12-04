package tech.droptable.advent.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CubeGameModel implements Model {

  List<CubeGame> games;
  
  public CubeGameModel() {
    games = new ArrayList<>();
  }
  
  public void addGame(CubeGame game) {
    games.add(game);
  }
  
  @Override
  public Map<String, String> getAttributes() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public List<CubeGame> getGames() {
    return games;
  }
  
  public static class CubeGame {
    List<Round> rounds;
    String name;
    public CubeGame(String name) {
      this.name = name;
      this.rounds = new ArrayList<>();
    }
    
    public void addRound(Round round) {
      rounds.add(round);
    }
    
    public List<Round> getRounds() {
      return rounds;
    }
    
    public String getName() {
      return name;
    }
  }
  
  public static class Round {
    Map<String, Integer> cubes;
    
    public Round() {
      cubes = new HashMap<>();
    }

    public Round(Map<String, Integer> c) {
      cubes = c;
    }
    
    public void addCubes(String colour, int number) {
      cubes.put(colour, number);
    }
    
    public Map<String, Integer> getCubes() {
      return cubes;
    }
  }

}
