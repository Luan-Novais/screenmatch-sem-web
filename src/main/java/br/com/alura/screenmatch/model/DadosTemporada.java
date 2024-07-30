package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //ignore todos os outros registros do json respeitando somente oq mapeei
public record DadosTemporada(@JsonAlias("Season")Integer numero,
                             @JsonAlias("Episodes") List<DadosEpisodio> episodios ) {
}