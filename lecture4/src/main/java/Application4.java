import java.util.List;

public class Application4 {
    public static void main(String[] args) {
        LoginHelper registrateHelper = new LoginHelper();
        registrateHelper.registrate();

        String secretKey = registrateHelper.login();

        NoteHelper apiHelper = new NoteHelper(secretKey);

        Note returnedNewNote = apiHelper.addNote();
        System.out.println(returnedNewNote);

        Note updatedNote = apiHelper.updateNote(returnedNewNote.id, new NoteContent("Note was updated"));
        System.out.println(updatedNote);

        apiHelper.addNote();
        apiHelper.addNote();

        List<Note> returnedNotes = apiHelper.getAllNotes();
        System.out.println(returnedNotes);

        Note returnedNoteById = apiHelper.getNote(returnedNewNote.id);
        System.out.println(returnedNoteById);

        apiHelper.deleteNote(returnedNotes.get(returnedNotes.size() - 1).id);

        returnedNotes = apiHelper.getAllNotes();
        System.out.println(returnedNotes);
    }
}
