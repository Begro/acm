package liu.yan.pattern.iterator;

/**
 * @author 刘研
 * @create 2017-11-16 13:40
 **/
public class Customer {

  public static void main(String[] args) {
    AbstractCollection<String> collection = new MyCollection<>();
    collection.add("1");
    collection.add("2");
    collection.add("3");
    AbstractIterator<String> itr = collection.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
