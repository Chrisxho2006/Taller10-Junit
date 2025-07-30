package calculatorsmp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class OperationsTest {

    @Test
    @DisplayName("Probar Metodo MakeFormula")
    public void CM1() {
        String result = Operations.MakeFormula();
        assertNotNull(result);
        assertTrue(result.matches("\\d+([+\\-*/]\\d+)+"));
    }

    @Test
    @DisplayName("Test Verificador Sumatoria")
    public void CM2() {
        String formula = "33+77";
        String expResult = "33+77=110";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Prueba múltiples operaciones de precedencia mixta")
    public void T9() {
        String formula = "5*2+8/4";
        String expResult = "5*2+8/4=12"; // (5 * 2) + (8 / 4) = 10 + 2 = 12
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Prueba división por uno")
    public void T10() {
        String formula = "99/1";
        String expResult = "99/1=99";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Prueba números más grandes y operaciones complejas")
    public void T11() {
        String formula = "85+15-10*2/5";
        // 85+15 - (10*2)/5 = 100 - 20/5 = 100 - 4 = 96
        String expResult = "85+15-10*2/5=96";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
}
