import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			ArrayList<String> subjects = new ArrayList<>();
			subjects.add("Math");
			subjects.add("Science");
			subjects.add("Mapeh");

			ArrayList<String> history = new ArrayList<>();

			while (true) {
				double total = 0;
				System.out.print("\nEnter Student Name:");
				String name = sc.nextLine();
				if (name.isEmpty() || !name.matches("[a-zA-Z,. ]+")) {
					System.out.println("Error: Name must not be empty and letters only!");
					continue;
				}
				for (int i = 0; i < subjects.size(); i++) {
					System.out.print("Enter Grade in " + subjects.get(i) + ": ");
					while (!sc.hasNextDouble()) {
						System.out.print("Enter Numerical or numbers only Please Try again!:");
						sc.nextLine();
					}
					double grade = sc.nextDouble();
					sc.nextLine();
					total += grade;
				}
				double average = total / subjects.size();
				double roundUp = Math.round(average);
				String remark = (average >= 75) ? "Passed" : "Failed";
				String honor = "";
				if (average >= 96) {
					honor = "With Highest Honor";
				} else if (average >= 94) {
					honor = "With High Honor";
				} else if (average >= 90) {
					honor = "Honor";
				} else {
					honor = "No Honor";
				}

				System.out.println("\n-----------------------");
				System.out.println("Student Name: " + name);
				System.out.println("Average Grade: " + String.format("%.2f", average));
				System.out.println("Total Average: " + total);
				System.out.println("Final Grade: " + String.format("%.0f", roundUp));
				System.out.println("Status: " + honor);
				System.out.println("Remark: " + remark);
				System.out.println("------------------------");

				String record = String.format("%-15s | Avg: %.2f | %s", name, average, honor);
				history.add(record);

				System.out.print("\n[1] Add Another | [2] View History | [3] Exit: ");
				String choice = sc.nextLine();

				if (choice.equals("2")) {
					System.out.println("\n--------------HISTORY -----------------");
					for (String h : history) {
						System.out.println(h);
					}
					System.out.println("========================");
					System.out.print("\nPress Enter to continue...");
					sc.nextLine();
				} else if (choice.equals("3")) {
					System.out.println("Goodbye!");
					break;
				}

			}
		}
	}
}