public class Enemigo {
    private String nombre;
    private int puntoDeVidaActual;
    private int puntoDeVidaMaximo;
    private int dañoBase;

    public Enemigo(String nombre, int puntoDeVidaMaximo, int dañoBase) {
        this.nombre = nombre;
        this.puntoDeVidaMaximo = puntoDeVidaMaximo;
        this.puntoDeVidaActual = puntoDeVidaMaximo;
        this.dañoBase = dañoBase;
    }

    public void recibirDaño(int daño) {
        puntoDeVidaActual -= daño;
        if (puntoDeVidaActual < 0) {
            puntoDeVidaActual = 0;
        }
    }

    public boolean estaDerrotado() {
        return puntoDeVidaActual <= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntoDeVidaActual() {
        return puntoDeVidaActual;
    }

    public int getPuntoDeVidaMaximo() {
        return puntoDeVidaMaximo;
    }

    public int getDañoBase() {
        return dañoBase;
    }




}
