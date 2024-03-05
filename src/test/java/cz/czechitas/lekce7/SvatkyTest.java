package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void vratKdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
//        assertTrue(svatky.jeVSeznamu("Nataša"));
//        assertFalse(svatky.jeVSeznamu("Krumpáč"));

        // Arrange
        String jmenoJeVSeznamu = "Nataša";
        String jmenoNeniVSeznamu = "Pytlik";

        // Act
        boolean resultJmenoJeVSeznamu = svatky.jeVSeznamu(jmenoJeVSeznamu);
        boolean resultJmenoNeniVSeznamu = svatky.jeVSeznamu(jmenoNeniVSeznamu);

        // Assert
        assertTrue(resultJmenoJeVSeznamu, "Jmeno " + jmenoJeVSeznamu + " melo byt v seznamu.");
        assertFalse(resultJmenoNeniVSeznamu, "Jmeno " + jmenoNeniVSeznamu + " nemelo byt v seznamu.");
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Alex", 14, 6);
        boolean result = svatky.jeVSeznamu("Alex");
        assertTrue(result);
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridejSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Andrew", MonthDay.of(6, 15));
        boolean result = svatky.jeVSeznamu("Andrew");
        assertTrue(result);
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridejSvatekMonthDay() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Aiden", MonthDay.of(Month.JUNE, 16));
        boolean result = svatky.jeVSeznamu("Aiden");
        assertTrue(result);
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        Svatky svatky = new Svatky();
        svatky.smazSvatek("Alex");
        assertFalse(svatky.jeVSeznamu("Alex"));
    }
}
