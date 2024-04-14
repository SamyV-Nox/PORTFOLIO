package model.dto.project;

public class Card extends Presentation {
    private String link;

    public Card(String urlImages, String title, String description, String urlPage) {
        super(urlImages, title, description);
        this.link = urlPage;
    }

    public Card(String urlImages, String title, String description) {
        super(urlImages, title, description);
    }

    public Card() {}

    @Override
    public String toHTML() {

        if (link != null && !link.isEmpty()) {
            return "<a href='" + link + "'>"
            + "<div style='background-image: url(" + getUrlImage() + ");' class='img'></div>"
            + "<h3>" + getTitle() + "</h3>"
            + "<p>" + getDescription() + "</p>"
            + "</a>";
        }
        return "<a>"
            + "<div style='background-image: url(" + getUrlImage() + ");' class='img'></div>"
            + "<h3>" + getTitle() + "</h3>"
            + "<p>" + getDescription() + "</p>"
            + "</a>";
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}