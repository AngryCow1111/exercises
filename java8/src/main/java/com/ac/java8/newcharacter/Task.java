package com.ac.java8.newcharacter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Task
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public class Task {
    public Task(Status status, Integer points) {
        this.status = status;
        this.points = points;
    }

    private Status status;
    private Integer points;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String toString() {
        return String.format("[%s,%d]", this.status, this.points);
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );
        int totalPoints = tasks.stream().filter(task ->
                task.status == Status.OPEN
        ).mapToInt(Task::getPoints)
                .sum();
        System.out.println(totalPoints);

//        Integer reduce = tasks.stream()
//                .parallel()
////                .map(task -> task.getPoints())
//                .map(Task::getPoints)
//                .reduce(0, Integer::sum);
//        System.out.println(reduce);
// Calculate total points of all tasks
        Integer reduce = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints()) // or map( Task::getPoints )
                .reduce(0, Integer::sum);

        System.out.println("Total points (all tasks): " + totalPoints);

        Map<Status, List<Task>> collect = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(collect);

        // Calculate the weight of each tasks (as percent of total points)

        final Collection<String> result = tasks

                .stream()                                        // Stream< String >

                .mapToInt(Task::getPoints)                     // IntStream

                .asLongStream()                                  // LongStream

                .mapToDouble(points -> (points + 0.0) / totalPoints)   // DoubleStream

                .boxed()                                         // Stream< Double >

                .mapToLong(weigth -> (long) (weigth * 100)) // LongStream

                .mapToObj(percentage -> percentage + "%")      // Stream< String>

                .collect(Collectors.toList());                 // List< String >


        System.out.println(result);

    }
}

