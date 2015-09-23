package com.ahyc.eai.batch.data.financial.trend;

import java.util.Vector;

public class FTrendARIMA
{

   double[] originalData = {};

   FTrendARMAMath armamath = new FTrendARMAMath();

   Vector<double[]> armaARMAcoe = new Vector<double[]>();

   Vector<double[]> bestarmaARMAcoe = new Vector<double[]>();

   public FTrendARIMA(double[] originalData){
      this.originalData = originalData;
   }

   /**
    * ԭʼ���ݱ�׼������һ�׼����Բ��+Z-Score��һ��
    * @return
    */
   double stderrDara = 0;

   double avgsumData = 0;

   public double[] preDeal(){

      //seasonal Difference:Peroid=7
      double[] tempData = new double[originalData.length - 7];
      for(int i = 0; i < originalData.length - 7; i++){
         tempData[i] = originalData[i + 7] - originalData[i];
      }

      //Z-Score
      avgsumData = armamath.avgData(tempData);
      stderrDara = armamath.stderrData(tempData);

      for(int i = 0; i < tempData.length; i++){
         tempData[i] = (tempData[i] - avgsumData) / stderrDara;
      }

      return tempData;
   }

   public int[] getARIMAmodel(){
      double[] stdoriginalData = this.preDeal();//ԭʼ���ݱ�׼������
      int paraType = 0;
      double minAIC = 9999999;
      int bestModelindex = 0;
      int[][] model = new int[][]{{0, 1}, {1, 0}, {1, 1}, {0, 2}, {2, 0}, {2, 2}, {1, 2}, {2, 1}};
      //��8��ģ�ͽ��е�����ѡ��AICֵ��С��ģ����Ϊ���ǵ�ģ��
      for(int i = 0; i < model.length; i++){

         if(model[i][0] == 0){
            FTrendMA ma = new FTrendMA(stdoriginalData, model[i][1]);
            armaARMAcoe = ma.MAmodel(); //�õ�maģ�͵Ĳ���
            paraType = 1;
         }else if(model[i][1] == 0){
            FTrendAR ar = new FTrendAR(stdoriginalData, model[i][0]);
            armaARMAcoe = ar.ARmodel(); //�õ�arģ�͵Ĳ���
            paraType = 2;
         }else{
            FTrendARMA arma = new FTrendARMA(stdoriginalData, model[i][0], model[i][1]);
            armaARMAcoe = arma.ARMAmodel();//�õ�armaģ�͵Ĳ���
            paraType = 3;
         }

         double temp = getmodelAIC(armaARMAcoe, stdoriginalData, paraType);
         //System.out.println(temp);
         if(temp < minAIC){
            bestModelindex = i;
            minAIC = temp;
            bestarmaARMAcoe = armaARMAcoe;

         }
      }
      //System.out.println("bestModelindex" + bestModelindex);
      return model[bestModelindex];
   }

   public double getmodelAIC(Vector<double[]> para,
                             double[] stdoriginalData,
                             int type){
      double temp = 0;
      double temp2 = 0;
      double sumerr = 0;
      int p = 0;//ar1,ar2,...,sig2
      int q = 0;//sig2,ma1,ma2...
      int n = stdoriginalData.length;

      if(type == 1){
         double[] maPara = para.get(0);
         q = maPara.length;
         double[] err = new double[q]; //error(t),error(t-1),error(t-2)...
         err[0] = Math.sqrt(maPara[0]);

         for(int k = q - 1; k < n; k++){
            temp = 0;

            for(int i = 1; i < q; i++){
               temp += maPara[i] * err[i];
            }

            //��������ʱ�̵�����
            for(int j = q - 1; j > 0; j--){
               err[j] = err[j - 1];
            }
            err[0] = stdoriginalData[k] - (err[0] - temp);
            //���Ƶķ���֮��
            sumerr += err[0] * err[0];

         }
         return n * Math.log(sumerr / (n - (q - 1))) + (q) * Math.log(n);//AIC ��С���˹���

      }else if(type == 2){
         double[] arPara = para.get(0);
         p = arPara.length;
         for(int k = p - 1; k < n; k++){
            temp = 0;
            for(int i = 0; i < p - 1; i++){
               temp += arPara[i] * stdoriginalData[k - i - 1];
            }
            temp += Math.sqrt(arPara[p - 1]);
            //���Ƶķ���֮��
            sumerr += (stdoriginalData[k] - temp) * (stdoriginalData[k] - temp);
         }

         return n * Math.log(sumerr / (n - (p - 1))) + (p) * Math.log(n);//AIC ��С���˹���
      }else{
         double[] arPara = para.get(0);
         double[] maPara = para.get(1);
         p = arPara.length;
         q = maPara.length;
         double[] err = new double[q]; //error(t),error(t-1),error(t-2)...
         err[0] = Math.sqrt(maPara[0]);

         for(int k = p - 1; k < n; k++){
            temp = 0;
            temp2 = 0;
            for(int i = 0; i < p - 1; i++){
               temp += arPara[i] * stdoriginalData[k - i - 1];
            }

            for(int i = 1; i < q; i++){
               temp2 += maPara[i] * err[i];
            }

            //��������ʱ�̵�����
            for(int j = q - 1; j > 0; j--){
               err[j] = err[j - 1];
            }
            err[0] = stdoriginalData[k] - (err[0] - temp2 + temp);
            //���Ƶķ���֮��
            sumerr += err[0] * err[0];
         }

         return n * Math.log(sumerr / (n - (p - 1))) + (p + q - 1) * Math.log(n);//AIC ��С���˹���
      }
   }

   public double aftDeal(int predictValue){
      return predictValue * stderrDara + avgsumData + originalData[originalData.length - 7];
   }

   public int predictValue(int p,
                           int q){
      int predict = 0;
      double[] stdoriginalData = this.preDeal();
      int n = stdoriginalData.length;
      double temp = 0, temp2 = 0;
      double[] err = new double[q];

      if(p == 0){
         double[] maPara = bestarmaARMAcoe.get(0);

         for(int k = q - 1; k <= n; k++){
            temp = 0;

            for(int i = 1; i < q; i++){
               temp += maPara[i] * err[i];
            }

            //��������ʱ�̵�����
            for(int j = q - 1; j > 0; j--){
               err[j] = err[j - 1];
            }
            if(k == n)
               predict = (int)(err[0] - temp); //����Ԥ��
            else
               err[0] = stdoriginalData[k] - (err[0] - temp);
         }
      }else if(q == 0){
         double[] arPara = bestarmaARMAcoe.get(0);

         for(int k = p - 1; k <= n; k++){
            temp = 0;
            for(int i = 0; i < p - 1; i++){
               temp += arPara[i] * stdoriginalData[k - i - 1];
            }
            temp += Math.sqrt(arPara[p - 1]);
         }

         predict = (int)temp;

      }else{

         double[] arPara = bestarmaARMAcoe.get(0);
         double[] maPara = bestarmaARMAcoe.get(1);

         err = new double[q]; //error(t),error(t-1),error(t-2)...
         err[0] = Math.sqrt(maPara[0]);

         for(int k = p - 1; k <= n; k++){
            temp = 0;
            temp2 = 0;
            for(int i = 0; i < p - 1; i++){
               temp += arPara[i] * stdoriginalData[k - i - 1];
            }

            for(int i = 1; i < q; i++){
               temp2 += maPara[i] * err[i];
            }

            //��������ʱ�̵�����
            for(int j = q - 1; j > 0; j--){
               err[j] = err[j - 1];
            }
            if(k == n)
               predict = (int)(err[0] - temp2 + temp);
            else
               err[0] = stdoriginalData[k] - (err[0] - temp2 + temp);

         }

      }

      return predict;
   }

   public double[] getMApara(double[] autocorData,
                             int q){
      double[] maPara = new double[q + 1];//��һ�������������������q�����ma����sigma2,ma1,ma2...
      double[] tempmaPara = maPara;
      double temp = 0;
      boolean iterationFlag = true;
      //�ⷽ����
      //�������ⷽ����
      while(iterationFlag){
         for(int i = 1; i < maPara.length; i++){
            temp += maPara[i] * maPara[i];
         }
         tempmaPara[0] = autocorData[0] / (1 + temp);

         for(int i = 1; i < maPara.length; i++){
            temp = 0;
            for(int j = 1; j < maPara.length - i; j++){
               temp += maPara[j] * maPara[j + i];
            }
            tempmaPara[i] = -(autocorData[i] / tempmaPara[0] - temp);
         }
         iterationFlag = false;
         for(int i = 0; i < maPara.length; i++){
            if(maPara[i] != tempmaPara[i]){
               iterationFlag = true;
               break;
            }
         }

         maPara = tempmaPara;
      }

      return maPara;
   }

}
