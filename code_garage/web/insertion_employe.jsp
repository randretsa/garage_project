
<%@page import="java.util.*"%>
<%@page import="metier.*"%>

<%
ArrayList<Niveau> niveaux = (ArrayList)request.getAttribute("list_niveau");
ArrayList<Poste> postes = (ArrayList)request.getAttribute("list_poste");
%>

<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title></title>

	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/login-register.css">
	
</head>

<body>

    <div class="main-content">

        <form class="form-register" method="post" name="/insertemploye">

            <div class="form-register-with-email">

                <div class="form-white-background">

                    <div class="form-title-row">
                        <h1>Insertion</h1>
                    </div>
					
                   <div class="form-row">
                        <label>
                            <span>Nom</span>
                            <input type="text" name="nom" id="nom" placeholder="nom">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Prenom</span>
                            <input type="text" name="prenom" id="prenom" placeholder="prenom">
                        </label>
                    </div>

					<div class="form-row">
                        <label>
                            <span>Date Naissance</span>
                            <input type="text" name="date_naissance" id="date_naissance" value="2002-01-01" placeholder="date_naissance">
                        </label>
                    </div>

					<div class="form-row">
                        <label>
							<span></span>
                                                        <select name="poste">
                                <% for(Poste poste : postes) { %>
                                <option value="<%out.print(poste.getId());%>"><%out.print(poste.getNom_poste());%></option>
				<% } %>                                
                            </select>
                        </label>
                    </div>

					<div class="form-row">
                        <label>
							<span></span>
                                                        <select name="niveau">
			  <% for(Niveau niveau : niveaux) { %>
                                <option value="<%out.print(niveau.getId());%>"><%out.print(niveau.getNiveau());%></option>
				<% } %>    </select>
                        </label>
                    </div>

					<input type="submit" name="btn_login" value="Valider">
               
                </div>
            </div>
        </form>
    </div>
</body>

</html>
