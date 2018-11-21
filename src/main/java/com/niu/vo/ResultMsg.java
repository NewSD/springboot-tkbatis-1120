package com.niu.vo;

import com.niu.enumtype.ReturnStatus;
import com.niu.exception.BusinessException;
import lombok.Data;

import java.util.List;

/**
 * Created by ami on 2018/11/20.
 */
@Data
public class ResultMsg<T> {

    private int resultCode;
    private String resultMsg;
    private T data;
    private int totalCount;
    private List<Integer> permissions;

    public static ResultMsg createErrMsg(ReturnStatus status) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResultCode(status.getCode());
        resultMsg.setResultMsg(status.getDesc());
        return resultMsg;
    }

    public static ResultMsg createErrMsg(BusinessException bizException) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResultCode(bizException.getErrorCode());
        resultMsg.setResultMsg(bizException.getMessage());
        return resultMsg;
    }

    public static ResultMsg createErrMsg(Integer resultCode, String msg) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResultCode(resultCode);
        resultMsg.setResultMsg(msg);
        return resultMsg;
    }

    public static ResultMsg createMsg(Object data) {
        ResultMsg resultMsg = new ResultMsg();
//        resultMsg.setResultCode(0);
        resultMsg.setResultCode(ReturnStatus.OK.getCode());
        resultMsg.setResultMsg(ReturnStatus.OK.getDesc());
        resultMsg.setData(data);
        return resultMsg;
    }

    public static ResultMsg createMsg() {
        ResultMsg resultMsg = new ResultMsg();
//        resultMsg.setResultCode(0);
        resultMsg.setResultCode(ReturnStatus.OK.getCode());
        resultMsg.setResultMsg(ReturnStatus.OK.getDesc());
        return resultMsg;
    }


}
