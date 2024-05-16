package controlador;

import modelo.InicioSesion;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Usuario;

public class Login extends HttpServlet {
    // Variables privadas a la instancia del Servlet

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String iniciar = request.getParameter("iniciar");
        String cerrar = request.getParameter("cerrar");

        Usuario user = (Usuario) session.getAttribute("user");
        if (user != null) {
            if (cerrar != null) {
                session.removeAttribute("user");
                gotoPage("/vista/carrito.jsp", request, response);
            } else {
                gotoPage("/vista/caja.jsp", request, response);
            }
        } else {
            gotoPage("/vista/login.jsp", request, response);
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
