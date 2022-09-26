package capaLogica;

public class Coordenada {

    protected double x;
    protected double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "Latitud=" + x +
                ", Longitud=" + y +
                '}';
    }
}
