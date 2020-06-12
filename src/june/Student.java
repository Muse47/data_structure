package june;

/**
 * @auther Muse47
 * 创建时间： 2019/6/11 17:07
 * 描述：
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> stu = new Array<>();
        stu.addLast(new Student("Alice",100));
        stu.addLast(new Student("Bob",66));
        stu.addLast(new Student("Charlie",88));
        System.out.println(stu);
    }
}