package com.nuance.jettyDemo.action.HTTP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.http.HttpStatus;

public class HandleHttpRequest extends HttpServlet {

    private static Logger logger = LogManager.getLogger(HandleHttpRequest.class);
    private static final long serialVersionUID = 1L;

    String uri = null;
    String CTN = null;

    String result = "";
    int i = 1;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        uri = req.getRequestURL().toString();
        CTN = req.getParameter("CTN");

        logger.info("Request " + uri + "]  port[ " + req.getServerPort() + "]  CTN [" + CTN + "]");

        if (CTN == null) {

            resp.setStatus(HttpStatus.OK_200);
            resp.getWriter().println("Not Valid Request");
            logger.error("URL is " + uri + ",  port[ " + req.getServerPort() + "]  CTN [" + CTN + "]");
            return;
        }

        // String res = getResponse();

        String res = getRoundRobinResponse();

        resp.setStatus(HttpStatus.OK_200);
        resp.getWriter().println(res);

    }

    public String getResponse() {

        try {

        }

        catch (Exception e) {
            logger.error("Exception ocurred while request  process,URL is " + uri + " CTN [" + CTN + "]  exception "
                    + e.getMessage());
        }
        return Config.getXmlRessponse();

    }

    public String getRoundRobinResponse() {

        if (i == 8) {

            i = 1;

        }

        else {

            result = MainEntryjetty.map.get(i);

            i++;

        }

        return result;

    }

}
