# Next Iteration (#2) Plan
| Rank           | Requirement(use case or feature)    | Comments                                                                                                            |
|----------------|-------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| High           | Upload My Closet                    | Generate Outfit and Save Outfit cannot work without clothing photos uploaded to My Model.Closet and descriptions applied. |
| Medium to High | Generate Outfit                     | Core feature for Outfit Generator app. Save Outfit depends on outfits generated.                                    |
| Low to Medium  | Validate Login and User Preferences | Important for storing some pre-defined user preferences like style, color, etc that are used to Generate Outfit.    |
| Low            | Saved Outfits                       | In the future, Generate Outfit could utilize favorite outfits.                                                      |

## Use Cases to Work On
1. **Upload My Model.Closet (Manual Categorization)**
    - **Objective**: Allow users to manually categorize clothes based on type, texture, pattern and color.
    - **Future Improvement**: Investigate a model that can automate categorization or give suggested descriptions in the future for a smoother user experience.
    - **Priority**:
        - **Criticality**: Ensures accurate categorization of items.
        - **Coverage**: Affects the quality of generated outfits and user satisfaction.
        - **Risk**: Low, user involvement reduces the need for automated classification.

2. **Generate Outfit (Rule-Based Matching)**
   - **Objective**: Use a rule-based system to match clothes based on predefined combinations (e.g., matching colors, types, and weather suitability).
   - **Future Improvement**: Explore training a model to make the outfit matching smarter and more adaptable to individual preferences, based on the feedback from the rule-based implementation. 
       Also, generate outfit should eventually use saved outfits and user feedback to generate better outfits.
   - **Priority**:
      - **Criticality**: Core feature for generating outfits.
      - **Coverage**: Uses data from wardrobe, preferences, and weather conditions.
      - **Risk**: Medium, easier to implement than AI, suitable for testing functionality. Might require more work to match colors, types, materials, etc. based on style and weather.

3. **Validate Login and User Preferences**
    - **Objective**: Enhance user preferences to include specific details (e.g., preferred styles, favorite colors).
    - **Future Improvement**: Gather preference data to train a model that can adapt suggestions based on more nuanced style trends and user habits.
    - **Priority**:
        - **Criticality**: Personalization is a key part of the user experience.
        - **Coverage**: Generate Outfit is affected by user preferences. My Model.Closet and Save Outfits depend on stored information associated with the user.
        - **Risk**: Low, mainly concerns expanding preference options and storing user data.

4. **Save Outfits (User Manually Saves Outfits)**
    - **Objective**: User can save a generated outfit or create an outfit using My Model.Closet to save. Allow users to manually update saved outfits.
    - **Future Improvement**: Look into developing a model that can provide automated suggestions for updating saved outfits, using user trends and wardrobe changes.
    - **Priority**:
        - **Criticality**: Enhances engagement by allowing users to refresh outfits. 
        - **Coverage**: Not as important to the functioning of Outfit Generator. All aspects of app can run fine without Save Outfits.
        - **Risk**: Low, user-driven changes reduce implementation complexity.

## Plan Summary
- **Implement Rule-Based Matching** for generating outfits to establish a working solution quickly.
- **Enhance Manual Categorization** in "My Model.Closet" with helpful hints for users, while exploring a model for automating this process in the future.
- **Expand User Preferences** to collect more detailed data for potential future training.
- **Provide Manual Update Options** for saved outfits with plans to explore automated suggestions based on model training.

### Exploration and Future Improvements
- **Model Exploration**: We are actively researching and considering training a model to make the application easier to use, more accurate, and capable of generating personalized outfit suggestions. This will be done after testing the rule-based approach to determine the best use of current technology.

## Phase 3 Next Iteration (#3) Plan

| Rank           | Requirement (Use Case or Feature)                 | Comments                                                                                                                 |
|----------------|---------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| High           | Generate Outfit with Limited Closet Items         | Ensures usability when closet items are insufficient, creating an outfit with available items, even if incomplete.       |
| High           | Multi-layer Upper Outfit Generation               | Allows users to create layered outfits (e.g., shirt + jacket), improving realism and usability in various seasons.       |
| High           | Migrate to Android and Firebase                   | Transition to an Android application, using Firebase to store user and outfit data, replacing the current CSV file setup.|
| Medium         | Weather-Based Color Suggestions                   | Suggests color palettes based on seasons, e.g., lighter colors in summer, darker in winter.                              |
| Medium         | Future/Planned Outfits for Different Days         | Provides flexibility for users planning outfits in advance for events or travel with different weather conditions.       |
| Medium         | Manage Preferences                                | Allows users to save and update preferences (e.g., style, color) for a personalized experience and less repetitive input.|
| Low            | Save and Retrieve Outfits                         | Enables users to save generated outfits for future use, enhancing personalization and preference tracking.               |

## Use Cases to Work On

### 1. Generate Outfit with Limited Closet Items
- **Objective**: Generate an outfit using available items in the closet, ensuring an output even with limited options.
- **Priority**:
   - **Criticality**: High - Maintains functionality under varying closet conditions.
   - **Coverage**: Affects outfit generation accuracy and app usability.
   - **Risk**: Medium - Ensuring cohesive results with limited data may require complex handling.

### 2. Multi-layer Upper Outfit Generation
- **Objective**: Allow users to generate layered outfits, enhancing versatility for varying climates and seasonal use.
- **Priority**:
   - **Criticality**: High - Core to realistic and weather-appropriate outfit generation.
   - **Coverage**: Improves season adaptability and user satisfaction.
   - **Risk**: Medium - Requires additional logic for multi-layer compatibility.

### 3. Migrate to Android and Firebase
- **Objective**: Transition from a Java console application to an Android app, leveraging Firebase to store data, replacing CSV file usage.
- **Priority**:
   - **Criticality**: High - Essential for improved user experience, persistence, and mobile accessibility.
   - **Coverage**: Extends application accessibility and enhances data storage with Firebase.
   - **Risk**: Medium to High - Requires Android development setup, Firebase integration, and UI/UX redesign.

### 4. Weather-Based Color Suggestions
- **Objective**: Automatically recommend seasonal colors, such as lighter shades in warmer weather and darker shades in cooler months.
- **Priority**:
   - **Criticality**: Medium - Adds subtle but effective personalization for seasonal styling.
   - **Coverage**: Improves user satisfaction by aligning outfit colors with seasonal expectations.
   - **Risk**: Low - Straightforward implementation of a color palette selection based on seasons.

### 5. Future/Planned Outfits for Different Weather Conditions
- **Objective**: Allow users to plan outfits for specific days or locations where weather may differ from the current conditions.
- **Priority**:
   - **Criticality**: Medium - Essential for user planning flexibility, especially useful for events and travel.
   - **Coverage**: Adds significant user functionality without affecting core generation features.
   - **Risk**: Medium - Requires managing weather data for future dates and locations.

### 6. Manage Preferences
- **Objective**: Allow users to save and view their preferences, such as age, gender, style, and other favorite attributes, to personalize the experience.
- **Priority**:
   - **Criticality**: Medium - Reduces repetitive input, improves outfit accuracy based on stored preferences.
   - **Coverage**: Directly affects user satisfaction and outfit generation.
   - **Risk**: Low - Primarily involves data storage and retrieval with Firebase.

### 7. Save and Retrieve Outfits
- **Objective**: Enable users to save generated outfits for future use, allowing them to revisit and reuse styles.
- **Priority**:
   - **Criticality**: Low - Enhances user engagement but does not impact core functionality.
   - **Coverage**: Useful for users building a personal style history.
   - **Risk**: Low - User-driven action, simplifies implementation.

## Plan Summary

- **Android Migration**: Transition the application to Android to provide a mobile-friendly experience and improved accessibility.
- **Firebase Integration**: Use Firebase for data storage, enabling real-time database updates, data persistence, and enhanced security over CSV files.
- **Enhanced Outfit Generation**: Implement logic to handle limited closet items and provide seasonal color recommendations.
- **Multi-layer Outfit Capability**: Allow users to layer upper garments for enhanced seasonal flexibility.
- **Outfit Saving and Retrieval**: Enable outfit saving for user preferences and style tracking.

### Exploration and Future Improvements

- **Advanced Matching Algorithm**: We plan to investigate models that adapt to user preferences and improve color and style matching based on user feedback.
- **Weather Forecast Integration**: We will explore options to fetch weather forecasts, supporting outfit generation for future dates and different locations.


