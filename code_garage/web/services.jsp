
<%@page import="java.util.*"%>
<%@page import="metier.*"%>

<%
ArrayList<Niveau> niveaux = (ArrayList)request.getAttribute("list_niveau");
ArrayList<Poste> postes = (ArrayList)request.getAttribute("list_poste");
ArrayList<Service> list_Services = (ArrayList)request.getAttribute("list_Services");
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
                    <h1>Nos Services</h1>
       <table>
         <tr>
          <th>Id</th>
           <th>Service</th>
           <th>Revenus salarials</th>
           <th>Revenus materiels</th>
           <th>Marge Beneficiaire</th>
           <th>Montant</th>
         </tr>
         <% 
            for(Service service : list_Services) {  
         %>
         <tr>
           <td><%out.println(service.getIdservice());%></td>
           <td><%out.println(service.getNom_service());%></td>
           <td><%out.println(service.getMontantService());%></td>
           <td><%out.println(service.getRevenuMateriel());%></td>
           <td><%out.println(service.getMargeBeneficiaire());%></td>
           <td><%out.println(service.getValeurService());%></td>
         </tr>
         <% } %>
       </table> 
    </div>
  </div>
</div>
</body>
</html>