package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode207 {
    List<List<Integer>> edges;
    //状态：访问过，没访问过,访问完成
    int[] states;
    boolean valid=true;
    //本质是看图有没有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>(numCourses);
        states=new int[numCourses];
        for(int i=0;i<numCourses;i++)edges.add(new ArrayList<>());
        for(int[] p:prerequisites)edges.get(p[1]).add(p[0]);
        for(int i=0;i<numCourses;i++){
            if(states[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int course) {
        states[course]=1;
        for(int v:edges.get(course)){
            if(states[v]==0){
                dfs(v);
                if(!valid)return;
            }else if(states[v]==1){
                valid=false;
                return;
            }
        }
        states[course]=2;
    }
}
