package edu.vassar.cmpu203.outfitgenerator.Model;//public class ClothingItem {
//    private EPartOfBody partOfBody;
//    private Object subtype; // Object used to store different subtype enums (EUpper, ELower, etc.)
//    private ETexture texture;
//    private EPattern pattern;
//    private EColor color;
//
//    // Constructor
//    public ClothingItem(EPartOfBody partOfBody, Object subtype, ETexture texture, EPattern pattern, EColor color) {
//        this.partOfBody = partOfBody;
//        this.subtype = subtype;
//        this.texture = texture;
//        this.pattern = pattern;
//        this.color = color;
//    }
//
//    // Getters for each attribute
//    public EPartOfBody getPartOfBody() {
//        return partOfBody;
//    }
//
//    public Object getSubtype() {
//        return subtype;
//    }
//
//    public ETexture getTexture() {
//        return texture;
//    }
//
//    public EPattern getPattern() {
//        return pattern;
//    }
//
//    public EColor getColor() {
//        return color;
//    }
//
//    // Method to retrieve item details as a string
//    public String getItemDetails() {
//        return "Part of Body: " + partOfBody + ", Subtype: " + subtype +
//                ", Texture: " + texture + ", Pattern: " + pattern + ", Color: " + color;
//    }
//}

public class ClothingItem {
    private EPartOfBody partOfBody;
    private Object subtype;
    private ETexture texture;
    private EPattern pattern;
    private EColor color;

    public ClothingItem(EPartOfBody partOfBody, Object subtype, ETexture texture, EPattern pattern, EColor color) {
        this.partOfBody = partOfBody;
        this.subtype = subtype;
        this.texture = texture;
        this.pattern = pattern;
        this.color = color;
    }

    // Getter methods
    public EPartOfBody getPartOfBody() {
        return partOfBody;
    }

    //Get Enum values for each category
    public Object getSubtype() {
        return subtype;
    }

    public ETexture getTexture() {
        return texture;
    }

    public EPattern getPattern() {
        return pattern;
    }

    public EColor getColor() {
        return color;
    }

    //Set each category equal to something else.
    public void setPartOfBody(EPartOfBody partOfBody) {
        this.partOfBody = partOfBody;
    }
    public void setSubType(Object subtype) {
        this.subtype = subtype;
    }
    public void setTexture(ETexture texture) {
        this.texture = texture;
    }
    public void setPattern(EPattern pattern) {
        this.pattern = pattern;
    }
    public void setColor(EColor color) {
        this.color = color;
    }

    // Optional: a method to return item details as a string
    public String getItemDetails() {
        return "Part of Body: " + partOfBody + ", Subtype: " + subtype +
                ", Texture: " + texture + ", Pattern: " + pattern + ", Color: " + color;
    }
}
