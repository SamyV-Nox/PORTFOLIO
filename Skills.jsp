<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio | Accueil</title>
    <link rel="stylesheet" href="css/root.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Presentation.css">
    <link rel="stylesheet" href="css/TitlePage.css">
    <link rel="stylesheet" href="css/Card.css">    
    <link rel="icon" href="images/logo.jpg" />

    <script src="javascript/parallaxContainer.js" defer></script>
    <%@ page import="model.dao.json.HeaderJSON" %>
    <%@ page import="model.dao.json.TitlePageJSON" %>
    <%@ page import="model.dao.json.CardJSON" %>
    <% HeaderJSON header = new HeaderJSON(); %>

</head>

<body>
    <header class="header-container">
        <%= header.toHTML() %>
    </header>
    
    <section class="title-page-content">
        <% TitlePageJSON titlePage = new TitlePageJSON();%>
        <%= titlePage.toHTMLByTitle("Compétences") %>
    </section>

    <section class="card-centent">
        <h2>Langages</h2>
        <main>
        <% CardJSON langages = new CardJSON(); %>
        <%= langages.toHTML() %>
        </main>
    </section>

    <section class="card-centent">
        <h2>Outils</h2>
        <main>
        <% CardJSON technologie = new CardJSON("Technologie.json"); %>
        <%= technologie.toHTML() %>
        </main>
    </section>

    <section class="card-centent">
        <h2>IDE</h2>
        <main>
        <% CardJSON ide = new CardJSON("Ide.json"); %>
        <%= ide.toHTML() %>
        </main>
    </section>

</body>

</html>