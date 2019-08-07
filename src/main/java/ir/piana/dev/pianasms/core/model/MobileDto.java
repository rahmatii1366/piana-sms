package ir.piana.dev.pianasms.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 11:18 AM
 **/
public class MobileDto {
    private String mobile;

    public MobileDto() {
    }

    public MobileDto(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
