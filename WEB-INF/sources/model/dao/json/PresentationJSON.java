package model.dao.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.html.HTMLElement;
import model.dto.project.Presentation;

public class PresentationJSON implements HTMLElement {
    
    private static final String DEAULT_FILE_PATH = "Accueil.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private List<Presentation> presentations;

    public PresentationJSON() {
        this(DEAULT_FILE_PATH);
    }

    public PresentationJSON(String filePath) {
        try (InputStream inputStream = PresentationJSON.class.getClassLoader().getResourceAsStream(filePath)) {
            Presentation[] presentationArray = mapper.readValue(inputStream, Presentation[].class);
            this.presentations = Arrays.asList(presentationArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Presentation> findAll() {
        return this.presentations;
    }

    @Override
    public String toHTML() {
        StringBuilder st = new StringBuilder();
        for (Presentation presentation : presentations) {
            st.append(presentation.toHTML());
        }
        return st.toString();
    }
}
