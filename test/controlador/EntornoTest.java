package controlador;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test sencillo para verificar que el entorno de JUnit funciona.
 * No usa Mockito para evitar dependencias adicionales.
 */
public class EntornoTest {

    @Test
    public void entornoFunciona() {
        // Prueba mínima: si esto pasa, JUnit está bien configurado
        assertEquals(4, 2 + 2);
    }
}