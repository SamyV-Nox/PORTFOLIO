package model.dao.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.html.HTMLElement;
import model.dto.project.Project;

public class ProjectJSON implements HTMLElement {
    private static final String DEAULT_FILE_PATH = "Project.json";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Map<String, Project> projects;
    private List<Project> ordonedKey;

    public ProjectJSON() {
        this(DEAULT_FILE_PATH);
    }

    public ProjectJSON(String filePath) {
        this.projects = new HashMap<>();
        this.ordonedKey = null;

        try (InputStream inputStream = ProjectJSON.class.getClassLoader().getResourceAsStream(filePath)) {
            Project[] projectArray = MAPPER.readValue(inputStream, Project[].class);
            for (Project project : projectArray) {
                this.projects.put(project.getCode(), project);
            }
            this.ordonedKey = new ArrayList<>(projects.values());
            Collections.sort(this.ordonedKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<Project> findAll() {
        return projects.values();
    }

    public List<Project> searchByName(String title) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects.values()) {
            if (project.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(project);
            }
        }
        return result;
    }

    public String toHTMLSearch(String string) {
        List<Project> searchResult = searchByName(string);
        Collections.sort(searchResult);

        StringBuilder res = new StringBuilder();
        for (Project project : searchResult) {
            res.append(project.toHTMLResume());
        }

        return res.toString();
    }

    public Project get(String code) {
        return projects.get(code);
    }

    @Override
    public String toHTML() {
        StringBuilder sb = new StringBuilder();
        for (Project code : ordonedKey) {
            sb.append(code.toHTML());
        }
        return sb.toString();
    }

    
    public String toHTMLResume() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(this.ordonedKey);
        for (Project code : ordonedKey) {
            sb.append(code.toHTMLResume());
        }
        return sb.toString();
    }

    public boolean contains(String title) {
        return projects.containsKey(title);
    }
}
