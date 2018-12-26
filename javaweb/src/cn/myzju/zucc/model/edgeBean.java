package cn.myzju.zucc.model;

import org.neo4j.graphdb.Relationship;

public class edgeBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    private String name;
    private String source;
    private String target;

    public edgeBean(){}

    public edgeBean(Relationship relationship){
        this.setName(String.valueOf(relationship.getType()));
        this.setSource(String.valueOf(relationship.getStartNodeId()));
        this.setTarget(String.valueOf(relationship.getEndNodeId()));
    }
}
