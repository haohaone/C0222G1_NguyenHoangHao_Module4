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
    <title>Danh sách nhân viên</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css" />
    <link href="/bootstrap413/css/furama.css" rel="stylesheet" type="text/css">
    <style>
        .bg{
            background-image: url(/bootstrap413/css/furama2.jpg);
            background-size: cover;
        }
    </style>
</head>

<body class=" bg w-100" style="overflow: hidden">
<nav class="navbar bg-white m-0 p-0" id="head">
    <div class="row col-md-12 h-100 m-0 p-0">
        <div class="col-md-2 m-0 p-0 center-box home">
            <a href="jsp/home.jsp">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png" class="logo">
            </a>
        </div>
        <div class=" col-md-8 h-100 p-0 p-0 center-box home">
            Danh sách nhân viên
        </div>
        <div class=" col-md-2 center-box">
        </div>
    </div>
</nav>

<div class="row m-0 p-0  h-100 w-100" style="overflow: auto">
    <div class="col-md-1 m-0 h-100  p-0 center-box">&nbsp;</div>
    <div class="col-md-10 h-100 m-0 p-0 center-box">
        <div class=" bg-white center-box">
            <table class="table text-center table-striped table-hover bg-white" id="tableEmployee">
                <thead>
                <tr>
                    <td colspan="11" class="text-primary border-0">
                        <div class="row w-100">
                            <div class="col-md-6">
                                <a href="/employee?action=add" class="font-weight-bold">
                                    Thêm nhân viên
                                </a>
                            </div>
                            <div class="col-md-6">
                                <a href="/employee?action=search" data-toggle="modal" data-target="#SearchByName"
                                   class="font-weight-bold">
                                    Tìm kiếm theo tên
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
                    <th>No.</th>
                    <th>Tên Nhân Viên</th>
                    <th>Ngày sinh</th>
                    <th>SĐT</th>
                    <th>Địa chỉ</th>
                    <th>Lương</th>
                    <th>Chức vụ</th>
                    <th>Bộ phận</th>
                    <th>Học vấn</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${employeeList}" var="employee">
                    <c:if test="${employee.employeeStatusDelete == 0}">
                        <tr>
                            <td>${employee.employeeId}</td>
                            <td>${employee.employeeName}</td>
                            <td>${employee.employeeBirthDay}</td>
                            <td>${employee.employeePhone}</td>
                            <td>${employee.employeeAddress}</td>
                            <td>${employee.employeeSalary}</td>
                            <c:forEach items="${positionList}" var="position">
                                <c:if test="${position.positionId == employee.positionId}">
                                    <td>${position.positionName}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${divisionList}" var="division">
                                <c:if test="${division.divisionId == employee.divisionId}">
                                    <td>${division.divisionName}</td>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${educationDegreeList}" var="educationDegree">
                                <c:if test="${educationDegree.educationDegreeId == employee.educationDegreeId}">
                                    <td>${educationDegree.educationDegreeName}</td>
                                </c:if>
                            </c:forEach>
                            <td>
                                <a href="/employee?action=edit&id=${employee.employeeId}">Edit</a>
                            </td>
                            <td>
                                <a href="#" onclick="employeeIndex(${employee.employeeId})" data-toggle="modal"
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
                <h4 class="modal-title w-100 text-center">Bạn có muốn xóa nhân viên</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" onclick="employeeIndex2()">
                    <a class="text-white">Xóa</a>
                </button>
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
                    <form method="post" action="/employee?action=search"
                          class="form-inline my-2 my-lg-0 w-100 center-box">
                        <div class="p-1 bg-light rounded rounded-pill w-100 shadow-sm center-box">
                            <div class="input-group center-box w-100">
                                <input type="search" placeholder="Tên nhân viên" aria-describedby="button-addon1"
                                       class="form-control border-0 bg-light w-75"
                                       name="searchByName"
                                >
                                <div class="input-group-append">
                                    <button id="button-addon1" type="submit" class="btn btn-link text-primary w-25">
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

    function employeeIndex(index) {
        id = index;
    };

    function employeeIndex2() {
        let link = "/employee?action=delete&id=" + id;
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
