package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;//permite pegar o nome exato que vem da api e renomear com nome da classe
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //ignore todos os outros registros do json respeitando somente oq mapeei
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
}
