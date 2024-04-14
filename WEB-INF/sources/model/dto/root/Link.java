package model.dto.root;

import model.dto.html.HTMLElement;

public class Link implements HTMLElement {
    private String url;
    private String text;

    public Link(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public Link() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toHTML() {
        return "<a href=\"" + url + "\">" + text + "</a>";
    }
}
