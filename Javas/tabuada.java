package Javas;

import java.util.*;
import java.time.LocalTime;

public class tabuada {
  //funcao de limpar a tela
  public static void limparTela(){
      System.out.println("\033[H\033[2J");
      System.out.flush();
    }
   
  // Pergunta se quer reiniciar
  public static boolean querReiniciar(Scanner scanner) {
    while (true) {
      System.out.println("\nDigite 's' para reiniciar ou 'n' para sair:");
      String resposta = scanner.nextLine().trim().toLowerCase();

      if (resposta.equals("s")) return true;
      if (resposta.equals("n")) return false;

      System.out.println("Opção inválida, tente novamente!");
    }
  }

  // Validação de nome
  public static boolean validarNome(String name) {
    if (name.isEmpty()) {
      System.out.println("Digite um nome válido espertinho!");
      return false;
    }
    if (!name.matches("[a-zA-Zá-úÁ-Ú]+")) {
      System.out.println("Digite um nome sem caracteres especiais e sem espaço!");
      return false;
    }
    return true;
  }    
  
  // Tabuada
  public static void tabuadaFuncao(Scanner scanner, String name) {
        int numero = 0;

        // loop
        while (true) {
            try {
                System.out.println("Olá, " + name + "! Digite o número da tabuada que deseja: ");
                numero = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números inteiros.");
                continue;
            }
        }

        limparTela();

        System.out.println("Tabuada do " + numero + " para você, " + name + ":\n");

        // Tabuada de 0 a 10
        for (int i = 0; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

    }
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String name = "";

    limparTela();
    // pede o nome
    while (true) {
      System.out.println("Qual seu nome?");
      name = scanner.nextLine().trim();

      if (!validarNome(name)) {
        continue;
      }
      // Letra maiúscula
      if (Character.isLowerCase(name.charAt(0))) {
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
      }

        int hour = LocalTime.now().getHour();
        int minute = LocalTime.now().getMinute();

        if (hour >= 6 && hour < 12) {
             System.out.println("\nBom dia, " + name + "!\nA hora atual é: " + hour + "h" + minute + "min");
        } else if (hour >= 12 && hour  < 18) {
             System.out.println("\nBoa tarde, " + name + "!\nA hora atual é: " + hour + "h" + minute + "min");
        } else {
             System.out.println("\nBoa noite, " + name + "!\nLA hora atual é: " + hour + "h" + minute + "min");
        }
        break;
    }
    // Opções
    boolean continuar = true;
    while (continuar) {
      System.out.println("\nVocê deseja fazer a tabuada ou sair?\n1 - Entrar\n\"N\" - SAIR");
      String choice = scanner.nextLine().trim();

      switch (choice) {
        case "1":
        case "entrar":
        case "Entrar":
        case "ENTRAR":
         tabuadaFuncao(scanner, name);
         break;
        case "N":
        case "n":
         continuar = false;
         break;
        default:
          System.out.println("Você precisa digitar alguma das opções!");
          continue;
      }
       if (!continuar) {
        break;
      } 
      
      // Funcao de reiniciar
      if (!querReiniciar(scanner)) {
        continuar = false;
      }
    }

    System.out.println("Obrigado por usar o programa, " + name + "! Até logo.");
    scanner.close();
  }
}