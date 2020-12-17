package Lambda.interfaces;

import Lambda.test.Item;

/**
 * @author linliquan
 * @description:
 * @create 2020/12/17 17:37
 */
public interface ItemCreatorParamContruct {
    Item getItem(int id, String name, double price);
}
