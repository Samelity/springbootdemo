package com.rin.web;

import com.rin.entity.TDR;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "天地融接口模拟")
@RestController
@RequestMapping(value = "/open", produces = "application/json; charset=utf-8")
public class TDRController {

    private String base64="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";

    @PostMapping("/uncompletedlist")
    public String getList(@RequestBody TDR.Message message) {
        if (message.getSize() > 0) {
            return "{\n" +
                    "  \"resultCode\": \"0\",\n" +
                    "  \"errorMsg\": \"SUCCESS\",\n" +
                    "  \"data\": {\n" +
                    "    \"total\": 2,\n" +
                    "    \"size\": 2,\n" +
                    "    \"pages\": 1,\n" +
                    "    \"current\": 1,\n" +
                    "    \"records\": [\n" +
                    "      {\n" +
                    "        \"guestId\": \"2020030501\",\n" +
                    "        \"type\": 1,\n" +
                    "        \"name\": \"龙哥\",\n" +
                    "        \"sex\": 1,\n" +
                    "        \"birthday\": \"2000-10-11T00:00:00Z\",\n" +
                    "        \"photoBase64\": \""+base64+"\",\n" +
                    "        \"cardType\": \"01\",\n" +
                    "        \"cardNo\": \"612321198812272352\",\n" +
                    "        \"addrRegion\": \"612321\",\n" +
                    "        \"addrDetail\": \"杭州市余杭区中泰乡石鸽社区８组石鸽里１８２号\",\n" +
                    "        \"nation\": \"汉\",\n" +
                    "        \"nativePlace\": \"浙江杭州\",\n" +
                    "        \"passCardNo\": \"\",\n" +
                    "        \"issuerOrg\": \"\",\n" +
                    "        \"issuerTime\": 0,\n" +
                    "        \"effectiveDate\": \"\",\n" +
                    "        \"expiryDate\": \"\",\n" +
                    "        \"chineseName\": \"\",\n" +
                    "        \"englishFirstname\": \"\",\n" +
                    "        \"englishSurname\": \"\",\n" +
                    "        \"country\": \"\",\n" +
                    "        \"infoPhotoBase64\": \"\",\n" +
                    "        \"visaPhotoBase64\": \"\",\n" +
                    "        \"coverPhotoBase64\": \"\",\n" +
                    "        \"exitPhotoBase64\": \"\"\n" +
                    "      },\n " +
                    "      {\n" +
                    "        \"guestId\": \"2020030502\",\n" +
                    "        \"type\": 2,\n" +
                    "        \"name\": \"Berumotto\",\n" +
                    "        \"sex\": 2,\n" +
                    "        \"birthday\": \"1988-10-11T00:00:00Z\",\n" +
                    "        \"photoBase64\": \""+base64+"\",\n" +
                    "        \"cardType\": \"14\",\n" +
                    "        \"cardNo\": \"APTX4869\",\n" +
                    "        \"addrRegion\": \"\",\n" +
                    "        \"addrDetail\": \"\",\n" +
                    "        \"nation\": \"\",\n" +
                    "        \"nativePlace\": \"\",\n" +
                    "        \"passCardNo\": \"\",\n" +
                    "        \"issuerOrg\": \"\",\n" +
                    "        \"issuerTime\": 0,\n" +
                    "        \"effectiveDate\": \"\",\n" +
                    "        \"expiryDate\": \"\",\n" +
                    "        \"chineseName\": \"贝尔摩德\",\n" +
                    "        \"englishFirstname\": \"Beru\",\n" +
                    "        \"englishSurname\": \"Motto\",\n" +
                    "        \"country\": \"JP\",\n" +
                    "        \"infoPhotoBase64\": \"\",\n" +
                    "        \"visaPhotoBase64\": \"\",\n" +
                    "        \"coverPhotoBase64\": \"\",\n" +
                    "        \"exitPhotoBase64\": \"\"\n" +
                    "      }" +
                    "    ]\n" +
                    "  }\n" +
                    "}";
        } else {
            return "{\n" +
                    "  \"resultCode\": \"-1\",\n" +
                    "  \"errorMsg\": \"传入的参数错误\"\n" +
                    "}";
        }
    }

    @PostMapping("/completerecord")
    public String completeRecord(@RequestBody TDR.Guest guest) {
        return "{\n" +
                "  \"resultCode\": \"0\",\n" +
                "  \"errorMsg\": \"补全完成\"\n" +
                "}";
    }

}
