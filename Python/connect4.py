import pygame
pygame.init()
background_colour = (255, 255, 255)
screen = pygame.display.set_mode((550, 500))
pygame.display.set_caption('Connect 4')
screen.fill(background_colour)

gamewidth = 700
gameheight = 600

pygame.draw.rect(screen, (0, 0, 0), (100, 100, 350, 300), 1)
for i in range (1, 7):
    pygame.draw.line(screen, (0, 0, 0), (100+i*50, 100), (100+i*50, 400))
for i in range (1, 6):
    pygame.draw.line(screen, (0, 0, 0), (100, 100+i*50), (450, 100+i*50))
pygame.display.flip()

finish = False
turn = "red"
move = 0
board = [[],[],[],[],[],[],[]]

def placepiece(keypressed):
    if (keypressed < 8):
        column = keypressed-1
        if len(board[column]) < 6:
            board[column].append(turn)
            pygame.draw.rect(screen, turn, (100+50*column, 100+50*(6-len(board[column])), 50, 50))
            move+=1
            for i in range (-3, 1):
                row = len(board[column]) - 1
                if column + i >= 0 and column + i <= 3:
                    if board[column + i][row] == turn and board[column + i + 1][row] == turn and board[column + i + 2][row] == turn and board[column + i + 3][row] == turn:
                        finish = True
                        # turn wins
                if row + i >= 0 and row + i <= 2:
                    if board[column][row + i] == turn and board[column][row + i + 1] == turn and board[column][row + i + 2] == turn and board[column][row + i + 3] == turn:
                        finish = True
                        # turn wins
                if row + i >= 0 and row + i <= 2 and column + i >= 0 and column + i <= 3:
                    if board[column + i][row + i] == turn and board[column + i + 1][row + i + 1] == turn and board[column + i + 2][row + i + 2] == turn and board[column + i + 3][row + i + 3] == turn:
                        finish = True
                        # turn wins
                if row - i <= 5 and row - i >= 3 and column + i >= 0 and column + i <= 3:
                    if board[column + i][row - i] == turn and board[column + i + 1][row - i - 1] == turn and board[column + i + 2][row - i - 2] == turn and board[column + i + 3][row - i - 3] == turn:
                        finish = True
                        # turn wins
            if turn == "red":
                turn = "blue"
            else:
                turn = "red"
            if (move == 42 and not finish):
                finish = True
                # draw
                

while not finish:
    for event in pygame.event.get():    
        if event.type == pygame.QUIT:
            finish = True
