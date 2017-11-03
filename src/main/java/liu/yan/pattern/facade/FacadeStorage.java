package liu.yan.pattern.facade;

/**
 * 存储层门面
 * 门面模式，屏蔽系统内部细节，对外部提供一个统一接口
 * 使各系统之间的依赖达到最小，降低客户端与系统的耦合度。
 * 一般在系统分层中，各层之间依赖已可以使用门面模式，降低各层之间的依赖
 * @author 刘研
 * @create 2017-10-30 15:13
 **/
public class FacadeStorage implements IStorage {

  private DbStorage dbStorage = new DbStorage();
  private RedisStorage redisStorage = new RedisStorage();

  @Override
  public void save(Object object) {
    redisStorage.save(object);
    dbStorage.save(object);
  }

  @Override
  public void update(Object object) {
    redisStorage.update(object);
    dbStorage.update(object);
  }

  @Override
  public void delete(Object object) {
    dbStorage.delete(object);
    redisStorage.delete(object);
  }

  @Override
  public Object query(int id) {
    redisStorage.query(id);
    dbStorage.query(id);
    return null;
  }
}
