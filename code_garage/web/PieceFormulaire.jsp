
<%@page import="java.util.*"%>
<%@page import="magasin.*"%>

<%
ArrayList<Piece> list_pieces = (ArrayList)request.getAttribute("ListPiece");
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

        <form class="form-register" method="post" name="/pieceservlet">

            <div class="form-register-with-email">

                <div class="form-white-background">

                    <div class="form-title-row">
                        <h1>Choix des Pieces</h1>
                    </div>
					

					<div class="form-row">
                        <label> 
                        <span>Piece</span>
                            <select name="piece">
                                <% for(Piece piece : list_pieces) { %>
                                <option value="<%out.print(piece.getId());%>"><%out.print(piece.getNomPiece());%></option>
				            <% } %>                                
                            </select>
                        </label>
                    </div>

					<input type="submit" name="btn_login" value="Valider">
               
                </div>
            </div>
        </form>
    </div>
</body>

</html>
