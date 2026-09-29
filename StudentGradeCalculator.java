import java.util.*;

class StudentReport {
    Map<String, Integer> subjectMarks = new HashMap<>();
    List<Integer> marksList = new ArrayList<>();
    int total = 0;
    double average;
    String grade;

    void addSubject(String subject, int marks) {
        subjectMarks.put(subject, marks);
        marksList.add(marks);
        total += marks;
    }

    void generateResult() {
        average = (double) total / subjectMarks.size();
        
        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else grade = "F";

        // DSA: Sorting for analysis
        Collections.sort(marksList);
    }

    void display() {
        System.out.println("\n========== STUDENT REPORT ==========");
        for (Map.Entry<String, Integer> entry : subjectMarks.entrySet()) {
            System.out.printf("%-15s : %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("------------------------------------------------");
        System.out.printf("Total Marks   : %d\n", total);
        System.out.printf("Average       : %.2f%%\n", average);
        System.out.printf("Grade         : %s\n", grade);
        System.out.printf("Highest Marks : %d\n", marksList.get(marksList.size() - 1));
        System.out.printf("Lowest Marks  : %d\n", marksList.get(0));
        System.out.println("==================================================");
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentReport report = new StudentReport();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i+1) + " name: ");
            String sub = sc.nextLine();
            System.out.print("Marks for " + sub + " (0-100): ");
            int marks = sc.nextInt();
            sc.nextLine();
            report.addSubject(sub, marks);
        }

        report.generateResult();
        report.display();
        sc.close();
    }
}