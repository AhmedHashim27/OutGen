# Generate Outfit

## 1. Primary Actor and Goals
- **User**: Wants to receive a tailored outfit suggestion based on weather conditions, pattern compatibility, texture, and color matching. The user is provided with a completed outfit, with the option to add accessories for a personalized touch.

## 2. Other Stakeholders and Their Goals
- **System**:
    - Provides outfit suggestions by matching closet items based on weather conditions, texture, pattern, and color compatibility.
    - Supports the option to include an accessory in the final outfit for personalization.

## 3. Preconditions
- The user’s virtual closet is set up with categorized clothing items (e.g., Tops, Bottoms, Shoes, Accessories).
- An internet connection is available to fetch weather data if required.

## 4. Post-conditions
- An outfit is generated and displayed to the user.
- The user can choose to add accessories but cannot save the generated outfit (planned as a future feature).

## 5. Workflow

### Main Success Scenario
1. **Click "Generate Outfit" Button**: The user initiates the outfit generation process by clicking the button.
2. **Retrieve Weather Data**: If needed, the system fetches the current weather data.
3. **Filter and Select Upper Item**: The system filters upper items based on weather and randomly selects one.
4. **Match Lower Item**: The system filters lower items, ensuring at most one pattern is present between the upper and lower items, and then matches by texture and color.
5. **Select Feet Item**: The system filters footwear to match both upper and lower selections and the weather condition.
6. **Optional Accessory**: The user is prompted to add an accessory if desired.
7. **Display Outfit**: The system displays the generated outfit to the user, without saving capabilities.

### UML Class Diagram

```plantuml
@startuml

skin rose

title Generate Outfit (casual level)

' define the lanes
|#application|User|
|#implementation|System|
|#technology|Weather API|

|User|
start

:Clicks "Generate Outfit";

|System|
:Retrieve user preferences (style, colors, exclusions);
|Weather API|
:Fetch current weather data;
|System|
:Analyze context (preferences, weather, occasion);

|System|
:Filter Upper items;
:Select random upper item;

|System|
:Filter Lower items;
:Match pattern and texture with upper;
:Select lower item compatible with upper;

|System|
:Filter Feet items;
:Match texture with upper and lower items;
:Select feet item compatible with upper and lower;

|User|
if (Add Accessory?) then (yes)
    :Chooses accessory option;
    |System|
    :Fetch accessory items;
    :Adds selected accessory;
else (no)
endif

|System|
:Display completed outfit;

stop

@enduml
```
## Sequence Diagrams

## 1. Main Outfit Generation

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":WeatherService" as weather
<<<<<<< HEAD
participant ":Closet" as closet

=======
participant ":Model.Closet" as closet
participant ":Database" as db

user <- ui : Displays "Generate Outfit" screen
user -> ui : Clicks "Generate Outfit" button
ui -> user : Asks for occasion or special conditions
user -> ui : Provides occasion (e.g., work, casual, formal)
ui -> outfitGen : Send user preferences and occasion
outfitGen -> db : Fetch user preferences (style, exclusions, colors)
db --> outfitGen : Return preferences
outfitGen -> weather : Fetch current weather data
weather --> outfitGen : Return weather data
outfitGen -> closet : Fetch available clothing items from closet
closet -> db : Retrieve clothing items based on preferences
db --> closet : Return available clothing items
closet --> outfitGen : Send filtered clothing items

outfitGen -> outfitGen : Analyze context (preferences, weather, occasion, items)
outfitGen -> ui : Generate and display outfit (top, bottom, shoes)

user <- ui : Displays generated outfit with options to customize
user -> ui : Decides to customize (optional)
alt User customizes
    ui -> user : Asks to choose item to change (e.g., top, bottom)
    user -> ui : Selects a new item from closet
    ui -> outfitGen : Send user selection
    outfitGen -> outfitGen : Replace item in outfit
    outfitGen -> ui : Display updated outfit
end

user -> ui : Accepts outfit
ui -> outfitGen : Notify outfit finalized
@enduml


```

### Customize Outfit

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":Model.Closet" as closet
participant ":Database" as db

user <- ui : Displays generated outfit
user -> ui : Clicks "Customize Outfit"
ui -> user : Asks which item to change (e.g., top, bottom, shoes)
user -> ui : Selects item to change (e.g., top)
ui -> closet : Fetch available alternatives for selected type (e.g., tops)
closet -> db : Retrieve clothing items (tops) based on user preferences
db --> closet : Return filtered tops
closet --> outfitGen : Send available items
outfitGen -> ui : Display alternative items to user
user -> ui : Selects new top from alternatives
ui -> outfitGen : Apply customization (replace top)
outfitGen -> outfitGen : Replace top in outfit
outfitGen -> ui : Display updated outfit to user
@enduml


```

###  Saved Outfit

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":Database" as db

user <- ui : Displays finalized outfit
user -> ui : Clicks "Save Outfit"
ui -> outfitGen : Request to save outfit
outfitGen -> db : Save outfit to database (includes items and user preferences)
db --> outfitGen : Confirm save operation
outfitGen -> ui : Notify user (outfit saved successfully)
@enduml


```

### Suggest New Item

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":Model.Closet" as closet
participant ":Database" as db

user <- ui : Displays generated outfit
user -> ui : Clicks "Suggest New Item"
ui -> outfitGen : Request new item suggestion for specific type (e.g., top)
outfitGen -> closet : Fetch available clothing items (based on type, user preferences)
closet -> db : Retrieve clothing items based on type (e.g., tops)
db --> closet : Return available items
closet --> outfitGen : Send available tops to suggest
outfitGen -> outfitGen : Suggest new item (select from alternatives)
outfitGen -> ui : Display suggested item to user
user -> ui : Accepts or rejects suggestion
alt User accepts suggestion
    ui -> outfitGen : Apply suggested item to outfit
    outfitGen -> outfitGen : Update outfit with suggested item
    outfitGen -> ui : Display updated outfit
else User rejects suggestion
    ui -> outfitGen : Request another suggestion
    outfitGen -> outfitGen : Suggest another item
    outfitGen -> ui : Display new suggestion
end
@enduml


```

### Retrieve Saved Outfits

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":Database" as db

user <- ui : Displays saved outfits screen
user -> ui : Clicks "View Saved Outfits"
ui -> outfitGen : Request to fetch saved outfits
outfitGen -> db : Fetch saved outfits for user
db --> outfitGen : Return saved outfits
outfitGen -> ui : Display saved outfits to user
user <- ui : Shows saved outfits (with option to view, edit, or delete)
@enduml


```

### Fetch Weather

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":WeatherService" as weather

user <- ui : Displays generate outfit screen
>>>>>>> refs/remotes/origin/main
user -> ui : Clicks "Generate Outfit"
ui -> weather : Fetch weather data
weather --> ui : Return weather data
ui -> outfitGen : Request outfit generation with weather data
outfitGen -> closet : Retrieve upper items
outfitGen -> outfitGen : Filter by weather, select random upper item
outfitGen -> closet : Retrieve lower items
outfitGen -> outfitGen : Filter by pattern and texture, match with upper
outfitGen -> closet : Retrieve feet items
outfitGen -> outfitGen : Filter by weather, match with upper and lower
outfitGen -> user : Prompt user to add accessory (optional)
alt User adds accessory
    user -> outfitGen : Select accessory
    outfitGen -> closet : Retrieve accessory items
    outfitGen -> outfitGen : Add accessory to outfit
end
outfitGen -> ui : Display completed outfit
@enduml

```
## 2. Accessory Selection (Optional)

```plantuml
@startuml
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":Closet" as closet

user -> ui : Prompts to add accessory
ui -> user : Asks if user wants to add an accessory
alt User wants accessory
    user -> ui : Selects "Yes"
    ui -> outfitGen : Accessory selection process
    outfitGen -> closet : Retrieve suitable accessories
    closet --> outfitGen : Return accessory items
    outfitGen -> ui : Display accessory options
    user -> ui : Selects accessory
    outfitGen -> ui : Adds accessory to outfit
else User skips accessory
    user -> ui : Selects "No"
    ui -> outfitGen : Proceed without accessory
end
outfitGen -> user : Displays completed outfit
@enduml
```

## 3. Weather-Based Outfit Generation for a Future Day

```plantuml
@startuml
actor User as user
participant ":UI" as ui
participant ":OutfitGenerator" as outfitGen
participant ":WeatherService" as weather

user -> ui : Clicks "Generate Outfit"
ui -> user : Prompts for weather condition
user -> ui : Enters desired weather condition (e.g., sunny and warm)
ui -> outfitGen : Sends weather condition
outfitGen -> outfitGen : Initiate outfit creation based on user input
outfitGen -> weather : (Optional) Fetch updated weather data
weather --> outfitGen : Return data if applicable
outfitGen -> outfitGen : Filter items based on condition
outfitGen -> user : Generate and display outfit suggestion
@enduml

