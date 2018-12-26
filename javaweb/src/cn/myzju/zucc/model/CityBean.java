package cn.myzju.zucc.model;

/**
 * @author clovef
 * @date 2018/12/23 0023
 * @package cn.myzju.zucc.model
 */
public class CityBean {
    private String name;
    private int value;

    public CityBean(){}

    public CityBean(String name,int value){this.name=name;this.value=value;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
