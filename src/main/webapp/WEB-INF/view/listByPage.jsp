<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/kkpager/jpager.css">
    <script type="text/javascript" src="<%=basePath%>js/listpage.js"></script>
    <script type="text/javascript">
        function load() {
        	arrayPage(${pagedResult.pages}, ${pagedResult.total});
        }
    </script>
    <script type="text/javascript">
	     function del(id) {
	  	     if(!confirm("确认删除吗？")) {
	  	     	window.event.returnValue = false;
	  	     	
	  	     } else {
	  	     	window.event.returnValue = true;
	  	     		$.ajax({
	  	     		type:"post",
	  	     		async:true,
	  	     		url:"<%=basePath%>del.do",
	  	     		data:{id:id},
	  	     		dataType:"text",
	  	     		success:function(res) {  	     		  
	  	     			if(res=="yes") {
	  	     			    alert("恭喜你删除成功！");
	  	     				location.href="<%=basePath%>getAllByPage.do";
	  	     			} else {
	  	     				alert("请稍后再试！");
	  	     			}
	  	     		}
	  	     	})
	  	     }	  	     
	  	     }
    </script>
</head>
<body onload="load()">

	<div>列表</div>
	<div>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Age</th>
				<th>ComingTime</th>
				<th>MaxScore</th>
				<th>MinScore</th>
				<th>Operation</th>
			</tr>
				<c:forEach items="${pagedResult.dataList}" var="s">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.comingtime}</td>
					<td>${s.maxscore}</td>
					<td>${s.minscore}</td>
					<td>
              			<a onclick="del(${s.id})">del|</a>
              			<a href="<%=basePath%>toUpdateByid.do?id=${s.id}">update</a>
              		</td>
				</tr>
				</c:forEach>
		</table>
	</div>
	<div id="jpager"></div>
</body>
</html>