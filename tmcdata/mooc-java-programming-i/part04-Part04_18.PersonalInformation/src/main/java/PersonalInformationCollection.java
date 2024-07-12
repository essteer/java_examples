
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("First name:");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) {
                break;
            }
            System.out.println("Last name:");
            String lastName = scanner.nextLine();

            System.out.println("Identification number:");
            String identificationNumber = scanner.nextLine();

            PersonalInformation newEntry = new PersonalInformation(firstName, lastName, identificationNumber);
            infoCollection.add(newEntry);
        }

        for (PersonalInformation info : infoCollection) {
            System.out.println(info.getFirstName() + " " + info.getLastName());
        }

    }
}
