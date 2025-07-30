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
    @DisplayName("Test de Resta")
    public void T3() {
        String formula = "20-2";
        String expResult = "20-2=18";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Test de Producto entre enteros: ")
    public void T4() {
        String formula = "24*5";
        String expResult = "24*5=120";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Test de División entre enteros: ")
    public void T5() {
        String formula = "30/5";
        String expResult = "30/5=6";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

        @Test
    @DisplayName("Prueba multiplicar luego sumar")
    public void T6() {
        String formula = "2+3*4";
        String expResult = "2+3*4=14";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Prueba dividir luego restar")
    public void T7() {
        String formula = "10-6/2";
        String expResult = "10-6/2=7";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Prueba con múltiples operaciones de la misma precedencia")
    public void T8() {
        String formula = "10+5-3";
        String expResult = "10+5-3=12";
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
