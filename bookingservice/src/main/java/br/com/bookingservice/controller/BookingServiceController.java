package br.com.bookingservice.controller;

import br.com.bookingservice.model.domain.Viagem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class BookingServiceController {

    @GetMapping
    public ResponseEntity<List<Viagem>> getViagem() {
        List<Viagem> viagens = new ArrayList<>();

        // Criação de instâncias de Viagem com LocalDate
        Viagem viagem1 = new Viagem("Belém", "Ilha do Marajó", LocalDate.of(2024, 6, 25), "Barco Marajoense");
        Viagem viagem2 = new Viagem("Belém", "Salvaterra", LocalDate.of(2024, 6, 26), "Barco Estrela do Marajó");
        Viagem viagem3 = new Viagem("Belém", "Soure", LocalDate.of(2024, 6, 27), "Barco Amazônia Azul");

        // Adiciona as viagens à lista
        viagens.add(viagem1);
        viagens.add(viagem2);
        viagens.add(viagem3);
        return ResponseEntity.ok(viagens);
    }
}
