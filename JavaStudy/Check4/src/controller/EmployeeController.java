package controller;
/**
 * 社員情報管理コントローラー
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeBean;
import service.EmployeeService;

public class EmployeeController extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {

 try {
  // 問① index.htmlから送信されたIDとPassWordの値を取得できるように修正しましょう。
 String id = request.getParameter("id");
 String password = request.getParameter("password");
 /*ユーザーからの入力情報をパラメーターとして受け取る*/

 /*
 * IDとPassWordと元に、社員情報を検索する関数の呼び出し、結果をJSPに渡す処理
 * ※ EmployeeBeanとEmployeeServiceをimportするのを忘れないでください。
 */
  // 問② EmployeeServiceクラスをインスタンス化する。
 EmployeeService employeeService = new EmployeeService();
  // 問③ EmployeeBeanに、EmployeeServiceよりsearch関数を呼び出し、返り値を格納する。
 EmployeeBean employee = employeeService.search(id, password);
 /*社員情報を問い合わせするためにEmployeeServiceのsearchメソッドを実行する
  * 24,25行目で処理されたパラメータの情報を元に*/
  // 問④ nullの部分に適切な引数をセットする。
 request.setAttribute("EmployeeBean", employee);
 /*jspに返す準備
  * キー：EmployeeBean
  * 値：employee（値格納済み）*/

 } catch (Exception e) {
 e.printStackTrace();
 } finally {/*サーブレット・・Java上でサーバー実行するためのプログラム*/
 ServletContext context = this.getServletContext();
 /*Java上でサーバーを実行させる*/
 RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
 /*渡したいjspを指定*/
 /*サーブレットからJSPを表示するためのインターフェイス。*/
 dispatcher.forward(request, response);
 }
 }

}