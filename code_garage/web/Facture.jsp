
<%@page import="java.util.*"%>
<%@page import="facturation.*"%>
<%@page import="metier.*"%>

<%
Facture factures = (Facture)request.getAttribute("Facture");
ArrayList<Service> listService = (ArrayList<Service>)request.getAttribute("listServices");
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
              <th>Remise</th>
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
              <td><%out.println(factureservice.getRemise()+ "%");%></td>
              <td><%out.println(factureservice.getMontantLine());%></td>
            </tr>
            <% } %>

            <tr>
              <form action="/code_garage/savedetailfacture" method="get">
                <td><input type="hidden" name="idfacture" value="<%out.print(factures.getIdFacture());%>"></td>
                <td>
                  <select name="idservice" id="">
                    <%
                      for(Service service : listService) { %>
                      <option value="<%out.print(service.getIdservice());%>"><%out.print(service.getNom_service());%></option>
                    <% } %>
                  </select>
                </td>
                <td><input type="text" placeholder="Prix" name="montant"></td>
                <td><input type="text" placeholder="Quantite" name="quantite"></td>
                <td><input type="text" placeholder="Remise" name="remise"></td>
                <td><button type="submit">Valider</button></td>
              </form>
            </tr>
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
              <a href="financeservlet"><button style="margin-top: 50px;">Etat Financier</button></a>
      </div>
  </div>
</body>
</html>