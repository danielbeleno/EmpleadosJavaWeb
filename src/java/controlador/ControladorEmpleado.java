package controlador;

import dao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;

public class ControladorEmpleado extends HttpServlet {

    Empleado e;
    EmpleadoDAO eDAO = new EmpleadoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        String nombre, cedula, fecha_cumple, cargo;
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "Listar":
                    out.print(eDAO.listar());
                    break;
                case "Registrar":
                    nombre = request.getParameter("nombre");
                    cedula = request.getParameter("cedula");
                    fecha_cumple = request.getParameter("fecha_cumple");
                    cargo = request.getParameter("cargo");
                    e = new Empleado(nombre, cedula, fecha_cumple, cargo);
                    out.print(eDAO.registrar(e));
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    out.print(eDAO.eliminar(id));
                    break;
                case "Editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    out.print(eDAO.getEmpleado(id));
                    break;
                case "Guardar":
                    id = Integer.parseInt(request.getParameter("id"));
                    nombre = request.getParameter("nombre");
                    cedula = request.getParameter("cedula");
                    fecha_cumple = request.getParameter("fecha_cumple");
                    cargo = request.getParameter("cargo");
                    e = new Empleado(nombre, cedula, fecha_cumple, cargo);
                    out.print(eDAO.editar(e, id));
                    break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
