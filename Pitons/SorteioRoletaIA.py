import os, time, datetime, random, sys, pygame
from pathlib import Path
MUSIC_PATH = Path(r"C:\Users\Sala_C37\.vscode\cli\Pitons\RoletaMusic.ogg")

AUDIO_AVAILABLE = True
pygame.mixer.init()
if AUDIO_AVAILABLE:
    if not MUSIC_PATH.exists():
        print(f"Aviso: arquivo de áudio não encontrado: {MUSIC_PATH}")
        AUDIO_AVAILABLE = False
    else:
        try:
            pygame.mixer.music.load(str(MUSIC_PATH))
            pygame.mixer.music.set_volume(0.6)
        except Exception as e:
            print("Erro ao carregar música:", e)
            AUDIO_AVAILABLE = False

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
    if not elementos:
        raise ValueError("A lista 'elementos' está vazia. Nada para sortear.")

    total_duration = 10.5  # segundos
    n_steps = 40  # FIXO: número de "frames" da animação
    acceleration_power = 3.0  # quanto maior, mais acelera no final

    # gera pesos para delays (início lento, fim rápido)
    weights = []
    for i in range(n_steps):
        t = i / (n_steps - 1)  # 0..1
        weights.append((1.0 - t) ** acceleration_power)

    sum_w = sum(weights)
    delays = [(w / sum_w) * total_duration for w in weights]

    # vencedor (a animação é só visual; se quiser que o último mostrado seja o vencedor,
    # remova esta linha e defina sorteado = atual após o loop)
    sorteado = random.choice(elementos)

    if AUDIO_AVAILABLE:
        try:
            pygame.mixer.music.play()
        except Exception as e:
            print("Erro ao tocar música:", e)

    for delay in delays:
        atual = random.choice(elementos)
        sys.stdout.write("\033[F")
        sys.stdout.write("\033[K")
        print(f"O elemento sorteado é... {atual}")
        time.sleep(delay)

    if AUDIO_AVAILABLE:
        try:
            pygame.mixer.music.fadeout(600)
        except Exception as e:
            print("Erro ao parar música:", e)

    limparTela()
    print(f"\n🎉 O elemento sorteado foi: {sorteado} 🎉\n")
    return sorteado

def saveLog(sorteado, elementos):
    with open("log_sorteios.txt", "a") as arquivo:
        arquivo.write(f"Nos elementos: {elementos}:\n{datetime.datetime.now().strftime('%d/%m/%Y - %Hh %Mm %Ss')} - Sorteado: {sorteado}\n\n\n")

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
            print("Elemento não pode ser vazio!")
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
                if AUDIO_AVAILABLE:
                    try:
                        pygame.mixer.music.stop()
                    except:
                        pass
                exit()
            elif opcao in ['s', 'sim', 'entrar', 'continuar']:
                repetir = input("\nQuer retirar o elemento já sorteado para não ser sorteado novamente? [S/N] ")
                if repetir in ['s', 'sim', 'entrar', 'continuar']:
                    elementos.remove(sorteado)
                    sair = False
                    if not elementos:
                        print("Não há mais nada para ser sorteado!")
                        if AUDIO_AVAILABLE:
                            try:
                                pygame.mixer.music.stop()
                            except:
                                pass                        
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
