package LAB2.Ex36;

public class Student {
    int birth;
    String surname;

    public void Sort(Student[] students, ISort sort){
        sort.sort(students);
    }
}
