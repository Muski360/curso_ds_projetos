import tkinter as tk
from tkinter import messagebox

def calcular():
    try:
        l1 = float(entrada_1.get())
        l2 = float(entrada_2.get())
        l3 = float(entrada_3.get())
        
        if l1 + l2 > l3 and l1 + l3 > l2 and l2 + l3 > l1:
            if l1 == l2 == l3:
                resultado = "É um triângulo equilátero."
            elif l1 == l2 or l2 == l3 or l1 == l3:
                resultado = "É um triângulo isósceles."
            else:
                resultado = "É um triângulo escaleno."
        else:
            resultado = "Os lados não formam um triângulo válido."
        messagebox.showinfo("Resultado", resultado)
    except ValueError:
        messagebox.showerror("Erro", "Por favor, insira valores numéricos válidos.")

janela = tk.Tk()
janela.title("Tipos de triângulo - Murilo Dovigo Bastos")

lado_1 = tk.Label(janela, text="Medida do Lado 1:")
lado_1.grid(row=0, column=0, padx=10, pady=5)

entrada_1 = tk.Entry(janela)
entrada_1.grid(row=0, column=1, padx=10, pady=5)

lado_2 = tk.Label(janela, text="Medida do Lado 2:")
lado_2.grid(row=1, column=0, padx=10, pady=5)

entrada_2 = tk.Entry(janela)
entrada_2.grid(row=1, column=1, padx=10, pady=5)

lado_3 = tk.Label(janela, text="Medida do Lado 3:")
lado_3.grid(row=2, column=0, padx=10, pady=5)

entrada_3 = tk.Entry(janela)
entrada_3.grid(row=2, column=1, padx=10, pady=5)

botao_calcular = tk.Button(janela, text="Calcular", command=calcular)
botao_calcular.grid(row=3, column=0, columnspan=2, pady=10)

janela.mainloop()