<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<%@page import="java.util.*"%>
<%@page import="metier.*"%>
<%@page import="magasin.*"%>

<%
Service service = (Service)request.getAttribute("Services");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
  <div class="main-content">

    <form class="form-register" method="post" name="myform" onsubmit="return validate();">

        <div class="form-register-with-email">
                <div class="form-title-row">
                    <h1>Liste poste associés</h1>

       <table>
         <tr>
          <th>Id</th>
           <th>poste</th>
           <th>salaire</th>
         </tr>
         <% 
            for(ServicePoste ServicePoste : service.getListposte()) {  
         %>
         <tr>
           <td><%out.println(ServicePoste.getPoste().getId());%></td>
           <td><%out.println(ServicePoste.getPoste().getNom_poste());%></td>
           <td><%out.println(ServicePoste.getPoste().getMontant());%></td>
         </tr>
         <% } %>
       </table>

       <h1>Listes pieces associées</h1>
       <table>
        <tr>
         <th>Id</th>
          <th>Nom Piece</th>
          <th>Quantite</th>
          <th>Prix</th>
        </tr>
        <% 
           for(Piece piece : service.getListPieces()) {  
        %>
        <tr>
          <td><%out.println(piece.getId());%></td>
          <td><%out.println(piece.getNomPiece());%></td>
          <td><%out.println(piece.getQuantite());%></td>
          <td><%out.println(piece.getPrixUnitaire());%></td>
        </tr>
        <% } %>
      </table>




      <div class="main-content">

        <form class="form-register" method="post" name="/detailserviceservlet">

            <div class="form-register-with-email">

                <div class="form-white-background">
                   <div class="form-row">
                        <label>
                            <span>Marge Beneficiaiare</span>
                            <input type="text" name="marge_beneficiaire" id="nom" placeholder="marge_beneficiaire">
                            <input type="hidden" name="id" value="<%out.println(service.getIdservice());%>">
                        </label>
                    </div>

					<input type="submit" name="btn_login" value="Valider">
               
                </div>
            </div>
        </form>
    </div>
  </div>
</div>
</body>
</html>