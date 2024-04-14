package model.dto.project;

import model.dto.html.HTMLElement;

/**
 * Project
 * @author Samy Van Calster
 */
public class Project implements HTMLElement, Comparable<Project> {

    private static final String LABEL_DESCRIPTION = "Résumé du projet ou objectif principal";
    private static final String LABEL_CONCLUSION = "Conclusion";

    private String backgroundImage;
    private String code;
    private String title;
    private String description;
    private Skill skills;
    private PointOfView pointOfView;
    private String conclusion;

    public Project() {}

    public Project(String code, String title, String description, Skill skills, PointOfView pointOfView,
            String conclusion) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.skills = skills;
        this.pointOfView = pointOfView;
        this.conclusion = conclusion;
    }

    public static String getLabelDescription() {
        return LABEL_DESCRIPTION;
    }

    public static String getLabelConclusion() {
        return LABEL_CONCLUSION;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getBackgroundImage() {
        if (this.backgroundImage == null) {
            return "images/projet.jpg";
        }
        return this.backgroundImage;
    }

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    public PointOfView getPointOfView() {
        return pointOfView;
    }

    public void setPointOfView(PointOfView pointOfView) {
        this.pointOfView = pointOfView;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toHTML() {
        StringBuilder res = new StringBuilder();
        res.append("<div class=\"project\">");
        res.append("<h1>" + code + " - " + title + "</h1>");
        res.append("<h2>" + LABEL_DESCRIPTION + "</h2>");
        res.append("<p>" + description + "</p>");
        res.append(skills.toHTML());
        res.append(pointOfView.toHTML());
        res.append("<h2>" + LABEL_CONCLUSION + "</h2>");
        res.append("<p>" + conclusion + "</p>");
        res.append("</div>");
        return res.toString();
    }

    public String toHTMLResume() {
        StringBuilder res = new StringBuilder();
        res.append("<div class=\"project\" style=\"background-image: url(" + getBackgroundImage() + ");\">");
        res.append("<h1>" + code + " - " + title + "</h1>");
        res.append("<a href=\"Project.jsp?project=" + code.replace(" ", "%20").replace("+", "%2B") + "\">Voir plus...</a>");
        res.append("</div>");
        return res.toString();
    }

    public String toHTMLFocus() {
        StringBuilder res = new StringBuilder();
        res.append("<div class=\"project\">");
        res.append("<a href=\"Project.jsp\"> <- Retour</a>");
        res.append("<h2>" + LABEL_DESCRIPTION + "</h2>");
        res.append("<p>" + description + "</p>");
        res.append(skills.toHTML());
        res.append(pointOfView.toHTML());
        res.append("<h2>" + LABEL_CONCLUSION + "</h2>");
        res.append("<p>" + conclusion + "</p>");
        res.append("</div>");
        return res.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }

    @Override
    public int compareTo(Project arg0) {
        return (arg0.code.compareTo(this.code) * -1);
    }
}