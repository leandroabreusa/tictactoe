package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char[][] dados = new char[3][3];
        String comando;
        boolean finish = false;
        char jogador1 = 'X', jogador2 = 'O';

        while (!finish) {
            boolean continua = true, entradaCerta, playerVsBot = false, botVsPlayer = false,
                    playerVsPlayer = false, botVsBot = false,
                    botMVsPlayer = false, playerVsBotM = false,
                    botMVsBot = false, botVsBotM = false, botMVsBotM = false,
                    playerVsBotH = false, botHVsPlayer = false, botHVsBotH = false,
                    botHvsBot = false, botHvsBotM = false, botMVsBotH = false,
                    botVsBotH = false;

            System.out.print("Input command: ");
            comando = teclado.nextLine();

            switch (comando) {
                case "start easy user":
                    entradaCerta = true;
                    botVsPlayer = true;
                    break;
                case "start easy easy":
                    entradaCerta = true;
                    botVsBot = true;
                    break;
                case "start user user":
                    entradaCerta = true;
                    playerVsPlayer = true;
                    break;
                case "start user easy":
                    entradaCerta = true;
                    playerVsBot = true;
                    break;
                case "start user medium":
                    entradaCerta = true;
                    playerVsBotM = true;
                    break;
                case "start medium easy":
                    entradaCerta = true;
                    botMVsBot = true;
                    break;
                case "start easy medium":
                    entradaCerta = true;
                    botVsBotM = true;
                    break;
                case "start medium user":
                    entradaCerta = true;
                    botMVsPlayer = true;
                    break;
                case "start medium medium":
                    entradaCerta = true;
                    botMVsBotM = true;
                    break;
                case "exit":
                    finish = true;
                    entradaCerta = true;
                    break;
                default:
                    entradaCerta = false;
                    break;
            }

            if (entradaCerta && !finish) {

                if (playerVsBot) {
                    impressao(dados);

                    while (continua) {
                        dados = leitura(dados, jogador1);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = movimentoFacil(dados, jogador2);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                } else if (botVsBot) {
                    impressao(dados);

                    while (continua) {
                        dados = movimentoFacil(dados, jogador1);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = movimentoFacil(dados, jogador2);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                } else if (playerVsPlayer) {
                    impressao(dados);

                    while (continua) {
                        dados = leitura(dados, jogador1);
                        impressao(dados);
                        continua = resultado(dados);
                        if (continua) {
                            dados = leitura(dados, jogador2);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                } else if (botVsPlayer) {
                    impressao(dados);

                    while (continua) {
                        dados = movimentoFacil(dados, jogador1);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = leitura(dados, jogador2);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                } else if (botMVsPlayer) {
                    impressao(dados);

                while (continua) {
                    dados = movimentoMedio(dados, jogador1, jogador2);
                    impressao(dados);
                    continua = resultado(dados);

                    if (continua) {
                        dados = leitura(dados, jogador2);
                        impressao(dados);
                        continua = resultado(dados);

                        if (!continua)
                            break;
                        }
                    }
                } else if (playerVsBotM) {
                    impressao(dados);

                    while (continua) {
                        dados = leitura(dados, jogador1);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = movimentoMedio(dados, jogador2, jogador1);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                } else if (botVsBotM) {
                    impressao(dados);

                    while (continua) {
                        movimentoFacil(dados, jogador1);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = movimentoMedio(dados, jogador2, jogador1);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                } else if (botMVsBot) {
                    impressao(dados);

                    while (continua) {
                        dados = movimentoMedio(dados, jogador1, jogador2);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = movimentoFacil(dados, jogador2);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                            }
                        }
                }
                else {
                    impressao(dados);

                    while (continua) {
                        dados = movimentoMedio(dados, jogador1, jogador2);
                        impressao(dados);
                        continua = resultado(dados);

                        if (continua) {
                            dados = movimentoMedio(dados, jogador2, jogador1);
                            impressao(dados);
                            continua = resultado(dados);

                            if (!continua)
                                break;
                        }
                    }
                }
            } else
                System.out.println("Bad parameters!");
        }
    }
    static void impressao(String dados) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", dados[0][0], dados[0][1], dados[0][2]);
        System.out.printf("| %c %c %c |\n", dados[1][0], dados[1][1], dados[1][2]);
        System.out.printf("| %c %c %c |\n", dados[2][0], dados[2][1], dados[2][2]);
        System.out.println("---------");
    }

    public static String leitura(char[][] dados, char letra) {
        Scanner teclado = new Scanner(System.in);

        boolean termina = false;

        while (!termina) {
            int coordenada1, coordenada2;

            System.out.print("Enter the coordinates: ");
            boolean teste1 = teclado.hasNextInt();
            boolean teste2 = teclado.hasNextInt();

            if (teste1 && teste2) {
                coordenada1 = teclado.nextInt();
                coordenada2 = teclado.nextInt();

                if (coordenada1 > 0 && coordenada1 < 4 && coordenada2 > 0 && coordenada2 < 4) {
                        coordenada1 -= 1;
                        coordenada2 -= 1;

                        if (dados[coordenada1][coordenada2] == ' ') {
                            dados[coordenada1][coordenada2] = letra;

                            termina = true;
                        } else
                            System.out.println("This cell is occupied! Choose another one!");

                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");

                teclado.nextLine();
            }
        }
        return dados;
    }

    static boolean resultado(char[][] dados) {

        if (dados[0][0] == 'X' && dados[0][1] == 'X' && dados[0][2] == 'X' || dados[1][0] == 'X' && dados[1][1] == 'X' && dados[1][2] == 'X' ||
                dados[2][0] == 'X' && dados[2][1] == 'X' && dados[2][2] == 'X' || dados[0][0] == 'X' && dados[1][1] == 'X' && dados[2][2] == 'X' ||
                dados[0][2] == 'X' && dados[1][1] == 'X' && dados[2][0] == 'X' || dados[0][0] == 'X' && dados[1][0] == 'X' && dados[2][0] == 'X' ||
                dados[0][1] == 'X' && dados[1][1] == 'X' && dados[2][1] == 'X' || dados[0][2] == 'X' && dados[1][2] == 'X' && dados[2][2] == 'X') {
            System.out.println("X wins");
            return false;
        } else if (dados[0][0] == 'O' && dados[0][1] == 'O' && dados[0][2] == 'O' || dados[1][0] == 'O' && dados[1][1] == 'O' && dados[1][2] == 'O' ||
                dados[2][0] == 'O' && dados[2][1] == 'O' && dados[2][2] == 'O' || dados[0][0] == 'O' && dados[1][1] == 'O' && dados[2][2] == 'O' ||
                dados[0][2] == 'O' && dados[1][1] == 'O' && dados[2][0] == 'O' || dados[0][0] == 'O' && dados[1][0] == 'O' && dados[2][0] == 'O' ||
                dados[0][1] == 'O' && dados[1][1] == 'O' && dados[2][1] == 'O' || dados[0][2] == 'O' && dados[1][2] == 'O' && dados[2][2] == 'O') {
            System.out.println("O wins");
            return false;
        } else if (dados[0][0] == ' ' || dados[0][1] == ' ' || dados[0][2] == ' ' || dados[1][0] == ' ' || dados[1][1] == ' ' || dados[1][2] == ' ' ||
                dados[2][0] == ' ' || dados[2][1] == ' ' || dados[2][2] == ' ')
            return true;
        else {
            System.out.println("Draw");
            return false;
        }
    }

    static String movimentoFacil(char[][] dados, char letra) {
        Random random = new Random();
        boolean finaliza = false;

        System.out.println("Making move level \"easy\"");

        while (!finaliza) {
            int aleatorio1 = random.nextInt(3);
            int aleatorio2 = random.nextInt(3);

            for (int i = aleatorio; i < 9 && !finaliza; i++) {
                if (dados.charAt(i) == ' ') {
                    if (i == 8)
                        dados = dados.substring(0, i) + letra;
                    else
                        dados = dados.substring(0, i) + letra + dados.substring(i + 1);

                    finaliza = true;
                }
            }
        }

        return dados;
    }

    public static String movimentoMedio(String dados, char letra, char letraoposta) {
        Random random = new Random();

        boolean finaliza = false;
        int verifica = verificaMedio(dados, letraoposta);

        System.out.println("Making move level \"medium\"");

        if (verifica == -1) {
            while (!finaliza) {
                int aleatorio = random.nextInt(9);

                for (int i = aleatorio; i < 9 && !finaliza; i++) {
                    if (dados.charAt(i) == ' ') {
                        if (i == 8)
                            dados = dados.substring(0, i) + letra;
                        else
                            dados = dados.substring(0, i) + letra + dados.substring(i + 1);

                        finaliza = true;
                    }
                }
            }
        } else {

            if (verifica == 8)
                dados = dados.substring(0, verifica) + letra;
            else
                dados = dados.substring(0, verifica) + letra + dados.substring(verifica + 1);
        }

        return dados;
    }


    private static int verificaMedio(String dados, char letra)
    {
        if (dados.charAt(0) == letra && dados.charAt(1) == letra && dados.charAt(2) == ' ')
            return 2;

        if (dados.charAt(0) == letra && dados.charAt(1) == ' ' && dados.charAt(2) == letra)
            return 1;

        if (dados.charAt(0) == ' ' && dados.charAt(1) == letra && dados.charAt(2) == letra)
            return 0;

        if (dados.charAt(3) == letra && dados.charAt(4) == letra && dados.charAt(5) == ' ')
            return 5;

        if (dados.charAt(3) == letra && dados.charAt(4) == ' ' && dados.charAt(5) == letra)
            return 4;

        if (dados.charAt(3) == ' ' && dados.charAt(4) == letra && dados.charAt(5) == letra)
            return 3;

        if (dados.charAt(6) == letra && dados.charAt(7) == letra && dados.charAt(8) == ' ')
            return 8;

        if (dados.charAt(6) == letra && dados.charAt(7) == ' ' && dados.charAt(8) == letra)
            return 7;

        if (dados.charAt(6) == ' ' && dados.charAt(7) == letra && dados.charAt(8) == letra)
            return 6;

        if (dados.charAt(0) == letra && dados.charAt(4) == letra && dados.charAt(8) == ' ')
            return 8;

        if (dados.charAt(0) == letra && dados.charAt(4) == ' ' && dados.charAt(8) == letra)
            return 4;

        if (dados.charAt(0) == ' ' && dados.charAt(4) == letra && dados.charAt(8) == letra)
            return 0;

        if (dados.charAt(2) == letra && dados.charAt(4) == letra && dados.charAt(6) == ' ')
            return 6;

        if (dados.charAt(2) == letra && dados.charAt(4) == ' ' && dados.charAt(6) == letra)
            return 4;

        if (dados.charAt(2) == ' ' && dados.charAt(4) == letra && dados.charAt(6) == letra)
            return 2;

        return -1;
    }

}
