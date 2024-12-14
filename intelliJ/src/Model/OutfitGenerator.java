package edu.vassar.cmpu203.outfitgenerator.Model;//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//public class OutfitGenerator {
//
//    private Model.Closet closet;
//    private Model.ColorMatcher colorMatcher;
//    private WeatherService weatherService;
//    private TextureFilter textureFilter;
//    private PatternFilter patternFilter;
//    private static final int MAX_RECURSION_DEPTH = 10;
//
//    public OutfitGenerator(Model.Closet closet) {
//        this.closet = closet;
//        this.colorMatcher = new Model.ColorMatcher();
//        this.weatherService = new WeatherService();
//        this.textureFilter = new TextureFilter();
//        this.patternFilter = new PatternFilter();
//    }
//
//    // Main method for generating an outfit based on weather and maximum recursion depth
//    public List<ClothingItem> generateOutfit(double temperature, String condition) {
//        return generateOutfit(temperature, condition, 0);
//    }
//
//    // Recursive method to generate an outfit
//    private List<ClothingItem> generateOutfit(double temperature, String condition, int recursionDepth) {
//        if (recursionDepth > MAX_RECURSION_DEPTH) {
//            System.out.println("Max recursion depth reached. Unable to find matching outfit.");
//            return new ArrayList<>();
//        }
//
//        String tempCategory = classifyTemperature(temperature);
//
//        // Step 1: Filter items by temperature and condition
//        List<ClothingItem> filteredItems = filterByTemperatureAndCondition(tempCategory, condition);
//
//        // Step 2: Filter by texture
//        filteredItems = textureFilter.filterByTexture(filteredItems, tempCategory);
//
//        // Step 3: Filter by pattern to avoid clashing styles
//        filteredItems = patternFilter.filterByPattern(filteredItems);
//
//        // Step 4: Attempt to pick an outfit
//        ClothingItem upper = pickRandomItemOfType(filteredItems, EPartOfBody.UPPER);
//        ClothingItem lower = pickRandomItemOfType(filteredItems, EPartOfBody.LOWER);
//        ClothingItem feet = pickRandomItemOfType(filteredItems, EPartOfBody.FEET);
//
//        // Check color compatibility across selected items
//        if (upper != null && lower != null && feet != null && areColorsCompatible(upper.getColor(), lower.getColor(), feet.getColor())) {
//            // Ask if they want to add an item from "Other" category
//            ClothingItem other = askForOtherItem(filteredItems);
//            List<ClothingItem> outfit = new ArrayList<>(List.of(upper, lower, feet));
//            if (other != null) outfit.add(other);
//
//            System.out.println("Generated Outfit:");
//            displayItem("Upper", upper);
//            displayItem("Lower", lower);
//            displayItem("Feet", feet);
//            if (other != null) displayItem("Other", other);
//            return outfit;
//        } else {
//            System.out.println("Colors do not match; retrying selection.");
//            return generateOutfit(temperature, condition, recursionDepth + 1); // Retry with increased recursion depth
//        }
//    }
//
//    // Method to classify temperature into a readable category
//    private String classifyTemperature(double temperature) {
//        if (temperature < 0) return "Very Cold";
//        else if (temperature >= 0 && temperature < 10) return "Cold";
//        else if (temperature >= 10 && temperature < 15) return "Cool";
//        else if (temperature >= 15 && temperature < 25) return "Warm";
//        else return "Hot";
//    }
//
//    // Filter items based on temperature and weather condition
//    private List<ClothingItem> filterByTemperatureAndCondition(String tempCategory, String condition) {
//        List<ClothingItem> result = new ArrayList<>();
//        for (ClothingItem item : closet.getItems()) {
//            if (isSuitableForTemperature(item, tempCategory) && isSuitableForCondition(item, condition)) {
//                result.add(item);
//            }
//        }
//        return result;
//    }
//
//    // Helper method: Filter based on temperature
//    private boolean isSuitableForTemperature(ClothingItem item, String tempCategory) {
//        ETexture texture = item.getTexture();
//        switch (tempCategory) {
//            case "Very Cold": return texture == ETexture.WOOL || texture == ETexture.FUR;
//            case "Cold": return texture == ETexture.WOOL || texture == ETexture.LEATHER;
//            case "Cool": return texture == ETexture.COTTON || texture == ETexture.LEATHER;
//            case "Warm": return texture == ETexture.COTTON;
//            case "Hot": return texture == ETexture.COTTON || texture == ETexture.LACE;
//            default: return false;
//        }
//    }
//
//    // Helper method: Filter based on weather conditions
//    private boolean isSuitableForCondition(ClothingItem item, String condition) {
//        ETexture texture = item.getTexture();
//        if (condition.equalsIgnoreCase("raining")) {
//            return texture != ETexture.FUR && texture != ETexture.LACE;
//        } else if (condition.equalsIgnoreCase("snowing")) {
//            return texture == ETexture.WOOL || texture == ETexture.LEATHER;
//        }
//        return true;
//    }
//
//    // Pick a random clothing item of the specified type
//    private ClothingItem pickRandomItemOfType(List<ClothingItem> items, EPartOfBody type) {
//        List<ClothingItem> matchingItems = new ArrayList<>();
//        for (ClothingItem item : items) {
//            if (item.getPartOfBody() == type) {
//                matchingItems.add(item);
//            }
//        }
//        if (!matchingItems.isEmpty()) {
//            Random random = new Random();
//            return matchingItems.get(random.nextInt(matchingItems.size()));
//        }
//        return null;
//    }
//
//    // Check color compatibility across selected items
//    private boolean areColorsCompatible(EColor color1, EColor color2, EColor color3) {
//        return colorMatcher.isMatching(color1, color2) && colorMatcher.isMatching(color2, color3);
//    }
//
//    // Ask if the user wants to add an item from the "Other" category
//    private ClothingItem askForOtherItem(List<ClothingItem> items) {
//        System.out.print("Would you like to add an accessory (e.g., hat, bag)? (yes/no): ");
//        String response = new Scanner(System.in).nextLine();
//        if (response.equalsIgnoreCase("yes")) {
//            return pickRandomItemOfType(items, EPartOfBody.OTHER);
//        }
//        return null;
//    }
//
//    // Display the details of a clothing item
//    private void displayItem(String label, ClothingItem item) {
//        System.out.println(label + ": " + item.getItemDetails());
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutfitGenerator {

    private Closet closet;
    private ColorMatcher colorMatcher;
    private static final int MAX_RECURSION_DEPTH = 100;

    public OutfitGenerator(Closet closet) {
        this.closet = closet;
        this.colorMatcher = new ColorMatcher();
    }

    // Generate an outfit based on weather and maximum recursion depth
    public List<ClothingItem> generateOutfit(double temperature, String condition) {
        return generateOutfit(temperature, condition, 0);
    }

    // Recursive method to generate an outfit
    private List<ClothingItem> generateOutfit(double temperature, String condition, int recursionDepth) {
        if (recursionDepth > MAX_RECURSION_DEPTH) {
            System.out.println("Max recursion depth reached. Unable to find matching outfit.");
            return new ArrayList<>();
        }

        String tempCategory = classifyTemperature(temperature);

        // Step 1: Filter Upper items
        List<ClothingItem> upperItems = filterItemsByType(EPartOfBody.UPPER, tempCategory, condition);
        ClothingItem upper = pickRandomItem(upperItems);
        if (upper == null) {
            System.out.println("No matching upper item found. Retrying...");
            return generateOutfit(temperature, condition, recursionDepth + 1);
        }

        // Step 2: Filter Lower items that are compatible with Upper
        List<ClothingItem> lowerItems = filterItemsByType(EPartOfBody.LOWER, tempCategory, condition);
        lowerItems = filterByPattern(lowerItems, upper.getPattern()); // Ensure pattern compatibility
        ClothingItem lower = pickRandomItemWithColorCompatibility(lowerItems, upper.getColor());
        if (lower == null) {
            System.out.println("No matching lower item found. Retrying...");
            return generateOutfit(temperature, condition, recursionDepth + 1);
        }

        // Step 3: Filter Feet items that are compatible with Upper and Lower
        List<ClothingItem> feetItems = filterItemsByType(EPartOfBody.FEET, tempCategory, condition);
        feetItems = filterFeetBasedOnWeather(feetItems, condition); // Further refine for condition
        ClothingItem feet = pickRandomItemWithColorCompatibility(feetItems, upper.getColor(), lower.getColor());
        if (feet == null) {
            System.out.println("No matching feet item found. Retrying...");
            return generateOutfit(temperature, condition, recursionDepth + 1);
        }

        // Optional Accessory
        ClothingItem other = null;
        if (askForOtherItem()) {
            List<ClothingItem> otherItems = filterItemsByType(EPartOfBody.OTHER, tempCategory, condition);
            other = otherItems.isEmpty() ? null : pickRandomItem(otherItems);
        }

        // Display the Outfit
        List<ClothingItem> outfit = new ArrayList<>(List.of(upper, lower, feet));
        if (other != null) outfit.add(other);

        return outfit;
    }

    // Filter items based on type, temperature, and condition
    private List<ClothingItem> filterItemsByType(EPartOfBody type, String tempCategory, String condition) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : closet.getItems()) {
            if (item.getPartOfBody() == type && isSuitableForTemperature(item, tempCategory) && isSuitableForCondition(item, condition)) {
                if (isSuitableSubType(item, type, tempCategory)){
                    result.add(item);
                }
            }
        }
        return result;
    }
    private boolean isSuitableSubType(ClothingItem item, EPartOfBody type, String tempCategory) {
        switch(type) {
            case UPPER: if(isSuitableSubTypeUpper(item, tempCategory)){return true;} break;
            case LOWER: if(isSuitableSubTypeLower(item, tempCategory)) {return true;} break;
            case FEET: if(isSuitableSubTypeFeet(item, tempCategory)){return true;} break;
            case OTHER: if(isSuitableSubTypeOther(item, tempCategory)){return true;} break;
        }
        return false;
    }
    private boolean isSuitableForTemperature(ClothingItem item, String tempCategory) {
        ETexture texture = item.getTexture();
        return switch (tempCategory) {
            case "Very Cold" -> texture == ETexture.WOOL || texture == ETexture.FUR || texture == ETexture.LEATHER || texture == ETexture.VELVET || texture == ETexture.FLEECE;
            case "Cold" -> texture == ETexture.COTTON || texture == ETexture.FUR || texture == ETexture.VELVET || texture == ETexture.WOOL || texture == ETexture.LEATHER || texture == ETexture.FLEECE;
            case "Cool" -> texture == ETexture.COTTON || texture == ETexture.DENIM || texture == ETexture.LACE || texture == ETexture.LEATHER || texture == ETexture.FLEECE;
            case "Warm" -> texture == ETexture.COTTON || texture == ETexture.DENIM || texture == ETexture.LACE || texture == ETexture.SILK || texture == ETexture.CHIFFON;
            case "Hot" -> texture == ETexture.COTTON || texture == ETexture.LACE || texture == ETexture.SILK || texture == ETexture.CHIFFON;
            default -> false;
        };
    }
    private boolean isSuitableSubTypeUpper(ClothingItem item, String tempCategory) {
        Object upper = item.getSubtype();

        return switch (tempCategory) {
            case "Very Cold" -> upper == EUpper.SWEATER || upper == EUpper.SWEATSHIRT || upper == EUpper.JACKET;
            case "Cold" -> upper == EUpper.HOODIE || upper == EUpper.SWEATER || upper == EUpper.SWEATSHIRT || upper == EUpper.JACKET;
            case "Cool" -> upper == EUpper.HOODIE || upper == EUpper.SWEATSHIRT || upper == EUpper.BUTTON_UP || upper == EUpper.LONG_SLEEVE;
            case "Warm" -> upper == EUpper.TANK_TOP || upper == EUpper.T_SHIRT || upper == EUpper.CROPPED || upper == EUpper.DRESS || upper == EUpper.BUTTON_UP;
            case "Hot" -> upper == EUpper.T_SHIRT || upper == EUpper.CROPPED || upper == EUpper.DRESS || upper == EUpper.TANK_TOP;
            default -> false;
        };
    }

    private boolean isSuitableSubTypeLower(ClothingItem item, String tempCategory) {
        Object lower = item.getSubtype();
        return switch (tempCategory) {
            case "Very Cold" -> lower == ELower.JOGGERS || lower == ELower.SWEATPANTS || lower == ELower.LEGGINGS;
            case "Cold" -> lower == ELower.JOGGERS || lower == ELower.SWEATPANTS || lower == ELower.LEGGINGS || lower == ELower.PANTS;
            case "Cool" -> lower == ELower.JOGGERS || lower == ELower.SWEATPANTS || lower == ELower.LEGGINGS || lower == ELower.JEANS || lower == ELower.PANTS || lower == ELower.OVERALLS;
            case "Warm" -> lower == ELower.SHORTS || lower == ELower.OVERALLS || lower == ELower.SKIRT || lower == ELower.JEANS || lower == ELower.PANTS;
            case "Hot" -> lower == ELower.SHORTS || lower == ELower.SKIRT || lower == ELower.PANTS;
            default -> false;
        };
    }

    private boolean isSuitableSubTypeFeet(ClothingItem item, String tempCategory) {
        Object feet = item.getSubtype();
        return switch (tempCategory) {
            case "Very Cold" -> feet == EFeet.BOOTS;
            case "Cold" -> feet == EFeet.BOOTS || feet == EFeet.SNEAKERS;
            case "Cool" -> feet == EFeet.BOOTS || feet == EFeet.SNEAKERS || feet == EFeet.LOAFERS || feet == EFeet.HEELS;
            case "Warm" -> feet == EFeet.SNEAKERS || feet == EFeet.FLATS || feet == EFeet.SLIPPERS || feet == EFeet.SANDALS || feet == EFeet.HEELS;
            case "Hot" -> feet == EFeet.FLATS || feet == EFeet.SLIPPERS || feet == EFeet.SANDALS || feet == EFeet.HEELS;
            default -> false;
        };
    }
    private boolean isSuitableSubTypeOther(ClothingItem item, String tempCategory) {
        Object other = item.getSubtype();
        return switch (tempCategory) {
            case "Very Cold" -> other == EOther.BAG || other == EOther.BEANIE || other == EOther.JEWELRY;
            case "Cold" -> other == EOther.BAG || other == EOther.BELT || other == EOther.BEANIE || other == EOther.JEWELRY;
            case "Cool" -> other == EOther.BAG || other == EOther.BELT || other == EOther.JEWELRY;
            case "Warm" -> other == EOther.BAG || other == EOther.BELT || other == EOther.HAT || other == EOther.JEWELRY;
            case "Hot" -> other == EOther.BAG || other == EOther.HAT || other == EOther.GLASSES || other == EOther.JEWELRY;
            default -> false;
        };
    }

    private boolean isSuitableForCondition(ClothingItem item, String condition) {
        if ("raining".equalsIgnoreCase(condition)) {
            return item.getTexture() != ETexture.FUR && item.getTexture() != ETexture.LACE;
        } else if ("snowing".equalsIgnoreCase(condition)) {
            return item.getTexture() == ETexture.WOOL || item.getTexture() == ETexture.LEATHER || item.getTexture() == ETexture.FUR || item.getTexture() == ETexture.VELVET;
        }
        return true;
    }

    private List<ClothingItem> filterByPattern(List<ClothingItem> items, EPattern upperPattern) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.getPattern() == EPattern.NONE || upperPattern == EPattern.NONE || item.getPattern() == upperPattern) {
                result.add(item);
            }
        }
        return result;
    }

    private List<ClothingItem> filterFeetBasedOnWeather(List<ClothingItem> items, String condition) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (!"raining".equalsIgnoreCase(condition) || item.getTexture() == ETexture.LEATHER){
                result.add(item);
            }
        }
        return result;
    }

    private ClothingItem pickRandomItem(List<ClothingItem> items) {
        return items.isEmpty() ? null : items.get((int) (Math.random() * items.size()));
    }

    private ClothingItem pickRandomItemWithColorCompatibility(List<ClothingItem> items, EColor... matchingColors) {
        List<ClothingItem> compatibleItems = new ArrayList<>();
        for (ClothingItem item : items) {
            boolean matchesAll = true;
            for (EColor color : matchingColors) {
                if (!colorMatcher.isMatching(item.getColor(), color)) {
                    matchesAll = false;
                    break;
                }
            }
            if (matchesAll) compatibleItems.add(item);
        }
        return compatibleItems.isEmpty() ? null : compatibleItems.get((int) (Math.random() * compatibleItems.size()));
    }

    private boolean askForOtherItem() {
        System.out.print("Would you like to add an accessory (e.g., hat, bag)? (yes/no): ");
        String response = new Scanner(System.in).nextLine();
        return response.equalsIgnoreCase("yes");
    }

    private void displayOutfit(List<ClothingItem> outfit) {
        System.out.println("\nGenerated Outfit:");
        for (ClothingItem item : outfit) {
            System.out.println(item.getItemDetails());
        }
    }

    private String classifyTemperature(double temperature) {
        if (temperature < 30) return "Very Cold";
        else if (temperature >= 30 && temperature < 50) return "Cold";
        else if (temperature >= 50 && temperature < 70) return "Cool";
        else if (temperature >= 70 && temperature < 90) return "Warm";
        else return "Hot";
    }
}
