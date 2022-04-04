package domain.ropa;

public class VentaEnEfectivo extends Venta {
  public VentaEnEfectivo() {
    super();
  }

  @Override
  protected double aplicarRecargo(double totalBase) {
    return totalBase;
  }
  // Si la venta es en efectivo, no se aplica recargo
}
