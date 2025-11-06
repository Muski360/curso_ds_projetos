import sys
from PyQt6.QtWidgets import QApplication, QWidget, QLabel, QPushButton
from PyQt6.QtGui import QFont
from PyQt6.QtCore import Qt  # Necessário para o alinhamento

# 1. Definir a classe da Janela Principal (herda de QWidget)
class MinhaJanela(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Exemplo PyQt com Botão Fechar")
        self.setGeometry(100, 100, 450, 250)  # x, y, largura, altura
        self.iniciar_componentes()

    def iniciar_componentes(self):
        # --- RÓTULO (LABEL) ---
        label = QLabel("Olá, PyQt!", self)
        label.setFont(QFont("Arial", 24))

        # Centraliza o texto dentro do label
        label.setAlignment(Qt.AlignmentFlag.AlignCenter)

        # Define posição e tamanho do label
        label.setGeometry(50, 50, 350, 50)

        # --- BOTÃO FECHAR ---
        botao_fechar = QPushButton("Fechar", self)
        botao_fechar.setFont(QFont("Arial", 12))

        # Define posição e tamanho do botão
        botao_fechar.setGeometry(150, 150, 150, 40)

        # Conecta o botão ao método de fechar a janela
        botao_fechar.clicked.connect(self.close)

# 2. Executar a aplicação
if __name__ == "__main__":
    app = QApplication(sys.argv)

    # Cria e exibe a janela principal
    janela_principal = MinhaJanela()
    janela_principal.show()

    # Inicia o loop de eventos da aplicação
    sys.exit(app.exec())
