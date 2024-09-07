import pygame, sys, os
import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Conv2D, InputLayer
from keras.layers import MaxPooling2D, Flatten, BatchNormalization
import keras as tk
mnist = tk.datasets.mnist
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

(trainX, trainy), (testX, testy) = mnist.load_data()


trainy_array = []
testy_array = []

for i in trainy:
    term = [0 for i in range(10)]
    term[i-1]=1
    trainy_array.append(term)
trainy_array = np.array(trainy_array)

for i in testy:
    term = [0 for i in range(10)]
    term[i-1]=1
    testy_array.append(term)
testy_array = np.array(testy_array)

screen_size = 560
size = 10
speed = 40


#????????
model = Sequential()

model.add(InputLayer(input_shape=(28, 28, 1)))
model.add(Conv2D(filters=64, kernel_size=3, strides = 1, padding='same', activation = 'relu'))
model.add(Conv2D(filters=64, kernel_size=3, strides = 1, padding='same', activation = 'relu'))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(BatchNormalization())

model.add(Conv2D(filters=128, kernel_size=3, strides = 1, padding='same', activation = 'relu'))
model.add(Conv2D(filters=128, kernel_size=3, strides = 1, padding='same', activation = 'relu'))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(BatchNormalization())

model.add(Conv2D(filters=256, kernel_size=3, strides = 1, padding='same', activation = 'relu'))
model.add(MaxPooling2D(pool_size=(2, 2)))
model.add(BatchNormalization())

model.add(Flatten())
model.add(Dense(512, activation = 'relu'))
model.add(Dense(10, activation = 'softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
model.fit(trainX, trainy_array, epochs = 1, validation_data = (testX, testy_array))

pygame.init()
background_colour = (0, 0, 0)
screen = pygame.display.set_mode((screen_size, screen_size))
pygame.display.set_caption('Numbers')
screen.fill(background_colour)
pygame.display.flip()
clock = pygame.time.Clock()
finish = False



pressed = False
prev_pressed = False
prev_x, prev_y = pygame.mouse.get_pos()

def guess():
    # blur from viewing size to 28x28
    blurred_image = [[0 for i in range(28)] for j in range(28)]
    for i in range(28):
        for j in range (28):
            pixel_color = 0
            for k in range (20):
                for l in range(20):
                    pixel_color+=screen.get_at((i*20+k, j*20+l))[0]
            blurred_image[i][j] = round(pixel_color/400)
    # apply blurred list to screen
    for i in range(28):
        clock.tick(speed)
        for j in range (28):
            pygame.draw.rect(screen, (blurred_image[i][j], blurred_image[i][j], blurred_image[i][j]), (i*20, j*20, 20, 20))
        pygame.display.flip()
    # sharpen image for recognition
    sharpened_image = [[0 for i in range(28)] for j in range(28)]
    
    for i in range (28):
        for j in range (28):
            pixel_color = 0
            count = 0
            # ???
            if i != 0:
                pixel_color -= blurred_image[i-1][j]
                count+=1
            if j != 0:
                pixel_color -= blurred_image[i][j-1]
                count+=1
            if i != 27:
                pixel_color -= blurred_image[i+1][j]
                count+=1
            if j != 27:
                pixel_color -= blurred_image[i][j+1]
                count+=1
            pixel_color+=(count+1)*blurred_image[i][j]
            if pixel_color<0:
                pixel_color = 0
            elif pixel_color>255:
                pixel_color = 255
            sharpened_image[i][j] = round(pixel_color)
    # apply sharpened list to screen
    for i in range(28):
        clock.tick(speed)
        for j in range (28):
            pygame.draw.rect(screen, (sharpened_image[i][j], sharpened_image[i][j], sharpened_image[i][j]), (i*20, j*20, 20, 20))
        pygame.display.flip()
    input_image = [[0 for i in range(28)] for j in range(28)]
    for i in range(28):
        for j in range (28):
            input_image[i][j] = sharpened_image[j][i]
    # predict
    answer_array = model.predict(np.array([input_image]))
    count = 0
    for i in range(10):
        count += answer_array[0][i]
    print(count)
    print(answer_array)
    for i in range (10):
        if round(answer_array[0][i]*100/count, 2) > 0:
            if i != 9:
                print('probability of being', i+1, 'is:', round(answer_array[0][i]*100/count, 2), '%')
            else:
                print('probability of being', 0, 'is:', round(answer_array[0][i]*100/count, 2), '%')
    

            

    

    


while not finish:
    clock.tick(60)
    

    x, y = pygame.mouse.get_pos()
    

    
    for event in pygame.event.get():
        key_press = pygame.key.get_pressed()
        mouse_press = pygame.mouse.get_pressed()
        if event.type == pygame.QUIT:
            finish = True
            sys.exit()
        
        if key_press[pygame.K_RETURN]:
            guess()
        if key_press[pygame.K_d]:
            pygame.draw.rect(screen, (0, 0, 0), (0, 0, screen_size, screen_size))
        if mouse_press[0]:
            pressed = True
        else:
            pressed = False
        






        if pressed == True:
            if prev_pressed == True:

                pygame.draw.line(screen, (255,255,255), (x, y), (prev_x, prev_y), size)
            
            pygame.draw.circle(screen, (255,255,255), (x, y), size/2.2, 0)
            prev_pressed = True
            prev_x, prev_y = x, y
        else:
            prev_pressed = False
            


    pygame.display.flip()
    

