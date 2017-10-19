<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<div class="text-center">
		<ul class="pagination">


			<%--For displaying Previous link except for the 1st page --%>


			<c:if test="${currentPage != 1}">
				<li><a href="ControlerArticles?page=${currentPage - 1}">Previous</a></li>
			</c:if>

			<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>

			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<li><a href="#">${i} </a></li>
					</c:when>
					<c:otherwise>
						<li><a href="ControlerArticles?page=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>


			<%--For displaying Next link --%>


			<c:if test="${currentPage lt noOfPages}">
				<li><a href="ControlerArticles?page=${currentPage+1}">Next</a></li>
			</c:if>
		</ul>

	</div>
