package dollar.kimi.leetcode;

public class LeetCode680 {
    public boolean validPalindrome(String s) {
        char[] sc=s.toCharArray();
        int i=0,j=sc.length-1;
        for(;i<j&&sc[i]==sc[j];i++,j--);
        return isPalindrome(sc,i+1,j)||isPalindrome(sc,i,j-1);

    }

    private boolean isPalindrome(char[] s,int i,int j){
        for(;i<j&&s[i]==s[j];i++,j--);
        return i>=j;
    }
}
