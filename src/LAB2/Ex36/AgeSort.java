package LAB2.Ex36;

public class AgeSort implements ISort{

    @Override
    public void sort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (students[j].birth > students[j+1].birth) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
    }
}
