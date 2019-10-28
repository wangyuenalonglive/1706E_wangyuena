<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<div id="pper">
<body>
<h1>	硪锝评论 		</h1>

<c:forEach items="${myComments }" var="comments">
		<div class="media-body">
			<h5 class="mt-0 mb-1">
				<small>评论内容：${comments.content }</small>
			</h5>
			<h5 class="mt-0 mb-1">
				<small>评论人：${comments.userName }" </small>
			</h5>
			<h5 class="mt-0 mb-1">
				<small>
				评论时间：<fmt:formatDate value="${comments.created }" pattern="yyyy-MM-dd"/> 
				</small>
			</h5>

		</div>
		<hr>
	</c:forEach>
	<div>${page }</div>
</body>
</div>
<script type="text/javascript">
//获取分页连接的URL .并进行加载
$('.page-link').off("click");
$(function(){
     $('.page-link').click(function (e) {
     	  //获取点击的的url
         var url = $(this).attr('data');
        //在中间区域显示地址的内容
        $('#pper').load(url);
     });
	
})
</script>

</html>