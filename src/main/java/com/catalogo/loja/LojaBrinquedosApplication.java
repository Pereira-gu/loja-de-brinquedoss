package com.catalogo.loja;

import com.catalogo.loja.model.Categoria;
import com.catalogo.loja.model.Equipe;
import com.catalogo.loja.model.Item;
import com.catalogo.loja.repository.CategoriaRepository;
import com.catalogo.loja.repository.EquipeRepository;
import com.catalogo.loja.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class LojaBrinquedosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaBrinquedosApplication.class, args);
	}

	@Bean
	public CommandLineRunner inicializarDados(CategoriaRepository categoriaRepo,
											  ItemRepository itemRepo,
											  EquipeRepository equipeRepo) {
		return args -> {
			itemRepo.deleteAll();
			categoriaRepo.deleteAll();
			equipeRepo.deleteAll();

			Categoria cat1 = new Categoria();
			cat1.setNomeCategoria("Ação e Aventura");
			cat1.setImgCategoria("https://via.placeholder.com/150");

			Categoria cat2 = new Categoria();
			cat2.setNomeCategoria("Jogos de Tabuleiro");
			cat2.setImgCategoria("https://via.placeholder.com/150");
			categoriaRepo.saveAll(Arrays.asList(cat1, cat2));

			Item item1 = new Item();
			item1.setCodigoDoBrinquedo("BR-001");
			item1.setDescricao("Boneco Super Herói");
			item1.setMarca("Brinquedos SA");
			item1.setValor(59.90);
			item1.setImagemUrl("https://via.placeholder.com/200");
			item1.setDestaque(true);
			item1.setDetalhes("Boneco articulado com vários acessórios incríveis.");
			item1.setCategoria(cat1);

			Item item2 = new Item();
			item2.setCodigoDoBrinquedo("BR-002");
			item2.setDescricao("Banco Imobiliário");
			item2.setMarca("Estrela");
			item2.setValor(120.00);
			item2.setImagemUrl("https://via.placeholder.com/200");
			item2.setDestaque(false);
			item2.setDetalhes("O clássico jogo de compra e venda de propriedades.");
			item2.setCategoria(cat2);

			itemRepo.saveAll(Arrays.asList(item1, item2));

			Equipe dev1 = new Equipe();
			dev1.setNome("pessoa 1");
			dev1.setRgm("11111111");
			dev1.setFoto("https://via.placeholder.com/150");

			Equipe dev2 = new Equipe();
			dev2.setNome("pessoa 2");
			dev2.setRgm("22222222");
			dev2.setFoto("https://via.placeholder.com/150");

			equipeRepo.saveAll(Arrays.asList(dev1, dev2));

			System.out.println("✅ Banco de dados populado com sucesso! Prontos para testar.");
		};
	}
}