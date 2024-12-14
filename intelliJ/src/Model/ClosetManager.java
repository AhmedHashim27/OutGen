package edu.vassar.cmpu203.outfitgenerator.Model;
import Controller.Controller;
import java.io.*;

public class ClosetManager {
    private Closet closet;
    private static final String CSV_FILE_PATH = "src/closet_items.csv";

    public ClosetManager(Closet closet) {
        this.closet = closet;
    }

    // Save closet items to a CSV file
    public void saveClosetToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.println("PartOfBody,Subtype,Texture,Pattern,Color"); // Header row
            for (ClothingItem item : closet.getItems()) {
                writer.println(item.getPartOfBody() + "," + item.getSubtype() + "," +
                        item.getTexture() + "," + item.getPattern() + "," + item.getColor());
            }
            System.out.println("Model.Closet items saved to CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error saving to CSV: " + e.getMessage());
        }
    }

    // Append a single clothing item to the CSV file
    public void saveSingleItemToCSV(ClothingItem item) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.println(item.getPartOfBody() + "," + item.getSubtype() + "," +
                    item.getTexture() + "," + item.getPattern() + "," + item.getColor());
            System.out.println("New item saved to CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error saving item to CSV: " + e.getMessage());
        }
    }

    public void removeSingleItemFromCSV(ClothingItem item) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, false))) {
            writer.println(item.getPartOfBody() + "," + item.getSubtype() + "," +
                    item.getTexture() + "," + item.getPattern() + "," + item.getColor());
            System.out.println("New item removed from CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error removing item from CSV: " + e.getMessage());
        }
    }

    public void editSingleItemInCSV(ClothingItem item) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, false))) {
            writer.println(item.getPartOfBody() + "," + item.getSubtype() + "," +
                    item.getTexture() + "," + item.getPattern() + "," + item.getColor());
            System.out.println("Item removed from CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error removing item from CSV: " + e.getMessage());
        }
    }

    // Load closet items from a CSV file without reinitializing Model.Closet
    public void loadClosetFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            reader.readLine(); // Skip header row
            System.out.println("Loading items from CSV...");
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");

                if (attributes.length < 5) {
                    System.err.println("Skipping incomplete line: " + line);
                    continue;
                }

                EPartOfBody partOfBody = EPartOfBody.valueOf(attributes[0]);
                String subtypeString = attributes[1];
                ETexture texture = ETexture.valueOf(attributes[2]);
                EPattern pattern = EPattern.valueOf(attributes[3]);
                EColor color = EColor.valueOf(attributes[4]);

                // Determine the subtype based on the part of the body
                Object subtype = switch (partOfBody) {
                    case UPPER -> EUpper.valueOf(subtypeString);
                    case LOWER -> ELower.valueOf(subtypeString);
                    case FEET -> EFeet.valueOf(subtypeString);
                    case OTHER -> EOther.valueOf(subtypeString);
                };

                ClothingItem item = new ClothingItem(partOfBody, subtype, texture, pattern, color);
                closet.addClothing(item); // Add to existing Model.Closet instance
                System.out.println("Loaded item: " + item.getItemDetails()); // Debug information
            }
            System.out.println("Model.Closet items loaded from CSV successfully.");
        } catch (IOException e) {
            System.err.println("Error loading from CSV: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error parsing an item from CSV. Ensure all enum values are valid: " + e.getMessage());
        }
    }
}



//
//
//
//
//import java.io.*;
//import java.util.List;
//
//public class Model.ClosetManager {
//    private Model.Closet closet;
//    private static final String CSV_FILE_PATH = "/home/ahashim/team-2f/intelliJ/src/closet_items.csv";
//
//    public Model.ClosetManager(Model.Closet closet) {
//        this.closet = closet;
//    }
//
//    // Save all closet items to the CSV file
//    public void saveClosetToCSV() {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
//            writer.println("PartOfBody,Subtype,Texture,Pattern,Color"); // Header row
//            for (ClothingItem item : closet.getItems()) {
//                writer.println(item.getPartOfBody() + "," + item.getSubtype() + "," +
//                        item.getTexture() + "," + item.getPattern() + "," + item.getColor());
//            }
//            System.out.println("Model.Closet items saved to CSV successfully.");
//        } catch (IOException e) {
//            System.err.println("Error saving to CSV: " + e.getMessage());
//        }
//    }
//
//    // Append a single clothing item to the CSV file
//    public void saveSingleItemToCSV(ClothingItem item) {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
//            writer.println(item.getPartOfBody() + "," + item.getSubtype() + "," +
//                    item.getTexture() + "," + item.getPattern() + "," + item.getColor());
//            System.out.println("New item saved to CSV successfully.");
//        } catch (IOException e) {
//            System.err.println("Error saving item to CSV: " + e.getMessage());
//        }
//    }
//
//    // Remove an item from the closet and update the CSV
//    public void removeSingleItemFromCSV(ClothingItem item) {
//        closet.deleteClothing(item); // Remove from memory
//        saveClosetToCSV(); // Rewrite the CSV with the updated list
//    }
//
//    // Edit an item in the closet and update the CSV
//    public void editSingleItemInCSV(ClothingItem originalItem, ClothingItem newItem) {
//        closet.editClothing(originalItem, newItem.getPartOfBody(), newItem.getSubtype(), newItem.getTexture(), newItem.getPattern(), newItem.getColor());
//        saveClosetToCSV(); // Rewrite the CSV with the updated list
//    }
//
//    // Load closet items from a CSV file into the Model.Closet instance
//    public void loadClosetFromCSV() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
//            String line;
//            reader.readLine(); // Skip header row
//            System.out.println("Loading items from CSV...");
//            while ((line = reader.readLine()) != null) {
//                String[] attributes = line.split(",");
//
//                if (attributes.length < 5) {
//                    System.err.println("Skipping incomplete line: " + line);
//                    continue;
//                }
//
//                EPartOfBody partOfBody = EPartOfBody.valueOf(attributes[0]);
//                String subtypeString = attributes[1];
//                ETexture texture = ETexture.valueOf(attributes[2]);
//                EPattern pattern = EPattern.valueOf(attributes[3]);
//                EColor color = EColor.valueOf(attributes[4]);
//
//                // Determine the subtype based on the part of the body
//                Object subtype = switch (partOfBody) {
//                    case UPPER -> EUpper.valueOf(subtypeString);
//                    case LOWER -> ELower.valueOf(subtypeString);
//                    case FEET -> EFeet.valueOf(subtypeString);
//                    case OTHER -> EOther.valueOf(subtypeString);
//                };
//
//                ClothingItem item = new ClothingItem(partOfBody, subtype, texture, pattern, color);
//                closet.addClothing(item); // Add to existing Model.Closet instance
//                System.out.println("Loaded item: " + item.getItemDetails()); // Debug information
//            }
//            System.out.println("Model.Closet items loaded from CSV successfully.");
//        } catch (IOException e) {
//            System.err.println("Error loading from CSV: " + e.getMessage());
//        } catch (IllegalArgumentException e) {
//            System.err.println("Error parsing an item from CSV. Ensure all enum values are valid: " + e.getMessage());
//        }
//    }
//}
//
