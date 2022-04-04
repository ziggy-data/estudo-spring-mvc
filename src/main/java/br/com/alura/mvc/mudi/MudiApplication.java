package br.com.alura.mvc.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //so se tiver essa anotacao que vai funcionar o cache
@SpringBootApplication
public class MudiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}

	//cache otimiza o sistema guardando os dados da consulta na ram fazendo diminuir a sobrecarga
		// pode nao ser tao interessante qnd precisamos entregar dados mais atualizados
		// cache pode ser custoso e nao valer a pena
		// usuamos cache qnd não é preciso retornar para o usuário os dados mais atualizados,
		// quando os dados forem muito requisitados e demandarem muito processamento
		// Utilizar cache neste cenário pode não apenas reduzir o custo financeiro da aplicação, 
		// como liberar capacidade de processamento para outras funcionalidades
		// possivelmente mais importantes.
}
