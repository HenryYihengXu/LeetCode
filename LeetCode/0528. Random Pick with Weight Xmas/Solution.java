import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    Random rand;
    Scanner scanner;
    ArrayList<String> questions;
    ArrayList<Integer> weights;
    ArrayList<Integer> prefixSum;
    HashSet<String> easy;
    HashSet<String> medium;
    HashSet<String> hard;
    int sum;
    int count;
    int easyCount;
    int mediumCount;
    int hardCount;
    int minEasy;
    int minMedium;
    int minHard;
    String currentSet;

    public Solution() {
        rand = new Random();
        scanner = new Scanner(System.in);
        questions = new ArrayList<>();
        weights = new ArrayList<>();
        prefixSum = new ArrayList<>();
        easy = new HashSet<>();
        medium = new HashSet<>();
        hard = new HashSet<>();
        sum = 0;
        easyCount = 0;
        mediumCount = 0;
        hardCount = 0;
        currentSet = "easy";
        count = 1;
    }

    public void run() {
        while (true) {
            System.out.println("Please input file name");
            String fileName = scanner.nextLine();
            if (fileName.equals("exit")) {
                return;
            }
            if (read(fileName)) {
                System.out.println("Question loaded");
                break;
            }
        }
        while (true) {
            String next = scanner.nextLine();
            if (next.equals("exit")) {
                return;
            }
            System.out.println(count + ". " + getQuestion());
        }
    }

    public boolean read(String fileName) {
        File file = new File(fileName);
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.equals("")) {
                    continue;
                }
                if (line.contains("Easy")) {
                    currentSet = "easy";
                    minEasy = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                if (line.contains("Medium")) {
                    currentSet = "medium";
                    minMedium = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                if (line.contains("Hard")) {
                    currentSet = "hard";
                    minHard = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                String[] pair = line.split(" ");
                String question = pair[0];
                int weight = Integer.parseInt(pair[1]);
                questions.add(question);
                weights.add(weight);
                prefixSum.add(sum);
                sum += weight;
                if (currentSet.equals("easy")) {
                    easy.add(question);
                } else if (currentSet.equals("medium")) {
                    medium.add(question);
                } else {
                    hard.add(question);
                }
            }
            prefixSum.add(sum);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": file not found");
            return false;
        }
        return true;
    }

    public String getQuestion() {
        if (questions.isEmpty()) {
            return "Questions used up";
        }
        int x = rand.nextInt(prefixSum.get(prefixSum.size() - 1));

        int l = 0, r = prefixSum.size() - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (prefixSum.get(mid) == x) {
                l = mid;
                break;
            } else if (x < prefixSum.get(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        String question = questions.get(l);
        if (mediumCount < minMedium && hard.contains(question)) {
            return getQuestion();
        }
        if (easyCount < minEasy && medium.contains(question)) {
            return getQuestion();
        }

//        System.out.println(questions);
//        System.out.println(weights);
//        System.out.println(prefixSum);
//        System.out.println(x);
//        System.out.println(l);

        count += 1;
        sum -= weights.get(l);
        weights.remove(l);
        questions.remove(l);
        prefixSum.remove(prefixSum.size() - 1);
        for (int i = l; i < prefixSum.size() - 1; i++) {
            prefixSum.set(i + 1, prefixSum.get(i) + weights.get(i));
        }
        if (hard.contains(question)) {
            hard.remove(question);
            hardCount += 1;
        }
        if (medium.contains(question)) {
            medium.remove(question);
            mediumCount += 1;
        }
        if (easy.contains(question)) {
            easy.remove(question);
            easyCount += 1;
        }
        return question;
    }

    public static void main(String[] args) {
//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());
        while (true) {
            Solution solution = new Solution();
            solution.run();
        }
    }
}
