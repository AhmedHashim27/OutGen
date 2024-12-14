package edu.vassar.cmpu203.outfitgenerator.Model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ColorMatcher {

    private static final Map<EColor, List<EColor>> colorMatches = new EnumMap<>(EColor.class);

    static {
        // Define color matches based on general fashion pairings and additional colors
        colorMatches.put(EColor.BLACK, List.of(EColor.WHITE, EColor.GREY, EColor.BROWN, EColor.YELLOW, EColor.PINK, EColor.RED, EColor.ORANGE, EColor.GREEN, EColor.BLUE, EColor.PURPLE, EColor.BROWN, EColor.SILVER, EColor.GOLD, EColor.MULTICOLORED, EColor.BLACK));
        colorMatches.put(EColor.WHITE, List.of(EColor.WHITE, EColor.BLACK, EColor.GREY, EColor.BLUE, EColor.PINK, EColor.RED, EColor.ORANGE, EColor.GREEN, EColor.PURPLE, EColor.BROWN, EColor.SILVER, EColor.GOLD, EColor.MULTICOLORED));
        colorMatches.put(EColor.GREY, List.of(EColor.GREY, EColor.BLACK, EColor.WHITE, EColor.RED, EColor.GREEN, EColor.BLUE, EColor.PURPLE, EColor.PINK, EColor.SILVER, EColor.GOLD));
        colorMatches.put(EColor.RED, List.of(EColor.RED, EColor.PINK, EColor.GREY, EColor.GOLD, EColor.SILVER, EColor.BLACK, EColor.WHITE));
        colorMatches.put(EColor.ORANGE, List.of(EColor.ORANGE, EColor.BLUE, EColor.GREEN, EColor.BROWN, EColor.WHITE, EColor.YELLOW, EColor.BLACK, EColor.GOLD, EColor.SILVER));
        colorMatches.put(EColor.YELLOW, List.of(EColor.YELLOW, EColor.PURPLE, EColor.BROWN, EColor.GREY, EColor.WHITE, EColor.BLACK));
        colorMatches.put(EColor.GREEN, List.of(EColor.GREEN, EColor.BROWN, EColor.WHITE, EColor.GREY, EColor.GOLD));
        colorMatches.put(EColor.BLUE, List.of(EColor.BLUE, EColor.ORANGE, EColor.GREEN, EColor.WHITE, EColor.GREY, EColor.SILVER));
        colorMatches.put(EColor.PINK, List.of(EColor.PINK, EColor.RED, EColor.SILVER, EColor.GREY, EColor.BROWN, EColor.WHITE, EColor.BLACK, EColor.PURPLE));
        colorMatches.put(EColor.PURPLE, List.of(EColor.PURPLE, EColor.YELLOW, EColor.GREY, EColor.PINK, EColor.GOLD));
        colorMatches.put(EColor.BROWN, List.of(EColor.BROWN, EColor.PINK, EColor.GREY, EColor.ORANGE, EColor.GREEN, EColor.YELLOW, EColor.BLACK));
        colorMatches.put(EColor.MULTICOLORED, List.of(EColor.BLACK, EColor.WHITE, EColor.GREY)); // Typically works with neutral colors
        colorMatches.put(EColor.SILVER, List.of(EColor.BLACK, EColor.WHITE, EColor.BLUE, EColor.GREY, EColor.PINK, EColor.RED));//Cooler colors
        colorMatches.put(EColor.GOLD, List.of(EColor.BLACK, EColor.WHITE, EColor.GREEN, EColor.BROWN, EColor.RED, EColor.ORANGE, EColor.PURPLE, EColor.GREEN));//Warmer colors
    }

    // Returns matching colors for a given color
    public List<EColor> getMatchingColors(EColor color) {
        return colorMatches.getOrDefault(color, new ArrayList<>());
    }

    // Checks if two specific colors are compatible
    public boolean isMatching(EColor color1, EColor color2) {
        List<EColor> matchingColors = colorMatches.get(color1);
        return matchingColors != null && matchingColors.contains(color2);
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        ColorMatcher matcher = new ColorMatcher();

        // Example test: Retrieve matching colors for RED
        EColor testColor = EColor.RED;
        List<EColor> matchingColors = matcher.getMatchingColors(testColor);

        System.out.println("Colors that match with " + testColor + ": " + matchingColors);

        // Example test: Check if RED and GREEN match
        EColor color1 = EColor.RED;
        EColor color2 = EColor.GREEN;
        boolean match = matcher.isMatching(color1, color2);
        System.out.println("Do " + color1 + " and " + color2 + " match? " + match);
    }
}
