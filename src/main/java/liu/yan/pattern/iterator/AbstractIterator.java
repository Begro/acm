package liu.yan.pattern.iterator;

/**
 * 抽象迭代器
 *
 * @author 刘研
 * @create 2017-11-16 11:29
 **/
public interface AbstractIterator<E> {

  E next();

  E previous();

  boolean hasNext();
}
