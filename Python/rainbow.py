import pygame
pygame.init()
background_colour = (255, 255, 255)
screen = pygame.display.set_mode((550, 500))
pygame.display.set_caption('Connect 4')
screen.fill(background_colour)
pygame.display.flip()

sun = [0, 100, 100]

running = True
while running:
    for event in pygame.event.get():    
        if event.type == pygame.QUIT:
            running = False
