/*
* 文 件 名:  USERSTATUS.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  用户状态
* 修 改 人:  zhouliang
* 修改时间:  2014年7月22日
* 修改内容:  <修改内容>
*/
package org.yy.demo.model.constants;

/**
* 用户状态
* 
* @author  zhouliang
* @version  [0.1, 2014年7月22日]
* @since  [APP-DEMO/0.1]
*/
public final class USERSTATUS {
    
    private USERSTATUS() {
    }
    
    /**
     * 表示注销
     */
    public static final Integer CANCEL = 0;
    
    /**
     * 表示生效
     */
    public static final Integer VALID = 1;
    
    /**
     * 表示禁用
     */
    public static final Integer DISABLE = 2;
    
}
