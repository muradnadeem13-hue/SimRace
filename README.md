<b>A simple car race Java program (without GUI) in which a car is implemented as a thread.</b><br><b>(Start the race by running the main method in SimRace.java)</b>

<h2>Car.java</h2>
<p>
  A car has a name and drives for a set amount of rounds. The time required to complete a round is determined randomly. After completing a round, a car rests for a set amount of time. In order to actually participate in a race, a car is used by a caller (SimRace.java).
</p>

<h2>SimRace.java</h2>
<p>
  The core element of the program. It aligns the cars for the race and makes them drive. The time one car needs to complete the race is independent from the finishing time of the other cars. After the race is done, a "table" is shown with each car's rank. 
</p>
