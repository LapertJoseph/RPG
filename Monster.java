package Game;

public class Monster {

    String name;
    int hp;
    int energy;
    int attack;
    int defense;
    String skill;

    Monster(String name, int hp, int energy, int attack, int defense, String skill) {
        this.name = name;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setHp(Monster newMonster) {
        this.hp = newMonster.getHp();
    }

    public int setHpToZero(int hp) {
        return this.hp = 0;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void attack(Character c) {
        int damage = attack - c.defense;
        if (damage <= 0) {
            c.hp = c.hp;
            System.out.println("Le héros esquive le coup du monstre.");
        } else {
            c.hp = c.hp - damage;
            System.out.println("*Le heros subit " + damage + " point de degats");
        }
    }
}
