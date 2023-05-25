package Game;

import java.util.*;

public class Inventory {
    private List<Item> items;
    private int capacity;

    public Inventory(List<Item> items, int capacity) {
        this.items = new ArrayList<>(items);
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            System.out.println("L'objet " + item.getNomLoot() + " a été ajouté à l'inventaire.");
            return true;
        } else {
            System.out.println("L'inventaire est plein. Impossible d'ajouter l'objet " + item.getNomLoot() + ".");
            return false;
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void displayInventory() {
        System.out.println("Inventaire : ");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println("2 " + item.getNomLoot() + " - Quantité: " + item.getNombreLoot());
        }
    }

    @Override
    public String toString() {
        return capacity + " emplacements";
    }

    public List<Item> getItems() {
        return items;
    }
}
