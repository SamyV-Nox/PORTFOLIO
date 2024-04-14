package model.dto.root;

import java.util.List;

import model.dto.html.HTMLElement;

public class Header implements HTMLElement {
    private String title;
    private String imgPath;
    private List<Link> links;

    public Header() {}

    public Header(String title, String imgPath, List<Link> links) {
        this.title = title;
        this.imgPath = imgPath;
        this.links = links;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toHTML() {
        StringBuilder st = new StringBuilder("<section>");
        st.append("<h1>" + title + "</h1>");
        st.append("<label for=\"menu-toggle\" class=\"menu-icon\">☰ Menu</label>");
        st.append("</section>");
        st.append("<input type=\"checkbox\" id=\"menu-toggle\">");
        st.append("<nav>");
        for (Link link : links) {
            st.append(link.toHTML());
        }
        st.append("</nav>");
        return st.toString();
    }


}
