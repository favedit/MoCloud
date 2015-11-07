package org.mo.content.core.financial.customer;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataFinancialCustomerLogic;
import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.define.enums.core.EGcPersonBusiness;
import com.cyou.gccloud.define.enums.core.EGcPersonEducation;
import com.cyou.gccloud.define.enums.core.EGcPersonGender;
import com.cyou.gccloud.define.enums.core.EGcPersonMarry;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.content.core.financial.marketer.customer.FDataFinancialMarketerCustomerInfo;
import org.mo.content.core.financial.marketer.customer.IDataMarketerCustomerConsole;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>客户推荐控制台。</T>
//============================================================
public class FCustomerConsole
      extends FAbstractLogicUnitConsole<FDataFinancialCustomerLogic, FDataFinancialCustomerUnit>
      implements
         ICustomerConsole
{
   // 每页条数
   static final int                       _pageSize = 12;
                                                    
   // 成员控制器
   @ALink
   protected IDataMemberConsole           _memberConsole;
                                          
   // 理财师客户控制器
   @ALink
   protected IDataMarketerCustomerConsole _marketerCustomerConsole;
                                          
   // 城市控制器
   @ALink
   protected ICityConsole                 _cityConsole;
                                          
   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FCustomerConsole(){
      super(FDataFinancialCustomerLogic.class, FDataFinancialCustomerUnit.class);
   }
   
   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerInfo> selectByMarketerId(ILogicContext logicContext,
                                                                       long marketerId){
      if(marketerId == 0){
         throw new FFatalError("selectByMarketerId,marketerId is null");
      }
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialCustomerLogic.MARKETER_ID, "={marketerId}");
      whereSql.bind("marketerId", RString.parse(marketerId));
      FLogicDataset<FDataFinancialCustomerInfo> unitList = logic.fetchClass(FDataFinancialCustomerInfo.class, whereSql);
      for(FDataFinancialCustomerInfo info : unitList){
         // 客户的主键和成员的主键一样
         FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
         if(member != null){
            info.setLabel(member.label());
            info.setPhone(member.phone());
            info.setEMAIL(member.email());
            info.setLastLogin(member.lastLoginDate());
            info.setAge(nowDate.year() - member.birthday().year());
            //学历
            info.setEducation(EGcPersonEducation.formatLabel(member.educationCd()));
            //婚否
            info.setMarray(EGcPersonMarry.formatLabel(member.marryCd()));
            //性别
            info.setGenderLabel(EGcPersonGender.formatLabel(member.genderCd()));
            //城市
            FDataCommonCityUnit city = _cityConsole.find(logicContext, member.cityId());
            if(city != null){
               info.setCityLabel(city.label());
            }
            //职业
            info.setBusiness(EGcPersonBusiness.formatLabel(member.businessCd()));
         }
      }
      return unitList;
   }
   
   // ============================================================
   // <T>获取总页数</T>
   //
   // @param logicContext 链接对象
   // @param marketerId 理财师编号
   // @return 总页数
   // ============================================================
   @Override
   public int getPageCount(ILogicContext logicContext,
                           long marketerId){
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FSql sql = new FSql();
      sql.append("SELECT COUNT(ouid) FROM DT_FIN_CUSTOMER WHERE ");
      sql.append(FDataFinancialCustomerLogic.MARKETER_ID + " = {marketer_id}");
      sql.bind("marketer_id", RString.parse(marketerId));
      ISqlConnection conn = logic.connection();
      int count = conn.executeInteger(sql);
      int pageTotal = count / _pageSize;
      if(count % _pageSize != 0){
         pageTotal += 1;
      }
      return pageTotal;
   }
   
   // ============================================================
   // <T>获取客户信息</T>
   //
   // @param logicContext 链接对象
   // @param  objectId 对象编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialCustomerInfo findInfo(ILogicContext logicContext,
                                              long objectId){
      if(objectId == 0){
         throw new FFatalError("findInfo,objectId is null");
      }
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FDataFinancialCustomerInfo info = logic.find(FDataFinancialCustomerInfo.class, objectId);
      FDataCommonCityUnit city = null;
      // 获取客户的一些基本信息,客户的主键和成员的主键一样
      FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
      if(member != null){
         city = null;
         info.setLabel(member.label());
         info.setPhone(member.phone());
         info.setEMAIL(member.email());
         info.setLastLogin(member.lastLoginDate());
         info.setAge(nowDate.year() - member.birthday().year());
         //学历
         info.setEducation(EGcPersonEducation.formatLabel(member.educationCd()));
         //婚否
         info.setMarray(EGcPersonMarry.formatLabel(member.marryCd()));
         //性别
         info.setGenderLabel(EGcPersonGender.formatLabel(member.genderCd()));
         //城市
         city = _cityConsole.find(logicContext, member.cityId());
         if(city != null){
            info.setCityLabel(city.label());
         }
         //职业
         info.setBusiness(EGcPersonBusiness.formatLabel(member.businessCd()));
      }
      return info;
   }
   
   // ============================================================
   // <T>获取理财师的客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  pageNum 页码
   // @return 数据对象
   // ============================================================
   @Override
   public FLogicDataset<FDataFinancialCustomerInfo> selectByMarketerId(ILogicContext logicContext,
                                                                       long marketerId,
                                                                       int pageNum){
      if(marketerId == 0){
         throw new FFatalError("selectByMarketerId,marketerId is null");
      }
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataFinancialCustomerLogic.MARKETER_ID, "={marketerId}");
      whereSql.bind("marketerId", RString.parse(marketerId));
      FLogicDataset<FDataFinancialCustomerInfo> unitList = logic.fetchClass(FDataFinancialCustomerInfo.class, whereSql, _pageSize, pageNum);
      for(FDataFinancialCustomerInfo info : unitList){
         // 客户的主键和成员的主键一样
         FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
         if(member != null){
            info.setLabel(member.label());
         }
      }
      return unitList;
   }
   
   // ============================================================
   // <T>获取客户</T>
   //
   // @param logicContext 链接对象
   // @param  marketerId 理财师编号
   // @param  customerId 客户编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialCustomerInfo findInfo(ILogicContext logicContext,
                                              long marketerId,
                                              long customerId){
      if(marketerId == 0 || customerId == 0){
         throw new FFatalError("findInfo,marketerId is null or customerId is null");
      }
      TDateTime nowDate = new TDateTime(RDateTime.currentDateTime());
      FDataFinancialCustomerLogic logic = logicContext.findLogic(FDataFinancialCustomerLogic.class);
      FDataFinancialCustomerInfo info = logic.find(FDataFinancialCustomerInfo.class, customerId);
      FDataCommonCityUnit city = null;
      // 获取客户的一些基本信息,客户的主键和成员的主键一样
      FDataFinancialMemberUnit member = _memberConsole.find(logicContext, info.ouid());
      FLogicDataset<FDataFinancialMarketerCustomerInfo> marketerCustomerList = _marketerCustomerConsole.findBeenSets(logicContext, marketerId, customerId);
      if(member != null){
         city = null;
         info.setLabel(member.label());
         info.setPhone(member.phone());
         info.setEMAIL(member.email());
         info.setLastLogin(member.lastLoginDate());
         info.setAge(nowDate.year() - member.birthday().year());
         //学历
         info.setEducation(EGcPersonEducation.formatLabel(member.educationCd()));
         //婚否
         info.setMarray(EGcPersonMarry.formatLabel(member.marryCd()));
         //性别
         info.setGenderLabel(EGcPersonGender.formatLabel(member.genderCd()));
         //城市
         city = _cityConsole.find(logicContext, member.cityId());
         if(city != null){
            info.setCityLabel(city.label());
         }
         //职业
         info.setBusiness(EGcPersonBusiness.formatLabel(member.businessCd()));
         for(FDataFinancialMarketerCustomerInfo marketerCustomerInfo : marketerCustomerList){
            if(marketerCustomerInfo.smsContactCd() == 1){
               info.setContactOnline(marketerCustomerInfo.smsContactCd());
            }else if(marketerCustomerInfo.smsContactCd() == 2){
               info.setContactFollow(marketerCustomerInfo.smsContactCd());
            }else if(marketerCustomerInfo.smsContactCd() == 3){
               info.setContactPurchase(marketerCustomerInfo.smsContactCd());
            }else if(marketerCustomerInfo.smsContactCd() == 4){
               info.setContactRecharge(marketerCustomerInfo.smsContactCd());
            }
         }
      }
      return info;
   }
}
