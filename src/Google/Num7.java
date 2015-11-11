package Google;
import java.util.*;

//leetcode 168 171  Excel Sheet Column Title
public class Num7 {
    
    //move to the very right
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        // s[n...0]  rank = sum((s[i] - 'A' + 1) * (26 ^ i))
        while (n != 0) {
            int remainder = n % 26;
            remainder = (remainder == 0) ? 26 : remainder;
            char c = (char)('A' + remainder - 1);
            sb.insert(0, c);
            n = (n - remainder) / 26;
        }
        
        return sb.toString();
    }
    
    
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int rank = 0;
        int multiplier = 1;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = c - 'A' + 1;
            //invalid input char
            if (val > 26 || val < 1) {
                return 0;
            }
            rank += val * multiplier;
            multiplier *= 26;
        }
        
        return rank;
    }
}
