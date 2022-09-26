package capaLogica;

public class Departamento {
    private int codigo;
    private String referencia;
    private String direccion;
    private double zonaje;
    private Coordenada coordena;

    public Departamento(int codigo, String referencia, String direccion, double zonaje, Coordenada coordena) {
        this.codigo = codigo;
        this.referencia = referencia;
        this.direccion = direccion;
        this.zonaje = zonaje;
        this.coordena = coordena;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getZonaje() {
        return zonaje;
    }

    public void setZonaje(double zonaje) {
        this.zonaje = zonaje;
    }

    public Coordenada getCoordena() {
        return coordena;
    }

    public void setCoordena(Coordenada coordena) {
        this.coordena = coordena;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codigo=" + codigo +
                ", referencia='" + referencia + '\'' +
                ", direccion='" + direccion + '\'' +
                ", zonaje=" + zonaje +
                ", coordena=" + coordena +
                '}';
    }
}
