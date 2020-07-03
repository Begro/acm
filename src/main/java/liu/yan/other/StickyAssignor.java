package liu.yan.other;

import java.util.*;

/**
 * @author liuyan
 * @date 15:47 2020/5/12
 * @description
 */
public class StickyAssignor<K extends Comparable<K>> {


	private Map<K, SortedSet<Integer>> currentAssignment = new TreeMap<>();
	private int currentQueueSize;

	/**
	 * @param serverId
	 * @param clients   must can be Comparator
	 * @param queueSize
	 * @return
	 */
	public List<Integer> assign(int serverId, List<K> clients, int queueSize) {
		clients.sort(null);
		int clientSize = clients.size();
//		int offset = clientSize < queueSize ? serverId : (serverId * queueSize) % clientSize;
//		int offset = clientSize < queueSize ? serverId : serverId*queueSize;
		int offset = queueSize;
		int average = queueSize / clientSize;
		int remainder = queueSize % clientSize;
		Map<K, Integer> targetAssignment = new TreeMap<>();
		for (int i = offset; i < clientSize + offset; i++) {
			K client = clients.get(i % clientSize);
			targetAssignment.put(client, average + (remainder > 0 ? 1 : 0));
			remainder--;
		}
		SortedSet<Integer> freeQueues = new TreeSet<>();
		if (currentAssignment.isEmpty()) {
			for (int i = 1; i <= queueSize; i++) {
				freeQueues.add(i);
			}
		} else if (currentQueueSize < queueSize) {
			for (int i = currentQueueSize + 1; i <= queueSize; i++) {
				freeQueues.add(i);
			}
		} else if (currentQueueSize > queueSize) {
			reduceQueue(queueSize);
		}
		currentQueueSize = queueSize;
		//先过滤一遍多分配的队列
		freeMore(freeQueues, targetAssignment);
		List<Integer> result = new ArrayList<>(freeQueues);
		//过滤一遍少分配的
		assignLess(freeQueues, targetAssignment);
		//分配一遍剩余的
		assignFree(freeQueues);
		return result;
	}

	private void reduceQueue(int queueSize) {
		for (Map.Entry<K, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
			SortedSet<Integer> value = entry.getValue();
			if (value.isEmpty()) {
				continue;
			}
			int last = value.last();
			while (last >= queueSize) {
				value.remove(last);
				last = value.last();
			}
		}
	}

	private void assignFree(SortedSet<Integer> freeQueues) {
		if (freeQueues.isEmpty()) {
			return;
		}
		while (!freeQueues.isEmpty()) {
			for (Map.Entry<K, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
				if (freeQueues.isEmpty()) {
					return;
				}
				Integer first = freeQueues.first();
				entry.getValue().add(first);
				freeQueues.remove(first);
			}
		}
	}

	private void assignLess(SortedSet<Integer> freeQueues, Map<K, Integer> targetAssignment) {
		if (freeQueues.isEmpty()) {
			return;
		}
		for (Map.Entry<K, Integer> entry : targetAssignment.entrySet()) {
			K client = entry.getKey();
			int targetSize = entry.getValue();
			if (!currentAssignment.containsKey(client)) {
				int assignSize = freeQueues.size() < targetSize ? freeQueues.size() : targetSize;
				TreeSet<Integer> queues = new TreeSet<>();
				currentAssignment.put(client, queues);
				if (freeQueues.isEmpty()) {
					continue;
				}
				while (assignSize-- > 0) {
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

	private void freeMore(SortedSet<Integer> freeQueues, Map<K, Integer> targetAssignment) {
		if (currentAssignment.isEmpty()) {
			return;
		}
		List<K> toBeDelete = new ArrayList<>();
		for (Map.Entry<K, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
			K client = entry.getKey();
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
		if (!toBeDelete.isEmpty()) {
			for (K client : toBeDelete) {
				currentAssignment.remove(client);
			}
		}
	}


	public Map<K, SortedSet<Integer>> getCurrentAssignment() {
		return currentAssignment;
	}

	public K getClientChannelByQueue(int queue) {
		for (Map.Entry<K, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
			if (entry.getValue().contains(queue)) {
				return entry.getKey();
			}
		}
		return null;
	}
}
