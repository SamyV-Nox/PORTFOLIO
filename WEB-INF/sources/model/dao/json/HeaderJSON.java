package model.dao.json;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.html.HTMLElement;
import model.dto.root.Header;

public class HeaderJSON implements HTMLElement {
    private static final String DEAULT_FILE_PATH = "Header.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private Header header;

    public HeaderJSON() {
        this(DEAULT_FILE_PATH);
    }

    public HeaderJSON(String filePath) {
        this.header = null;
        try (InputStream inputStream = HeaderJSON.class.getClassLoader().getResourceAsStream(filePath)) {
            Header[] projectArray = mapper.readValue(inputStream, Header[].class);
            this.header = projectArray[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toHTML() {
        if (header != null) {
            return header.toHTML();
        }
        return "";
    }
}
