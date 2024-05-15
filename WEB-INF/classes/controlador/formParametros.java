package controlador;

import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Carrito;

public class formParametros extends HttpServlet {
    // Variables privadas a la instancia del Servlet

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Generamos un objeto sesion
        HttpSession session = request.getSession(true);

        // Generamos un objeto para el contexto de la aplicacion
        ServletContext context = getServletContext();

        // Almacenamos los parametros de entrada en variables temporales
        String disco = request.getParameter("cd");
        String cantidad = request.getParameter("cantidad");
        String[] cdsAEliminar = request.getParameterValues("eliminar");

        // Recuperamos sumaSesion de la sesion y si no existe, creamos este atributo
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            System.out.println("carrito es null");

            // Inicializamos el atributo sumaSesion
            session.setAttribute("carrito", new Carrito());

            carrito = (Carrito) session.getAttribute("carrito");
        }

        HashMap<String, Float[]> listaDiscos = carrito.getListaDiscos();

        //si disco y cantidad son null significa que se ha eliminado un cd
        if (disco != null && cantidad != null) {
            Float cantidadParseada = Float.parseFloat(cantidad);
            //obtenemos el precio del disco
            int indiceDolar = disco.lastIndexOf('$');
            String precioDolares = disco.substring(indiceDolar + 1).trim();
            Float precio = Float.parseFloat(precioDolares);

            if (!listaDiscos.isEmpty() && listaDiscos.containsKey(disco)) {

                Float[] valores = listaDiscos.get(disco);
                valores[0] += cantidadParseada;

                float precioFinal = 0F;
                if (precioDolares != null) {
                    precioFinal = precio * valores[0];
                }

                valores[1] = precioFinal;
                listaDiscos.replace(disco, valores);
            } else {

                carrito.setDisco(disco, cantidadParseada, precio);

            }
        } else { //si eran null la unica posibilidad es que se haya seleccionado eliminar un cd:

            // Verificar si se seleccionaron CDs para eliminar
            if (cdsAEliminar != null && cdsAEliminar.length > 0) {
                // Eliminar los CDs seleccionados de la lista de CDs en el carrito
                for (String cd : cdsAEliminar) {
                    float numCds = listaDiscos.get(cd)[0];

                    if (numCds <= 0) {
                        carrito.removeDisco(cd);
                    } else {
                        Float[] cD = listaDiscos.get(cd);
                        float precioUnidad = cD[1] / cD[0]; //con esto obtengo el precio de un disco
                        cD[0] = numCds - 1;
                        cD[1] = precioUnidad * cD[0];

                        listaDiscos.replace(cd, cD);
                    }

                }
            }
        }
        
        //finalmente se calcula el precio final y se setean los atributos de la sesion
        session.setAttribute("precioFinal", carrito.calcularPrecio());
        session.setAttribute("carrito", carrito);

        gotoPage("/vista/vista.jsp", request, response);
    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creamos objeto RequestDispatcher
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(
                address);
        dispatcher.forward(request, response);

    }
}
