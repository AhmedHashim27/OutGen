## Manage Model.Closet Class Diagram

```plantuml
@startuml

hide empty methods
' classes
class User{
    +name: String
}
class Model.Closet{
    + myC: Clothing
    +addClothing(myC: Clothing)
    +deleteClothing(myC: Clothing)
    +updateClothing(myC: Clothing)
    +filterClothing(myC: Clothing)
    +create(part_of_body, subtype, color, texture, pattern, season)
    +delete(part_of_body, subtype, color, texture, pattern, season)
    +edit(part_of_body, subtype, color, texture, pattern, season)
    +find(part_of_body, subtype, color, texture, pattern, season)
}
class Controller.Controller{
    +updateSystemDisplay(Model.Closet): void
}
class Clothing{
    +name : String
    +partOfBody(String):
    +subType(String)
    +color(String)
    +pattern(String)
    +texture(String)
    +season(String)
}
class Main{
    + {static} main(String[args]): void
}
enum EColor{
    +Black
    +White
    +Multicolored
    +Red
    +Orange
    +Yellow
    +Green
    +Blue
    +Purple
    +Pink
    +Brown
    +Grey
}
enum ETexture{
    + Leather
    + Denim
    + Cotton
    + Wool
    + Fur
    + Velvet
    + Lace 
}
enum EPattern{
    + Swirls
    + Polka Dots
    + Stripes
    + Florals
    + Plaid
    + Logo
    + Animal Print
    + Abstract
}
enum ESeason{
    + Winter
    + Summer
    + Spring
    + Fall
}
enum EpartOfBody{
    +Upper
    +Lower
    +Feet
    +Other
}
class subType{
    +partOfBody(String)
}
enum EUpper{
    +Jacket
    +T-shirt
    +Long sleeve
    +Cropped
    +Button-Up
    +Dress
}
enum ELower{
    +Pants
    +Shorts
    +Skirt
    +Overalls
}
enum EFeet{
    +Boots
    +Sneakers
    +Slippers
    +Heels
    +Loafers
    +Flats
}
enum EOther{
    +Bag
    +Hat
    +Glasses
    +Jewelry
}


' associations 
Clothing "1" -down- "0..*" EColor : \tcontains\t\t
Clothing "1" -down- "0..*" EPattern : \tcontains\t\t
Clothing "1" -down- "0..*" ETexture : \tcontains\t\t
Clothing "1" -right- "0..*" ESeason : \tcontains\t\t
Clothing "1" -up- "0..*" subType : \tcontained by\t\t
Clothing "1" -up- "0..*" EpartOfBody : \tcontained by\t\t
User "1" -down- "0..*" Model.Closet : \tcontributes to\t\t
Model.Closet "0..*" -down- "1" Controller.Controller : \tutilized by\t\t
Model.Closet "1" -right- "0..*" Clothing : \tuses\t\t
subType "1" -left- "0..*" EpartOfBody : \tdescribed by\t\t
subType "1" -up- "0..*" EUpper : \tdescribed by\t\t
subType "1" -up- "0..*" ELower : \tdescribed by\t\t
subType "1" -right- "0..*" EOther : \tdescribed by\t\t
subType "1" -up- "0..*" EFeet : \tdescribed by\t\t
Main "1" -right- "0..*" Model.Closet : \tuses\t\t
@enduml

