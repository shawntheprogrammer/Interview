package Google;

import java.util.*;

public class Num1 {
    public class Vote{
        public int time;
        public String candidate;
        public Vote(int time, String candidate) {
            this.time = time;
            this.candidate = candidate;
        }
    }
    
    public static List<String> findWinnerII(Vote[] logs, int t) {
        if (logs == null || logs.length == 0) {
            return new ArrayList<>();
        }
        
        int index = quickselect(logs, t);
        HashMap<String, Integer> map = new HashMap<>();
        List<String> winners = new ArrayList<>();
        int maxVote = 0;
                
        for (int i = 0; i <= index; i++) {
            if (logs[i].time > t) {
                break;
            }
            String candidate = logs[i].candidate;
            
            if (!map.containsKey(candidate)) {
                map.put(candidate, 0);
            }
            map.put(candidate, map.get(candidate) + 1);
            
            if (map.get(candidate) == maxVote) {
                winners.add(candidate);
            } else if(map.get(candidate) > maxVote) {
                winners = new ArrayList<>();
                winners.add(candidate);
                maxVote = map.get(candidate);
            }
        }
        
        return winners;
    }
    
    private static int quickselect(Vote[] logs, int t) {
        int less = 0;
        int equal = 0;
        int greater = 0;
        
        //maintain the order as less...equal.....greater
        while (less + equal + greater < logs.length) {
            int i = less + equal;
            Vote v = logs[i];
            int time = v.time;
            if (time < t) {
                swap(logs, less, i);
                less++;
            } else if (time == t) {
                equal++;
            } else {
                greater++;
                swap(logs, i, logs.length - greater);
            }
        }
        return less + equal - 1;
    }
    
    public static void swap(Vote[] logs, int i, int j) {
        Vote temp = logs[i];
        logs[i] = logs[j];
        logs[j] = temp;
    }

    //use a hashmap and sort logs first  NlgN
    public static List<String> findWinner(Vote[] logs, int t) {
        if (logs == null || logs.length == 0) {
            return new ArrayList<>();
        }
        
        Arrays.sort(logs, new Comparator<Vote>(){
            public int compare(Vote v1, Vote v2) {
                return v1.time - v2.time;
            }
        });
        
        //candidate -> votes map
        HashMap<String, Integer> map = new HashMap<>();
        
        List<String> winners = new ArrayList<>();
        int maxVote = 0;
                
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].time > t) {
                break;
            }
            String candidate = logs[i].candidate;
            if (!map.containsKey(candidate)) {
                map.put(candidate, 0);
            }
            map.put(candidate, map.get(candidate) + 1);
            if (map.get(candidate) == maxVote) {
                winners.add(candidate);
            } else if(map.get(candidate) > maxVote) {
                winners = new ArrayList<>();
                winners.add(candidate);
                maxVote = map.get(candidate);
            }
        }
        
        return winners;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Num1 q = new Num1();
        Vote v1 = q.new Vote(1, "a");
        Vote v2 = q.new Vote(2, "b");
        Vote v3 = q.new Vote(3, "a");
        Vote v4 = q.new Vote(4, "b");
        Vote v5 = q.new Vote(5, "b");
        Vote v6 = q.new Vote(6, "b");
        Vote[] arr = new Vote[]{v1, v2, v3, v4, v5, v6};
        
        System.out.println(findWinner(arr, 1));
        System.out.println(findWinner(arr, 2));
        System.out.println(findWinner(arr, 3));
        System.out.println(findWinner(arr, 4));
        System.out.println(findWinner(arr, 5));
        System.out.println(findWinner(arr, 6));
        
        System.out.println(findWinnerII(arr, 1));
        System.out.println(findWinnerII(arr, 2));
        System.out.println(findWinnerII(arr, 3));
        System.out.println(findWinnerII(arr, 4));
        System.out.println(findWinnerII(arr, 5));
        System.out.println(findWinnerII(arr, 6));
        
    }

}
