package com.fastcampus.sns.model;

import lombok.Data;

import java.util.List;

@Data
public class AlarmArgs {

    // 알람을 발생시킨 사람
    private Integer fromUserId;
    private Integer targetId;


}
