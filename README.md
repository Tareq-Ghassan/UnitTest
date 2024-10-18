
# Art Book App

**Art Book** is a simple Android application built with Jetpack Compose, using Dependency Injection for managing dependencies and Realm Database for persistent storage. The app allows users to add artworks by providing an image, name, artist's name, and year. It is designed primarily as a project to practice unit testing.

## Features

- **Add New Art**: Users can add new artworks with the following details:
  - Image: Select an image from an API search.
  - Name: Text field input for the artwork's name.
  - Artist Name: Text field input for the artist's name.
  - Year: Text field input for the year the artwork was created.
  
- **Image Selection**: When adding an art, users can search for an image using an API. Once an image is selected, it will be displayed on the form. 

- **Save Art**: After filling in the required fields (image, name, artist, year), users can save the artwork. This information is stored locally on the device using **Realm Database**.

- **View Saved Artworks**: The main screen displays a list of all saved artworks retrieved from the local Realm DB.

- **Delete Artwork**: Users can delete any saved artwork directly from the main screen.

## Technology Stack

- **Jetpack Compose**: For building a modern, declarative UI.
- **Dependency Injection**: Using Dagger Hilt for managing dependencies across the app.
- **Realm Database**: For storing the user's added artworks locally on the phone.
- **Retrofit**: For handling API calls to fetch images for the user to choose from.

## Architecture

The app follows the **MVVM (Model-View-ViewModel)** architecture pattern for better separation of concerns and testability.

- **View**: Jetpack Compose UI.
- **ViewModel**: Holds and manages the UI-related data and logic.
- **Model**: The Realm DB entities representing saved artworks.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Tareq-Ghassan/UnitTest.git
   ```

2. Open the project in Android Studio.

3. Run the app on an emulator or physical device.

## How to Use

1. On the main screen, click the "Add Art" button to create a new artwork.
2. Fill in the name, artist's name, and year in the text fields.
3. Click the image field to search for an image via the API. After selecting an image, it will be displayed.
4. Click the "Save" button to save the artwork to the Realm database.
5. The saved artwork will now appear on the main screen.
6. To delete an artwork, simply click the delete button next to it.

## Testing

This app is focused on practicing unit testing. The core logic for saving, deleting, and fetching artworks from the database has been covered with unit tests.

- **Unit Tests**: Test the ViewModel logic and ensure proper interactions with the database and API.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
