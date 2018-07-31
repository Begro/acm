package liu.yan.concurrent;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author liu yan
 * @description
 * @date 2018/7/31
 */
public class JumpConsistentHash {

	public static void main(String[] args) {
		/*List<String> nodes = new ArrayList<>();
		nodes.add("ins1");
		nodes.add("ins2");
		nodes.add("ins3");
		List<String> keys = new ArrayList<>();
		for(int i =0 ;i<16;i++){
			keys.add(i+"");
		}
		test(keys,nodes);
		nodes.add("ins5");
		test(keys,nodes);*/
		for (int i = 1 ;i<1000;i++){
			System.out.println(Hashing.consistentHash(1L,i));
		}
	}

	private static void test(List<String> keys, List<String> nodes){
		Map<String,List<String>> map = new HashMap<>();
		keys.stream().forEach(e -> {
			int bucket = Hashing.consistentHash(Hashing.md5().hashString(e, Charsets.UTF_8), nodes.size());
			String node = nodes.get(bucket);
			if(map.containsKey(node)){
				map.get(node).add(e);
			}else {
				List<String> strings = new ArrayList<>();
				strings.add(e);
				map.put(node,strings);
			}
		});
		print(map);
	}
	private static void print(Map<String,List<String>> map){
		for (Map.Entry<String, List<String>> integerListEntry : map.entrySet()) {
			System.out.print(integerListEntry.getKey());
			System.out.print(" >>>>>>>>>>>>>>> ");
			for(String a : integerListEntry.getValue()){
				System.out.print(a);
				System.out.print("    ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}


	public static int consistentHash(long input, int buckets) {
		int candidate = 0;
		int next;

		// Jump from bucket to bucket until we go out of range
		while (true) {
			next = (int) ((candidate + 1) / nextDouble(input));
			if (next >= 0 && next < buckets) {
				candidate = next;
			} else {
				return candidate;
			}
		}
	}
	public static int getHash(String key) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			return 0;
		}
		md5.reset();
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
	public static double nextDouble(long key) {
		long lstate = 2862933555777941757L * key + 1;
		return ((double) ((int) (lstate >>> 33) + 1)) / (0x1.0p31);
	}
}
