
<%@page import="java.util.*"%>
<%@page import="finance.*"%>

<%
EtatFinance etatfinance = (EtatFinance)request.getAttribute("etatFinancier");
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
          <h1>Etat Financier</h1>
          <table>
            <tr>
              <th>Recette</th>
              <th>Depense</th>
              <th>Reste en Caisse</th>
            </tr>
            <tr>
                <td><%out.print(etatfinance.getRecette());%></td>
                <td><%out.print(etatfinance.getDepense());%></td>
                <td><%out.print(etatfinance.getDetail());%></td>
            </tr>
          </table> 
        </div>
      </div>
    </form>
  </div>
</body>
</html>