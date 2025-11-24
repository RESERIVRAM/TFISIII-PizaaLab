package controlador;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EntornoTest {

    @Test
    public void entornoFunciona() {
        // Usamos Mockito para crear un mock sencillo
        Runnable r = mock(Runnable.class);

        r.run();

        // Verificamos que se llamó una vez
        verify(r).run();

        // Y hacemos una aserción simple
        assertEquals(4, 2 + 2);
    }
}