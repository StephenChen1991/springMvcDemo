<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/kkpager/jpager.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="jpager"></div>
	<!-- 分页插件开始 -->
	<script type="text/javascript">

		function getParameter(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return null;
		}

		//init
		$(function() {
			var totalPage = $
			{
				pageResult.pages
			}
			;
			var totalRecords = $
			{
				pageResult.total
			}
			;
			var pageNo = getParameter('pageNumber');
			if (!pageNo) {
				pageNo = 1;
			}
			//生成分页 
			jpager.generPageHtml({
				pno : pageNo,
				//总页码 
				total : totalPage,
				//总数据条数 
				totalRecords : totalRecords,
				//链接前部 
				hrefFormer : 'getAllByPage',
				//链接尾部 
				hrefLatter : '',
				getLink : function(n) {
					//alert(n);
					return this.hrefFormer + this.hrefLatter + "?pageNumber="
							+ n;
				},
			/* 		lang : {
			 firstPageText : '|<',
			lastPageText : '>|',
			 prePageText : '<',
			nextPageText : '>',
			 totalPageBeforeText : '共',
			 totalPageAfterText : '页',
			 totalRecordsAfterText : '条数据',
			 gopageBeforeText : '转到',
			 gopageButtonOkText : '确定',
			 gopageAfterText : '页',
			 buttonTipBeforeText : '第',
			 buttonTipAfterText : '页'
			 } */
			//,
			//mode : 'click',//默认值是link，可选link或者click 
			/* 		click : function(n){
			 //this.selectPage(n);
			 alert(n);
			 return false;
			 } */
			});
		});
	</script>
	<!-- 分页插件结束 -->
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
			</tr>
				<c:forEach items="${pagedResult.dataList}" var="s">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.comingtime}</td>
					<td>${s.maxscore}</td>
					<td>${s.minscore}</td>
				</tr>
				</c:forEach>
		</table>
	</div>

</body>
</html>