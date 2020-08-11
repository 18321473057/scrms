package com.tn.scrms.common.engine;

import java.io.*;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公共的JS脚本引擎工具类
 */
public class CommonScriptEngineUtil {
    private static Logger log = LoggerFactory.getLogger(CommonScriptEngineUtil.class); // 日志

    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");

    private static Invocable invoke = null;

    /**
     * 调用js中的函数
     * @param jsName js文件名称
     * @param functionName 调用的函数名称
     * @param param 调用js函数的参数
     * @return
     */
    public static  String invokeJSFuntion(String jsName, String functionName, String param){
        initJS(jsName);
        synchronized (invoke) {
        String result = param;
        if(invoke != null){
            try {
                long startTime = System.currentTimeMillis();
                String c = (String)invoke.invokeFunction(functionName, param);
                long endTime = System.currentTimeMillis();
                log.info("invokeJSFuntion 耗时 >>>>" + (endTime-startTime));
                result = c;
            } catch (NoSuchMethodException e) {
                log.error(e.getMessage());
            } catch (ScriptException e) {
                //如果出错就重新加载
                initJS(jsName);
                log.error(e.getMessage());
            }
        }
        return result;
        }
    }


    private static void initJS(String jsName){
         String jsFileName =  "/resources/" + jsName;   // 读取js文件
        InputStreamReader reader = null;
        try {
            reader =new InputStreamReader(new FileInputStream(jsFileName),"UTF-8");
            engine.eval(reader);
            if(engine instanceof Invocable) {
                invoke = (Invocable)engine;
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } catch (ScriptException e) {
            log.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args){
        String enc = invokeJSFuntion("aes.js","valAesEncryptSet","123456");
        System.out.println(enc);
    }
}