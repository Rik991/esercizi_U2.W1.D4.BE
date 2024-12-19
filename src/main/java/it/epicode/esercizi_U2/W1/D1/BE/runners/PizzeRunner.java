package it.epicode.esercizi_U2.W1.D1.BE.runners;

import it.epicode.esercizi_U2.W1.D1.BE.entities.Pizza;
import it.epicode.esercizi_U2.W1.D1.BE.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Order(1)
public class PizzeRunner implements ApplicationRunner {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private Pizza newPizzaMargherita;
    @Autowired
    private Pizza newPizzaHawaaiiana;
    @Autowired
    private Pizza newPizzaSalame;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        pizzaRepository.save(newPizzaMargherita);
        pizzaRepository.save(newPizzaHawaaiiana);
        pizzaRepository.save(newPizzaSalame);

        System.out.println("Pizza Margherita: " + pizzaRepository.findPizzaByNome("Margherita").getNome());

        pizzaRepository.findPizzaByPrezzoBetween(2, 6).forEach(pizza -> System.out.println("\"Pizze che costano tra 2 e 6 euro: " + pizza.getNome()));

        pizzaRepository.findPizzaByCalorieOrderByCalorieDesc(1104).forEach(pizza -> System.out.println("Pizze con 1104 calorie: " + pizza.getNome()));

        pizzaRepository.findByOrderByCalorieDesc().forEach(pizza -> System.out.println("Pizze ordinate per calorie: " + pizza.getNome()));


    }
}
