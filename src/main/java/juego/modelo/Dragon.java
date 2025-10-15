package juego.modelo;

public class Dragon extends Criatura implements Volador {
    private String escamas;
    private Arma arma;

    public Dragon(String nombre, int salud, int fuerza, String escamas, Arma arma) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza * 2;
        if (arma != null)
            daño += arma.getDañoAdicional();

        System.out.println(nombre + " lanza fuego con sus escamas " + escamas + " a " 
                + objetivo.getNombre() + ", causando " + daño + " de daño!");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int dañoReducido = (int) (daño * 0.9); // escamas reducen 10%
        reducirSalud(dañoReducido);
        System.out.println(nombre + " usa sus escamas " + escamas + 
                " para reducir el daño. Salud restante: " + salud);
    }

    @Override
    public void volar() {
        System.out.println(nombre + " está volando alto en el cielo!");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterriza con fuerza en el suelo!");
    }
}



