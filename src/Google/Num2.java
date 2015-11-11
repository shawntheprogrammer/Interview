package Google;

import java.util.*;

//encoding and decoding a string
public class Num2 {
    
    public static String encoding(List<String> list) {
        if (list == null) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        //scan through the list 
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                char c= s.charAt(j);
                //adding a '/' before ',' or '/' to specify it's character in the string, not the sperater
                if (c == ',' || c == '/')
                    sb.append('/');
                sb.append(c);
            }
            //make the string comma seperated
            if (i != list.size() - 1)
                sb.append(',');
        }
        
        return sb.toString();
    }
    
    public static List<String> decoding(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<>();
        
        //scan through s, find all the ',' that doesn't has a '/' before it
        int start = 0;
        while (start < s.length()) {
            int cur = start;
            StringBuilder sb = new StringBuilder();
            //let cur find a ',' without '/' prefix it
            while (cur < s.length()) {
                char c = s.charAt(cur);
                //conditions: 1. normal char 2. '/' 3. ','
                if (c == '/') {
                    cur++;
                    sb.append(s.charAt(cur));
                    cur++;
                } else if (c == ',') {
                    cur++;
                    break;
                } else {
                    sb.append(c);
                    cur++;
                }
            }
            result.add(sb.toString());
            start = cur;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = ",";
        String s3 = "/";
        List<String> list = new ArrayList<>();
        list.add(s1); list.add(s2); list.add(s3);
        System.out.println(encoding(list));
        List<String> res = decoding(encoding(list));
        System.out.println(res.size());
        for (String s : res)
                System.out.println(s);
        System.out.println(list.equals(res));
    }
}
