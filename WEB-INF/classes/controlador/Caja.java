package controlador;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Set;

public class Caja extends HttpServlet {
    // Variables privadas a la instancia del Servlet

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        gotoPage("/vista/caja.jsp", request, response);
    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creamos objeto RequestDispatcher
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
                address);
        dispatcher.forward(request, response);

    }
}
