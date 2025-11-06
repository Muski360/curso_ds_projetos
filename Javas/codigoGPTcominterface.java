package Javas;

import javax.swing.*;
import java.util.*;
import java.time.LocalTime;

public class codigoGPTcominterface {

  // Helper gráfico para pedir String (retorna null se usuário cancelar)
  private static String askString(String title, String message) {
    return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
  }

  // Helper para mostrar mensagem
  private static void showInfo(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  // Helper para perguntar números (double) com repetição em caso de erro ou cancelar -> retorna null se cancelar
  private static Double askDouble(String title, String message) {
    while (true) {
      String s = askString(title, message);
      if (s == null) return null; // usuario cancelou
      try {
        return Double.parseDouble(s.trim());
      } catch (NumberFormatException e) {
        showInfo("Entrada inválida", "Formato inválido! Use ponto para decimais e digite apenas números.");
      }
    }
  }

  private static Float askFloat(String title, String message) {
    while (true) {
      String s = askString(title, message);
      if (s == null) return null;
      try {
        return Float.parseFloat(s.trim());
      } catch (NumberFormatException e) {
        showInfo("Entrada inválida", "Formato inválido! Use ponto para decimais e digite apenas números.");
      }
    }
  }

  private static Integer askInt(String title, String message) {
    while (true) {
      String s = askString(title, message);
      if (s == null) return null;
      try {
        return Integer.parseInt(s.trim());
      } catch (NumberFormatException e) {
        showInfo("Entrada inválida", "Digite um número inteiro válido.");
      }
    }
  }

  // Validação de nome (aceita letras e acentos, sem espaços)
  public static boolean validarNomeGUI(String name) {
    if (name == null || name.trim().isEmpty()) {
      showInfo("Nome inválido", "Digite um nome válido, espertinho!");
      return false;
    }
    // regex permite letras latinas com acentos, sem espaços
    if (!name.matches("^[a-zA-ZÀ-ÿ]+$")) {
      showInfo("Nome inválido", "Digite um nome sem caracteres especiais e sem espaço!");
      return false;
    }
    return true;
  }

  // CalcularIMC (versão GUI)
  public static void calcularIMC_GUI(String name) {
    Double alturaD = null;
    Float pesoF = null;

    alturaD = askDouble("IMC", "-------- Bem vindo a calculadora de IMC, " + name +
            "! --------\n\nQual é sua altura? (UTILIZE PONTO: ex. 1.70)");
    if (alturaD == null) return; // cancelou

    if (alturaD <= 0) {
      showInfo("Altura inválida", "Altura inválida! Digite um valor maior que 0.");
      return;
    }

    pesoF = askFloat("IMC", "Beleza, " + name + ". Agora, qual é o seu peso em kilos?");
    if (pesoF == null) return;

    if (pesoF <= 0) {
      showInfo("Peso inválido", "Peso inválido! Digite um valor maior que 0.");
      return;
    }

    float altura = alturaD.floatValue();
    float peso = pesoF;
    float IMC = peso / (altura * altura);
    String rank;
    if (IMC <= 18.5) rank = "Abaixo do peso normal";
    else if (IMC <= 24.9) rank = "Peso normal";
    else if (IMC <= 29.9) rank = "Excesso de peso";
    else if (IMC <= 34.9) rank = "Obesidade Classe 1";
    else if (IMC <= 39.9) rank = "Obesidade Classe 2";
    else rank = "Obesidade Classe 3";

    showInfo("Resultado IMC", String.format("Perfeito! Seu IMC é: %.2f. Sua classificação: %s.", IMC, rank));
  }

  // Triangulos (GUI)
  public static void calcularTriangulo_GUI(String name) {
    Double ladoA = askDouble("Triângulos", "-------- Bem vindo a calculadora de tipos de triângulos, " + name +
            "! --------\n\nDiga-me o primeiro lado do triângulo (metros).");
    if (ladoA == null) return;
    Double ladoB = askDouble("Triângulos", "Agora, me diga o segundo lado.");
    if (ladoB == null) return;
    Double ladoC = askDouble("Triângulos", "Agora me fale o terceiro lado.");
    if (ladoC == null) return;

    if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
      showInfo("Lados inválidos", "Os lados precisam ser positivos.");
      return;
    }

    String rank;
    if (ladoA.equals(ladoB) && ladoB.equals(ladoC)) rank = "Triângulo Equilátero";
    else if (ladoA.equals(ladoB) || ladoA.equals(ladoC) || ladoB.equals(ladoC)) rank = "Triângulo Isósceles";
    else rank = "Triângulo Escaleno";

    showInfo("Resultado Triângulo", "Perfeito! Seu triângulo se classifica como: " + rank +
            "\nLados: \n Lado 1: " + ladoA + "\n Lado 2: " + ladoB + "\n Lado 3: " + ladoC);
  }

  // Vogais (GUI)
  public static void contarVogais_GUI(String name) {
    String word = askString("Contador de Vogais", "-------- Bem vindo a calculadora de vogais, " + name + "! --------\n\nFale qualquer palavra que eu conto!");
    if (word == null) return;

    int count = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = Character.toLowerCase(word.charAt(i));
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
    }
    showInfo("Resultado Vogais", "Número de vogais da palavra \"" + word + "\" é " + count + " vogais!");
  }

  // PA e PG (GUI)
  public static void verificarPAPG_GUI(String name) {
    Float firstnumber = askFloat("PA/PG", "-------- Bem vindo a calculadora de PG e PA, " + name + "! --------\n\nEscreva o primeiro número:");
    if (firstnumber == null) return;
    Float secondnumber = askFloat("PA/PG", name + ", escreva o segundo número:");
    if (secondnumber == null) return;
    Float thirdnumber = askFloat("PA/PG", name + ", escreva o terceiro número:");
    if (thirdnumber == null) return;

    float x = thirdnumber - secondnumber;
    float y = secondnumber - firstnumber;
    final float EPS = 1e-6f;

    boolean isPA = Math.abs(x - y) < EPS;
    boolean isPG = false;
    if (Math.abs(firstnumber) < EPS && Math.abs(secondnumber) < EPS && Math.abs(thirdnumber) < EPS) {
      isPG = true;
    } else if (Math.abs(firstnumber) > EPS && Math.abs(secondnumber) > EPS) {
      float r1 = secondnumber / firstnumber;
      float r2 = thirdnumber / secondnumber;
      if (Math.abs(r1 - r2) < EPS) isPG = true;
    }

    if (!isPA && !isPG) {
      showInfo("Resultado PA/PG", name + ", isso não é uma progressão aritmética nem geométrica!");
    } else if (isPA) {
      showInfo("Resultado PA", name + ", sua sequência é uma PA. Razão: " + y + "!");
    } else {
      float razao = (Math.abs(secondnumber) > EPS && Math.abs(firstnumber) > EPS) ? (secondnumber / firstnumber) : 0f;
      showInfo("Resultado PG", name + ", sua sequência é uma PG. Razão: " + razao + "!");
    }
  }

  // Média de notas (GUI)
  public static void calcularMedia_GUI(String name) {
    Float notacorte = askFloat("Média", "-------- Bem vindo a calculadora de média de notas, " + name + "! --------\n\nPrimeiro, qual é a nota de corte?");
    if (notacorte == null) return;
    if (notacorte <= 0) { showInfo("Erro", "Nota de corte inválida!"); return; }

    Float notarecuperacao = askFloat("Média", "Digite a nota de recuperação (ou 0 se não houver):");
    if (notarecuperacao == null) return;
    if (notarecuperacao < 0 || notarecuperacao >= notacorte) {
      showInfo("Erro", "Nota de recuperação inválida! Deve ser >=0 e menor que a nota de corte.");
      return;
    }

    Integer qntdnotas = askInt("Média", "Quantas notas você quer calcular?");
    if (qntdnotas == null) return;
    if (qntdnotas <= 0) { showInfo("Erro", "Quantidade inválida."); return; }

    float[] notas = new float[qntdnotas];
    for (int i = 0; i < qntdnotas; i++) {
      Float n = askFloat("Média", "Fale a " + (i + 1) + "° nota, " + name + ":");
      if (n == null) return;
      if (n < 0) { showInfo("Erro", "Nota inválida!"); return; }
      notas[i] = n;
    }

    float media = 0f;
    for (float x : notas) media += x;
    media = media / qntdnotas;
    String rank;
    if (notarecuperacao == 0f) {
      rank = (media >= notacorte) ? "aprovado" : "reprovado";
    } else {
      if (media >= notacorte) rank = "aprovado";
      else if (media < notacorte && media >= notarecuperacao) rank = "recuperação";
      else rank = "reprovado";
    }

    showInfo("Resultado Média", "Notas: " + Arrays.toString(notas) +
            "\nSua média: " + media + "\nResultado: " + rank);
  }

  // Jogo da Forca (GUI)
  public static void Forca_GUI(String name) {
    Integer tamanho = askInt("Forca", "-------- Bem vindo ao jogo da forca, " + name +
            "! Você vai me fornecer palavras e eu sortearei uma palavra para brincarmos.\n\nQuantas palavras você quer fornecer?");
    if (tamanho == null) return;
    if (tamanho <= 0) { showInfo("Erro", "Quantidade inválida."); return; }

    String[] palavras = new String[tamanho];
    for (int i = 0; i < tamanho; i++) {
      String p = askString("Forca", "Digite a " + (i + 1) + "° palavra:");
      if (p == null) return;
      palavras[i] = p.trim();
    }

    Random random = new Random();
    String palavraforca = palavras[random.nextInt(tamanho)].toLowerCase();
    char[] progresso = new char[palavraforca.length()];
    for (int i = 0; i < progresso.length; i++) progresso[i] = '_';

    int chances = (palavraforca.length() > 6) ? palavraforca.length() : 6;
    ArrayList<Character> tentativas = new ArrayList<>();

    while (chances > 0) {
      String estado = new String(progresso);
      String resp = askString("Forca", "Palavra: " + estado + "\nTentativas restantes: " + chances + "\nDigite uma letra, " + name + ":");
      if (resp == null) return;
      if (resp.trim().isEmpty()) { showInfo("Erro", "Digite uma letra!"); continue; }
      char guess = Character.toLowerCase(resp.trim().charAt(0));
      if (tentativas.contains(guess)) { showInfo("Aviso", "Você já tentou essa letra!"); continue; }
      tentativas.add(guess);
      boolean acertou = false;
      for (int y = 0; y < palavraforca.length(); y++) {
        if (palavraforca.charAt(y) == guess) {
          progresso[y] = guess;
          acertou = true;
        }
      }
      if (!acertou) {
        chances--;
        if (chances == 0) {
          showInfo("Fim de Jogo", "Errou! A palavra era: " + palavraforca + ".");
        } else {
          showInfo("Errou", "Errou, " + name + "!\nTentativas restantes: " + chances);
        }
      } else {
        if (new String(progresso).equals(palavraforca)) {
          showInfo("Vitória", "Você acertou, " + name + "!!! A palavra era: " + palavraforca + ".");
          break;
        }
      }
    }
  }

  // Menu principal GUI
  public static void main(String[] args) {
    // executar na EDT
    SwingUtilities.invokeLater(() -> {
      // pede o nome
      String name = null;
      while (true) {
        name = askString("Bem-vindo", "Qual seu nome?");
        if (name == null) { // cancelar
          System.exit(0);
        }
        if (!validarNomeGUI(name)) continue;
        // capitaliza primeira letra
        if (Character.isLowerCase(name.charAt(0))) {
          name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }
        break;
      }

      int hour = LocalTime.now().getHour();
      int minute = LocalTime.now().getMinute();
      String saudacao;
      if (hour >= 6 && hour < 12) saudacao = "Bom dia";
      else if (hour >= 12 && hour < 18) saudacao = "Boa tarde";
      else saudacao = "Boa noite";
      showInfo("Saudação", saudacao + ", " + name + "!\nA hora atual é: " + hour + "h" + minute + "min");

      boolean continuar = true;
      String[] options = {"IMC", "Triângulo", "Vogais", "PA/PG", "Média", "Forca", "Sair"};
      while (continuar) {
        int choice = JOptionPane.showOptionDialog(null,
            "Escolha uma opção, " + name + ":",
            "Menu",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]);

        if (choice == -1 || choice == 6) { // fechar ou Sair
          continuar = false;
          break;
        }

        switch (choice) {
          case 0: calcularIMC_GUI(name); break;
          case 1: calcularTriangulo_GUI(name); break;
          case 2: contarVogais_GUI(name); break;
          case 3: verificarPAPG_GUI(name); break;
          case 4: calcularMedia_GUI(name); break;
          case 5: Forca_GUI(name); break;
          default: showInfo("Erro", "Opção inválida!"); break;
        }

        int reiniciar = JOptionPane.showConfirmDialog(null, "Deseja fazer outra operação?", "Continuar?", JOptionPane.YES_NO_OPTION);
        if (reiniciar != JOptionPane.YES_OPTION) continuar = false;
      }

      showInfo("Tchau", "Obrigado por usar o programa, " + name + "! Até logo.");
      System.exit(0);
    });
  }
}
