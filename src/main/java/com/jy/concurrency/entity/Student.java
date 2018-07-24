package com.jy.concurrency.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @Title: User
 * @Description: https://mp.weixin.qq.com/s/6hxgtH2r9bmGIizHhofyhA   lombok使用
 * @author liaojy
 */
@Accessors(chain = true)
@Getter
@Setter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class User {
    @NonNull
    private String userName;
    private int age;
}
