
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
    <title>Tạo mới hợp đồng</title>
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
                        Tạo mới hợp đồng
                    </div>
                </div>
                <form action="/contract?action=add" method="post">
                    <div class="p-3">
                        <div class="form-group ">
                            <label>Ngày bắt đầu</label>
                            <input type="datetime-local" class="form-control border-primary text-dark" name="startDate">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("startDate")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Ngày kết thúc</label>
                            <input type="datetime-local" class="form-control border-primary text-dark" name="endDate">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("endDate")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Tiền cọc</label>
                            <input type="text" class="form-control border-primary text-dark" name="deposit">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("deposit")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Tổng tiền</label>
                            <input type="text" class="form-control border-primary text-dark" name="totalMoney">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("totalMoney")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Khách hàng</label>
                            <select name="customerId" class="form-control custom-select border-primary">
                                <c:forEach items="${customerList}" var="customer">
                                    <option value="${customer.customerId}">(${customer.customerId}) ${customer.customerName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("customerId")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Nhân viên</label>
                            <select name="employeeId" class="form-control custom-select border-primary">
                                <c:forEach items="${employeeList}" var="employee">
                                    <option value="${employee.employeeId}">(${employee.employeeId}) ${employee.employeeName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("employeeId")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Dịch vụ</label>
                            <select name="serviceId" class="form-control custom-select border-primary">
                                <c:forEach items="${serviceList}" var="service">
                                    <option value="${service.serviceId}">(${service.serviceId}) ${service.serviceName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("serviceId")}</label>
                            </c:if>
                        </div>
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
