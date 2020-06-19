<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>

<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Chỉnh sửa sản phẩm</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                            <form id="formSubmit">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Brand</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" id="categoryCode" name="categoryCode">
                                        </select>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Mô tả</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${model.shortDescription}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Giá</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="gia" name="gia" value="${model.gia}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">Hình ảnh</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="anh" name="anh" value="${model.anh}"/>
                                    </div>
                                </div>
                                <br/>
                                <br/>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <c:if test="${not empty model.id}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật sản phẩm" id="btnAddOrUpdatesp"/>
                                        </c:if>
                                        <c:if test="${empty model.id}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm sản phẩm" id="btnAddOrUpdatesp"/>
                                        </c:if>
                                    </div>
                                </div>
                                <input type="hidden" value="${model.id}" id="id" name="id"/>
                            </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        window.onload=function () {
            $.getScript("/template/js/admin/edit.js");
        }
    </script>
</body>
</html>
