import java.io.File;
import java.util.Scanner;

public class MountainTrekking {
        public static void printArray(int[] a) {
            for(int n : a)
                System.out.print(n + " ");
            System.out.println();
        }
        public static long getGain(int from, int to, int [] points) {
            long gain = 0;
            if (from < to) {
                for (int i = from; i < to; i = i + 1) {
                    if (points[i] < points[i + 1]) {
                        gain += points[i + 1] - points[i];
                    }
                }
            } else {
                for (int i = from; i > to; i = i - 1) {
                    if (points[i] < points[i - 1]) {
                        gain += points[i - 1] - points[i];
                    }
                }
            }
            return gain;
        }

        public static void main(String[] args) throws Exception {
            File f = new File("SampleInputP4.txt");
            Scanner scanner = new Scanner(f);
            String line = null;
            line = scanner.nextLine();
            int numPoints = Integer.parseInt(line);
            line = scanner.nextLine();
            int numWayPoints = Integer.parseInt(line);

            int[] points = new int[numPoints];
            int[] wayPoints = new int[numWayPoints];

            for (int i = 0; i < numPoints; i++) {
                line = scanner.nextLine();
                points[i] = Integer.parseInt(line);
            }
            for (int i = 0; i < numWayPoints; i++) {
                line = scanner.nextLine();
                wayPoints[i] = Integer.parseInt(line);
            }
            printArray(points);
            printArray(wayPoints);
            // process
            long gain = 0;
            for (int i = 0; i < numWayPoints-1; i++) {
                gain += getGain(wayPoints[i], wayPoints[i+1], points);
            }
            System.out.println(gain);
        }
    }

