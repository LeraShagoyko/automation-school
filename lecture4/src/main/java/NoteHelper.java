import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NoteHelper extends ParentHelper {

    private String content;
    private String secretKey;


    public NoteHelper(String secretKey) {
        this.content = "content" + System.currentTimeMillis();
        this.secretKey = secretKey;
    }

    public Note addNote() {
        NoteContent newContent = new NoteContent(this.content);
        Note note = null;
        try {
            String request = mapper.writeValueAsString(newContent);
            HttpPost httpPost = new HttpPost("https://taschool-notes-service.herokuapp.com//v1/notes");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("authorization", this.secretKey);
            StringEntity entity = new StringEntity(request);
            httpPost.setEntity(entity);
            CloseableHttpResponse response = this.client.execute(httpPost);
            HttpEntity entity2 = response.getEntity();
            String responceWithJsonOfNewNote = EntityUtils.toString(entity2, "UTF-8");
            note = this.mapper.readValue(responceWithJsonOfNewNote, Note.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return note;
    }

    public List<Note> getAllNotes() {
        HttpGet httpGet = new HttpGet("https://taschool-notes-service.herokuapp.com//v1/notes");
        httpGet.setHeader("authorization", this.secretKey);
        CloseableHttpClient client = HttpClients.createDefault();
        List<Note> notes = new ArrayList<>();
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            notes = this.mapper.readValue(responseString, new TypeReference<List<Note>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notes;
    }


    public Note getNote(int noteId) {
        HttpGet httpGet = new HttpGet("https://taschool-notes-service.herokuapp.com//v1/notes/" + noteId);
        httpGet.setHeader("authorization", this.secretKey);
        CloseableHttpClient client = HttpClients.createDefault();
        Note returnedNote = null;
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            returnedNote = this.mapper.readValue(responseString, Note.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnedNote;
    }

    public Note updateNote(int noteId, NoteContent noteContent) {
        Note note = null;
        try {
            String request = mapper.writeValueAsString(noteContent);
            HttpPut httpPut = new HttpPut("https://taschool-notes-service.herokuapp.com/v1/notes/" + noteId);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            httpPut.setHeader("authorization", this.secretKey);
            StringEntity entity = new StringEntity(request);
            httpPut.setEntity(entity);
            CloseableHttpResponse response = this.client.execute(httpPut);
            HttpEntity entity2 = response.getEntity();
            String responseString = EntityUtils.toString(entity2, "UTF-8");
            note = this.mapper.readValue(responseString, Note.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return note;
    }

    public boolean deleteNote(int noteId) {
        HttpDelete httpDelete = new HttpDelete("https://taschool-notes-service.herokuapp.com//v1/notes/" + noteId);
        httpDelete.setHeader("authorization", this.secretKey);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            client.execute(httpDelete);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
