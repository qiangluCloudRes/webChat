package com.lynch.web.vo;

/**
 * Created by LuQiang on 2017/7/2.
 */
public final class Result {

    public static final class ErrorCode{
        public static Integer   PARAM_ERROR = 11001 ;
        public static Integer   SYS_ERROR = 11002;
        public static Integer   UNKNOWN_ERROR = 11002;

    }

    public static final class Status{
        public static Integer   SUCCESS = 1;
        public static Integer   FAILURE = 0;
    }

    public static final class Reason{
        public static final String   PARAM_ABSENT = "参数错误";
        public static final String   SUCCESS = "成功";
        public static final String   FAILURE = "失败";
    }
}
