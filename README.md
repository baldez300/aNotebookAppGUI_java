# Notebook Application

## Overview
This JavaFX-based notebook application allows users to take notes with a simple graphical user interface (GUI). Users can add notes with a title and content, view them, and edit existing notes. The application follows the MVC (Model-View-Controller) design pattern.

## Features
- **TextArea**: Write your notes.
- **TextField**: Enter the title of the note.
- **Add Button**: Save the note when clicked.
- **ListView**: Display the saved notes.
- **Edit and Delete**: Double-click a note to edit or delete it.

## Requirements
- Java Development Kit (JDK) 17 or later
- JavaFX SDK
- SceneBuilder for designing the GUI

## Project Structure
- **model**: Contains the `Note` and `Notebook` classes.
- **controller**: Contains the `NoteController` class which handles user interactions.
- **view**: Contains the `NoteApp` class to launch the application and `Main` class with the main method.
- **resources**: Contains the `note.fxml` for the layout and `style.css` for styling.

## Model Classes

### Note
Represents a single note with a title and content.

```java
package model;

public class Note {
    private String title;
    private String content;

    public Note() {
        this.title = "";
        this.content = "";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
```

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/baldez300/aNotebookAppGUI_java.git


cd aNotebookAppGUI_java
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

