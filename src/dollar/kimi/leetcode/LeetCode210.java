package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;


public class LeetCode210 {

    List<List<Integer>> edges;
    //三种状态:未访问，访问过，完成
    int[] states;
    int[] res;
    int len;
    //是否有环
    boolean invalid=false;

    //拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       edges=new ArrayList<>(numCourses);
       states=new int[numCourses];
       res=new int[numCourses];
       len=numCourses;
       for (int i=0;i<numCourses;i++)edges.add(new ArrayList<>());
       for(int[] p:prerequisites)edges.get(p[1]).add(p[0]);
       for(int i=0;i<numCourses;i++){
           if(states[i]==0){
               dfs(i);
           }
       }
       return len==0?res:new int[]{};
    }

    private void dfs(int node) {
        states[node]=1;
        for(int v:edges.get(node)){
            if(states[v]==0){
                dfs(v);
                if(invalid)return;
            }else if(states[v]==1){
                invalid=true;
                return;
            }
        }
        states[node]=2;
        res[--len]=node;
    }


}
