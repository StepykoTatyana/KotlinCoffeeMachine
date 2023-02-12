def buy(water, milk, coffee_beans, money, cups=1):
    water_m = 400 - water
    milk_m = 540 - milk
    coffee_beans_m = 120 - coffee_beans
    cups_m = 9 - cups
    money_m = 550 + money
    print()
    print(f"""The coffee machine has:
{water_m} of water
{milk_m} of milk
{coffee_beans_m} of coffee beans
{cups_m} of disposable cups
{money_m} of money""")


def fill():
    water = 400 + int(input("Write how many ml of water do you want to add: "))
    milk = 540 + int(input("Write how many ml of milk do you want to add: "))
    coffee_beans = 120 + int(input("Write how many grams of coffee beans do you want to add: "))
    cups = 9 + int(input("Write how many disposable cups of coffee do you want to add: "))
    print()
    print(f"""The coffee machine has:
{water} of water
{milk} of milk
{coffee_beans} of coffee beans
{cups} of disposable cups
550 of money""")


def take():
    print(f"I gave you $550")
    print()
    print(f"""The coffee machine has: 
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
0 of money""")


print("""The coffee machine has:
400 of water
540 of milk
120 of coffee beans
9 of disposable cups
550 of money""")
action = input("Write action (buy, fill, take): ")
if action == "buy":
    coffee_type = int(input("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: "))
    if coffee_type == 1:  # espresso
        water = 250
        coffee_beans = 16
        milk = 0
        money = 4
        buy(water, milk, coffee_beans, money)

    if coffee_type == 2:  # a latte
        water = 350
        milk = 75
        coffee_beans = 20
        money = 7
        buy(water, milk, coffee_beans, money)
    if coffee_type == 3:  # a cappuccino
        water = 200
        milk = 100
        coffee_beans = 12
        money = 6
        buy(water, milk, coffee_beans, money)
if action == 'fill':
    fill()
if action == 'take':
    take()