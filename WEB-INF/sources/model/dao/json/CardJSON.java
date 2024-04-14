package model.dao.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.html.HTMLElement;
import model.dto.project.Card;

public class CardJSON implements HTMLElement {
    private static final String DEAULT_FILE_PATH = "Langage.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private List<Card> cards;

    public CardJSON() {
        this(DEAULT_FILE_PATH);
    }

    public CardJSON(String filePath) {
        try (InputStream inputStream = CardJSON.class.getClassLoader().getResourceAsStream(filePath)) {
            Card[] cardArray = mapper.readValue(inputStream, Card[].class);
            this.cards = Arrays.asList(cardArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Card> findAll() {
        return this.cards;
    }

    @Override
    public String toHTML() {
        StringBuilder st = new StringBuilder();
        for (Card presentation : cards) {
            st.append(presentation.toHTML());
        }
        return st.toString();
    }

    public static void main(String[] args) {
        CardJSON cardJSON = new CardJSON();
        System.out.println(cardJSON.toHTML());
    }
}
