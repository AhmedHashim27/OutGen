# Manage Outfits

## 1. Primary Actor and Goals

- **User**: Wants to manage outfits saved locally in CSV format, with options to view, edit, delete, or use a saved outfit to generate a similar one. Users may also apply an outfit directly for a specific occasion or event.

## 2. Other Stakeholders and Their Goals

- **System**:
    - Stores and displays saved outfits accurately using CSV for local storage.
    - Supports modifications, including editing items within an outfit.
- **Local Database (CSV)**:
    - Stores saved outfits in CSV format.
    - Provides retrieval of saved outfits for user actions.

## 3. Preconditions

- User has successfully logged in.
- User has previously saved outfits to the local CSV storage.

## 4. Post-conditions

- Users can view, edit, delete, or generate similar outfits based on saved outfits.
- Any updates (additions, removals, modifications) are saved to the CSV file for persistent storage.

## 5. Workflow

### Brief: Main Success Scenario

1. **Access Saved Outfits**: The user navigates to the "Saved Outfits" section.
2. **View Saved Outfits**: The system retrieves and displays a list of saved outfits.
3. **User Options**:
    - **View Outfit Details**: Allows the user to view individual outfit details (items, colors, patterns).
    - **Apply Outfit**: (Future feature) Users can plan to apply outfits for an occasion.
    - **Edit Outfit**: Users modify an outfit by adding, removing, or swapping items, leveraging the existing **Generate Outfit** logic for compatibility.
    - **Delete Outfit**: Users can delete an outfit from the saved list.
    - **Generate Similar Outfit**: Generates a similar outfit based on the selected one.
4. **Loop for Continuous Management**: Users can continue to manage outfits until they exit.

### Casual Level: Most Common Scenarios and Variations

```plantuml
@startuml

skin rose

title Manage Outfits (casual level)

' Define the lanes
|#application|User|
|#implementation|System|
|#technology|Local Database (CSV)|

|User|
start
:Accesses "Saved Outfits" section;

|System|
:Retrieves list of saved outfits from CSV;
:Displays list to the user;

|User|
repeat
    if (Selects an outfit?) then (Yes)
        :View Outfit Details;
        |System|
        :Displays outfit details (items, colors, patterns);

        |User|
        if (Apply outfit for occasion?) then (Yes)
            :Selects an occasion;
            |System|
            :Marks outfit for that occasion;
        else (No)
            if (Edit outfit?) then (Yes)
                :Choose to add, remove, or swap items;
                |System|
                :Delegates to Generate Outfit for compatibility;
                :Updates the outfit;
                |Local Database (CSV)|
                :Stores updated outfit;
            else (No)
                if (Delete outfit?) then (Yes)
                    :Confirms deletion;
                    |System|
                    :Removes outfit from saved list;
                    |Local Database (CSV)|
                    :Deletes outfit data;
                else (No)
                    if (Generate similar outfit?) then (Yes)
                        |System|
                        :Delegates to Generate Outfit for similar suggestions;
                        :Displays generated similar outfit;
                    endif
                endif
            endif
        endif
    else (No)
        :Returns to main menu;
    endif
repeat while (User continues managing outfits)

stop

@enduml

