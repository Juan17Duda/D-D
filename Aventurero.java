public class Aventurero {
    private String nombre;
    private int puntoDeVidaActual;
    private int puntoDeVidaMaximo;
    private int dañoBase;
    public static int curacion=20;
    private int numeroPociones=3;

    public Aventurero(String nombre, int puntoDeVidaMaximo, int dañoBase) {
        this.nombre = nombre;
        this.puntoDeVidaMaximo = puntoDeVidaMaximo;
        this.puntoDeVidaActual = puntoDeVidaMaximo;
        this.dañoBase = dañoBase;
    }

    public void atacar(Enemigo objetivo) {
        objetivo.recibirDaño(dañoBase);
    }

    public void beberPocion() {
        if (numeroPociones>0) {
        puntoDeVidaActual += curacion;
        if (puntoDeVidaActual > puntoDeVidaMaximo) {
            puntoDeVidaActual = puntoDeVidaMaximo;
        }
        numeroPociones--;
    }else{
        System.out.println("NO TIENES POCIONES DESGRACIO");
    }
    }


    public void recibirDaño(int daño) {
        puntoDeVidaActual -= daño;
        if (puntoDeVidaActual < 0) {
            puntoDeVidaActual = 0;
        }
    }

    public boolean estaDerrotado() {
        boolean derrotado=false;
       if (puntoDeVidaActual<=0) {
         derrotado=true;
       }
       return derrotado;
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
    public int getNumeroPociones() {
        return numeroPociones;
    }
    
}
