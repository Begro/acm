package liu.yan.pattern.facade;

/**
 * 数据库存储
 *
 * @author 刘研
 * @create 2017-10-30 15:14
 **/
public class DbStorage implements IStorage{

  @Override
  public void save(Object object) {
    System.out.println("存储到数据库");
  }

  @Override
  public void update(Object object) {

  }

  @Override
  public void delete(Object object) {
    System.out.println("从数据库删除");
  }

  @Override
  public Object query(int id) {
    System.out.println("从数据库中查询");
    return null;
  }
}
