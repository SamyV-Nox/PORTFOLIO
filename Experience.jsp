<%@ page pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio | Experiences</title>
    <link rel="stylesheet" href="css/root.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/TitlePage.css">
    <link rel="stylesheet" href="css/Experience.css">

    <link rel="icon" href="images/logo.jpg" />

    <%@ page import="model.dao.json.HeaderJSON" %>
    <%@ page import="model.dao.json.TitlePageJSON" %>
    <%@ page import="model.dao.json.PresentationJSON" %>
</head>

<body>
    <header class="header-container">
        <% HeaderJSON header = new HeaderJSON(); %>
        <%= header.toHTML() %>
    </header>

    <section class="title-page-content">
        <% TitlePageJSON titlePage = new TitlePageJSON(); %>
        <%= titlePage.toHTMLByTitle("Éxperiences") %>
    </section>

    <section class="experience-container">
        <h2>Stages</h2>
        <main>
            <% PresentationJSON stages = new PresentationJSON("Stage.json"); %>
            <%= stages.toHTML() %>
        </main>
        
    </section>
</body>