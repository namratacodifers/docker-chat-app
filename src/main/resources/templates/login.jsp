<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Codifers Chat</title>

<style type="text/css">
	header .border{
		background-color: #f5f5f5;
	}
	
	.card-horizontal{
		display: flex;
    	flex: 1 1 auto;
	}

	html, body {
 		 height: 100%;
	}

	main{
		height: 88.7%;
	}
	
	main .container-fluid , main #main{
		height: 100%; 
	}
	
	main .card{
		cursor: pointer;
	}
	
	.textMessage{
		background-color: #f5f5f5;
		position: absolute;
		bottom: 0px;
		width: 100%;
	}
	
	main textarea{
		resize: none;
	}
	
	.responseMessage{
		background-color: #077b8a;
		height: fit-content;
		/* margin-left: 10px !important;
		margin-top: 10px !important; */
		color: white;
		width: 80%;
		
	}
	
	.requestMessage{	
	
		background-color: #5c3c92;
		height: fit-content;
		/* margin-left: 10px !important;
		margin-top: 10px !important; */
		color: white;
		width: 80%;
	
	}


</style> 
<script th:inline="javascript">
/*<![CDATA[*/

    var currentUser = /*[[${codifersClientUser}]]*/ null;
    console.log(currentUser);
    var serverURL = "http://localhost:8080/codifers-chat/";

/*]]>*/
</script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" /> 
</head>
<body>
	<header>
		<div class="container-fluid">
			<div class="row border justify-content-between">
				<div class="col col-lg-3 col-md-4 col-sm-4 col-xs-4 ">
					<h4 class="p-3">Codifers Chat</h4>
				</div>
				<div class="col col-lg-2 col-md-3 col-sm-3 col-xs-2">
					<i class="fa fa-user fa-2x p-3"></i><span th:text="${codifersClientUser.name}">User Name</span>
				</div>
			</div>
		</div>
		
	</header>
	
	<main>
		<div class="container-fluid">
			<div class="row" id="main">
				<div class="col col-lg-4 col-md-4 col-sm-4 col-xs-4 p-3 border border-top-0" style="height: 100%;">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-center">
							<input class="form-control" type="text" placeholder="Search" aria-label="Search">
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-center">
							<button class="btn btn-primary btn-rounded my-0" type="button">Search</button>
						</div>
					</div>
					<div class="row" style="margin-top: 10px;" th:each="user: ${codifersClientList}">
						<div class="col offset-sm-1 col-lg-10 col-md-10 col-sm-10 col-xs-10" style="margin-top: 10px;">
							<div class="card" th:data-user="${ user }" th:onclick="selectUser([[${ user }]])"  >
								<div class="card-horizontal">
									<div class="img-square-wrapper w-25 text-center">
										<img class="w-50 p-1 rounded-circle" src="images/user.png" alt="Card image cap">
									</div>
									<div class="card-body p-1">
										<h6 class="card-title" th:text="${user.name}">Shivansh Nema</h6>
										<p class="card-subtitle" th:text="Hello">Kya haal h</p>
									</div>
								</div>
							</div>
						</div>			
					</div>
				</div>
	
				<div class="col col-lg-8 col-md-8 col-sm-8 col-xs-8" id="messageBox" style="height: inherit;">
					<!-- <h5 style="text-align: center;margin-top:30%;">Start Chat by clicking on user or Search for user</h5> -->
					
	
				</div>
			</div>
		</div>
	</main>
	
	<footer>
	
	
	</footer>

	
</body>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://use.fontawesome.com/aa06376ed2.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<script src="js/custom.js"></script>
<script src="js/chat.js"></script>


</html>