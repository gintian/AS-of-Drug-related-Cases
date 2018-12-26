package cn.myzju.zucc.model;



import org.neo4j.graphdb.Node;

import java.util.Arrays;
import java.util.List;

public class nodeBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des.substring(1,des.length()-1).replace(",","</br>");
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(String label) {
        List<String> name = Arrays.asList("Cases", "Crime", "Drugs","Penalty","People");
        this.category = name.indexOf(label);
    }

    private String name;
    private String id;
    private String des;
    private int category;

    public nodeBean(){}

    public nodeBean(Node node){
        this.setId(String.valueOf(node.getId()));
        this.setCategory(node.getLabels().iterator().next().name());
        this.setDes(node.getAllProperties().toString());
        this.setName((String) node.getProperty("name"));
    }
}
