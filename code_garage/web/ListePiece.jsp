
<%@page import="java.util.*"%>
<%@page import="magasin.*"%>

<%
ArrayList<Piece> list_pieces = (ArrayList)request.getAttribute("ListPiece");
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
    <form class="form-register" method="post" name="myform">
      <div class="form-register-with-email">
        <div class="form-title-row">
          <h1>Tableau de bord des Pieces</h1>
          <table>
            <tr>
              <th>Id</th>
              <th>Nom</th>
              <th>Prix d'Achat</th>
              <th>Pourcentage</th>
              <th>Benefice</th>
              <th>Prix Conseiller</th>
            </tr>
            <% 
              for(Piece pieces : list_pieces) {  
            %>
            <tr>
                <td><%out.print(pieces.getId());%></td>
                <td><%out.print(pieces.getNomPiece());%></td>
                <td><%out.print(pieces.getPrixUnitaire());%></td>
                <td><%out.print(pieces.getPourcentage() + "%");%></td>
                <td><%out.print(pieces.getInteret());%></td>
                <td><%out.print(pieces.getPrixConseiller());%></td>
            </tr>
            <% } %>
          </table> 
        </div>
      </div>
    </form>
  </div>
</body>
</html>