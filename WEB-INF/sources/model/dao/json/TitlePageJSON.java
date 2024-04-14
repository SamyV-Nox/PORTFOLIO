package model.dao.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.html.HTMLElement;
import model.dto.root.TitlePage;

public class TitlePageJSON implements HTMLElement {

    private static final String DEAULT_FILE_PATH = "Title.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private Map<String, TitlePage> titlePages;


    public TitlePageJSON() {
        this(DEAULT_FILE_PATH);
    }

    public TitlePageJSON(String filePath) {
        this.titlePages = new HashMap<>();
        try (InputStream inputStream = TitlePageJSON.class.getClassLoader().getResourceAsStream(filePath)) {
            TitlePage[] cardArray = mapper.readValue(inputStream, TitlePage[].class);
            
            for (TitlePage titlePage : cardArray) {
                this.titlePages.put(titlePage.getTitle(), titlePage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<TitlePage> findAll() {
        return this.titlePages.values();
    }

    public String toHTMLByTitle(String title) {
        return this.titlePages.get(title).toHTML();
    }

    @Override
    public String toHTML() {
        StringBuilder st = new StringBuilder();
        for (TitlePage titlePage : titlePages.values()) {
            st.append(titlePage.toHTML());
        }
        return st.toString();
    }
}
