package com.rin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

public class TDR {
    @ApiModel(description = "获取列表请求")
    @Data
    public static class Message {
        @ApiModelProperty(value = "页码")
        private Integer current;
        @ApiModelProperty(value = "条目数")
        private Integer size;
    }

    @Data
    public static class Guest {
        private String guestId;
        private int type;
        private String cardType;
        private String cardNo;
        private int sex;
        private String occupation;
        private String reason;
        private String birthday;
        private String enterTime;
        private String roomNo;
        private String exitTime;
        private String chineseName;
        private String englishFirstname;
        private String englishSurname;
        private String country;
        private String visaType;
        private String visaNo;
        private String goDate;
        private String signDepartment;
        private String enterCountryDate;
        private String enterCountryPort;
        private String fromWhere;
        private String toWhere;
        private String validPeriod;
        private String hostUnit;
        private String name;
        private String addrProvince;
        private String addrCity;
        private String addrRegion;
        private String addrDetail;
        private String nativePlace;
        private String nation;
    }
}
