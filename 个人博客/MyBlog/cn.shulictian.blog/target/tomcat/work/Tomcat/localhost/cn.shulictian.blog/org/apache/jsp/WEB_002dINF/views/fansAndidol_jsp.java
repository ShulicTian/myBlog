/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-03-14 09:58:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shulictian.ssm.po.*;

public final class fansAndidol_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "resources.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div style=\"background-color: #f5f6f7;\">\r\n");
      out.write("\t\t<div id=\"globleCtx\">\r\n");
      out.write("\t\t\t<div style=\"height: 820px; background-color: white;\">\r\n");
      out.write("\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100%; height: 50px; border: 1px solid; margin-bottom: 30px;\"></div>\r\n");
      out.write("\t\t\t\t<div v-if=\"users==null|users==''\">此处还没有内容，您可以发表文章吸引粉丝，或关注博主成为粉丝!</div>\r\n");
      out.write("\t\t\t\t<div v-for=\"user in users\"\r\n");
      out.write("\t\t\t\t\tstyle=\"padding: 15px 30px; padding-bottom: 0px;\"\r\n");
      out.write("\t\t\t\t\t@click=\"toPage('bigCow/user/getUserCus/'+user.id)\">\r\n");
      out.write("\t\t\t\t\t<div id=\"photo\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"border: 1px solid; width: 50px; height: 50px; display: inline; float: left; margin-bottom: 5px;\">\r\n");
      out.write("\t\t\t\t\t\t<img :src=\"'img/'+user.nickName+'.jpg'\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"name\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"float: left; display: inline; margin-left: 15px;\">\r\n");
      out.write("\t\t\t\t\t\t<a id=\"userName\" style=\"text-align: left;\"\r\n");
      out.write("\t\t\t\t\t\t\tv-bind:href=\"'getUserCus/'+user.id\" target=\"_blank\">{{user.nickName}}</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<hr style=\"margin: 0px;\" />\r\n");
      out.write("\t\t\t\t\t<div style=\"clear: both;\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"fansPaging\" style=\"text-align: center;\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"clear: both;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write(" \tlayui.use(['carousel', 'element','laypage'], function(){\r\n");
      out.write("\t\t  var carousel = layui.carousel,\r\n");
      out.write("\t\t  \t  laypage = layui.laypage,\r\n");
      out.write("\t\t  \t  element = layui.element;\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  laypage.render({\r\n");
      out.write("\t\t\t    elem: 'fansPaging'\r\n");
      out.write("\t\t\t    ,count: app.count\r\n");
      out.write("\t\t\t    ,limit: app.limit\r\n");
      out.write("\t\t\t    ,theme: '#1E9FFF'\r\n");
      out.write("\t\t\t    ,jump: function(obj, first){\r\n");
      out.write("\t\t\t    \tvar url = 'bigCow/paging/fans'\r\n");
      out.write("\t\t\t    \tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jud}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'!=\"fans\"){\r\n");
      out.write("\t\t\t    \t\turl = 'bigCow/paging/atts'\r\n");
      out.write("\t\t\t    \t}\r\n");
      out.write("\t\t\t    \t $.post(url,{'nowPage':obj.curr,\"userId\":");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("},function(data){\r\n");
      out.write("\t\t\t\t\t\t\tapp.conts=JSON.parse(data.data.users)\r\n");
      out.write("\t\t\t\t\t\t},'json')\r\n");
      out.write("\t\t\t     }\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t}); \r\n");
      out.write("</script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar app=new Vue({\r\n");
      out.write("\t\t\tel:'#globleCtx',\r\n");
      out.write("\t\t\tdata:{\r\n");
      out.write("\t\t\t\tusers: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pages.pageJSON}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("\t\t\t\tcount: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pages.allNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("\t\t\t\tlimit: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pages.nowPageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmethods:{\r\n");
      out.write("\t\t\t\ttoPage:function(href){\r\n");
      out.write("\t\t\t\t\t/* window.open(href) */\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tcreated: function(){\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tfilters: {\r\n");
      out.write("\t\t\t\tformatText(text){\r\n");
      out.write("\t\t\t\t\tvar reg=new RegExp(/\\<p\\>([\\w\\s\\.\\u4e00-\\u9fa5]+)\\<\\/p\\>/g)\r\n");
      out.write("\t\t\t\t\ttext=reg.exec(text)\r\n");
      out.write("\t\t\t\t\ttext=text[1].substring(0,155)\r\n");
      out.write("\t\t\t\t\ttext+=\" ...\"\r\n");
      out.write("\t\t\t\t\treturn text\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
