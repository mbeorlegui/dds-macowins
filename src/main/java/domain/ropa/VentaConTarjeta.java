package domain.ropa;

public class VentaConTarjeta extends Venta {
  double coeficienteFijo;
  int cuotas;

  public VentaConTarjeta(double coeficienteFijo, int cuotas) {
    super();
    this.coeficienteFijo = coeficienteFijo;
    this.cuotas = cuotas;
  }

  @Override
  protected double aplicarRecargo(double totalBase) {
    return this.cuotas * this.coeficienteFijo + 1.01 * totalBase;
  }
  // En caso de que la venta sea con tarjeta, se aplica un recargo según las cuotas seleccionadas
}
