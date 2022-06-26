
<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/1/2022
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tạo mới khách hàng</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/bootstrap413/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap413/css/login.css" rel="stylesheet" type="text/css">
    <style>
        .bg{
            background-image: url(/bootstrap413/css/furama2.jpg);
            background-size: cover;
        }
    </style>
</head>

<body class="h-100 w-100 bg">
<div class="container-fluid w-100 h-100 p-0 m-0">
    <div class="row w-100 h-100 p-0 m-0" style="overflow: auto">
        <div class="col-md-4 p-0 m-0 "></div>
        <div class="col-md-4 p-0 m-0 login">
            <div class="h-100 w-100 bg-white p-0 m-0 ">
                <div class=" login">
                    <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png"
                         class="logo">
                    <div class="text-primary title">Tạo mới khách hàng</div>
                </div>
                <form action="/customer?action=edit" method="post">
                    <div class="p-3">
                        <div class="form-group ">
                            <input hidden value="${id}" type="text" class="form-control border-primary text-dark" name="id">
                        </div>
                        <div class="form-group">
                            <label>Loại khách hàng</label>
                            <select name="customerTypes" class="form-control custom-select border-primary">
                                <c:forEach items="${customerTypes}" var="cusType">
                                    <option value="${cusType.customerId}">${cusType.customerTypeName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("customerType")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Tên khách hàng</label>
                            <input value="${name}" type="text" class="form-control border-primary text-dark" name="name">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("name")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Giới tính</label>
                            <select name="gender" class="form-control custom-select border-primary">>
                                <option selected value="1">Nam</option>
                                <option value="0">Nữ</option>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("gender")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Ngày sinh</label>
                            <input type="date" class="form-control border-primary text-dark d" name="birthDay">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("birthDay")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Số chứng minh thư</label>
                            <input value="${idCard}" type="text" class="form-control border-primary text-dark" name="idCard">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("idCard")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Số điện thoại</label>
                            <input value="${phone}" type="text" class="form-control border-primary text-dark" name="phone">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("phone")}</label>
                            </c:if>
                        </div>

                        <div class="form-group ">
                            <label>Email</label>
                            <input value="${email}" type="email" class="form-control border-primary text-dark" name="email">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("email")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Địa chỉ</label>
                            <input value="${address}" type="text" class="form-control border-primary text-dark" name="address">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("address")}</label>
                            </c:if>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Sửa</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-4  p-0 m-0"></div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/bootstrap413/js/bootstrap.min.js"></script>

</html>
