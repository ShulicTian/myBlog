<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="shulictian.ssm.po.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div style="background-color:#f5f6f7;">
		<div style="height:345px;padding:10px 0px;margin-bottom:20px;">
			<div class="layui-carousel" id="imgs" style="margin:auto;box-shadow:0px 0px 5px black;">
				<div carousel-item="">
					<div><img src="img/logo.jpg" /></div>
					<div><img src="img/back.jpg" /></div>
					<div><img src="" /></div>
				</div>
			</div>
		</div>
		<div id="globleCtx">
				<div id="topics" style="height:1020px;width:75%;margin:auto;background-color:white;">
				<div v-if="isHave()">此处暂时没有任何人发帖，奉献你的第一次吧!&nbsp;<a v-bind:href="sendUrl" target="_blank">点击发帖</a></div>
				<div v-for="top in topics" class="topic">
					<div id="imgHead"></div>
					<div id="tit"><a v-bind:href="'getTopic/'+top.id" target="_blank"><h6>{{top.title}}</h6></a><br/></div>
					<div id="time"><span style="color:gray;">{{top.sendTime}}</span></div>
					<div id="userName"><a  v-bind:href="'getUserCus/'+top.user.id">{{top.user.nickName}}</a></div>
					<div id="text">{{top.text | formatText}}</div>
					<div id="readed">
						<a href="javascript:void(0)" class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon" style="color:green"></i>评论({{top.readNum}})</a>
						<a v-bind:href="'getTopic/'+top.id" target="_blank" class="layui-btn layui-btn-normal layui-btn-sm"><i class="layui-icon" style="color:gray"></i>阅读({{top.readNum}})</a>
					</div>
					<br><br><hr style="margin:0px;margin-top:50px;"/>
				</div>
			</div>
			<div id="pages" style="margin-top:15px;">
				<div style="width:300px;height:27px;margin:0 auto;overflow:hidden;">
					<a href="javascript:void(0)" v-on:click="getPage(1)" class="easyui-linkbutton">首页</a>
					<a href="javascript:void(0)" id="start" v-on:click="getPage(nowPage-1)" class="easyui-linkbutton" style="margin:0px 3px;">上一页</a>
					<a v-for="p in pageNum" :class="{'page':setStyle(start+p-1)}" style="width:20px;display:block;text-align:center;margin-top:2px;">{{start+p-1}}</a>
					<a href="javascript:void(0)" id="end" v-on:click="getPage(nowPage+1)" class="easyui-linkbutton" style="margin:0px 3px;">下一页</a>
					<a href="javascript:void(0)" v-on:click="getPage(pagesNum)" class="easyui-linkbutton">尾页</a>
				</div>																																																																																							
			</div>
			<div id="bottomCtx">
			</div>
		</div>
		<div style="clear:both;"></div>
	</div>
	<script type="text/javascript">
	layui.use(['carousel', 'form'], function(){
		  var carousel = layui.carousel
		  form = layui.form;
		  carousel.render({
		    elem: '#imgs'
		    ,width: '75%'
		    ,height: '350px'
		    ,interval: 4000
		  });
		  carousel.render({
			    elem: '#ad'
			    ,width: '99%'
			    ,height: '260px'
			    ,interval: 4000
			  });
		});
</script>
	<script type="text/javascript">
		new Vue({
			el:'#globleCtx',
			data:{
				topics: ${pages.pageTops},
				pagesNum: ${pages.pageNum},
				pageNum: ${pages.pageNum}>5?5:${pages.pageNum},
				nowPage: 1,
				start: 1,
				end: 5,
				sendUrl: ${user==null}?'logreg':'toadd'
			},
			methods:{
				getPage: function(nowPage){
					if(nowPage>=1 && nowPage<=this.pagesNum){
						this.nowPage=nowPage
						
						if(this.pagesNum>5){
							this.judPage(nowPage)
						}
						this.disabled()
						var temp=this
					 	$.post("soPage",{"nowPage":nowPage},function(data){
					 		temp.topics=data
						},"json")
					}
				},
				disabled: function(){
					if(this.nowPage==1){
						$("#start").css("color","#ADADAD");
					}else{
						$("#start").css("color","#007bff");
					}
					if(this.nowPage==this.pagesNum){
						$("#end").css("color","#ADADAD");
					}else{
						$("#end").css("color","#007bff");
					}
				},
				setStyle: function(page){
					return this.nowPage==page?true:false
				},
				judPage: function(nowPage){
					if(nowPage>this.end){
						if(nowPage>=this.pagesNum-4){
							this.start=this.pagesNum-this.pagesNum%5+1
							this.pageNum=this.pagesNum%5
							this.end=this.pagesNum
						}else{
							this.pageNum=5
							this.start=this.end+1
							this.end=nowPage+4
						}
					}
					if(nowPage<this.start){
						this.pageNum=5
						if(nowPage-4<=0){
							this.start=1
							this.end=5
						}else{
							this.start=nowPage-4
							this.end=nowPage
						}
					}
				},
				isHave:function(){
					if(this.topics.length<=0){
						return true
					}else{
					return false
					}
				}
				
			},
			created: function(){
				this.disabled()
			},
			filters: {
				formatText(text){
					var reg=new RegExp(/\<p\>([\w\s\.\u4e00-\u9fa5]+)\<\/p\>/g)
					text=reg.exec(text)
					text=text[1].substring(0,155)
					text+=" ..."
					return text
				}
			}
		})
	</script>
</body>
</html>