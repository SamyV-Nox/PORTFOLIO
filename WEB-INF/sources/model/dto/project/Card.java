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
        String res = "";
            res += (link != null && !link.isEmpty())? "<a href='" + link + "'>" : "<a>";
            res +=  (getUrlImage() != null)? "<div style='background-image: url(" + getUrlImage() + ");' class='img'></div>" : "";
            res +=  "<h3>" + getTitle() + "</h3>";
            res +=  "<p>" + getDescription() + "</p>";
            res +=  "</a>";
        return res;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}