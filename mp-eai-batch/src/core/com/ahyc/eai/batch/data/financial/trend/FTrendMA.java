package com.ahyc.eai.batch.data.financial.trend;

import java.util.Vector;


public class FTrendMA {

	double[] stdoriginalData={};
	int q;
	FTrendARMAMath armamath=new FTrendARMAMath();
	
	/** MAģ��
	 * @param stdoriginalData //Ԥ������������
	 * @param q //qΪMAģ�ͽ���
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
		return v;//�õ�MAģ������Ĳ���ֵ
	}
		
	
}
