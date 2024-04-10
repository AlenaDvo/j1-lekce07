package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.List;
import java.util.Set;

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

        String jmenoJeVSeznamu = "Nataša";
        MonthDay datumJeVSeznamu = MonthDay.of(5, 18);
        String jmenoNeniVSeznamu = "Pytlik";

        assertEquals(datumJeVSeznamu, svatky.vratKdyMaSvatek(jmenoJeVSeznamu), "Jmeno " + jmenoJeVSeznamu + " melo byt v seznamu pod datem " + datumJeVSeznamu + ".");
        assertNull(svatky.vratKdyMaSvatek(jmenoNeniVSeznamu), "Jmeno " + jmenoNeniVSeznamu + " nemelo byt v seznamu.");
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();

        String jmenoJeVSeznamu = "Nataša";
        String jmenoNeniVSeznamu = "Pytlik";

        assertTrue(svatky.jeVSeznamu(jmenoJeVSeznamu), "Jmeno " + jmenoJeVSeznamu + " melo byt v seznamu.");
        assertFalse(svatky.jeVSeznamu(jmenoNeniVSeznamu), "Jmeno " + jmenoNeniVSeznamu + " nemelo byt v seznamu.");
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

        Set<String> seznamJmen = Set.of("Valdemar", "Maxim", "Kamila", "Ivo", "Zbyšek", "Claudia", "Vladimíra", "Nataša", "Viliam", "Maxmilián", "Emil", "Stibor", "Ferdinand", "Svatava", "Vanesa", "Filip", "Žofie", "Viola", "Alex", "Aneta", "Bonifác", "Ctibor", "Květoslav", "Klaudie", "Monika", "Jana", "Klaudia", "Přemysl", "Zikmund", "Stanislav", "Alexej", "Vilém", "Radoslav", "Vladimír", "Blažena", "Pankrác", "Servác");

        assertEquals(37, svatky.getSeznamJmen().size(), "Velikost seznamu jmen mela byt 37.");
        assertEquals(seznamJmen, svatky.getSeznamJmen(), "Seznam jmen je nesprávný.");
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekIntInt() {
        Svatky svatky = new Svatky();

        String ocekavaneJmeno = "Allison";
        int ocekavanyDenVMesici = 14;
        int ocekavanyMesic = 6;

        svatky.pridejSvatek(ocekavaneJmeno, ocekavanyDenVMesici, ocekavanyMesic);

        assertTrue(svatky.jeVSeznamu(ocekavaneJmeno), "Jmeno " + ocekavaneJmeno + " melo byt v seznamu.");
        assertEquals(ocekavanyDenVMesici, svatky.vratKdyMaSvatek(ocekavaneJmeno).getDayOfMonth(), "Den " + ocekavanyDenVMesici + " mel byt dnem, kdy ma svatek " + ocekavaneJmeno + ".");
        assertEquals(ocekavanyMesic, svatky.vratKdyMaSvatek(ocekavaneJmeno).getMonthValue(), "Mesic " + ocekavanyMesic + " mel byt mesicem, kdy ma svatek " + ocekavaneJmeno + ".");
        assertEquals(38, svatky.getPocetJmen(), "Pocet svatku se mel zvetsit o jedna.");
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridejSvatekIntMonth() {
        Svatky svatky = new Svatky();

        String ocekavaneJmeno = "Andrew";
        int ocekavanyDen = 15;
        Month ocekavanyMesic = Month.JUNE;

        svatky.pridejSvatek(ocekavaneJmeno, ocekavanyDen, ocekavanyMesic);

        assertTrue(svatky.jeVSeznamu(ocekavaneJmeno), "Jmeno " + ocekavaneJmeno + " melo byt v seznamu.");
        assertEquals(ocekavanyDen, svatky.vratKdyMaSvatek(ocekavaneJmeno).getDayOfMonth(), "Den " + ocekavanyDen + " mel byt dnem, kdy ma svatek " + ocekavaneJmeno + ".");
        assertEquals(ocekavanyMesic, svatky.vratKdyMaSvatek(ocekavaneJmeno).getMonth(), "Mesic " + ocekavanyMesic + " mel byt mesicem, kdy ma svatek " + ocekavaneJmeno + ".");
        assertEquals(38, svatky.getPocetJmen(), "Pocet svatku se mel zvetsit o jedna.");
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridejSvatekMonthDay() {
        Svatky svatky = new Svatky();

        String ocekavaneJmeno = "Aiden";
        MonthDay ocekavaneDatum = MonthDay.of(Month.JUNE, 16);

        svatky.pridejSvatek(ocekavaneJmeno, ocekavaneDatum);

        assertTrue(svatky.jeVSeznamu(ocekavaneJmeno), "Jmeno " + ocekavaneJmeno + " melo byt v seznamu.");
        assertEquals(ocekavaneDatum, svatky.vratKdyMaSvatek(ocekavaneJmeno), "Datum " + ocekavaneDatum + " melo byt datem, kdy ma svatek " + ocekavaneJmeno + ".");
        assertEquals(38, svatky.getPocetJmen(), "Pocet svatku se mel zvetsit o jedna.");
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        Svatky svatky = new Svatky();

        String mazaneJmeno = "Alex";

        svatky.smazSvatek(mazaneJmeno);

        assertFalse(svatky.jeVSeznamu(mazaneJmeno), "Jmeno " + mazaneJmeno + " nema byt po smazani v seznamu.");
        assertEquals(36, svatky.getPocetJmen(), "Pocet jmen se mel po smazani o jedna snizit.");
    }
}