import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A'] += 1;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        int totalIdle = (max - 1) * n + max - 1;
        for (int count : counts) {
            totalIdle -= count == max ? count - 1 : count;

            if (totalIdle <= 0) {
                return tasks.length;
            }
        }
        return totalIdle + tasks.length;
    }
}

//class Task {
//    private char name;
//    private int count;
//    private int coolDown;
//
//    public Task(char name, int count, int coolDown) {
//        this.name = name;
//        this.count = count;
//        this.coolDown = coolDown;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public char getName() {
//        return name;
//    }
//
//    public int getCoolDown() {
//        return coolDown;
//    }
//
//    public void setCoolDown(int coolDown) {
//        this.coolDown = coolDown;
//    }
//
//    public void coolDown() {
//        coolDown -= 1;
//    }
//
//    public void coolDown(int n) {
//        coolDown -= n;
//    }
//
//    public void decrementCount() {
//        count -= 1;
//    }
//}
//
//class Solution {
//    public int leastInterval(char[] tasks, int n) {
//        if (n == 0) {
//            return tasks.length;
//        }
//
//        HashMap<Character, Integer> countMap = new HashMap<>();
//        for (char taskName : tasks) {
//            countMap.put(taskName, countMap.getOrDefault(taskName, 0) + 1);
//        }
//
////        ArrayList<Task> taskList = new ArrayList<>(countMap.size());
//        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> (b.getCount() - a.getCount()));
//        for (char taskName : countMap.keySet()) {
//            pq.offer(new Task(taskName, countMap.get(taskName), n));
//        }
//
//        HashMap<Character, Task> coolDownMap = new HashMap<>();
//
//        int time = 0;
//        while (!pq.isEmpty() || !coolDownMap.isEmpty()) {
//            if (pq.isEmpty()) {
//                int min = Integer.MAX_VALUE;
//                for (Task task : coolDownMap.values()) {
//                    min = Math.min(min, task.getCoolDown());
//                }
//
//                time += min;
//
//                Iterator<Task> iterator = coolDownMap.values().iterator();
//                while (iterator.hasNext()) {
//                    Task task = iterator.next();
//                    if (task.getCoolDown() == min) {
//                        pq.add(task);
//                        iterator.remove();
//                    } else {
//                        task.coolDown(min);
//                    }
//                }
//            } else {
//                Task taskRun = pq.poll();
//
//                Iterator<Task> iterator = coolDownMap.values().iterator();
//                while (iterator.hasNext()) {
//                    Task task = iterator.next();
//                    if (task.getCoolDown() == 1) {
//                        pq.add(task);
//                        iterator.remove();
//                    } else {
//                        task.coolDown();
//                    }
//                }
//
//                taskRun.decrementCount();
//                if (taskRun.getCount() != 0) {
//                    taskRun.setCoolDown(n);
//                    coolDownMap.put(taskRun.getName(), taskRun);
//                }
//                time += 1;
//            }
//        }
//        return time;
//    }
//}
