package domain.ropa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Local {

  private List<Venta> ventas = new ArrayList<Venta>();

  public void agregarVenta(Venta v) {
    this.ventas.add(v);
  }

  public double gananciaDeUnDia(LocalDate unDia) {
    double ganancia = 0;
    for (Venta v : this.ventas) {
      if (v.esVentaDelDia(unDia)) {
        ganancia += v.totalVenta();
      }
    }
    return ganancia;
  }

  private String ventasDeUnDia(LocalDate unDia) {
    String ventasDelDia = this.ventas.stream().filter(venta -> venta.esVentaDelDia(unDia)).toString();
    return String.join(" ", ventasDelDia);
  }

  public void imprimirVentasDeUnDia(LocalDate unDia) {
    System.out.printf("REGISTRO DEL DIA %s%nGanancia total: %s%nDetalle:%n%s%n",
        unDia, this.gananciaDeUnDia(unDia), this.ventasDeUnDia(unDia));
  }

}