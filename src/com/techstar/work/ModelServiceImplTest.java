/**   
 * Copyright © 2016 北京恒泰实达科技发展有限公司. All rights reserved.
 * 项目名称：tech09Hessian
 * 描述信息: 
 * 创建日期：2016年1月5日 下午2:56:15 
 * @author malitao
 * @version 
 */
package com.techstar.work;

import java.util.ArrayList;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.techstar.framework.components.interfacemgr.bean.Control;
import com.techstar.framework.components.interfacemgr.bean.Operation;
import com.techstar.framework.components.interfacemgr.bean.Parameter;
import com.techstar.framework.components.interfacemgr.bean.Parameters;
import com.techstar.framework.components.interfacemgr.bean.RequestMessage;
import com.techstar.framework.components.interfacemgr.bean.ReturnMessage;
import com.techstar.framework.components.interfacemgr.hessian.HessianRpcPublishInterface;

import visu.platform.analyzer.model.DataSource;

/**
 * 
 * 创建日期：2016年1月5日 下午2:56:15
 * 
 * @author malitao
 */
public class ModelServiceImplTest {

    public static void main(String[] args) throws Exception {
        new ModelServiceImplTest().testFindDataSource();
    }
    @SuppressWarnings("unchecked")
	public void testFindDataSource() throws Exception {
        long before = System.currentTimeMillis();
        // Hessian 代理工厂
        HessianProxyFactory factory = new HessianProxyFactory();
        //设置访问的servlet路径
//        String url = "http://127.0.0.1:8080/hessianservlet/rpcservice";System.out.println(url);
        String url = "http://172.16.101.121:8080/visu-platform4.0/hessianservlet/rpcservice";System.out.println(url);
        HessianRpcPublishInterface hrp = (HessianRpcPublishInterface)factory.create(HessianRpcPublishInterface.class,url);
        System.out.println("获取连接时间："+(System.currentTimeMillis()-before));
        //获得Hessian工厂获取的几口具体实现类
        String token =null;
        //全部
        RequestMessage requestMessage = getAll();
        //单个
//        RequestMessage requestMessage = getOneById("a2eea8854d2011e5aa13a5809b4a5558");
        ReturnMessage returnMessage = (ReturnMessage) hrp.operationData(token,requestMessage);
        Object obj = returnMessage.getOperation().getReturnValue().getObjectValue();
        System.out.println("得到返回值时间："+(System.currentTimeMillis()-before)+"毫秒");
        if(obj instanceof List){
            //全部的遍历
            List<DataSource> list = (List<DataSource>)obj;
            System.out.println(list.get(0).getCaption()+" : "+list.get(0).getId());
            System.out.println("实例个数为："+list.size());
        }else {
            //单个的遍历
            DataSource ds = (DataSource) obj;
            System.out.println(ds.getCaption() + ":" + ds.getId());
        }
        System.out.println("解析信息时间："+(System.currentTimeMillis()-before));
    }

    /**
     * 获取所需参数： 调用全部DataSource的方法： getAllDataSource (类：ModelServiceImpl)
     * @return
     */
    @SuppressWarnings("rawtypes")
	public RequestMessage getAll(){
        RequestMessage requestMsg = new RequestMessage();
        requestMsg.setControl(new Control());
        Operation op = new Operation();
        op.setNamespace("iModelService");op.setServiceClass("iModelService");
        //取全部信息
        op.setName("getAllDataSource");
        op.setMethodName("getAllDataSource");
        ArrayList al = new ArrayList();
        Parameters paraList = new Parameters();
        paraList.setParameterList(al);
        op.setParameters(paraList);
        requestMsg.setOperation(op);
        return requestMsg;
    }

    /**
     * 获取所需参数： 调用全部DataSource的方法： findDataSourceByID (类：ModelServiceImpl)
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public RequestMessage getOneById(String id){ RequestMessage requestMsg = new RequestMessage();
        requestMsg.setControl(new Control());
        Operation op = new Operation();
        op.setNamespace("iModelService");op.setServiceClass("iModelService");
        //按id取信息
        Parameter para = new Parameter();
        para.setParamValue(id);
        ArrayList al = new ArrayList();
        al.add(para);
        Parameters paraList = new Parameters();
        paraList.setParameterList(al);
        op.setParameters(paraList);
        op.setName("findDataSourceByID");
        op.setMethodName("findDataSourceByID");
        requestMsg.setOperation(op);
        return requestMsg;
    }

    //    @Test
    @SuppressWarnings("unused")
	public void test(){
        List<String> list = new ArrayList<String>();
        String str = "str";
//        Object o = list;
        Object o = str;
        if(o instanceof List){
            System.out.println("list");
        }else{
            System.out.println("str");
        }
    }
}