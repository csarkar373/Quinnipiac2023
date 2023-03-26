import java.io.File;
import java.util.*;

public class FrequencySorter {
    private static class Item implements Comparable<Item> {
        Integer key;
        Integer frequency;
        public Item(Integer value, Integer frequency) {
            this.key = value;
            this.frequency = frequency;
        }

        @Override public String toString() {
            return key + ":" + frequency;
        }

        @Override
        public int compareTo(Item o) {
            if (this.frequency < o.frequency) return 1;
            if (this.frequency > o.frequency) return -1;
            if (this.key < o.key) return -1;
            if (this.key > o.key) return 1;
            return 0;
        }
    }
    public static void main(String[] args) throws Exception {
        File f = new File("SampleInputP1.txt");
        Scanner scanner = new Scanner(f);
        String line = scanner.nextLine();
        int size = Integer.parseInt(line);
        int[] data = new int[size];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            line = scanner.nextLine();
            int item = Integer.parseInt(line);
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        List<Item> list = new ArrayList<>();
        for (Integer key : map.keySet() ) {
            list.add(new Item(key, map.get(key)));
        }
        //System.out.println(list); // debug
        Collections.sort(list);
        //System.out.println(list); // debug
        for (Item item : list) System.out.println(item.key);
    }
}
