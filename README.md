# Outfit Generator Prototype

## Overview
The **Outfit Generator Prototype** is a Java-based application with a text-based interface. It assists users in creating personalized outfits based on weather, texture, pattern, and color compatibility, utilizing the **Model-View-Controller (MVC)** architecture to ensure scalability and maintainability.

## Features
- **Outfit Generation**: Generates weather-based outfits by filtering closet items according to specified weather conditions, ensuring compatibility in texture, pattern, and color.
- **Closet Management**:
   - **Add Items**: Users can add new items, specifying attributes like clothing type, color, texture, and pattern.
   - **View Closet**: Displays all items in the virtual closet, organized by category.
   - **Edit and Remove Items**: Users can update or remove items as needed.
a
## System Requirements
- **Java**: Java 11 or higher is required to run the application.

## Installation
**Clone the Repository**:
    ```bash
    git clone https://gitlab.cs.vassar.edu/cmpu203-f24-projects/team-2f.git
    cd outfit-generator-prototype
    ```
## Open in Android Studio:
1. Open Android Studio.
2. Click on **File > Open** and select the cloned repository folder.
3. Allow Android Studio to import the project and download any necessary dependencies.

## Run the App:
1. Connect your Android device via USB or start an emulator.
2. Click on the **Run** button in Android Studio to build and install the app on your device.

## Main Menu Options
### Generate Outfit:
- Tap the **Generate Outfit** option from the main menu.
- The application automatically fetches the current weather condition using the OpenWeatherMap API.
- The app filters closet items based on the weather data, ensuring compatibility for selected upper and lower pieces in terms of pattern, texture, and color.
- Optionally, save the generated outfit for future reference.
- The completed outfit is displayed based on your closet items and the current weather.

### Manage Closet:
- **Add Items:** Add a new clothing item by selecting part of the body (Upper, Lower, Feet, or Accessories) and entering relevant details.
- **View Closet:** View all stored items, organized by category.
- **Edit/Remove Items:** Modify or delete items to ensure the closet remains current.

### Save Outfits:
- **View Saved Outfits:** View all outfits that you have previously saved.
- **Delete Saved Outfits:** Remove any saved outfits you no longer need.

### Manage Preferences:
- Update user preferences that may affect outfit generation.

### Exit:
- Use the device's back button or menu option to close the application.

## Example Usage Flow
### Adding an Item to the Closet:
1. From the main menu, select **Manage Closet > Add Clothing**.
2. Enter item details (e.g., Part of Body: Upper, Subtype: T-Shirt, Texture: Cotton, Pattern: None, Color: Blue).
3. Confirm to add the item to the closet.

### Generating an Outfit:
1. Select **Generate Outfit** from the main menu.
2. The app fetches the current weather condition automatically.
3. The system displays the generated outfit based on your closet items and the current weather.
4. Optionally, save the outfit by tapping **Save Outfit**.

### Viewing Saved Outfits:
1. Select **Save Outfits > View Saved Outfits** from the main menu.
2. Browse through your saved outfits and view details.

### Editing or Removing an Item:
1. Select **Manage Closet > View Closet**.
2. Tap on an item to edit its details or remove it from the closet.

## Design Patterns
The application follows the **Model-View-Controller (MVC)** design pattern:
- **Model:**
    - `Closet` and `ClothingItem` classes manage closet data and clothing attributes.
    - Integration with Firebase for data persistence.
    - `OutfitGenerator` class handles the logic for generating outfits based on weather data.
- **View:**
    - Android layouts and fragments manage prompts and outputs.
    - Provides a graphical user interface for better user experience.
- **Controller:**
    - `ControllerActivity` contains logic for outfit generation and closet management, directing user interactions.

## How the Application Works
1. **Initialization:**
    - The application loads any pre-existing closet items and saved outfits from Firebase.
    - Starts with a main menu offering **Generate Outfit**, **Manage Closet**, and **Save Outfits** options.
2. **Outfit Generation:**
    - The system uses real-time weather data to filter closet items by texture, pattern, and color.
    - Upper clothing is selected first, followed by a matching lower item, and then footwear.
    - Generates a complete outfit suitable for the current weather conditions.
3. **Closet Management:**
    - Users can add, view, edit, or remove items in their virtual closet to maintain a comprehensive wardrobe inventory.
4. **Data Persistence:**
    - All closet items and saved outfits are stored in Firebase Realtime Database, ensuring data is preserved across sessions.

## Future Enhancements
- **Calendar Integration:** Potentially, users could apply outfits to specific dates or events.
- **Advanced Filters:** Implementing filters for seasons or specific occasions will help users find relevant clothing items more easily.
- **Social Sharing:** Allow users to share their outfits on social media platforms directly from the app.
- **User Preferences:** Incorporate user preferences for styles, colors, or excluded items to personalize outfit suggestions further.

## Authors and Acknowledgment
Developed by **Team 2-f: Ahmed Hashim & Rabiah Aziz**. Special thanks to **Prof. Rui Meireles** who provided feedback and support throughout the project.

## License
This project is licensed under the Vassar College policy, and utilizes the OpenWeatherMap API and Firebase services under their respective terms of service.

## Project Status
This is an active project with planned iterations to improve functionality and add features.

