package Lambda.test;

import Lambda.interfaces.ItemCreatorBlankConstruct;
import Lambda.interfaces.ItemCreatorParamContruct;

/**
 * @author linliquan
 * @description: 构造方法的引用
 * @create 2020/12/17 17:38
 */
public class Exe2 {
    public static void main(String[] args) {
        ItemCreatorBlankConstruct creator = () -> new Item();
        Item item = creator.getItem();

        ItemCreatorBlankConstruct creator2  = Item::new;
        Item item1 = creator2.getItem();
        System.out.println(item1);

//        ItemCreatorParamContruct creator3 = Item::new;
//        Item item3 = creator3.getItem(112, "鼠标", 135.99);

    }
}
