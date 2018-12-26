package cn.myzju.zucc;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.myzju.zucc.neo4j.CaseSearch.*;

/**
 * @author clovef
 * @date 2018/11/15 0015
 * @package cn.myzju.zucc
 */
public class Do extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Do() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * @descript 对前端的Get方法进行响应
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * @descript 对前端的Post方法进行响应
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setCharacterEncoding("utf-8");
        String data=searchByName(name).replace("\"source\"","source").replace("\"target\"","target").replace("\"category\"","category").replace("\"des\"","des").replace("\"id\"","id").replace("\"name\"","name");
        response.getWriter().write("var myChart3 = echarts.init(document.getElementById('main1'));option3 = {\n" +
                "            title: { text: '涉毒案件关系图谱' },\n" +
                "            tooltip: {\n" +
                "                formatter: function (x) {\n" +
                "                    return x.data.des;\n" +
                "                }\n" +
                "            },\n" +
                "            series: [\n" +
                "                {\n" +
                "                    type: 'graph',\n" +
                "                    layout: 'force',\n" +
                "                    symbolSize: 80,\n" +
                "                    roam: true,\n" +
                "                    edgeSymbol: ['circle', 'arrow'],\n" +
                "                    edgeSymbolSize: [4, 10],\n" +
                "                    edgeLabel: {\n" +
                "                        normal: {\n" +
                "                            textStyle: {\n" +
                "                                fontSize: 20\n" +
                "                            }\n" +
                "                        }\n" +
                "                    },\n" +
                "                    force: {\n" +
                "                        repulsion: 2500,\n" +
                "                        edgeLength: [10, 50]\n" +
                "                    },\n" +
                "                    draggable: true,\n" +
                "                    itemStyle: {\n" +
                "                        normal: {\n" +
                "                            color: '#4b565b'\n" +
                "                        }\n" +
                "                    },\n" +
                "                    lineStyle: {\n" +
                "                        normal: {\n" +
                "                            width: 2,\n" +
                "                            color: '#4bff5b'\n" +
                "\n" +
                "                        }\n" +
                "                    },\n" +
                "                    categories:[\n" +
                "                        {name:\"Cases\",\n" +
                "                        itemStyle: {\n" +
                "                        normal: {\n" +
                "                            color: 'red'\n" +
                "                        }\n" +
                "                        }},\n" +
                "                        {name:\"Crime\",itemStyle: {\n" +
                "                        normal: {\n" +
                "                            color: 'blue'\n" +
                "                        }\n" +
                "                        }},\n" +
                "                        {name:\"Drugs\",itemStyle: {\n" +
                "                        normal: {\n" +
                "                            color: '#82202b'\n" +
                "                        }\n" +
                "                        }},\n" +
                "                        {name:\"Penalty\",itemStyle: {\n" +
                "                        normal: {\n" +
                "                            color: '#662233'\n" +
                "                        }\n" +
                "                        }},\n" +
                "                        {name:\"People\",itemStyle: {\n" +
                "                        normal: {\n" +
                "                            color: '#aaaaaa'\n" +
                "                        }\n" +
                "                        }}\n" +
                "                    ],\n" +
                "                    edgeLabel: {\n" +
                "                        normal: {\n" +
                "                            show: true,\n" +
                "                            formatter: function (x) {\n" +
                "                                return x.data.name;\n" +
                "                            }\n" +
                "                        }\n" +
                "                    },\n" +
                "                    label: {\n" +
                "                        normal: {\n" +
                "                            show: true,\n" +
                "                            textStyle: {\n" +
                "                            }\n" +
                "                        }\n" +
                "                    },"+data+",\n" +
                "                }\n" +
                "            ]\n" +
                "        };myChart3.setOption(option3);");
    }
}
