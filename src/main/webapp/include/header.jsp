<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>JJAPANG</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
	<style>
	.abc {
		position: sticky;
		top: 0px;
		width: 100%; 
		z-index: 10;
	}
	 @font-face {
        font-family: 'NeoSansPro-BoldItalic';
        src: url('fonts/neosanspro-bolditalic.ttf') format('truetype');
        font-weight: bold;
        font-style: italic;
    }

    .brand {
        font-size: 100px;
        font-family: 'NeoSansPro-BoldItalic', sans-serif;
    }
        .brand span {
            display: inline-block;
        }
        .brand .j {
            color: brown;
        }
        .brand .a1 {
            color: brown;
        }
        .brand .p {
            color: red;
        }
        .brand .a {
            color: orange;
        }
        .brand .n {
            color: yellow;
        }
        .brand .g {
            color: skyblue;
        }
	.rainbow-text {
    animation: rainbow 5s infinite;
	}
	
	@keyframes rainbow {
	    0% { color: red; }
	    14% { color: orange; }
	    28% { color: yellow; }
	    43% { color: green; }
	    57% { color: blue; }
	    71% { color: indigo; }
	    85% { color: violet; }
	    100% { color: red; }
	}
	.address-bar {
    font-size: 30px;
	}
	.navbar-nav li a {
    font-family: 'NeoSansPro-BoldItalic', sans-serif;
    font-size: 30px;
	}
	.brand:hover {
    cursor: pointer;
	}
	</style>
    
</head>

<body>
	<!-- header -->
	<div class="brand" onclick="goToHomePage()">
    <span class="j">J</span>
    <span class="j">J</span>
    <span class="a1">a</span>
    <span class="p">p</span>
    <span class="a">a</span>
    <span class="n">n</span>
    <span class="g">g</span>
</div>

	<script>
		function goToHomePage() {
    	location.href = '<%=request.getContextPath() %>/home.jsp';
		}
	</script>         
    <div class="address-bar rainbow-text">세상에 이런 쇼핑몰은 없다 짭팡</div>
    
    <nav class="navbar navbar-default abc" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	
                    <li>
                        <a href="<%=request.getContextPath() %>/home.jsp" style="color:black">홈</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/product/mainpage.pd" style="color:black">상품</a>
                    </li>
                    
                    <c:choose>
                   	<c:when test="${sessionScope.member_id != null }">
                    <li>
                        <a href="<%=request.getContextPath() %>/member/member_login.member" style="color:blue">마이페이지</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/member/member_logout.member" style="color:red">로그아웃</a>
                    </li>
                    </c:when>
                    <c:otherwise>
                    <li>
                        <a href="<%=request.getContextPath() %>/member/member_login.member" style="color:blue">로그인</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/member/member_join.member" style="color:red">회원가입</a>
                    </li>
                    </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->