package liu.yan.acm.facade;

/**
 * redis存储
 *
 * @author 刘研
 * @create 2017-10-30 15:15
 **/
public class RedisStorage  implements IStorage{
  @Override
  public void save(Object object) {
    System.out.println("存储到redis");
  }

  @Override
  public void update(Object object) {
    System.out.println("更新redis数据");
  }

  @Override
  public void delete(Object object) {
    System.out.println("从redis删除");
  }

  @Override
  public Object query(int id) {
    System.out.println("从redis中查询");
    return null;
  }
}
