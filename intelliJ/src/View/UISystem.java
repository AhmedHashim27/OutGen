package View;

import Model.Closet;
import Model.ClosetManager;
import Model.EPartOfBody;

import Model.OutfitGenerator;
import Model.EColor;
import Model.ETexture;
import Model.EPattern;
import Model.EPartOfBody;
import java.util.Scanner;

public interface UISystem {
    void startApp(Closet closet, ClosetManager closetManager, Scanner scanner);
    void manageCloset(Closet closet, ClosetManager closetManager, Scanner scanner);
    void generateOutfit(OutfitGenerator outfitGenerator);
    void addItemToCloset(Closet closet, ClosetManager closetManager, Scanner scanner);
    void removeItemFromCloset(Closet closet, ClosetManager closetManager, Scanner scanner);
    void editItemsInCloset(Closet closet, ClosetManager closetManager, Scanner scanner);
    void filterItemsInCloset(Closet closet, ClosetManager closetManager, Scanner scanner);
    EPartOfBody partOfBodyEnum(Scanner scanner);
    Object subTypeEnum(Scanner scanner, EPartOfBody partOfBody);
    ETexture textureEnum(Scanner scanner);
    EPattern patternEnum(Scanner scanner);
    EColor colorEnum(Scanner scanner);
}
