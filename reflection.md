Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
For my cafe class , I decided to overload my sellCoffee() method and my constructor : I wanted to be able to sell customizable coffees and just house default recipes, I also wanted to be able to build cafes with either a fixed number of floors or another attribute

For my library class I overloaded the checkOut() and addBook() methods because I didn't want my library to be able to check in and check one just one book at a time ,cause that would realistically take too long.

For my House class, I implemented similar thinking and decided to overload the moveIn and moveOut methods, to move out an arrayList of students instead of just one student at a time.

- What worked, what didn't, what advice would you give someone taking this course in the future?
I realized that because a lot of my methods across my classes were structured similarly that I could overload them in very similar ways across classes. I did try to checkout books by their ISBN values instead of their course titles but that didn't work because the way my collection hashtable as set up was in string ,boolean form and not integer ,boolean so instead I checked out an arraylist of books , by iterating through the arraylist and removing each title instead.
