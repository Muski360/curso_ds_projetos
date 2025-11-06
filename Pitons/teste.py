from pathlib import Path
import pygame, time, traceback

M = Path(r"C:\Users\Sala_C37\.vscode\cli\Pitons\RoletaMusic.ogg") 
print("existe?", M.exists(), M)
try:
    pygame.mixer.init()
    pygame.mixer.music.load(str(M))
    pygame.mixer.music.play()
    print("tocando 5s")
    time.sleep(5)
    pygame.mixer.music.stop()
except Exception:
    traceback.print_exc()
