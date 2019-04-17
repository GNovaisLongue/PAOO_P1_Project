package strategy_battle_arenaMain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class CombateMain {
	public static void main(String[] args) {
		Random random = new Random();
		List<ListaCombateUmVersusUm> listaCombate1v1 = new ArrayList<>();
		int vitoriaDaRodada = 0; // (flag)quem venceu o duelo 1v1 e avanca
		int armaExtra; // (Decorator)ganha um dano extra entre 4 possibilidades
		Character vencedorDuelo;// quem venceu sua partida
		/////////////////////////////////////////////////////////////////////

		DecimalFormat dec = new DecimalFormat("#0.00");
		listaCombate1v1.clear();
		for (int i = 0; i < 8; i++) {
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
		for (ListaCombateUmVersusUm listB : listaCombate1v1) {
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

		// --------------------------Batalha-----------------------
		for (int i = 1; i < 5; i++) {
			int j = 0;
			System.out.println("Fase " + i + ": ");
			for (ListaCombateUmVersusUm cadaDuelo : listaCombate1v1) {
				System.out.print("Batalha " + ++j + ": ");
				System.out.println(cadaDuelo);
			}
			Character duelista1 = null, duelista2 = null;
			// lista para os vencedores
			List<ListaCombateUmVersusUm> listaVencedores = new ArrayList<>();

			int cont = 0;
			for (ListaCombateUmVersusUm cadaDuelo : listaCombate1v1) {
				cont++;
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\nBatalha " + cont + " - " + cadaDuelo + "\n");
				System.out.println("///////////////////////[Relatório da batalha]///////////////////////\n");
				while (cadaDuelo.batalhando()) {
					int turno = random.nextInt(2);
					switch (turno) {
						case 0:
							cadaDuelo.p1Ataca();
							break;
						case 1:
							cadaDuelo.p2Ataca();
							break;
					}
					System.out
							.println("\nVida de " + cadaDuelo.getPessoa1() + ": " + dec.format(cadaDuelo.getPessoa1().getVida()));
					System.out.println(
							"Vida de " + cadaDuelo.getPessoa2() + ": " + dec.format(cadaDuelo.getPessoa2().getVida()) + "\n");
				}
				System.out.println("**********************************************************");
				System.out.println("Vencedor:" + cadaDuelo.quemVenceu());
				System.out.println("**********************************************************");
				vencedorDuelo = cadaDuelo.quemVenceu();
				// Buff para o vitorioso
				int tipo_elemento = random.nextInt(4);
				switch (tipo_elemento) {
					case 0:
						System.out
								.println("\n" + vencedorDuelo + " obteve controle sobre magias de fogo, aumentando em +20 seu dano");
						vencedorDuelo = new FireMagicBuff(vencedorDuelo);
						break;
					case 1:
						System.out.println("\n" + vencedorDuelo + " tem muitos espinhos em suas armas, aumentando em +15 seu dano");
						vencedorDuelo = new ThornsBuff(vencedorDuelo);
						break;
					case 2:
						System.out
								.println("\n" + vencedorDuelo + " Abusou muito de sua sorte chegando até aqui. Sem Buff para você!");
						break;
					case 3:
						System.out
								.println("\n" + vencedorDuelo + " tem uma animal feroz como ajudante, aumentando em +10 seu dano");
						vencedorDuelo = new BeastTamerBuff(vencedorDuelo);
						break;
				}
				System.out.println(
						"\n-----------------------------------------------------------------------------------------------");
				if (vitoriaDaRodada == 0) {
					// vencedor se torna futuro pessoa1
					duelista1 = vencedorDuelo;
					duelista1.recuperarMaxVida();
					vitoriaDaRodada = 1;
				} else {
					// vencedor se torna futuro pessoa2
					duelista2 = vencedorDuelo;
					duelista2.recuperarMaxVida();
					vitoriaDaRodada = 0;
					// e fecha um futuro novo combate 1v1
					listaVencedores.add(new ListaCombateUmVersusUm(duelista1, duelista2));
				}
				System.out
						.println("///////////////////////////////////////////////////////////////////////////////////////////\n");
			}
			listaCombate1v1 = listaVencedores;
			if (i == 4) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------");
				System.out.println("\nCampeão: " + duelista1);
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------------------");
			}
		}
	}

}
