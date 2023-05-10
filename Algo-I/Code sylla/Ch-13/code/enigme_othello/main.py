"""
Script principal pour lancer la GUI et placer quatre pions initiaux
"""

from window import Window

game = Window()

game.add_token(315, 152)
game.add_token(405, 152)
game.add_token(315, 210)
game.add_token(405, 210)

game.loop()