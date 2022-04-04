package domain.ropa;

public class Nuevo implements Estado {
  @Override
  public double precioFinal(double precioBase) {
    return precioBase;
  }
}