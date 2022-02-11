package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Conexion;
import modelo.Empleado;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmpleadoDAO {

    private String query;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection cn;
    private final Conexion conexion;

    public EmpleadoDAO() {
        conexion = new Conexion();
        cn = conexion.conectar();
    }

    public boolean registrar(Empleado emp) {
        boolean result;
        query = "INSERT INTO EMPLEADOS (NOMBRE, CEDULA, FECHA_CUMPLE, CARGO) VALUES (?, ?, ?, ?)";
        try {
            pst = cn.prepareStatement(query);
            pst.setString(1, emp.getNombre());
            pst.setString(2, emp.getCedula());
            pst.setString(3, emp.getFecha_cumple());
            pst.setString(4, emp.getCargo());
            result = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }

    public JSONArray listar() {
        JSONObject obj;
        JSONArray lista = new JSONArray();
        query = "SELECT * FROM EMPLEADOS";
        try {
            cn = conexion.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String cedula = rs.getString(3);
                String fecha_cumple = rs.getString(4);
                String cargo = rs.getString(5);
                Empleado e = new Empleado(nombre, cedula, fecha_cumple, cargo);
                e.setId(id);
                obj = new JSONObject();
                obj.put("id", e.getId());
                obj.put("nombre", e.getNombre());
                obj.put("cedula", e.getCedula());
                obj.put("fecha_cumple", e.getFecha_cumple());
                obj.put("cargo", e.getCargo());
                lista.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public JSONObject getEmpleado(int id) {
        JSONObject empleado = null;
        query = "SELECT * FROM EMPLEADOS WHERE ID = ?";
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString(2);
                String cedula = rs.getString(3);
                String fecha_cumple = rs.getString(4);
                String cargo = rs.getString(5);
                Empleado e = new Empleado(nombre, cedula, fecha_cumple, cargo);
                e.setId(id);
                empleado = new JSONObject();
                empleado.put("id", e.getId());
                empleado.put("nombre", e.getNombre());
                empleado.put("cedula", e.getCedula());
                empleado.put("fecha_cumple", e.getFecha_cumple());
                empleado.put("cargo", e.getCargo());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return empleado;
    }

    public boolean editar(Empleado emp, int id) {
        boolean result;
        query = "UPDATE EMPLEADOS SET NOMBRE = ?, CEDULA = ?, FECHA_CUMPLE = ?, CARGO = ? WHERE ID = ?";
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(query);
            pst.setString(1, emp.getNombre());
            pst.setString(2, emp.getCedula());
            pst.setString(3, emp.getFecha_cumple());
            pst.setString(4, emp.getCargo());
            pst.setInt(5, id);
            result = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }

    public boolean eliminar(int id) {
        boolean result;
        query = "DELETE FROM EMPLEADOS WHERE ID = ?";
        try {
            cn = conexion.conectar();
            pst = cn.prepareStatement(query);
            pst.setInt(1, id);
            result = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }
}
