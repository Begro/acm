package liu.yan.pattern.iterator;

/**
 * 抽象集合类
 *
 * @author 刘研
 * @create 2017-11-16 13:29
 **/
public interface AbstractCollection<E> {

  AbstractIterator<E> iterator();

  int size();

  E get(int i);

  void add(E e);

}
