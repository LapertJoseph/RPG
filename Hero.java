package Game;

public class Hero {
    
    String nom;
    String prenom;

    Hero(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String heroToString() {
        return "nom: " + " " + nom + "\n" + "prenom: " + " " + prenom + "\n";
    }

    public String getName () {
        return nom;
    }
    public void setName(String nom) {
        this.nom = nom;
    }
    
} 
