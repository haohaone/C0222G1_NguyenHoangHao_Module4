<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/5/2022
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sandwich Condiments</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/bootstrap413/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .center-box {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .head-text {
            font-size: 30px;
            font-weight: bold;
            height: 10%;
        }

        .footer {
            display: flex;
            align-items: center;
            justify-content: space-around;
        }

        .back-home {
            color: white;
            text-underline: none;
        }

        .back-home:hover {
            color: white;
            text-underline: white;
        }
    </style>
</head>
<body class="bg-dark">
<div class="container">
    <div class=" bg-white">
        <div class="h1 center-box m-0">Settings</div>
        <form:form modelAttribute="mailBox" action="/create" method="post" class="p-3">
            <div class="form-group">
                <label>Languages:</label>
                <form:select class="form-control" path="languages">
                    <form:options items="${languages123}"></form:options>
                </form:select>
            </div>

            <div class="form-group">
                <label>Page size:</label>
                Show
                <form:select class="form-control" path="pageSize">
                    <form:options items="${pageSize123}"></form:options>
                </form:select>
            </div>

            <div class="form-group">
                <label>Spams filter:</label>
                <form:checkbox path="spamsFilter"/> Enable spams filter
            </div>

            <div class="form-group">
                <label>Signature:</label>
                <form:textarea type="text" class="form-control" path="signature"/>
            </div>
            <div class="form-group footer">
                <button type="submit" class="btn btn-dark w-25 back-home">Update</button>
            </div>
        </form:form>
    </div>
</div>
</body>

<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap413/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous">

</script>
</html>
