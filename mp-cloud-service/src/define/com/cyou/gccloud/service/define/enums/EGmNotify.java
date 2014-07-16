//============================================================
// <T>游戏功能。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.service.define.enums;

//============================================================
// <T>游戏功能枚举定义。</T>
//
// @enum
//============================================================
public class EGmNotify{

   //------------------------------------------------------------
   // 系统 - 未知。
   public final static int EGnSystem_Unknown = 1;

   //------------------------------------------------------------
   // 账号 - 账号不存在。
   public final static int EGnAccount_AccountNotExists = 2;
   // 账号 - 账号锁定。
   public final static int EGnAccount_AccountLock = 3;
   // 账号 - 查询账号不存在。
   public final static int EGnAccount_QueryAccountNotExists = 4;
   // 账号 - 角色不存在。
   public final static int EGnAccount_RoleNotExists = 5;
   // 账号 - 角色锁定。
   public final static int EGnAccount_RoleLock = 6;
   // 账号 - 查询角色不存在。
   public final static int EGnAccount_QueryRoleNotExists = 7;

   //------------------------------------------------------------
   // 客户端 - 会话编号失效。
   public final static int EGnClient_SessionInvalid = 8;

   //------------------------------------------------------------
   // 家园 - 不存在的建筑。
   public final static int EGnHome_BuildingNotExists = 9;
   // 家园 - 建筑级别满。
   public final static int EGnHome_BuildingLevelFull = 10;
   // 家园 - 神树精灵未激活。
   public final static int EGnHome_WorkerLock = 11;
   // 家园 - 防御塔未激活。
   public final static int EGnHome_FortLock = 12;
   // 家园 - 没有空闲神树精灵。
   public final static int EGnHome_WorkerLess = 13;
   // 家园 - 不能升级。
   public final static int EGnHome_MustLowTreeLevel = 66;

   //------------------------------------------------------------
   // 家园 - 地图未激活。
   public final static int EGnDefense_MapUnlock = 14;
   // 家园 - 奴隶营位置未激活。
   public final static int EGnDefense_SlaveClampUnlock = 15;
   // 家园 - 没有选择防御塔不能开始战斗。
   public final static int EGnDefense_NotSelectFort = 25;
   // 家园 - 奴隶营房间不足。
   public final static int EGnDefense_SlaveRoomTooSmall = 64;
   // 家园 - 神技位置不足。
   public final static int EGnDefense_SkillNotEnough = 107;

   //------------------------------------------------------------
   // 布阵 - 布阵地图未激活。
   public final static int EGnEmbattle_MapLock = 16;
   // 布阵 - 保存布阵二次确认。
   public final static int EGnEmbattle_SaveConfirm = 17;
   // 布阵 - 修改布阵二次确认。
   public final static int EGnEmbattle_ModifyConfirm = 18;
   // 布阵 - 无布阵信息。
   public final static int EGnEmbattle_NoEmbattle = 19;
   // 布阵 - 没有选择防御塔不能开始战斗。
   public final static int EGnEmbattle_NotSelectFort = 20;
   // 布阵 - 布阵更换塔。
   public final static int EGnEmbattle_EmbattleChangeFort = 118;

   //------------------------------------------------------------
   // 突袭 - 奴隶不存在。
   public final static int EGnRaid_SlaveNotExists = 21;
   // 突袭 - 奴隶数量不足。
   public final static int EGnRaid_SlaveCountInvalid = 22;
   // 突袭 - 没有选择突袭目标。
   public final static int EGnRaid_NotSelectTraget = 23;
   // 突袭 - 没有选择备战虫虫不能开始战斗。
   public final static int EGnRaid_NotSelectSlave = 24;
   // 突袭 - 不能突袭自己。
   public final static int EGnRaid_CannotRaidSelf = 78;
   // 突袭 - 收税完毕。
   public final static int EGnRaid_CollectFinish = 88;
   // 突袭 - 突袭目标被保护。
   public final static int EGnRaid_RaidTargetProtected = 104;
   // 突袭 - 突袭功能受限。
   public final static int EGnRaid_RaidLimit = 105;
   // 突袭 - 等级差别超过20级。
   public final static int EGnRaid_LevelDiffrenceTooMuch = 121;
   // 突袭 - 达到当前级别可拥有的属臣数量上限。
   public final static int EGnRaid_FootmanCountIsFull = 122;

   //------------------------------------------------------------
   // 逻辑 - 备战席位不足。
   public final static int EGnLogic_FortNotEnough = 26;
   // 逻辑 - 开启位置。
   public final static int EGnLogic_Logic1 = 27;
   // 逻辑 - 战斗中离开提示。
   public final static int EGnLogic_Logic3 = 28;
   // 逻辑 - 奴隶没关完提示。
   public final static int EGnLogic_Logic4 = 29;
   // 逻辑 - 奴隶营太小提示。
   public final static int EGnLogic_Logic5 = 30;
   // 逻辑 - 精华不足提示。
   public final static int EGnLogic_Logic6 = 31;
   // 逻辑 - 天火点不足提示。
   public final static int EGnLogic_Logic7 = 32;
   // 逻辑 - 灵气点不足提示。
   public final static int EGnLogic_Logic8 = 33;
   // 逻辑 - 无效的令牌类型。
   public final static int EGnLogic_Logic9 = 34;
   // 逻辑 - 中级诱敌令牌不足提示。
   public final static int EGnLogic_Logic10 = 35;
   // 逻辑 - 无效的地图模板编号。
   public final static int EGnLogic_Logic11 = 36;
   // 逻辑 - 不能放置防御塔。
   public final static int EGnLogic_Logic12 = 37;
   // 逻辑 - 培养模式不存在。
   public final static int EGnLogic_Logic13 = 38;
   // 逻辑 - 培养位置不足。
   public final static int EGnLogic_Logic14 = 39;
   // 逻辑 - 没有足够的奴隶贩卖。
   public final static int EGnLogic_Logic15 = 40;
   // 逻辑 - 该建筑不能手动升级。
   public final static int EGnLogic_Logic16 = 41;
   // 逻辑 - 神树等级不足，无法进行此操作。
   public final static int EGnLogic_Logic17 = 42;
   // 逻辑 - 食物数量不足，无法进行此操作。
   public final static int EGnLogic_Logic18 = 43;
   // 逻辑 - 物品不足提示。
   public final static int EGnLogic_Logic19 = 44;
   // 逻辑 - 初级诱敌令牌不足提示。
   public final static int EGnLogic_Logic20 = 45;
   // 逻辑 - 高级诱敌令牌不足提示。
   public final static int EGnLogic_Logic21 = 46;
   // 逻辑 - 初级突袭令牌不足提示。
   public final static int EGnLogic_Logic22 = 47;
   // 逻辑 - 中级突袭令牌不足提示。
   public final static int EGnLogic_Logic23 = 48;
   // 逻辑 - 高级突袭令牌不足提示。
   public final static int EGnLogic_Logic24 = 49;
   // 逻辑 - 培养失败。
   public final static int EGnLogic_Logic25 = 67;
   // 逻辑 - 道具不足。
   public final static int EGnLogic_PropNotEnough = 68;
   // 逻辑 - 无效编号。
   public final static int EGnLogic_InvaildPropTid = 69;
   // 逻辑 - 无效编号。
   public final static int EGnLogic_InvaildCrystalPlaceTid = 70;
   // 逻辑 - 水晶位置已经开启。
   public final static int EGnLogic_CrystalPlaceAlreadyUnlock = 71;
   // 逻辑 - 不能手动开启。
   public final static int EGnLogic_NotManualUnlock = 72;
   // 逻辑 - 无效的神树精灵编号。
   public final static int EGnLogic_InvaildWokerTid = 73;
   // 逻辑 - 无效的加速模板编号。
   public final static int EGnLogic_InvaildAccelerateTid = 74;
   // 逻辑 - 无效的训练位置模板编号。
   public final static int EGnLogic_InvaildTrainingPlaceTid = 75;
   // 逻辑 - 培养位置未解锁。
   public final static int EGnLogic_TrainingPlaceUnlock = 76;
   // 逻辑 - 消耗灵气。
   public final static int EGnLogic_SpendReiki = 77;
   // 逻辑 - 操作过于频繁。
   public final static int EGnLogic_FrequentlyOperiation = 85;
   // 逻辑 - 非领主和属臣不能培养。
   public final static int EGnLogic_CanNotTrain = 89;

   //------------------------------------------------------------
   // 任务 - 无效的任务模板编号。
   public final static int EGnTask_InvaildTaskTID = 50;
   // 任务 - 已交付过的任务。
   public final static int EGnTask_TaskCompleted = 51;
   // 任务 - 不能交付未完成的任务。
   public final static int EGnTask_TaskUnfinish = 52;
   // 任务 - 未知的任务操作。
   public final static int EGnTask_UnknownTaskOperation = 53;

   //------------------------------------------------------------
   // 全局 - 被突袭未成功。
   public final static int EGnGlobal_Unbeaten = 54;
   // 全局 - 被击败。
   public final static int EGnGlobal_Beaten = 55;
   // 全局 - 换领主。
   public final static int EGnGlobal_ChangeMaster = 56;
   // 全局 - 你已自由。
   public final static int EGnGlobal_Freedom = 57;
   // 全局 - 失去奴隶。
   public final static int EGnGlobal_LoseSlave = 58;
   // 全局 - 灵气池恢复。
   public final static int EGnGlobal_PlaceReady = 59;
   // 全局 - 新空闲神树精灵。
   public final static int EGnGlobal_WorkerReady = 60;
   // 全局 - 恐怖大王来袭。
   public final static int EGnGlobal_BossComing = 61;
   // 全局 - 指令错误。
   public final static int EGnGlobal_InvaildCommand = 62;
   // 全局 - 参数错误。
   public final static int EGnGlobal_ErrorCommandparameter = 63;
   // 全局 - 已是好友。
   public final static int EGnGlobal_AlreadyFriends = 65;
   // 全局 - 收税冷却。
   public final static int EGnGlobal_CollectCoolDown = 87;
   // 全局 - 成就奖励下周领取。
   public final static int EGnGlobal_NextWeek = 90;
   // 全局 - 未选择加速模式。
   public final static int EGnGlobal_SelectMode = 91;
   // 全局 - 不能升级技能。
   public final static int EGnGlobal_TrainSkillLimit = 92;
   // 全局 - 两次领奖之间的间隔时间不足。
   public final static int EGnGlobal_TimeSpanNotEnough = 93;
   // 全局 - 当天的奖励已经领完了。
   public final static int EGnGlobal_RewardFinish = 94;
   // 全局 - 成就组未全部达成。
   public final static int EGnGlobal_AchievementNotAllFinish = 95;
   // 全局 - 成就组奖励已领取。
   public final static int EGnGlobal_AchievementGroupIsRewarded = 96;
   // 全局 - 没有放置水晶。
   public final static int EGnGlobal_CrystalNotEnough = 97;
   // 全局 - 签到奖励已领取。
   public final static int EGnGlobal_RewardSignDayFinish = 98;
   // 全局 - 签到宝箱已领取。
   public final static int EGnGlobal_RewardSignStageFinish = 99;
   // 全局 - 补签次数已满。
   public final static int EGnGlobal_SignMonthChanceOver = 100;
   // 全局 - 每天只能补签一次。
   public final static int EGnGlobal_SignDayChanceOver = 101;
   // 全局 - 已经在训练了。
   public final static int EGnGlobal_IsInTraining = 106;
   // 全局 - 塔不是自己的不能取回。
   public final static int EGnGlobal_FortNotSelf = 108;
   // 全局 - 不能升级技能。
   public final static int EGnGlobal_TrainGodSkillLimit = 109;
   // 全局 - 经验已满。
   public final static int EGnGlobal_FortExperienceFull = 110;
   // 全局 - 购买的商品数量错误。
   public final static int EGnGlobal_BuyErrorCount = 111;
   // 全局 - 不能给不是自己的虫子加速。
   public final static int EGnGlobal_AccelerateAimError = 112;
   // 全局 - 玩家受保护不能突袭。
   public final static int EGnGlobal_CanNotRaidInLimitTime = 113;
   // 全局 - 频道限制不能发言。
   public final static int EGnGlobal_LimitChannel = 114;
   // 全局 - 玩家不存在或者不在线。
   public final static int EGnGlobal_PlayerOffline = 115;
   // 全局 - 虫虫已经满级。
   public final static int EGnGlobal_FortMaxLevel = 116;
   // 全局 - 技能已经满级。
   public final static int EGnGlobal_SkillMaxLevel = 117;
   // 全局 - 调戏次数已达上限。
   public final static int EGnGlobal_MolestCountLimit = 119;
   // 全局 - 不是属臣不能调戏。
   public final static int EGnGlobal_NotFootmanCanNotMolest = 120;
   // 全局 - 操作失败，装备未卸下！。
   public final static int EGnGlobal_EquipmentAttachOnNpc = 123;
   // 全局 - 装备已经满级。
   public final static int EGnGlobal_EquipmentMaxLevel = 124;

   //------------------------------------------------------------
   // 市场 - 不买自己的。
   public final static int EGnMarket_BuySelf = 79;
   // 市场 - 物品已经被买走。
   public final static int EGnMarket_BeenBought = 80;
   // 市场 - 市场空位不足。
   public final static int EGnMarket_SpaceNotEnough = 81;
   // 市场 - 必须输入出售的价格。。
   public final static int EGnMarket_MustEnterPrice = 82;
   // 市场 - 无效的卖单编号。
   public final static int EGnMarket_InvalidBillId = 83;
   // 市场 - 错误的操作。
   public final static int EGnMarket_ErrorOperation = 84;
   // 市场 - 交易已过期。
   public final static int EGnMarket_TradeOutOfDate = 86;

   //------------------------------------------------------------
   // 蝴蝶仓库 - 已经搜刮过了。
   public final static int EGnButterfly_CanNotTake = 102;
   // 蝴蝶仓库 - 先选择物品。
   public final static int EGnButterfly_ChooseFirst = 103;
}
