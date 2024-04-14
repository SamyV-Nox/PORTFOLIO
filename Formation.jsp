<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio | Formations</title>
    <link rel="stylesheet" href="css/root.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/TitlePage.css">
    <link rel="stylesheet" href="css/Presentation.css">
    <link rel="icon" href="images/logo.jpg" />

    <%@ page import="model.dao.json.HeaderJSON" %>
    <%@ page import="model.dao.json.PresentationJSON" %>
    <%@ page import="model.dao.json.TitlePageJSON" %>
    <% HeaderJSON header = new HeaderJSON(); %>
    <% TitlePageJSON titlePage = new TitlePageJSON(); %>
    <% PresentationJSON presentaion = new PresentationJSON("Formation.json"); %>
</head>

<body>
    <header class="header-container">
        <%= header.toHTML() %>
    </header>

    <section class="title-page-content">
        <%= titlePage.toHTMLByTitle("Formations") %>
    </section>

    <section class="presentation-centent">
        <main>
            <%= presentaion.toHTML() %>
        </main>
    </section>
</body>

</html>