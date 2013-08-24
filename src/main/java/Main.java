import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;


public class Main {

	public static void main(String[] args)  throws Exception{
		String appBase = "/"; 
		Integer port = Integer.valueOf(8342);

		  Tomcat tomcat = new Tomcat();
		  tomcat.setPort(port);

		  tomcat.setBaseDir(".");
		  //tomcat.getHost().setAppBase("D:\\sideModule\\CMS\\WEB\\WebContent");
		  tomcat.getHost().setAppBase("src\\main\\webapp");
		  tomcat.noDefaultWebXmlPath();
		  String contextPath = "/phoenix";

		  // Add AprLifecycleListener
		  StandardServer server = (StandardServer)tomcat.getServer();
		  AprLifecycleListener listener = new AprLifecycleListener();
		  server.addLifecycleListener(listener);

		  tomcat.addWebapp(contextPath, appBase);
		  tomcat.start();
		  tomcat.getServer().await();
	}

}
