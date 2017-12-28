import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    //if k >= length of both strings combined, then Yes (we can delete at null to increment)
    //else we require x delete operations and y append operations to match
    //1 append and 1 delete can preserve the string while increasing operation count by 2
    //therefore if k >= x + y and (x + y - k) % 2 == 0 then yes, else no

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        int k = in.nextInt();
        int count = 0;
        int index = 0;
        if(k >= s.length + t.length){
            System.out.println("Yes");
            
        }else{
            while(index < s.length && index < t.length){
                if(s[index] != t[index])
                    break;
                count++;
                index++;
            }
            int x = s.length - count;
            int y = t.length - count;
            if(k >= x+y && (x+y-k)%2 == 0){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        in.close();
    }
}
