package br.com.bookingservice.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viagem {
    private String origem;
    private String destino;
    private LocalDate dataViagem;
    private String nomeEmbarcacao;
}

