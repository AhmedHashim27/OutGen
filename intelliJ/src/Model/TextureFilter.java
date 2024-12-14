package edu.vassar.cmpu203.outfitgenerator.Model;

import java.util.ArrayList;
import java.util.List;

public class TextureFilter {

    // Filters items based on temperature category
    public List<ClothingItem> filterByTexture(List<ClothingItem> items, String temperatureCategory) {
        List<ClothingItem> filteredItems = new ArrayList<>();

        for (ClothingItem item : items) {
            if (isTextureSuitable(item, temperatureCategory)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Determines if a clothing item is suitable based on its texture and the temperature category
    private boolean isTextureSuitable(ClothingItem item, String temperatureCategory) {
        ETexture texture = item.getTexture();

        switch (temperatureCategory.toLowerCase()) {
            case "very cold":
                // For very cold weather, prioritize insulating textures, with LEATHER as a versatile option
                return texture == ETexture.WOOL || texture == ETexture.FUR || texture == ETexture.LEATHER;

            case "cold":
                // For cold weather, include a variety of warm textures with LEATHER
                return texture == ETexture.WOOL || texture == ETexture.VELVET || texture == ETexture.FUR || texture == ETexture.LEATHER || texture == ETexture.DENIM;

            case "cool":
                // For cool weather, balance comfort with some lighter textures, with LEATHER included
                return texture == ETexture.COTTON || texture == ETexture.DENIM || texture == ETexture.LEATHER || texture == ETexture.VELVET;

            case "warm":
                // For warm weather, prioritize breathable textures, with LEATHER as an option
                return texture == ETexture.COTTON || texture == ETexture.LACE || texture == ETexture.DENIM || texture == ETexture.LEATHER;

            case "hot":
                // For hot weather, use only light and breathable textures
                return texture == ETexture.COTTON || texture == ETexture.LACE || texture == ETexture.SILK || texture == ETexture.CHIFFON;

            default:
                return false;
        }
    }
}
