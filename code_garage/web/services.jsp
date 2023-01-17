
<%@page import="java.util.*"%>
<%@page import="metier.*"%>

<%
ArrayList<Niveau> niveaux = (ArrayList)request.getAttribute("list_niveau");
ArrayList<Poste> postes = (ArrayList)request.getAttribute("list_poste");
ArrayList<Service> service = (ArrayList)request.getAttribute("list_Services");
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
           <th></th>
           <th>Service</th>
           <th>Montant</th>
         </tr>
         <% 
            for(Service service : list_Services) {  
         %>
         <tr>
           <td>1</td>
           <td><%out.println(service.getNom_service());%></td>
           <td><%out.println(service.getValeurService());%></td>
         </tr>
         <% } %>
       </table> 
    </div>
  </div>
</div>
</body>
</html>