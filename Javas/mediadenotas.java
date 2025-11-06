package Javas;

import java.util.*;
import java.time.LocalTime;
import java.math.*;

public class mediadenotas {

  // Função de limpar a tela
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

  // Média de notas
  public static void calcularMedia(Scanner scanner, String name) {
    //declarações de variáveis
    int i;
    String rank;
    float media = 0;
    float notacorte = 0;
    float notarecuperacao = 0;
    int qntdnotas;
    //loop para perguntar nota de corte
    while (true) {
      try {
        System.out.println("-------- Bem vindo a calculadora de média de notas, " + name
            + "! --------\n\nPrimeiro, qual é a nota de corte que você quer usar?");
            String input = scanner.nextLine().trim();
            BigDecimal bd = new BigDecimal(input);
            int casasDecimais = bd.scale() < 0 ? 0 : bd.stripTrailingZeros().scale();
        if (casasDecimais > 2) {
            System.out.println("Coloque uma nota com, no máximo, 2 casas decimais");
            continue;
        }
        
        notacorte = Float.parseFloat(input);    
        if (notacorte > 10) {
            System.out.println("Coloque uma nota entre 0 e 10!");
            continue;
        }
        if (notacorte <= 0) {
          System.out.println("Nota de corte inválida! Use um número positivo e não 0.");
          continue;
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Digite um número válido.");
      }
    }
    //loop para perguntar nota de corte de recuperação
      while(true) {
      try {
        System.out.println("Agora, digite uma nota de corte para recuperação, " + name + ". (Digite 0 se não tiver recuperação.)");
            String input = scanner.nextLine().trim();
            BigDecimal bd = new BigDecimal(input);
            int casasDecimais = bd.scale() < 0 ? 0 : bd.stripTrailingZeros().scale();
                    if (casasDecimais > 2) {
            System.out.println("Coloque uma nota com, no máximo, 2 casas decimais");
            continue;
        }
        notarecuperacao = Float.parseFloat(input);
        if (notarecuperacao < 0 || notarecuperacao >= notacorte) {
          System.out.println("Nota de recuperação inválida! Use um número não-negativo e maior que a nota de corte.");
          continue;
        } 
        break;
      } catch(NumberFormatException e) {
        System.out.println("Entrada inválida! Digite um número válido!");
      }
    }
    //loop para perguntar quantas notas quer calcular
    while (true) {
      try {
        System.out.println("Quantas notas você quer calcular?");
        qntdnotas = Integer.parseInt(scanner.nextLine().trim());
        if (qntdnotas <= 0) {
          System.out.println("Quantidade inválida! Digite um número inteiro maior que 0.");
          continue;
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Digite um número inteiro para a quantidade de notas.");
      }
    }
    // loop para guardar as notas recebidas no array
        float[] notas = new float[qntdnotas];
        for (i = 0; i < qntdnotas; i++) {
            while (true) {
            try {
                System.out.println("Fale a " + (i + 1) + "° nota, " + name + ":");
                String input = scanner.nextLine().trim();
                BigDecimal bd = new BigDecimal(input);
                int casasDecimais = bd.scale() < 0 ? 0 : bd.stripTrailingZeros().scale();

            // verificacao de casas decimais
            if (casasDecimais > 2) {
                System.out.println("Nota inválida! Não é possível utilizar notas com mais de 2 casas decimais.");
                continue;
            }
            float nota = Float.parseFloat(input);

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida! Use um número entre 0 e 10.");
                continue;
            }
            notas[i] = nota;
            break;

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite apenas números (use ponto se necessário).");
        }
    }
}

   //calculo da variavel MEDIA
    media = 0;
    for (float x : notas) {
      media = media + x;
    }
    media = media / qntdnotas;
    //arredonda MEDIA. transforma em MEDIAARREDONDADA
    BigDecimal mediaarredondada = new BigDecimal(Float.toString(media));
    mediaarredondada = mediaarredondada.setScale(2, RoundingMode.HALF_UP);

    //verificação caso o usuário escolheu não ter recuperação (digitou 0) e vai definir o RANK (aprovado...)
    if(notarecuperacao == 0) {
      if (media >= notacorte) {
      rank = "aprovado";
      } else {
        rank = "reprovado";
      }
    } else {
          if (media >= notacorte) {
      rank = "aprovado";
    } else if (media < notacorte && media >= notarecuperacao){
      rank = "recuperação";
    } else {
      rank = "reprovado";
    }
  }
    //vai printar o array (transformei array em string) e printa a MEDIAARREDONDADA, junto com a verificação de ranks.
    System.out.println("Notas digitadas: " + Arrays.toString(notas));
    System.out.println("\n ----------- Sua média foi de " + mediaarredondada + ", " + name + ". Então você está " + rank + "! -----------");
  }

  // Public MAIN
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String name = "";
    // pede o nome
    limparTela();
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
      System.out.println("\nVocê deseja fazer cálculo de média ou sair?\n1 - Entrar\n\"N\" - SAIR");
      String choice = scanner.nextLine().trim();
      limparTela();

      switch (choice) {
        case "1":
        case "entrar":
        case "Entrar":
        case "ENTRAR":
         calcularMedia(scanner, name);
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