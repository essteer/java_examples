import java.util.ArrayList;

public class Student {

    private ArrayList<Integer> allPoints;
    private ArrayList<Integer> passingPoints;

    public Student() {
        this.allPoints = new ArrayList<>();
        this.passingPoints = new ArrayList<>();
    }

    public void addPoints(int points) {
        if (points >= 0 && points <= 100) {
            this.allPoints.add(points);
            if (points >= 50) {
                this.passingPoints.add(points);
            }
        }
    }

    public double averageAll() {
        if (this.allPoints.size() > 0) {
            int totalPoints = 0;
            for (int i=0; i < this.allPoints.size(); i++) {
                totalPoints += this.allPoints.get(i);
            }
            return (double) totalPoints / this.allPoints.size();
        }
        return 0.0;
    }

    public double averagePassing() {
        if (this.passingPoints.size() > 0) {
            int totalPoints = 0;
            for (int i=0; i < this.passingPoints.size(); i++) {
                totalPoints += this.passingPoints.get(i);
            }
            return (double) totalPoints / this.passingPoints.size();
        }
        return 0.0;
    }

    public double percentPassing() {
        return 100 * ((double) this.passingPoints.size() / this.allPoints.size());
    }

    public String[] gradeDistribution() {
        String[] grades = {"", "", "", "", "", ""};
        int[] gradeLower = {0, 50, 60, 70, 80, 90};
        int[] gradeUpper = {50, 60, 70, 80, 90, 101};
        int gradeIndex = grades.length - 1;

        while (gradeIndex >= 0) {
            for (int points : allPoints) {
                if (points >= gradeLower[gradeIndex] && points < gradeUpper[gradeIndex]) {
                    grades[gradeIndex] += "*";
                }
            }
            gradeIndex -= 1;
        }
        return grades;
    }

}
