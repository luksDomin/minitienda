package controlador;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Carrito;
import modelo.Pagar;
import modelo.Usuario;

public class Pago extends HttpServlet {
    // Variables privadas a la instancia del Servlet

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        Usuario user = (Usuario) session.getAttribute("user");
        if (user != null) { //si hay un usario que ha iniciado sesion
            //implementar logica (llamar a clase pagar etc)
            Carrito carrito = (Carrito) session.getAttribute("carrito");
            if (carrito != null) {
                float precioFinal = (Float) session.getAttribute("precioFinal");
                Pagar pagar = new Pagar();
                if (pagar.realizarPedido(user.getCorreo(), carrito.getListaDiscos().keySet(), precioFinal)) {
                    //implementar que se enseñe en una nueva pagian el pedido realizado y el mensaje de confirmacion
                    request.setAttribute("carro", carrito);
                    request.setAttribute("pagoFinal", precioFinal);
                    session.removeAttribute("carrito");
                    session.removeAttribute("precioFinal");
                    gotoPage("/vista/pedidoRealizado.jsp", request, response);
                }
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
