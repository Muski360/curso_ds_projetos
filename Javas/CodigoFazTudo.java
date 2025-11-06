package Javas;

import java.util.Scanner;

public class CodigoFazTudo {

public static boolean querReiniciar(Scanner scanner) {
    while (true) {
        System.out.println("\nDigite 's' para reiniciar ou 'n' para sair:");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) return true;
        if (resposta.equals("n")) return false;

        System.out.println("Opção inválida, tente novamente!");
    }
}
  public static boolean validarNome(String name) {
    if (name.isEmpty() && !name.matches("[a-zA-Zá-úÁ-Ú]+")) {
        System.out.println("Isso foi inválido!");
        return false;
    }
    return true;
}
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String name = "";
    while (true) {
      System.out.println("Qual seu nome?");
      name = scanner.nextLine().trim();

      if (name.isEmpty()) {
        System.out.println("Digite um nome válido espertinho!");
      } else if (!name.matches("[a-zA-Zá-úÁ-Ú]+")) {
        System.out.println("Digite um nome sem caracteres especiais e sem espaço!");
      } else {
        if (Character.isLowerCase(name.charAt(0))) {
          name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }

        System.out.println("Beleza, " + name + ". Espero que esteja bem!\n");
        break;

      }
    }

    String choice = "";
    while(true) {
    System.out.println("Você quer calcular seu IMC, calcular tipos de triângulos, contar vogais ou ver se é PG ou PA, fazer médias de notas, " + name
            + "?\n------- \nDigite 1 - IMC\nDigite 2 - Triângulo\nDigite 3 - Vogais\nDigite 4 - PA e PG\nDigite 5 - Média de notas");
    choice = scanner.nextLine().trim();
    if (choice.equals("1")) {
      float altura;
      float peso;
      float IMC;
      String rank = "";
      System.out.println("-------- Bem vindo a calculadora de IMC, " + name
          + "! --------\n\nQual é sua altura? (UTILIZE PONTO PARA SEPARAR, TIPO '1.70')");
      altura = Float.parseFloat(scanner.nextLine().trim());
      System.out.println("Beleza, " + name + ". Agora, Qual é o seu peso em kilos?");
      peso = Float.parseFloat(scanner.nextLine().trim());
      IMC = peso / (altura * altura);
      if (IMC <= 18.5) {
        rank = "Abaixo do peso normal";
      } else if (IMC > 18.5 && IMC <= 24.9) {
        rank = "Peso normal";
      } else if (IMC >= 25.0 && IMC <= 29.9) {
        rank = "Excesso de peso";
      } else if (IMC >= 30.0 && IMC <= 34.9) {
        rank = "Obesidade Classe 1";
      } else if (IMC >= 35.0 && IMC <= 39.9) {
        rank = "Obesidade Classe 2";
      } else {
        rank = "Obesidade Classe 3";
      }
      System.out.println("Perfeito! Seu IMC é: " + IMC + ". Sua classificação é: " + rank + ".");

    } else if (choice.equals("2")) {
      while (true) {
        double ladoA;
        double ladoB;
        double ladoC;
        String rank = "";
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

        if (ladoA == ladoB && ladoB == ladoC) {
          rank = "Triângulo Equilátero";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
          rank = "Triângulo isóceles";
        } else if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC) {
          rank = "Triângulo Escaleno";
        }
        System.out.println("Perfeito! Seu triângulo se classifica como: " + rank + ". E seus lados são: \n Lado 1: "
            + ladoA + ".\n Lado 2: " + ladoB + ".\n Lado 3: " + ladoC + ".");
        if (!querReiniciar(scanner)) {
          break;
        }
      }
    } else if (choice.equals("3")) {
      String word = "";
      int count = 0;
      int i;
      System.out.println(
          "-------- Bem vindo a calculadora de vogais, " + name + "! --------\n\nFale qualquer palavra que eu conto!");
      word = scanner.nextLine().trim();

      for (i = 0; i < word.length(); i++) {
        char c = Character.toLowerCase(word.charAt(i));

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
          count++;
        }
      }
      System.out.println("Número de vogais da sua palavra \"" + word + "\" é de " + count + " vogais!");
         if (!querReiniciar(scanner)) {
          break;
        }

    } else if (choice.equals("4")) {
      float firstnumber;
      float secondnumber;
      float thirdnumber;
      float x;
      float y;
      System.out.println("-------- Bem vindo a calculadora de PG e PA, " + name
          + "! --------\n\nEscreva o primeiro número de sua sequencia: ");
      firstnumber = Float.parseFloat(scanner.nextLine().trim());
      System.out.println(name + ", escreva o segundo número de sua sequencia: ");
      secondnumber = Float.parseFloat(scanner.nextLine().trim());
      System.out.println(name + ", escreva o teceiro número de sua sequencia: ");
      thirdnumber = Float.parseFloat(scanner.nextLine().trim());
      x = thirdnumber - secondnumber;
      y = secondnumber - firstnumber;
      if (firstnumber >= secondnumber && secondnumber >= thirdnumber) {
        System.out.println(name + ", isso não é uma sequencia!");
      } else if (x == y) {
        System.out.println(name + ", sua sequencia é uma PA (Progressão aritmética). E sua razão é: " + y + "!");
      } else {
        float z = thirdnumber / secondnumber;
        System.out.println(name + ", sua sequencia é uma PG (Progressão geométrica). E sua razão é: " + z + "!");
           if (!querReiniciar(scanner)) {
            break;
        }

      }
    } else if (choice.equals("5")) {
      int i;
      String rank;
      float media = 0;
      System.out.println("-------- Bem vindo a calculadora de média de notas, " + name
          + "! --------\n\nPrimeiro, qual é a nota de corte que você quer usar?");
      float notacorte = Float.parseFloat(scanner.nextLine().trim());
      System.out.println("Quantas notas você quer calcular?");

      int qntdnotas = scanner.nextInt();
      scanner.nextLine();
      float[] notas = new float[qntdnotas];

      for (i = 0; i < qntdnotas; i++) {

        System.out.println("Fale a " + (i + 1) + "°" + " nota, " + name + ":");
        notas[i] = Float.parseFloat(scanner.nextLine().trim());
      } 
       for (float x : notas) {
        media += x;
       }
       media = media / qntdnotas;
       if(media >= notacorte) {
        rank = "aprovado";
       } else {
        rank = "reprovado";
       }
      System.out.println("Sua média foi de " + media + ", " + name + ". Então você está " + rank + ".");
         if (!querReiniciar(scanner)) {
          break;
        }
    }
   }
 }
}