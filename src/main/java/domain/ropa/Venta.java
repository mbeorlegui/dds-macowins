package domain.ropa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// La clase es abstracta, ya que no se utiliza la clase Venta, si no que siempre se van a utilizar
// las clases hijas (VentaEnEfectivo y VentaConTarjeta)
abstract class Venta {
  private LocalDate fecha;
  private final List<Prenda> prendasVendidas = new ArrayList<Prenda>();

  public Venta() {
    this.fecha = LocalDate.now();
  }

  abstract double aplicarRecargo(double totalBase);

  public double totalVenta() {
    double valorPrendas = 0;

    // Enhanced for loop:
    // Puede iterar sobre objetos y llamar a sus metodos.
    // Primero ponemos el tipo sobre lo que queremos iterar (p es de tipo "Prenda" en este caso)
    // Y luego iteramos sobre sus prendasVendidas que es una lista
    for (Prenda p : this.prendasVendidas) {
      valorPrendas += p.precioFinal();
    }
    return aplicarRecargo(valorPrendas);
    // Debido a que el recargo que se aplica esta sujeto al tipo de venta, utilizamos polimorfismo
    // y dejamos que eso lo calculen las subclases
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void agregarPrenda(Prenda unaPrenda) {
    this.prendasVendidas.add(unaPrenda);
  }

  public int cantidadVendida() {
    return this.prendasVendidas.size();
  }

  private String imprimirPrendas() {
    return String.join(" ", this.prendasVendidas.toString());
  }

  // Sirve para hacer la diferenciacion de las ventas de un mismo dia,
  // que necesitará el local en cuestión
  public boolean esVentaDelDia(LocalDate dia) {
    return this.getFecha().equals(dia);
  }

  // El metodo toString muestra la informacion referida al objeto,
  // con el decorador override hacemos que se muestre de una forma mas amigable (y menos fea)
  @Override
  public String toString() {
    return String.format("VENTA%nFecha: %s%nCantidad: %d%nTotal: %s%nPrendas:%n%s",
        this.fecha, this.cantidadVendida(), this.totalVenta(), this.imprimirPrendas());
  }

}
