package Game;

import java.util.*;

public class Room {
  String nomSalle;
  int nombreSalles;
  List<Monster> monster;

  Room(String nomSalle, int nombreSalles, List<Monster> monster) {
    this.nomSalle = nomSalle;
    this.nombreSalles = nombreSalles;
    this.monster = new ArrayList<>(monster);
  }

  public String getNomSalle() {
      return nomSalle;
  }
  public void setNomSalle(String nomSalle) {
      this.nomSalle = nomSalle;
  }
  public int getNombreSalles() {
      return nombreSalles;
  }
  public void setNombreSalles(int nombreSalles) {
      this.nombreSalles = nombreSalles;
  }
  @Override
  public String toString() {
    return nomSalle ;
  }
  public List<Monster> getMonster() {
      return monster;
  }
  public void setMonster(List<Monster> monster) {
      this.monster = monster;
  }
}
