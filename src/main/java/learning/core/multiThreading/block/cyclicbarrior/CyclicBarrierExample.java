package learning.core.multiThreading.block.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Player extends Thread {
    private final CyclicBarrier barrier;
    private final String name;

    public Player(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is ready");
            barrier.await(); // Waits at the barrier until all players are ready
            System.out.println(name + " started playing");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numPlayers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numPlayers);

        for (int i = 1; i <= numPlayers; i++) {
            Player player = new Player(barrier, "Player " + i);
            player.start();
        }
    }
}
