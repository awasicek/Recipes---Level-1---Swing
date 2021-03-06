//Explaining Static 

//Trying to explain static to kids is difficult….

//You use static when you don’t want to use or don’t have an instance. Most notably in the main method. This is static because when the program starts, no instances exist. 

//Static variables belong to the class, not any instance and because of this, all instances share the variable. Here is an example:-
//

//Task:  	Create a class for athlete/marathon runners.
//Requirements:
//Sequential bib-numbers 
//Count the number of athletes
//Set the race location & start time

// 1. Class for making Athletes
// 2. Following information should be in Athlete class: name, speed, bib number, count (of athletes in the race; hint: static), 
//   location of the race (hint: static), start time of the race (hint: static).
// 3. In the main method:
//    a. make some athletes
//    b. print out each athlete's name and bib number
//    c. change the race location and/or time
//    d. change the race location again but only for one athlete (hint: john.location = "Chicago";)
//    e. print out the name of each athlete and where and when they are racing

public class Athlete {

	String name;
	int speed;
	int bibNumber;
	static int count;
	static String location = "New York";
	static String startTime = "9.00am";

	Athlete(String name, int speed) {
		this.name = name;
		this.speed = speed;
		count++;
		this.bibNumber = count;
	}

	public static void main(String[] args) {
		Athlete john = new Athlete("John", 10);
		Athlete sarah = new Athlete("Sarah", 11);

		System.out.println(sarah.name + "'s bib number is " + sarah.bibNumber);
		System.out.println("Total number of athletes is " + count);
		location = "San Diego";
		System.out.println(john.name + " is running in " + john.location);
		john.location = "Chicago";
		System.out.println(sarah.name + " is running in " + sarah.location);

	}
}
// Show that the static variables belong to the class and the other variables
// belong to the instance.

// Show what happens to the variables when the 2 constructors run, especially
// how count changes and when bib number is assigned.

// Show how you can update the location and this is updated for all the
// athletes.
