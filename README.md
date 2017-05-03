# ViagogoTask

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
