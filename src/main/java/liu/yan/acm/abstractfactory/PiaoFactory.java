package liu.yan.acm.abstractfactory;

/**
 * @author 刘研
 * @create 2017-10-24 15:38
 **/
public class PiaoFactory extends AbstractFactory {

  @Override
  IFuckCompany createFuckCompany() {
    return new FuckPiao();
  }

  @Override
  ILoveCompany createLoveCompany() {
    return new LovePiao();
  }
}
