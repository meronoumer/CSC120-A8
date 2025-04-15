


/* This is a stub for the Cafe class */



/**
 * Represents a Cafe building with an inventory containing coffee, sugar, cream, and cups.
 */
public class Cafe extends Building {
   /**
    * How many ounces of coffee are remaining in inventory.
    */
    private int nCoffeeOunces;
   /**
    * How many sugar packets are remaining in inventory.
    */
    private int nSugarPackets;
   /**
    * The number of "splashes" of cream remaining in inventory.
    */
    private int nCreams;
   /**
    * How many cups are remaining in inventory.
    */
    private int nCups;

    private boolean hasElevator; 


   /**
    * Constructs a new Cafe object.
    *
    * @param name    The name of the cafe.
    * @param address The address of the cafe.
    * @param nFloors The number of floors in the cafe.
    */

    public Cafe(String name,String address,int nFloors ) { 
        super(name, address, nFloors);//is this right
        
        this.nCoffeeOunces  =100;
        this.nSugarPackets = 200;
        this.nCreams = 60;
        this.nCups = 100;
        this.hasElevator = false;
        System.out.println("You have built a cafe: ☕");
    }
    /**
     * Initializes our Cafe 
     */

    public Cafe(String name,String address){
    super(name, address);
    this.nFloors = 1;

    }
    

  /**
    * Sells a cup of coffee and updates the inventory.
    *
    * @param size               The size of the coffee in ounces.
    * @param nSugarPacketsTaken The number of sugar packets used.
    * @param nCreamsUsed        The number of cream splashes used.
    */
    public void sellCoffee(int size, int nSugarPacketsTaken, int nCreamsUsed){
        if (nCups>0 && nCoffeeOunces >= size && nSugarPackets>=nSugarPacketsTaken && nCreams>=nCreamsUsed){

            nCoffeeOunces -= size;
            nSugarPackets -= nSugarPacketsTaken;
            nCreams -= nCreamsUsed;
            nCups -= 1;

            System.out.println("You have sold " +size +" coffee.");
            System.out.println("Compass Cafe currently has " + nCups + " cups "+ nCoffeeOunces + " coffee ounces "+ nSugarPackets + " sugar packets "+nCreams +" creams remaining. " );
        }
        else{
            System.out.println("Sorry we're currently too understocked to make your order.");
            this.restock(nCoffeeOunces,nSugarPackets,nCreams,nCups);
        }
    }

    /**
    * Sells a default  cup of coffee and updates the inventory.
    *
    * @param size The size of the coffee in ounces.

    */
    public void sellCoffee(int size){
        if(nCups>0 && nCoffeeOunces >= size){
            nCoffeeOunces -= size;
            nCups -=1;

            System.out.println("You've currently sold one general"+ size +"coffee");
        }
    }
      /**
    * Sells a cup of coffee and updates the inventory.
    *
    * @param size               The size of the coffee in ounces.
    * @param nCreamsUsed        The number of creams used.
    */
    public void sellCoffee(int size, int nCreamsUsed){
        if(nCups>0 && nCoffeeOunces >= size && nCreams>=nCreamsUsed){
            nCoffeeOunces -= size;
            nCups -=1;
            nCreams -=nCreamsUsed;

            System.out.println("You've currently sold a"+ size +" latte.");

        }

    }


   /**
    * Restocks the cafe's inventory.
    *
    * @param nCoffeeOunces The current number of coffee ounces.
    * @param nSugarPackets The current number of sugar packets.
    * @param nCreams       The current number of cream splashes.
    * @param nCups         The current number of cups.
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (nCups ==0 || nCoffeeOunces==0 || nSugarPackets ==0 || nCreams ==0 ){

            nCups +=400;
            nCoffeeOunces +=300;
            nSugarPackets +=250;
            nCreams +=100; // I hard coded these to specific amounts but should i be doing it differently because if i do ncups +=ncups then it just automatically doubles it....should i do that instead

            System.out.println("We currently have" + nCups + "cups"+ nCoffeeOunces + "coffee ounces"+ nSugarPackets + "sugar packets"+nCreams +"creams" );
            
        }

    }

  
    /**
     * Displays the available options for interacting with the library like entering, exiting, going up , managing the book collection, and checking book availability.
     */
    @Override
    public void showOptions(){
        System.out.println("Available options at " + this.name + "cafe" +  ":\n + enter() \n + exit() \n + goUp() \n + restock()\n + sellCoffee()\n ");
    }

    /**
     * Tells the student that they aren't allowed to move beyond the first floor.
     * 
     * @param floorNum The floor of a building
     */
    @Override
    public void goToFloor(int floorNum){

    System.out.println("You are not permitted to move to any other floors in " + this.name + "cafe .");





}

    /**
     * Main method for testing the Cafe class.
     *
     * @param args
     */

    public static void main(String[] args) {
        Cafe Compass = new Cafe( "Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 4 );

        Compass.sellCoffee(12, 2, 1);

        Compass.sellCoffee(100000, 40000, 99999);

        Compass.sellCoffee(12, 2, 1);
    }



    






    




    
}
