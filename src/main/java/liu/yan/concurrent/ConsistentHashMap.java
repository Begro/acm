package liu.yan.concurrent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * consistent hash algorithm
 * N:type of node ,must Override method {@link Object#hashCode()};
 * K:type of object , must Override method {@link Object#toString()} ;
 *
 * @param <N>
 * @param <K>
 */
public class ConsistentHashMap<N, K> {
	private static final String SEPARATOR = "_";
	private int numberOfReplicas;
	private final SortedMap<Integer, N> circle = new TreeMap<Integer, N>();
	private Collection<N> nodes;

	public ConsistentHashMap(int numberOfReplicas) {
		this(numberOfReplicas, new ArrayList<N>());
	}

	public ConsistentHashMap(int numberOfReplicas, Collection<N> nodes) {
		this.numberOfReplicas = numberOfReplicas;
		this.nodes = new ArrayList<N>();
		for (N node : nodes) {
			add(node);
		}
	}

	public ConsistentHashMap() {
		this(100, new ArrayList<N>());
	}

	public ConsistentHashMap(Collection<N> nodes) {
		this(100, nodes);
	}

	public void add(N node) {
		if (null != node) {
			for (int i = 0; i < numberOfReplicas; i++) {
				String hashkey = getHashIdForNode(node) + SEPARATOR + i;
				circle.put(getHash(hashkey), node);
			}
			nodes.add(node);
		}
	}

	public void addAll(Collection<N> nodes) {
		if (!nodes.isEmpty()) {
			for (N node : nodes) {
				add(node);
			}
			nodes.addAll(nodes);
		}
	}

	public void remove(N node) {
		if (null != node) {
			for (int i = 0; i < numberOfReplicas; i++) {
				String hashkey = getHashIdForNode(node) + SEPARATOR + i;
				circle.remove(getHash(hashkey));
			}
			nodes.remove(node);
		}
	}

	public void removeAll() {
		if (nodes != null) {
			nodes.clear();
		}
		circle.clear();
	}

	public int size() {
		return circle.size();
	}

	public N get(K key) {
		int hash = getHash(key.toString());
		return get(hash);
	}

	private N get(int hash) {
		if (circle.isEmpty()) {
			return null;
		}

		if (!circle.containsKey(hash)) {
			SortedMap<Integer, N> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		int startPoint = hash;
		hash++;
		SortedMap<Integer, N> tailMap = circle.tailMap(hash);
		hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		if (startPoint == hash) {
			return null;
		}
		return circle.get(hash);
	}

	private static ThreadLocal<MessageDigest> MD5 = new ThreadLocal<MessageDigest>() {
		@Override
		protected MessageDigest initialValue() {
			try {
				return MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new IllegalStateException("++++ no md5 algorithm found");
			}
		}
	};

	public int getHash(String key) {
		MessageDigest md5 = MD5.get();
		byte[] d = md5.digest(key.getBytes());
		int hash = 0;
		for (int h = 0; h < 4; h++) {
			hash ^= ((int) (d[3 + h * 4] & 0xFF) << 24) | ((int) (d[2 + h * 4] & 0xFF) << 16) | ((int) (d[1 + h * 4] & 0xFF) << 8) | ((int) (d[0 + h * 4] & 0xFF));
			hash = ~hash;
		}
		int code = hash - 1;// To prevent the reach the largest integer//To prevent the reach the largest integer
		code = code & 0x7FFFFFFF; // Convert to positive integer
		return code;
	}

	/**
	 * Returns the hashID of a given server.
	 *
	 * @param node The node which we're interested in
	 * @return String the hash ID of that node.
	 */
	protected int getHashIdForNode(N node) {
		return node.hashCode();
	}

	protected Collection<N> getNodes() {
		return nodes;
	}

	protected void setNodes(Collection<N> nodes) {
		this.nodes = nodes;
	}
}
