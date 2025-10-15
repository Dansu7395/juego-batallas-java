package juego.modelo;

public class Mago extends Criatura implements Magico {
    private String hechizos;
    private Arma arma;

    public Mago(String nombre, int salud, int fuerza, String hechizos, Arma arma) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza;
        if (arma != null)
            daño += arma.getDañoAdicional();

        System.out.println(nombre + " lanza el hechizo " + hechizos + 
                " usando su " + arma.getNombre() + " y causa " + daño + " de daño!");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        reducirSalud(daño);
        System.out.println(nombre + " recibe " + daño + " de daño. Salud restante: " + salud);
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        System.out.println(nombre + " lanza el hechizo " + hechizos + " contra " + objetivo.getNombre());
        objetivo.defender(fuerza);
    }

    @Override
    public void aprenderHechizo(String hechizo) {
        this.hechizos = hechizo;
        System.out.println(nombre + " ha aprendido un nuevo hechizo: " + hechizo);
    }
}

