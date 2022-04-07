package domain.ropa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MisTests {

  @DisplayName("Test de pruebe que siempre va a pasar")
  @Test
  public void testDePrueba() {
    assertTrue(true);
  }

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

  
}
