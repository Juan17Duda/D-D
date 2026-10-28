
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Mazmorra {

    private static final Scanner scanner = new Scanner(System.in);
   

    private static int tirarDado20() {
        Random dado = new Random();
        return dado.nextInt(20) + 1;
    }

    // Solicita un número entero y controla los errores de entrada.
    private static int leerOpcion() {
        while (true) {
            try {
                System.out.print("Opción: ");
                String entrada = scanner.nextLine();
                int opcion = Integer.parseInt(entrada);

                if (opcion == 1 || opcion == 2) {
                    return opcion;
                }

                System.out.println("¡Opción inválida!");
                System.out.println(
                    "Introduce 1 para atacar o 2 para beber una poción."
                );

            } catch (NumberFormatException e) {
                System.out.println("¡Entrada incorrecta!");
                System.out.println(
                    "Debes introducir un número entero: 1 o 2."
                );
            }

            System.out.println("Vuelve a intentarlo.");
        }
    }

    public static void main(String[] args) {

        Aventurero aventurero = new Aventurero("JOTAPE", 100, 20);
        Enemigo enemigo = new Enemigo("Enemigo", 80, 15);

        System.out.println("""
        
███╗   ███╗ █████╗ ███████╗███╗   ███╗ ██████╗ ██████╗ ██████╗  █████╗ 
████╗ ████║██╔══██╗╚══███╔╝████╗ ████║██╔═══██╗██╔══██╗██╔══██╗██╔══██╗
██╔████╔██║███████║  ███╔╝ ██╔████╔██║██║   ██║██████╔╝██████╔╝███████║
██║╚██╔╝██║██╔══██║ ███╔╝  ██║╚██╔╝██║██║   ██║██╔══██╗██╔══██╗██╔══██║
██║ ╚═╝ ██║██║  ██║███████╗██║ ╚═╝ ██║╚██████╔╝██║  ██║██║  ██║██║  ██║
╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝

██████╗ ███████╗██╗         ██████╗ ███████╗███████╗████████╗██╗███╗   ██╗ ██████╗ 
██╔══██╗██╔════╝██║        ██╔═══██╗██╔════╝██╔════╝╚══██╔══╝██║████╗  ██║██╔═══██╗
██║  ██║█████╗  ██║        ██║   ██║███████╗█████╗     ██║   ██║██╔██╗ ██║██║   ██║
██║  ██║██╔══╝  ██║        ██║   ██║██║          ██║   ██║   ██║██║╚██╗██║██║   ██║
██████╔╝███████╗███████╗   ██████ ╔╝███████║███████╗   ██║   ██║██║ ╚████║╚██████╔╝
╚═════╝ ╚══════╝╚══════╝    ╚═════╝ ╚══════╝╚══════╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝

        """);

        System.out.println("""
        
                            / \\  //\\
             |\\___/|      /   \\//  \\\\
             /O  O  \\__  /    //  | \\ \\
            /     /  \\/_/    //   |  \\  \\
            @_^_@'/   \\/_   //    |   \\   \\
            //_^_/     \\/_ //     |    \\    \\
         ( //) |        \\///      |     \\     \\
       ( / /) _|_ /   )  //       |      \\     _\\
     ( // /) '/,_ _ _/  ( ; -.    |    _ _\\.-~        
   (( / / )) ,-{        _      `-.|.-~-.           
  (( // / ))  '/\\      /                 ~-. _
  (( /// ))      `.   {            }                   ___
   (( / ))     .----~-\\        \\-'               .-~´   `~.
              ///.----..>        \\            .-~           |
                ///-._ _ _ _ _ _ _}       .-~               |
                                              

        """);

        do {
            System.out.println("\n==================================");
            System.out.println("Aventurero: " + aventurero.getNombre()
                    + " | Vida: "
                    + aventurero.getPuntoDeVidaActual()
                    + "/" + aventurero.getPuntoDeVidaMaximo());

            System.out.println("Enemigo: " + enemigo.getNombre()
                    + " | Vida: "
                    + enemigo.getPuntoDeVidaActual()
                    + "/" + enemigo.getPuntoDeVidaMaximo());

            System.out.println("==================================");
            System.out.println("Elige una acción:");
            System.out.println("1. Atacar con arma");
            System.out.println("2. Beber poción");

            int opcion = leerOpcion();

            switch (opcion) {

                case 1:
                    int resultadoDado = tirarDado20();

                    System.out.println("Has sacado un "
                            + resultadoDado
                            + " en el dado de 20 caras.");

                    if (resultadoDado == 20) {
                        int danoCritico =aventurero.getDañoBase() * 2;
                        enemigo.recibirDaño(danoCritico);

                        System.out.println("¡GOLPE CRÍTICO!");
                        System.out.println(aventurero.getNombre()
                                + " atacó a " + enemigo.getNombre()
                                + " causando " + danoCritico
                                + " puntos de daño.");

                    } else if (resultadoDado == 1) {
                        System.out.println("¡PIFIA!");
                        System.out.println("El ataque ha fallado.");

                    } else {
                        aventurero.atacar(enemigo);

                        System.out.println(aventurero.getNombre()
                                + " atacó a " + enemigo.getNombre()
                                + " causando "
                                + aventurero.getDañoBase()
                                + " puntos de daño.");
                    }
                    break;

                case 2:
                    if (aventurero.getNumeroPociones() > 0) {
                        aventurero.beberPocion();

                        System.out.println(aventurero.getNombre()
                                + " bebió una poción y recuperó "
                                + "20 puntos de vida.");
                    } else {
                        System.out.println("No te quedan pociones.");
                    }
                    break;
            }

            
            if (!enemigo.estaDerrotado()) {
                aventurero.recibirDaño(enemigo.getDañoBase());
        

                System.out.println(enemigo.getNombre()
                        + " atacó a " + aventurero.getNombre()
                        + " causando " + enemigo.getDañoBase()
                        + " de daño.");
            }

        } while (!aventurero.estaDerrotado()
                && !enemigo.estaDerrotado());

        if (aventurero.estaDerrotado()) {

            System.out.println("""
        
##############################################################

                    _____________
                   /             \\
                  |   R I P       |
                  |               |
                  |   EL HÉROE    |
                  |               |
                  |   CAYÓ EN     |
                  |               |
                  |   LA          |
                  |   MAZMORRA    |
                  |               |
                  |_______________|
                       |||||
                       |||||
                       |||||
                       |||||

            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
               LA OSCURIDAD LO HA CONSUMIDO TODO
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--------------------------------------------------------------------
███╗   ███╗██╗   ██╗███████╗██████╗  ███████╗  ██████╗
████╗ ████║██║   ██║██╔════╝██╔══██╗╚══██╔══╝██╔═══██╗
██╔████╔██║██║   ██║█████╗  ██████╔╝   ██║   ██║   ██║
██║╚██╔╝██║██║   ██║██╔══╝  ██╔══██╗   ██║   ██║   ██║
██║ ╚═╝ ██║╚██████╔╝███████╗██║  ██║   ██║   ╚██████╔╝
╚═╝     ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝
            
--------------------------------------------------------------------

        El destino no siempre concede redención.
        La mazmorra reclama otra alma.

##############################################################

        """);

        } else if (enemigo.estaDerrotado()) {
            System.out.println("""
        
                            / \\  //\\
             |\\___/|      /   \\//  \\\\
             /x  x  \\__  /    //  | \\ \\
            /     /  \\/_/    //   |  \\  \\
            @_^_@'/   \\/_   //    |   \\   \\
            //_^_/     \\/_ //     |    \\    \\
         ( //) |        \\///      |     \\     \\
       ( / /) _|_ /   )  //       |      \\     _\\
     ( // /) '/,_ _ _/  ( ; -.    |    _ _\\.-~        DRAGÓN
   (( / / )) ,-{        _      `-.|.-~-.           DERROTADO
  (( // / ))  '/\\      /                 ~-. _
  (( /// ))      `.   {            }                   ___
   (( / ))     .----~-\\        \\-'               .-~´   `~.
              ///.----..>        \\            .-~           |
                ///-._ _ _ _ _ _ _}       .-~               |
                                              

--------------------------------------------------------------------

███████╗ ██╗ ███╗   ██╗
██╔════╝ ██║ ████╗  ██║
█████╗   ██║ ██╔██╗ ██║
██╔══╝   ██║ ██║╚██╗██║
██║      ██║ ██║ ╚████║
╚═╝      ╚═╝ ╚═╝  ╚═══╝

--------------------------------------------------------------------

     

        """);

           

           

        scanner.close();
    }
}
}
