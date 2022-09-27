package com.java8.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Practice {

    private static final List<Student> students = Arrays.asList(new Student(1, "Ramesh", "hyd", "CSE", 101), new Student(2, "Ravi", "hyd", "CSE", 100), new Student(3, "Abhi", "Delhi", "Mech", 70), new Student(4, "Aadhar", "Delhi", "EEE", 50), new Student(5, "Chandra", "Vizag", "EEE", 50));
    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    public static void main(String[] args) {
        Java8Practice java8Practice = new Java8Practice();

        java8Practice.getInitializedList().forEach(System.out::println);
        java8Practice.getInitializedListUsingStream();
        java8Practice.getListUsingRangeAndLimit();
        java8Practice.useIntStream();
        java8Practice.sortNumbersInDecOrder();
        java8Practice.sortNumbersInDecOrderToString();
        java8Practice.sortNumbersInIncOrder();
        java8Practice.useForEach();
        java8Practice.filterNumbers();
        java8Practice.multiplyNumbersUsingMap();
        java8Practice.getInitializedArrayOfObjects();
        java8Practice.getStudentsByPlaceUsingGroupBy();
        System.out.println(java8Practice.getNamesOfStudentsByDeptUsingGroupBy());
        System.out.println(java8Practice.getNamesOfStudentsByDeptInSortedOrder());
        java8Practice.getSumOfMarksOfStudentsByDeptUsingGroupBy();
        java8Practice.getSumOfMarksOfStudents();
        java8Practice.sortStudentsByMarksInIncOrder();
        java8Practice.sortStudentsByMarksInDecOrder();
        java8Practice.getSumOfNumbersUsingReduce();
        java8Practice.getStudentWithMaxMarks();
        System.out.println(java8Practice.groupStudentsByPassedAndFailed());
        System.out.println(java8Practice.getUniqueDeptByStudentsPassedAndFailed());
        java8Practice.getPassedStudentsNames();

    }

    public List<Integer> getInitializedList() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    }

    public List<Integer> getInitializedListUsingStream() {
        return Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
    }

    public List<Integer> getListUsingRangeAndLimit() {
        return IntStream.range(1, 100).limit(56).boxed().collect(Collectors.toList());
    }

    public void useIntStream() {
        IntStream.range(1, 100).forEach(System.out::println);
    }

    public List<Integer> sortNumbersInDecOrder() {
        return numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public String sortNumbersInDecOrderToString() {
        return numbers.stream().sorted(Comparator.reverseOrder()).map(Object::toString).collect(Collectors.joining(","));
    }

    public List<Integer> sortNumbersInIncOrder() {
        return numbers.stream().sorted(Comparator.comparingInt(value -> value)).collect(Collectors.toList());
    }

    public void useForEach() {
        numbers.forEach(val -> System.out.println(" val: " + val));
    }

    public List<Integer> filterNumbers() {
        return numbers.stream().filter(val -> val > 4).collect(Collectors.toList());
    }

    public List<Integer> multiplyNumbersUsingMap() {
        return numbers.stream().map(val -> val * 2).collect(Collectors.toList());
    }

    public List<Student> getInitializedArrayOfObjects() {
        return Arrays.asList(new Student(1, "Ramesh", "hyd", "CSE", 101), new Student(2, "Ravi", "hyd", "CSE", 100), new Student(3, "Abhi", "Delhi", "Mech", 70), new Student(4, "Aadhar", "Delhi", "EEE", 50), new Student(5, "Chandra", "Vizag", "EEE", 50));
    }

    public Map<String, List<Student>> getStudentsByPlaceUsingGroupBy() {
        return students.stream().collect(Collectors.groupingBy(Student::getPlace));
    }

    public Map<String, Integer> getSumOfMarksOfStudentsByDeptUsingGroupBy() {
        return students.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.summingInt(Student::getMarks)));
    }

    public Map<String, Set<String>> getNamesOfStudentsByDeptUsingGroupBy() {
        return students.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.mapping(Student::getName, Collectors.toSet())));

    }

    public Map<String, Set<String>> getNamesOfStudentsByDeptInSortedOrder() {
        return students.
                stream()
                .collect(Collectors.groupingBy(Student::getDept, LinkedHashMap::new, Collectors.mapping(Student::getName, Collectors.toSet())));
    }

    public Integer getSumOfMarksOfStudents() {
        return students.stream().mapToInt(Student::getMarks).sum();
    }

    public List<Student> sortStudentsByMarksInIncOrder() {
        return students.stream().sorted(Comparator.comparingInt(Student::getMarks)).collect(Collectors.toList());
    }

    public List<Student> sortStudentsByMarksInDecOrder() {
        return students.stream().sorted(Comparator.comparing(Student::getMarks, Comparator.reverseOrder())).collect(Collectors.toList());
    }

    public Integer getSumOfNumbersUsingReduce() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public Student getStudentWithMaxMarks() {
        return students.stream().max(Comparator.comparingInt(Student::getMarks)).get();
    }

    public Map<Boolean, List<Student>> groupStudentsByPassedAndFailed() {
        return students.stream().collect(Collectors.partitioningBy(student -> student.getMarks() > 70));
    }

    public Map<Boolean, Set<String>> getUniqueDeptByStudentsPassedAndFailed() {
        return students.stream().collect(Collectors.partitioningBy(student -> student.getMarks() > 70, Collectors.mapping(Student::getDept, Collectors.toSet())));
    }

    public List<Student> getPassedStudentsNames() {
        Map<Boolean, List<Student>> studentsResult = groupStudentsByPassedAndFailed();

        return studentsResult.entrySet().stream().filter(Map.Entry::getKey).map(Map.Entry::getValue).flatMap(Collection::stream).collect(Collectors.toList());
    }

}
