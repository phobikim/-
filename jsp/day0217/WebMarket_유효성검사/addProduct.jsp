<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">-->
 <link rel="stylesheet" href="./resources/css/bootstrap.min.css">  
 <script type="text/javascript" src="./resources/js/validation.js"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>


<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> 상품 등록 </h1>
	</div>
</div>

<main role="main">
	<div class="container">
		<form  onsubmit="return CheckAddProduct()"  enctype="multipart/form-data" class="form-horizontal" name="newProduct" action="processAddProduct.jsp" method="post">
			<div class="form-group row">
				<label class="col-sm-2">상품 코드</label>
				<div class="col-sm-3">
					<input type="text" id="productId" name="productId" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text"  id="unitPrice" name="unitPrice" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">상세 정보</label>
				<div class="col-sm-3">
					<input type="text" name="description" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" class="form-control">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New">신규 제품
					<input type="radio" name="condition" value="Old">중고 제품
					<input type="radio" name="condition" value="Refurbished">재생 제품
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-5">
					<input type="file" name="productImage" class="form-control">
				</div>
			</div>
			
			
			
			<div class="form-group row">				
				<div class="col-sm-3">
					<input type="submit" class="btn btn-primary"
					value="등록">
				</div>
			</div>
		</form>
	</div>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>















