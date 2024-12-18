package it.epicode.esercizi_U2.W1.D1.BE.runners;

import it.epicode.esercizi_U2.W1.D1.BE.entities.Menu;
import it.epicode.esercizi_U2.W1.D1.BE.entities.Ordine;
import it.epicode.esercizi_U2.W1.D1.BE.entities.Tavolo;
import it.epicode.esercizi_U2.W1.D1.BE.repository.MenuRepository;
import it.epicode.esercizi_U2.W1.D1.BE.repository.OrdineRepository;
import it.epicode.esercizi_U2.W1.D1.BE.repository.TavoloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@Order(5)
public class OrdiniRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(OrdiniRunner.class);

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private TavoloRepository tavoloRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Value("${costo.coperto}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumero(1);
        tavolo.setNumeroCopertiMax(4);
        tavolo.setOccupato(true);
        tavoloRepository.save(tavolo);

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setStato("in corso");
        ordine.setNumeroCoperti(3);
        ordine.setOraAcquisizione(LocalDateTime.now());
        ordine.setTavolo(tavolo);

        List<Menu> elementiMenu = menuRepository.findAll();
        ordine.setElementiMenu(elementiMenu);

        double importoTotale = elementiMenu.stream().mapToDouble(Menu::getPrezzo).sum() + (costoCoperto * ordine.getNumeroCoperti());
        ordine.setImportoTotale(importoTotale);

        ordineRepository.save(ordine);

        logger.info("Ordine creato: {}", ordine);
    }


}
