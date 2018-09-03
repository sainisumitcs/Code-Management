package com.action.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.http.HttpStatus;

import com.action.config.Config;

public class HandleHttpRequest extends HttpServlet {

    private static Logger logger = LogManager.getLogger(HandleHttpRequest.class);
    private static final long serialVersionUID = 1L;

    String userInfo = null;
 
    String result = "";
    int i = 1;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //userInfo = req.getRequestURL().toString();
    	userInfo = req.getParameter(userInfo);
        System.out.println("request,"+userInfo);
 
        String res = getResponse();

        resp.setStatus(HttpStatus.OK_200);
        resp.getWriter().println(res);

    }

    public String getResponse() {

    	String response = null;
        try {
        	response = "{\"msisdn\":\"8800773917\"}";
        }

        catch (Exception e) {
            logger.error("Exception ocurred while request  process,URL is " + userInfo + "  exception "
                    + e.getMessage());
        }
        return response;

    }

 
}
