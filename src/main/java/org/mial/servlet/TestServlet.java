package org.mial.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    private static final String PATH = "/WEB-INF/view/";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("messageTest", System.nanoTime() + "--------");
        request.getRequestDispatcher(PATH + "time.jsp").forward(request, response);
    }
}
