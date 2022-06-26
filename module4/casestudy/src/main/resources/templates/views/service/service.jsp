<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 6/1/2022
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="/bootstrap413/css/furama.css" rel="stylesheet" type="text/css">
    <style>
        .bg {
            background-image: url(/bootstrap413/css/furama2.jpg);
            background-size: cover;
        }
    </style>
</head>

<body class=" w-100 bg" style="overflow: hidden">
<nav class="navbar bg-white m-0 p-0" id="head">
    <div class="row col-md-12 h-100 m-0 p-0">
        <div class="col-md-2 m-0 p-0 center-box home">
            <a href="jsp/home.jsp">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png" class="logo">
            </a>
        </div>
        <div class=" col-md-8 h-100 p-0 p-0 center-box home">
            Danh sách khách hàng
        </div>
        <div class=" col-md-2 center-box">
        </div>
    </div>
</nav>

<div class="row m-0 p-0  h-100 w-100">
    <div class="col-md-1 m-0 h-100  p-0 center-box">&nbsp;</div>
    <div class="col-md-10 h-100 m-0 p-0 center-box">
        <div class=" bg-white center-box">
            <table class="table border-0 text-center table-striped table-hover bg-white" id="tableEmployee">
                <thead>
                <tr>
                    <td colspan="11" class="text-primary border-0">
                        <div class="row w-100">
                            <div class="col-md-6">
                                <a href="/service?action=add" class="font-weight-bold"
                                   data-toggle="modal" data-target="#addNew">
                                    Thêm dịch vụ
                                </a>
                            </div>
                            <div class="col-md-6">
                                <a href="/service?action=search" data-toggle="modal" data-target="#SearchByName"
                                   class="font-weight-bold">
                                    Tìm kiếm dịch vụ
                                </a>
                            </div>
                        </div>
                    </td>
                </tr>
                <c:if test="${editSuccessful != null}">
                    <tr>
                        <th colspan="11">
                            <div class="text-danger font-weight-bold">${editSuccessful}</div>
                        </th>
                    </tr>
                </c:if>

                <c:if test="${addSuccessful != null}">
                    <tr>
                        <th colspan="11">
                            <div class="text-success font-weight-bold">${addSuccessful}</div>
                        </th>
                    </tr>
                </c:if>

                <c:if test="${deleteSuccessful != null}">
                    <tr>
                        <th colspan="11">
                            <div class="text-warning font-weight-bold">${deleteSuccessful}</div>
                        </th>
                    </tr>
                </c:if>
                <tr>
                    <th>Mã dịch vụ</th>
                    <th>Tên dịch vụ</th>
                    <th>Diện tích</th>
                    <th>Giá</th>
                    <th>Loại thuê</th>
                    <th>Loại Dịch vụ</th>
                    <th>Tiêu chuẩn</th>
                    <th>Dịch vụ khác</th>
                    <th>Hồ bơi</th>
                    <th>Tầng</th>
                    <th>Edit</th>
                    <th>Delel</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${serviceList}" var="service">
                    <c:if test="${service.statusDelete == 0}">
                        <tr>
                            <td>${service.serviceId}</td>
                            <td>${service.serviceName}</td>
                            <td>${service.serviceArea}</td>
                            <td>${service.serviceCost}</td>
                            <c:forEach items="${rentTypeList}" var="rentType">
                                <c:if test="${rentType.rentTypeId == service.rentTypeId}">
                                    <td>${rentType.rentTypeName}</td>
                                </c:if>
                            </c:forEach>
                            <td>
                                <c:forEach items="${serviceTypeList}" var="serviceType">
                                    <c:if test="${serviceType.serviceTypeId == service.serviceTypeId}">
                                        ${serviceType.serviceTypeName}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${service.standardRoom}</td>
                            <td>${service.description}</td>
                            <td><c:if test="${service.poolArea > 0}">${service.poolArea}</c:if></td>
                            <td>
                                <c:if test="${service.floor > 0}">${service.floor}</c:if>
                                <c:if test="${service.floor <= 0}">Không</c:if>
                            </td>
                            <td>
                                <a href="/service?action=edit&id=${service.serviceId}">Edit</a>
                            </td>
                            <td>
                                <a href="#" onclick="serviceIndex('${service.serviceId}')" data-toggle="modal"
                                   data-target="#delete">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-1 m-0 p-0">&nbsp;</div>
</div>
</div>

<div class="modal" id="delete">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title w-100 text-center">Bạn có muốn xóa khách hàng</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" onclick="serviceIndex2()">
                    <a class="text-white">Xóa</a>
                </button>
                <button type="button" class="btn btn-dark " data-dismiss="modal">Hủy</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="addNew">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title w-100 text-center">Chọn loại dịch vụ muốn thêm</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body" style="display: flex; align-items: center; justify-content: space-around">
                <button type="button" class="btn btn-dark w-25">
                    <a href="/service?action=add&name=Villa" class="text-white">Villa</a>
                </button>
                <button type="button" class="btn btn-dark w-25">
                    <a href="/service?action=add&name=House" class="text-white">House</a>
                </button>
                <button type="button" class="btn btn-dark w-25">
                    <a href="/service?action=add&name=Room" class="text-white">Room</a>
                </button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark " data-dismiss="modal">Hủy</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="SearchByName">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header w-100">
                <div class="w-100 center-box">
                    <form method="post" action="/service?action=search"
                          class="form-inline my-2 my-lg-0 w-100 center-box">
                        <div class="row p-1 rounded rounded-pill w-100  center-box">
                            <div class="col-md-4 w-100">
                                <select name="customerTypes" class="form-control custom-select bg-light">
                                    <option value="" selected>Loại thuê</option>
                                    <c:forEach items="${rentTypeList}" var="rentType">
                                        <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-8 input-group center-box shadow-sm bg-light w-100 p-0">
                                <input type="search" placeholder="Tên khách hàng" aria-describedby="button-addon1"
                                       class="form-control border-0 w-75 bg-light "
                                       name="searchByName"
                                >
                                <div class="input-group-append bg-light w-25">
                                    <button id="button-addon1" type="submit"
                                            class="btn bg-light btn-link text-primary w-100">
                                        <i class="bi bi-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/bootstrap413/js/bootstrap.bundle.min.js"></script>

<script>
    var id;

    function serviceIndex(index) {
        debugger
        id = index;
    };

    function serviceIndex2() {
        let link = "/service?action=delete&id=" + id;
        window.location.href = link;
    };
</script>

<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    })
</script>
</html>
