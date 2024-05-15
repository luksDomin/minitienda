package controlador;

import modelo.InicioSesion;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Caja extends HttpServlet {
    // Variables privadas a la instancia del Servlet

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String usernameLog = request.getParameter("usernameLogin");
        String passwordLog = request.getParameter("passwordLogin");

        if (usernameLog != null && passwordLog != null) {
            InicioSesion login = new InicioSesion(usernameLog, passwordLog);
            if (login.iniciarSesion()) {
                gotoPage("/vista/caja.jsp", request, response);
            } else {
                gotoPage("/vista/login.jsp", request, response);
            }
        } else {
            String usernameReg = request.getParameter("usernameReg");
            String passwordReg = request.getParameter("passwordReg");
            if (usernameReg != null && passwordReg != null) {
                InicioSesion register = new InicioSesion(usernameReg, passwordReg);
                if (register.realizarRegistro()) {
                    gotoPage("/vista/caja.jsp", request, response);
                } else {
                    gotoPage("/vista/registro.jsp", request, response);
                }
            }
        }

    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creamos objeto RequestDispatcher
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
                address);
        dispatcher.forward(request, response);

    }
}
