package Javas;

import java.util.*;
import java.time.LocalTime;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CodigoFazTudo2 {

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

  // CalcularIMC
  public static void calcularIMC(Scanner scanner, String name) {
    float altura = 0;
    float peso = 0;
    float IMC;
    String rank = "";
// altura
    while (true) {
      try {
        System.out.println("-------- Bem vindo a calculadora de IMC, " + name
            + "! --------\n\nQual é sua altura? (UTILIZE PONTO PARA SEPARAR, TIPO '1.70')");
        altura = Float.parseFloat(scanner.nextLine().trim());
        if (altura <= 0) {
          System.out.println("Altura inválida! Digite um valor maior que 0.");
          continue;
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Formato inválido! Use ponto como separador, exemplo: 1.70 (não use vírgula ou letras).");
      }
    }
// peso
    while (true) {
      try {
        System.out.println("Beleza, " + name + ". Agora, Qual é o seu peso em kilos?");
        peso = Float.parseFloat(scanner.nextLine().trim());
        if (peso <= 0) {
          System.out.println("Peso inválido! Digite um valor maior que 0.");
          continue;
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Formato inválido! Digite apenas números (use ponto se necessário).");
      }
    }

    // Calculo
    IMC = peso / (altura * altura);
    if (IMC <= 18.5) {
      rank = "Abaixo do peso normal";
    } else if (IMC <= 24.9) {
      rank = "Peso normal";
    } else if (IMC <= 29.9) {
      rank = "Excesso de peso";
    } else if (IMC <= 34.9) {
      rank = "Obesidade Classe 1";
    } else if (IMC <= 39.9) {
      rank = "Obesidade Classe 2";
    } else {
      rank = "Obesidade Classe 3";
    }

    System.out.println("Perfeito! Seu IMC é: " + IMC + ". Sua classificação é: " + rank + ".");
  }

  // Triangulos
  public static void calcularTriangulo(Scanner scanner, String name) {
    double ladoA = 0, ladoB = 0, ladoC = 0;
    while (true) {
      try {
        System.out.println("-------- Bem vindo a calculadora de tipos de triângulos, " + name
            + "! --------\n\nImagine um triângulo. Diga-me o primeiro lado do triângulo, em metros.");
        ladoA = Double.parseDouble(scanner.nextLine().trim());

        System.out.println("Perfeito. Agora, me diga o segundo lado.");
        ladoB = Double.parseDouble(scanner.nextLine().trim());

        System.out.println("Beleza, " + name + "! Agora me fale o terceiro lado.");
        ladoC = Double.parseDouble(scanner.nextLine().trim());

        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
          System.out.println(name + "... O número dos lados precisam ser positivos...\n");
          continue;
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Digite apenas números (use ponto se necessário). Vamos recomeçar a entrada dos lados.");
      }
    }

    String rank = "";
    if (ladoA == ladoB && ladoB == ladoC) {
      rank = "Triângulo Equilátero";
    } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
      rank = "Triângulo isóceles";
    } else {
      rank = "Triângulo Escaleno";
    }

    System.out.println("Perfeito! Seu triângulo se classifica como: " + rank + ". E seus lados são: \n Lado 1: "
        + ladoA + ".\n Lado 2: " + ladoB + ".\n Lado 3: " + ladoC + ".");
  }

  // Vogais
  public static void contarVogais(Scanner scanner, String name) {
    System.out.println("-------- Bem vindo a calculadora de vogais, " + name + "! --------\n\nFale qualquer palavra que eu conto!");
    String word = scanner.nextLine().trim();

    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = Character.toLowerCase(word.charAt(i));
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        count++;
      }
    }
    System.out.println("Número de vogais da sua palavra \"" + word + "\" é de " + count + " vogais!");
  }

  // PA e PG
  public static void verificarPAPG(Scanner scanner, String name) {
    float firstnumber = 0, secondnumber = 0, thirdnumber = 0;
    while (true) {
      try {
        System.out.println("-------- Bem vindo a calculadora de PG e PA, " + name
            + "! --------\n\nEscreva o primeiro número de sua sequencia: ");
        firstnumber = Float.parseFloat(scanner.nextLine().trim());

        System.out.println(name + ", escreva o segundo número de sua sequencia: ");
        secondnumber = Float.parseFloat(scanner.nextLine().trim());

        System.out.println(name + ", escreva o teceiro número de sua sequencia: ");
        thirdnumber = Float.parseFloat(scanner.nextLine().trim());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Digite números válidos (use ponto se necessário). Vamos tentar novamente.");
      }
    }

    float x = thirdnumber - secondnumber;
    float y = secondnumber - firstnumber;
    final float EPS = 1e-6f;

    boolean isPA = Math.abs(x - y) < EPS;

    boolean isPG = false;
    if (Math.abs(firstnumber) < EPS && Math.abs(secondnumber) < EPS && Math.abs(thirdnumber) < EPS) {
      // excessão de 0,0,0
      isPG = true;
    } else if (Math.abs(firstnumber) > EPS && Math.abs(secondnumber) > EPS) {
      float r1 = secondnumber / firstnumber;
      float r2 = thirdnumber / secondnumber;
      if (Math.abs(r1 - r2) < EPS) {
        isPG = true;
      }
    }

    if (!isPA && !isPG) {
      System.out.println(name + ", isso não é uma progressão aritmética nem geométrica!");
    } else if (isPA) {
      System.out.println(name + ", sua sequencia é uma PA (Progressão aritmética). E sua razão é: " + y + "!");
    } else { // PG
      float razao = (Math.abs(secondnumber) > EPS && Math.abs(firstnumber) > EPS) ? (secondnumber / firstnumber) : 0f;
      System.out.println(name + ", sua sequencia é uma PG (Progressão geométrica). E sua razão é: " + razao + "!");
    }
  }

  // Média de notas
  public static void calcularMedia(Scanner scanner, String name) {
    int i;
    String rank;
    float media = 0;
    float notacorte = 0;
    float notarecuperacao = 0;

    while (true) {
      try {
        System.out.println("-------- Bem vindo a calculadora de média de notas, " + name
            + "! --------\n\nPrimeiro, qual é a nota de corte que você quer usar?");
        notacorte = Float.parseFloat(scanner.nextLine().trim());
        if (notacorte <= 0) {
          System.out.println("Nota de corte inválida! Use um número positivo e não 0.");
          continue;
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Digite um número válido.");
      }
    }

      while(true) {
      try {
        System.out.println("Agora, digite uma nota de corte para recuperação, " + name + ". (Digite 0 se não tiver recuperação.)");
        notarecuperacao = Float.parseFloat(scanner.nextLine().trim());
        if (notarecuperacao < 0 || notarecuperacao >= notacorte) {
          System.out.println("Nota de recuperação inválida! Use um número não-negativo e maior que a nota de corte.");
          continue;
        } 
        break;
      } catch(NumberFormatException e) {
        System.out.println("Entrada inválida! Digite um número válido!");
      }
    }

    int qntdnotas;
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

float[] notas = new float[qntdnotas];
for (i = 0; i < qntdnotas; i++) {
    while (true) {
        try {
            System.out.println("Fale a " + (i + 1) + "° nota, " + name + ":");
            String input = scanner.nextLine().trim();
            BigDecimal bd = new BigDecimal(input);
            int casasDecimais = bd.scale() < 0 ? 0 : bd.stripTrailingZeros().scale();

            // Verificação de casas decimais
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


    media = 0;
    for (float x : notas) {
      media = media + x;
    }
    media = media / qntdnotas;
    BigDecimal mediaarredondada = new BigDecimal(Float.toString(media));
    mediaarredondada = mediaarredondada.setScale(2, RoundingMode.HALF_UP);

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

    System.out.println("Notas digitadas: " + Arrays.toString(notas));
    System.out.println("\n ----------- Sua média foi de " + mediaarredondada + ", " + name + ". Então você está " + rank + "! -----------");
  }

  // Jogo da Forca1
  public static void Forca(Scanner scanner, String name) {
    int tamanho = 0;


     String[] palavras = new String[10];
     System.out.println("-------- Bem vindo ao jogo da forca, " + name + "! Você vai me fornecer palavras e eu sortearei uma palavra para brincarmos. -----------\n");
      System.out.println("Então, " + name + ", quer me fornecer quantas palavras?");
      tamanho = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < tamanho; i++) {
          System.out.println("Digite a " + (i + 1) + "° palavra:");
          palavras[i] = scanner.nextLine().trim();
      }
    System.out.println("\nPalavras escolhidas, " + name + "!\n\nAgora vou sortear uma para brincarmos de jogo da forca!\n");
      Random random = new Random();
      int indiceSorteado = random.nextInt(tamanho); 
       String palavraforca = palavras[indiceSorteado];
       palavraforca = palavraforca.toLowerCase();
       char[] progresso = new char[palavraforca.length()];
       for (int x = 0; x < palavraforca.length(); x++) {
       progresso[x] = '_';
       }
      Forca2(scanner, name, progresso, palavraforca);
    }

  // Jogo da Forca2 
  public static void Forca2(Scanner scanner, String name, char[] progresso, String palavraforca) {
    limparTela();
    int chances = 0;
    if (palavraforca.length() > 6) {
      chances = palavraforca.length();
    } else {
      chances = 6;
    }
     ArrayList<Character> tentativas = new ArrayList<>();
     
     System.out.println("Você tem apenas " + chances + " chances!");
      
      //Loop principal
       while(chances > 0) { 
        System.out.println("\nPalavra: " + new String(progresso));
        System.out.println("Tentativas restantes: " + chances + "!");
        System.out.println("Digite uma letra, " + name + ":");
        char guess = scanner.nextLine().toLowerCase().charAt(0);

          if (tentativas.contains(guess)) {
            System.out.println("Você já tentou essa letra, " + name + "!");
            continue;
          }

       tentativas.add(guess);
       boolean acertou = false;   
       for (int y = 0; y < palavraforca.length(); y++) {
        if(palavraforca.charAt(y) == guess) {
         progresso[y] = guess;
         acertou = true;
        }
      }
      if(acertou == false){
        chances--;
        if (chances == 0){
          System.out.println("Errou, " + name + "!!!! A palavra era: " + palavraforca + ".");
        } else {
          System.out.println("Errou, " + name + "\n");
        }
        continue;
      } 

      //verificação final
      if(new String(progresso).equals(palavraforca)) {
        System.out.println("Você acertou, " + name + "!!! A palavra era: " + palavraforca + ".");
        break;

      }
    }
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
             System.out.println("Bom dia, " + name + "!\nA hora atual é: " + hour + "h" + minute + "min");
        } else if (hour >= 12 && hour  < 18) {
             System.out.println("Boa tarde, " + name + "!\nA hora atual é: " + hour + "h" + minute + "min");
        } else {
             System.out.println("Boa noite, " + name + "!\nLA hora atual é: " + hour + "h" + minute + "min");
        }
        break;
    }

    // Opções
    boolean continuar = true;
    while (continuar) {
      System.out.println("Você quer calcular seu IMC, calcular tipos de triângulos, contar vogais ou ver se é PG ou PA, fazer médias de notas, " + name
          + "?\n------- \nDigite 1 - IMC\nDigite 2 - Triângulo\nDigite 3 - Vogais\nDigite 4 - PA e PG\nDigite 5 - Média de notas\nDigite 6 - Jogo da forca\nDigite \"N\" - SAIR");
      String choice = scanner.nextLine().trim();
      limparTela();

      switch (choice) {
        case "1":
          calcularIMC(scanner, name);
          break;
        case "2":
          calcularTriangulo(scanner, name);
          break;
        case "3":
          contarVogais(scanner, name);
          break;
        case "4":
          verificarPAPG(scanner, name);
          break;
        case "5":
          calcularMedia(scanner, name);
          break;
        case "6":
         Forca(scanner, name);
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
