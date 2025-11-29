package org.example;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Mini Projet DevOps</title></head>");
        out.println("<div style='margin-top: 30px; padding: 20px; background-color: #f0f0f0;'>");
        out.println("<h3 style='color: purple;'>Nouvelle Fonctionnalité !!</h3>");
        out.println("<p>✅ Branch: new_feature</p>");
        out.println("<p>✅ Date: " + new java.util.Date() + "</p>");
        out.println("</div>");
        out.println("<body style='text-align: center; margin-top: 100px; font-family: Arial;'>");
        out.println("<h1 style='color: blue;'>🚀 Mini Projet DevOps Réussi!</h1>");
        out.println("<h2 style='color: green;'>Hello Nawres!! 👋</h2>");
        out.println("<p>Application déployée avec Jenkins + Tomcat</p>");
        out.println("</body>");
        out.println("</html>");
    }
}