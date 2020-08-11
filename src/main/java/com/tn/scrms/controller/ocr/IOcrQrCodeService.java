package com.tn.scrms.controller.ocr;

import java.io.IOException;

/**
 * @Author: yangcs
 * @Date: 2020/7/23 13:59
 * @Description: ocr 二维码识别服务
 */

public interface IOcrQrCodeService {

    /**
     * @Description 电池二维码图文识别
     *
     * */

      void  coventImage() throws IOException;


}
