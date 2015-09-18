package com.ahyc.eai.batch.financial.trend;

/*import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;*/

public class FTrendCalculator {
	public static void main(String args[])
	{
		
		try {
			/*ArrayList<Double> arraylist=new ArrayList<Double>();
			Scanner ino=new Scanner(new File("D:\\Microbject\\workspaces\\Arima\\Data\\ceshidata.txt"));
			
			while(ino.hasNext())
			{
				arraylist.add(Double.parseDouble(ino.next()));
			}
			ino.close();*/
			double[] dataArray={12781.17 
					,10637.69 
					,11094.06 
					,11153.49 
					,16824.44 
					,10365.10 
					,3995.04 
					,17261.63 
					,13581.99 
					,16120.09 
					,15202.40 
					,15265.77 
					,10935.89 
					,5001.37 
					,14425.29 
					,13852.18 
					,13414.44 
					,14985.12 
					,17885.13 
					,5628.67 
					,5164.49 
					,12303.56 
					,15256.25 
					,20512.45 
					,23408.02 
					,25226.68 
					,13353.91 
					,6149.77 
					,19858.05 
					,21444.57 
					,20234.96 
					,19156.03 
					,16758.90 
					,11458.99 
					,5284.05 
					,22604.48 
					,20444.98 
					,19127.97 
					,20858.25 
					,23122.47 
					,13126.87 
					,5257.35 
					,20494.09 
					,18502.32 
					,21340.57 
					,20958.07 
					,24576.16 
					,17056.14 
					,5924.57 
					,23728.32 
					,24627.06 
					,26352.01 
					,25826.76 
					,27587.46 
					,17407.61 
					,7018.34 
					,25652.50 
					,23985.74 
					,24815.16 
					,23384.18 
					,29519.61 
					,24300.43 
					,7924.05 
					,23015.72 
					,24370.97 
					,24451.75 
					,21390.04 
					,27223.46 
					,20438.26 
					,7900.74 
					,28862.47 
					,25568.59 
					,28432.24 
					,29026.96 
					,32398.77 
					,26971.05 
					,9645.30 
					,32320.22 
					,32431.04 
					,31092.99 
					,32069.23 
					,34655.36 
					,22258.58 
					,10343.59 
					,33206.60 
					,31426.29 
					,35320.37 
					,36137.26 
					,41145.95 
					,29862.53 
					,17320.76};//new double[arraylist.size()]; 
			
			/*for(int i=0;i<arraylist.size();i++)
				dataArray[i]=arraylist.get(i);*/
			
			//System.out.println(arraylist.size());
				
			FTrendARIMA arima=new FTrendARIMA(dataArray); 
			
			int []model=arima.getARIMAmodel();
			System.out.println("Best model is [p,q]="+"["+model[0]+" "+model[1]+"]");
			System.out.println();
			System.out.println(arima.aftDeal(arima.predictValue(model[0],model[1])));
			
		
		//	String[] str = (String[])list1.toArray(new String[0]);	
			
		} catch (Exception e) {//FileNotFoundException e
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	/*
		ARIMA arima=new ARIMA(dataArray); 
		
		int []model=arima.getARIMAmodel();
		System.out.println("Best model is [p,q]="+"["+model[0]+" "+model[1]+"]");
		System.out.println();
		System.out.println(arima.aftDeal(arima.predictValue(model[0],model[1])));
		*/
	
		/*
		
		double corr[]=a.autocorData(arima.preDeal(), 10);
		
		for(int i=0;i<corr.length;i++)
		{
			System.out.println(corr[i]+"  ");
		}
		System.out.println();
		
		double parcorr[]=a.parautocorData(arima.preDeal(), 10);
		for(int i=0;i<parcorr.length;i++)
		{
			System.out.println(parcorr[i]+" ");
		}
		System.out.println();
		*/
	}
}
