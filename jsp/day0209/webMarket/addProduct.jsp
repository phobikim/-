<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="menu.jsp"/>


<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> ��ǰ ��� </h1>
	</div>
</div>

<main role="main">
	<div class="container">
		<form class="form-horizontal" name="newProduct" action="processAddProduct.jsp" method="post">
			<div class="form-group row">
				<label class="col-sm-2">��ǰ �ڵ�</label>
				<div class="col-sm-3">
					<input type="text" name="productId" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">��ǰ��</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">����</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">�� ����</label>
				<div class="col-sm-3">
					<input type="text" name="description" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">������</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">�з�</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">��� ��</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">����</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New">�ű� ��ǰ
					<input type="radio" name="condition" value="Old">�߰� ��ǰ
					<input type="radio" name="condition" value="Refurbished">��� ��ǰ
				</div>
			</div>
			
			<div class="form-group row">				
				<div class="col-sm-3">
					<input type="submit" class="btn btn-primary"
					value="���">
				</div>
			</div>
		</form>
	</div>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>















