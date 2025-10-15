package juego;

import org.junit.jupiter.api.Test;
import juego.modelo.*;

public class MainTest {

    @Test
    void testSimulacionBatallaGuerreroVsDragon() {
        Arma espada = new Arma("espada legendaria", 10);
        Arma garra = new Arma("garras de metal", 8);

        Guerrero guerrero = new Guerrero("Gaia el caballero feroz", 100, 15, espada);
        Dragon dragon = new Dragon("Dragón negro de ojos rojos", 120, 20, "negras", garra);

        Main.simularBatalla(guerrero, dragon);
    }

    @Test
    void testSimulacionBatallaMagoVsDragon() {
        Arma baston = new Arma("bastón mágico", 6);
        Arma garra = new Arma("garras de metal", 8);

        Mago mago = new Mago("Mago oscuro", 80, 18, "bola de fuego", baston);
        Dragon dragon = new Dragon("Dragón negro de ojos rojos", 120, 20, "negras", garra);

        Main.simularBatalla(mago, dragon);
    }

    @Test
    void testSimulacionBatallaGuerreroVsMago() {
        Arma espada = new Arma("espada legendaria", 10);
        Arma baston = new Arma("bastón mágico", 6);

        Guerrero guerrero = new Guerrero("Gaia el caballero feroz", 100, 15, espada);
        Mago mago = new Mago("Mago oscuro", 80, 18, "bola de fuego", baston);

        Main.simularBatalla(guerrero, mago);
    }
}






