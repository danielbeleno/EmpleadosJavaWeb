package modelo;

public class Empleado {

    private int id;
    private String nombre;
    private String cedula;
    private String fecha_cumple;
    private String cargo;

    public Empleado(String nombre, String cedula, String fecha_cumple, String cargo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fecha_cumple = fecha_cumple;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha_cumple() {
        return fecha_cumple;
    }

    public void setFecha_cumple(String fecha_cumple) {
        this.fecha_cumple = fecha_cumple;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
