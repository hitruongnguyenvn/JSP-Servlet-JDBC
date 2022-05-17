<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@include file="/common/taglib.jsp" %>
	<c:url var='APIurl' value='/api-admin-news'></c:url>
	<c:url var='NEWSurl' value='/admin-news'></c:url>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Danh sach bai viet</title>
		</head>

		<body>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<c:if test="${not empty alert}">
							<div class="alert alert-${alert}" role="alert">
 								<strong>${message}</strong>
							</div>
						</c:if>	
						<div>
							<form id="login-form" style='display:inline-block;' class="form"
								action="<c:url value='/admin-news'></c:url>" method="post">
								<button id="" type="submit"
									class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Them Bai Viet'>
									<span>
										<i class="fa fa-plus-circle bigger-110 purple"></i>
									</span>
								</button>
							</form>
							<button id="btnDelete" type="button"
								class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
								data-toggle="tooltip" title='Xoa bai viet'>
								<span>
									<i class="fa fa-trash-o bigger-110 pink"></i>
								</span>
							</button>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<table class="table table-striped">
									<thead>
										<tr>
											<th><input type="checkbox" value="" id="checkBoxAll"></th>											
											<th>Ten bai viet</th>
											<th>Mo ta ngan</th>
											<th>Thao Tac</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.getModels()}">
											<tr>
												<td><input type="checkbox" value="${item.getId()}" id="checkBox_${item.getId()}"></td>
												<td>${item.getTitle()}</td>
												<td>${item.getShortDescription()}</td>
												<td>
													<form id="login-form" style='display:inline-block;' class="form"
														action="<c:url value='/admin-news?id=${item.getId()}'></c:url>" method="post">
														<button id="" type="submit"
															class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
															data-toggle="tooltip" title='Cap nhat bai viet'>
															<span>
																<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															</span>
														</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<form action="<c:url value='/admin-news'></c:url>" id="formSubmit" method="get">
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page" />
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
							<input type="hidden" value="" id="sortName" name="sortName" />
							<input type="hidden" value="" id="sortBy" name="sortBy" />
						</form>
					</div>
				</div>
			</div>
			<!-- /.main-content -->
			<script type="text/javascript">
				var totalPage = ${model.getTotalPage()};
				var currentPage = ${model.getPage()};
				var fetchNextRows = 3;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPage,
						visiblePages : 3,
						startPage : currentPage,
						onPageClick : function(event, page) {
							if(currentPage != page) {
								$('#page').val(page);
								$('#maxPageItem').val(fetchNextRows);
								$('#sortName').val("id");
								$('#sortBy').val("DESC");
								$('#formSubmit').submit();
							}
						}
					});
				});

				$("#btnDelete").click(function(){
					var data = {};
					var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            	return $(this).val();
		       		 }).get();
					/* ids la ten thuoc tinh vi chi co mot field
					nen ta dung dau dau ngoac kep truyen thang vao.
					Con khi nhieu fields thi ta can get ten cua tung
					field ra roi dung toan tu + de cong chuoi vao.
					*/
					data["ids"] = ids;
					deleteNews(data);
				});

				function deleteNews(data) {
					$.ajax({
						url: '${APIurl}',
						type: 'DELETE',
						contentType: 'application/json',
						data: JSON.stringify(data),
						dataType: 'json',
						success: function(result){
							window.location.href = '${NEWSurl}?page=1&maxPageItem=3&alert=success&message=deleteSuccess';
						},
						error: function(error){
							window.location.href = '${NEWSurl}?page=1&maxPageItem=3&alert=success&message=deleteFail';
						}
					});
				}
			</script>
		</body>

		</html>