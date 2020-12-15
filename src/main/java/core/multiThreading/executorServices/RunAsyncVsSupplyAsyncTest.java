package core.multiThreading.executorServices;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunAsyncVsSupplyAsyncTest {
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    @Test
    public void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture
            .runAsync(() -> System.out.println("runAsync has no return values"));

        Assert.assertNull(c.get());
    }

    @Test
    public void runAsyncWithCallbacks() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture
            .runAsync(() -> System.out.println("runAsync has no return values"))
            .thenRunAsync(() -> System.out.println("callback"));

        Assert.assertNull(c.get());
    }

    @Test
    public void runAsyncWithExecutor() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture
            .runAsync(() -> System.out.println("Run runAsync with an Executor"), executorService);

        Assert.assertNull(c.get());
    }

    @Test
    public void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture
            .supplyAsync(() -> "supplyAsync has return value");

        Assert.assertEquals("supplyAsync has return value", ((String) c.get()));
    }

    @Test
    public void supplyAsyncWithCallbacks() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture
            .supplyAsync(() -> "supplyAsync")
            .thenApplyAsync((s) -> s + " callback");

        Assert.assertEquals("supplyAsync callback", ((String) c.get()));
    }

    @Test
    public void supplyAsyncWithExecutor() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture
            .supplyAsync(() -> "run supplyAsync with an Executor", executorService);

        Assert.assertEquals("run supplyAsync with an Executor", ((String) c.get()));
    }

    @Test
    public void competitionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> c = CompletableFuture
            .supplyAsync(() -> "run supplyAsync ")
            .thenApplyAsync(o -> o.concat("and then apply async"));

        Assert.assertEquals("run supplyAsync and then apply async", c.get());

        CompletableFuture<String> c1 = CompletableFuture
            .supplyAsync(() -> "run supplyAsync ")
            .thenApply(s -> s.concat("and then apply"));

        Assert.assertEquals("run supplyAsync and then apply", c1.get());
    }

    @Test
    public void competitionAllOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> c = CompletableFuture
            .supplyAsync(() -> "completable future 1");


        CompletableFuture<String> c2 = CompletableFuture
            .supplyAsync(() -> "completable future 2");

        CompletableFuture<String> c3 = CompletableFuture
            .supplyAsync(() -> "completable future 3");


        String collect = Stream.of(c, c2, c3).map(CompletableFuture::join).collect(Collectors.joining(","));

        Assert.assertEquals("completable future 1,completable future 2,completable future 3", collect);
    }
}