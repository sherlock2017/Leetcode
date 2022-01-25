* same as previous category to find the count of longest substring palindrome
* note: dp kaa matlab:
1. dp x axis = end points
2. dp y axis = start points
​
* sare gap diagonals pr check kro ki palindrome hai ki nahi
* gap = 0 diagonal - ye toh palindrome honge hi, since start aur end same hai
* gap = 1 diagonal - ye tabhi palindrome honge jab start aur end character same honge
gap > 1 diagonal - ye tabhi palindrom honge jab :
1) start aur end character same honge aur
2) beech ki puri string palindrome ho - i + 1, j - 1 pr ho calculate kia tha vo