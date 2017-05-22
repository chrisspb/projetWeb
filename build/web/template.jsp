<%-- 
    Document   : template
    Created on : 21 mai 2017, 12:13:09
    Author     : perle
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML>  
<html>  
    <head>  
        <title>${param.title}</title>  
        <link rel="stylesheet" type="text/css"  
              href="${pageContext.request.contextPath}/resources/style.css" />  
        <link rel="stylesheet" type="text/css"  
              href="${pageContext.request.contextPath}/resources/materialize.css" />  
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/favicon.png">-->
    </head>  
    <body>  
        <jsp:include page="header.jsp"/>  


        <h1>${param.title}</h1> 

        <main>
            <jsp:include page="${param.content}.jsp"/>  
        </main>
        
        
        <jsp:include page="footer.jsp"/>  

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/materialize.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/main.js"></script>     
    </body>  
</html> 
