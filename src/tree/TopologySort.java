package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologySort
{
  /*
   * 有n个任务需要完成（编号1到n），任务之间有一些依赖关系，如果任务a依赖于任务b和c，那么只有当任务b和任务c完成之后才能完成任务a。给定所有的依赖关系
   * ，判断这些任务是否能够完成。如果能够完成，请给出一个合法的任务完成序列。
   * 样例：
   * n=5
   * 1->2,3
   * 3->4
   * 上述样例中任务1依赖于任务2和任务3，任务3依赖于任务4，那么存在合法的任务完成序列4,3,2,1,5
   */

  /*
   * deps[id]表示任务id所依赖的任务
   * 如果存在合法的任务完成序列，返回true，否则返回false
   * 合法的任务序列请存放在参数result中（已经分配空间）
   */
  public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n,
      int[] result)
  {
    int[] indeg = new int[n + 1];
    // reverse map
    Map<Integer, List<Integer>> rmap = new HashMap<Integer, List<Integer>>();
    for (Map.Entry<Integer, List<Integer>> entry : deps.entrySet()) {
      int id1 = entry.getKey();
      for (int id2 : entry.getValue()) {
        if (!rmap.containsKey(id2)) rmap.put(id2, new ArrayList<Integer>());
        rmap.get(id2).add(id1);
        indeg[id1]++;
      }
    }
    Stack<Integer> sta = new Stack<Integer>();
    for (int i = 1 ; i <= n ; i++)
      if (indeg[i] == 0) {
        //all the task has no dependency
        sta.push(i);
      }
    for (int t = 0 ; t < n ; t++) {
      if (sta.empty()) return false;
      int id = sta.pop();
      result[t] = id;
      if (rmap.containsKey(id)) {
        for (int id2 : rmap.get(id)) {
          indeg[id2]--;
          if (indeg[id2] == 0) sta.push(id2);
        }
      }
    }
    return true;
  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
