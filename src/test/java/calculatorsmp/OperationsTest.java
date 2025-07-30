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
}
