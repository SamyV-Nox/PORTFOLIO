<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio | Accueil</title>
    <link rel="stylesheet" href="css/root.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Accueil.css">
    <link rel="stylesheet" href="css/Presentation.css">
    <link rel="stylesheet" href="css/Hoobie.css">
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/Contact.css">
    <link rel="stylesheet" href="css/Quality.css">


    
    <link rel="stylesheet" href="css/Card.css">    
    <link rel="icon" href="images/logo.jpg" />
    <script src="javascript/parallaxContainer.js" defer></script>
    <%@ page import="model.dto.project.Project" %>
    <%@ page import="model.dao.json.*" %>
    <% HeaderJSON header = new HeaderJSON(); %>

</head>

<body>
    <header class="header-container">
        <%= header.toHTML() %>
    </header>

    <section class="portfolio-section" id="accueil">
        <div class="parallax-container">
            <div class="parallax-content">
                <img src="images/wall.jpg" alt="arrière-plan" class="background-image">
                <div class="overlay"></div>
                <div class="presentation">
                    <img src="images/me.jpg" alt="moi" class="person-image">
                    <h1>Samy Van Calster</h1>
                    <p>Étudiant en 2eme année en BUT Informatique.</p>
                </div>
            </div>
        </div>
    </section>

    <section class="quality-container">
    <h2>Qualités</h2>
        <main>
        <% CardJSON qualitys = new CardJSON("Quality.json"); %>
        <%= qualitys.toHTML() %>
        </main>
    </section>

    <section class="project-container">
        <h2>Projets en vedette</h2>
        <% ProjectJSON projects = new ProjectJSON(); %>
        <main>
            <%= projects.get("SAÉ 4.01").toHTMLResume() %>
        </main>
        <a href="./Project.jsp">Voir d'autres projets ?</a>
    </section>
    
    <section class="presentation-centent">
        <h2>Formations</h2>
        <% PresentationJSON presentaion = new PresentationJSON("Formation.json"); %>
        <main>
            <%= presentaion.toHTML() %>
        </main>
    </section>

    <section class="card-centent">
        <h2>Langages</h2>
        <% CardJSON langages = new CardJSON(); %>
        <main>
            <%= langages.toHTML() %>
        </main>
        <a href="./Skills.jsp">Voir mes outils ?</a>
    </section>

    <section class="hoobies-content">
        <h2>Centre d'intérêts</h2>   
        <% PresentationJSON hoobies = new PresentationJSON("Hoobie.json"); %>
        <main>
        <%= hoobies.toHTML() %>
        </main>
    </section>

    <section class="contact-container">
    <h2>Contacts</h2>
        <main>
        <% CardJSON contact = new CardJSON("Contact.json"); %>
        <%= contact.toHTML() %>
        </main>
    </section>

    
</body>

</html>