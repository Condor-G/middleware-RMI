1 运行RMI程序前，在路径： java安装路径\jre6\lib\security中，找到java.policy文件，
  在末行添加：permission java.security.AllPermission "", ""; 
2 借助于虚拟机，本例子中不需要生成_stub和sktl
3 一般建议生成_stub和sktl。请使用rmic编译远程对象类。
4 较高版本的JDK，rmic编译后只生成_stub,没有sktl
