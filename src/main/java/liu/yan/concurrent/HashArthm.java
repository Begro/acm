package liu.yan.concurrent;

import java.util.*;

/**
 * @author liu yan
 * @description
 * @date 2018/7/12
 */
public class HashArthm {


	private static Map<Integer, Node> nodes = new TreeMap<>();

	private static int group = 16;

	private static int initServerNum = 3;

	public static void main(String[] args) {
		addMember("1.1.1.1", 1);
		addMember("2.2.2.2", 2);
		addMember("3.3.3.3", 3);
		Map<Node, List<Integer>> test = hash(group, initServerNum, nodes);
		say(test);
		deleteMember("2.2.2.2", 2);
		say(hash(group, initServerNum, nodes));

		addMember("4.4.4.4", 4);
		say(hash(group, initServerNum, nodes));


		deleteMember("1.1.1.1", 1);
		say(hash(group, initServerNum, nodes));

		addMember("1.1.1.1", 1);
		say(hash(group, initServerNum, nodes));

		addMember("2.2.2.2", 2);
		say(hash(group, initServerNum, nodes));

		deleteMember("1.1.1.1", 1);
		say(hash(group, initServerNum, nodes));

		deleteMember("2.2.2.2", 2);
		say(hash(group, initServerNum, nodes));

		deleteMember("3.3.3.3", 3);
		say(hash(group, initServerNum, nodes));

		addMember("5.5.5.5", 5);
		say(hash(group, initServerNum, nodes));

		addMember("6.6.6.6", 6);
		say(hash(group, initServerNum, nodes));

		deleteMember("5.5.5.5", 5);
		say(hash(group, initServerNum, nodes));
	}

	private static void say(Map<Node, List<Integer>> test) {
		for (Map.Entry<Node, List<Integer>> nodeListEntry : test.entrySet()) {
			System.out.print(nodeListEntry.getKey() + " >>> ");
			for (int i : nodeListEntry.getValue()) {
				System.out.print(i + "   ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

	private static Map<Node, List<Integer>> hash(int groupNum, int initServerNum, Map<Integer, Node> nodes) {
		Map<Node, List<Integer>> result = new HashMap<>();
		List<Integer> left = new ArrayList<>();
		for (int group = 0; group < groupNum; group++) {
			int mod = group % initServerNum;
			if (nodes.get(mod).isAvailable()) {
				if (result.containsKey(nodes.get(mod))) {
					result.get(nodes.get(mod)).add(group);
				} else {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(group);
					result.put(nodes.get(mod), tmp);
				}
			} else {
				left.add(group);
			}
		}
		Map<Integer, Node> available = getAvalible(nodes);
		int size = available.size();
		int factNum = groupNum / size;
		if (size >= initServerNum) {
			for (int i = 0; i < initServerNum; i++) {
				Node node = nodes.get(i);
				if (node.isAvailable()) {
					List<Integer> list = result.get(node);
					while ((list.size() - factNum) > 0) {
						left.add(list.get(list.size() - 1));
						list.remove(list.size() - 1);
					}
				}
			}
		}
		Integer[] tmpArray = new Integer[left.size()];
		Arrays.sort(left.toArray(tmpArray));
		left.clear();
		left.addAll(Arrays.asList(tmpArray));
		List<Integer> finalLeft = new ArrayList<>();
		for (int i = 0; i < left.size(); i++) {
			int offset = 0;
			while (true) {
				int mod = (i % size + offset) % size;
				Node node = available.get(mod);
				if (!result.containsKey(node)) {
					result.put(node, new ArrayList<>());
				}
				if (result.get(node).size() >= factNum) {
					offset++;
					if (offset > size) {
						finalLeft.add(left.get(i));
						break;
					}
				} else {
					result.get(node).add(left.get(i));
					break;
				}
			}
		}
		if (!finalLeft.isEmpty()) {
			for (int i = 0; i < finalLeft.size(); i++) {
				int mod = i % size;
				Node node = available.get(mod);
				result.get(node).add(finalLeft.get(i));
			}
		}
		return result;
	}

	private static void addMember(String ip, int port) {
		Node node = new Node(ip,port);
		node.setAvailable(true);
		node.setOrder(nodes.size());
		for (Node temp : nodes.values()) {
			if (node.equals(temp)) {
				temp.setAvailable(true);
				return;
			}
		}
		nodes.put(node.getOrder(), node);
	}

	private static void deleteMember(String ip, int port) {
		Node node = new Node(ip,port);
		for (Node temp : nodes.values()) {
			if (node.equals(temp)) {
				temp.setAvailable(false);
				break;
			}
		}
	}

	private static Map<Integer, Node> getAvalible(Map<Integer, Node> nodes) {
		Map<Integer, Node> result = new TreeMap<>();
		for (Node node : nodes.values()) {
			if (node.isAvailable()) {
				result.put(result.size(), node);
			}
		}
		return result;
	}


}
