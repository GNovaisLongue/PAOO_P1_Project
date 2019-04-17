package strategy_battle_arena_Teste;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import strategy_battle_arenaMain.ListaCombateUmVersusUm;
import strategy_battle_char_buff.BeastTamerBuff;
import strategy_battle_char_buff.FireMagicBuff;
import strategy_battle_char_buff.ThornsBuff;
import strategy_battle_Chars.King;
import strategy_battle_Chars.Knight;
import strategy_battle_Chars.Queen;
import strategy_battle_Chars.Troll;
import strategy_battle_Chars.Character;
import strategy_battle_weapons.AxeBehavior;
import strategy_battle_weapons.BowAndArrowBehavior;
import strategy_battle_weapons.KnifeBehavior;
import strategy_battle_weapons.SwordBehavior;

public class TesteMain {
	public static void main(String[] args) {
		Scanner Leitor = new Scanner(System.in);
		String stringMenu =
				"\t--Menu--\n0-Encerrar\n1-Teste Listagem_Combatentes\n2-Lista_Combate_UmVersusUm";
		Random random = new Random();
		int tomadaDecisaoMenu;

		List <ListagemCombatentes> listaCombatentes = new ArrayList<>();//case1
		List <ListaCombateUmVersusUm> listaCombate1v1 = new ArrayList<>();//case2
		int vitoriaDaRodada=0; //(flag)quem venceu o duelo 1v1 e avanca
		int armaExtra; //(Decorator)ganha um dano extra entre 4 possibilidades
		Character vencedorDuelo;//quem venceu sua partida
		/////////////////////////////////////////////////////////////////////
		do {
			System.out.println(stringMenu);
			tomadaDecisaoMenu = Leitor.nextInt();
			switch(tomadaDecisaoMenu) {
				default:
					break;
				case 0:
					System.out.println("Encerrando");
					break;
					
				case 1://--------------------Listar Combatentes (Teste)------------------
					listaCombatentes.clear();
					for (int i=0; i < 10; i++) {
						int p = random.nextInt(4);
						switch(p) {
						case 0:
							listaCombatentes.add(new ListagemCombatentes(new Knight()));
							break;
						case 1:
							listaCombatentes.add(new ListagemCombatentes(new Troll()));
							break;
						case 2:
							listaCombatentes.add(new ListagemCombatentes(new Queen()));
							break;
						case 3:
							listaCombatentes.add(new ListagemCombatentes(new King()));
							break;
						}
					}
					for(ListagemCombatentes listA : listaCombatentes) {
						int weapon = random.nextInt(4);
						switch (weapon) {
						case 0:
							listA.getplayer().setWeapon(new BowAndArrowBehavior());
							break;
						case 1:
							listA.getplayer().setWeapon(new AxeBehavior());
							break;
						case 2:
							listA.getplayer().setWeapon(new KnifeBehavior());
							break;
						case 3:
							listA.getplayer().setWeapon(new SwordBehavior());
							break;
						}
					}
					//mostra um combatente por linha
					for(ListagemCombatentes combatentes : listaCombatentes) {
						System.out.println(combatentes);
					}
					System.out.println("------------Na lista");
					//mostra combatentes na mesma linha e dentro de uma lista
					System.out.println(listaCombatentes.toString());
					System.out.println("");
					break;
					//separar conteudo lista
					//Split("");
					
				case 2://---------------Combate 1v1 - 16 combatentes-----------------
					DecimalFormat dec = new DecimalFormat("#0.00");
					listaCombate1v1.clear();
					for (int i=0; i < 8; i++) {
						Character pessoa1 = null, pessoa2 = null;
						int p1 = random.nextInt(4);
						switch (p1) {
							case 0:
								pessoa1 = new King();
								break;
							case 1:
								pessoa1 = new Queen();
								break;
							case 2:
								pessoa1 = new Troll();
								break;
							case 3:
								pessoa1 = new Knight();
								break;
						}
						int p2 = random.nextInt(4);
						switch (p2) {
							case 0:
								pessoa2 = new King();
								break;
							case 1:
								pessoa2 = new Queen();
								break;
							case 2:
								pessoa2 = new Troll();
								break;
							case 3:
								pessoa2 = new Knight();
								break;
						}
						listaCombate1v1.add(new ListaCombateUmVersusUm(pessoa1, pessoa2));
					}
					for(ListaCombateUmVersusUm listB : listaCombate1v1) {
						int weapon1 = random.nextInt(4);
						switch (weapon1) {
						case 0:
							listB.getPessoa1().setWeapon(new BowAndArrowBehavior());
							break;
						case 1:
							listB.getPessoa1().setWeapon(new AxeBehavior());
							break;
						case 2:
							listB.getPessoa1().setWeapon(new KnifeBehavior());
							break;
						case 3:
							listB.getPessoa1().setWeapon(new SwordBehavior());
							break;
						}
						int weapon2 = random.nextInt(4);
						switch (weapon2) {
						case 0:
							listB.getPessoa2().setWeapon(new BowAndArrowBehavior());
							break;
						case 1:
							listB.getPessoa2().setWeapon(new AxeBehavior());
							break;
						case 2:
							listB.getPessoa2().setWeapon(new KnifeBehavior());
							break;
						case 3:
							listB.getPessoa2().setWeapon(new SwordBehavior());
							break;
						}
					}
					//--------------------------Batalha-----------------------
					for(int i=1; i<5; i++) {
						int j=0;						
						System.out.println("Fase "+ i + ": ");
						for(ListaCombateUmVersusUm cadaDuelo : listaCombate1v1) {
							System.out.print("Batalha " + ++j + ": ");
							System.out.println(cadaDuelo);
						}
						Character duelista1 = null, duelista2 = null;
						//lista para os vencedores
						List <ListaCombateUmVersusUm> listaVencedores = new ArrayList <> ();
						
						int cont = 0;
						for(ListaCombateUmVersusUm cadaDuelo : listaCombate1v1) {
							cont++;
							System.out.println("--------------------------------------------------------------------");
							System.out.println("\nBatalha " + cont + " - " + cadaDuelo +"\n");
							System.out.println("///////////////////////[Relatório da batalha]///////////////////////\n");
							while(cadaDuelo.batalhando()) {
								int turno = random.nextInt(2);
								switch (turno) {
									case 0:
										cadaDuelo.p1Ataca();
										break;
									case 1:
										cadaDuelo.p2Ataca();
										break;
									}
								System.out.println("\nVida de " + cadaDuelo.getPessoa1() + ": " + dec.format(cadaDuelo.getPessoa1().getVida()));
								System.out.println("Vida de " + cadaDuelo.getPessoa2() + ": " + dec.format(cadaDuelo.getPessoa2().getVida()) + "\n");
								}
							System.out.println("**********************************************************");
							System.out.println("Vencedor:" + cadaDuelo.quemVenceu());
							System.out.println("**********************************************************");
							vencedorDuelo = cadaDuelo.quemVenceu();
							//Buff para o vitorioso
							int tipo_elemento = random.nextInt(4);
							switch (tipo_elemento) {
								case 0:
										System.out.println("\n" + vencedorDuelo + " obteve controle sobre magias de fogo, aumentando em +20 seu dano");
										vencedorDuelo = new FireMagicBuff(vencedorDuelo);
										break;
									case 1:
										System.out.println("\n" + vencedorDuelo + " tem muitos espinhos em suas armas, aumentando em +15 seu dano");
										vencedorDuelo = new ThornsBuff(vencedorDuelo);
										break;
									case 2:
										System.out.println("\n" + vencedorDuelo + " Abusou muito de sua sorte chegando até aqui. Sem Buff para você!");
										break;
									case 3:
										System.out.println("\n" + vencedorDuelo + " tem uma animal feroz como ajudante, aumentando em +10 seu dano");
										vencedorDuelo = new BeastTamerBuff(vencedorDuelo);
										break;
								}
							System.out.println("\n-----------------------------------------------------------------------------------------------");
								if(vitoriaDaRodada==0) {
									//vencedor se torna futuro pessoa1
									duelista1 = vencedorDuelo;
									duelista1.recuperarMaxVida();
									vitoriaDaRodada = 1;
								}
								else {
									//vencedor se torna futuro pessoa2
									duelista2 = vencedorDuelo;
									duelista2.recuperarMaxVida();
									vitoriaDaRodada= 0;
									//e fecha um futuro novo combate 1v1
									listaVencedores.add (new ListaCombateUmVersusUm(duelista1, duelista2));
								}
								System.out.println("////////////////////////////////////////////////////////////////////////////////////////////\n");
							}
							listaCombate1v1 = listaVencedores;
							System.out.println("--------------------------------------------------------------------");
							if(i==4) {
								System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
								System.out.println("\nCampeão: " + duelista1);
								System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							}
						}
					}
			}while(tomadaDecisaoMenu != 0);		
		
	}
}
/*
 * Characters
	1. Considerando o conteudodo da aula de Strategy, faca o seguinte
	1.1 Escreva a classe abstrata que representa os personagens de jogo.
	1.2 Escolha um personagem de jogo arbitrario e implemente uma classe que o
		represente. Deve ser possivel alterar seu modo de ataque em tempo de execucao.
	1.3 Implemente as classes que representam os demais personagens.
 * Weapons
	1.4 Escreva a interface que representa comportamentos de ataque.
	1.5 Escreva as classes que representam comportamentos de ataque.
 * TesteMain
	1.6 Escreva uma classe de teste com metodo main em que:
	1.6.1 Uma lista de personagens eh preenchida com um personagem de cada tipo.
	1.6.2 Cada personagem deve ter um comportamento de ataque definido.
	
		*Batalhas 1 VS 1
	1.6.3 Percorra a lista fazendo com que cada um ataque.
		*Vitorioso PODE GANHAR arma mais forte
	1.6.4 Percorra a lista novamente, fazendo com que o comportamento de ataque de cada
	personagem na lista seja trocado para algum outro com probabilidade 0.25.
		Dica: Estude a classe Random do pacote java.util para sortear numeros pseudo aleatorios.
		
	2. Incremente o jogo da seguinte forma:
	2.1 Crie uma classe que contem duas instancias de personagens. Crie um ArrayList desse tipo.
	2.2 Crie uma classe com metodo main que cria 10 entradas na lista, aleatoriamente.
	2.3 Faca uma estrutura de repeticao que percorre a lista. A cada iteracao, sorteie com
		probabilidade 0.5 qual dos dois personagens ira atacar.
	2.4 Adicione um atributo vida (double) aos personagens. Todos comecam com vida 1 e,
		quando atacados, perdem 0.1 de vida.
	2.5 No metodo main, faca com que os elementos da lista se ataquem ate que reste
		somente um vivo e o declare campeao.
*/
