package Game;

import java.util.*;

public class Character extends Hero {

    String classe;
    int hp;
    int attack;
    int defense;
    int energy;
    static String skill;
    static String descriptionSpell;
    Inventory inventory;

    Character(String classe, int hp, int attack, int defense, int energy, String nom, String prenom, String skill,
            String descriptionSpell, Inventory inventory) {
        super(nom, prenom);
        this.classe = classe;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.energy = energy;
        this.skill = skill;
        this.descriptionSpell = descriptionSpell;
        this.inventory = inventory;
    };

    public String heroToString() {
        return "Voici votre feuille de personnage :\n " + "Nom: " + nom + "\n" + " " + "Prenom: " + prenom + "\n" + " "
                + "Classe: " + classe + "\n" + " " + "PV: " + hp + "\n" + " " + "Attaque: " + attack + "\n" + " "
                + "Defense: " + defense + "\n" + " " + "Energie: " + energy + "\n" + " " + "Competence: " + skill + "\n"
                + "Description de la competence: " + descriptionSpell + "\n" + "Inventaire: "
                + inventory.toString() + "\n";
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefense() {
        return defense;
    }

    public int setHpToZero(int hp) {
        return this.hp = 0;
    }
    public int getAttack() {
        return attack;
    }
    public int getEnergy() {
        return energy;
    }
    public String getName() {
        return nom;
    }

    public String getClasse() {
        return classe;
    }

    public static String getSkill(String skill) {
        return skill;
    }

    public static String getDescriptionSpell() {
        return descriptionSpell;
    }

    // Function Hero attack Monster
    public void attack(Monster m) {
        int damage = attack - m.defense;
        if (damage <= 0) {
            m.hp = m.hp;
            System.out.println("Le monstre esquive le coup du héros.");
        }
        m.hp = m.hp - damage;
        System.out.println("*Le monstre subit " + damage + " point de degats.");
    }

    /**
     * 
     * @param item
     * @param inventory
     * @return List<Item> item
     */
    public void addItemHealToInventory(Item item, List<Item> inventory) {
        if (item.getNomLoot().equals("Potion de soin")) {
            for (Item existingItem : inventory) {
                if (existingItem.getNomLoot().equals("Potion de soin")) {
                    existingItem.setNombreLoot(existingItem.getNombreLoot() + item.getNombreLoot());
                    System.out.println("Potions de soin ajoutées à l'inventaire.");
                    return;
                }
            }
        }
    }

    public void addItemDefenseToInventory(Item item, List<Item> inventory) {
        if (item.getNomLoot().equals("Potion de défense")) {
            for (Item existingItem : inventory) {
                if (existingItem.getNomLoot().equals("Potion de défense")) {
                    existingItem.setNombreLoot(existingItem.getNombreLoot() + item.getNombreLoot());
                    System.out.println("Potion de défense ajoutées à l'inventaire.");
                }
            }
        }
    }

    public void addItemStatToInventory(Item item, List<Item> inventory) {
        if (item.getNomLoot().equals("Potion fortifiante")) {
            for (Item existingItem : inventory) {
                System.out.println("existingItem: " + existingItem);
                if (existingItem.getNomLoot().equals("Potion fortifiante")) {
                    existingItem.setNombreLoot(existingItem.getNombreLoot() + item.getNombreLoot());
                    System.out.println("Potion fortifiantes ajoutées à l'inventaire.");
                }
            }
        }
    }

    public void removeItemInventory(Item item) {
        inventory.removeItem(item);
    }

    public void useHealPotion() {
        for (Item item : inventory.getItems()) {
            if (item.getNomLoot().equals("Potion de soin")) {
                int heal = item.getHealingAmount();
                hp += heal;
                System.out.println(
                        "Vous avez utilisé une potion de soin et récupéré " + heal + " points de vie.");
                // reduce the potion to 1
                item.setNombreLoot(item.getNombreLoot() - 1);
                // if quantity potion == 0 then remove potion from inventory
                if (item.getNombreLoot() == 0) {
                    inventory.removeItem(item);
                    System.out.println("La potion de soin est épuisée et a été retirée de votre inventaire.");
                }
                return;

            }
        }
    }

    public void useDefPotion() {
        for (Item item : inventory.getItems()) {
            if (item.getNomLoot().equals("Potion de défense")) {
                int def = item.getDefAmount();
                defense += def;
                System.out.println(
                        "Vous avez utilisé une potion de défense. Votre défense est désormais de " + defense
                                + " points.");
                item.setNombreLoot(item.getNombreLoot() - 1);
                if (item.getNombreLoot() == 0) {
                    inventory.removeItem(item);
                    System.out.println("Les potions de défense sont épuisée et sont retirée de votre inventaire.");
                }
                return;
            }
        }
    }

    public void useStatPotion() {
        for (Item item : inventory.getItems()) {
            if (item.getNomLoot().equals("Potion fortifiante")) {
                int stat = item.getStatAmount();
                hp += stat;
                attack += stat;
                defense += stat;
                energy += stat;
                System.out.println(
                        "Vous avez utilisé une potion fortifiante et augmenter vos statistiques de " + stat
                                + " points.");
                item.setNombreLoot(item.getNombreLoot() - 1);
                if (item.getNombreLoot() == 0) {
                    inventory.removeItem(item);
                    System.out.println("Les potions fortifiantes sont épuisée et sont retirée de votre inventaire.");
                }
                return;
            }
        }
    }

    // Create Character
    public static Character createCharactertoString() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans le monde d'Eternal Kingdom");
        System.out.println("Entrez un nom");
        String nom = sc.nextLine();
        System.out.println("Entrez un prenom");
        String prenom = sc.nextLine();

        Item potionHeal = new Item("Potion de soin", 2, 20);
        Item potionDefense = new Item("Potion de défense", 1, 20);
        Item potionStat = new Item("Potion fortifiante", 1, 20);

        List<Item> items = new ArrayList<>();
        items.add(potionHeal);
        items.add(potionDefense);
        items.add(potionStat);

        String classe = null;
        int hp = 0;
        int attack = 0;
        int defense = 0;
        int energy = 0;
        Inventory inventory = new Inventory(items, 10);

        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("Veuillez choisir une classe :");
            System.out.println("1 - Guerrier");
            System.out.println("2 - Pretre");
            System.out.println("3 - Mage");

            choice = sc.nextInt();

            if (choice == 1) {
                classe = "Guerrier";
                hp = 100;
                attack = 50;
                defense = 30;
                energy = 100;
                skill = "Frappe mortelle";
                descriptionSpell = "Le guerrier esquive l'attaque de l'ennemi et inflige une attaque devastatrice.";
            } else if (choice == 2) {
                classe = "Pretre";
                hp = 100;
                attack = 35;
                defense = 20;
                energy = 150;
                skill = "Soin rapide";
                descriptionSpell = "Le Pretre entonne de sa voix, une douce melodie qui lui permet de se revitaliser.";
            } else if (choice == 3) {
                classe = "Mage";
                hp = 100;
                attack = 35;
                defense = 10;
                energy = 300;
                skill = "Sort ultime";
                descriptionSpell = "Un enorme rocher de feu jaillit des mains du mage et explose au visage de l'ennemi.";
            } else {
                System.out.println("Choix invalide. Veuillez choisir une classe.");
            }
        }
        Character character = new Character(classe, hp, attack, defense, energy, nom, prenom, skill, descriptionSpell,
                inventory);
        System.out.println(character.heroToString());
        return character;
    };
};