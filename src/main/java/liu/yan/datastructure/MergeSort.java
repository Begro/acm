package liu.yan.datastructure;

/**
 * 归并排序
 *
 * @author 刘研
 * @create 2017-12-13 16:33
 **/
public class MergeSort {

  public static void main(String[] args) {
    int[] a = new int[]{3, 1, 3, 6, 4, 1, 2, 6, 8, 9, 2};
    sort(a, 0, a.length - 1);
    for (int s : a) {
      System.out.print(s + "  ");
    }
  }

  public static void merge1(int[] data, int left, int center, int right) {
    // 临时数组
    int[] tmpArr = new int[data.length];
    // 右数组第一个元素索引
    int mid = center + 1;
    // third 记录临时数组的索引
    int third = left;
    // 缓存左数组第一个元素的索引
    int tmp = left;
    while (left <= center && mid <= right) {
      // 从两个数组中取出最小的放入临时数组
      if (data[left] <= data[mid]) {
        tmpArr[third++] = data[left++];
      } else {
        tmpArr[third++] = data[mid++];
      }
    }
    // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
    while (mid <= right) {
      tmpArr[third++] = data[mid++];
    }
    while (left <= center) {
      tmpArr[third++] = data[left++];
    }
    // 将临时数组中的内容拷贝回原数组中
    // （原left-right范围的内容被复制回原数组）
    while (tmp <= right) {
      data[tmp] = tmpArr[tmp++];
    }
  }

  public static void sort(int[] array, int left, int right) {

    if (left < right) {
      int middle = (left + right) / 2;
      sort(array, left, middle);
      sort(array, middle + 1, right);
      merge(array, left, middle, right);
    }

  }


  private static void merge(int[] array, int left, int middle, int right) {
    int arrayL[] = new int[middle - left + 1];
    int arrayR[] = new int[right - middle];

    for (int i = 0; i < arrayL.length; i++) {
      arrayL[i] = array[left + i];
    }
    for (int k = 0; k < arrayR.length; k++) {
      arrayR[k] = array[middle + k + 1];
    }

    int l = 0, r = 0, k = left;
    while (l < arrayL.length && r <arrayR.length ) {
      if (arrayL[l] < arrayR[r]) {
        array[k++] = arrayL[l];
        l++;
      } else {
        array[k++] = arrayR[r];
        r++;
      }
    }
    while (l < arrayL.length) {
      array[k++] = arrayL[l++];
    }
    while (r < arrayR.length) {
      array[k++] = arrayR[r++];
    }
  }


}
