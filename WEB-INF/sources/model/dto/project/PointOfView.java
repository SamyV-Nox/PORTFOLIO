package model.dto.project;

import java.util.List;

import model.dto.html.HTMLElement;

public class PointOfView implements HTMLElement {
    private static final String LABEL_STRENGTH = "Points forts";
    private static final String LABEL_WEAKNESS = "Points faibles";
    private static final String LABEL_UPGRADE = "Points à améliorer";
    
    private List<String> myStrength;
    private List<String> myWeakness;
    private List<String> myUpgrade;

    public PointOfView(List<String> myStrength, List<String> myWeakness, List<String> myUpgrade) {
        this.myStrength = myStrength;
        this.myWeakness = myWeakness;
        this.myUpgrade = myUpgrade;
    }

    public PointOfView() {}

    public static String getLabelStrength() {
        return LABEL_STRENGTH;
    }

    public static String getLabelWeakness() {
        return LABEL_WEAKNESS;
    }

    public static String getLabelUpgrade() {
        return LABEL_UPGRADE;
    }

    public List<String> getMyStrength() {
        return myStrength;
    }

    public void setMyStrength(List<String> myStrength) {
        this.myStrength = myStrength;
    }

    public List<String> getMyWeakness() {
        return myWeakness;
    }

    public void setMyWeakness(List<String> myWeakness) {
        this.myWeakness = myWeakness;
    }

    public List<String> getMyUpgrade() {
        return myUpgrade;
    }

    public void setMyUpgrade(List<String> myUpgrade) {
        this.myUpgrade = myUpgrade;
    }

    private boolean hasOtherSoftSkills() {
        return myUpgrade!= null && !myUpgrade.isEmpty();
    }

    private boolean hasSoftSkills() {
        return myWeakness!= null && !myWeakness.isEmpty();
    }

    private boolean hasTechnicalSkills() {
       return myStrength!= null && !myStrength.isEmpty();
    }

    @Override
    public String toHTML() {
        StringBuilder res = new StringBuilder();
        
        if (hasTechnicalSkills()) {
            res.append("<h2>" + LABEL_STRENGTH + "</h2><ul>");
            for (String skill : myStrength) {
                res.append("<li>" + skill + "</li>");
            }
            res.append("</ul>");
        }

        if (hasSoftSkills()) {
            res.append("<h2>" + LABEL_WEAKNESS + "</h2><ul>");
            for (String skill : myWeakness) {
                res.append("<li>" + skill + "</li>");
            }
            res.append("</ul>");
        }

        if (hasOtherSoftSkills()) {
            res.append("<h2>" + LABEL_UPGRADE + "</h2><ul>");
            for (String skill : myUpgrade) {
                res.append("<li>" + skill + "</li>");
            }
            res.append("</ul>");
        }
        return res.toString();
    }
}
