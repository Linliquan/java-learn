package 观察者模式;

/**
 * @author linliquan
 * @description:
 * @create 2021/6/30 9:52
 */
public class WeixinUser implements Observer {

    /**
     * 微信用户名
     */
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }


}
