<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
        <title>Shop Homepage - Start Bootstrap Template</title>
        <link rel="icon" type="image/x-icon" href="<c:url value='/template/web/assets/favicon.ico'></c:url>" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="<c:url value='/template/web/css/styles.css'></c:url>" rel="stylesheet" />
	</head>
	<body>
		<!-- header -->
		<%@include file="/common/web/header.jsp"%>
		<!-- header -->
		<dec:body></dec:body>
		<!-- footer -->
		<%@include file="/common/web/footer.jsp"%>
		<!-- footer -->
	 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="<c:url value='template/web/js/scripts.js'></c:url>"></script>
	</body>
</html>