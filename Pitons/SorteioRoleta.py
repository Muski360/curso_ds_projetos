import os, time, datetime, random, sys

def limparTela():
    os.system("cls")

def getConfirmation():
    while True:
        limparTela()
        print(("-" * 40) + "\nSORTEIO DA ROLETA!\n" + ("-" * 40))
        print(f"Olá, {os.getlogin()}! tudo bem?\n\nVocê fornecerá elementos que vão ser sorteados na roleta!\n")
        opcao = input("Deseja continuar? [S/N] ").strip().lower()
        if opcao in ['n', 'nao', 'não', 'sair']:
            print("Saindo do programa...")
            time.sleep(2)
            exit()
        elif opcao in ['s', 'sim', 'entrar', 'continuar']:
            return
        else:
            print("Opção inválida. Digite novamente")
            time.sleep(1)

def animation1():
    print("Vamos começar o sorteio.");
    sys.stdout.write("\033[F")
    sys.stdout.write("\033[K")
    time.sleep(1)
    print("Vamos começar o sorteio..")
    sys.stdout.write("\033[F")
    sys.stdout.write("\033[K")
    time.sleep(1)
    print("Vamos começar o sorteio...");
    sys.stdout.write("\033[F")
    sys.stdout.write("\033[K")
    time.sleep(1)

def animation(elementos):
    sorteado = random.choice(elementos)
    for y in range(300):
        time
        atual = random.choice(elementos)
        sys.stdout.write("\033[F")
        sys.stdout.write("\033[K")
        print(f"O elemento sorteado é... {atual}")
        if y >= 270:
            time.sleep(0.1)
        if y >= 293:
            time.sleep(0.45)
        if y >= 296:
            time.sleep(0.65)
        if y >= 298:
            time.sleep(0.9)
        else:
            time.sleep(0.01)
        
    limparTela()
    print(f"\n🎉 O elemento sorteado foi: {sorteado} 🎉\n")
    return sorteado

def saveLog(sorteado, elementos):
    with open("log_sorteios.txt", "a") as arquivo:
        arquivo.write(f"Nos elementos: {elementos}:\n{datetime.datetime.now().strftime('%d/%m/%Y - %Hh %Mm')} - Sorteado: {sorteado}\n\n\n")

def main():
    getConfirmation()
    time.sleep(0.5)
    limparTela()
    elementos = []
    i = 0
    parar = False
    while parar == False:
        entrada = input(f"Digite o {i + 1}° elemento (digite \"0\" quando terminar, ou \"VOLTAR\" para corrigir): ").strip().lower()
        if entrada == "0":
            if elementos:
                parar = True
            else:
                print("A lista está vazia!")
        elif entrada in ["voltar", "volte", "antes", "apagar", "corrigir", "deletar", "excluir"]:
            if elementos:
                removido = elementos.pop()
                print(f"Pronto.\nRemovido: {removido}")
                i -= 1
            else:
                print("A lista está vazia!")
        elif entrada == "":
            print("O elemento não pode ser vazio!")
        else:
            elementos.append(entrada)
            i += 1

    print("\nLista final:")
    print(elementos);
    animation1()
    limparTela()
    while True:
        sorteado = animation(elementos)
        saveLog(sorteado, elementos)
        sair = True
        while sair == True:
            opcao = input("\nDeseja sortear novamente, dentro desses elementos? [S/N] ").strip().lower()
            if opcao in ['n', 'nao', 'não', 'sair']:
                print("Saindo do programa...")
                time.sleep(2)
                exit()
            elif opcao in ['s', 'sim', 'entrar', 'continuar']:
                repetir = input("\nQuer retirar o elemento já sorteado para não ser sorteado novamente? [S/N] ")
                if repetir in ['s', 'sim', 'entrar', 'continuar']:
                    elementos.remove(sorteado)
                    sair = False
                    if not elementos:
                        print("Não há mais nada para ser sorteado!")
                        exit()
                elif repetir in ['n', 'nao', 'não', 'sair']:
                    sair = False
                    continue
                else:
                    print("\nOpção inválida!")
                    continue
            else:
                print("\nOpção inválida. Digite novamente")
                continue

if __name__ == "__main__":
    main()