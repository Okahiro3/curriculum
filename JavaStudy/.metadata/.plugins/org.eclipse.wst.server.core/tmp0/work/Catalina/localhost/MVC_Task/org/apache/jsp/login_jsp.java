/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-08-27 11:41:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Objects;
import java.util.List;
import java.util.function.Function;
import skillcheck.bean.ResponseBean;
import skillcheck.bean.EmployeeBean;
import skillcheck.logger.Logger;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Objects");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("skillcheck.bean.ResponseBean");
    _jspx_imports_classes.add("skillcheck.bean.EmployeeBean");
    _jspx_imports_classes.add("java.util.function.Function");
    _jspx_imports_classes.add("skillcheck.logger.Logger");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
      return;
    }

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    //リクエストより社員番号を取得: 関数型インターフェース（ラムダ式）
    Function<HttpServletRequest, Object[]> rmdGetResponseInfo = (rmdRequest) -> {
        // request: responseBean
        ResponseBean rb = (ResponseBean) request.getAttribute("responseBean");
        int requestStatus = 0;
        String message = "";
        String empId = "";
        if (Objects.nonNull(rb)) {
            requestStatus = rb.getRequestStaus();
            message = rb.getMessage();
            EmployeeBean emp = rb.getEmplyeeBeanList().stream().findFirst().orElse(null);
            if (Objects.nonNull(emp)) empId = emp.getEmpId();
        }
        return new Object[]{requestStatus, message, empId};
    };

    ResponseBean responseBean = null;
    // エラーメッセージ表示用
    String message = "";
    int requestStatus = 0;
    String empId = "";

    try {
        if (Objects.isNull(session) || session.isNew()) {
            Logger.log(new Throwable(), "セッションなし");
            Object[] objects = rmdGetResponseInfo.apply(request);
            requestStatus = (int) objects[0];
            message = (String) objects[1];
            empId = (String) objects[2];
        } else {
            Logger.log(new Throwable(), "セッションあり");
            // session: redirect
            final String redirect = (String) session.getAttribute("redirect");
            if (Objects.nonNull(redirect)) {
                Logger.log(new Throwable(), "redirect = " + redirect);
                message = redirect;
                session.invalidate();
            }

            if (requestStatus < 2 && message.isEmpty()) {
                // ログインエラー時
                ResponseBean rb = (ResponseBean) session.getAttribute("responseBean");
                if (Objects.nonNull(rb)) {
                    requestStatus = rb.getRequestStaus();
                    message = rb.getMessage();
                    EmployeeBean emp = rb.getEmplyeeBeanList().stream().findFirst().orElse(null);
                    if (Objects.nonNull(emp)) {
                        empId = emp.getEmpId();
                    }
                }
            }
            Logger.log(new Throwable(), "message = " + message);
        }
    } catch (Exception e) {
        Logger.log(new Throwable(), e);
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<!-- FIXME Step-1-1: login.jspに適用するcssファイルのリンクタグを記述しなさい。-->\n");
      out.write("<!-- Tips1: common.css、login.cssの2つを適用-->\n");
      out.write("<!-- Tips2: 適用するcssファイルのパスの書き方に注意 -->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/login.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/common.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"/></script>\n");
      out.write("<title>ログイン</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <input id=\"hiddenDialog\" type=\"hidden\" value=\"");
      out.print(requestStatus == 2 ? message : "");
      out.write("\"></input>\n");
      out.write("    <h2>ログイン</h2>\n");
      out.write("    <div class=\"div-login-form\">\n");
      out.write("        ");
 if (requestStatus < 2 && !message.isEmpty()) { 
      out.write("\n");
      out.write("            <!-- FIXME Step-1-2: 以下の手順に沿って適当な処理を記述しなさい。 -->\n");
      out.write("            <!-- 1. エラー（message）表示時に使用するlabelタグの準備-->\n");
      out.write("            <!-- 2. class属性と、適用するスタイルの記述-->\n");
      out.write("            <!-- Tips: common.cssより赤色の文字色を定義しているスタイルを確認 -->\n");
      out.write("            <!-- [ここへ記述] -->\n");
      out.write("            <label for=\"error-label\">該当する社員情報がありません</label>\n");
      out.write("            <br>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <!-- FIXME Step-1-3: actionに送信先URIを記述しなさい。 -->\n");
      out.write("        <!-- Tips: 「/このプロジェクト/web.xmlに記述されているservlet-name」 -->\n");
      out.write("        <form action=\"/MVC_Task/employee\" method=\"post\">\n");
      out.write("            <div class=\"div-input-flex-area\">\n");
      out.write("                <div>\n");
      out.write("                    <label>社員番号　: </label>\n");
      out.write("                    <input id=\"empId\" type=\"text\" name=\"empId\" maxlength=\"5\" value=\"");
      out.print(empId);
      out.write("\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <label>パスワード: </label>\n");
      out.write("                    <input id=\"password\" type=\"password\" name=\"password\"><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"div-button-area\">\n");
      out.write("                <input type=\"hidden\" name=\"sender\" value=\"/login.jsp\"></input>\n");
      out.write("                <button id=\"btn-login\" class=\"btn-login\" name=\"requestType\" value=\"login\">ログイン</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
