public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /** 
     * Default constructor
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /** 
     * Overloaded constructor with address only
     * @param address The address of the building.  
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /**
     * Overloaded constructor with name, address
     * @param name The name of the building.
     * @param address The address of the building.   
     */

    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /** Full constructor
     * @param name The name of the building.
     * @param address The address of the building.
     * @param nFloors The number of floors in the building.
     * @throws RuntimeException if the number of floors is less than 1.
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { 
            this.name = name; 
        }
        if (address != null) { 
            this.address = address; 
        } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Accessor for the building's name.
     * @return The name of the building.
     */    
    public String getName() {
        return this.name;
    }
    /**
     * Accessor for the building's address.
     * @return The address of the building.
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * Accessor for the number of floors.
     * @return The number of floors in the building.
     */
    public int getnFloors() {
        return this.nFloors;
    }
    /**
     * Enters the building, setting the active floor to the ground floor (1).
     * If already inside the building, throws a RuntimeException.
     * @return A pointer to the current Building object.
     * @throws RuntimeException if the user is already inside the building.
     */
    public Building enter() {
        if (activeFloor != -1) 
        {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Exits the building, resetting the active floor to -1.
     * Throws a RuntimeException if not currently inside the building or if the active floor is above the first floor.
     * @return null, indicating that the user is no longer inside the building.
     * @throws RuntimeException if the user is not inside the building or is on a floor higher than the first.
     */
    public Building exit() {
        if (this.activeFloor == -1) 
        {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) 
        {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /**
     * Navigates to the specified floor number.
     * Throws a RuntimeException if not inside the building or if the floor number is invalid.
     * @param floorNum The floor number to go to.
     * @throws RuntimeException if the user is not inside the building or if the floor number is out of the valid range (1 to nFloors).
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) 
        {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) 
        {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }
    /**
     * Moves up one floor. Calls goToFloor() with the next higher floor number.
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }
    /**
     * Moves down one floor. Calls goToFloor() with the next lower floor number.
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Displays the available options for interacting with the building.
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }
    /**
     * Returns a string representation of the Building object.
     * @return A string describing the building's name, number of floors, and address.
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /**
     * Main method 
     * @param args 
     */

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }

}
