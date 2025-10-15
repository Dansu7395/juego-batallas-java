package juego;

import juego.modelo.*;

public class Main {

    public static void simularBatalla(Criatura c1, Criatura c2) {
        System.out.println("\n=== ¡Comienza la batalla entre " + c1.getNombre() + " y el " + c2.getNombre() + "! ===\n");

        int turno = 1;

        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("Turno " + turno + "\n");

            // Turno de la criatura 1
            System.out.println("--- " + c1.getNombre() + " ---");
            c1.atacar(c2);
            if (!c2.estaViva()) break;

            // Turno de la criatura 2
            System.out.println("\n--- " + c2.getNombre() + " ---");
            c2.atacar(c1);

            turno++;
            System.out.println("\n------------------------------\n");
        }

        System.out.println("--- Resultado ---");
        if (c1.estaViva())
            System.out.println(c1.getNombre() + " ha ganado la batalla!");
        else
            System.out.println(c2.getNombre() + " ha ganado la batalla!");
    }

    public static void main(String[] args) {
        Arma espada = new Arma("espada legendaria", 10);
        Arma garra = new Arma("garras de metal", 8);

        Guerrero guerrero = new Guerrero("Gaia el caballero feroz", 100, 15, espada);
        Dragon dragon = new Dragon("Dragón negro de ojos rojos", 120, 20, "negras", garra);
        Mago mago = new Mago("Mago oscuro", 80, 18, "bola de fuego", new Arma("bastón mágico", 6));

        simularBatalla(guerrero, dragon);

        System.out.println("\n========================================\n");

        simularBatalla(mago, dragon);
    }
}

