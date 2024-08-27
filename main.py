name = "Earl"
first_name = "Earl Romeo"
last_name = "Ordovez"
print("Hello " + name)
print(type(name))

for char in first_name:
    print(char)

#
# print("Hello " + first_name + " " + last_name)
# age = 19
# age += 1
# print(type(age))
# print("My age is " + str(age))

# height = 250.5
# print(type(height))
# print("My height is " + str(height) + " cm")

# human = True
# # print(type(human))
#
# print("Are you a human " + str(human))

# name = "Earl"
# age = 19
# attractive = True

# name, age, attractive = "Earl", 19, True
#
# print(name)
# print(age)
# print(attractive)

# Spongebob = patrick = Sandy = Squidward = 30
# print(Spongebob, patrick, Sandy, Squidward)

# name = "Earl Romeo"
# print(len(name)) length
# print(name.find("R"))
# print(name.capitalize())
# print(name.upper())
# print(name.lower())
# print(name.isdigit())
# print(name.isalpha())
# print(name.count("E"))
# print(name.replace("o", "a"))
# print(name*10)

# x = 1
# y = 2.0
# z = "3"

# y = str(y)
# z = str(z)
# x = str(x)
#
#
# y = float(y)
# z = float(z)
# x = float(x)

# print("X is " + str(x))
# print(y)  #print(int(y))
# print(z * 3)
#
#
# name = input("What is your name?: ")
# age = int(input("How old are you?: "))
# height = float(input("How tall are you?: "))
#
#
# print("Hello " + str(name) + "\nYour age is " + str(age) + "\nYou are " + str(height) + "cm tall")


# import math
#
# pi = 3.14
# x = 1
# y = 2
# z = 3
#
# print(round(pi))
# print(math.ceil(pi))
# print(math.floor(pi))
# print(abs(pi))
# print(pow(pi, 2))
# print(math.sqrt(pi))
# print(max(x, y, z))
# print(min(x, y, z))


# slicing [start:stop:step]
#
# name = "Earl Romeo B Ordovez"
#
# first_name = name[0:10]
# last_name = name[13:20]
# funky_name = name[::2]
# reversed_name = name[::-1]
#
# print("My first name is " + first_name)
# print("My last name is " + last_name)
# print(funky_name)
# print(reversed_name)
#
# website = "https://google.com"
# website2 = "https://wikipedia.com"
#
# sliced = slice(8, -4)
#
# print(website)
# print(website[sliced])
# print(website2)
# print(website2[sliced])
#
# age = int(input("How old are you?: "))
#
# if age >= 70:
#     print("GYATT DAMN YOU ARE OLD")
#
# elif age >= 18:
#     print("You are an adult")
#
# elif age < 0:
#     print("You haven't been born yet")
#
# else:
#     print("You are an minor")


# logical operators and or not
# #
# temp = int(input("What is the temperature outside?: "))
#
# if temp >= 0 and temp <= 30:
#     print("The temperature is COLD")
#     print("Wear heavy clothing")
#
# elif temp < 0 or temp > 30:
#     print("The temperature is bad today")
#     print("Stay inside!")
#
# if not(temp >= 0 and temp <= 30):
#     print("The temperature is good today")
#     print("Go outside")
#
# elif not(temp < 0 or temp > 30):
#     print("The temperature is bad today")
#     print("Stay inside!")


# while loop
#
# name = ""
#
# while len(name) == 0:
#     name = input("Enter your name: ")
#
# while len(name) <= 6:
#     print("Please input more than 6 Characters")
#     name = input("Enter your name: ")
#
# while len(name) > 20:
#     print("No more than 20 characters")
#     name = input("Enter your name: ")
#
# name = None
#
# while not name:
#     name = input("Enter your name: ")
#
# print("Hello " + name)
#
# for i in range(10):
#     print(i)
#
# for i in range(50,101,2):
#     print(i)
#
# for i in "Earl":
#     print(i)
#
# import time
#
# for seconds in range(10,0,-1):
#     print(seconds)
#     time.sleep(1)
#
# print("Happy New Year!")


# nested loop
#
# rows = int(input("How many rows?: "))
# columns = int(input("How many columns?: "))
# symbol = input("What symbol to use?: ")
#
# for i in range(rows):
#     for j in range(columns):
#         print(symbol, end=" ")
#     print(" ")
#
# rows = int(input("How many rows?: "))
# columns = int(input("How many columns?: "))
# symbol = input("What symbol to use?: ")
#
# for i in range(rows):
#     for j in range(columns):
#         if i == 0 or i == rows - 1 or j == 0 or j == columns - 1:
#             print(symbol, end=" ")
#         else:
#             print(" ", end=" ")
#     print(" ")


# loop control

# while True:
#     name = input("Enter Your Name: ")
#     if name != "":
#         break
#
# phone_number = "123-456-789-0"
#
# for i in phone_number:
#     if i == "-":
#         continue
#     print(i, end=" ")
#
# for i in range(1, 21):
#     if i == 13:
#         pass
#     else:
#         print(i)


# def convert_temperature():
#     temp = float(input("Enter temperature: "))
#     unit = input("Is this in Celsius (C), Fahrenheit (F), or Kelvin (K)? ").upper()
#
#     while unit not in ["C", "F", "K"]:
#         print("Invalid unit. Please enter C for Celsius, F for Fahrenheit, or K for Kelvin.")
#         unit = input("Is this in Celsius (C), Fahrenheit (F), or Kelvin (K)? ").upper()
#
#     if unit == "C":
#         print(f"{temp}°C is {temp * 9 / 5 + 32}°F and {temp + 273.15}K")
#     elif unit == "F":
#         print(f"{temp}°F is {(temp - 32) * 5 / 9}°C and {(temp - 32) * 5 / 9 + 273.15}K")
#     elif unit == "K":
#         print(f"{temp}K is {temp - 273.15}°C and {(temp - 273.15) * 9 / 5 + 32}°F")
#
#
# convert_temperature()


# list
#
# food = ["Pizza", "hamburgers", "hat dog", "spaghetti"]
#
# food[0] = "sushi"
# food.append("ice cream")
# food.remove("hat dog")
# food.pop()
# food.insert(0, "cake")
# food.sort()
# food.clear()
# print(food[0])
#
# for i in food:
#     print(i)


# 2d list
#
# drinks = ["coffee", "soda", "tea"]
# dinner = ["pizza", "hamburger", "hotdog"]
# dessert = ["cake", "ice cream"]
#
# food = [drinks, dinner, dessert]
# # food.sort()
#
# # print(food[1][2])
#
# for i in food[1]:
#     print(i)


# tuples
#
# student = ("Earl", 19, "male")
#
# # print(student.count("Earl"))
# # print(student.index("male"))
#
# for i in student:
#     print(i)
#
# if "Earl" in student:
#     print("Earl is here")


# set
#
# utensils = {"fork", "spoon", "knife", "knife"}
# dishes = {"bowl", "plate", "cup", "knife"}
#
# utensils.add("napkin")
# utensils.remove("fork")
# utensils.clear()
# # dinner_table = utensils.union(dishes)utensils.update(dishes)
#
#
# for i in dinner_table:
#     print(i)
# for i in utensils:
#     print(i)
#
# print(utensils.difference(dishes))
# print(utensils.intersection(dishes))


# dictionary
#
# capitals = {"USA": "Washington DC",
#             "India": "New Deli",
#             "China": "Beijing",
#             "Russia": "Moscow"}
#
# capitals.update({"Germany": "Berlin"})
# capitals.update({"USA": "Las Vegas"})  # ({"Mars":"Las Vegas"})
# capitals.pop("China")
# capitals.clear()
#
# print(capitals["Russia"])
# for i in capitals:
#     print(i)
# print(capitals.get("Germany"))
# print(capitals.keys())
# print(capitals.values())
# print(capitals.items())
#
# for key, value in capitals.items():
#     print(key, value)


# index operator
#
# name = "earl Romeo Ordovez!"
#
# # if(name[0].islower()):
# #     name = name.capitalize()
#
# first_name = name[0:11].title() # capitalize # lower # upper
# last_name = name[11:19].title() # or [11:]
# last_character = name[-1]
#
# # first_name = first_name.upper()
#
# print(first_name)
# print(last_name)
# print(last_character)


# function
#
# # name = input("What is Your name?: ")
#
# # import time
# def hello(first_name, last_name, age):
#     print("Hello " + first_name+ " " + last_name)
#     print("You are " + str(age) + " years old")
#     print("Have a nice day!")
#     # hello()
#
# # name = "Earl"
# hello("Earl", "Ordovez", 19)
# # hello("Earl")


# Return statements
#
# number1 = int(input("Enter First number: "))
# number2 = int(input("Enter Second number: "))
#
# def multiply(number1, number2):
#     result = number1 * number2
#     return result
# def multiply(number1, number2):
#     return number1 * number2
#
# # print(multiply(number1, number2))
#
# x = multiply(6,8)
# print(x)


# keyword arguments
#
# def hello(first, middle, last):
#     print("Hello " + first +" "+ middle +" "+ last)
#
# # hello("Earl Romeo", "B.", "Ordovez")
# hello(last ="Ordovez", first="Earl Romeo", middle="B.")


# nested function calls
#
# num = input("Enter a whole positive number: ")
# num = float(num)
# num = abs(num)
# num = round(num)
# print(num)
#
# print(round(abs(float(input("Enter a whole positive integer: ")))))


# variable scope
#
# name = "Earl" # Global variable
#
# def displayName():
#     name = "Meowie"  # local Variable
#     print(name)
#
# displayName()
# print(name)


# *args
#
# def add(*args):
#     sum = 0
#     args = list(args) # tuples can be changed to list
#     args[0] = 13  # can reiterate values
#     for i in args:
#         sum += i
#     return sum
#
# print(add(1,1,2,3,5,6))
#
# def add(*combine):
#     total = 0
#     for i in combine:
#         total += i
#     return total
#
# def getUserInputs():
#     global intList
#     userInputs = input("Enter numbers separated by spaces: ")
#     inputList = userInputs.split()
#
#     try:
#         intList = [int(i) for i in inputList]
#     except ValueError:
#         getUserInputs()
#     return intList
#
# # Get user inputs and call the add function
# numbers = getUserInputs()
# result = add(*numbers)
# print("The sum is:", result)


# kwargs
#
# def hello(**kwargs):
#     # print("Hello " + kwargs["first"] + " " + kwargs["last"])
#     print("Hello",end=" ")
#     for key,value in kwargs.items():
#         print(value, end=" ")
#
#
# hello(title="Mr.",first="Earl", middle="B", last="Ordovez")


# string format
#
# animal = "cow"
# item = "moon"
#
# print("The " + animal + " jumped over the " + item)
#
# print("The {} jumped over the {}".format("cow", "moon"))
# print("The {} jumped over the {}".format(animal, item))
# print("The {0} jumped over the {1}".format(animal, item))
# print("The {animal} jumped over the {item}".format(animal="cow", item="moon"))
# print(f"The {animal} jumped over the {item}")
#
# text = "The {} jumped over the {}"
# print(text.format(animal, item))
#
# name = "Earl"
#
# print("Hello my name is {}".format(name))
# print("Hello my name is {:10}.".format(name))
# print("Hello my name is {:<10}.".format(name))
# print("Hello my name is {:>10}.".format(name))
# print("Hello my name is {:^10}.".format(name))
#
# number = 10000
# pi = 3.14159
#
# print("{:.2f}".format(pi))
# print("{:,}".format(number))
# print("{:b}".format(number))
# print("{:o}".format(number))
# print("{:x}".format(number))
# print("{:e}".format(number))


# import random
#
#  = random.randint(1,6)
# random1 = random.random()
# print(random1)
#
# list = ["rock", "paper", "scissors"]
# randomList = (random.choice(list)).title()
#
# print(randomList)
#
# cards = [1,2,3,4,5,6,7,8,9, "J", "Q", "Q"]
# random.shuffle(cards)
# print(cards)


# exception
#
# try:
#     numerator = int(input("Enter a number to divide: "))
#     denominator = int(input("Enter a number to divide by: "))
#     result = numerator / denominator
# except ZeroDivisionError as e:
#     print(e)
#     print("You can't divide by zero :(")
# except ValueError as e:
#     print(e)
#     print("You can only divide numbers :(")
# # except Exception:
# #     print("something went wrong :(")
# else:
#     print(result)
# finally:
#     print("This will always execute")
# print("{:.2f}".format(result))
# print(result)


# file detection
# import os
#
# path = "C:\\Users\\earlo\\OneDrive\\Desktop\\AlloCare"
# path2 = "C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE"
# if os.path.exists(path):
#     print("The exist in that location")
#     if os.path.isfile(path):
#         print("This is a file")
# else:
#     print("That location doesnt exist")
#
# if os.path.exists(path2):
#     print("This exist in that location")
#     if os.path.isdir(path2):
#         print("This is a file directory")
# else:
#     print("This file doesnt exist")
#
# location = "C:\\Users\\earlo\\OneDrive\\Desktop\\python"
#
# if os.path.exists(location):
#     print("This exist in the location")
#     if os.path.isfile(location):
#         print("This is a file")
#     elif os.path.isdir(location):
#         print("This is a file directory")
#     else:
#         print("This is a different extension")
# else:
#     print("this file doesnt exist :(")


# read text file
#
# with open("C:\\Users\\earlo\\OneDrive\\Desktop\\Java\\BMI\\BMI.java") as file:
# try:
#     with open("C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\read.txt") as file:
#         print(file.read())
#         print(file.closed) # see if file is open or not
# except FileNotFoundError:
#     print("File was not found :(")


# writing files
#
# text = "\ni manage to append this text"
# with open("C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\writing.txt", "a") as file: # r for read
# w for write # a for append
#     file.write(text)
#
# with open("C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\writing.txt") as file:
#     print(file.read())
#
#
# path = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\test.txt"
# text = "I have writen something to this file!"
# appended = "\ni have overwritten this file with this text"
#
# with open(path, "w") as file:
#     file.write(text)
# with open(path, "a") as appends:
#     appends.write(appended)
# with open(path) as file:
#     print(file.read())


# copying file using shutil
# import shutil
# #
# try:
#     path = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\copyingFile.txt"
#     dst = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\copy.txt"
#     placingFile = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\placing"
#     shutil.copy2(path, placingFile)  # src and destination
# except PermissionError:
#     print("There is something wrong with permission :(")
# except FileNotFoundError:
#     print("This file doesnt exist :(")
# else:
#     print("File Was Successfully Copied")
# finally:
#     print("--Earl--")


# move a file
#
# import os
#
# destination = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\moving.txt"
# source = "C:\\Users\\earlo\\OneDrive\\Desktop\\test.txt" # the test.txt is used to rename the file
#
# try:
#     if os.path.isfile(destination):
#         print("File exists")
#     else:
#         os.replace(source, destination)
#         print("File replaced")
# except FileNotFoundError:
#     print(source + "File Not Found")


# delete files
#
# import os
# import shutil
#
# path = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\deleting.txt"
# path = "C:\\Users\\earlo\\OneDrive\\Desktop\\python\\test\\New folder"
# deletion = False
#
# try:
#     if os.path.isfile(path):
#         os.remove(path)
#         print("File removed")
#         deletion = True
#     elif os.path.isdir(path):
#         os.rmdir(path)
#         print("Folder removed")
#         deletion = True
# except FileNotFoundError:
#     print("File not found")
# except PermissionError:
#     print("Permission denied")
# except OSError:
#     print("Something went wrong")
#
# if deletion:
#     print("a file/empty directory was deleted")
# else:
# # # # # # # # #   shutil.rmtree(path)


# modules

# import messages as msg
# from messages import hello, bye
# from messages import *
#
#
# msg.hello()
# msg.bye()
# hello()
# bye()


# idea for the rock paper scissor
#
# import random
# while True:
#     choices = ["rock", "paper", "scissors"]
#
#     enemy = random.choice(choices)
#     player = None
#
#     while player not in choices:
#         player = input("Choose rock, paper, or scissors: ").lower()
#
#     print(f"computer: {enemy}")
#     print(f"player: {player}")
#
#     if player == enemy:
#         print("TIE")
#     elif player == "rock":
#         if enemy == "scissors":
#             print("Player wins")
#         else:
#             print("Computer wins")
#
#     elif player == "paper":
#         if enemy == "scissors":
#             print("Computer wins")
#         else:
#             print("Player wins")
#
#     elif player == "scissors":
#         if enemy == "rock":
#             print("Computer wins")
#         else:
#             print("Player wins")
#
#     play_again = input("Would you like to play again? (yes/no) ").lower()
#     if play_again != "yes":
#         print("Thanks for playing!")
#         break


# class
# from car import Car
#
# car_1 = Car("Chevy", "Corvette", 2021, "Blue")
# car_2 = Car("Ford", "Mustang", 2022, "Red")
# car_1.wheels = 2
#
# Car.wheels = 2
#
# print(car_1.make)
# print(car_1.model)
# print(car_1.year)
# print(car_1.color)
# print(car_1.wheels)
# print(car_2.wheels)
#
# car_1.drive()
# car_1.stop()
#
# print(Car.wheels)


# inheritance
# from animal import Animal
# class Animal:
#
#     alive = True
#
#     def eat(self):
#         print('this animal is eating')
#
#     def sleep(self):
#         print('this animal is sleeping')
#
#
# class Rabbit(Animal):
#     def run(self):
#         print('this rabbit is running')
#
#
# class Fish(Animal):
#     def swim(self):
#         print('this fish is swimming')
#
#
# class Hawk(Animal):
#     def fly(self):
#         print('this hawk is flying')
#
#
# rabbit = Rabbit()
# fish = Fish()
# hawk = Hawk()
#
# # print(rabbit.alive)
# # fish.eat()
# # hawk.sleep()
#
# rabbit.run()
# hawk.fly()
# rabbit.eat()
# fish.swim()


# Multi level inheritance
# class Organism:
#     alive = True
#
#
# class Animal(Organism):
#     def eat(self):
#         print('this animal is eating')
#
#
# class Dog(Animal):
#     def bark(self):
#         print('this dog is barking')
#
#
# dog = Dog()
# print(dog.alive)
# dog.bark()
# dog.eat()


# multiple inheritance
# class Prey:
#     def flee(self):
#         print("This animal flee")
#
#
# class Predator:
#     def hunt(self):
#         print("This animal hunting")
#
#
# class Rabbit(Prey):
#     pass
#
#
# class Hawk(Predator):
#     pass
#
#
# class Fish(Prey, Predator):
#     pass
#
#
# rabbit = Rabbit()
# hawk = Hawk()
# fish = Fish()
#
# rabbit.flee()
# hawk.hunt()
# fish.flee()
# fish.hunt()


# method overriding
# class Animal:
#     def eat(self):
#         print("this animal is eating")
#
#
# class Rabbit(Animal):
#     def eat(self):
#         print("this Rabbit is eating a carrot")
#
#
# rabbit = Rabbit()
# rabbit.eat()


# method chaining
# class Car:
#     def turn_on(self):
#         print("Turning car on")
#         return self
#
#     def drive(self):
#         print("You drive the car")
#         return self
#
#     def brake(self):
#         print("You step on the brakes")
#         return self
#
#     def turn_off(self):
#         print("Turning car off")
#         return self
#
#
# car = Car()
# # car.turn_on().drive()
# # car.brake().turn_off()
# (car.turn_on()
#  .drive()
#  .brake()
#  .turn_off())


# super function
# class Rectangle:
#     def __init__(self, length, width):
#         self.length = length
#         self.width = width
#
#
# class Square(Rectangle):
#     def __init__(self, length, width):
#         # self.length = length
#         # self.width = width
#         super().__init__(length, width)
#
#     def area(self):
#         return self.length * self.width
#
#
# class Cube(Rectangle):
#     def __init__(self, length, width, height):
#         # self.length = length
#         # self.width = width
#         super().__init__(length, width)
#         self.height = height
#
#     def volume(self):
#         return self.length * self.width * self.height
#
#
# square = Square(5, 5)
# cube = Cube(5, 5, 5)
#
# print(square.area())
# print(cube.volume())


# abstract classes prevent user form creating object of the class
# from abc import ABC, abstractmethod
# class Vehicle(ABC):  # does have declaration but doesn't have implementation
#     @abstractmethod
#     def go(self):
#         pass
#
#     @abstractmethod
#     def stop(self):
#         pass
#
#
# class Car(Vehicle):
#     def go(self):
#         print("You drive the car")
#
#     def stop(self):
#         print("You stop the car")
#
# class Motorcycle(Vehicle):
#     def go(self):
#         print("You drive the motorcycle")
#
#     def stop(self):
#         print("You stop the motorcycle")
#
#
# # vehicle = Vehicle() prevent suer from creating an object from that class
# car = Car()
# motorcycle = Motorcycle()
#
# # vehicle.go()
# car.go()
# motorcycle.go()
# car.stop()
# motorcycle.stop()


# pass object as arguments
# class Car:
#     color = None
#
#
# class Motorcycle:
#     color = None
#
#
# def change_color(car, color):
#     car.color = color
#
#
# car_1 = Car()
# car_2 = Car()
# car_3 = Car()
#
# bike_1 = Motorcycle()
#
#
# change_color(car_1, "Red")
# change_color(car_2, "Blue")
# change_color(car_3, "Green")
# change_color(bike_1, "Yellow")
#
#
# print(car_1.color)
# print(car_2.color)
# print(car_3.color)
# print(bike_1.color)


# Duck typing
# class Duck:
#     def walk(self):
#         print("This Duck is walking")
#
#     def talk(self):
#         print("This Duck is quaking")
#
#
# class Chicken:
#     def walk(self):
#         print("This Chicken is walking")
#
#     def talk(self):
#         print("This Chicken is clucking")
#
#
# class Person():
#     def catch(self, duck):
#         duck.walk()
#         duck.talk()
#         print("You caught a critter")
#
#
# duck = Duck()
# chicken = Chicken()
# person = Person()
#
# person.catch(chicken)  # if it walks like a duck, and it quacks like a duck, then it must be a duck
# person.catch(duck)  # both class should have both objects


# walrus operator # assignment expression
# happy = True
# print(happy)
#
# print(happy := "MEOW")
# foods = list()
# while True:
#     food = input("Enter food name: ")
#     if food == "quit":
#         break
#     foods.append(food)
#
# print(foods)
# foods = list()
# while food := input("What food do you like?: ") != "quit":
#     foods.append(food)


# assign function to a variable
# def hello():
#     print("Hello World")
#
# hi = hello
# # print(hi)
# hello()
# hi()
# say = print
# say("WHOA THIS WORKS??")


# higher order function
#
# def loud(text):
#     return text.upper()
#
#
# def quiet(text):
#     return text.lower()
#
#
# def hello(func):
#     text = func("Hello World!")
#     print(text)
#
#
# hello(loud)
# hello(quiet)
#
# text = "Hello, World"
#
# high_order = list(map(loud, text))
# print(high_order)
#
# for i in high_order:
#     print(i, end="")
#
# print()
#
# for i in range(len(high_order)):
#     print(high_order[i], end="")
#
# def divisor(x):
#     def dividend(y):
#         return y / x
#     return dividend
#
#
# divide = divisor(2)
# # print(f"{divide(10):.0f}")
# print(divide(10))
