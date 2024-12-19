package it.epicode.esercizi_U2.W1.D1.BE.repository;

import it.epicode.esercizi_U2.W1.D1.BE.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza,Long>  {


    Pizza findPizzaByNome(String nome);

    List<Pizza> findPizzaByPrezzoBetween(double minPrezzo, double maxPrezzo);

    List<Pizza> findPizzaByCalorieOrderByCalorieDesc(int calorie);
    List<Pizza> findByOrderByCalorieDesc();

}