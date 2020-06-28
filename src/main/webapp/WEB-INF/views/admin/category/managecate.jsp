<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Quản lí category</title>
		<style>
        .dropdown-submenu {
            position: relative;
            text-align: center;
        }

        .dropdown-submenu .dropdown-menu {
            top: 0;
            left: 100%;
            margin-top: -1px;
            width: fit-content;
            text-align: center;
        }
        .myborder{
            border-left: 2px inset rgb(248, 246, 246);
        }
    </style>
	</head>

	<body>
		<div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Manage category</li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 myborder">
                            <!-- <div class="lopong">
                        <div class="btn-group-vertical">
                            <button type="button" class="btn btn-primary">Ông 1</button>
                            <div class="lopcha">
                                <div class="btn-group-vertical">
                                    <button type="button" class="btn btn-primary">Cha 1</button>
                                    <button type="button" class="btn btn-primary">Cha 2</button>
                                </div>
                            </div>
                            <button type="button" class="btn btn-primary">Samsung</button>
                            <button type="button" class="btn btn-primary">Sony</button>
                          </div>
                    </div> -->
                            <div class="sidebar responsive ace-save-state">
                                <ul class="nav nav-list">
                                    <li>
                                        <a href="#" class="dropdown-toggle">
                                            <i class="menu-icon fa fa-folder"></i>
                                            <span class="menu-text"> Men </span>

                                            <b class="arrow fa fa-angle-down"></b>
                                        </a>
                                        <b class="arrow"></b>

                                        <ul class="submenu">
                                            <li>
                                                <a href="">
                                                    <i class="menu-icon fa fa-caret-right"></i>
                                                    Nike
                                                </a>

                                                <b class="arrow"></b>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <i class="menu-icon fa fa-caret-right"></i>
                                                    Adidas
                                                </a>

                                                <b class="arrow"></b>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#" class="dropdown-toggle">
                                            <i class="menu-icon fa fa-folder"></i>
                                            <span class="menu-text"> Women </span>

                                            <b class="arrow fa fa-angle-down"></b>
                                        </a>
                                        <b class="arrow"></b>

                                        <ul class="submenu">
                                            <li>
                                                <a href="">
                                                    <i class="menu-icon fa fa-caret-right"></i>
                                                    Nike
                                                </a>

                                                <b class="arrow"></b>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <i class="menu-icon fa fa-caret-right"></i>
                                                    Adidas
                                                </a>

                                                <b class="arrow"></b>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 myborder">
                            <form action="">
                                <h3>Add type</h3>
                                <label for="tentype">Tên type</label>
                                <br>
                                <input name="tentype" type="text">
                                <br>
                                <button type="button" class="btn btn-warning">Thêm</button>
                            </form>
                        </div>
                        <div class="col-lg-3 myborder">
                            <form action="">
                                <h3>Add category</h3>
                                <label for="sel1">Chọn type:</label>
                                <select class="form-control" id="seltype" name="sellist1">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select>
                                <label for="tencategory">Tên category</label><br>
                                <input name="tencategory" type="text"><br>
                                <label for="categorycode">Category code</label><br>
                                <input name="categorycode" type="text">
                                <br>
                                <button type="button" class="btn btn-warning">Thêm</button>
                            </form>
                        </div>
                        <div class="col-lg-3 myborder">
                            <form id="xoatypecate" action="">
                                <h3>Xóa</h3>
                                <div class="form-check-inline">
                                    <label class="form-check-label" for="radio1">
                                        <input type="radio" class="form-check-input" id="radio1" name="optradio"
                                            value="option1" checked>Type
                                    </label>
                                </div>
                                <div class="form-check-inline">
                                    <label class="form-check-label" for="radio2">
                                        <input type="radio" class="form-check-input" id="radio2" name="optradio"
                                            value="option1">Category
                                    </label>
                                </div>
                                <div class="del-type">
                                    <label for="seldeltype">Type:</label>
                                    <select class="form-control" id="seldeltype" name="seldeltype">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                </div>

                                <div class="del-cate" style="display: none;">
                                    <label for="seldelcate">Category:</label>
                                    <select class="form-control" id="seldelcate" name="seldelcate">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                </div>
                                <br>
                                <button type="button" class="btn btn-warning">Thêm</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $('.dropdown-submenu a.test').on("click", function (e) {
                $(this).next('ul').toggle();
                e.stopPropagation();
                e.preventDefault();
            });
        });
    </script>
    <script>
        $("#xoatypecate").change(function () {
            if ($('#radio2').is(':checked')) {
                $(".del-cate").show();
                console.log("true");
            } else if (!($('#radio2').is(':checked'))) {
                $(".del-cate").hide();
                console.log("false");
            }
        })
    </script>
	</body>

	</html>