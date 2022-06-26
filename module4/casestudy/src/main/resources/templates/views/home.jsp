<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 5/28/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Furama Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/bootstrap413/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap413/css/furama.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <style>
        .bg{
            background-image: url(/bootstrap413/css/furama2.jpg);
            background-size: cover;
        }
    </style>
</head>

<body class="bg">
<nav class="navbar bg-white m-0 p-0" id="head">
    <div class="row col-md-12 h-100 m-0 p-0">
        <div class="col-md-2 m-0 p-0 center-box">
            <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png"
                 class="logo">
        </div>
        <div class="row col-md-7 h-100 p-0 p-0">
            <div class="col-md-2 h-100 w-100 p-1 m-0 center-box">
                <button class="btn h-100 w-100 p-0 m-0 center-box button-menu" type="button">
                    <a class=" h-100  w-100 p-0 m-0 button-menu center-box home" href="#">Home</a>
                </button>
            </div>

            <div class="col-md-2 h-100 w-100 p-1 m-0">
                <button class="btn h-100 w-100 p-0 m-0 center-box button-menu" type="button">
                    <a class="w-100 h-100 button-menu center-box" href="/customer">Customer</a>
                </button>
            </div>

            <div class="col-md-2 h-100 w-100 p-1 m-0">
                <button class="btn h-100 w-100 p-0 m-0 center-box button-menu" type="button">
                    <a class="w-100 h-100 button-menu center-box" href="/service">Service</a>
                </button>
            </div>

            <div class="col-md-2 h-100 w-100 p-1 m-0">
                <button class="btn h-100 w-100 p-0 m-0 center-box button-menu" type="button">
                    <a class="w-100 h-100 button-menu center-box" href="/contract">Contract</a>
                </button>
            </div>

            <div class="col-md-2 h-100 w-100 p-1 m-0">
                <button class="btn h-100 w-100 p-0 m-0 center-box button-menu" type="button">
                    <a class="w-100 h-100 button-menu center-box" href="/employee">Employee</a>
                </button>
            </div>
            <div class="col-md-2">
                &nbsp
            </div>
        </div>
        <div class="row col-md-3 center-box">
            <div class="row w-100">
                <i class="bi bi-telephone-fill">
                    0762-709-502
                </i>
            </div>
            <div class="row w-100">
                <i class="bi bi-envelope-fill">
                    reservation@furamavietnam.com
                </i>
            </div>
        </div>
    </div>
</nav>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/datatables/js/bootstrap.min.js"></script>

</html>

