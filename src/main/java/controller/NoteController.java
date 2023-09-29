package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.Notebook;
import javafx.scene.input.MouseEvent;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private ListView<String> noteListView; // For using ListView

    private final Notebook notebook = new Notebook();
    private boolean isUpdateMode = false; // Flag to track whether we are in "Update" mode

    @FXML
    private void initialize() {
        // For using ListView
        updateNoteList();
    }

    @FXML
    private void handleAddButtonAction(ActionEvent event) {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            if (isUpdateMode) {
                // Update an existing note
                int selectedIndex = noteListView.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    Note updatedNote = new Note();
                    updatedNote.setTitle(title);
                    updatedNote.setContent(content);
                    notebook.editNoteAt(selectedIndex, updatedNote);
                    isUpdateMode = false; // Exit "Update" mode
                    addButton.setText("Add"); // Switch back to "Add" mode
                }
            } else {
                // Add a new note
                Note note = new Note();
                note.setTitle(title);
                note.setContent(content);

                notebook.addNote(note);
            }

            // Clear the input fields
            titleField.clear();
            contentArea.clear();
            updateNoteList(); // Update the note list (if using ListView)
        }
    }

    @FXML
    private void handleNoteSelection(MouseEvent event) {
        if (event.getClickCount() == 2) {
            // Double-clicked on a note, allow editing
            int selectedIndex = noteListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                // Get the selected note from the list
                Note selectedNote = notebook.getNotes().get(selectedIndex);

                // Populate the input fields with the selected note's data
                titleField.setText(selectedNote.getTitle());
                contentArea.setText(selectedNote.getContent());

                // Switch to "Update" mode
                isUpdateMode = true;
                addButton.setText("Edit");
            }
        }
    }

    // Update the note list (if using ListView)
    private void updateNoteList() {
        noteListView.getItems().clear();
        for (Note note : notebook.getNotes()) {
            noteListView.getItems().add(note.getTitle());
        }
    }
}
