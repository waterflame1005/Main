import numpy as np
import pygame, math


width = 600
height = 600

pygame.init()
background_colour = (0, 0, 0)
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Fluid")
screen.fill(background_colour)
pygame.display.flip()
clock = pygame.time.Clock()


resolution = 10
numwidth = math.floor(width / resolution)
numheight = math.floor(height / resolution)


class fluid:
    def __init__(self, numwidth, numheight):
        self.velocity = np.zeros((numwidth, numheight))
        self.pressure = np.zeros((numwidth, numheight))
        self.divergence = np.zeros((numwidth, numheight))
        self.up = np.zeros((numwidth, numheight))
        self.right = np.zeros((numwidth, numheight))
        self.newup = np.zeros((numwidth, numheight))
        self.newright = np.zeros((numwidth, numheight))

    def simulate(self):
        # update the velocities with incompressability
        for i in range(1, numwidth - 1):
            for j in range(1, numheight - 1):
                self.up[i][j] += self.divergence[i][j] / 4
                self.right[i][j] += self.divergence[i][j] / 4
                self.up[i][j + 1] -= self.divergence[i][j] / 4
                self.right[i + 1][j] -= self.divergence[i][j] / 4
        

        # advection
        dt = 1.0 / 100
        for i in range(0, numwidth - 1):
            for j in range(0, numheight - 1):
                prevx = i - dt * self.right[i][j]
                prevy = j - dt * self.up[i][j]
                if i==20 and j==20:
                    print(i, j, self.right[i][j],self.up[i][j], prevx, prevy)
                # advect x
                u = math.floor(prevx)
                v = math.floor(prevy - 0.5)
                deltax = prevx - u
                deltay = prevy - v - 0.5
                
                self.newright[i][j] = (
                    self.right[u][v] * (1 - deltax) * (1 - deltay)
                    + self.right[u + 1][v] * deltax * (1 - deltay)
                    + self.right[u][v + 1] * (1 - deltax) * deltay
                    + self.right[u + 1][v + 1] * deltax * deltay
                )
                # advect y
                u = math.floor(prevx - 0.5)
                v = math.floor(prevy)
                deltax = prevx - u - 0.5
                deltay = prevy - v
                
                self.newup[i][j] = (
                    self.up[u][v] * (1 - deltax) * (1 - deltay)
                    + self.up[u + 1][v] * deltax * (1 - deltay)
                    + self.up[u][v + 1] * (1 - deltax) * deltay
                    + self.up[u + 1][v + 1] * deltax * deltay
                )
        self.up = self.newup
        self.right = self.newright

        for i in range(1, numwidth - 1):
            for j in range(1, numheight - 1):
                self.divergence[i][j] = (
                    self.up[i][j + 1]
                    + self.right[i + 1][j]
                    - self.up[i][j]
                    - self.right[i][j]
                )
                self.pressure[i][j]+=self.divergence[i][j]

    def draw(self):
        for i in range(0, numwidth-1):
            for j in range(0, numheight-1):
                vel = (((self.right[i][j]+self.right[i+1][j])/2) ** 2) + (((self.up[i][j]+self.up[i][j+1])/2) ** 2)
                pres = max(min(self.pressure[i][j],255),0)
                pygame.draw.rect(
                    screen,
                    (min(vel, 255), min(vel, 255), min(vel, 255)),
                    # (pres,pres,pres),
                    [i * resolution, j * resolution, resolution, resolution],
                )


f = fluid(numwidth, numheight)
running = True
pressed = False
while running:
    if pressed:
        pos = pygame.mouse.get_pos()
        x = math.floor(pos[0] / resolution)
        y = math.floor(pos[1] / resolution)
        f.divergence[x][y] = 255
        f.divergence[x + 1][y] = 255
        f.divergence[x][y + 1] = 255
        f.divergence[x - 1][y] = 255
        f.divergence[x][y - 1] = 255
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        mouse_press = pygame.mouse.get_pressed()
        if mouse_press[0]:
            pressed = True
        else:
            pressed = False

    f.simulate()
    f.draw()

    pygame.display.flip()
    pygame.time.delay(50)


pygame.display.quit()
pygame.quit()
exit()
