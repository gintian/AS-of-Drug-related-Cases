package cn.myzju.zucc.neo4j;

import cn.myzju.zucc.model.edgeBean;
import cn.myzju.zucc.model.nodeBean;
import com.alibaba.fastjson.JSON;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CaseSearch {
    static GraphDatabaseService graphDb;



    static{
        graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File("D:\\2xm\\graph.db"));
    }


    public static Map<String, Integer> posCount(){
        String query = "MATCH (n:Cases) RETURN n.location as location,count(n.location) as count";
        Map<String, Integer> count = new HashMap<>();
        Result result = graphDb.execute(query);
        while ( result.hasNext() )
        {
            Map<String, Object> row = result.next();
            count.put(String.valueOf(row.get("location")),Integer.parseInt(String.valueOf(row.get("count"))));
        }
        return count;
    }

    public static String searchByName(String name){
        List<nodeBean> nodes = new ArrayList<nodeBean>();
        List<edgeBean> edges = new ArrayList<edgeBean>();
        List<Long> ids = new ArrayList<Long>();

        String query = "MATCH (n) where n.name='"+name+"' RETURN id(n) ORDER BY RAND() limit 5";
        Map<String, Object > parameters = new HashMap<String, Object>();
        Result result = graphDb.execute(query);
        while ( result.hasNext() ) {
            ids.add((long) result.next().values().iterator().next());
        }
        for(Long id:ids){
            Transaction tx = graphDb.beginTx();
            try{
                Node node = graphDb.getNodeById(id);
                nodes.add(new nodeBean(node));
                for (Relationship relationship : node.getRelationships(Direction.OUTGOING)){
                    edges.add(new edgeBean(relationship));
                    nodes.add(new nodeBean(relationship.getEndNode()));
                    if (!node.getLabels().iterator().next().name().equals("Cases")){
                        for (Relationship relationship1 : relationship.getEndNode().getRelationships(Direction.OUTGOING)){
                            if (relationship1.getEndNode().getId()==node.getId()){
                                continue;
                            }
                            nodes.add(new nodeBean(relationship1.getEndNode()));
                            edges.add(new edgeBean(relationship1));
                        }
                    }
                }
            }finally {
                tx.close();
            }
        }

        return "data:"+ JSON.toJSONString(nodes)+",links:"+JSON.toJSONString(edges);
    }

    public static StringBuffer searchInf(){
        StringBuffer stringBuffer=new StringBuffer("[");
        String query = "MATCH (o)-[r1:punish]->(m),(o)-[r2:contain]->(n) RETURN o.location,o.min_age,m.sentence_years,sum(n.drug_quantity)";
        Map<String, Object > parameters = new HashMap<String, Object>();
        Result result = graphDb.execute(query);
        while ( result.hasNext() )
        {
            Map<String, Object> row = result.next();
            String t = String.valueOf(row.get("o.location"));
            String t1 = String.valueOf(row.get("o.min_age"));
            String t2 = String.valueOf(row.get("m.sentence_years"));
            String t3 = String.valueOf(row.get("sum(n.drug_quantity)"));
            stringBuffer.append("["+t1+","+t3+","+t2+",'"+t+"'],");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        stringBuffer.append("]");
        return stringBuffer;
    }
}
