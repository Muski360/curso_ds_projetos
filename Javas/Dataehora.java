package Javas;

import java.util.Scanner;
import java.time.LocalTime;

public class Dataehora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual é o seu nome?");
        String name = scanner.nextLine();

        int hour = LocalTime.now().getHour();
        int minute = LocalTime.now().getMinute();

        if (hour >= 6 && hour < 12) {
             System.out.println("Bom dia, " + name + "!\nA hora atual é: " + hour + "h" + minute);
        } else if (hour >= 12 && hour  < 18) {
             System.out.println("Boa tarde, " + name + "!\nA hora atual é: " + hour + "h" + minute);
        } else {
             System.out.println("Boa noite, " + name + "!\nLA hora atual é: " + hour + "h" + minute);
        }
        scanner.close();
      }
    } 