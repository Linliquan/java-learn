package 观察者模式;

/**
 * @author linliquan
 * @description:
 * @create 2021/6/30 9:52
 */
public interface Subject {
    /**
     * 增加订阅者
     *
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 删除订阅者
     *
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知订阅者更新消息
     */
    void notify(String message);
}