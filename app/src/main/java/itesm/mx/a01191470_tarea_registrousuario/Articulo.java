package itesm.mx.a01191470_tarea_registrousuario;

/**
 * Created by hugo on 9/15/15.
 */
public class Articulo {
    private int numSerie;
    private String nombre;
    private int ctd;
    private double price;
    private int articuloFotoId;


    public Articulo(int numSerie, String nombre, int ctd, double price, int articuloFotoId) {
        this.numSerie = numSerie;
        this.nombre = nombre;
        this.ctd = ctd;
        this.price = price;
        this.articuloFotoId = articuloFotoId;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCtd() {
        return ctd;
    }

    public double getPrice() {
        return price;
    }

    public int getArticuloFotoId() {return articuloFotoId;}

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCtd(int ctd) {
        this.ctd = ctd;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setArticuloFotoId(int articuloFotoId) {
        this.articuloFotoId = articuloFotoId;
    }
}
