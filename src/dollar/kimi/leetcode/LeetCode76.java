package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    //滑动窗口
    public String minWindow(String s, String t) {
        // l是收缩指针，r是扩展指针
        int l=0,r=0;
        int lmin=0,rmin=s.length()-1;
        int over=t.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<s.length()){
            char cr=s.charAt(r);
            if(map.containsKey(cr)){
                int sum=map.get(cr)-1;
                map.put(cr,sum);
                if(sum>=0)over--;
                if(sum<=0&&over==0){
                    //收缩
                    while(l<=r){
                        char cl=s.charAt(l);
                        if(map.containsKey(cl)){
                            int sum2=map.get(cl)+1;
                            if(sum2>0)break;
                            else {
                                map.put(cl,sum2);
                            }
                        }
                        l++;
                    }
                }
            }
            if(over==0&&r-l<rmin-lmin){
                lmin=l;
                rmin=r;
            }
            r++;
        }

        return over==0?s.substring(lmin,rmin+1):"";
    }


}
