package cn.myzju.zucc;

import cn.myzju.zucc.model.CityBean;
import cn.myzju.zucc.neo4j.CaseSearch;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author clovef
 * @date 2018/11/15 0015
 * @package cn.myzju.zucc
 */
public class Init extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * @descript 对前端的Get方法进行响应
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        List<CityBean> cities=new ArrayList<CityBean>();
        Map<String, Integer> map=CaseSearch.posCount();
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            cities.add(new CityBean(entry.getKey()+"市",entry.getValue()));
        }
        String data=JSON.toJSONString(cities);
        data=data.replace("\"name\"","name").replace("\"value\"","value");
        response.getWriter().write("var myChart = echarts.init(document.getElementById('main'));var option={title:{text:'浙江涉毒案件分布',subtext:'学习案例，仅供参考'},tooltip:{trigger:'item'},dataRange:{orient:'horizontal',min:0,max:900,text:['高','低'],splitNumber:0},series:[{name:'涉毒案件数',type:'map',mapType:'浙江',mapLocation:{x:'center'},selectedMode:'multiple',itemStyle:{normal:{label:{show:true}},emphasis:{label:{show:true}}},data:"+data+"}]};myChart.setOption(option);");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * @descript 对前端的Post方法进行响应
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
