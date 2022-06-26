<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/2/2022
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chỉnh sửa Nhân viên</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/bootstrap413/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap413/css/login.css" rel="stylesheet" type="text/css">
    <link href="/bootstrap413/css/furama.css" rel="stylesheet" type="text/css">
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
                    <div class="text-primary title">Chỉnh sửa nhân viên</div>
                </div>
                <form action="/employee?action=edit&id=${id}" method="post">
                    <div class="p-3">
                        <div class="form-group">
                            <input hidden value="${id}" type="text" class="form-control border-primary text-dark" name="id">
                        </div>
                        <div class="form-group ">
                            <label>Tên nhân viên</label>
                            <input value="${name}" type="text" class="form-control border-primary text-dark" name="name">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("name")}</label>
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
                            <label>Lương</label>
                            <input value="${salary}" type="text" class="form-control border-primary text-dark" name="salary">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("salary")}</label>
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
                        </div>
                        <div class="form-group ">
                            <label>Địa chỉ</label>
                            <input value="${address}" type="text" class="form-control border-primary text-dark" name="address">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("address")}</label>
                            </c:if>
                        </div>
                        <div class="form-group ">
                            <label>Tài khoản</label>
                            <input value="${account}" type="email" class="form-control border-primary text-dark" name="account">
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("account")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <select name="position" class="form-control custom-select">
                                <option selected>Chức vụ</option>
                                <c:forEach items="${positionList}" var="posi">
                                    <option value="${posi.positionId}">${posi.positionName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("position")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <select  name="division" class="form-control custom-select">
                                <option selected>Bộ phận</option>
                                <c:forEach items="${divisionList}" var="division">
                                    <option value="${division.divisionId}">${division.divisionName}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("division")}</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <select name="educationDegree" class="form-control custom-select">
                                <option selected>Học vấn</option>
                                <c:forEach items="${educationDegreeList}" var="educationDegree">
                                    <option value="${educationDegree.educationDegreeId}">
                                            ${educationDegree.educationDegreeName}
                                    </option>
                                </c:forEach>
                            </select>
                            <c:if test="${validate != null}">
                                <label class="text-danger">${validate.get("educationDegree")}</label>
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
