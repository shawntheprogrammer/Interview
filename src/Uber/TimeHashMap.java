package Uber;
import java.util.*;

public class TimeHashMap<K, V> {
    HashMap<K, Entry> map = new HashMap<>();
    
    public class Entry {
        double time;
        V value;
        Entry next;
        public Entry(double t, V v) {
            time = t;
            value = v;
        }
    }
    
    public void put(double t, K k, V v) {
        if (!map.containsKey(k)) {
            Entry entry = new Entry(t, v);
            map.put(k, entry);
            return;
        }
        
        Entry cur = map.get(k);
        if (t < cur.time) {
            Entry e = new Entry(t, v);
            e.next = cur;
            map.put(k, e);
            return;
        }
        while (cur.time <= t) {
            if (cur.time == t) {
                cur.value = v;
                return;
            } else if (cur.next == null) {
                Entry e = new Entry(t, v);
                cur.next = e;
                return;
            } else if (cur.next.time > t){
                Entry e = new Entry(t, v);
                e.next = cur.next;
                cur.next = e;
                return;
            } else {
                cur = cur.next;
            }
        }
    }
    
    public V get(K k, int t) {
        if (!map.containsKey(k)) {
            return null;
        }
        Entry cur = map.get(k);
        if  (t < cur.time) {
            return null;
        }
        while (cur.next != null && cur.time < t && cur.next.time <= t) {
            cur = cur.next;
        }
        return cur.value;
    }
    
    public static void main(String[] args) {
        TimeHashMap<String, String> myMap = new TimeHashMap<>();
        
        myMap.put(1, "0", "1");
        myMap.put(12, "0", "12");
        System.out.println(myMap.get("0", 0));
        System.out.println(myMap.get("0", 2));
        System.out.println(myMap.get("0", 12));
        System.out.println(myMap.get("0", 13));
    }
}
