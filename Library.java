/* This is a stub for the Library class */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collection;

/**
 * Represents a Library building with a collection of books.
 */
public class Library extends Building {


  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;


   /**
    * Constructs a new Library object.
    *
    * @param name    The name of the library.
    * @param address The address of the library.
    * @param nFloor The number of floors in the library.
    */
    public Library(String name, String address, int nFloor ) {
      super(name, address, nFloor);

      this.hasElevator = true; 
      this.collection = new Hashtable<String, Boolean>() ;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a title to the library's collection.
     *
     * @param title The title of the book to add.
     * @throws RuntimeException if the book is already in the library.
     */

    public void addTitle(String title){
      if (this.collection.containsKey(title)){
        throw new RuntimeException("This book is already in the library");
      }
      else {
        this.collection.put(title,true);
      }
    }
    /**
     * Adds a collection of book titles to the library. If a book is already present, a message is printed to the console, and the process continues with the next title.
     * 
     * @param Books The group of books to add
     * catches Exception if the book in the arraylist of books we're trying to add is already in the library
     */
    public void addTitle(ArrayList<String> books){
      for(String title:books){
        try {
            addTitle(title);
        } catch ( Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Moving on to add the next title");

        }
      }


    }






    /**
     * Removes a title from the library's collection.
     *
     * @param title The title of the book to remove.
     * @return The title of the removed book.
     * @throws RuntimeException if the book is not found in the library.
     */
    public String removeTitle(String title){
      if(!this.collection.containsKey(title)){
        throw new RuntimeException("This book isn't found in this library.");

      }
      else{
        this.collection.remove(title);
        return title;
      }
    }


    /**
     * Checks out a book from the library.
     *
     * @param title The title of the book to check out.
     * @throws RuntimeException if the book is not found in the library.
     */
    public void checkOut(String title){
      if(this.collection.containsKey(title)){

        collection.replace(title, true, false);
        System.out.println("The book " + title + " has been checked out");}
      else{ throw new RuntimeException("This book isn't found in this library.");

      }
    }

    /**
     * Checks out a group of books from the library.
     *
     * @param Book The collection of booksto check out.
     */

    public void checkOut(ArrayList<String> Books) {
      for (String title : Books) {
          if (collection.containsKey(title)) {
              if (collection.get(title)) { // 
                  collection.replace(title, true, false);
                  System.out.println( title + " has been checked out.");
              } else {
                  System.out.println(title +  "is already checked out.");
              }
          } else {
              System.out.println( title + " isn't found in this library.");
          }
      }
  }

    /**
     * Returns a book to the library.
     *
     * @param title The title of the book to return.
     * @throws RuntimeException if the book is not found in the library.
     */
    public void returnBook(String title){
      this.collection.put(title,true);

    }


    /**
     * Checks if the library contains a title.
     *
     * @param title The title to check for.
     * @return true if the title is in the collection, false otherwise.
     */
    public boolean containsTitle(String title){
      if(this.collection.containsKey(title)){
        return true;  
      }
      else{
        return false;
      }
    }

   /**
    * Checks if a title is available for checkout.
    *
    * @param title The title to check.
    * @return true if the book is available, false otherwise.
    * @throws RuntimeException if the book is not found in the library.
    */
    public boolean isAvailable(String title){
      if (this.collection.get(title)==true){
        return true;

      }
      else{
        return false;
      }

    } 
   /**
    * Prints the collection of books in the library.
    */
    public void printCollection(){
      if (!this.collection.isEmpty()){
        System.out.println("     ~~~~~~~~~~~~~~~~~~~~      ");
        System.out.println("Collection Titles");
        System.out.println("     ~~~~~~~~~~~~~~~~~~~~      ");


        for (String key : this.collection.keySet()){
          System.out.println("Title :  " + key + " Check in Status:  " + this.collection.get(key));
        }}
        else{
        System.out.println("This collection is empty.") ;
    }
      
    }
    /**
     * Displays the available options for interacting with the library like entering, exiting, navigating floors, managing the book collection, and checking book availability.
     */
    @Override
    public void showOptions(){
      System.out.println("Available options at  " + this.name + "library"+ ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + addTitle()\n + removeTitle()\n +  checkOut()\n + returnBook()\n + containsTitle() \n + isAvailable() \n + printCollection()");
}



  /**
   * Navigates to a specific floor within the library.
   * Checks if the requested floor is valid and handles movement between floors, potentially using the elevator if available
   * (though the current implementation always uses the superclass's logic for non-adjacent floors). It throws a RuntimeException if the user
   * is not inside the building or if the floor number is invalid.
   *
   * @param floorNum The number of the floor to go to.
   * @throws RuntimeException If the user is not inside the building or if the requested floor number is invalid.
   */
  @Override
  public void goToFloor(int floorNum){

    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
  }
  if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
  }
  if(floorNum != this.activeFloor +1){
    super.goToFloor(floorNum);
  }
  System.out.println("You are now on floor #" + floorNum + " of " + this.name);
  this.activeFloor = floorNum;




  }




  /**
    * Main method for testing the Library class.
    *
    * @param args 
    */
  
    public static void main(String[] args) {
      Library Neilson = new Library("Neilson Library", "10 Neilson Drive", 4);

      Neilson.addTitle("Fiker Eske Mekabir");
      
      Neilson.addTitle("The Brothers Karamazov"); //and now that's causing errors here help me
      Neilson.addTitle("Letters to Milena");

      Neilson.printCollection();

      System.out.println("Does Neilson Library have The Brothers Karamazov?  " + Neilson.containsTitle("The Brothers Karamazov"));
      System.out.println("Does Neilson Library have The Bell Jar ?  " + Neilson.containsTitle("The Bell Jar "));

      System.out.println("Is Letters to Milena currently availiable?  "+ Neilson.isAvailable("Letters to Milena") );

      Neilson.checkOut("Letters to Milena");

      System.out.println("Is Letters to Milena currently availiable?  "+ Neilson.isAvailable("Letters to Milena") );

      Neilson.returnBook("Letters to Milena");

      System.out.println("Is Letters to Milena currently availiable?  "+ Neilson.isAvailable("Letters to Milena") );

      Neilson.removeTitle("Fiker Eske Mekabir");

      Neilson.printCollection();


      //testing out just the exceptions
      //Neilson.addTitle("The Brothers Karamazov");

      //Neilson.removeTitle("Pedagogy of the Opressed");
      Neilson.checkOut("Pedagogy of the Opressed");











    }
  
  }