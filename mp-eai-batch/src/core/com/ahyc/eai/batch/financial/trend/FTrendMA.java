package com.ahyc.eai.batch.financial.trend;

import java.util.Vector;


public class FTrendMA {

	double[] stdoriginalData={};
	int q;
	FTrendARMAMath armamath=new FTrendARMAMath();
	
	/** MA模型
	 * @param stdoriginalData //预处理过后的数据
	 * @param q //q为MA模型阶数
	 */
	public FTrendMA(double [] stdoriginalData,int q)
	{
		this.stdoriginalData=stdoriginalData;
		this.q=q;
	}
	
	public Vector<double[]> MAmodel()
	{
		Vector<double[]> v=new Vector<double[]>();
		v.add(armamath.getMApara(armamath.autocorData(stdoriginalData,q), q));
		return v;//拿到MA模型里面的参数值
	}
		
	
}
