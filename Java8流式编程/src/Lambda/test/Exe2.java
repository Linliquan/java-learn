package Lambda.test;

import Lambda.interfaces.ItemCreatorBlankConstruct;
import Lambda.interfaces.ItemCreatorParamContruct;

/**
 * @author linliquan
 * @description:
 * @create 2020/12/17 17:38
 */
public class Exe2 {
    public static void main(String[] args) {
        ItemCreatorBlankConstruct creator = () -> new Item();

    }
}
