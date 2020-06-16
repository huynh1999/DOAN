<%@include file="/common/taglib.jsp"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<div class="main-content">
    <form>
      <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="ace-icon fa fa-home home-icon"></i>
              <a href="#">Trang chủ</a>
            </li>
            <li class="active">Upload ảnh</li>
          </ul>
        </div>
        <div class="page-content">
          <div class="row">
            <div class="col-xs-12">
              <form id="formSubmit">
                <div class="form-group">
                  <div class="col-sm-3" style="text-align: right;">
                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Chọn ảnh"
                      id="btnuploadimage" />
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control" id="upanh" name="upanh" value="" />
                  </div>
                </div>
              </form>
            </div>
          </div>
          <br>
          <div class="row" style="text-align: center;">
            <input type="button" class="btn btn-white btn-warning btn-bold" value="Hoàn tất"
                      id="btnuploadimagedone" />
          </div>
          <br>
        </div>
      </div>
    </form>
  </div>
</body>
</html>
