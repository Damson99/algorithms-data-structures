package computingsystems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BinaryIndexTree {

    public static void main(String[] args) {
        int[] input = new int[110000];
        IntStream.rangeClosed(1, 100000).forEach(i -> input[i] = i - 49000);
        long start = System.currentTimeMillis();
        processArray(input);
        double elapsedSeconds = (System.currentTimeMillis() - start) / 1000.0;
        System.out.printf("Execution time: %.3f s%n", elapsedSeconds);

    }

    static class BinaryIndexedTree {
        private final int[] tree;

        BinaryIndexedTree(int size) {
            tree = new int[size + 1];
        }

        int sum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= bitOffset(index);
            }
            return sum;
        }

        void update(int index, DELTA delta) {
            while (index < tree.length) {
                tree[index] += delta.direction;
                index += bitOffset(index);
            }
        }

        private int bitOffset(int index) {
            return index & -index;
        }

        int find(int target) {
            int position = 0;
            int bitMask = 1;
            while ((bitMask << 1) < tree.length) {
                bitMask <<= 1;
            }

            while (bitMask > 0) {
                int nextPos = position + bitMask;
                if (nextPos < tree.length && tree[nextPos] < target) {
                    position = nextPos;
                    target -= tree[position];
                }
                bitMask >>= 1;
            }
            return position + 1;
        }
    }

    enum DELTA {
        UP(1),
        DOWN(-1);
        private final int direction;
        DELTA(int direction) {
            this.direction = direction;
        }
    }

    public static List<Integer> processArray(int[] input) {
        List<Integer> negativesResult = new ArrayList<>(input.length);
        BinaryIndexedTree bit = new BinaryIndexedTree(input.length);
        int negativesCount = 0;

        for (int value : input) {
            if (value < 0) {
                negativesResult.add(value);
                negativesCount++;
                bit.update(negativesCount, DELTA.UP);
            } else if (value > 0) {
                int activeCount = bit.sum(negativesCount);
                if (value <= activeCount) {
                    int idxToRemove = bit.find(value);
                    bit.update(idxToRemove, DELTA.DOWN);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= negativesCount; i++) {
            int countI = bit.sum(i) - bit.sum(i - 1);
            if (countI == 1) {
                result.add(negativesResult.get(i - 1));
            }
        }
        return result;
    }
}
