package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		Scanner leitura = new Scanner(System.in);
		System.out.println("Qual a serie que deseja pesquisar: ");
		String minhaSerie = leitura.nextLine().replace(" " , "+");
		System.out.println(minhaSerie);
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=" + minhaSerie + "&apikey=307179e1");
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=307179e1");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		List<DadosTemporada> temproadas = new ArrayList<>();
		for (int i = 1 ; i<=dados.totalTemporadas(); i++){

			json = consumoApi.obterDados("https://www.omdbapi.com/?t=" + minhaSerie + "&season=" + i + "&apikey=307179e1");
			DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
			temproadas.add(dadosTemporada);
		}
		temproadas.forEach(System.out::println);

	}
}
