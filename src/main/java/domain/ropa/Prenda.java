package domain.ropa;

public class Prenda {
  // private String nombre;
  private TipoPrenda tipo;
  private double precioBase;
  private Estado estado;

  // El constructor lo defino de la siguiente manera:
  public Prenda(TipoPrenda tipo, Estado estado, double precioBase) {
    this.tipo = tipo;
    this.estado = estado;
    this.precioBase = precioBase;
    // Todos estos datos son necesarios para instanciar a los objetos de tipo Prenda
  }

  // El precio final de una prenda depende del ESTADO, por lo que el estado
  // es el encargado de realizar el cálculo en base al precio base de la prenda
  public double precioFinal() {
    return estado.precioFinal(precioBase);
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public void cambiarEstado(Estado nuevoEstado) {
    this.estado = nuevoEstado;
  }
}
