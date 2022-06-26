
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
    <title>Tạo mới dịch vụ</title>
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
                    <div class="text-primary title">
                        <c:if test="${name == 'Villa'}">
                            Tạo mới Villa
                        </c:if>
                        <c:if test="${name == 'House'}">
                            Tạo mới House
                        </c:if>
                        <c:if test="${name == 'Room'}">
                            Tạo mới Room
                        </c:if>
                    </div>
                </div>
                <form action="/service?action=add" method="post">
                    <div class="p-3">
                        <div class="form-group ">
                            <label>ID dịch vụ</label>
                            <input type="text" class="form-control border-primary text-dark" name="id">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("id")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <input type="text" class="form-control border-primary text-dark" name="name"
                            value="${name}" hidden>
                        </div>

                        <div class="form-group ">
                            <label>Số người tối đa</label>
                            <input type="text" class="form-control border-primary text-dark d" name="maxPeople">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("maxPeople")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Loại thuê</label>
                            <select name="rentType" class="form-control custom-select border-primary">
                                <c:forEach items="${rentTypeList}" var="rentType">
                                    <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("rentType")}</label>
                            </c:if>
                        </div>
                        <c:if test="${name == 'Villa' || name == 'House'}">
                            <div class="form-group">
                                <label>Loại dịch vụ</label>
                                <select name="serviceType" class="form-control custom-select border-primary">
                                    <c:forEach items="${serviceTypeList}" var="serviceType">
                                        <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                                    </c:forEach>
                                </select>
                                <c:if test="${validate != null}">
                                    <label class="text-danger">${validate.get("serviceType")}</label>
                                </c:if>
                            </div>
                        </c:if>
                        <div class="form-group ">
                            <label>Giá thuê</label>
                            <input type="text" class="form-control border-primary text-dark" name="serviceCost">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("serviceCost")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Diện tích sử dụng</label>
                            <input type="text" class="form-control border-primary text-dark" name="serviceArea">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("serviceArea")}</label>
                            </c:if>
                        </div>
                        <c:if test="${name == 'Villa' || name == 'House'}">
                            <div class="form-group ">
                                <label>Dịch vụ đi kèm</label>
                                <input type="text" class="form-control border-primary text-dark" name="description">
                                <c:if test="${validate != null}">
                                    <label class="text-danger">${validate.get("description")}</label>
                                </c:if>
                            </div>
                        </c:if>
                        <c:if test="${name == 'Villa' || name == 'House'}">
                            <div class="form-group ">
                                <label>Tiêu chuẩn</label>
                                <input type="text" class="form-control border-primary text-dark" name="standardRoom">
                                <c:if test="${validate != null}">
                                    <label class="text-danger">${validate.get("standardRoom")}</label>
                                </c:if>
                            </div>
                        </c:if>
                        <c:if test="${name == 'Villa' || name == 'House'}">
                            <div class="form-group ">
                                <label>Số tầng</label>
                                <input type="text" class="form-control border-primary text-dark" name="floor">
                                <c:if test="${validate != null}">
                                    <label class="text-danger">${validate.get("floor")}</label>
                                </c:if>
                            </div>
                        </c:if>
                        <c:if test="${name == 'Villa'}">
                            <div class="form-group">
                                <label>Diện tích hồ bơi</label>
                                <input type="text" class="form-control border-primary text-dark" name="poolArea">
                                <c:if test="${validate != null}">
                                    <label class="text-danger">${validate.get("poolArea")}</label>
                                </c:if>
                            </div>
                        </c:if>
                        <button type="submit" class="btn btn-primary w-100">Thêm mới</button>
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
