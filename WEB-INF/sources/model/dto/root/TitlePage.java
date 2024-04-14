package model.dto.root;

import model.dto.html.HTMLElement;

public class TitlePage implements HTMLElement {
    String title;
    String description;
    String imagePath;

    public TitlePage(String title, String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
    }

    public TitlePage() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toHTML() {
        StringBuilder res = new StringBuilder();
        res.append("<div class=\"parallax-container\">");
        res.append("<div class=\"parallax-content\">");
        res.append("<img src=\"" + imagePath + "\" alt=\"" + title + "\" class=\"background-image\">");
        res.append("<div class=\"overlay\"></div>");
        res.append("<div class=\"presentation\">");
        res.append("<h1>" + title + "</h1>");
        res.append("<p>" + description + "</p>");
        res.append("</div>");
        res.append("</div>");
        res.append("</div>");
        res.append("<script src=\"javascript/parallaxContainer.js\"></script>");
        return res.toString();
    }  
}
