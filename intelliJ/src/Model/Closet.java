package edu.vassar.cmpu203.outfitgenerator.Model;

import java.util.ArrayList;
import java.util.List;

public class Closet {
    private List<ClothingItem> items;

    public Closet() {
        items = new ArrayList<>();
    }

    public List<ClothingItem> getItems() {
        return items;
    }

    // Add Clothing
    public boolean addClothing(ClothingItem item) {
        return items.add(item);
    }

    //Delete Clothing
    public boolean deleteClothing(ClothingItem item) {
        return items.remove(item);
    }

    //Filter Clothing
    public List<ClothingItem> filterColor(EColor color){
        List<ClothingItem> filteredItems = new ArrayList<>();
        for(ClothingItem item : items) {
            if(item.getColor().equals(color)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
    public List<ClothingItem> filterPattern(EPattern pattern){
        List<ClothingItem> filteredItems = new ArrayList<>();
        for(ClothingItem item : items) {
            if(item.getPattern().equals(pattern)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
    public List<ClothingItem> filterTexture(ETexture texture){
        List<ClothingItem> filteredItems = new ArrayList<>();
        for(ClothingItem item : items) {
            if(item.getTexture().equals(texture)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public List<ClothingItem> filterSubType(Object subtype){
        List<ClothingItem> filteredItems = new ArrayList<>();
        for(ClothingItem item : items) {
            if(item.getSubtype().equals(subtype)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public List<ClothingItem> filterPartOfBody(EPartOfBody partofbody){
        List<ClothingItem> filteredItems = new ArrayList<>();
        for(ClothingItem item : items) {
            if(item.getPartOfBody().equals(partofbody)){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Edit Clothing
    public void editClothing(ClothingItem item, EPartOfBody partOfBody, Object subtype, ETexture texture, EPattern pattern, EColor color) {
        if(partOfBody != null){
            item.setPartOfBody(partOfBody);
        }
        if(subtype != null){
            item.setSubType(subtype);
        }
        if(texture != null){
            item.setTexture(texture);
        }
        if (pattern != null) {
            item.setPattern(pattern);
        }
        if (color != null){
            item.setColor(color);
        }
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Your closet is empty.");
        } else {
            System.out.println("Items in your closet:");
            for (ClothingItem item : items) {
                System.out.println(item.getItemDetails());
            }
        }
    }
}
