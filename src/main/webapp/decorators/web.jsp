<%@include file="/common/taglib.jsp"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title><dec:title /></title>
	<link href="<c:url value='/template/css/bootstrap.min.css' />"
		  rel="stylesheet" type="text/css">
	<dec:head />
	<link rel="stylesheet" href=" ${pageContext.request.contextPath}/template/css/nhshop.css">
	<link rel="shortcut icon" href=" ${pageContext.request.contextPath}/template/logo/icon.ico" type="image/x-icon">
</head>
<body>
<!-- header -->
<script>

	function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
		console.log('statusChangeCallback');
		console.log(response);                   // The current login status of the person.
		if (response.status === 'connected') {   // Logged into your webpage and Facebook.
			testAPI();
		} else {                                 // Not logged into your webpage or we are unable to tell.
			document.getElementById('status').innerHTML = 'Please log ' +
					'into this webpage.';
		}
	}


	function checkLoginState() {               // Called when a person is finished with the Login Button.
		FB.getLoginStatus(function(response) {   // See the onlogin handler
			statusChangeCallback(response);
		});
	}


	window.fbAsyncInit = function() {
		FB.init({
			appId      : '189392698895180',
			cookie     : true,                     // Enable cookies to allow the server to access the session.
			xfbml      : true,                     // Parse social plugins on this webpage.
			version    : '7.0'           // Use this Graph API version for this call.
		});


		FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
			console.log("getLoginStatus"+response);
			statusChangeCallback(response);        // Returns the login status.
		});
	};


	(function(d, s, id) {                      // Load the SDK asynchronously
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) return;
		js = d.createElement(s); js.id = id;
		js.src = "https://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));


	function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
		console.log('Welcome!  Fetching your information.... ');
		FB.api('/me?fields=email,name', function(response) {
			axios.post("/login-facebook",{
				id:response.id,
				name:response.name,
				email:response.email
			})

		});
	}

</script>

<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v7.0&appId=189392698895180&autoLogAppEvents=1"></script>



<!-- header  -->
<div class="header" role="list">
	<div class="headinfo" role="listitem">
		<div class="headinfo_left" role="listitem">
			<a href="#" class="text_" data-target="#myModal">Join us</a>
		</div>
		<div class="headinfo_right" role="listitem">
			<a href="#" class="text_ loginclick">Login</a>
			<a href="#" class="text_">Help</a>
			<a href="${pageContext.request.contextPath}/checkout" class="fa fa-shopping-cart icon_color"></a>
			<a href="#" class="fa fa-map-marker icon_color"><span class="text_"> HCM</span></a>
		</div>
	</div>
	<div class="headmenu" role="listitem">
		<div class="headmenu_cl1" role="listitem">
			NBShop
		</div>
		<div class="headmenu_cl2" role="list">
			<ul class="menu_list" role="list">
				<li class="menu_item" role="listitem">
					<div class="list_down">
						<a href="category.html">MEN</a>
						<div class="dropdown_content" role="dropdown_content">
							<a class="sm_item" href="#">MEN 1</a>
							<a class="sm_item" href="#">MEN 2</a>
							<a class="sm_item" href="#">MEN 3</a>
						</div>
					</div>
				</li>
				<li class="menu_item" role="listitem">
					<div class="list_down">
						<a href="#">WOMEN</a>
						<div class="dropdown_content">
							<a class="sm_item" href="#">WOMEN 1</a>
							<a class="sm_item" href="#">WOMEN 2</a>
							<a class="sm_item" href="#">WOMEN 3</a>
						</div>
					</div>
				</li>
				<li class="menu_item" role="listitem">
					<div class="list_down">
						<a href="#">KIDS</a>
						<div class="dropdown_content">
							<a class="sm_item" href="#">KIDS 1</a>
							<a class="sm_item" href="#">KIDS 2</a>
							<a class="sm_item" href="#">KIDS 3</a>
						</div>
					</div>
				</li>
				<li class="menu_item" role="listitem">
					<div class="list_down">
						<a href="category.html">BRAND</a>
						<div class="dropdown_content">
							<a class="sm_item" href="category.html">NIKE</a>
							<a class="sm_item" href="#">ADIDAS</a>
							<a class="sm_item" href="#">GUCCI</a>
							<a class="sm_item" href="#">CHANEL</a>
						</div>
					</div>
				</li>
				<li class="menu_item" role="listitem">
					<a href="custom.html">CUSTOMISE</a>
				</li>
			</ul>
		</div>
		<div class="headmenu_cl3" role="form">
			<form class="search" action="" role="search">
				<div class="input-group">

					<input id="input1" type="text" placeholder="Search">
					<div class="input-group-appen">
						<span class="fa fa-search myis"></span>
					</div>
					<!-- <button><span class="fa fa-search input-group-addon"></span></button> -->
				</div>

			</form>
		</div>
	</div>

</div>
<!-- login  -->
<div class="mylogform modal-open">
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="display: none;"
			id="btshowlog">
		Open modal
	</button>
	<!-- The Modal -->
	<!-- login  -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="containerform">
						<div class="chudau">
							<h4 class="modal-title chudep">Login</h4>
						</div>

						<form action="<c:url value="/j_spring_security_check" />" method="post">
							<div class="input-field">
								<input type="text" required="" name="j_username">
								<label>Username</label>
							</div>
							<div class="input-field">
								<input class="pswrd" type="password" required="" name="j_password">
								<span class="show"></span>
								<label>Password</label>
							</div>
							<div class="button">
								<div class="inner">
								</div>
								<button type="submit">LOGIN</button>
							</div>
						</form>
						<div class="auth">
							<p id="login_with">Or login with</p>
						</div>
						<div class="links">
							<div class="facebook">
								<fb:login-button size="medium"
												 scope="public_profile,email"
												 onlogin="checkLoginState();">
									Connect to Facebook
								</fb:login-button>
							</div>
							<div class="google">
								<i class="fa fa-google-plus-square"><span>Google</span></i>
							</div>
						</div>
						<div class="signup">
							<p id="signup">Not a member? <a href="#" id="signuplink" data-dismiss="modal">Signup now</a></p>
						</div>
					</div>

				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<!-- signup  -->
	<div class="mylogform">
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalSignup" style="display: none;"
				id="btshowlogsignup">
			Open modal
		</button>
		<!-- The Modal -->
		<!-- signup  -->
		<div class="modal fade" id="myModalSignup" >
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="containerform">
							<div class="chudau">
								<h4 class="modal-title chudep">Signup</h4>
							</div>

							<form action="/register" method="post">
								<div class="input-field">
									<input type="text" required="" name="username">
									<label>User Name</label>
								</div>
								<div class="input-field">
									<input type="text" required="" name="fullname">
									<label>Full Name</label>
								</div>
								<div class="input-field">
									<input type="text" required="" name="phone">
									<label>Số điện thoại</label>
								</div>
								<div class="input-field">
									<input type="text" required="" name="address">
									<label>Địa chỉ</label>
								</div>
								<div class="input-field">
									<input type="text" required="" name="email">
									<label>Email</label>
								</div>
								<div class="input-field">
									<input class="pswrd" type="password" required="" name="password">
									<span class="show"></span>
									<label>Password</label>
								</div>
								<div class="input-field">
									<input class="pswrd" type="password" required="">
									<span class="show"></span>
									<label>Password Again</label>
								</div>
								<div class="button">
									<div class="inner">
									</div>
									<button>SIGNUP</button>
								</div>
							</form>
							<div class="signup">
								<p id="signup">Had account? <a href="#" class="loginclick" data-dismiss="modal">Login</a></p>
							</div>
						</div>

					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>
	</div>


	<dec:body />
	<!-- Footer -->
	<script src="${pageContext.request.contextPath}/template/js/common/axios.js"></script>
	<link href="<c:url value='/template/css/font-awesome.min.css' />"
		  rel="stylesheet" type="text/css">
	<script src="<c:url value='/template/js/common/jquery.js' />"></script>
	<script src="<c:url value='/template/js/common/bootstrap.min.js' />"></script>
	<script src="${pageContext.request.contextPath}/template/js/common/popper.js"></script>
	<script>
		$(document).ready(function () {
			$(".loginclick").click(function () {
				event.preventDefault();
				$("#btshowlog").click();
			})
			$("#signuplink").click(function () {
				event.preventDefault();
				$("#btshowlogsignup").click();
			})
		})
	</script>
</body>
</html>