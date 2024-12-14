# Outfit Generator Prototype

## Overview
The **Outfit Generator Prototype** is a Java-based application with a text-based interface. It assists users in creating personalized outfits based on weather, texture, pattern, and color compatibility, utilizing the **Model-View-Controller (MVC)** architecture to ensure scalability and maintainability.

## Features
- **Outfit Generation**: Generates weather-based outfits by filtering closet items according to specified weather conditions, ensuring compatibility in texture, pattern, and color.
- **Closet Management**:
   - **Add Items**: Users can add new items, specifying attributes like clothing type, color, texture, and pattern.
   - **View Closet**: Displays all items in the virtual closet, organized by category.
   - **Edit and Remove Items**: Users can update or remove items as needed.

## System Requirements
- **Java**: Java 11 or higher is required to run the application.

## Installation
**Clone the Repository**:
    ```bash
    git clone https://gitlab.cs.vassar.edu/cmpu203-f24-projects/team-2f.git
    cd outfit-generator-prototype
    ```


### Main Menu Options
1. **Generate Outfit**:
   -  Select the "Generate Outfit" option from the main menu.
   - Enter the current weather condition when prompted to tailor the clothing selection.
   - The application filters closet items based on the input weather, ensuring compatibility for selected upper and lower pieces in terms of pattern, texture, and color.
   - Optionally, add an accessory to the outfit.
   - The completed outfit is displayed based on user selections.

2. **Manage Closet**:
   - **Add Items**: Add a new clothing item by selecting part of the body (Top, Bottom, Feet, or Accessories) and entering relevant details.
   - **View Closet**: View all stored items, organized by category.
   - **Edit/Remove Items**: Modify or delete items to ensure the closet remains current.

3. **Exit**: Select "Exit" to close the application.

### Example Usage Flow
- **Adding an Item to the Closet**:
   - From the main menu, select **Manage Closet > Add Clothing**.
   - Enter item details (e.g., Part of Body: Upper, Subtype: T-Shirt, Texture: Cotton, Pattern: None, Color: Blue).
   - Confirm to add the item to the closet.

- **Generating an Outfit**:
   - Select **Generate Outfit** from the main menu.
   - Enter the weather condition (e.g., Warm).
   - Optionally add an accessory.
   - The system displays the generated outfit based on the user’s closet items and input.

- **Viewing the Closet**: Select **Manage Closet > View Closet** to see all stored items.

- **Editing or Removing an Item**: Select **Manage Closet > Edit/Remove Clothing** to update or delete items.

## Design Patterns
The application follows the **Model-View-Controller (MVC)** design pattern:
- **Model**: `Closet` and `ClothingItem` classes manage closet data and clothing attributes.
- **View**: Text-based user interface manages prompts and outputs.
- **Controller**: Contains logic for outfit generation and closet management, directing user interactions.

## How the Application Works
1. **Initialization**: The application loads any pre-existing closet items and starts with a main menu offering **Generate Outfit** and **Manage Closet** options.
2. **Outfit Generation**:
   - The system uses the weather input to filter closet items by texture, pattern, and color.
   - Upper clothing is selected first, followed by a matching lower item, and then footwear.
   - Optionally, an accessory can be added to complete the look.
3. **Closet Management**:
   - Users can add, view, edit, or remove items in their virtual closet to maintain a comprehensive wardrobe inventory.

## Future Enhancements
1. **Save Outfits**: Future iterations may allow users to save generated outfits for future reference.
2. **Calendar Integration**: Potentially, users could apply outfits to specific dates or events.
3. **Advanced Filters**: Implementing filters for season or specific occasions will help users find relevant clothing items more easily.



## Authors and Acknowledgment
Developed by [Team 2-f/Ahmed Hashim & Rabiah Aziz]. Special thanks to [Prof. Rabiah Aziz] who provided feedback and support throughout the project.

## License
This project is licensed under the Vassar, and OpenWeatherMap API.

## Project Status
This is an active project with planned iterations to improve functionality and add features.
