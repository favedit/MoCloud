package com.ahyc.eai.batch.data.financial.trend;
import java.util.*;

public class FTrendAR {
	
	double[] stdoriginalData={};
	int p;
	FTrendARMAMath armamath=new FTrendARMAMath();
	
	/**
	 * ARģ��
	 * @param stdoriginalData
	 * @param p //pΪMAģ�ͽ���
	 */
	public FTrendAR(double [] stdoriginalData,int p)
	{
		this.stdoriginalData=stdoriginalData;
		this.p=p;
	}
	
	public Vector<double[]> ARmodel()
	{
		Vector<double[]> v=new Vector<double[]>();
		v.add(armamath.parcorrCompute(stdoriginalData, p, 0));
		return v;//�õ����Իع�ϵ��
		
		//��Ҫ���Ʒ�������
	}
	
}
