<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<%@include file="/common/taglib.jsp" %>
	<c:url var='APIurl' value='/api-admin-news'></c:url>
	<c:url var='NEWSurl' value='/admin-news'></c:url>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Chinh sua bai viet</title>
	</head>

	<body>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="#">Home</a>
						</li>
						<li class="active">Change posts</li>
					</ul><!-- /.breadcrumb -->
				</div>
				<div class="page-content">
				<c:if test="${not empty alert}">
							<div class="alert alert-${alert}" role="alert">
 								<strong>${message}</strong>
							</div>
						</c:if>	
					<div class="row">
						<div class="col-xs-12">
							<form id="formSubmit">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Categories</label>
									<div class="col-sm-9">
										<select class="form-control" id="idCategory" name="idCategory">
											<option value="">Choice...</option>
											<c:forEach var="item" items="${categories}">
												<c:if test="${model.getIdCategory() == item.getId()}">
													<option value="${item.getId()}" selected>${item.getName()}</option>
												</c:if>
												<c:if test="${model.getIdCategory() != item.getId()}">
													<option value="${item.getId()}">${item.getName()}</option>
												</c:if>										
											</c:forEach>
										</select>			
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Title</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="title" name="title" value="${model.getTitle()}" />
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Thumbnail</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="thumbnail" name="thumbnail"
											value="" />
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Short Description</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="shortDescription"
											name="shortDescription" value="${model.getShortDescription()}" />
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Content</label>
									<div class="col-sm-9">
										<textarea rows="" cols="" id="content" name="content"
											style="width: 820px;height: 175px">${model.getContent()}</textarea>
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<div class="col-sm-12">
										<c:if test="${not empty model.id}">
											<input type="button" class="btn btn-white btn-warning btn-bold"
												value="Update Posts" id="btnAddOrUpdateNew" />
										</c:if>
										<c:if test="${empty model.id}">
											<input type="button" class="btn btn-white btn-warning btn-bold"
												value="Add Posts" id="btnAddOrUpdateNew" />
										</c:if>
									</div>
								</div>
								<input type="hidden" value="${model.getId()}" id="id" name="id" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			$( "#btnAddOrUpdateNew" ).click(function(/*e*/) {
				/*e.preventDefault();*/
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data[""+v.name+""] = v.value;
				});
				var id = $('#id').val();
				if(id == ""){
					addNews(data);
				} else {
					updateNews(data);
				}
			});
			function addNews(data){
				$.ajax({
					url: '${APIurl}',
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result) {
						window.location.href = '${NEWSurl}?page=1&maxPageItem=3&alert=success&message=insertSuccess';
					},
					error: function(error) {
						window.location.href = '${NEWSurl}?page=1&maxPageItem=3&alert=success&message=insertFail';
					}
				})
			}
			function updateNews(data){
				$.ajax({
					url: '${APIurl}',
					type: 'PUT',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result) {
						window.location.href = '${NEWSurl}?page=1&maxPageItem=3&alert=success&message=updateSuccess';
					},
					error: function(error) {
						window.location.href = '${NEWSurl}?page=1&maxPageItem=3&alert=success&message=updateFail';
					}
				})
			}
		</script>
	</body>
	</html>