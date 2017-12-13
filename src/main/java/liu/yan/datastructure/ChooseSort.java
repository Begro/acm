package liu.yan.datastructure;

/**
 * 选择排序
 * 第一次迭代：第一个位置一定是数据最小的值，所以满足
 * 在第n次迭代之后，数组a[0...n]已经是原数组排序好的子数组
 * 下一次迭代新增加的一定比之前已经排序好的数组值都大
 * 子数组前a[0...n]的位置依旧是排序好的
 * 满足循环不变式
 *
 * @author 刘研
 * @create 2017-12-13 14:40
 **/
public class ChooseSort {

  public static void main(String[] args) {
    int[] a = new int[]{3, 1, 3, 6, 4, 1, 2, 6, 8, 9, 2};
    sort(a);
    for (int s : a) {
      System.out.print(s + "  ");
    }
  }

  public static void sort(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }

    int i = 0;
    while (i < array.length) {
      int min = array[i];
      int minPos = i;
      for (int j = i; j < array.length; j++) {
        if (min > array[j]) {
          min = array[j];
          minPos = j;
        }
      }
      if (minPos == i) {
        i++;
        continue;
      }
      array[i] = array[i] + array[minPos];
      array[minPos] = array[i] - array[minPos];
      array[i] = array[i] - array[minPos];
      i++;
    }
  }
}
