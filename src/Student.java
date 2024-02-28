import java.util.*;

public class Student {
    public String FIO;
    public String groupNumber;
    public int[] grade;

    public boolean isStudentHaveOnlyMoreThanThree = true;

    public double averageScore;

    Student(String FIO, String groupNumber, int[] grade){
        this.FIO = FIO;
        this.groupNumber = groupNumber;
        this.grade = grade;

        calculateAverageScore(this.grade);
    }

    private void calculateAverageScore(int[] grade){
        for(int score : grade){
            averageScore += score;
            if(score <= 3)
                isStudentHaveOnlyMoreThanThree = false;
        }
        averageScore /= 5;
    }
}

class Main{
    public static void main(String[] args) {
        Student[] students = {
                new Student("Иванов И.И.", "22ИТ17", new int[]{5, 4, 5, 5, 4}),
                new Student("Петров П.П.", "23МТ17", new int[]{4, 4, 4, 5, 4}),
                new Student("Стелькин С.С.", "21ФИ18", new int[]{3, 4, 5, 2, 4}),
                new Student("Жидков О.В.", "25БИ16", new int[]{5, 5, 4, 5, 5}),
                new Student("Небесин А.П.", "24ХТ19", new int[]{3, 2, 3, 4, 2}),
                new Student("Лакрицын Е.А.", "22ИТ17", new int[]{4, 5, 4, 5, 5}),
                new Student("Новиков Д.В.", "23МТ17", new int[]{2, 3, 2, 4, 3}),
                new Student("Кузнецова Н.С.", "21ФИ18", new int[]{5, 5, 5, 5, 5}),
                new Student("Морозов П.Н.", "25БИ16", new int[]{4, 3, 4, 5, 3}),
                new Student("Волкова М.И.", "24ХТ19", new int[]{3, 4, 3, 2, 3})

        };

        sortStudentsByAverageScore(students);
        printStudents(students);

        printStudentsOnlyHaveMoreThanThree(students);
    }

    public static void printStudents(Student[] students){
        System.out.println("Ср. балл  |  ФИО  |  Группа");
        for(int i = 0; i < students.length; i++){
            System.out.printf("%f | %s | %s\n",
                    students[i].averageScore, students[i].FIO, students[i].groupNumber);
        }

        System.out.println();
    }

    public static void sortStudentsByAverageScore(Student[] students){
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;

            for(int i = 1; i < students.length; i++){
                if(students[i].averageScore < students[i - 1].averageScore){
                    isSorted = false;

                    Student temp = students[i];
                    students[i] = students[i - 1];
                    students[i - 1] = temp;
                }
            }
        }
    }

    public static void printStudentsOnlyHaveMoreThanThree(Student[] students){
        System.out.println("  Студенты только с 4 или 5");
        System.out.println("Ср. балл  |  ФИО  |  Группа");
        for(int i = 0; i < students.length; i++){
            if(students[i].isStudentHaveOnlyMoreThanThree)
                System.out.printf("%f | %s | %s\n",
                        students[i].averageScore, students[i].FIO, students[i].groupNumber);
        }

        System.out.println();
    }
}
