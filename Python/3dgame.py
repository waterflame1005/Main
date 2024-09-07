import pygame
import math
import sys
clock = pygame.time.Clock()
pygame.init()
sx = 400
sy = 300
fov = 30
screen = pygame.display.set_mode((sx*2, sy*2))
pitch = 0
yaw = 0
done = False



xp=0
yp=0
zp=0.5
x=0
y=0
z=0


while not done:
    pygame.init()
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit(0)
    pressed = pygame.key.get_pressed()
    if pressed[pygame.K_a]:
        xp += 3
    if pressed[pygame.K_d]:
        xp -= 3
    if pressed[pygame.K_SPACE]:
        yp += 3
    if pressed[pygame.K_LSHIFT]:
        yp -= 3
    if pressed[pygame.K_s]:
        zp += 1
    if pressed[pygame.K_w]:
        zp -= 1
    if pressed[pygame.K_LEFT]:
        yaw += 0.01
    if pressed[pygame.K_RIGHT]:
        yaw -= 0.01
    if pressed[pygame.K_UP]:
        pitch += 0.01
    if pressed[pygame.K_DOWN]:
        pitch -= 0.01
    
    screen.fill((0, 0, 0))
    if yaw+math.atan((xp+x)/(zp+z))<fov:
        firstpoint = (sx+math.tan(yaw+math.atan((xp+x)/(zp+z)))*sx, sy+math.tan(pitch+math.atan((yp+y)/(zp+z)))*sy)
        secondpoint = (sx+math.tan(yaw+math.atan((xp+x)/(zp+z)))*sx, sy+math.tan(pitch+math.atan((yp+y+20)/(zp+z)))*sy)
        pygame.draw.line(screen, (0, 0, 255), firstpoint, secondpoint)

    print(xp, yp, zp, yaw, pitch)


    
    
    
    clock.tick(60)          
    pygame.display.flip()