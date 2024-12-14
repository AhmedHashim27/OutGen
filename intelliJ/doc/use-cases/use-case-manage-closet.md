
# Manage Closet

## 1. Primary actor and goals

__User__: wants to upload their clothes to their closet, so they can be used to generate an outfit. Wants to organize clothes by Tops, Bottoms, Shoes and Accessories. Wants to filter My Model.Closet based on filters like texture, pattern, color, and type of clothing.


## 2. Other stakeholders and their goals

* __System__: Wants to display uploaded photos of clothes without backgrounds. Wants to use input data to filter clothes based on applied filters. Wants to sort clothes based on the subsections they're classified in.
* __Database__: Wants to store photos uploaded. Wants to store information about each photo (ie: type of clothing, subsection of clothing, texture, pattern, and color).


## 2. Preconditions

* User has logged in with correct username and password.
* User profile with optional user preferences is created.
* User has a working camera and has given the app access to use the camera and photos.
  
## 4. Post-conditions

* Photos are saved without backgrounds(sticker cut-outs).
* Filtered closet can be generated.
* Database has clothes saved based on different inputs.
* My Closet is split into four sections: Tops, Bottoms, Shoes, and Accessories.


## 4. Workflow

```plantuml
@startuml

skin rose

title Manage Model.Closet (casual level)

'define the lanes
|#application|User|
|#implementation|System|
|#technology|Database|

|System|
start

:Display User's Model.Closet;
    
    |User|
    while (Manage Model.Closet) is (continue)
        if (Filter clothing) then (yes)
            :Choose descriptions: Part of Body, Clothing Subtype, Texture, Pattern, Color, Season;
            |Database|
            :Retrieve clothing based on filters;
            |System|
            :Displays clothing based on filters;
    
        else if (Add clothing) then (yes)
            |User|
            :Upload photo;
            |System|
            :Remove background;
            |Database|
            :Store photo cutout;
            |User|
            while (Apply descriptions) is (not applied)
            :Select descriptons: Part of Body, Clothing Subtype, Color, Pattern, Texture, Season;
            if (Submit clothing) then (cancel)
            |System|
            :Clothing not added;
            |User|
            else (done) 
            |System|
            :Clothing added;
            |Database|
            :Stores information;
            |User|
            endif
            end while (applied)
        else if (Remove Clothing) then (yes)
            |User|
            :Select clothing;
            |System|
            if (Confirmation) then (yes)
            |Database|
            :Delete from memory;
            |System|
            :Display "item deleted";
            :Display Model.Closet without item;
            else (no)
            endif
        else if (Edit clothing) then (yes)
            |User|
            :Select item to edit;
            |System|
            :Show description questions;
            |User|
            :Apply descriptions;
            |Database|
            :Update information;
        else (no)
        endif
        end while(exit)
        |System|
        :Display all items in my clothing;
stop
@enduml
```
## Sequence Diagram: 
### Add Clothing
```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":Controller.Controller" as controller
participant "myC:Clothing" as clothing
participant ":Model.Closet" as closet

user <- ui : Displays Manage Model.Closet
user -> ui : Clicks "Add clothing"
user <- ui : Asks for descriptions
user -> ui : Choose part of body, subtype, color, texture, pattern, season
ui -> controller: partOfBody(str), subType(str), Color(str), Texture(str), Pattern(str), Season(str)

controller -> closet : myC = create(part_of_body, subtype, color, texture, pattern, season)
closet -> closet : addClothing(myC)
controller -> ui : updateClosetDisplay(Model.Closet)
ui -> user : Displays updated closet

@enduml
```

### Delete Clothing

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":Controller.Controller" as controller
participant "myC:Clothing" as clothing
participant ":Model.Closet" as closet

user <- ui : Displays Manage Model.Closet
user -> ui : Clicks "Delete clothing"
ui -> user : Asks to select clothing to delete
user -> ui : Selects clothing item
controller -> ui : confirmation(str)
ui -> user: Asks to confirm: "Clothing cannot be retrieved once deleted"
alt yes
controller -> closet : deleteClothing(myC)
else no

user <- ui : Displays "Not deleted" message
end

controller -> ui : updateClosetDisplay(Model.Closet)

ui -> user : Displays updated closet

@enduml
```

### Edit Clothing

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":Controller.Controller" as controller
participant "myC:Clothing" as clothing
participant ":Model.Closet" as closet
user <- ui : Displays Manage Model.Closet
user -> ui : Clicks "Edit clothing"
ui -> user : Asks to select clothing to edit
user -> ui : Selects clothing item
user <- ui : Asks what to edit
user -> ui : Changes part of body, subtype, color, texture, pattern, and/or season
ui -> controller: texture(str), partOfBody(str), subType(str), color(str), texture(str), pattern(str) season(str)
controller -> closet : edit(part_of_body, subtype, color, texture, pattern, season)
closet -> closet : updateClothing(myC)
controller -> ui : updateClosetDisplay(Model.Closet)
ui -> user : Displays updated closet

@enduml
```

### Filter Clothing

```plantuml
@startuml
hide footbox
actor User as user
participant ":UI" as ui
participant ":Controller.Controller" as controller

participant "myC:Clothing" as clothing
participant ":Model.Closet" as closet
user <- ui : Displays Manage Model.Closet
user -> ui : Clicks "Filter clothing"
user <- ui : Choose filters to apply
user -> ui : Chooses part of body, subtype, color, texture, pattern, and/or season
ui -> controller: texture(str), partOfBody(str), subType(str), Color(str), Texture(str), Pattern(str), Season(str)
controller -> closet : find(part_of_body, subtype, color, texture, pattern, season)
closet -> closet : filterClothing(myC)
controller -> ui : updateClosetDisplay(Model.Closet)
ui -> user : Displays updated closet

@enduml
```