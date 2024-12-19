package it.epicode.esercizi_U2.W1.D1.BE.TestMenu;


import it.epicode.esercizi_U2.W1.D1.BE.entities.Bevanda;
import it.epicode.esercizi_U2.W1.D1.BE.entities.Menu;
import it.epicode.esercizi_U2.W1.D1.BE.entities.Pizza;
import it.epicode.esercizi_U2.W1.D1.BE.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TestMenu {

    @Autowired
    private MenuRepository menuRepository;


    @Test
    @DisplayName("Test per il salvataggio delle pizze")
    public void testSavePizze() {
        Menu pizza1 = new Pizza();
        pizza1.setNome("Margherita");
        pizza1.setCalorie(800);
        pizza1.setPrezzo(5.0);
        menuRepository.save(pizza1);

        Menu pizza2 = new Pizza();
        pizza2.setNome("Diavola");
        pizza2.setCalorie(900);
        pizza2.setPrezzo(6.0);
        menuRepository.save(pizza2);

        Menu pizza3 = new Pizza();
        pizza3.setNome("Prosciutto e Funghi");
        pizza3.setCalorie(859);
        pizza3.setPrezzo(6.5);
        menuRepository.save(pizza3);
    }

    @ParameterizedTest
    @DisplayName("Test parametrizzato per il calcolo delle calorie")
    @ValueSource(ints = {800, 900, 859})
    public void testCalorie(int calorie) {
        assertEquals(800, calorie);
    }

    @ParameterizedTest
    @DisplayName("Test parametrizzato per il calcolo dei prezzi")
    @ValueSource(doubles = {5.0, 6.0, 6.5})
    public void testPrezzo(double prezzo) {
        assertEquals(5.0, prezzo);
    }

    @Test
    @DisplayName("Test per il salvataggio delle bevande")
    public void testSaveBevande() {
        Menu bevanda1 = new Bevanda();
        bevanda1.setNome("Acqua");
        bevanda1.setCalorie(0);
        bevanda1.setPrezzo(1.0);
        menuRepository.save(bevanda1);

        Menu bevanda2 = new Bevanda();
        bevanda2.setNome("Coca Cola");
        bevanda2.setCalorie(100);
        bevanda2.setPrezzo(2.0);
        menuRepository.save(bevanda2);

        Menu bevanda3 = new Bevanda();
        bevanda3.setNome("Birra");
        bevanda3.setCalorie(200);
        bevanda3.setPrezzo(3.0);
        menuRepository.save(bevanda3);
    }


}

