# wordCalculator
A calculator which adds or subtracts words which are assigned with an integer while while defining
calculate the solution which is denoted by calc, but no output should be printed for definitions which is denoted by def
If word is not found with the sum print unknown, typing clear will remove all the saved words.
Sample Input :
def apple 4
calc apple + fruit =
def fruit 5
def healthy 9
calc apple + fruit =
def is 4
def good 6
calc healthy - is + good =
def fun 11
calc programming - is + fun =
clear

Sample Output:
apple + fruit = unknown // as fruit is not defined yet
apple + fruit = healthy  // fruit is defined now and apple + fruit = 5 + 4 = 9 = healthy
healthy - is + good = unknown // because healthy - is + good = 9 - 4 + 6 = 11 which is not defined yet
healthy - is + good = fun  // 11 defined as fun
