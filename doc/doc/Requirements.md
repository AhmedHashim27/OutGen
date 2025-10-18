# Requirements Documentation Update

## Requirement Updates

### Platform Transition
- **Original Requirement**: Desktop-based Java application with CSV for data storage.
- **Updated Requirement**: Android-based mobile application, utilizing Firebase for real-time database and user data storage.

### Outfit Generation Enhancements
- **Original Requirement**: Generate outfits based on weather, pattern compatibility, texture, and color.
- **Updated Requirement**:
    - **Generate Limited Outfits**: Provide outfit options even when closet inventory is limited, ensuring functionality under various closet conditions.
    - **Multi-layer Upper Outfit**: Allow multiple upper layers (e.g., shirt + jacket), enhancing seasonal adaptability.
    - **Color Recommendations by Season**: Suggest lighter colors in summer, darker tones in winter to align with seasonal styling expectations.
    - **Future Outfit Planning**: Users can plan outfits for upcoming days or different locations with varying weather conditions.
    - **Save and Retrieve Outfits**: Enable users to save outfits for future reference and provide outfit suggestions based on saved preferences.

### Manage Preferences
- **Original Requirement**: Allow users to save basic preferences (e.g., style and color).
- **Updated Requirement**:
    - **Expanded Preference Options**: Include gender, age, favorite textures, patterns, colors, and seasons, allowing more tailored recommendations.

### Firebase Integration
- **Original Requirement**: Store data in CSV files.
- **Updated Requirement**: Use Firebase as the primary data storage, enabling real-time updates, data persistence, and multi-user support.

## Use Case Detail: Generate Outfit with Limited Closet Items

### 1. Primary Actor and Goals
- **User**: Wants to receive an outfit suggestion even when closet inventory is limited. The outfit should prioritize essential items (e.g., top, bottom) and complete as much as possible given the available items.

### 2. Other Stakeholders and Their Goals
- **System**: Ensure user satisfaction by delivering an outfit despite closet constraints.
- **Database**: Retrieve all available clothing items to maximize outfit completeness.

### 3. Preconditions
- User has logged into their profile and accessed their closet.
- Firebase database contains at least one upper, lower, and footwear item for the user.

### 4. Post-conditions
- The system displays an outfit based on available items.
- If the closet lacks certain pieces, the system informs the user but provides as complete an outfit as possible.

### 5. Workflow
1. **Initiate Outfit Generation**: User selects "Generate Outfit" on the main menu.
2. **Check Closet Inventory**: System checks available items in the Firebase database.
3. **Prioritize Essential Items**: System selects upper, lower, and footwear items based on user preferences and weather, prioritizing these essentials.
4. **Handle Insufficient Items**:
    - If an essential item is missing, notify the user and proceed with available items.
5. **Display Outfit**: Present the user with the generated outfit or notify them if an outfit cannot be completed due to inventory limitations.

## Updated Use Cases Overview

1. **Generate Outfit**: Generate an outfit based on weather, seasonal colors, and user preferences, with support for limited inventory.
2. **Manage Closet**: Add, view, edit, and remove items, categorized by type, color, and other attributes.
3. **Manage Preferences**: Save detailed preferences (e.g., favorite colors, patterns) to enhance personalization.
4. **Save and Retrieve Outfits**: Save generated outfits for future reference and outfit suggestions.

## Future Considerations

- **Automated Suggestions**: Leverage machine learning to suggest outfit updates based on user style patterns and closet changes.
- **Outfit History**: Implement a history of saved outfits for user reference, enhancing personalization.
- **Expanded Firebase Integration**: Use Firebase’s real-time database features to improve the app’s responsiveness and support additional features like sharing outfits.
