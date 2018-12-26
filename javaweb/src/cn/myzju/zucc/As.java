package cn.myzju.zucc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cn.myzju.zucc.neo4j.CaseSearch.searchInf;

/**
 * @author clovef
 * @date 2018/12/23 0023
 * cn.myzju.zucc
 */
public class As extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public As() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * 对前端的Get方法进行响应
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //初始化返回数值接口
        String data=searchInf().toString();
        response.getWriter().write("var myChart2 = echarts.init(document.getElementById('main2'));" +
                "var schema = [\n" +
                "    {name: 'age', index: 1, text: '最小年龄'},\n" +
                "    {name: 'qua', index: 2, text: '贩毒数量'},\n" +
                "    {name: 'year', index: 3, text: '刑期'}\n" +
                "];\n" +
                "\n" +
                "var rawData = "+data+";\n" +
                "\n" +
                "\n" +
                "var option2 = {\n" +
                "    animation: false,\n" +
                "    brush: {\n" +
                "        brushLink: 'all',\n" +
                "        xAxisIndex: [],\n" +
                "        yAxisIndex: [],\n" +
                "        inBrush: {\n" +
                "            opacity: 1\n" +
                "        }\n" +
                "    },\n" +
                "    toolbox: {\n" +
                "        show:false\n" +
                "    }," +
                "    visualMap: {\n" +
                "        type: 'piecewise',\n" +
                "        categories: [\"金华\", \"舟山\", \"杭州\",\"嘉兴\",\"宁波\",\"衢州\",\"温州\",\"绍兴\",\"湖州\",\"丽水\",\"台州\"],\n" +
                "        dimension: 3,\n" +
                "        orient: 'horizontal',\n" +
                "        top: 0,\n" +
                "        left: 'center',\n" +
                "        inRange: {\n" +
                "            color: ['#c23531','#2f4554', '#61a0a8','#f0a1a8','#8076a3','#d0dfe6','#1ba784','#869d9d','#fccb16','#835e1d','#f26b1f','#ec2b24']\n" +
                "        },\n" +
                "        outOfRange: {\n" +
                "            color: '#eee'\n" +
                "        },\n" +
                "        seriesIndex: [0]\n" +
                "    },\n" +
                "    tooltip: {\n" +
                "        trigger: 'item'\n" +
                "    },\n" +
                "    parallelAxis: [\n" +
                "        {dim: 0, name: schema[0].text},\n" +
                "        {dim: 1, name: schema[1].text},\n" +
                "        {dim: 2, name: schema[2].text}\n" +
                "    ],\n" +
                "    xAxis: [],\n" +
                "    yAxis: [],\n" +
                "    series: [\n" +
                "        {\n" +
                "            name: 'parallel',\n" +
                "            type: 'parallel',\n" +
                "            smooth: true,\n" +
                "            lineStyle: {\n" +
                "                normal: {\n" +
                "                    width: 1,\n" +
                "                    opacity: 0.3\n" +
                "                }\n" +
                "            },\n" +
                "            data: rawData\n" +
                "        }\n" +
                "    ]\n" +
                "};" +
                "myChart2.setOption(option2);");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * 对前端的Post方法进行响应
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
