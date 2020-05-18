package liu.yan.leetcode;

import java.util.*;

/**
 * @author liuyan
 * @date 15:47 2020/5/16
 * @description
 */
public class AliTow {

	private static Map<String, Integer> hashToString = new HashMap<>();

	private static TreeNode[] treeNodes;

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("ab");
		words.add("ac");
		words.add("fb");
		words.add("ad");
		init(words);
		System.out.println(check("abc"));
	}

	private static boolean check(String a) {
		List<TreeNode> childs = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			String s = String.valueOf(a.charAt(i));
			if (!hashToString.containsKey(s)) {
				return false;
			}
			Integer pos = hashToString.get(s);
			if (i == 0 && !treeNodes[pos].isHead) {
				return false;
			}
			if (i != 0 && !childs.contains(treeNodes[pos])) {
				return false;
			}
			childs = treeNodes[pos].childs;
			if (i != 0 && childs.isEmpty()) {
				return true;
			}
		}
		return true;
	}


	public static void init(List<String> seWords) {
		int index = 0;
		for (String s : seWords) {
			for (int i = 0; i < s.length(); i++) {
				String c = String.valueOf(s.charAt(i));
				if (!hashToString.containsKey(c)) {
					hashToString.put(c, index);
					index++;
				}
			}
		}
		treeNodes = new TreeNode[index + 1];
		for (String word : seWords) {
			TreeNode parent = null;
			for (int i = 0; i < word.length(); i++) {
				String key = String.valueOf(word.charAt(i));
				int pos = hashToString.get(key);
				if (treeNodes[pos] == null) {
					TreeNode treeNode = new TreeNode();
					treeNode.setHead(i == 0);
					treeNode.word = key;
					if (i > 0) {
						treeNode.parents.add(parent);
					}
					parent = treeNode;
					treeNodes[pos] = treeNode;
				} else {
					if (i > 0) {
						treeNodes[pos].parents.add(parent);
					}
				}
			}
			TreeNode child = null;
			for (int i = word.length() - 1; i >= 0; i--) {
				int pos = hashToString.get(String.valueOf(word.charAt(i)));
				if (i < word.length() - 1) {
					treeNodes[pos].childs.add(child);
				}
				child = treeNodes[pos];
			}
		}

	}


	static class TreeNode {
		private boolean isHead;
		private List<TreeNode> childs = new ArrayList<>();
		private List<TreeNode> parents = new ArrayList<>();
		private String word;

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			TreeNode treeNode = (TreeNode) o;
			return Objects.equals(word, treeNode.word);
		}

		@Override
		public int hashCode() {
			return Objects.hash(word);
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public List<TreeNode> getParents() {
			return parents;
		}

		public void setParents(List<TreeNode> parents) {
			this.parents = parents;
		}

		public List<TreeNode> getChilds() {
			return childs;
		}

		public void setChilds(List<TreeNode> childs) {
			this.childs = childs;
		}

		public boolean isHead() {
			return isHead;
		}

		public void setHead(boolean head) {
			isHead = head;
		}
	}
}
