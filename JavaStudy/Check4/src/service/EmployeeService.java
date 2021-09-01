package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.EmployeeBean;

/**
 * ・社員情報検索サービス
 */

public class EmployeeService {

  // 問① 接続情報を記述してください
 /** ドライバーのクラス名 */
 private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
 /** ・JDMC接続先情報 */
 private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee_db";
 /** ・ユーザー名 */
 private static final String USER = "postgres";
 /** ・パスワード */
 private static final String PASS = "postgres";
 /** ・タイムフォーマット */
 private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

  // 問② 入力された値で、UPDATEする文
 /** ・SQL UPDATE文 */
 private static final String SQL_UPDATE = "update employee_table set login_time=? where id=?";

  // 問③ 入力されたIDとPassWordをキーにして、検索するSELECT文
 /** ・SQL SELECT文 */
 private static final String SQL_SELECT = "select * from employee_table where id=? and password=?";

 EmployeeBean employeeDate = null;

  // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド
 public EmployeeBean search(String id, String password) {

 Connection connection = null;
 Statement statement = null;
 ResultSet resultSet = null;
 PreparedStatement preparedStatement = null;

 try {
  // データベースに接続
 Class.forName(POSTGRES_DRIVER);
 connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
 statement = connection.createStatement();
 /*静的SQL文を実行し、作成された結果を返すために使用されるオブジェクトです。*/

  // 処理が流れた時間をフォーマットに合わせて生成
 Calendar cal = Calendar.getInstance(); 
 /*Calendarクラスの中のgetInstanceメソッドを使って日時を取得する。cal変数に格納する*/
 SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);
 /*TIME_FORMATに従って表示する
  * 取得した時間を国、地域によって設定し表示させる*/

  // PreparedStatementで使用するため、String型に変換
 String login_time = sdFormat.format(cal.getTime());

 /*
 * 任意のユーザーのログインタイムを更新できるように、プリペアドステートメントを記述。
 */

  // preparedStatementに実行したいSQLを格納
 preparedStatement = connection.prepareStatement(SQL_UPDATE);
 /*PreparedStatementインタフェース*/
  // 問④ preparedStatementを使って、一番目のindexに今の時間をセットしてください。2番目のindexにIDをセットしてください。
 preparedStatement.setString(1, login_time);
 /*第１引数の意味は１番目の？に対応するもの（login_timeをさす）、第１引数の意味は値を示す
  * 指定されたパラメータを指定されたJavaのString値に設定します。*/
 preparedStatement.setString(2, id);
  // 問⑤ UPDATEを実行する文を記述
 preparedStatement.executeUpdate();
 /*PreparedStatementインタフェースのexecuteUpdateメソッドを使って指定されたSQLを実行し，更新行数を返します。
*/
 /*
 * UPDATEが成功したものを即座に表示
 * 任意のユーザーを検索できるように、プリペアドステートメントを記述。
 */
 preparedStatement = connection.prepareStatement(SQL_SELECT);
  //問⑥ 一番目のindexにIDをセットしてください。2番目のindexにPASSWORDをセット。
 preparedStatement.setString(1, id);
 preparedStatement.setString(2, password);
  // SQLを実行。実行した結果をresultSetに格納。
 resultSet = preparedStatement.executeQuery();
 /*引数で指定されたSQLをデータベースで実行し、resultSetに返す*/

 while (resultSet.next()) {
  // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。
 String tmpName = resultSet.getString("name");
 /*ResultSetオブジェクトの現在行の列の値を，Javaプログラミング言語のStringで取得*/
 String tmpComment = resultSet.getString("comment");
 String tmpLoginTime = resultSet.getString("login_time");

  // 問⑧ EmployeeBeanに取得したデータを入れてください。
 employeeDate = new EmployeeBean();
 employeeDate.setName(tmpName);
 employeeDate.setComment(tmpComment);
 employeeDate.setLogin_Time(tmpLoginTime);
 /*SQL値をEmployeeControllerに返却する*/
 }

  // forName()で例外発生
 } catch (ClassNotFoundException e) {
 e.printStackTrace();

  // getConnection()、createStatement()、executeQuery()で例外発生
 } catch (SQLException e) {
 e.printStackTrace();

 } finally {
 try {

 if (resultSet != null) {
 resultSet.close();
 }
 if (statement != null) {
 statement.close();
 }
 if (connection != null) {
 connection.close();
 }

 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 return employeeDate;
 /*EmployeeBean employeeにEmployeeControllerのserachメソッドの返り値を格納する*/
 }
}