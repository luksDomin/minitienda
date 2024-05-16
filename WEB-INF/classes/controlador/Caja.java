package controlador;

import modelo.InicioSesion;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Usuario;

public class Caja extends HttpServlet {
    // Variables privadas a la instancia del Servlet

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        String correoLog = request.getParameter("correoLogin");
        String passwordLog = request.getParameter("passwordLogin");

        if (correoLog != null && passwordLog != null) {
            InicioSesion login = new InicioSesion(correoLog, passwordLog);
            if (login.iniciarSesion()) {
                Usuario useraux = new Usuario();
                useraux.setCorreo(correoLog);
                useraux.setPasswd(passwordLog);

                session.setAttribute("user", useraux);

                gotoPage("/vista/caja.jsp", request, response);
            } else {
                request.setAttribute("Error", "Nombre de usuario o contraseña incorrectos");
                gotoPage("/vista/login.jsp", request, response);
            }
        } else {

            String correoReg = request.getParameter("correoReg");
            String passwordReg = request.getParameter("passwordReg");
            String tarjeta = request.getParameter("tarjeta_credito");
            String tipo = request.getParameter("tipo_tarjeta");
            if (correoReg != null && passwordReg != null) {
                InicioSesion register = new InicioSesion(correoReg, passwordReg, tarjeta, tipo);
                if (register.realizarRegistro()) {
                    Usuario useraux = new Usuario();

                    useraux.setCorreo(correoReg);
                    useraux.setPasswd(passwordReg);

                    session.setAttribute("user", useraux);
                    gotoPage("/vista/caja.jsp", request, response);
                } else {
                    request.setAttribute("Error", "Nombre de usuario ya en uso");
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
