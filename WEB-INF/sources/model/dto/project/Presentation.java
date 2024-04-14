package model.dto.project;

import model.dto.html.HTMLElement;

public class Presentation implements HTMLElement {

    String urlImage;
    String title;
    String description;

    public Presentation(String urlImage, String title, String description) {
        this.urlImage = urlImage;
        this.title = title;
        this.description = description;
    }

    public Presentation() {}

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return (title == null)? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return (description == null)? "" : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PresentationCard" + urlImage + ", title=" + title + ", description=" + description + "]";
    }

    @Override
    public String toHTML() {
        return "<div>"
                + "<div style='background-image: url(" + urlImage + ");' class='img'></div>"
                + "<div class='text'>"
                + "<h3>" + title + "</h3>"
                + "<p>" + description + "</p>"
                + "</div>"
                + "</div>";
    }
}