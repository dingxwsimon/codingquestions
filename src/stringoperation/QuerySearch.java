package stringoperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuerySearch {

    /*
     * 有一个长度为n的字符串str，有非常多的关键字query（长度不超过10），需要判断每个关键字是否是str的子串。
     * 注意：query是动态的输入进行查询的，预先并不知道所有的query。
     */

    private List<String> prefixList;

    // pre-process the large string
    public void initWithString(String str) {
	Set<String> strs = new HashSet<String>();

	for (int i = 0; i < str.length(); ++i) {
	    strs.add(str.substring(i, Math.min(str.length(), i + 10)));
	}
	prefixList = new ArrayList<String>(strs);
	Collections.sort(prefixList);
    }

    // find the query substring
    public boolean existSubString(String query) {
	int low = 0;
	int high = prefixList.size() - 1;
	while (low <= high) {
	    int mid = (low + high) / 2;
	    int comp = prefixList.get(mid).compareTo(query);
	    if (comp == 0) {
		return true;
	    }
	    if (prefixList.get(mid).startsWith(query)) {
		return true;
	    }
	    if (comp > 0) // mid > query
	    {
		high = mid - 1;
	    } else {
		low = mid + 1;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
