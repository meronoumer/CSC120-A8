/* This is a stub for the House class */

import java.util.ArrayList;

/**
 * Represents a House building containing residents and a dining room.
 */
public class House extends Building {

  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private Student oneCardNumber;



  /**
  * Constructs a new House object.
  *
  * @param name          The name of the house.
  * @param address       The address of the house.
  * @param nFloors       The number of floors in the house.
  * @param hasDiningRoom Whether the house has a dining room.
  */
  public House(String name, String address, int nFloors,boolean hasDiningRoom){
    super(name, address, nFloors);
    this.residents = new ArrayList<> ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

    System.out.println("You have built a house: 🏠");
  }
 /**
  * Returns whether the house has a dining room.
  *
  * @return true if the house has a dining room, false otherwise.
  */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
  * Returns the number of residents in the house.
  *
  * @return The number of residents.
  */

  public int nResidents(){
    int numResidents = 0;
    for (int i = 0; i<residents.size();i++)
    {
      numResidents++;
    }
    return numResidents;
  }

  /**
  * Adds a student to the list of residents in the house.
  *
  * @param s The student to move in.
  */

  public void moveIn(Student s){
   
      this.residents.add(s);
    }

  /**
  * Adds a student to the list of residents in the house identifying by their oneCard number.
  *
  * @param oneCardNumber The oneCard ID number of the student to move in.
  */
    public void moveIn(int oneCardNumber){
   
      this.residents.add(this.oneCardNumber);
    }
  /**
  * Adds a group of students to the list of residents in the house 
  *
  * @param oneCardNumber The oneCard ID number of the student to move in.
  */
    public void moveIn(ArrayList<Student> students){
      for (Student student : students) 
      { 
        this.residents.add(student);
    }
}
   
  /**
   * Removes a student from the list of residents in the house.
   *
   * @param s The student to move out.
   * @return The student who moved out.
   * @throws RuntimeException if the student is not found in the house.
   */

   
public Student moveOut(Student s){
  if(!isResident(s))
  {
    throw new RuntimeException("Student not found");
  }
  else{
    this.residents.remove(s);
    return s;
  }
  
}
/**
 * Removes a student from the list of residents in the house identifying them by their ID or OneCard number.
 *
 * @param oneCardNumber The onecard number (ID) of the student to move out.
 * @return The student who moved out.
 * @throws RuntimeException if the student is not found in the house.
 */

public void moveOut(int oneCardNumber){
  this.residents.add(this.oneCardNumber);

}

/**
 * Removes a group of students from the list of residents in the house.
 *
 * @param students The students to move out.
 * @return The student who moved out.
 * @throws RuntimeException if the student is not found in the house.
 */
public void moveOut(ArrayList<Student> students){
  for(Student student : students)
  {
    this.residents.add(student);
  }
}


/**
 * Checks if a student is a resident of the house.
 *
 * @param s The student to check.
 * @return true if the student is a resident, false otherwise.
 */
public boolean isResident(Student s){
  if (residents.contains(s))
  {
    return true;
  }
  else{
    return false;

  }

}
/**
 * Displays the available options for interacting with a house like moving in, moving out, going up, has a dining room, and if someone is a resident.
 */
@Override
public void showOptions(){
  System.out.println("Available options for "+this.name+ " house : moveIn(),moveOut(), goUp(),hasDiningRoom(),isResident()");

}

/**
 * Navigates to a specific floor in a House.
 * Checks if the desired  floor is valid first and handles movement between floors, potentially using the elevator if available
 * throws a RuntimeException if the user is not inside the building or if the floor number is invalid.
 *
 * @param floorNum The number of the floor to go to.
 * @throws RuntimeException If the user is not inside the building
 * or if the requested floor number is invalid.
 */


 @Override
 public void goToFloor(int floorNum) {
     if (!this.hasElevator && (floorNum > this.activeFloor + 1 || floorNum < this.activeFloor - 1)) 
     {
         throw new RuntimeException("This house does not have an elevator. You can only move to adjacent floors.");
     }
     super.goToFloor(floorNum);
 }



 /**
  * Main method 
  *
  * @param args 
  */
  public static void main(String[] args) {
    House Washburn  = new House("Washburn House","4 Seelye Dr, Northampton, MA 01063",3,false);
    House Chase  = new House("Chase House","45 Elm Street, Northampton, MA 01063",3,false);

    Student student1 = new Student("Radiah", "9901",1);
    Student student2 = new Student("Nahian", "9902",1);
    Student student3 = new Student("Lola", "9903", 1);
    Washburn.moveIn(student1);
    Washburn.moveIn(student2);
    Washburn.moveIn(student3);
    System.out.println("Washburn Residents: "+ Washburn.residents);




    Washburn.moveOut(student1);

    Chase.moveIn(student1);


    System.out.println("Number of Residents currently in Washburn  " + Washburn.nResidents());
    System.out.println("Number of Residents currently in Chase  " + Chase.nResidents());

    System.out.println("Is Nahian a current Washburn Resident? " + Washburn.isResident(student2));
    System.out.println("Is Radiah a current Washburn Resident? " + Washburn.isResident(student1));
    //Washburn.moveOut(student1);







  }

}