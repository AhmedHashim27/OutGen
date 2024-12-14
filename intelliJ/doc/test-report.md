# Test Report
## Overall System
Run Main.main()
Starts by parsing all items from the CSV and di splays them. Shows the Closet System Menu.
Must enter a number from 1-4 or else the system displays an error message and asks you to try again.
![Screen Shot 2024-11-01 at 2.25.00 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%202.25.00%20PM.png)
## 1. Manage Closet
Enter 1 to go to Manage items in closet.
Enter a number from 1-4 to add, delete, edit or filter, respectively.
- Entering 0 or 5 will result in the system displaying "Invalid option! Please enter a number from 1-4."
- Entering a string will result in the system displaying "Invalid option! Please enter a number."
In both cases you are expected to enter another input, which is then checked for validity.
- 
  ![Screen Shot 2024-11-01 at 7.31.45 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%207.31.45%20PM.png)
- 
1. Add an item to closet:
For each description: PartOfBody, SubType, Texture, Color, Pattern are asked.
For each category, can only enter 1- max number in that enumerated class. Can only enter a number.

![Screen Shot 2024-11-01 at 7.34.51 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%207.34.51%20PM.png)
 ![Screen Shot 2024-11-01 at 7.35.08 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%207.35.08%20PM.png)
![Screen Shot 2024-11-01 at 7.35.19 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%207.35.19%20PM.png)
![Screen Shot 2024-11-01 at 7.35.35 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%207.35.35%20PM.png)
![Screen Shot 2024-11-01 at 7.35.48 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%207.35.48%20PM.png)
Item successfully added and closet displayed.

2. Delete an item from closet:
Hit 2 to delete an item from closet.
Must enter a number from 1- max number of items in closet. Must be a number.

![deleteC2.png](screenshots/deleteC2.png)
![deleteC.png](screenshots/deleteC.png)
![deleteC3.png](screenshots/deleteC3.png)
Prints item removed and displays updated closet without removed item.

3. Edit an item in closet:
Press 3 to edit items in closet.
Displays each item in closet.
Must enter a number from 1- max number of items in closet. Must be a number.
For each description: PartOfBody, SubType, Texture, Color, Pattern are asked.
For each category, can only enter 1- max number in that enumerated class. Can only enter a number.

![edit_1.png](screenshots/edit_1.png)
![edit_choice.png](screenshots/edit_choice.png)
![edit_3.png](screenshots/edit_3.png)
![edit_6.png](screenshots/edit_6.png)
![edit.png](screenshots/edit.png)
![edit_last.png](screenshots/edit_last.png)
Displays full closet with edited item.
Displays the item edited.

4. Filter closet:
Displays what you can filter closet by: part of body, subtype, texture, pattern, color.
For each filter, can only enter a number from 1- max number of enumerated types inside that enumerated class.
Can only enter a number.

![Screen Shot 2024-11-01 at 8.40.04 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.40.04%20PM.png)
Filter by part of body:
![Screen Shot 2024-11-01 at 8.40.18 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.40.18%20PM.png)
Filter by subtype:
![Screen Shot 2024-11-01 at 8.40.42 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.40.42%20PM.png)
![Screen Shot 2024-11-01 at 8.40.53 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.40.53%20PM.png)
Filter by texture:
![Screen Shot 2024-11-01 at 8.41.19 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.41.19%20PM.png)
![Screen Shot 2024-11-01 at 8.41.47 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.41.47%20PM.png)
Filter by pattern:
![Screen Shot 2024-11-01 at 8.42.37 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.42.37%20PM.png)
![Screen Shot 2024-11-01 at 8.42.54 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.42.54%20PM.png)
Filter by color:
![Screen Shot 2024-11-01 at 8.43.18 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.43.18%20PM.png)
![Screen Shot 2024-11-01 at 8.43.28 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%208.43.28%20PM.png)

## 2. View Closet
Enter 2 to go to View Closet.
![Screen Shot 2024-11-01 at 9.27.59 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%209.27.59%20PM.png)
![Screen Shot 2024-11-01 at 9.28.14 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%209.28.14%20PM.png)
System displays all elements in closet parsed from CSV file.

## 3. Generate Outfit
Enter 3 to go to Generate Outfit.
System displays "Current weather in New York:".
System displays temperature and condition based on Weather API.
System asks if user would like to add an accessory.
User must enter string(any case) that is either "yes" or "no." If user enters a number, no accessory is added.

![Screen Shot 2024-11-01 at 9.29.08 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%209.29.08%20PM.png)
![Screen Shot 2024-11-01 at 9.29.27 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%209.29.27%20PM.png)
![Screen Shot 2024-11-01 at 9.29.55 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%209.29.55%20PM.png)
System displays generated outfit with textures, subtypes based on temperature, texture based on condition, and color matches.

## 4. Exit
Enter 4 to go to Exit (placeholder for next iteration's use case).
![Screen Shot 2024-11-01 at 9.36.32 PM.png](screenshots/Screen%20Shot%202024-11-01%20at%209.36.32%20PM.png)
System prints "Exiting..."
