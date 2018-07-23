package liu.yan.concurrent;

import java.util.*;

/**
 * @author liu yan
 * @description
 * @date 2018/7/18
 */
public class Test {
	public static void main(String[] args) {
		List<String> nodes = new ArrayList<>();
		nodes.add("127.0.0.1:9000");
		nodes.add("127.0.0.1:9001");
		nodes.add("127.0.0.1:9002");
		ConsistentHashMap<String, Integer> consistentHashMap = new ConsistentHashMap<String, Integer>(nodes);
		print(consistentHashMap);
	}

	private static void print(ConsistentHashMap<String, Integer> consistentHashMap) {
		Map<String, List<Integer>> result = new HashMap<>();
		for (int i = 0; i < 16; i++) {
			String node1 = consistentHashMap.get(i);
			if (result.containsKey(node1)) {
				result.get(node1).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				result.put(node1, list);
			}
		}
		for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
			System.out.print(entry.getKey() + " 》》 ");
			for (int i : entry.getValue()) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("==================");
	}
}
