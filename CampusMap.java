import java.util.ArrayList;

/***
 * Represents a campus map that contains a collection of buildings
 */
public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Returns a string representation of the campus map.
     * The string includes a directory header followed by a numbered list
     * of all the buildings currently on the map, including their names and addresses.
     *
     * @return A formatted string representing the campus map directory.
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        
        // System.out.println(myMap);

        //houses
        House Washburn  = new House("Washburn House","4 Seelye Dr, Northampton, MA 01063",3,false);
        House Chase  = new House("Chase House","45 Elm Street, Northampton, MA 01063",3,false);

        House King  = new House("King House","179 Elm Street, Northampton, MA 01063",3,true);

        House Jordan  = new House("Jordan House","1 Paradise Road, Northampton, MA 01063",4,false);

        House Haynes = new House("Haynes House","1 Mandelle Rd, Northampton, MA 01063",4,true);

        //libraries
        Library Neilson = new Library("Neilson Library", "10 Neilson Drive", 4);
        Library Josten  = new Library("Josten LIbrary", "122 Green St, Northampton, MA 01063", 1);
        Library Hillyer = new Library("Hillyer Library","22 Elm St, Northampton, MA 01063" ,3);

        //Cafes
        Cafe Compass = new Cafe( "Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 4 );
        Cafe CC = new Cafe( "Campus Center Cafe", "1 Chapin Way Northampton, MA 01063 ",  1);

        //adding the houses

        myMap.addBuilding(Washburn);
        myMap.addBuilding(Chase);
        myMap.addBuilding(King);
        myMap.addBuilding(Jordan);
        myMap.addBuilding(Haynes);

        //adding our Cafes

        myMap.addBuilding(CC);
        myMap.addBuilding(Compass);

        //adding our libraries
        myMap.addBuilding(Neilson);
        myMap.addBuilding(Josten);
        myMap.addBuilding(Hillyer);


        System.out.println(myMap);

        //testing my overloaded methods in the library
        Neilson.addTitle("Pedagogy of the Oppressed");
        Josten.addTitle("Sense and Sensibility");

        try {
            Neilson.checkOut("Pedagogy of the Oppressed");
            Josten.checkOut("Sense and Sensibility");
            System.out.println("Successfully checked out 'Pedagogy of the Oppressed'.");
            System.out.println("Is 'The Great Gatsby' available? " + Neilson.isAvailable("Pedagogy of the Oppressed"));
        } catch (RuntimeException e) {
            System.out.println("Error checking out 'Pedagogy of the Oppressed': " + e.getMessage());
        }

        // trying to check out a book that isn't in a library
        try {
            Josten.checkOut("Pedagogy of the Oppressed");
            System.out.println("Successfully checked out 'Moby Dick' (this should not happen).");
        } catch (RuntimeException e) {
            System.out.println("Error checking out 'Moby Dick': " + e.getMessage());
        }


        // Try to add  a bunch of books
        ArrayList<String> newBooks = new ArrayList<>();
        newBooks.add("Java for Dummies");
        newBooks.add("Think Like a Programmer");
        newBooks.add("Thunderhead");
        newBooks.add("Calculus Single Variable");
        newBooks.add("Frankenstein");

        Neilson.addTitle(newBooks);
        Neilson.printCollection();

        //trying to check out a bunch of books

        ArrayList<String>desiredBooks = new ArrayList<>();
        desiredBooks.add("Java for Dummies");
        desiredBooks.add("Calculus Single Variable");


        Neilson.checkOut(desiredBooks);

        //testing overloaded methods from my cafe class


        //testing the selling a general coffee method
        Compass.sellCoffee(12); // Selling a general coffee
        Compass.sellCoffee(16); // Selling another general coffee
        //testing the selling a latte method
        CC.sellCoffee(4, 6);
        CC.sellCoffee(20,500);

        //testing constructor()
        Cafe cafe1 = new Cafe("The Daily Grind", "456 Oak Avenue", 2);
        System.out.println("Cafe 1 Name: " + cafe1.getName());
        System.out.println("Cafe 1 Address: " + cafe1.getAddress());
        System.out.println();

        // Using the constructor with name and address only(overloaded)
        Cafe cafe2 = new Cafe("Coffee Corner", "789 Pine Street");
        System.out.println("Cafe 2 Name: " + cafe2.getName());
        System.out.println("Cafe 2 Address: " + cafe2.getAddress());
        System.out.println();

        System.out.println();
        //testing overloaded methods from my house class





    }
    
}
