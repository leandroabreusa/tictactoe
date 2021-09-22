package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String dados = "         ";
        boolean continua = true;
        char jogador1 = 'X', jogador2 = 'O';

        while (continua) {
            impressao(dados);
            dados = leitura(dados, jogador1);
            impressao(dados);
            continua = resultado(dados);
            if (! continua)
                break;
            else {
                dados = leitura(dados, jogador2);
                impressao(dados);
                continua = resultado(dados);

                if (! continua)
                    break;
            }
        }
    }

    static void impressao(String dados) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", dados.charAt(0), dados.charAt(1), dados.charAt(2));
        System.out.printf("| %c %c %c |\n", dados.charAt(3), dados.charAt(4), dados.charAt(5));
        System.out.printf("| %c %c %c |\n", dados.charAt(6), dados.charAt(7), dados.charAt(8));
        System.out.println("---------");
    }

    public static String leitura(String dados, char letra) {
        Scanner teclado = new Scanner(System.in);

        boolean termina = false;

        while (! termina) {
            int coordenada1, coordenada2;

            System.out.print("Enter the coordinates: ");
            boolean teste1 = teclado.hasNextInt();
            boolean teste2 = teclado.hasNextInt();

            if (teste1 && teste2) {
                coordenada1 = teclado.nextInt();
                coordenada2 = teclado.nextInt();

                if (coordenada1 > 0 && coordenada1 < 4 && coordenada2 > 0 && coordenada2 < 4) {
                    if (coordenada1 == 1) {
                        coordenada2 -= 1;

                        if (dados.charAt(coordenada2) == ' ') {
                            dados = dados.substring (0, coordenada2) + letra + dados.substring (coordenada2+1);

                            System.out.println("---------");
                            System.out.printf("| %c %c %c |\n", dados.charAt(0), dados.charAt(1), dados.charAt(2));
                            System.out.printf("| %c %c %c |\n", dados.charAt(3), dados.charAt(4), dados.charAt(5));
                            System.out.printf("| %c %c %c |\n", dados.charAt(6), dados.charAt(7), dados.charAt(8));
                            System.out.println("---------");

                            termina = true;
                        } else
                            System.out.println("This cell is occupied! Choose another one!");
                    }
                    else if (coordenada1 == 2) {
                        int somaCoordenada = coordenada1 + coordenada2;

                        if (dados.charAt(somaCoordenada) == ' ') {
                            dados = dados.substring (0, somaCoordenada) + letra + dados.substring (somaCoordenada+1);

                            System.out.println("---------");
                            System.out.printf("| %c %c %c |\n", dados.charAt(0), dados.charAt(1), dados.charAt(2));
                            System.out.printf("| %c %c %c |\n", dados.charAt(3), dados.charAt(4), dados.charAt(5));
                            System.out.printf("| %c %c %c |\n", dados.charAt(6), dados.charAt(7), dados.charAt(8));
                            System.out.println("---------");

                            termina = true;
                        } else
                            System.out.println("This cell is occupied! Choose another one!");
                    }
                    else
                    {
                        coordenada1 *= 2;
                        coordenada2 -= 1;
                        int soma3 = coordenada1 + coordenada2;

                        if (dados.charAt(soma3) == ' ') {
                            dados = dados.substring (0, soma3) + letra + dados.substring (soma3+1);

                            System.out.println("---------");
                            System.out.printf("| %c %c %c |\n", dados.charAt(0), dados.charAt(1), dados.charAt(2));
                            System.out.printf("| %c %c %c |\n", dados.charAt(3), dados.charAt(4), dados.charAt(5));
                            System.out.printf("| %c %c %c |\n", dados.charAt(6), dados.charAt(7), dados.charAt(8));
                            System.out.println("---------");

                            termina = true;
                        } else
                            System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
            else
                System.out.println("You should enter numbers!");
        }

        return dados;
    }

    static boolean resultado(String dados) {
        int countX = 0, countO = 0, countUnderline = 0;

        for (int i = 0; i < 9; i++)
        {
            if (dados.charAt(i) == 'X')
                countX++;
            else if (dados.charAt(i) == 'O')
                countO++;
            else
                countUnderline++;
        }

        if (countX > countO+1 || countO > countX+1 ||
                dados.charAt(0) == 'X' && dados.charAt(3) == 'X' && dados.charAt(6) == 'X' && dados.charAt(1) == 'O' && dados.charAt(4) == 'O' && dados.charAt(7) == 'O' ||
                dados.charAt(0) == 'X' && dados.charAt(3) == 'X' && dados.charAt(6) == 'X' && dados.charAt(2) == 'O' && dados.charAt(5) == 'O' && dados.charAt(8) == 'O' ||
                dados.charAt(0) == 'O' && dados.charAt(3) == 'O' && dados.charAt(6) == 'O' && dados.charAt(1) == 'X' && dados.charAt(4) == 'X' && dados.charAt(7) == 'X' ||
                dados.charAt(0) == 'O' && dados.charAt(3) == 'O' && dados.charAt(6) == 'O' && dados.charAt(2) == 'X' && dados.charAt(5) == 'X' && dados.charAt(8) == 'X' ||
                dados.charAt(1) == 'X' && dados.charAt(4) == 'X' && dados.charAt(7) == 'X' && dados.charAt(2) == 'O' && dados.charAt(5) == 'O' && dados.charAt(8) == 'O' ||
                dados.charAt(1) == 'O' && dados.charAt(4) == 'O' && dados.charAt(7) == 'O' && dados.charAt(2) == 'X' && dados.charAt(5) == 'X' && dados.charAt(8) == 'X' ) {
            System.out.println("Impossible");
            return false;
        }
        else if (dados.charAt(0) == 'X' && dados.charAt(1) == 'X' && dados.charAt(2) == 'X' || dados.charAt(3) == 'X' && dados.charAt(4) == 'X' && dados.charAt(5) == 'X' ||
                dados.charAt(6) == 'X' && dados.charAt(7) == 'X' && dados.charAt(8) == 'X' || dados.charAt(0) == 'X' && dados.charAt(4) == 'X' && dados.charAt(8) == 'X' ||
                dados.charAt(2) == 'X' && dados.charAt(4) == 'X' && dados.charAt(6) == 'X' || dados.charAt(0) == 'X' && dados.charAt(3) == 'X' && dados.charAt(6) == 'X' ||
                dados.charAt(1) == 'X' && dados.charAt(4) == 'X' && dados.charAt(7) == 'X' || dados.charAt(2) == 'X' && dados.charAt(5) == 'X' && dados.charAt(8) == 'X') {
            System.out.println("X wins");
            return false;
        }
        else if (dados.charAt(0) == 'O' && dados.charAt(1) == 'O' && dados.charAt(2) == 'O' || dados.charAt(3) == 'O' && dados.charAt(4) == 'O' && dados.charAt(5) == 'O' ||
                dados.charAt(6) == 'O' && dados.charAt(7) == 'O' && dados.charAt(8) == 'O'  || dados.charAt(0) == 'O' && dados.charAt(4) == 'O' && dados.charAt(8) == 'O' ||
                dados.charAt(2) == 'O' && dados.charAt(4) == 'O' && dados.charAt(6) == 'O'  || dados.charAt(0) == 'O' && dados.charAt(3) == 'O' && dados.charAt(6) == 'O' ||
                dados.charAt(1) == 'O' && dados.charAt(4) == 'O' && dados.charAt(7) == 'O'  || dados.charAt(2) == 'O' && dados.charAt(5) == 'O' && dados.charAt(8) == 'O') {
            System.out.println("O wins");
            return false;
        }
        else if (countUnderline > 0) {
            return true;
        }
        else {
            System.out.println("Draw");
            return false;
        }
    }
}
