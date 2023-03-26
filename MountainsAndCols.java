import java.io.File;
import java.util.*;

public class MountainsAndCols {
    public static void printArray(int[] a) {
        for(int item : a)
            System.out.print(item + " ");
        System.out.println();
    }
    public static int getLeftProm(int index, int [] points) {
        int col = index;
        for (int i = index-1; i >=0 ; i--) {
            if (points[i] < points[col]) col = i;
            if (points[i] > points[index]) return points[index] - points[col];
        }
        return points[index];
    }

    public static int getRightProm(int index, int [] points) {
        int col = index;
        for (int i = index+1; i < points.length; i++) {
            if (points[i] < points[col]) col = i;
            if (points[i] > points[index]) return points[index] - points[col];
        }
        return points[index];
    }

    public static int getProm(int index, int [] points) {
        return Math.min(getLeftProm(index, points), getRightProm(index, points));
    }

    public static List<Integer> getPeaks(int [] points) {
        List<Integer> peaks = new ArrayList<>();
        if (points.length == 0) return peaks;
        if (points.length == 1) {
            peaks.add(0);
            return peaks;
        }
        if (points[1] < points[0]) {
            peaks.add(0);
        }
        if (points[points.length-1] > points[points.length-2]) {
            peaks.add(points.length - 1);
        }
        for (int i=1; i < points.length-1; i++) {
            if (points[i] > points[i-1] && points[i] > points[i+1]) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static void main(String[] args) throws Exception {
        File f = new File("SampleInputP6.txt");
        Scanner scanner = new Scanner(f);
        String line = null;
        line = scanner.nextLine();
        int pSize = Integer.parseInt(line);
        line = scanner.nextLine();
        int rSize = Integer.parseInt(line);

        int[] points = new int[pSize];
        int[] ranks = new int[rSize];
        int[] prom = new int[pSize];

        for (int i = 0; i < pSize; i++) {
            line = scanner.nextLine();
            points[i] = Integer.parseInt(line);
        }
        for (int i = 0; i < rSize; i++) {
            line = scanner.nextLine();
            ranks[i] = Integer.parseInt(line);
        }

        // get prominences
        for (int i = 0; i < points.length; i++) {
            prom[i] = getProm(i, points);
        }

        //printArray(prom);  // debug

        List<Integer> peaks = getPeaks(points);
        //System.out.println("Before sorting: " + peaks);  // debug
        Collections.sort(peaks, (a,b)-> {  // uses functional comparator
            if (prom[a] > prom[b])  return -1;
            else return 1;
        });  // high to low
        //System.out.println("After sorting: " + peaks);  // debug



        // print results
        for (int i = 0; i < ranks.length; i++) {
            //System.out.println("rank[" + i + "] = " + ranks[i]); // debug
            int pIndex = ranks[i] -1;
            if (pIndex >= peaks.size()) {
                System.out.println("0 0");
            } else {
                System.out.println(peaks.get(pIndex) + " " + prom[peaks.get(pIndex)]);
            }
        }
    }
}
