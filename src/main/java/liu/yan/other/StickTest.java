package liu.yan.other;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

/**
 * @author liuyan
 * @date 10:57 2020/7/3
 * @description
 */
public class StickTest {

	public static void main(String[] args) {
		new StickTest().test();
	}

	public void test() {

		int maxclient = 500;
		int maxqueue = 500;
		int maxserver = 4;

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://tmp.log"))) {
			for (int queue = 1; queue <= maxqueue; queue++) {
				for (int client = 1; client <= maxclient; client++) {
					List<Integer> clientList = new ArrayList<>();
					for (int i = 1; i <= client; i++) {
						clientList.add(i);
					}
					Map<Integer, Integer> clientQueueSize = new HashMap<>();
					for (int server = 0; server < maxserver; server++) {
						StickyAssignor<Integer> stringStickyAssignor = new StickyAssignor<>();
						stringStickyAssignor.assign(server, clientList, queue);
						Map<Integer, SortedSet<Integer>> currentAssignment = stringStickyAssignor.getCurrentAssignment();
						for (Map.Entry<Integer, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
							clientQueueSize.put(entry.getKey(), clientQueueSize.getOrDefault(entry.getKey(), 0) + entry.getValue().size());
						}
					}
					System.out.println("queue :" + queue);
					System.out.println("client :" + client);
					StringBuffer stringBuffer = new StringBuffer();
					stringBuffer.append("queue:").append(queue).append("\r\n").append("client:").append(client).append("\r\n");
					int min = Integer.MAX_VALUE, max = 0;
					for (Map.Entry<Integer, Integer> entry : clientQueueSize.entrySet()) {
						if (min > entry.getValue()) {
							min = entry.getValue();
						}
						if (max < entry.getValue()) {
							max = entry.getValue();
						}
					}
					stringBuffer.append("max:   ").append(max).append("   min:   ").append(min).append("   gap:   ").append(max - min)
							.append("   result:   ").append((max - min) <= 1).append("\r\n");
					bufferedWriter.write(stringBuffer.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public void testtt() {

		int client = 6;
		int queue = 8;
		int maxserver = 4;
		List<Integer> clientList = new ArrayList<>();
		for (int i = 1; i <= client; i++) {
			clientList.add(i);
		}
		Map<Integer, Integer> clientQueueSize = new HashMap<>();
		for (int server = 0; server < maxserver; server++) {
			StickyAssignor<Integer> stringStickyAssignor = new StickyAssignor<>();
			stringStickyAssignor.assign(server, clientList, queue);
			Map<Integer, SortedSet<Integer>> currentAssignment = stringStickyAssignor.getCurrentAssignment();
			for (Map.Entry<Integer, SortedSet<Integer>> entry : currentAssignment.entrySet()) {
				clientQueueSize.put(entry.getKey(), clientQueueSize.getOrDefault(entry.getKey(), 0) + entry.getValue().size());
			}
		}
		System.out.println("queue :" + queue);
		System.out.println("client :" + client);
		int min = Integer.MAX_VALUE, max = 0;
		for (Map.Entry<Integer, Integer> entry : clientQueueSize.entrySet()) {
			if (min > entry.getValue()) {
				min = entry.getValue();
			}
			if (max < entry.getValue()) {
				max = entry.getValue();
			}
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}

	}
}
