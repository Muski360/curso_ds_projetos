import os, datetime, time, locale

def limparTela():
        os.system("cls")

while True:
    limparTela()
    print("-" * 40)
    print("MULTA DE TRÂNSITO - EXCESSO DE VELOCIDADE\n" + "-" * 40)
    while True:
        opcao = input("Deseja continuar? [S/N] ").strip().lower()
        if opcao == 'n' or opcao == 'não' or opcao == 'nao' or opcao == 'sair':
            print("Saindo do programa...")
            time.sleep(2)
            exit()
        elif opcao == 's' or opcao == 'sim' or opcao == 'continuar' or opcao == 'entrar':
            break
        else:
            print("Opção inválida. Digite novamente")

    while True: 
        try:
            velocidade_limite = int(input("Qual é o limite de velocidade que deseja considerar? "))
            if velocidade_limite <= 0:
                print("O limite de velocidade deve ser um número positivo. Tente novamente.")
                continue
            break
        except ValueError:
            print("Por favor, insira um valor numérico válido para o limite de velocidade.")
            time.sleep(3)
            limparTela()
            continue
    while True:
        try:
            cor = int(input(f"Digite se o farol estava verde, amarelo ou vermelho: \n1 - Verde\n2 - Amarelo\n3 - Vermelho\n"))
            if cor not in [1, 2, 3]:
                print("Opção inválida. Digite 1, 2 ou 3.")
                continue
        except ValueError:
            print("Por favor, insira um valor numérico válido para a cor do farol.")
            time.sleep(3)
            limparTela()
            continue
        else:
            break
    while True:
        try:
            velocidade = int(input("Digite a velocidade do carro: "))
            if velocidade > velocidade_limite:
                if cor == 3:
                    print("Você foi multado por excesso de velocidade e por passar no sinal vermelho!")
                    multa = abs(velocidade - velocidade_limite) * 7 + 500
                else:
                    print("Você foi multado por excesso de velocidade!")
                    multa = abs(velocidade - velocidade_limite) * 7
                print("Calculando valor da multa...\n")
                time.sleep(2)
                print(f"Sua multa é de R$ {multa}\nData e hora da multa: {datetime.datetime.now().strftime('%d/%m/%Y - %Hh %Mm %Ss')}\nNome: {os.getlogin()}\n")
                break
            elif velocidade < (velocidade_limite * 0.5):
                if cor == 3:
                    print("Você foi multado por estar abaixo do mínimo de velocidade e por passar no sinal vermelho!")
                    multa = abs(velocidade - (velocidade_limite * 0.5)) * 5 + 500
                else:
                    print("Você foi multado por estar abaixo do mínimo de velocidade!")
                    multa = abs(velocidade - (velocidade_limite * 0.5)) * 5
                print("Calculando valor da multa...\n")
                time.sleep(2)
                print(f"Sua multa é de R$ {multa}\nData e hora da multa: {datetime.datetime.now().strftime('%d/%m/%Y - %Hh %Mm %Ss')}\nNome: {os.getlogin()}\n")
                break
            else:
                print("Velocidade dentro do limite permitido.\n")
                if cor == 3:
                    print("Você foi multado por passar no sinal vermelho!")
                    multa = 500
                    print("Calculando valor da multa...\n")
                    time.sleep(2)   
                    print(f"Sua multa é de R$ {multa}\nData e hora da multa: {datetime.datetime.now().strftime('%d/%m/%Y - %Hh %Mm %Ss')}\nNome: {os.getlogin()}\n")
                else:
                    print("Nenhuma infração detectada. Tenha um bom dia!")
                break
        except ValueError:
            print("Por favor, insira um valor numérico válido para a velocidade."); 
            time.sleep(3)
            limparTela()
            continue
        
    opcao = input("Deseja calcular outra multa? [S/N] ").strip().lower()
    if opcao == 'n':
        print("Saindo do programa...")
        time.sleep(2)
        exit()
    elif opcao == 's':
        limparTela()
        continue
    else:
        print("Opção inválida. Digite novamente")
        time.sleep(3)
        limparTela()
        continue