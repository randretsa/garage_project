
<%@page import="java.util.*"%>
<%@page import="facturation.*"%>
<%@page import="metier.*"%>

<%
ArrayList<Client> listClient= (ArrayList<Client>)request.getAttribute("listClients");
ArrayList<Service> listService= (ArrayList<Service>)request.getAttribute("listServices");

%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title></title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css2/main.css" rel="stylesheet" media="all">
    
</head>

<body>
    <div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
        <div class="wrapper wrapper--w680">
            <div class="card card-1">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Facture</h2>
                    <form name="/factureformulaire" method="post">
                        <div class="input-group">
                            <input class="input--style-1" type="text" placeholder="Reference"  name="reference">
                        </div>

                        <div class="input-group">
                            <input class="input--style-1" type="date" placeholder="" name="date">
                        </div>

                        <div class="select">
                            <select name="idclient" id="">
                                <%
                                    for(Client Client : listClient) { %>
                                        <option value="<%out.println(Client.getIdClient());%>"><%out.println(Client.getNom());%></option>
                                <%    } %>
                            </select>
                                
                            
                        </div>
                        
                        <div class="row row-space">
                           
                        </div>
                        <div class="p-t-20">
                            <button class="btn btn--radius btn--green" type="submit">Valider</button>
                        </div>
                    </form>
                    <div class="p-t-20">
                        <a href="listfactureservlet"><button class="btn btn--radius btn--green">Voir Facture</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body>

</html>
<!-- end document-->
