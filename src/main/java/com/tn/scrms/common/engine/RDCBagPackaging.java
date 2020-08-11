package com.tn.scrms.common.engine;

import org.springframework.util.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class RDCBagPackaging {
    /**
     * 正则表达式引擎管理器
     */
    private static ScriptEngineManager manager;
    /**
     * 正则表达式引擎
     */
    private static ScriptEngine engine;

    static {
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
    }
    
    public static   boolean trueOrFalse(String msg){
        boolean eval=false;
        try{
            if(!StringUtils.isEmpty(msg)){
                eval = (boolean) engine.eval(msg);
            }
        }catch (Exception e){

        }
         return eval;
    }
    public static void main(String[] args) throws ScriptException {

        String test = "(尾程供应商 = IB) or (尾程供应商 != DH) and (供应商服务产品 = PKD)";
        String test2 = "(WS == DHL)|| (WS == IB) || (UBI == UBI) && (UBIEUSEMI == UBIEUSEMI )";
//        String test2 = "（'WS' == 'DHL'）|| （'WS' == 'IB'） || （'UBI' == 'UBI') && ('UBIEUSEMI' == 'UBIEUSEMI')";
//        String test2 = "（尾程供应商=DHL）or （尾程供应商=IB） or （尾程供应商=UBI) and (服务产品=UBIEUSEMI）";
//        String test2 = "'UBI' == 'IB' || 'WS' == 'IB' || 'UBI' == 'UBI' && 'UBIEUSEMI' == 'UBIEUSEMI' ";
        String test1 = "('DH' == 'IB') || ('DH' != 'DH') && ('PKD' == 'PKD')";
        String test3 = "('DH' == 'PPS')  ||  ('DH' == 'PPS')  ||  ('DH' == 'PPS')  &&  ('PPS' == 'PPS')";
        String msg = "1 ==1&& 2==2";
        String newmsg = "('DH' == 'DH')  ||  ('DH' == 'IB')  ||  ('DH' == 'UB')  &&  ('PPS' == 'UBIEUSEMI')";
//        boolean eval = (boolean) engine.eval(msg);
//        boolean eval1 = (boolean) engine.eval(test1);
//        boolean eval2 = (boolean) engine.eval(test2);
//        boolean eval3 = (boolean) engine.eval(newmsg);




        String  aTest = "ycs=='ycs'";
        engine.put("ycs","ycs");
        boolean CC = (boolean) engine.eval(aTest);
//        System.out.println(eval);
//        System.out.println(eval1);
        System.out.println(CC);
//        System.out.println(trueOrFalse(aTest));
    }
}
