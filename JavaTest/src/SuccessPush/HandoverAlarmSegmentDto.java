package SuccessPush;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-03-07 19:11
 **/
public class HandoverAlarmSegmentDto {


    /**
     * 动作处理
     */
    public static final String CONST_ACTION_HANDLE_STATUS_NOT_PUSH = "0";         //无需推送
    public static final String CONST_ACTION_HANDLE_STATUS_SUCCESS_PUSH = "1";     //推送成功

    /**
     *  交班id
     */
    private Integer handoverId;

    /**
     * 患者名字
     */
    private String custName;

    /**
     * 推送动作 如 : "1" 或 "0"
     */
    private String actionHandleStatus;

    /**
     * 推送动作属性值, "推送成功"或"无需推送"
     */
    private String actionHandleStatusAttr;

    /**
     * 推送成功动作统计
     */
    private Integer successPushCount;

    /**
     * 无需推送动作统计
     */
    private Integer notPushCount;

    public HandoverAlarmSegmentDto(Integer handoverId, String custName, String actionHandleStatus, String actionHandleStatusAttr, Integer successPushCount, Integer notPushCount) {
        this.handoverId = handoverId;
        this.custName = custName;
        this.actionHandleStatus = actionHandleStatus;
        this.actionHandleStatusAttr = actionHandleStatusAttr;
        this.successPushCount = successPushCount;
        this.notPushCount = notPushCount;
    }

    public HandoverAlarmSegmentDto() {
    }

    public Integer getHandoverId() {
        return handoverId;
    }

    public void setHandoverId(Integer handoverId) {
        this.handoverId = handoverId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getActionHandleStatus() {
        return actionHandleStatus;
    }

    public void setActionHandleStatus(String actionHandleStatus) {
        this.actionHandleStatus = actionHandleStatus;
    }

    public String getActionHandleStatusAttr() {
        return actionHandleStatusAttr;
    }

    public void setActionHandleStatusAttr(String actionHandleStatusAttr) {
        this.actionHandleStatusAttr = actionHandleStatusAttr;
    }

    public Integer getSuccessPushCount() {
        return successPushCount;
    }

    public void setSuccessPushCount(Integer successPushCount) {
        this.successPushCount = successPushCount;
    }

    public Integer getNotPushCount() {
        return notPushCount;
    }

    public void setNotPushCount(Integer notPushCount) {
        this.notPushCount = notPushCount;
    }

    @Override
    public String toString() {
        return "HandoverAlarmSegmentDto{" +
                "handoverId=" + handoverId +
                ", custName='" + custName + '\'' +
                ", actionHandleStatus='" + actionHandleStatus + '\'' +
                ", actionHandleStatusAttr='" + actionHandleStatusAttr + '\'' +
                ", successPushCount=" + successPushCount +
                ", notPushCount=" + notPushCount +
                '}';
    }
}
