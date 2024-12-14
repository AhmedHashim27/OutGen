# Vision Document

## 1. Introduction

The target audience includes people who want to improve their style or those who do not have time to put together outfits. This can encompass individuals who are both into fashion and those who are not. The primary demographics are pre-teens, teenagers, and young adults, though others can benefit.

Outfit Generator will generate personalized outfits for users based on their preferences, the occasion, and current weather conditions. The application will offer features such as a customizable avatar to visualize outfits and a calendar aspect to plan outfits ahead of time.

## 2. Business Case

<<<<<<< HEAD
Outfit Generator has unique functionality that combines features from different applications into a cohesive design:
1. It allows users to save outfits as cut-out stickers in a "My Closet" library, mimicking functions typically performed using apps like iMessage and Notes.
2. It integrates location-based weather data with style inspiration, similar to features offered by the Weather app and Pinterest, to curate personalized outfits for users.
3. It aims to reduce decision fatigue by making daily styling easy, offering both randomized outfit options and personalized suggestions based on selected items.
=======
Outfit Generator has unique functionality that brings together features from different applications into a cohesive design:
1. It provides the ability to save outfits as cut-out stickers to a "My Model.Closet" library, mimicking functions typically performed using apps like iMessage and Notes.
2. It combines features like location-based weather data with style inspiration, similar to functions offered by apps like the Weather app and Pinterest, to curate personalized outfits for users.
3. It aims to reduce decision fatigue by making daily styling easy, offering users both randomized outfit options and personalized suggestions based on selected items.
>>>>>>> refs/remotes/origin/main

## 3. Key Functionality

- **Manage Preferences**:
  - Allows users to manage preferences such as age, gender, and style, which can be modified at any time.

<<<<<<< HEAD
- **My Closet**:
  - Users can upload photos of clothing items into categories: Tops, Bottoms, Shoes, and Accessories.
  - Users provide details for each item, including texture, pattern, color, and type.
  - Filters allow users to view items by these classifications.
=======
- **My Model.Closet**:
    - Users can upload photos of their clothing items into four main categories: Tops, Bottoms, Shoes, and Accessories.
    - For each item, users provide details like Texture, Pattern, Color, and Type of Clothing (subsection of the category).
    - Users can filter "My Model.Closet" based on these classifications.
>>>>>>> refs/remotes/origin/main

- **Generate Outfit**:
  - Users can generate an outfit with a "Generate Outfit" button. Options include creating a fully randomized outfit or basing the outfit on one or two selected clothing items.
  - Users can specify destinations (up to two) for further refining generated outfits.

- **Manage Outfits**:
  - Users can save frequently worn or generated outfits for future use.
  - Saved outfits can be applied to a specific day or event on a calendar.

## 4. Constraints
- Creating an intuitive interface to easily classify clothing items by material, color, pattern, and other attributes.
- Ensuring that generated outfits consider multiple criteria (e.g., weather, occasion).
- Addressing potential user errors when categorizing clothing items.

## 5. Stakeholder Goals Summary

- **User**:
  - Wants to upload photos of clothing, categorizing them by type, material, pattern, and color.
  - Desires to generate and save outfits easily based on wardrobe and preferences.
  - Prefers to filter the closet efficiently, generate customized or random outfits, and save preferred combinations for future reference.

- **System's Role**:
  - Validates user preferences to offer a personalized experience.
  - Generates outfits based on user input and saved preferences, provides closet filtering options, and saves items in "Saved Outfits."
  - Manages complex decision-making processes for a seamless, responsive user experience.

## Use Case Diagram

```plantuml
skin rose

' human actors
actor "User" as user

' external system actor
actor "Weather API" <<system>> as weatherAPI

' list all use cases in hierarchical structure within the app package
package OutfitGeneratorApp {
    usecase "View Outfits" as viewOutfits
    usecase "Manage Preferences" as managePreferences
    usecase "Manage Closet" as manageCloset
    usecase "Generate Outfit" as generateOutfit
    usecase "Manage Outfits" as manageOutfits

    ' Sub-use cases organized to show hierarchical relationships
    package ClosetOperations {
        usecase "Add Clothing" as addClothing
        usecase "Delete Clothing" as deleteClothing
        usecase "Edit Clothing" as editClothing
        usecase "Filter Closet" as filterClothing
    }

    package OutfitOperations {
        usecase "Save Outfit" as saveOutfit
        usecase "Edit Outfit" as editOutfit
        usecase "Delete Outfit" as deleteOutfit
        usecase "Apply Outfit to Event" as applyOutfit
    }

    package PreferencesOperations {
        usecase "Edit Preferences" as editPreferences
    }
}

' Define hierarchical relationships
viewOutfits --> managePreferences
viewOutfits --> manageCloset
viewOutfits --> generateOutfit
viewOutfits --> manageOutfits

manageCloset --> addClothing
manageCloset --> deleteClothing
manageCloset --> editClothing
manageCloset --> filterClothing

generateOutfit --> applyOutfit
managePreferences --> editPreferences
manageOutfits --> saveOutfit
manageOutfits --> deleteOutfit
manageOutfits --> editOutfit

weatherAPI --> generateOutfit : <<uses>>

