package jogodavelha;

import java.util.Scanner;

public class main {
	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		char[][] tabuleiro = {{' ', ' ', ' '},
		                      {' ', ' ', ' '},
		                      {' ', ' ', ' '}};
		
		
		
		System.out.println("TUTORIAL:\nDigite um numero de 1 a 9 para escolher o espaço que você quer marcar.\nSendo 1, 2 e 3 os tres espaços de cima da esquerda\npara direita, 4, 5 e 6 os espaços do meio, da esquerda para direita\n e 7, 8 e 9 os espaços de baixo, da esuqera para direita");
		System.out.println("Lembrando que não pode usar lugares já ocupados!!\n");
		desenhaTabuleiro(tabuleiro);
		
		while(true) {
			movimentoj1(tabuleiro, input);
			
			if(verificaJogo(tabuleiro)) 
				break;
			desenhaTabuleiro(tabuleiro);
			movimentoj2(tabuleiro, input);
			if(verificaJogo(tabuleiro)) 
				break;
			desenhaTabuleiro(tabuleiro);
		}
		
		
		input.close();
	}

	private static boolean verificaJogo(char[][] tabuleiro) {
		
		if((tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X')|| 
		   (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X')||
		   (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X')||
		   (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X')||
		   (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X')||
		   (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X')||
		   (tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X')||
		   (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X')) {
			desenhaTabuleiro(tabuleiro);
				System.out.println("Jogador 1(X) venceu!");
				
				return true;
		}
		
		if((tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O')||
		   (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O')||
		   (tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O')||
		   (tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O')||
		   (tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O')||
		   (tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O')||
		   (tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O')||
		   (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O')) {
			desenhaTabuleiro(tabuleiro);
				System.out.println("Jogador 2(O) venceu!");
						
				return true;
		}
		
		for(int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[i].length; j++) {
				if(tabuleiro[i][j] == ' ')
					return false;
			}
		}
		desenhaTabuleiro(tabuleiro);
		System.out.println("Deu velha!");
		return true;
	}

	private static void movimentoj1(char[][] tabuleiro, Scanner input) {
		String entrada;
	
		while(true) {
			System.out.println("Escolha o espaço que você quer jogar:");
			entrada = input.nextLine();
			if(espacoDisponivel(tabuleiro, Integer.parseInt(entrada))) 
					break;
			else
				System.out.println(entrada+ " não é um espaço disponivel.");
		}
		jogada(tabuleiro, entrada, 'X');
	}
	
	private static void movimentoj2(char[][] tabuleiro, Scanner input) {
		String entrada;
		
		while(true) {
			System.out.println("Escolha o espaço que você quer jogar:");
			entrada = input.nextLine();
			if(espacoDisponivel(tabuleiro, Integer.parseInt(entrada))) 
				break;
			else
				System.out.println(entrada+ " não é um espaço disponivel.");
		}
		jogada(tabuleiro, entrada, 'O');
	}


	private static void desenhaTabuleiro(char[][] tabuleiro) {
		System.out.println(tabuleiro[0][0] +"|"+tabuleiro[0][1] +"|"+tabuleiro[0][2]);
		System.out.println("-+-+-");
		System.out.println(tabuleiro[1][0] +"|"+tabuleiro[1][1] +"|"+tabuleiro[1][2]);
		System.out.println("-+-+-");
		System.out.println(tabuleiro[2][0] +"|"+tabuleiro[2][1] +"|"+tabuleiro[2][2]);
	}
	
	private static boolean espacoDisponivel(char[][] tabuleiro, int posicao) {
		
		switch(posicao) {
		case 1: 
			return (tabuleiro[0][0] == ' ');
		case 2: 
			return (tabuleiro[0][1] == ' ');
		case 3: 
			return (tabuleiro[0][2] == ' ');
		case 4: 
			return (tabuleiro[1][0] == ' ');
		case 5: 
			return (tabuleiro[1][1] == ' ');
		case 6: 
			return (tabuleiro[1][2] == ' ');
		case 7: 
			return (tabuleiro[2][0] == ' ');
		case 8: 
			return (tabuleiro[2][1] == ' ');
		case 9: 
			return (tabuleiro[2][2] == ' ');
		default: return false;
		}
	}
	
	public static void jogada(char[][] tabuleiro, String posicao, char simbolo) {
		
		switch(posicao) {
		case "1": 
			tabuleiro[0][0] = simbolo;
			break;
		case "2": 
			tabuleiro[0][1] = simbolo;
			break;
		case "3": 
			tabuleiro[0][2] = simbolo;
			break;
		case "4": 
			tabuleiro[1][0] = simbolo;
			break;
		case "5": 
			tabuleiro[1][1] = simbolo;
			break;
		case "6": 
			tabuleiro[1][2] = simbolo;
			break;
		case "7": 
			tabuleiro[2][0] = simbolo;
			break;
		case "8": 
			tabuleiro[2][1] = simbolo;
			break;
		case "9": 
			tabuleiro[2][2] = simbolo;
			break;
		default:
			System.out.println("Apenas números de 1 a 9!!");
		}
	}
}