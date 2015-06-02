package com.jfinal.weixin.robot;
import java.util.List;
public class TuLingResponse {
    private String code;
    private String text;
    private String url;
    private List<InfoEntity> list;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<InfoEntity> getList() {
        return list;
    }

    public void setList(List<InfoEntity> list) {
        this.list = list;
    }
}
