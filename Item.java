package Game;

public class Item {
    private String nomLoot;
    private int nombreLoot;
    private int buff;

    public Item(String nomLoot, int nombreLoot, int buff) {
        this.nomLoot = nomLoot;
        this.nombreLoot = nombreLoot;
    }

    public String getNomLoot() {
        return nomLoot;
    }

    public int getNombreLoot() {
        return nombreLoot;
    }

    public void setNombreLoot(int nombreLoot) {
        this.nombreLoot = nombreLoot;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public int getHealValue() {
        return buff;
    }

    @Override
    public String toString() {
        return "  ";
    }

    public int getHealingAmount() {
        return 20;
    }

    public int getDefAmount() {
        return 30;
    }

    public int getStatAmount() {
        return 10;
    }
}