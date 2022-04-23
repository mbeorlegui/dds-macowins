package domain.ropa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MisTests {

  @DisplayName("Ventas en efectivo no aplican recargo")
  @Test
  public void ventaEnEfectivoNoAplicaRecargo() {
    VentaEnEfectivo ventaEnEfectivo = new VentaEnEfectivo();
    assertEquals(ventaEnEfectivo.aplicarRecargo(100), 100);
  }

  @DisplayName("Ventas con tarjeta aplican recargo")
  @Test
  public void ventaConTarjetaAplicaRecargo() {
    VentaConTarjeta ventaConTarjeta = new VentaConTarjeta(10, 12);
    assertEquals(ventaConTarjeta.aplicarRecargo(100), 221);
  }

  @DisplayName("El tipo de un pantalon en promocion es 'PANTALON'")
  @Test
  public void elTipoDeUnPantalonEnPromocionEsPANTALON() {
    assertEquals(pantalonEnPromocion(200, 100).getTipo().toString(), "PANTALON");
  }

  @DisplayName("El tipo de una camisa nueva es 'CAMISA'")
  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @DisplayName("El tipo de un saco en liquidacion es 'SACO'")
  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @DisplayName("El precio de una camisa nueva es su precio base")
  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precioFinal(), 4000, 0);
    assertEquals(camisaNueva(5000).precioFinal(), 5000, 0);
  }

  @DisplayName("El precio de un saco en liquidacion es la mitad de su precio base")
  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precioFinal(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precioFinal(), 4000, 0);
  }

  @DisplayName("El precio de un Pantalon en Promocion es su precio menos su descuento")
  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precioFinal(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precioFinal(), 1400, 0);
  }

  @DisplayName("Al agregar una venta al local, la ganancia del dia es la de esa venta")
  @Test
  public void alAgregarUnaVentaAlLocalLaGananciaDelDiaEsEsaVenta() {
    Local unLocalConVenta = nuevoLocal();
    unLocalConVenta.agregarVenta(nuevaVentaEnEfectivoConPrenda());

    assertEquals(
        unLocalConVenta.gananciaDeUnDia(LocalDate.now()),
        nuevaVentaEnEfectivoConPrenda().totalVenta()
    );
  }

  @DisplayName("Al agregar varias ventas al local, la ganancia del dia es las de esas ventas")
  @Test
  public void alAgregarVariasVentasAlLocalLaGananciaDelDiaSonLasDeEsasVentas() {
    Local unLocalConVenta = nuevoLocal();
    unLocalConVenta.agregarVenta(nuevaVentaEnEfectivoConPrenda());
    unLocalConVenta.agregarVenta(nuevaVentaEnEfectivoConPrenda());
    unLocalConVenta.agregarVenta(nuevaVentaConTarjetaConPrenda());
    unLocalConVenta.agregarVenta(nuevaVentaConTarjetaConPrenda());

    assertEquals(
        unLocalConVenta.gananciaDeUnDia(LocalDate.now()),
        nuevaVentaEnEfectivoConPrenda().totalVenta() +
            nuevaVentaEnEfectivoConPrenda().totalVenta() +
            nuevaVentaConTarjetaConPrenda().totalVenta() +
            nuevaVentaConTarjetaConPrenda().totalVenta()

    );
  }


  @DisplayName("Instanciar: Pantalon en promocion")
  private Prenda pantalonEnPromocion(int precioBase, int descuento) {
    return new Prenda(TipoPrenda.PANTALON, new Promocion(descuento), precioBase);
  }

  @DisplayName("Instanciar: Camisa nueva")
  private Prenda camisaNueva(double precioBase) {
    return new Prenda(TipoPrenda.CAMISA, new Nuevo(), precioBase);
  }

  @DisplayName("Instanciar: Saco en liquidacion")
  private Prenda sacoEnLiquidacion(double precioBase) {
    return new Prenda(TipoPrenda.SACO, new Liquidacion(), precioBase);
  }

  @DisplayName("Instanciar: Nuevo local")
  private Local nuevoLocal() {
    return new Local();
  }

  @DisplayName("Instanciar: Nueva Venta con Tarjeta con prenda")
  private VentaConTarjeta nuevaVentaConTarjetaConPrenda() {
    VentaConTarjeta ventaConTarjeta = new VentaConTarjeta(10, 12);
    ventaConTarjeta.agregarPrenda(sacoEnLiquidacion(100));
    return ventaConTarjeta;
  }

  @DisplayName("Instanciar: Nueva Venta en Efectivo con prenda")
  private VentaEnEfectivo nuevaVentaEnEfectivoConPrenda() {
    VentaEnEfectivo ventaEnEfectivo = new VentaEnEfectivo();
    ventaEnEfectivo.agregarPrenda(camisaNueva(100));
    return ventaEnEfectivo;
  }

}