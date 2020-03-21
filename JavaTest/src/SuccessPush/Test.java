package SuccessPush;

import java.util.*;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-03-07 19:20
 **/
public class Test {

    public List<HandoverAlarmSegmentDto> init(){

        HandoverAlarmSegmentDto handoverAlarmSegmentDto1 = new HandoverAlarmSegmentDto();
        handoverAlarmSegmentDto1.setHandoverId(1);
        handoverAlarmSegmentDto1.setCustName("王五");
        handoverAlarmSegmentDto1.setActionHandleStatus("1");
        handoverAlarmSegmentDto1.setActionHandleStatusAttr("成功推送");

        HandoverAlarmSegmentDto handoverAlarmSegmentDto2 = new HandoverAlarmSegmentDto();
        handoverAlarmSegmentDto2.setHandoverId(2);
        handoverAlarmSegmentDto2.setCustName("王五");
        handoverAlarmSegmentDto2.setActionHandleStatus("0");
        handoverAlarmSegmentDto2.setActionHandleStatusAttr("无需推送");

        HandoverAlarmSegmentDto handoverAlarmSegmentDto3 = new HandoverAlarmSegmentDto();
        handoverAlarmSegmentDto3.setHandoverId(3);
        handoverAlarmSegmentDto3.setCustName("王五");
        handoverAlarmSegmentDto3.setActionHandleStatus("0");
        handoverAlarmSegmentDto3.setActionHandleStatusAttr("无需推送");

        HandoverAlarmSegmentDto handoverAlarmSegmentDto4 = new HandoverAlarmSegmentDto();
        handoverAlarmSegmentDto4.setHandoverId(4);
        handoverAlarmSegmentDto4.setCustName("王五");
        handoverAlarmSegmentDto4.setActionHandleStatus("1");
        handoverAlarmSegmentDto4.setActionHandleStatusAttr("成功推送");

        HandoverAlarmSegmentDto handoverAlarmSegmentDto5 = new HandoverAlarmSegmentDto();
        handoverAlarmSegmentDto5.setHandoverId(5);
        handoverAlarmSegmentDto5.setCustName("王五");
        handoverAlarmSegmentDto5.setActionHandleStatus("1");
        handoverAlarmSegmentDto5.setActionHandleStatusAttr("成功推送");

        HandoverAlarmSegmentDto handoverAlarmSegmentDto6 = new HandoverAlarmSegmentDto();
        handoverAlarmSegmentDto6.setHandoverId(6);
        handoverAlarmSegmentDto6.setCustName("小林");
        handoverAlarmSegmentDto6.setActionHandleStatus("0");
        handoverAlarmSegmentDto6.setActionHandleStatusAttr("无需推送");

        List<HandoverAlarmSegmentDto> list = new ArrayList<>();
        list.add(handoverAlarmSegmentDto1);
        list.add(handoverAlarmSegmentDto2);
        list.add(handoverAlarmSegmentDto3);
        list.add(handoverAlarmSegmentDto4);
        list.add(handoverAlarmSegmentDto5);
        list.add(handoverAlarmSegmentDto6);
        return list;
    }


    public static void main(String[] args) {

        Test test = new Test();
        List<HandoverAlarmSegmentDto> list = test.init();

        Map<String, List<HandoverAlarmSegmentDto>> hashMap = new HashMap<>(16);



        if (!list.isEmpty()) {
            for (HandoverAlarmSegmentDto map : list) {
                String name = map.getCustName();
                if (hashMap.containsKey(name)) {
                    if (map.getActionHandleStatus().equals(HandoverAlarmSegmentDto.CONST_ACTION_HANDLE_STATUS_SUCCESS_PUSH)) {

                        hashMap.get(name).get(0).setSuccessPushCount(hashMap.get(name).get(0).getNotPushCount() + 1);
                    } else {
                        if (hashMap.get(name).get(0).getNotPushCount() == null) {

                            hashMap.get(name).get(0).setNotPushCount(1);
                        } else {
                            hashMap.get(name).get(0).setNotPushCount(hashMap.get(name).get(0).getNotPushCount() + 1);
                        }
                    }
                } else {
                    if (map.getActionHandleStatus().equals(HandoverAlarmSegmentDto.CONST_ACTION_HANDLE_STATUS_SUCCESS_PUSH)) {
                        map.setSuccessPushCount(1);
                    } else {
                        map.setNotPushCount(1);
                    }
                    List<HandoverAlarmSegmentDto> custList = new ArrayList<>();
                    custList.add(map);
                    hashMap.put(name, custList);
                }
            }
        }

        if (!list.isEmpty()) {
            for (HandoverAlarmSegmentDto map : list) {

                int index = 0;
                for (int i = 0; i < hashMap.get(map.getCustName()).size(); i++) {
                    if (hashMap.get(map.getCustName()).get(i).getCustName().equals(map.getCustName())){
                        index = i;
                    }
                }
                if (map.getActionHandleStatus().equals(HandoverAlarmSegmentDto.CONST_ACTION_HANDLE_STATUS_SUCCESS_PUSH)) {
                    map.setSuccessPushCount(hashMap.get(map.getCustName()).get(index).getSuccessPushCount());
                } else {
                    map.setNotPushCount(hashMap.get(map.getCustName()).get(index).getNotPushCount());
                }

            }
        }


        //遍历输出
        for (String key : hashMap.keySet()){
            System.out.println("key= "+key+" and value= "+hashMap.get(key));
        }
    }
}
