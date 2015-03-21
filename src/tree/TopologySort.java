package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologySort
{
  /*
   * ��n��������Ҫ��ɣ����1��n��������֮����һЩ������ϵ���������a����������b��c����ôֻ�е�����b������c���֮������������a���������е�������ϵ
   * ���ж���Щ�����Ƿ��ܹ���ɡ�����ܹ���ɣ������һ���Ϸ�������������С�
   * ������
   * n=5
   * 1->2,3
   * 3->4
   * ��������������1����������2������3������3����������4����ô���ںϷ��������������4,3,2,1,5
   */

  /*
   * deps[id]��ʾ����id������������
   * ������ںϷ�������������У�����true�����򷵻�false
   * �Ϸ����������������ڲ���result�У��Ѿ�����ռ䣩
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
