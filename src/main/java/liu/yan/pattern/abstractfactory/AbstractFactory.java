package liu.yan.pattern.abstractfactory;

/**
 * 抽象工厂类
 * 抽象工厂模式：针对的多个产品族，每个产品族的实体需要在一起使用，
 * 如：本例中yht产品族和piao产品族两个产品族。每次每个产品族要在一起使用，fuck和love都同时针对yht或者piao
 *
 * 角色：抽象工厂，具体工厂，抽象角色，具体角色
 *
 * 优点：1.符合高内聚低耦合，只需要改变具体工厂类，就可以改变整个系统行为
 *      2.能保证同一时间只能使用同一产品族的具体类
 *      3.符合开闭原则，创建新的产品族，只需要创建新的具体工厂和产品族
 * 缺点：增加产品族的新产品很难，比如：本例中已有fuck和love产品，增加一个doNotCare就需要修改几乎所有类
 *
 * @author 刘研
 * @create 2017-10-24 15:33
 **/
public abstract class AbstractFactory {

  abstract IFuckCompany createFuckCompany();

  abstract ILoveCompany createLoveCompany();
}
