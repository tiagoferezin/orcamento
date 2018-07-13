<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">


</head>
<body>
	<c:if test="${not empty mensagemErro }">
		<div class="container">

			<div class="alert alert-danger">${mensagemErro }</div>

		</div>
	</c:if>

	<c:if test="${not empty mensagemInfo }">
		<div class="container">

			<div class="alert alert-info">${mensagemInfo }</div>

		</div>
	</c:if>
	<section class="container" id="secao-produtos">
		<jsp:include page="tabelaProduto.jsp" />
	</section>


	<jsp:include page="modalAlterar.jsp" />
	
	<jsp:include page="modalConfirmarExclusao.jsp" />

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="${path}/static/js/produtos.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

</body>
</html>