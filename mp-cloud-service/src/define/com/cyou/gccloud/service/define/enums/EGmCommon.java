//============================================================
// <T>游戏共通。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.service.define.enums;

//============================================================
// <T>游戏共通枚举定义。</T>
//
// @enum
//============================================================
public class EGmCommon{

   //------------------------------------------------------------
   // 结果 - 未知。
   public final static int EGmResult_Unknown = 0;
   // 结果 - 成功。
   public final static int EGmResult_Success = 1;
   // 结果 - 失败。
   public final static int EGmResult_Fail = 2;
   // 结果 - 继续。
   public final static int EGmResult_Continue = 3;
   // 结果 - 完成。
   public final static int EGmResult_Finish = 4;

   //------------------------------------------------------------
   // 对象类型 - 未知。
   public final static int EGmObject_Unknown = 0;
   // 对象类型 - 终端全局传输服务器。
   public final static int EGmObject_TrmGlobalTransfer = 1;
   // 对象类型 - 终端全局代理服务器。
   public final static int EGmObject_TrmGlobalProxy = 2;
   // 对象类型 - 终端全局主域服务器。
   public final static int EGmObject_TrmGlobalDomain = 3;
   // 对象类型 - 终端全局网关服务器。
   public final static int EGmObject_TrmGlobalGate = 4;
   // 对象类型 - 终端全局登录服务器。
   public final static int EGmObject_TrmGlobalLogin = 5;
   // 对象类型 - 终端全局存储服务器。
   public final static int EGmObject_TrmGlobalStorage = 6;
   // 对象类型 - 终端游戏代理服务器。
   public final static int EGmObject_TrmGameProxy = 7;
   // 对象类型 - 终端游戏主域服务器。
   public final static int EGmObject_TrmGameDomain = 8;
   // 对象类型 - 终端游戏网关服务器。
   public final static int EGmObject_TrmGameGate = 9;
   // 对象类型 - 终端游戏登录服务器。
   public final static int EGmObject_TrmGameLogin = 10;
   // 对象类型 - 终端游戏场景服务器。
   public final static int EGmObject_TrmGameScene = 11;
   // 对象类型 - 终端游戏战斗服务器。
   public final static int EGmObject_TrmGameBattle = 12;
   // 对象类型 - 终端游戏存储服务器。
   public final static int EGmObject_TrmGameStorage = 13;
   // 对象类型 - 终端游戏聊天服务器。
   public final static int EGmObject_TrmGameChat = 14;
   // 对象类型 - 终端游戏日志服务器。
   public final static int EGmObject_TrmGameLogger = 15;
   // 对象类型 - 终端客户端。
   public final static int EGmObject_TrmClient = 16;
   // 对象类型 - 模板种族。
   public final static int EGmObject_TplRace = 17;
   // 对象类型 - 模板职业。
   public final static int EGmObject_TplMetier = 18;
   // 对象类型 - 模板包裹。
   public final static int EGmObject_TplBag = 19;
   // 对象类型 - 模板道具。
   public final static int EGmObject_TplProp = 20;
   // 对象类型 - 模板装备。
   public final static int EGmObject_TplEquip = 21;
   // 对象类型 - 模板心法。
   public final static int EGmObject_TplBook = 22;
   // 对象类型 - 模板技能。
   public final static int EGmObject_TplSkill = 23;
   // 对象类型 - 模板BUFF。
   public final static int EGmObject_TplBuff = 24;
   // 对象类型 - 模板物品包。
   public final static int EGmObject_TplItemBag = 25;
   // 对象类型 - 模板掉落包。
   public final static int EGmObject_TplDropBag = 26;
   // 对象类型 - 模板任务包。
   public final static int EGmObject_TplTaskBag = 27;
   // 对象类型 - 模板奖励包。
   public final static int EGmObject_TplRewardBag = 28;
   // 对象类型 - 模板任务。
   public final static int EGmObject_TplTask = 29;
   // 对象类型 - 模板NPC。
   public final static int EGmObject_TplNpc = 30;
   // 对象类型 - 模板演员。
   public final static int EGmObject_TplActor = 31;
   // 对象类型 - 模板角色。
   public final static int EGmObject_TplRole = 32;
   // 对象类型 - 模板玩家。
   public final static int EGmObject_TplPlayer = 33;
   // 对象类型 - 物品道具。
   public final static int EGmObject_ItmProp = 34;
   // 对象类型 - 物品装备。
   public final static int EGmObject_ItmEquip = 35;
   // 对象类型 - 物品心法。
   public final static int EGmObject_ItmBook = 36;
   // 对象类型 - 物品技能。
   public final static int EGmObject_ItmSkill = 37;
   // 对象类型 - 实体物品。
   public final static int EGmObject_EttItem = 38;
   // 对象类型 - 实体玩家。
   public final static int EGmObject_EttPlayer = 39;
   // 对象类型 - 实体宠物。
   public final static int EGmObject_EttPet = 40;
   // 对象类型 - 实体坐骑。
   public final static int EGmObject_EttRide = 41;
   // 对象类型 - 实体NPC。
   public final static int EGmObject_EttNpc = 42;
   // 对象类型 - 地图模块。
   public final static int EGmObject_ModMap = 43;
   // 对象类型 - 全局信息。
   public final static int EGmObject_StgGlobal = 44;
   // 对象类型 - 存储账号。
   public final static int EGmObject_StgAccount = 45;
   // 对象类型 - 存储角色。
   public final static int EGmObject_StgRole = 46;

   //------------------------------------------------------------
   // 会话类型 - 未知。
   public final static int EGmSession_Unknown = 0;
   // 会话类型 - 玩家。
   public final static int EGmSession_Player = 1;
   // 会话类型 - 客服。
   public final static int EGmSession_Master = 2;
   // 会话类型 - 管理。
   public final static int EGmSession_Manager = 3;

   //------------------------------------------------------------
   // 修改类型 - 未知。
   public final static int EGmModify_Unknown = 0;
   // 修改类型 - 获得。
   public final static int EGmModify_Get = 1;
   // 修改类型 - 设置。
   public final static int EGmModify_Set = 2;
   // 修改类型 - 更改。
   public final static int EGmModify_Mod = 3;
   // 修改类型 - 增加。
   public final static int EGmModify_Inc = 4;
   // 修改类型 - 减少。
   public final static int EGmModify_Sub = 5;
   // 修改类型 - 相乘。
   public final static int EGmModify_Mul = 6;
   // 修改类型 - 相除。
   public final static int EGmModify_Div = 7;
   // 修改类型 - 按当前值修改比例。
   public final static int EGmModify_CurrentPercent = 8;
   // 修改类型 - 按最大值修改比例。
   public final static int EGmModify_MaxPercent = 9;
   // 修改类型 - 删除。
   public final static int EGmModify_Delete = 10;

   //------------------------------------------------------------
   // 比较类型 - 未知。
   public final static int EGmCompare_Unknown = 0;
   // 比较类型 - 相等。
   public final static int EGmCompare_Equals = 1;
   // 比较类型 - 不相等。
   public final static int EGmCompare_NotEquals = 2;
   // 比较类型 - 含有。
   public final static int EGmCompare_Contains = 3;
   // 比较类型 - 不含有。
   public final static int EGmCompare_NotContains = 4;
   // 比较类型 - 低于。
   public final static int EGmCompare_Lower = 5;
   // 比较类型 - 最小值。
   public final static int EGmCompare_Min = 6;
   // 比较类型 - 最大值。
   public final static int EGmCompare_Max = 7;
   // 比较类型 - 高于。
   public final static int EGmCompare_Higher = 8;

   //------------------------------------------------------------
   // 样式类型 - 未知。
   public final static int EGmStyle_Unknown = 0;

   //------------------------------------------------------------
   // 样式动作类型 - 未知。
   public final static int EGmStyleAction_Unknown = 0;
   // 样式动作类型 - 身体。
   public final static int EGmStyleAction_Body = 1;
   // 样式动作类型 - 武器。
   public final static int EGmStyleAction_Weapon = 2;
   // 样式动作类型 - 特效前。
   public final static int EGmStyleAction_EffectFront = 3;
   // 样式动作类型 - 特效后。
   public final static int EGmStyleAction_EffectBack = 4;
   // 样式动作类型 - 坐骑。
   public final static int EGmStyleAction_Ride = 5;
   // 样式动作类型 - 翅膀。
   public final static int EGmStyleAction_Wing = 6;

   //------------------------------------------------------------
   // 方向类型 - 未知。
   public final static int EGmDirection_Unknown = 0;
   // 方向类型 - 右下。
   public final static int EGmDirection_RightDown = 1;
   // 方向类型 - 下。
   public final static int EGmDirection_Down = 2;
   // 方向类型 - 左下。
   public final static int EGmDirection_LeftDown = 3;
   // 方向类型 - 左。
   public final static int EGmDirection_Left = 4;
   // 方向类型 - 左上。
   public final static int EGmDirection_LeftUp = 5;
   // 方向类型 - 上。
   public final static int EGmDirection_Up = 6;
   // 方向类型 - 右上。
   public final static int EGmDirection_RightUp = 7;
   // 方向类型 - 右。
   public final static int EGmDirection_Right = 8;
   // 方向类型 - 无方向。
   public final static int EGmDirection_All = 9;

   //------------------------------------------------------------
   // 属性类型 - 未知。
   public final static int EGmProperty_Unknown = 0;
   // 属性类型 - 当前生命。
   public final static int EGmProperty_HpCurrent = 1;
   // 属性类型 - 最大生命。
   public final static int EGmProperty_HpMax = 2;
   // 属性类型 - 当前魔法。
   public final static int EGmProperty_MpCurrent = 3;
   // 属性类型 - 最大魔法。
   public final static int EGmProperty_MpMax = 4;
   // 属性类型 - 物防。
   public final static int EGmProperty_DefencePhysical = 5;
   // 属性类型 - 法防。
   public final static int EGmProperty_DefenceMagic = 6;
   // 属性类型 - 物攻。
   public final static int EGmProperty_AttackPhysical = 7;
   // 属性类型 - 法攻。
   public final static int EGmProperty_AttackMagic = 8;
   // 属性类型 - 精准。
   public final static int EGmProperty_Hit = 9;
   // 属性类型 - 躲闪。
   public final static int EGmProperty_Dodge = 10;
   // 属性类型 - 体质。
   public final static int EGmProperty_Vitality = 11;
   // 属性类型 - 魔力。
   public final static int EGmProperty_Magic = 12;
   // 属性类型 - 力量。
   public final static int EGmProperty_Strength = 13;
   // 属性类型 - 耐力。
   public final static int EGmProperty_Stamina = 14;
   // 属性类型 - 敏捷。
   public final static int EGmProperty_Agile = 15;
   // 属性类型 - 行动值。
   public final static int EGmProperty_Mobility = 16;
   // 属性类型 - 经验。
   public final static int EGmProperty_Experience = 17;
   // 属性类型 - 等级。
   public final static int EGmProperty_Level = 18;
   // 属性类型 - 忠诚。
   public final static int EGmProperty_Fidelity = 19;
   // 属性类型 - 寿命。
   public final static int EGmProperty_Life = 20;
   // 属性类型 - 物攻资质。
   public final static int EGmProperty_ItgAttackPhysical = 21;
   // 属性类型 - 物防资质。
   public final static int EGmProperty_ItgDefencePhysical = 22;
   // 属性类型 - 气血资质。
   public final static int EGmProperty_ItgHp = 23;
   // 属性类型 - 法力资质。
   public final static int EGmProperty_ItgMagic = 24;
   // 属性类型 - 速度资质。
   public final static int EGmProperty_ItgMobility = 25;
   // 属性类型 - 躲闪资质。
   public final static int EGmProperty_ItgDodge = 26;
   // 属性类型 - 好友。
   public final static int EGmProperty_Friend = 27;
   // 属性类型 - 组队状态。
   public final static int EGmProperty_TeamStatic = 28;
   // 属性类型 - 怒气值。
   public final static int EGmProperty_Ap = 29;

   //------------------------------------------------------------
   // 种族类型 - 未知。
   public final static int EGmRace_Unknown = 0;
   // 种族类型 - 凡人。
   public final static int EGmRace_Human = 1;
   // 种族类型 - 尊族。
   public final static int EGmRace_Fairy = 2;
   // 种族类型 - 魔族。
   public final static int EGmRace_Evil = 3;
   // 种族类型 - 仙族。
   public final static int EGmRace_Angel = 4;
   // 种族类型 - 无种族限制。
   public final static int EGmRace_Unlimit = 5;

   //------------------------------------------------------------
   // 性别类型 - 未知。
   public final static int EGmGender_Unknown = 0;
   // 性别类型 - 男。
   public final static int EGmGender_Male = 1;
   // 性别类型 - 女。
   public final static int EGmGender_Female = 2;
   // 性别类型 - 无。
   public final static int EGmGender_None = 3;
   // 性别类型 - 无性别限制。
   public final static int EGmGender_Unlimit = 4;

   //------------------------------------------------------------
   // 性别 - 未知。
   public final static int EGmSex_Unknown = 0;
   // 性别 - 男性。
   public final static int EGmSex_Man = 1;
   // 性别 - 女性。
   public final static int EGmSex_Woman = 2;
}
