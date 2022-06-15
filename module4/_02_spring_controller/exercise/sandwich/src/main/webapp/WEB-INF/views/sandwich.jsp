<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/5/2022
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        .text{
            font-size: 20px;
        }

        .check{
            width: 18px;
            height: 18px;
        }
    </style>
</head>
<body class="bg-dark">
<div class="container">
    <div class=" bg-white">
        <div class="h1 center-box m-0">Sandwich Condiments</div>
        <form action="/" method="get" class="p-3 h-25">
            <div class="footer h-50">
                <span class="font-weight-bold text" >
                    <input type="checkbox" name="condiment" class="check" value="lettuce"> Lettuce
                </span>

                <span class="font-weight-bold text">
                    <input type="checkbox" name="condiment" class="check" value="tomato"> Tomato
                </span>

                <span class="font-weight-bold text">
                    <input type="checkbox" name="condiment" class="check" value="mustard">  Mustard
                </span>

                <span class="font-weight-bold text">
                    <input type="checkbox" name="condiment" class="check" value="sprouts">  Sprouts
                </span>
            </div>

            <div class="form-group footer h-50">
                <button type="submit" class="btn btn-dark w-25 back-home">Save</button>
            </div>
        </form>

        <div class="h1 footer m-0">
            <c:forEach items="${condiments}" var="condiment">
                <span class="text-success">${condiment}</span>
            </c:forEach>
        </div>
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
