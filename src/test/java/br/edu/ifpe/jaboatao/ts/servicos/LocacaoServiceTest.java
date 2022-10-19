package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoServiceTest {
	@Test
	public void teste01() {
		//System.out.println("Funcionando.");
		//Cen�rio
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		Bicicleta bike = new Bicicleta("Bike 01", 1, 40.0);
		//A��o
		Locacao locacao;
		try {
			locacao = service.alugarBicicleta(cliente, bike);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Verifica��o
		Assertions.assertTrue(locacao.getValorLocacao() == 40.0);
		Assertions.assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataLocacao(), new Date()));
		Assertions.assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataRetorno(), novaDataComDiferencaDeDias(3)));
		
		Assertions.assertTrue(locacao.getCliente().getNome() == "Cliente 01");
		Assertions.assertTrue(locacao.getBicicleta().getEstoque() == 1);
		
		

	}
}
