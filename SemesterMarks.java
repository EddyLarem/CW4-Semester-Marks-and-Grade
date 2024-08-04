import java.util.Scanner;
public class SemesterMarks {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int subjects = 5;
		double marks[] = new double[subjects];
		char grade[] = new char[subjects];
		
		for (int i = 0; i < subjects; i++) {
		System.out.print("Enter marks for subject " + (i+1) + " : ");
		marks[i] = scanner.nextDouble();

			while (marks[i] < 0 || marks[i] > 100) {
			System.out.print("%nInvalid input.%nEnter value between 0 and 100: ");
			marks[i] = scanner.nextDouble();
			} 

		grade[i] = awardGrade(marks[i]);

		}
		
		System.out.print("Do you have more subject marks to enter? ");
		String reply = scanner.next().toUpperCase();

		if (reply.equals("YES")) {
			System.out.print("How many more subject marks do you have to enter? ");
			int more = scanner.nextInt();
			double moreMarks[] = new double[more];
			char moreGrades[] = new char[more];

			for (int i = 0; i < more; i++) {
				System.out.print("Enter marks for subject " + (i + 1 + subjects) + " : ");

				moreMarks[i] = scanner.nextDouble();

				while (moreMarks[i] < 0 || moreMarks[i] > 100) {
				System.out.print("%nInvalid input.%nEnter value between 0 and 100: ");
				marks[i] = scanner.nextDouble();
				}
			moreGrades[i] = awardGrade(moreMarks[i]);
			
                        }
				
			System.out.println("Your grades are as follows: ");
                        System.out.println("+---------+----------+--------+");
			System.out.printf("%-10s|%-10s|%-10s%n", "Subject", "Marks", "Grades");
                        System.out.println("+---------+----------+--------+");
			for(int j = 0; j < (more + subjects); j++) {
                            char finalGrades[] = combineArrays(grade, moreGrades);
                            double finalMarks[] = combineArrays(marks, moreMarks);
			
			System.out.printf("%-10s%-10.2f%-10c%n", "Subject " + (j + 1), finalMarks[j], finalGrades[j]);
				
                        }
                        
                        double finalMarks[] = combineArrays(marks, moreMarks);
                        double averageMarks = averageCalculator(finalMarks);
			System.out.printf("Your average marks are %.2f", averageMarks);

		} else if(reply.equals("NO")) {
                                                        
                            double averageMarks = averageCalculator(marks);
                            
                            System.out.println("Your grades are as follows: ");
                            System.out.println("+---------+----------+--------+");
                            System.out.printf("%-10s|%-10s|%-10s%n", "Subject", "Marks", "Grades");
                            System.out.println("+---------+----------+--------+");
                            
                            for(int i = 0; i <  subjects; i++) {
                                System.out.printf("%-10s|%-10.2f|%-10c%n", "Subject " + (i + 1), marks[i], grade[i]);
                            }
                            System.out.printf("Your average marks are %.2f", averageMarks);
                            
                        } else {
                            System.out.println("Invalid input.%nPlease enter 'YES' or 'NO': ");
                            reply = scanner.next().toUpperCase();
                            
                        }
		scanner.close();
		}

	public static char awardGrade(double a) {
		if (a >= 90) {
			return 'A';
		} else if (a >= 80) {
			return 'B';
		} else if (a >= 70) {
			return 'C';
		} else if (a >= 60) {
			return 'D';
		} else if (a >= 50) {
			return 'E';
		} else {
			return 'F';
		}
	
	}

	public static double[] combineArrays(double[] array1, double[] array2) {
		int length1 = array1.length;
		int length2 = array2.length;

		double[] combined = new double[length1 + length2];
		

		System.arraycopy(array1, 0, combined, 0, length1);
		System.arraycopy(array2, 0, combined, length1, length2);
		return combined;
	}

	public static char[] combineArrays(char[] array1, char[] array2) {
		int length1 = array1.length;
		int length2 = array2.length;

		char[] combined = new char[length1 + length2];
		

		System.arraycopy(array1, 0, combined, 0, length1);
		System.arraycopy(array2, 0, combined, length1, length2);
		return combined;
	}

	public static double averageCalculator(double[] array1) {
		double sum = 0;

		for(double value : array1) {
			sum += value;
		}
	
		double average = sum / array1.length;
		return average;
	}	
}