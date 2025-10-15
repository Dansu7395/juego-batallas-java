package juego.modelo;

public class Guerrero extends Criatura {
    private Arma arma;

    public Guerrero(String nombre, int salud, int fuerza, Arma arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza;
        if (arma != null)
            daño += arma.getDañoAdicional();

        System.out.println(nombre + " ataca con su " + arma.getNombre() + " causando " + daño + " de daño!");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        reducirSalud(daño);
        System.out.println(nombre + " recibe " + daño + " de daño. Salud restante: " + salud);
    }
}

