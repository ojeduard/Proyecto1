package capaLogica;

public class Empleado extends Persona{

    private String sucursalDeTrabajo;
    private double salarioBase;
    private int telefono;

    public Empleado(String cedula, String nombre, String sucursalDeTrabajo, double salarioBase, int telefono) {
        super(cedula, nombre);
        this.sucursalDeTrabajo = sucursalDeTrabajo;
        this.salarioBase = salarioBase;
        this.telefono = telefono;
    }

    public String getSucursalDeTrabajo() {
        return sucursalDeTrabajo;
    }

    public void setSucursalDeTrabajo(String sucursalDeTrabajo) {
        this.sucursalDeTrabajo = sucursalDeTrabajo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Sucursal='" + sucursalDeTrabajo + '\'' +
                ", salarioBase=" + salarioBase +
                ", telefono=" + telefono +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
