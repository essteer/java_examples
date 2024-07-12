public class Student extends Person {

    private int studyCredits;

    public Student(String name, String address) {
        super(name, address);
        this.studyCredits = 0;
    }

    public int credits() {
        return studyCredits;
    }

    public void study() {
        studyCredits += 1;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Study credits " + studyCredits;
    }

}
