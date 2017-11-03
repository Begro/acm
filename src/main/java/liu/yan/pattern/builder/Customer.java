package liu.yan.pattern.builder;

/**
 * 客户端
 * 建造者模式：客户端无需关心产品类的具体构造过程，只需要选定具体构造者即可
 * 角色：产品类，抽象建造者，具体建造者，指挥者类
 * 优点：1.产品与产品的建造过程解耦，使用相同的建造流程，可以产生不同的产品
 *       2.使用不同的建造者可以创建不同的类，扩展方便，只需要增加新的建造者
 * 缺点：1.如果产品复杂种类多，则会产生很多建造者
 *      2.产品差异大则不适合
 * 使用场景：产品内部构造复杂，构造顺序相同且顺序依赖
 * JavaMail利用的退化建造者模式，MimeMessage一步步构造零件，最终发送邮件即返回产品
 * @author 刘研
 * @create 2017-10-25 10:34
 **/
public class Customer {

  public static void main(String[] args) {
    Director director = new Director(new ConcreteBuilderA());
    Product construct = director.construct();
    System.out.println(construct.getPartA());
    System.out.println(construct.getPartB());
  }
}
