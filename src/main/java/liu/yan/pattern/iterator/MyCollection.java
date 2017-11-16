package liu.yan.pattern.iterator;

/**
 * 迭代器模式：遍历一个聚合类，又不需知道它内部的数据结构
 * 定义了一个外部迭代器，对聚合类进行访问和遍历
 * 角色：抽象迭代器，具体迭代器，抽象聚合类，具体聚合类
 * 缺点：增加新的聚合类，需要增加相应的迭代器类
 *
 * @author 刘研
 * @create 2017-11-16 13:31
 **/
public class MyCollection<E> implements AbstractCollection<E> {

  private int size;
  Object[] data;

  public MyCollection() {
    size = 0;
    data = new Object[10];
  }

  @Override
  public AbstractIterator<E> iterator() {
    return new Itr();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public E get(int i) {
    return (E) data[i];
  }

  @Override
  public void add(E e) {
    data[size++] = e;
  }


  private class Itr implements AbstractIterator {

    int cursor;

    @Override
    public Object next() {
      return data[cursor++];
    }

    @Override
    public Object previous() {
      return data[cursor--];
    }

    @Override
    public boolean hasNext() {
      return cursor < size;
    }
  }
}
