
<%@page import="java.util.*"%>
<%@page import="facturation.*"%>

<%
Facture factures = (Facture)request.getAttribute("Facture");

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
    
      <div class="form-register-with-email">
        <div class="form-title-row">
            <h1>En tete</h1>
          <table>
            <tr>
              <th>IdFacture</th>
              <th>Reference</th>
              <th>idClient</th>
              <th>Date</th>
            </tr>
            <tr>
              <td><%out.println(factures.getIdFacture());%></td>
              <td><%out.println(factures.getRef());%></td>
              <td><%out.println(factures.getIdClient());%></td>
              <td><%out.println(factures.getDateFacture());%></td>
            </tr>
          </table> 




          <h1>Facture</h1>
          <table>
            <tr>
              <th>Id</th>
              <th>Service</th>
              <th>Prix Unitaire</th>
              <th>Quantite</th>
              <th>Prix Total</th>
            </tr>
            <% 
              for(FactureService factureservice : factures.getListfactureService()) {  
            %>
            <tr>
              <td><%out.println(factureservice.getIdservice());%></td>
              <td><%out.println(factureservice.getNom_service());%></td>
              <td><%out.println(factureservice.getPrix_unitaire());%></td>
              <td><%out.println(factureservice.getQuantite());%></td>
              <td><%out.println(factureservice.getMontantLine());%></td>
            </tr>
            <% } %>
          </table> 

          <h1>Etat Facture</h1>
          <table>
            <tr>
              <th>Montant total</th>
              <th>deja payer</th>
              <th>Reste payer</th>
            </tr>
            <tr>
              <td><%out.println(factures.getMontantTotal());%></td>
              <td><%out.println(factures.getMontantpaye());%></td>
              <td><%out.println(factures.getRestePayer());%></td>
            </tr>
          </table> 
          
        </div>
      </div>
    
      <div class="modif_marge">
        <form class="" method="post" name="/factureservlet">
                <label for="">Payer</label>
                    <input type="text" name="montant" id="nom" placeholder="montant">
                    <button type="submit">Valider</button>
                    <input type="hidden" name="idfacture" value="<%out.println(factures.getIdFacture());%>">
        </form>
      </div>
  </div>
</body>
</html>