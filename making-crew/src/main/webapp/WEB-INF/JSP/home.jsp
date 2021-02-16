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
  <link rel="stylesheet" href="./static/css/style.css" >
  <title>The Argo</title>
</head>

<body>
  <!-- Header section -->
  <header>
    <h1>
      <img
        src="https://www.wildcodeschool.com/assets/logo_main-e4f3f744c8e717f1b7df3858dce55a86c63d4766d5d9a7f454250145f097c2fe.png"
        alt="Wild Code School logo" />
      Les Argonautes
    </h1>
  </header>

  <!-- Main section -->
  <main>

    <!-- New member form -->
    <div>
	    <h2>Ajouter un(e) Argonaute</h2>
	    <form class="new-member-form"
	          method="post"
	          action="#"
	          >
	      <label for="name">Nom de l&apos;Argonaute</label>
	      <input id="name" name="name" type="text" placeholder="Charalampos" required />
	      <button type="submit">Envoyer</button>
	    </form>    
	    <c:if test="${!empty errorMessage}">
	      <p class="alert alert-danger" role="alert">
	        <c:out value="${errorMessage}"/>
	      </p>
	    </c:if>
	    <c:if test="${!empty successMessage}">
	      <p class="alert alert-danger" role="alert">
	        <c:out value="${successMessage}"/>
	      </p>
	    </c:if>
    </div>
    <!-- Member list -->
    <section id="crew">
	    <h2>Membres de l'équipage</h2>
	    <ul class="member-list">
	     <c:forEach var="member" items="${crew}">
	      <li class="member-item"><c:out value="${member.fullname}"/></li>	      
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
