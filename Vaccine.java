package Lab3;

public abstract class Vaccine 
{
	int age;
    String nationality;
    boolean firstDoseTaken = false;

    public Vaccine(int age, String nationality) {
        this.age = age;
        this.nationality = nationality;
    }

    public void firstDose() {
        if (nationality.equalsIgnoreCase("Indian") && age >= 18) {
            System.out.println("First dose taken successfully.");
            System.out.println("Now you have to pay ₹250.");
            System.out.println("Payment successful.");
            firstDoseTaken = true;
        } else {
            System.out.println("Not eligible for first dose.");
        }
    }

    public void secondDose() {
        if (firstDoseTaken) {
            System.out.println("Second dose taken successfully.");
        } else {
            System.out.println("You must take the first dose before the second dose.");
        }
    }

    public abstract void boosterDose();


}
