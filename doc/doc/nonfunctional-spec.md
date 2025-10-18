# Non-Functional Specs

## Functional
- Must save user preferences and login information.
- Must save photos and related data for each clothing item.
- Must generate outfits based on user inputs and preferences.
- Must allow users to save/favorite previous outfits for future use.

## Usability
- The login page appears as soon as the app is opened.
- The user interface should be simple and intuitive, with clear navigation for generating outfits and managing the closet.
- Support accessibility features like screen readers and larger text options.

## Performance
- Outfit generation and wardrobe filtering should be completed in less than 3 seconds.
- The system should handle up to 100,000 users concurrently.
- Each user should be able to store up to 500 wardrobe items without performance issues.

## Supportability
- Error messages should be user-friendly, and issues should be logged for troubleshooting.
- The system should be modular, allowing easy maintenance and future updates.
- Regular backups must be performed to avoid data loss.

## Implementation
- **Frontend**: Built using React for a responsive and dynamic user experience.
- **Backend**: Java for server-side operations and scalability.
- **Database**: MongoDB for storing user wardrobe, preferences, and saved outfits.
- Use of a Weather API for real-time weather-based outfit suggestions.

## Interface
- Integrates with a Weather API to provide personalized outfit recommendations.
- Uses an image processing service to remove backgrounds from clothing photos.
- Database integration to save and retrieve user wardrobe and preferences.

## Legal
- The app must comply with data privacy regulations.
- User data, including images, must be stored securely, and users must be able to delete their data at any time.
- A privacy policy must outline how user data is collected, stored, and used.

