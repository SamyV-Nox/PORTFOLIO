package model.dto.project;

import java.util.List;

import model.dto.html.HTMLElement;

/**
 * Skill
 * @author Samy Van Calster
 */
public class Skill implements HTMLElement {
    private static final String LABEL_TECHNICAL_SKILLS = "Compétences techniques visées";
    private static final String LABEL_SOFT_SKILLS = "Savoir-être requis liés à l'informatique";
    private static final String LABEL_OTHER_SKILLS = "Savoir-être requis divers";

    private List<String> technicalSkills;
    private List<String> softSkills;
    private List<String> otherSoftskills;

    public Skill(List<String> technicalSkills, List<String> softSkills, List<String> otherSoftskills) {
        this.technicalSkills = technicalSkills;
        this.softSkills = softSkills;
        this.otherSoftskills = otherSoftskills;
    }

    public Skill() {}

    public static String getLabelTechnicalSkills() {
        return LABEL_TECHNICAL_SKILLS;
    }

    public static String getLabelSoftSkills() {
        return LABEL_SOFT_SKILLS;
    }

    public static String getLabelOtherSkills() {
        return LABEL_OTHER_SKILLS;
    }

    public List<String> getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(List<String> technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public List<String> getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(List<String> softSkills) {
        this.softSkills = softSkills;
    }

    public List<String> getOtherSoftskills() {
        return otherSoftskills;
    }

    public void setOtherSoftskills(List<String> otherSoftskills) {
        this.otherSoftskills = otherSoftskills;
    }

    private boolean hasTechnicalSkills() {
        return technicalSkills!= null && !technicalSkills.isEmpty();
    }

    private boolean hasSoftSkills() {
        return softSkills!= null && !softSkills.isEmpty();
    }

    private boolean hasOtherSoftSkills() {
        return otherSoftskills!= null && !otherSoftskills.isEmpty();
    }


    @Override
    public String toHTML() {
        StringBuilder res = new StringBuilder();
        
        if (hasTechnicalSkills()) {
            res.append("<h2>" + LABEL_TECHNICAL_SKILLS + "</h2><ul>");
            for (String skill : technicalSkills) {
                res.append("<li>" + skill + "</li>");
            }
            res.append("</ul>");
        }

        if (hasSoftSkills()) {
            res.append("<h2>" + LABEL_SOFT_SKILLS + "</h2><ul>");
            for (String skill : softSkills) {
                res.append("<li>" + skill + "</li>");
            }
            res.append("</ul>");
        }

        if (hasOtherSoftSkills()) {
            res.append("<h2>" + LABEL_OTHER_SKILLS + "</h2><ul>");
            for (String skill : otherSoftskills) {
                res.append("<li>" + skill + "</li>");
            }
            res.append("</ul>");
        }
        return res.toString();
    }
}
