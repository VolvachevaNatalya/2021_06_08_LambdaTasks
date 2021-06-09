package project;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "scala", "java", "clojure", "clojure");
        System.out.println(task1(list));
        System.out.println(task2("sometext"));
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    //task 1
    private static List<String> task1(List<String> list) {
        UnaryOperator<List<String>> func = (strings) -> new ArrayList<>(new TreeSet(strings));
        return func.apply(list);
    }

    //task 2 Написать лямбда выражение, которое вернет строку в обратном порядке
    private static String task2(String str) {
        UnaryOperator<String> func = (text) -> new StringBuilder(text).reverse().toString();
        return func.apply(str);
    }

    //task 3
    private static void task3() {
        List<Student> students = Arrays.asList(
                new Student("Masha", 4),
                new Student("Adel", 5),
                new Student("Viktor", 3)
        );
        Comparator<Student> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Student> byGrade = (o1, o2) -> o2.getGrade() - o1.getGrade();

        System.out.println(students);
        students.sort(byName);
        System.out.println(students);
        students.sort(byGrade);
        System.out.println(students);
    }

    //task 4
//    Есть 7 строк. Задача, с помощью лямбды выражения склеить все эти строки и изменить регистр результата toUpperCase.
    private static void task4() {
        List<String> str = Arrays.asList("h", "e", "l", "l", "o", "!", ":)");
        str.forEach(value -> System.out.print(value.toUpperCase()));
    }

    public static void task5() {
        TernaryIntPredicate<Integer> ternaryIntPredicate = ((x, y, z) -> x != y && y != z && z != x);
        System.out.println(ternaryIntPredicate.test(1, 2, 3));
        System.out.println(ternaryIntPredicate.test(2, 2, 3));
    }

    private static void task6() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);
        numbers.forEach((number) -> System.out.print(number * 2 + " "));
    }

    //    Есть список чисел, избавиться от дубликатов в списке с помощью лямбды. И отсортировать в любом порядке.
    private static void task7() {
        List<Integer> numbers = Arrays.asList(5, 3, 7, 3, 4, 5, 9, 5, 5, 6, 1);
        Function<List<Integer>, LinkedHashSet<Integer>> digits = (number) -> new LinkedHashSet<Integer>(number);
        System.out.println(digits.apply(numbers));
        numbers.sort(Comparator.naturalOrder());
        System.out.println(digits.apply(numbers));
        numbers.sort((n1, n2) -> n2 - n1);
        System.out.println(digits.apply(numbers));
    }
}
