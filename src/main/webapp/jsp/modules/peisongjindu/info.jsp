<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<%@ include file="../../static/head.jsp"%>
	<link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8">
	    window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
	</script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>

</style>
<body>
	<!-- Pre Loader -->
	<div class="loading">
		<div class="spinner">
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>
	<!--/Pre Loader -->
	<div class="wrapper">
		<!-- Page Content -->
		<div id="content">
				<!-- Top Navigation -->
				<%@ include file="../../static/topNav.jsp"%>
				<!-- Menu -->
				<div class="container menu-nav">
					<nav class="navbar navbar-expand-lg lochana-bg text-white">
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
						 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="ti-menu text-white"></span>
						</button>
				
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<!-- <div class="z-navbar-nav-title">$template2.back.menu.title.text</div> -->
							<ul class="navbar-nav mr-auto" id="navUl">
							
							</ul>
						</div>
					</nav>
				</div>
				<!-- /Menu -->
				<!-- Breadcrumb -->
				<!-- Page Title -->
				<div class="container mt-0">
					<div class="row breadcrumb-bar">
						<div class="col-md-6">
							<h3 class="block-title">编辑配送进度</h3>
						</div>
						<div class="col-md-6">
							<ol class="breadcrumb">
								<li class="breadcrumb-item">
									<a href="${pageContext.request.contextPath}/index.jsp">
										<span class="ti-home"></span>
									</a>
								</li>
								<li class="breadcrumb-item"><span>配送进度管理</span></li>
								<li class="breadcrumb-item active"><span>编辑配送进度</span></li>
							</ol>
						</div>
					</div>
				</div>
			<!-- /Page Title -->

			<!-- /Breadcrumb -->
			<!-- Main Content -->
			<div class="container">

				<div class="row">
					<!-- Widget Item -->
					<div class="col-md-12">
						<div class="widget-area-2 lochana-box-shadow">
							<h3 class="widget-title">配送进度信息</h3>
							<form id="addOrUpdateForm">
								<div class="form-row">
									<input id="updateId" name="id" type="hidden">
									<div class="form-group col-md-6">
									<label>订单编号</label>

									<input id="dingdanbianhao" name="dingdanbianhao" class="form-control" v-model="ruleForm.dingdanbianhao" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>货物名称</label>

									<input id="huowumingcheng" name="huowumingcheng" class="form-control" v-model="ruleForm.huowumingcheng" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>货物重量</label>

									<input id="huowuzhongliang" name="huowuzhongliang" class="form-control" v-model="ruleForm.huowuzhongliang" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>运输金额</label>

									<input id="yunshujine" name="yunshujine" class="form-control" v-model="ruleForm.yunshujine" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>收件人</label>

									<input id="shoujianren" name="shoujianren" class="form-control" v-model="ruleForm.shoujianren" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>收件电话</label>

									<input id="shoujiandianhua" name="shoujiandianhua" class="form-control" v-model="ruleForm.shoujiandianhua" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>收件地址</label>

									<input id="shoujiandizhi" name="shoujiandizhi" class="form-control" v-model="ruleForm.shoujiandizhi" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>订单备注</label>

									<input id="dingdanbeizhu" name="dingdanbeizhu" class="form-control" v-model="ruleForm.dingdanbeizhu" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>司机姓名</label>

									<input id="sijixingming" name="sijixingming" class="form-control" v-model="ruleForm.sijixingming" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>车牌号码</label>

									<input id="chepaihaoma" name="chepaihaoma" class="form-control" v-model="ruleForm.chepaihaoma" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>联系电话</label>

									<input id="lianxidianhua" name="lianxidianhua" class="form-control" v-model="ruleForm.lianxidianhua" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>运输进度</label>

									<input id="yunshujindu" name="yunshujindu" class="form-control" v-model="ruleForm.yunshujindu" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>信息备注</label>

									<input id="xinxibeizhu" name="xinxibeizhu" class="form-control" v-model="ruleForm.xinxibeizhu" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>订单评价</label>

									<input id="dingdanpingjia" name="dingdanpingjia" class="form-control" v-model="ruleForm.dingdanpingjia" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>运输时间</label>

									<input id="yunshushijian" name="yunshushijian" class="form-control" v-model="ruleForm.yunshushijian" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>用户名</label>

									<input id="yonghuming" name="yonghuming" class="form-control" v-model="ruleForm.yonghuming" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>手机</label>

									<input id="shouji" name="shouji" class="form-control" v-model="ruleForm.shouji" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>身份证</label>

									<input id="shenfenzheng" name="shenfenzheng" class="form-control" v-model="ruleForm.shenfenzheng" readonly>
									</div>
									<div class="form-group col-md-6">
									<label>是否支付</label>

									<input id="ispay" name="ispay" class="form-control" v-model="ruleForm.ispay" readonly>
									</div>

									<div class="form-group-1 col-md-6 mb-3" style="display: flex;flex-wrap: wrap;">
										<button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- /Widget Item -->
				</div>
			</div>
			<!-- /Main Content -->
		</div>
		<!-- /Page Content -->
	</div>
	<!-- Back to Top -->
	<a id="back-to-top" href="#" class="back-to-top">
		<span class="ti-angle-up"></span>
	</a>
	<!-- /Back to Top -->
	<%@ include file="../../static/foot.jsp"%>
	<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>

	<script>
		<%@ include file="../../utils/menu.jsp"%>
		<%@ include file="../../static/setMenu.js"%>
		<%@ include file="../../utils/baseUrl.jsp"%>   	

		var tableName = "peisongjindu";
		var pageType = "add-or-update";
		var updateId = "";		

		var ruleForm = {};
		var vm = new Vue({
		  el: '#addOrUpdateForm',
		  data:{
			  ruleForm : {},
			},
		  beforeCreate: function(){
			  var id = window.sessionStorage.getItem("id");
				if(id != null && id != "" && id != "null"){
					$.ajax({ 
		                type: "GET",
		                url: baseUrl + "peisongjindu/info/" + id,
		                beforeSend: function(xhr) {xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));},
		                success: function(res){               	
		                	if(res.code == 0){
		                		vm.ruleForm = res.data;
				    		}else if(res.code == 401) {
				    			<%@ include file="../../static/toLogin.jsp"%>    
				    		}else{ alert(res.msg)}
		                },
		            });
				}
			},
			methods: { }
	  	});		

		// 填充富文本框
		function setContent(){
		}  

		// 获取当前详情
		function getDetails() {
			var id = window.sessionStorage.getItem("id");
			if(id != null && id != "" && id != "null"){
				$("#submitBtn").addClass("修改");
				updateId = id;
				window.sessionStorage.removeItem('id');
				$.ajax({ 
	                type: "GET",
	                url: baseUrl + "peisongjindu/info/" + id,
	                beforeSend: function(xhr) {xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));},
	                success: function(res){           
	                	if(res.code == 0){
	                		ruleForm = res.data
							showImg();
							setContent();		
							setMediaUrl();	
							setDownloadBtn();
			    		}else if(res.code ==401){
			    			 <%@ include file="../../static/toLogin.jsp"%>	
			    		}else{
							 alert(res.msg);
						}
	                },
	            });
			}else{
				$("#submitBtn").addClass("新增");
			}
		}	

		//图片显示
		function showImg(){
		}		
		function exit(){
			window.sessionStorage.removeItem("id");
			window.location.href = "list.jsp";
		}			
		// 下载
		function download(fileName){
			var url = baseUrl+fileName;
			window.open(url);
		}	
		//设置下载
		function setDownloadBtn(){
		}			
		//设置音视频播放链接
		function setMediaUrl(){
		}	
		//打开新窗口播放媒体
		function mediaPlay(url){
			//var url = baseUrl + "upload/" + fileName;
			window.open(baseUrl+url);
		}		
		$(document).ready(function() { 
			//设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username')+'('+window.sessionStorage.getItem('role')+')')
			//设置项目名
			$('.sidebar-header h3 a').html(projectName)
			setMenu();
			$('#exitBtn').on('click', function(e) {
			    e.preventDefault();
				exit();
			});
			getDetails();
			<%@ include file="../../static/myInfo.js"%>
		});			
		// 用户登出
        <%@ include file="../../static/logout.jsp"%>	
	</script>
</body>

</html>
