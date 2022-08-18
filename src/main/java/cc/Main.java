package cc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public long sync(List<String> listOfFiles) {
        long start = new Date().getTime();
        listOfFiles.forEach(this::totalCountInFile);
        long end = new Date().getTime();
        return end - start;

    }

    public long async(List<String> listOfFiles) {
        long start = new Date().getTime();

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);

        List<CompletableFuture<Integer>> list = new ArrayList<>();

        listOfFiles
                .forEach(x -> {

                            CompletableFuture<Integer> c = CompletableFuture
                                    .supplyAsync(() -> totalCountInFile(x), fixedPool);

                            list.add(c);

                        }
                );

        Integer reduce = list.stream().map(CompletableFuture::join).reduce(0, (x, y) -> x + y);

        long end = new Date().getTime();
        return end - start;
    }

    public int totalCountInFile(String fileName) {
        try {
            //System.out.println(String.format("Reading file: %s by thread [%s]", fileName, Thread.currentThread().getName()));
            Thread.sleep(50);
            //System.out.println(String.format("Reading file: %s completed by thread [%s]", fileName, Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextInt(500);
    }

    public static void main(String[] args) {
        Main main = new Main();

        List<String> listOfFiles = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            listOfFiles.add("fileName_" + i);
        }

        long syncPerformance = main.sync(listOfFiles);
        long asyncPerformance = main.async(listOfFiles);

        System.out.println("syncPerformance: " + syncPerformance / 60);
        System.out.println("asyncPerformance: " + asyncPerformance / 60);
    }
}
