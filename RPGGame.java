package Game;

import java.util.*;

public class RPGGame {
  List<Monster> monstersEntrance;
  List<Monster> monstersCorridor;
  List<Monster> monstersArmory;
  List<Monster> monstersBoss;
  List<Room> rooms;
  List<Item> items;
  static List<Inventory> inventory;
  static Random rand;
  boolean gameOver = false;

  public RPGGame() {
    monstersEntrance = new ArrayList<>();
    monstersEntrance.add(new Monster("Zombie", 50, 10, 30, 10, "Rale"));

    monstersCorridor = new ArrayList<>();
    monstersCorridor.add(new Monster("Orc", 50, 10, 50, 20, "Cri de guerre"));

    monstersArmory = new ArrayList<>();
    monstersArmory.add(new Monster("Lezard", 70, 15, 60, 30, "Coup de queue"));

    monstersBoss = new ArrayList<>();

    monstersBoss.add(new Monster("Raelstraz, Patriarche des dragons", 120, 20, 70, 80, "Souffle du dragon"));
    monstersBoss.add(new Monster("Ultor, l'assemblage détraqué", 110, 20, 50, 100, "Poing Fulgurant"));
    monstersBoss.add(new Monster("Calamitas, le sorcier fou", 70, 50, 30, 10, "Supernova"));

    rooms = new ArrayList<>(); // rajouter deux monstres dans les salles
    rooms.add(new Room("Entree", 1, monstersEntrance));
    rooms.add(new Room("Corridor", 1, monstersCorridor));
    rooms.add(new Room("Armurerie", 1, monstersArmory));
    rooms.add(new Room("Trone", 1, monstersBoss));

    // list salle avec les monstre associé
    // une salle = un monstre

    rooms.get(0);
    rooms.get(1);
    rooms.get(2);
    rooms.get(3);

    items = new ArrayList<>();

    items.add(new Item("Potion de soin", 2, 20));
    items.add(new Item("Potion de défense", 1, 5));
    items.add(new Item("Potion fortifiante", 1, 2));

    items.get(0);
    items.get(1);
    items.get(2);

    rand = new Random();
  }

  /**
   * @param List<Room> rooms
   * @return void
   */
  public void getSalles(List<Room> rooms) {
    for (Room room : rooms) {
      System.out.println(room.getNomSalle());
    }
  }

  /**
   *
   * @return Monster monster
   */
  public List<Monster> getMonstersEntrance() {
    return monstersEntrance;
  }

  public List<Monster> getMonstersArmory() {
    return monstersArmory;
  }

  public List<Monster> getMonstersCorridor() {
    return monstersCorridor;
  }

  public List<Monster> getMonstersBoss() {
    return monstersBoss;
  }

  /**
   * 
   * @param number
   * @return int
   */
  public static int displayInput(int number) {
    System.out.println("Que faites-vous ? ");
    System.out.println("1 - Attaquer ? ");
    System.out.println("2 - Utiliser un objet ?");
    System.out.println("3 - Fuir  ? ");
    System.out.println("\n");
    return number;
  }

  /**
   * 
   * @param gameOver
   * @return void
   */
  public void setGameOver(boolean gameOver) {
    this.gameOver = gameOver;
  }

  /**
   * 
   * @param a instanciation of Character
   * @return void RPG
   */
  public static void getActions(Character a) {
    Scanner sc = new Scanner(System.in);
    RPGGame game = new RPGGame();

    // DEBUT DU RPG
    System.out.println(
        "---------------------------------------------------------------------------------------------------------------------------");
    System.out.println(
        "Vous entrez dans ce qu'il semble etre un donjon abandonee et vous decidez de penetrer dans l'obscurite sombre et glaciale.");
    System.out.println("Vous regardez votre carte mais il fait noir.");
    System.out.println(
        "---------------------------------------------------------------------------------------------------------------------------");
    int choice = 0;

    if (choice != 1) {
      System.out.println("1 - Allumer la torche.");
      System.out.println("2 - Ne rien faire.");
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("---------------------------------------");
          System.out.println("Vous lisez votre carte et vous voyez : ");
          System.out.println("---------------------------------------");
          game.getSalles(game.rooms);
          break;
        case 2:
          System.out.println(
              "----------------------------------------------------------------------------------------------------------------------------");
          System.out.println(
              "Vous avez choisi de ne rien faire, dans l'attente de votre decision d'avancer, voici une enigme.");
          System.out.println(
              "Quel etre, pourvu d'une seule voix, a d'abord quatre jambes le matin, puis deux jambes a midi, et trois jambes le soir ?");
          System.out.println("1 - Singe");
          System.out.println("2 - Homme");
          System.out.println("3 - Vache");
          System.out
              .println("(ATTENTION : si vous repondez mal a la question, vous allez diminuer votre nombre de PV.)");
          System.out.println(
              "----------------------------------------------------------------------------------------------------------------------------");
          // Affichage de texte
          choice = 0;
          choice = sc.nextInt();
          for (int i = 0; i < 3; i++) {
            if (choice != 2) {
              a.hp -= 10; // 90
              System.out.println("Mauvaise reponse, Vous perdez 10 PV.");
              System.out.println("Il vous reste " + a.hp + " " + "PV."); // 90
              System.out.println(
                  "Quel etre, pourvu d'une seule voix, a d'abord quatre jambes le matin, puis deux jambes a midi, et trois jambes le soir ?");
              System.out.println("1 - Singe");
              System.out.println("2 - Homme");
              System.out.println("3 - Vache");
              if (a.hp == 70) {
                break;
              }
              choice = sc.nextInt();
            } else {
              System.out.println("---------------------------------------");
              System.out.println("Felicitation, vous avez bien repondu.");
              System.out.println("---------------------------------------");
              break;
            }
            System.out.println("Il vous reste " + a.hp + " " + "PV.");
          }
          break;
        // Fin de la boucle
        default:
          System.out.println("Veuillez choisir une option");
          break;
      }
    }

    System.out.println("-----------------------------------------------------");
    System.out.println("Nombre de PV : " + a.hp + " PV.");
    System.out.println("1 - Avancer vers " + game.rooms.get(0).toString() + " ?");
    System.out.println("2 - Reculer ?");
    choice = sc.nextInt();
    if (choice == 1) {
      System.out.println("Vous decidez de vous aventurer vers " + game.rooms.get(0).toString());
    } else {
      System.out.println(
          "----------------------------------------------------------------------------------------------------------------------------------------");
      System.out
          .println("Vous entendez un enorme eboulement derriere vous et vous comprenez que vous etes pris au piege.");
      a.hp -= 10;
      System.out.println(
          "Vous ne faite pas attention et un morceau de pierre vous tombe dessus, vous perdez 10 PV. Resignez, vous decidez d'avancer dans le noir.");
      System.out.println("Vous vous relevez et vous vous enfoncer dans l'entree.");
      System.out.println("Vous penetrez dans l'entree et vous commencez a scruter les environs.");
      System.out.println(
          "----------------------------------------------------------------------------------------------------------------------------------------");
    }

    System.out.println("-----------------------------------------------------------------------------------");
    System.out
        .println("Vous avancez quand soudain, vous tombez nez a nez avec un " + game.monstersEntrance.get(0).getName()
            + " !");
    System.out.println("-----------------------------------------------------------------------------------");

    // DEBUT COMBAT Salle 1 (Entree)
    do {
      displayInput(choice);
      choice = sc.nextInt();
      boolean escape = false;
      while (a.getHp() > 0 && game.monstersEntrance.get(0).getHp() > 0 && !escape) {
        if (choice == 1) {
          System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
          System.out.println(
              game.monstersEntrance.get(0).getName() + " possède " + game.monstersEntrance.get(0).getHp() + "PV.");
          System.out.println("\n");
          // Player attack
          a.attack(game.monstersEntrance.get(0));
          if (game.monstersEntrance.get(0).getHp() <= 0) {
            game.monstersEntrance.get(0).setHpToZero(game.monstersEntrance.get(0).hp);
            System.out.println("Félicitation, vous avez vaincu " + game.monstersEntrance.get(0).getName() + "!");
            break;
          } else {
            System.out.println("il reste " + game.monstersEntrance.get(0).getHp() + " PV au monstre.");
          }
          // Monster attack
          game.monstersEntrance.get(0).attack(a);
          if (a.getHp() <= 0) {
            a.setHpToZero(a.hp);
            System.out.println("Vous avez été vaincu par " + game.monstersEntrance.get(0).getName() + "!");
            game.setGameOver(true);
            break;
          } else {
            System.out.println("il vous reste " + a.getHp() + " PV.");
            System.out.println("\n");
          }
          System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
          System.out.println(
              game.monstersEntrance.get(0).getName() + " possède " + game.monstersEntrance.get(0).getHp() + "PV.");
          System.out.println("\n");
          System.out.println("CHOICE sortie de 1 :" + choice);
          System.out.println("\n");
          displayInput(choice);
          choice = displayInput(sc.nextInt());

          // Prise d'objet

        } else if (choice == 2) {
          choice = 0;
          System.out.println("\n");
          System.out.println("CHOICE  :" + choice);
          System.out.println("\n");
          a.inventory.displayInventory();
          System.out.println("Quel objet voulez-vous utilisez ?");
          int choicePotion = 0;
          System.out.println("\n");
          System.out.println("CHOICEPOTION  :" + choicePotion);
          System.out.println("\n");
          choicePotion = sc.nextInt();
          if (choicePotion == 2) {
            a.useDefPotion();
            System.out.println(a.getName() + " possède désormais " + a.getDefense() + " de défense.");
            displayInput(choice);
            choice = displayInput(sc.nextInt());
          }

        } else if (choice == 3) {
          System.out.println(
              "Vous choisissez de fuir le combat, vous subissez un coup de " + game.monstersEntrance.get(0).getName()
                  + " et vous perdez 40 PV");
          a.setHp(a.getHp() - 40);
          System.out.println("Il vous reste " + a.getHp() + " PV.");
          escape = true;
          System.out.println("\n");
          System.out.println("CHOICE sortie de 3 :" + choice);
          System.out.println("\n");

        } // Crochet de la fuite choice == 3
      } // Crochet du while
    } while (choice != 3 && game.gameOver != true && game.monstersEntrance.get(0).getHp() > 0);

    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println(
        "Une petite lumière gravite autour de vous et soudain elle vous traverse, vous regagnez 30 points de vie. BLA BLA BLA");
    choice = 0; // choice verifié bien égale à 0
    // verif isAlive
    if (a.getHp() <= 100) {
      int newHP = a.getHp() + 30;
      if (newHP > 100) {
        a.setHp(100);
      } else {
        a.setHp(newHP);
      }
      System.out.println("Il vous reste " + a.getHp() + "PV.");
      System.out.println("-----------------------------------------------------------------------------------------");

      // AddItem
      System.out.println("--------------------------------------------------------------------");
      Item itemToAdd = game.items.get(0);
      a.addItemDefenseToInventory(itemToAdd, a.inventory.getItems());
      a.inventory.displayInventory();
      System.out.println("\n");
      // FIN SALLE 1
      // --------------------------------------------------------------------------------------------------------------------------------
      // DEBUT SALLE 2
      System.out.println("Que faites vous ?");
      System.out.println("1 - Regarder la carte ?");
      System.out.println("2 - Explorer les environs ?");
      System.out.println("3 - Utiliser un objet ?");
      System.out.println("--------------------------------------------------------------------");

      choice = sc.nextInt();

      if (choice == 1) {
        System.out.println("---------------------------------------");
        System.out.println("Vous lisez votre carte et vous voyez : "); // Affichage de texte
        System.out.println("---------------------------------------");
        game.getSalles(game.rooms); // Affichage de la map via la function getSalles
      } else if (choice == 2) {
        System.out.println("Vous entendez un grognement bizarre et vous décidez rapidement de regarder votre carte");
        System.out.println("---------------------------------------");
        System.out.println("Vous lisez votre carte et vous voyez : "); // Affichage de texte
        System.out.println("---------------------------------------");
        game.getSalles(game.rooms); // Affichage de la map via la function getSalles
      }
      System.out.println("-------------------------------------------------------");

      System.out.println("Que faites vous ?");
      System.out.println("1 - Avancer vers " + game.rooms.get(1).toString() + " ?");
      System.out.println("-------------------------------------------------------");

      choice = sc.nextInt();
      while (choice != 1) {
        System.out.println("Veuillez entrer un chiffre valide");
        sc.nextInt();
      }
      System.out.println("---------------------------------------------------------------------");
      System.out.println("Vous decidez de vous aventurer vers " + game.rooms.get(1).toString());
      System.out.println("---------------------------------------------------------------------");

      System.out.println("-----------------------------------------------------------------------------------");
      System.out.println("Vous avancez dans le corridor quand vous apercevez une lueur rouge sur un piedestal");
      System.out.println("Que faites vous ? ");
      System.out.println("1 - Vous décidez de continuer vers le piedestal");
      System.out.println("2 - Vous décidez de scruter les environs");
      System.out.println("3 - Vous flânez");
      System.out.println("Vous avez " + a.getHp() + "PV.");
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out
              .println(
                  "Alors que vous avancez, le piedestal disparaît et vous activer par mégarde une trappe au sol et vous rugissait de douleur");
          System.out.println("Un carreau penetre dans votre épaule et vous perdez 20 points de vie.");
          a.setHp(a.hp - 20);
          if (a.getHp() <= 0) {
            a.setHpToZero(a.hp);
            System.out.println("GAME OVER ...");
          }
          System.out.println("Il vous reste " + a.getHp() + "PV.");
          System.out.println("Vous vous relevez et vous posez un bandage de fortune sur votre plaie.");
          System.out
              .println(
                  "Alors que vous finissez le bandage, vous sentez une odeur nauséabonde qui vous prend au museau.");
          break;
        case 2:
          System.out.println(
              "Alors que vous regardez attentivement le couloir vous apercevez au sol une trappe qui est relié à un dispositif de piege");
          System.out.println("Vous décidez alors de contournez la trappe");
          break;
        case 3:
          System.out.println("Vous décidez de rester planté la en attendant que le temps passe");
          System.out.println("Après plusieurs minutes d'attente, vous décidez d'avancez ");
          System.out
              .println(
                  "Alors que vous avancez, Un carreau penetre dans votre épaule et vous perdez 20 points de vie. ");
          a.setHp(a.hp - 20);
          if (a.getHp() <= 0) {
            a.setHpToZero(a.hp);
            System.out.println("GAME OVER ...");
          }
          System.out.println("Il vous reste " + a.getHp() + "PV.");
          System.out.println("Vous vous relevez et vous posez un bandage de fortune sur votre plaie.");
          System.out
              .println(
                  "Alors que vous finissez le bandage, vous sentez une odeur nauséabonde qui vous prend au museau.");
          break;
        default:
          System.out.println("(Veuillez choisir une option).");
          break;
      }
    }
    // TODO : Salle 2 (Done) Corridor

    System.out.println("Vous relevez la tête et vous apercevez un " + game.monstersCorridor.get(0).getName()
        + " qui vous barre la sortie du corridor. BLE BLE BLE");
    choice = 0;
    // DEBUT COMBAT
    do {
      displayInput(choice);
      choice = sc.nextInt();
      boolean escape = false;
      while (a.getHp() > 0 && game.monstersCorridor.get(0).getHp() > 0 && !escape) {
        if (choice == 1) {
          System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
          System.out.println(
              game.monstersCorridor.get(0).getName() + " possède " + game.monstersCorridor.get(0).getHp() + "PV.");
          System.out.println("\n");
          // Player attack
          a.attack(game.monstersCorridor.get(0));
          if (game.monstersCorridor.get(0).getHp() <= 0) {
            game.monstersCorridor.get(0).setHpToZero(game.monstersCorridor.get(0).hp);
            System.out.println("Félicitation, vous avez vaincu " + game.monstersCorridor.get(0).getName() + "!");
            break;
          } else {
            System.out.println("il reste " + game.monstersCorridor.get(0).getHp() + " PV au monstre.");
          }
          // Monster attack
          game.monstersCorridor.get(0).attack(a);
          if (a.getHp() <= 0) {
            a.setHpToZero(a.hp);
            System.out.println("Vous avez été vaincu par " + game.monstersCorridor.get(0).getName() + "!");
            game.setGameOver(true);
            break;
          } else {
            System.out.println("il vous reste " + a.getHp() + " PV.");
            System.out.println("\n");
          }
          System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
          System.out.println(
              game.monstersCorridor.get(0).getName() + " possède " + game.monstersCorridor.get(0).getHp() + "PV.");
          System.out.println("\n");
          displayInput(choice);
          choice = displayInput(sc.nextInt());
          // sc.nextInt();
        } else if (choice == 2) {
          a.inventory.displayInventory();
          System.out.println("Quel objet voulez-vous utilisez ?");
          choice = sc.nextInt();
          a.useDefPotion();
          System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
          System.out.println(
              game.monstersCorridor.get(0).getName() + " possède " + game.monstersCorridor.get(0).getHp() + "PV.");
          displayInput(choice);
          choice = displayInput(sc.nextInt());
          // sc.nextInt();
        } else if (choice == 3) {
          System.out.println(
              "Vous choisissez de fuir le combat, vous subissez un coup de " + game.monstersCorridor.get(0).getName()
                  + " et vous perdez 10 PV");
          a.setHp(a.getHp() - 10);
          System.out.println("Il vous reste " + a.getHp() + " PV.");
          escape = true;
          break;
        }
      }
    } while (choice != 3 && game.gameOver != true && game.monstersCorridor.get(0).getHp() > 0);
    if (a.getHp() == 0) { // GAME OVER
      return;
    } else { // + 30 HP
      System.out.println("-----------------------------------------------------------------------------------------");
      System.out.println(
          "Une petite lumière gravite autour de vous et soudain elle vous traverse, vous regagnez 30 points de vie.");
      if (a.getHp() <= 100) {
        int newHP = a.getHp() + 30;
        if (newHP > 100) {
          a.setHp(100);
        } else {
          a.setHp(newHP);
        }
        System.out.println("Il vous reste " + a.getHp() + "PV.");
        System.out.println("-----------------------------------------------------------------------------------------");
      }
    }
    System.out.println("Vous cherchez la lumière rouge et vous apercevez un coffre");
    Item newItemToAdd = game.items
        .get(1);
    a.addItemDefenseToInventory(newItemToAdd, a.inventory.getItems());
    a.inventory.displayInventory();
    System.out.println("--------------------------------------------------------------------");
    System.out.println("Vous êtes à mi-parcours ! Courage.");
    System.out.println("\n");
    System.out.println("Que faites vous ?");
    System.out.println("1 - Regarder la carte ?");
    System.out.println("2 - Explorer les environs ?");
    System.out.println("3 - Utiliser un objet ?");
    System.out.println("4 - ? ");
    System.out.println("--------------------------------------------------------------------");

    choice = sc.nextInt();

    if (choice == 1) {
      System.out.println("---------------------------------------");
      System.out.println("Vous lisez votre carte et vous voyez : "); // Affichage de texte
      System.out.println("---------------------------------------");
      game.getSalles(game.rooms);
    } else if (choice == 2) {
      System.out.println("Vous semblez avoir fait le tour du Corridor");
    } else if (choice == 3) {
      a.inventory.displayInventory();
      System.out.println("Quel objet voulez-vous utilisez ?");
      System.out.println("\n");
      choice = sc.nextInt();
      a.useDefPotion();
      System.out.println("Vous avez " + a.getHp() + " PV.");
    } else {
      System.out.println("???? : ????");
      int randomNumber = rand.nextInt(2);
      if (randomNumber < 1) { // Bonus
        System.out.println("Vous avez " + a.getHp() + "PV.");
        if (a.getHp() <= 100) {
          int newHP = a.getHp() + 30;
          if (newHP > 100) {
            a.setHp(100);
          } else {
            a.setHp(newHP);
          }
          System.out.println("Vous avez " + a.getHp() + "PV.");
        } else { // Malus
          System.out.println("??? : ???");
          System.out.println("Vous avez " + a.getHp() + "PV.");
          int newHP = a.getHp() - 30;
          if (newHP <= 0) {
            a.setHp(0);
            game.gameOver = true;
            System.out.println("? => ?");
            return;
          } else { // s'il est vivant
            a.setHp(newHP);
            System.out.println("Il vous reste " + a.getHp() + "PV.");
          }
        }
      }
    }
    System.out.println("-------------------------------------------------------");

    System.out.println("Que faites vous ?");
    System.out.println("1 - Avancer vers " + game.rooms.get(2).toString() + " ?");
    System.out.println("-------------------------------------------------------");

    choice = sc.nextInt();
    while (choice != 1) {
      System.out.println("Veuillez entrer un chiffre valide");
      sc.nextInt();
    }
    // FIN SALLE 2
    // -----------------------------------------------------------------------------------------------------------------------------------
    // DEBUT SALLE 3

    // TODO : Salle 3 Armurerie
    System.out.println("Vous penetrez dans l'armurerie et tout de suite, vous etes surpris de voir "
        + game.monstersArmory.get(0).getName() + " endormi, la main sur le coffre.");

    System.out.println("Que faites vous ?");
    System.out.println("1 - Attaquer ?");
    System.out.println("2 - Prendre le coffre ?");
    choice = sc.nextInt();

    if (choice == 1) {
      do {
        displayInput(choice);
        System.out.println("monster HP : " + game.monstersArmory.get(0).getHp());
        System.out.println("player HP : " + a.getHp());
        choice = sc.nextInt();

        boolean escape = false;
        while (a.getHp() > 0 && game.monstersArmory.get(0).getHp() > 0 && !escape) {
          if (choice == 1) {
            System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
            System.out.println(
                game.monstersArmory.get(0).getName() + " possède " + game.monstersArmory.get(0).getHp() + "PV.");
            System.out.println("\n");
            // Player attack
            a.attack(game.monstersArmory.get(0));
            if (game.monstersArmory.get(0).getHp() <= 0) {
              game.monstersArmory.get(0).setHpToZero(game.monstersArmory.get(0).hp);
              System.out.println("Félicitation, vous avez vaincu " + game.monstersArmory.get(0).getName() + "!");
              break;
            } else {
              System.out.println("il reste " + game.monstersArmory.get(0).getHp() + " PV au monstre.");
            }
            // Monster attack
            game.monstersArmory.get(0).attack(a);
            if (a.getHp() <= 0) {
              a.setHpToZero(a.hp);
              System.out.println("Vous avez été vaincu par " + game.monstersArmory.get(0).getName() + "!");
              game.setGameOver(true);
              break;
            } else {
              System.out.println("il vous reste " + a.getHp() + " PV.");
              System.out.println("\n");
            }
            System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
            System.out.println(
                game.monstersArmory.get(0).getName() + " possède " + game.monstersArmory.get(0).getHp() + "PV.");
            System.out.println("\n");
            displayInput(choice);
            choice = displayInput(sc.nextInt());
            // sc.nextInt();
          } else if (choice == 2) {
            a.inventory.displayInventory();
            System.out.println("Quel objet voulez-vous utilisez ?");
            choice = sc.nextInt();
            a.useDefPotion();
            System.out.println(a.getName() + " possède " + a.getHp() + "PV.");
            System.out.println(
                game.monstersArmory.get(0).getName() + " possède " + game.monstersArmory.get(0).getHp() + "PV.");
            displayInput(choice);
            choice = displayInput(sc.nextInt());
            // sc.nextInt();
          } else if (choice == 3) {
            System.out.println(
                "Vous choisissez de fuir le combat, vous subissez un coup de " + game.monstersArmory.get(0).getName()
                    + " et vous perdez 10 PV");
            a.setHp(a.getHp() - 10);
            System.out.println("Il vous reste " + a.getHp() + " PV.");
            escape = true;
            break;
          }
        }
      } while (choice != 3 && game.gameOver != true && game.monstersArmory.get(0).getHp() > 0);
    } else {
      // coder la fonction pour le choice 2
    }
    if (a.getHp() == 0) { // GAME OVER
      return;
    } else { // + 30 HP
      System.out.println("-----------------------------------------------------------------------------------------");
      System.out.println(
          "Une petite lumière gravite autour de vous et soudain elle vous traverse, vous regagnez 30 points de vie.");
      if (a.getHp() <= 100) {
        int newHP = a.getHp() + 30;
        if (newHP > 100) {
          a.setHp(100);
        } else {
          a.setHp(newHP);
        }
        System.out.println("Il vous reste " + a.getHp() + "PV.");
        System.out.println("-----------------------------------------------------------------------------------------");
      }
    }
    // FIN SALLE 3
    // -----------------------------------------------------------------------------------------------------------------------------------
    // DEBUT SALLE Boss
    sc.close();
    return;
  }
}

// TODO : implement restart game
// System.out.println("1 - Rejouez ? ");
// System.out.println("2 - Quitter");
// choice = sc.nextInt();
// do {
// if (choice == 1) {
// System.out.println("Vous décidez de rejouer, quel courage!");
// break;
// } else if (choice == 2) {
// System.out.println("Merci d'avoir jouer et à bientôt");
// return;
// }
// } while (choice != 1 && choice != 2);