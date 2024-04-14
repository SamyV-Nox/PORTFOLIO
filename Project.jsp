<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio | Projets</title>
    <link rel="stylesheet" href="css/root.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/TitlePage.css">
    <link rel="stylesheet" href="css/Search.css">

    <link rel="icon" href="images/logo.jpg" />

    <%@ page import="model.dao.json.TitlePageJSON" %>
    <%@ page import="model.dao.json.ProjectJSON" %>
    <%@ page import="model.dao.json.HeaderJSON" %>
    <%@ page import="model.dto.project.Project" %>
    <%@ page import="model.dto.root.TitlePage" %>
    <% ProjectJSON projects = new ProjectJSON();%>
    <% HeaderJSON header = new HeaderJSON();%>
</head>
<body>
    <header class="header-container">
        <%= header.toHTML() %>
    </header>
    <% 
    String projectParam = request.getParameter("project");
    if (projectParam != null && projects.contains(projectParam)) {
        Project project = projects.get(projectParam);
        TitlePage titlePage = new TitlePage(project.getCode(), project.getTitle(), project.getBackgroundImage());
    %>
    <section class="title-page-content">
        <%= titlePage.toHTML() %>
    </section>

    <section class="project-container">
        <main>
        <%= project.toHTMLFocus() %>
        </main>
    </section>
    <% 
    }
    else {
    %>

    <section class="title-page-content">
        <% TitlePageJSON titlePage = new TitlePageJSON();%>
        <%= titlePage.toHTMLByTitle("Projets") %>
    </section>

    <section class="search-container">
        <form action="Project.jsp">
            <% String searchParam = request.getParameter("search"); %>
            <input type="text" name="search" placeholder="Rechercher...">
            <input type="submit" value="Rechercher">
            <%
            if (searchParam != null && !searchParam.isEmpty()) {
            %>
                <p>Vous avez recherché "<%= searchParam %>"</p>
            <%
            }
            %>
        </form>
    </section>

    <section class="project-container">
        <main>
            <%
            if (searchParam != null && !searchParam.isEmpty()) {
            %>
            <%= projects.toHTMLSearch(searchParam) %>
            <%
            }
            else {
            %>
            <%= projects.toHTMLResume() %>
            <%
            }
            %>
        </main>
    </section>

    <%
    }
    %>
</body>
</html>