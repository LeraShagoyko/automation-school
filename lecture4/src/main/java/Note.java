public class Note {
    public int id;
    public String content;
    public String createdAt;
    public String modifiedAt;
    public int version;

    public String toString() { //return string for print
        return "Note " + this.id + " content " + this.content;
    }
}
