package Lab3;

public class VaccinationSuccessful extends Vaccine {
    public VaccinationSuccessful(int age, String nationality) {
        super(age, nationality);
    }

    @Override
    public void boosterDose() {
        if (firstDoseTaken) {
            System.out.println("Booster dose taken successfully.");
        } else {
            System.out.println("Booster dose not allowed without first dose.");
        }
    }
}
