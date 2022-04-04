package domain.ropa;

public class Promocion implements Estado {
  private double descuento;

  // Constructor de promocion, ya que toda promocion
  // necesita tener un descuento
  public Promocion(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public double precioFinal(double precioBase) {
    return precioBase - this.descuento;
  }

}
