package liu.yan.other;

import java.util.*;

/**
 * @author liuyan
 * @date 15:47 2020/5/12
 * @description
 */
public class StickyAssignor {


	private static Map<String, SortedSet<Integer>> currentAssignment = new TreeMap<>();


	public static void main(String[] args) {
		new StickyAssignor().test(1);

		System.out.println("##############################");

		new StickyAssignor().test(3);

	}


	private void test(int serverid){
		int queueSize = 8;
		List<String> clients = new ArrayList<>();
		clients.add("c0");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.add("c1");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.add("c2");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.add("c3");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.remove("c3");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.add("c3");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.remove("c2");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
		clients.add("c2");
		clients.add("c4");
		clients.add("c5");
		clients.add("c6");
		clients.add("c7");
		clients.add("c8");
		clients.add("c9");
		clients.add("c10");
		new StickyAssignor().assign(serverid, clients, queueSize);
		print(clients);
	}

	private static void print(List<String> clients) {
		System.out.println("====================================");
		clients.forEach(e-> System.out.print(e+" "));
		System.out.println();
		for (Map.Entry<String, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
			System.out.print(entry.getKey() + "----->");
			for (Integer integer : entry.getValue()) {
				System.out.print(integer + ",");
			}
			System.out.println();
			System.out.println("------------------------");
		}
		System.out.println("====================================");
	}


	private void assign(int serverId, List<String> clients, int queueSize) {
		clients.sort(String::compareTo);
		int clientSize = clients.size();
		int offset = clientSize < queueSize ? serverId : (serverId * queueSize) % clientSize;

		int average = queueSize / clientSize;
		int remainder = queueSize % clientSize;
		Map<String, Integer> targetAssignment = new TreeMap<>();
		for (int i = offset; i < clientSize + offset; i++) {
			String client = clients.get(i % clientSize);
			targetAssignment.put(client, average + (remainder > 0 ? 1 : 0));
			remainder--;
		}
		SortedSet<Integer> freeQueues = new TreeSet<>();
		if (currentAssignment.isEmpty()) {
			for (int i = 0; i < queueSize; i++) {
				freeQueues.add(i);
			}
		}
		//先过滤一遍多分配的队列
		freeMore(freeQueues, targetAssignment);
		//过滤一遍少分配的
		assignLess(freeQueues, targetAssignment);
		//分配一遍剩余的
		assignFree(freeQueues);
	}

	private void assignFree(SortedSet<Integer> freeQueues) {
		if (freeQueues.isEmpty()) {
			return;
		}
		while (!freeQueues.isEmpty()) {
			for (Map.Entry<String, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
				if (freeQueues.isEmpty()) {
					return;
				}
				Integer first = freeQueues.first();
				entry.getValue().add(first);
				freeQueues.remove(first);
			}
		}
	}

	private void assignLess(SortedSet<Integer> freeQueues, Map<String, Integer> targetAssignment) {
		for (Map.Entry<String, Integer> entry : targetAssignment.entrySet()) {
			String client = entry.getKey();
			int targetSize = entry.getValue();
			if (!currentAssignment.containsKey(client)) {
				int assignSize = freeQueues.size() < targetSize ? freeQueues.size() : targetSize;
				TreeSet<Integer> queues = new TreeSet<>();
				currentAssignment.put(client, queues);
				if (freeQueues.isEmpty()) {
					continue;
				}
				while(assignSize-->0){
					int queue = freeQueues.first();
					queues.add(queue);
					freeQueues.remove(queue);
				}
				continue;
			}
			int less = targetSize - currentAssignment.get(client).size();
			if (less > 0) {
				int assignSize = freeQueues.size() < less ? freeQueues.size() : less;
				while (assignSize-- > 0) {
					int queue = freeQueues.first();
					currentAssignment.get(client).add(queue);
					freeQueues.remove(queue);
				}
			}
		}
	}

	private void freeMore(SortedSet<Integer> freeQueues, Map<String, Integer> targetAssignment) {
		if (currentAssignment.isEmpty()) {
			return;
		}
		List<String> toBeDelete = new ArrayList<>();
		for (Map.Entry<String, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
			String client = entry.getKey();
			SortedSet<Integer> queues = entry.getValue();
			if (!targetAssignment.containsKey(client)) {
				freeQueues.addAll(queues);
				queues.clear();
				toBeDelete.add(client);
				continue;
			}
			int more = queues.size() - targetAssignment.get(client);
			while (more-- > 0) {
				int queue = queues.last();
				freeQueues.add(queue);
				queues.remove(queue);
			}
		}
		if(!toBeDelete.isEmpty()){
			for (String client : toBeDelete) {
				currentAssignment.remove(client);
			}
		}
	}


}
