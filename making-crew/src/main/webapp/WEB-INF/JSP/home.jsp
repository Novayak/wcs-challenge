<%@ page
  info="Populate the crew members of the Argo ship"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="./static/css/normalize.css">
  <link rel="stylesheet" href="./static/css/skeleton.css">
  <link rel="stylesheet" href="./static/css/style.css">
  <link rel="shortcut icon" href="./static/assets/favicon.png" type="image/x-icon">
  <title>The Argo</title>
</head>

<body>
  <!-- Header section -->
  <header>
    <img class="logo"
      src="https://www.wildcodeschool.com/assets/logo_main-e4f3f744c8e717f1b7df3858dce55a86c63d4766d5d9a7f454250145f097c2fe.png"
      alt="Wild Code School logo" />
    <h1>
      Les Argonautes
    </h1>
  </header>

  <!-- Main section -->
  <main>
    <h2>Ajouter un(e) Argonaute</h2>
    <form class="new-member-form" method="post" action="#">
      <label for="name">Nom de l&apos;Argonaute</label>
      <input id="name" name="name" type="text" placeholder="Charalampos" required />
      <button type="submit">Permssion de monter à bord ?</button>
      <c:if test="${!empty errorMessage}">
        <p class="notice error" role="alert">
          <i class="fas fa-times fa-lg"></i>
          <c:out value="${errorMessage}" />
        </p>
      </c:if>
      <c:if test="${!empty successMessage}">
        <div class="notice success" role="alert">
          <i class="fas fa-anchor fa-lg"></i>
          <c:out value="${successMessage}" />
        </div>
      </c:if>
    </form>

    <!-- Member list -->
    <section id="crew">
      <h2>Membres de l'équipage</h2>
      <ul class="member-list">
        <c:forEach var="member" items="${crew}">
          <li class="member-item">Admète</li>
          <li class="member-item">Acaste</li>
          <li class="member-item">Périclyménos</li>
          <li class="member-item">Astérios </li>
          <li class="member-item">Polyphème </li>
        </c:forEach>
      </ul>
    </section>
  </main>

  <footer>
    <p>Réalisé par Jason en Anthestérion de l'an 515 avant JC</p>
  </footer>
  <script src="https://code.jquery.com/jquery-1.12.3.js" integrity="sha256-1XMpEtA4eKXNNpXcJ1pmMPs8JV+nwLdEqwiJeCQEkyc="
    crossorigin="anonymous">
  </script>
  <!--<script src="./static/js/script.js"></script>  -->
</body>

</html>
