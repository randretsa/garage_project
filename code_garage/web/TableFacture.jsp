
<%@page import="java.util.*"%>
<%@page import="facturation.*"%>

<%
ArrayList<Facture> listfacture = (ArrayList)request.getAttribute("listfacture");

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
          <h1>Nos factures</h1>
          <table>
            <tr>
                <th>IdFacture</th>
                <th>Reference</th>
                <th>idClient</th>
                <th>Date</th>
            </tr>
            <% 
              for(Facture factures : listfacture) {  
            %>
            <tr>
                <td><%out.println(factures.getIdFacture());%></td>
                <td><a href="factureservlet?idfacture=<%out.println(factures.getIdFacture());%>"><%out.println(factures.getRef());%></a></td>
                <td><%out.println(factures.getIdClient());%></td>
                <td><%out.println(factures.getDateFacture());%></td>
            </tr>
            <% } %>
          </table> 
        </div>
      </div>
    </form>
  </div>
</body>
</html>

