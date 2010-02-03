package com.roadrantz.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class Log4jInit extends HttpServlet {

	protected final Log logger = LogFactory.getLog(getClass());
	
  public
  void init() {
    String prefix =  getServletContext().getRealPath("/");
    String file = getInitParameter("log4j-init-file");
    // if the log4j-init-file is not set, then no point in trying
    if(file != null) {
    	PropertyConfigurator.configure(prefix+file);
    }
    logger.info("log4j initialized");
  }

  public
  void doGet(HttpServletRequest req, HttpServletResponse res) {
  }
}

