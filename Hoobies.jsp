<%@ page pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio | Centres d'intérêts</title>
    <link rel="stylesheet" href="css/root.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/TitlePage.css">
    <link rel="stylesheet" href="css/Hoobie.css">
    <link rel="icon" href="images/logo.jpg" />

    <%@ page import="model.dao.json.HeaderJSON" %>
    <%@ page import="model.dao.json.PresentationJSON" %>
    <%@ page import="model.dao.json.TitlePageJSON" %>
</head>

<body>
    <header class="header-container">
        <% HeaderJSON header = new HeaderJSON(); %>
        <%= header.toHTML() %>
    </header>

    <section class="title-page-content">
        <% TitlePageJSON titlePage = new TitlePageJSON();%>
        <%= titlePage.toHTMLByTitle("Centres d'intérêts") %>
    </section>

    <section class="hoobies-content">
        <% PresentationJSON hoobies = new PresentationJSON("Hoobie.json"); %>
        <main>
        <%= hoobies.toHTML() %>
        </main>
    </section>
</body>