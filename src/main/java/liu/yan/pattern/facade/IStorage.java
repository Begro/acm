package liu.yan.pattern.facade;

public interface IStorage {

  void save(Object object);

  void update(Object object);

  void delete(Object object);

  Object query(int id);
}
