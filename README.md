# ViagogoTask

Requirements
 
- Code in any language you like but please provide clear instructions on how we should build & run your code
- Please use any source control system you like, and send us a link (or if you prefer just a zip of your project)
- The first requirement is your code meets the requirements
- Secondary requirements are whether your code is idiomatic for the language being coded in, easy to read, and clearly laid out
 
Scenario
 
- Your program should randomly generate seed data
- Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10 to +10 (X axis)
- Your program should assume that each co-ordinate can hold a maximum of one event
- Each event has a unique numeric identifier (e.g. 1, 2, 3)
- Each event has zero or more tickets
- Each ticket has a non-zero price, expressed in US Dollars
- The distance between two points should be computed as the Manhattan distance
 
Instructions
 
- You are required to write a program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event
- Please detail any assumptions you have made
- How might you change your program if you needed to support multiple events at the same location?
- How would you change your program if you were working with a much larger world size?
 
Example Program Run
 
Please Input Coordinates:
 
> 4,2
 
Closest Events to (4,2):
 
Event 003 - $30.29, Distance 3
Event 001 - $35.20, Distance 5
Event 006 - $01.40, Distance 12

# Solution

This project was made using Intellij Idea, but can be run using any Java IDE.

To run:
Open up the project in any Java IDE
Open the GridSearch class and run it.

Assumptions:
There are a maximum of 3 types of tickets that an event can have.
Ticket prices are between 1-100


How might you change your program if you needed to support multiple events at the same location?

Each event needs to have a unique event id(that the program already does). So nothing needs to be changed for the program to handle it.


How would you change your program if you were working with a much larger world size?

If the world size was larger the CityEvents and their information will need to be stored in a simple database table.
An SQL statement could be used to get the distances as follows: 
SELECT EventId, abs(Lat - UserLat) + abs(Long - UserLong) as Distance, Price
FROM Events
Order By Distance

After which the displaying of results could be constrained to just 5 entries.
