package edu.vassar.cmpu203.outfitgenerator.Model;

import java.util.ArrayList;
import java.util.List;

public class PatternFilter {

    public List<ClothingItem> filterByPattern(List<ClothingItem> items) {
        List<ClothingItem> filteredItems = new ArrayList<>();
        boolean hasPattern = false;

        for (ClothingItem item : items) {
            // Allow only one patterned item in the outfit
            if (item.getPattern() == EPattern.NONE || !hasPattern) {
                filteredItems.add(item);

                // Set flag if the item has a pattern to prevent further additions of patterned items
                if (item.getPattern() != EPattern.NONE) {
                    hasPattern = true;
                }
            }
        }

        // If no suitable patterned items are found, prioritize items with no pattern
        if (filteredItems.isEmpty()) {
            for (ClothingItem item : items) {
                if (item.getPattern() == EPattern.NONE) {
                    filteredItems.add(item);
                }
            }
        }

        return filteredItems;
    }
}
