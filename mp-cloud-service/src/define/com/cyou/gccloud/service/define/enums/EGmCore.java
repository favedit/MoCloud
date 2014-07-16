//============================================================
// <T>游戏核心。</T>
//
// @version 1.0.1
//============================================================
package com.cyou.gccloud.service.define.enums;

//============================================================
// <T>游戏核心枚举定义。</T>
//
// @enum
//============================================================
public class EGmCore{

   //------------------------------------------------------------
   // 通知级别类型 - 未知。
   public final static int EGmNotifyLevel_Unknown = 0;
   // 通知级别类型 - 打印。
   public final static int EGmNotifyLevel_Print = 1;
   // 通知级别类型 - 提示。
   public final static int EGmNotifyLevel_Info = 2;
   // 通知级别类型 - 警告。
   public final static int EGmNotifyLevel_Warn = 3;
   // 通知级别类型 - 错误。
   public final static int EGmNotifyLevel_Error = 4;
   // 通知级别类型 - 例外。
   public final static int EGmNotifyLevel_Fatal = 5;

   //------------------------------------------------------------
   // 通知样式类型 - 未知。
   public final static int EGmNotifyStyle_Unknown = 0;
   // 通知样式类型 - 全局广播。
   public final static int EGmNotifyStyle_Broadcast1 = 1;
   // 通知样式类型 - 快捷提示。
   public final static int EGmNotifyStyle_Broadcast2 = 2;
   // 通知样式类型 - 错误。
   public final static int EGmNotifyStyle_PopupError = 3;
   // 通知样式类型 - 纯文本提示。
   public final static int EGmNotifyStyle_PopupNotify1 = 4;
   // 通知样式类型 - YES/NO。
   public final static int EGmNotifyStyle_PopupNotify2 = 5;
   // 通知样式类型 - 消耗需求提示。
   public final static int EGmNotifyStyle_PopupNotify3 = 6;
   // 通知样式类型 - 图标无按钮。
   public final static int EGmNotifyStyle_PopupNotify4 = 7;
   // 通知样式类型 - 物品类。
   public final static int EGmNotifyStyle_PopupNotify5 = 8;

   //------------------------------------------------------------
   // 家园建筑类型 - 未知。
   public final static int EGmHome_Unknown = 0;
   // 家园建筑类型 - 科技树。
   public final static int EGmHome_Tree = 1;
   // 家园建筑类型 - 训练营。
   public final static int EGmHome_TrainingCamp = 2;
   // 家园建筑类型 - 奴隶营。
   public final static int EGmHome_SlaveCamp = 3;
   // 家园建筑类型 - 图腾。
   public final static int EGmHome_Totem = 4;
   // 家园建筑类型 - 食物车。
   public final static int EGmHome_FoodCar = 5;
   // 家园建筑类型 - 祭坛。
   public final static int EGmHome_Altar = 6;
   // 家园建筑类型 - 种子。
   public final static int EGmHome_Seed = 7;
   // 家园建筑类型 - 飘灵气。
   public final static int EGmHome_Reiki = 8;
   // 家园建筑类型 - 蝴蝶窝。
   public final static int EGmHome_Butterfly = 9;

   //------------------------------------------------------------
   // 家园工人激活 - 未知。
   public final static int EGmHomeWorkerActivation_Unknown = 0;
   // 家园工人激活 - 锁定。
   public final static int EGmHomeWorkerActivation_Lock = 1;
   // 家园工人激活 - 打开。
   public final static int EGmHomeWorkerActivation_Open = 2;
   // 家园工人激活 - 关闭。
   public final static int EGmHomeWorkerActivation_Close = 3;

   //------------------------------------------------------------
   // 物品类型 - 未知。
   public final static int EGmItem_Unknown = 0;
   // 物品类型 - 道具。
   public final static int EGmItem_Prop = 1;
   // 物品类型 - 装备。
   public final static int EGmItem_Equip = 2;
   // 物品类型 - 技能。
   public final static int EGmItem_Skill = 3;
   // 物品类型 - 增益。
   public final static int EGmItem_Buff = 4;

   //------------------------------------------------------------
   // 物品类型 - 未知。
   public final static int EGmProp_Unknown = 0;
   // 物品类型 - 水晶类。
   public final static int EGmProp_Crystal = 1;
   // 物品类型 - 家园类。
   public final static int EGmProp_Home = 2;
   // 物品类型 - 激活类。
   public final static int EGmProp_Activate = 3;
   // 物品类型 - 钥匙类。
   public final static int EGmProp_Key = 4;
   // 物品类型 - 砸蛋类。
   public final static int EGmProp_HitEggs = 5;
   // 物品类型 - 属性类。
   public final static int EGmProp_ChangeProperty = 6;
   // 物品类型 - 其他类。
   public final static int EGmProp_Others = 7;
   // 物品类型 - 商城类。
   public final static int EGmProp_Bags = 8;
   // 物品类型 - 宠物类。
   public final static int EGmProp_Pet = 9;

   //------------------------------------------------------------
   // 全局定义 - 未知。
   public final static int EGmGlobal_Unknown = 0;
   // 全局定义 - 恐怖大王怨念。
   public final static int EGmGlobal_FearRate = 1;

   //------------------------------------------------------------
   // 角色类型 - 未知。
   public final static int EGmNpc_Unknown = 0;
   // 角色类型 - 防御塔。
   public final static int EGmNpc_Fort = 1;
   // 角色类型 - 士兵。
   public final static int EGmNpc_Soldier = 2;
   // 角色类型 - 助手。
   public final static int EGmNpc_Assistant = 3;
   // 角色类型 - 阻挡。
   public final static int EGmNpc_Block = 4;
   // 角色类型 - 英雄。
   public final static int EGmNpc_Hero = 5;
   // 角色类型 - 天神。
   public final static int EGmNpc_God = 6;
   // 角色类型 - 玩家。
   public final static int EGmNpc_Player = 7;
   // 角色类型 - 宠物。
   public final static int EGmNpc_Pet = 8;

   //------------------------------------------------------------
   // 角色敌人类型 - 未知。
   public final static int EGmNpcEnemy_Unknown = 0;
   // 角色敌人类型 - 普通。
   public final static int EGmNpcEnemy_Common = 1;
   // 角色敌人类型 - BOSS。
   public final static int EGmNpcEnemy_Boss = 2;

   //------------------------------------------------------------
   // 角色激活类型 - 未知。
   public final static int EGmNpcActivation_Unknown = 0;
   // 角色激活类型 - 开启。
   public final static int EGmNpcActivation_Open = 1;
   // 角色激活类型 - 关闭。
   public final static int EGmNpcActivation_Close = 2;

   //------------------------------------------------------------
   // 角色是否打空 - 未知。
   public final static int EGmNpcLevelAir_Unknown = 0;
   // 角色是否打空 - 打空。
   public final static int EGmNpcLevelAir_True = 1;
   // 角色是否打空 - 不打空。
   public final static int EGmNpcLevelAir_False = 2;

   //------------------------------------------------------------
   // 角色是否打地 - 未知。
   public final static int EGmNpcLevelLand_Unknown = 0;
   // 角色是否打地 - 打地。
   public final static int EGmNpcLevelLand_True = 1;
   // 角色是否打地 - 不打地。
   public final static int EGmNpcLevelLand_False = 2;

   //------------------------------------------------------------
   // 角色是否飞行 - 未知。
   public final static int EGmNpcLevelFly_Unknown = 0;
   // 角色是否飞行 - 飞行。
   public final static int EGmNpcLevelFly_True = 1;
   // 角色是否飞行 - 不飞行。
   public final static int EGmNpcLevelFly_False = 2;

   //------------------------------------------------------------
   // 角色是否冻结 - 未知。
   public final static int EGmNpcLevelFreeze_Unknown = 0;
   // 角色是否冻结 - 冻结。
   public final static int EGmNpcLevelFreeze_True = 1;
   // 角色是否冻结 - 不冻结。
   public final static int EGmNpcLevelFreeze_False = 2;

   //------------------------------------------------------------
   // 角色是否可见 - 未知。
   public final static int EGmNpcLevelVisible_Unknown = 0;
   // 角色是否可见 - 可见。
   public final static int EGmNpcLevelVisible_True = 1;
   // 角色是否可见 - 不可见。
   public final static int EGmNpcLevelVisible_False = 2;

   //------------------------------------------------------------
   // 角色是否受嘲讽 - 未知。
   public final static int EGmNpcLevelTaunt_Unknown = 0;
   // 角色是否受嘲讽 - 受蜗牛嘲讽。
   public final static int EGmNpcLevelTaunt_True = 1;
   // 角色是否受嘲讽 - 不受蜗牛嘲讽。
   public final static int EGmNpcLevelTaunt_False = 2;

   //------------------------------------------------------------
   // 地图奖励动作 - 未知。
   public final static int EGmMapRewardAction_Unknown = 0;
   // 地图奖励动作 - 通过。
   public final static int EGmMapRewardAction_Pass = 1;
   // 地图奖励动作 - 失败。
   public final static int EGmMapRewardAction_Failure = 2;

   //------------------------------------------------------------
   // 地图奖励类型 - 未知。
   public final static int EGmMapRewardType_Unknown = 0;
   // 地图奖励类型 - 开启塔。
   public final static int EGmMapRewardType_OpenFort = 1;
   // 地图奖励类型 - 神树经验。
   public final static int EGmMapRewardType_Experience = 2;
   // 地图奖励类型 - 开启建筑。
   public final static int EGmMapRewardType_OpenBuilding = 3;
   // 地图奖励类型 - 灵气。
   public final static int EGmMapRewardType_Reiki = 4;
   // 地图奖励类型 - 精华。
   public final static int EGmMapRewardType_Cream = 5;
   // 地图奖励类型 - 物品。
   public final static int EGmMapRewardType_Item = 6;

   //------------------------------------------------------------
   // 地图类型 - 未知。
   public final static int EGmMapType_Unknown = 0;
   // 地图类型 - 诱敌地图。
   public final static int EGmMapType_Raid = 1;
   // 地图类型 - 布阵地图。
   public final static int EGmMapType_Embattle = 2;
   // 地图类型 - 新手引导地图。
   public final static int EGmMapType_Study = 3;
   // 地图类型 - 联防地图。
   public final static int EGmMapType_Cooperate = 4;
   // 地图类型 - 竞技地图。
   public final static int EGmMapType_Sports = 5;

   //------------------------------------------------------------
   // 塔激活状态 - 未知。
   public final static int EGmFortActivation_Unknown = 0;
   // 塔激活状态 - 激活塔。
   public final static int EGmFortActivation_True = 1;
   // 塔激活状态 - 非激活塔。
   public final static int EGmFortActivation_False = 2;

   //------------------------------------------------------------
   // 位置激活状态 - 未知。
   public final static int EGmPlaceActivation_Unknown = 0;
   // 位置激活状态 - 激活。
   public final static int EGmPlaceActivation_True = 1;
   // 位置激活状态 - 非激活。
   public final static int EGmPlaceActivation_False = 2;

   //------------------------------------------------------------
   // 奴隶营位置类型 - 未知。
   public final static int EGmSlavePlaceType_Unknown = 0;
   // 奴隶营位置类型 - 普通位。
   public final static int EGmSlavePlaceType_Common = 1;
   // 奴隶营位置类型 - boss位。
   public final static int EGmSlavePlaceType_Boss = 2;

   //------------------------------------------------------------
   // 突袭结果 - 未知。
   public final static int EGmRaidResult_Unknown = 0;
   // 突袭结果 - 占领。
   public final static int EGmRaidResult_Occupy = 1;
   // 突袭结果 - 击退。
   public final static int EGmRaidResult_Repel = 2;
   // 突袭结果 - 放弃。
   public final static int EGmRaidResult_Cancel = 3;
   // 突袭结果 - 开始。
   public final static int EGmRaidResult_Start = 4;

   //------------------------------------------------------------
   // 诱敌动员令 - 未知。
   public final static int EGmTokenDefense_Unknown = 0;
   // 诱敌动员令 - 1级。
   public final static int EGmTokenDefense_Level1 = 1;
   // 诱敌动员令 - 2级。
   public final static int EGmTokenDefense_Level2 = 2;
   // 诱敌动员令 - 3级。
   public final static int EGmTokenDefense_Level3 = 3;

   //------------------------------------------------------------
   // 突袭动员令 - 未知。
   public final static int EGmTokenRaid_Unknown = 0;
   // 突袭动员令 - 1级。
   public final static int EGmTokenRaid_Level1 = 1;
   // 突袭动员令 - 2级。
   public final static int EGmTokenRaid_Level2 = 2;
   // 突袭动员令 - 3级。
   public final static int EGmTokenRaid_Level3 = 3;

   //------------------------------------------------------------
   // 令牌产出渠道类型 - 未知。
   public final static int EGmProduct_Unknown = 0;
   // 令牌产出渠道类型 - 系统产出。
   public final static int EGmProduct_System = 1;
   // 令牌产出渠道类型 - 人民币购买。
   public final static int EGmProduct_Rmb = 2;

   //------------------------------------------------------------
   // 任务类型 - 未知。
   public final static int EGmTaskType_Unknown = 0;
   // 任务类型 - 普通任务。
   public final static int EGmTaskType_Common = 1;
   // 任务类型 - 每日任务。
   public final static int EGmTaskType_EveryDay = 2;

   //------------------------------------------------------------
   // 任务目标类型 - 未知。
   public final static int EGmTaskTarget_Unknown = 0;
   // 任务目标类型 - NPC升级至。
   public final static int EGmTaskTarget_NpcUpgrade = 1;
   // 任务目标类型 - NPC技能升级至。
   public final static int EGmTaskTarget_SkillUpgrade = 2;
   // 任务目标类型 - 家园建筑升级至。
   public final static int EGmTaskTarget_BuildingUpgrade = 3;
   // 任务目标类型 - 消耗诱捕动员令。
   public final static int EGmTaskTarget_DefenceToken = 4;
   // 任务目标类型 - 消耗突袭动员令。
   public final static int EGmTaskTarget_RaidToken = 5;
   // 任务目标类型 - 成功诱捕。
   public final static int EGmTaskTarget_DefenceWin = 6;
   // 任务目标类型 - 成功突袭。
   public final static int EGmTaskTarget_RaidWin = 7;
   // 任务目标类型 - 捕获奴隶。
   public final static int EGmTaskTarget_CatchSlaves = 8;
   // 任务目标类型 - 搜集某物品。
   public final static int EGmTaskTarget_CollectItems = 9;
   // 任务目标类型 - 开启新关卡。
   public final static int EGmTaskTarget_OpenMap = 10;
   // 任务目标类型 - 地图某难度。
   public final static int EGmTaskTarget_MapDifficulty = 11;

   //------------------------------------------------------------
   // 任务状态类型 - 未知。
   public final static int EGmTaskStatus_Unknown = 0;
   // 任务状态类型 - 可接受。
   public final static int EGmTaskStatus_Acceptable = 1;
   // 任务状态类型 - 工作中。
   public final static int EGmTaskStatus_Working = 2;
   // 任务状态类型 - 可完成。
   public final static int EGmTaskStatus_Finish = 3;

   //------------------------------------------------------------
   // 任务结果类型 - 未知。
   public final static int EGmTaskResult_Unknown = 0;
   // 任务结果类型 - 未完成的。
   public final static int EGmTaskResult_Uncomplete = 1;
   // 任务结果类型 - 已完成的。
   public final static int EGmTaskResult_Complete = 2;

   //------------------------------------------------------------
   // 好友占领状态 - 未知。
   public final static int EGmFriendOccupyStatus_Unknown = 0;
   // 好友占领状态 - 未占领的。
   public final static int EGmFriendOccupyStatus_UnOccupied = 1;
   // 好友占领状态 - 已占领的。
   public final static int EGmFriendOccupyStatus_Occupied = 2;

   //------------------------------------------------------------
   // 好友关系类型 - 未知。
   public final static int EGmFriendRelation_Unknown = 0;
   // 好友关系类型 - 我的领主。
   public final static int EGmFriendRelation_Laird = 1;
   // 好友关系类型 - 我的仆从。
   public final static int EGmFriendRelation_Footman = 2;

   //------------------------------------------------------------
   // 好友关系类型 - 未知。
   public final static int EGmBuffEffect_Unknown = 0;
   // 好友关系类型 - 改变属性。
   public final static int EGmBuffEffect_ChangeProperty = 1;
   // 好友关系类型 - 顶种子。
   public final static int EGmBuffEffect_CarrySeed = 2;

   //------------------------------------------------------------
   // 技能条件 - 未知。
   public final static int EGmSkillCondition_Unknown = 0;
   // 技能条件 - 攻击。
   public final static int EGmSkillCondition_Attack = 1;
   // 技能条件 - 被攻击。
   public final static int EGmSkillCondition_BeAttack = 2;
   // 技能条件 - 每减血百分比。
   public final static int EGmSkillCondition_HpDecRate = 3;
   // 技能条件 - 血值降低百分比触发。
   public final static int EGmSkillCondition_HpLowerRate = 4;
   // 技能条件 - 每间隔一定时间。
   public final static int EGmSkillCondition_IntervalTime = 5;
   // 技能条件 - 死亡。
   public final static int EGmSkillCondition_Dead = 6;
   // 技能条件 - 进入种子基地。
   public final static int EGmSkillCondition_EnterSeedBase = 7;
   // 技能条件 - 总是。
   public final static int EGmSkillCondition_Always = 8;
   // 技能条件 - 鞭挞。
   public final static int EGmSkillCondition_Lash = 9;
   // 技能条件 - 按钮。
   public final static int EGmSkillCondition_Button = 10;

   //------------------------------------------------------------
   // 技能目标组 - 未知。
   public final static int EGmSkillTargetGroup_Unknown = 0;
   // 技能目标组 - 敌方。
   public final static int EGmSkillTargetGroup_Enemy = 1;
   // 技能目标组 - 己方。
   public final static int EGmSkillTargetGroup_Own = 2;
   // 技能目标组 - 敌方喽啰。
   public final static int EGmSkillTargetGroup_EnemyCommon = 3;
   // 技能目标组 - 敌方BOSS。
   public final static int EGmSkillTargetGroup_EnemyBoss = 4;
   // 技能目标组 - 己方同伴。
   public final static int EGmSkillTargetGroup_OwnFriend = 5;
   // 技能目标组 - 己方自己。
   public final static int EGmSkillTargetGroup_OwnOneself = 6;

   //------------------------------------------------------------
   // 技能目标类型 - 未知。
   public final static int EGmSkillTarget_Unknown = 0;
   // 技能目标类型 - 固定数量。
   public final static int EGmSkillTarget_Count = 1;
   // 技能目标类型 - 以自己为中心的某半径范围内。
   public final static int EGmSkillTarget_OneselfCenter = 2;
   // 技能目标类型 - 全屏。
   public final static int EGmSkillTarget_FullScreen = 3;
   // 技能目标类型 - 以鼠标落点为中心的某半径范围内。
   public final static int EGmSkillTarget_MousePointCenter = 4;
   // 技能目标类型 - 改变游戏属性值。
   public final static int EGmSkillTarget_ChangeGameProperty = 5;

   //------------------------------------------------------------
   // 技能效果 - 未知。
   public final static int EGmSkillEffect_Unknown = 0;
   // 技能效果 - 普通攻击。
   public final static int EGmSkillEffect_NormalDamage = 1;
   // 技能效果 - 多倍伤害。
   public final static int EGmSkillEffect_Crit = 2;
   // 技能效果 - 区域伤害。
   public final static int EGmSkillEffect_RegionDamage = 3;
   // 技能效果 - 溅射伤害（以作用目标为中心）。
   public final static int EGmSkillEffect_SplashDamage = 4;
   // 技能效果 - 改变属性。
   public final static int EGmSkillEffect_ChangeProperty = 5;
   // 技能效果 - 增加指定BUFF。
   public final static int EGmSkillEffect_AddBuff = 6;
   // 技能效果 - 取消指定BUFF。
   public final static int EGmSkillEffect_DecBuff = 7;
   // 技能效果 - 取消所有BUFF。
   public final static int EGmSkillEffect_DecAllBuff = 8;
   // 技能效果 - 召唤。
   public final static int EGmSkillEffect_Summon = 9;
   // 技能效果 - 片伤（以某点为中心多体作用）。
   public final static int EGmSkillEffect_Aoe = 10;

   //------------------------------------------------------------
   // 技能CD时间类型 - 未知。
   public final static int EGmSkillCdTime_Unknown = 0;
   // 技能CD时间类型 - 共享。
   public final static int EGmSkillCdTime_Share = 1;
   // 技能CD时间类型 - 互斥。
   public final static int EGmSkillCdTime_Mutex = 2;

   //------------------------------------------------------------
   // 任务快捷键类型 - 未知。
   public final static int EGmTaskSpeedButton_Unknown = 0;
   // 任务快捷键类型 - 打开训练营。
   public final static int EGmTaskSpeedButton_Training = 1;
   // 任务快捷键类型 - 打开训练营升级界面。
   public final static int EGmTaskSpeedButton_TrainingUpgrade = 2;
   // 任务快捷键类型 - 打开奴隶营升级界面。
   public final static int EGmTaskSpeedButton_SlaveUpgrade = 3;
   // 任务快捷键类型 - 打开奴隶营界面。
   public final static int EGmTaskSpeedButton_Slave = 4;
   // 任务快捷键类型 - 打开祭坛升级界面。
   public final static int EGmTaskSpeedButton_AltarUpgrade = 5;
   // 任务快捷键类型 - 打开灵气池升级界面。
   public final static int EGmTaskSpeedButton_ReikiUpgrade = 6;
   // 任务快捷键类型 - 打开蝴蝶窝升级界面。
   public final static int EGmTaskSpeedButton_ButterflyUpgrade = 7;
   // 任务快捷键类型 - 打开种子基地升级界面。
   public final static int EGmTaskSpeedButton_SeedUpgrade = 8;
   // 任务快捷键类型 - 打开食物车升级界面。
   public final static int EGmTaskSpeedButton_FoodCarUpgrade = 9;
   // 任务快捷键类型 - 打开诱捕备战界面。
   public final static int EGmTaskSpeedButton_Defense = 10;
   // 任务快捷键类型 - 打开突袭备战界面。
   public final static int EGmTaskSpeedButton_Raid = 11;
   // 任务快捷键类型 - 打开布阵备战界面。
   public final static int EGmTaskSpeedButton_Embattle = 12;

   //------------------------------------------------------------
   // 实体属性 - 未知。
   public final static int EGmEntityProperty_Unknown = 0;
   // 实体属性 - 食物。
   public final static int EGmEntityProperty_Food = 1;
   // 实体属性 - 血值上限。
   public final static int EGmEntityProperty_HpMax = 2;
   // 实体属性 - 血值。
   public final static int EGmEntityProperty_Hp = 3;
   // 实体属性 - 攻击速度。
   public final static int EGmEntityProperty_AttackSpeed = 4;
   // 实体属性 - 攻击力。
   public final static int EGmEntityProperty_AttackPower = 5;
   // 实体属性 - 命中率。
   public final static int EGmEntityProperty_HitRate = 6;
   // 实体属性 - 移动速度。
   public final static int EGmEntityProperty_MoveSpeed = 7;
   // 实体属性 - 是否飞行。
   public final static int EGmEntityProperty_FlyCd = 8;
   // 实体属性 - 是否冻结。
   public final static int EGmEntityProperty_FreezeCd = 9;
   // 实体属性 - 是否可见。
   public final static int EGmEntityProperty_VisibleCd = 10;
   // 实体属性 - 防御力。
   public final static int EGmEntityProperty_DefensePower = 11;
   // 实体属性 - 被嘲讽。
   public final static int EGmEntityProperty_Taunt = 12;
   // 实体属性 - 祭祀食物。
   public final static int EGmEntityProperty_Mp = 13;
   // 实体属性 - 天火点。
   public final static int EGmEntityProperty_FirePoint = 14;
   // 实体属性 - 精华点。
   public final static int EGmEntityProperty_CreamPoint = 15;
   // 实体属性 - 神树经验。
   public final static int EGmEntityProperty_TreeExperience = 16;
   // 实体属性 - 灵气点。
   public final static int EGmEntityProperty_ReikiPoint = 17;
   // 实体属性 - 1级诱敌动员令绑定。
   public final static int EGmEntityProperty_TokenDefenseBind1 = 19;
   // 实体属性 - 2级诱敌动员令绑定。
   public final static int EGmEntityProperty_TokenDefenseBind2 = 20;
   // 实体属性 - 3级诱敌动员令绑定。
   public final static int EGmEntityProperty_TokenDefenseBind3 = 21;
   // 实体属性 - 1级诱敌动员令(RMB)。
   public final static int EGmEntityProperty_TokenDefenseUnbind1 = 22;
   // 实体属性 - 2级诱敌动员令(RMB)。
   public final static int EGmEntityProperty_TokenDefenseUnbind2 = 23;
   // 实体属性 - 3级诱敌动员令(RMB)。
   public final static int EGmEntityProperty_TokenDefenseUnbind3 = 24;
   // 实体属性 - 1级突袭动员令(绑定)。
   public final static int EGmEntityProperty_TokenRaidBind1 = 25;
   // 实体属性 - 2级突袭动员令绑定。
   public final static int EGmEntityProperty_TokenRaidBind2 = 26;
   // 实体属性 - 3级突袭动员令绑定。
   public final static int EGmEntityProperty_TokenRaidBind3 = 27;
   // 实体属性 - 1级突袭动员令(RMB)。
   public final static int EGmEntityProperty_TokenRaidUnbind1 = 28;
   // 实体属性 - 2级突袭动员令(RMB)。
   public final static int EGmEntityProperty_TokenRaidUnbind2 = 29;
   // 实体属性 - 3级突袭动员令(RMB)。
   public final static int EGmEntityProperty_TokenRaidUnbind3 = 30;
   // 实体属性 - 防御虫虫经验。
   public final static int EGmEntityProperty_FortExperience = 31;

   //------------------------------------------------------------
   // 角色buff关联类型 - 未知。
   public final static int EGmBuffRelevance_Unknown = 0;
   // 角色buff关联类型 - 食物。
   public final static int EGmBuffRelevance_Skill = 1;

   //------------------------------------------------------------
   // 角色buff关联类型 - 未知。
   public final static int EGmBuffType_Unknown = 0;
   // 角色buff关联类型 - 光环类。
   public final static int EGmBuffType_Aura = 1;

   //------------------------------------------------------------

   //------------------------------------------------------------
   // 技能是否可训练 - 未知。
   public final static int EGmSkillTraining_Unknown = 0;
   // 技能是否可训练 - 可升级技能。
   public final static int EGmSkillTraining_True = 1;
   // 技能是否可训练 - 不可升级技能。
   public final static int EGmSkillTraining_False = 2;

   //------------------------------------------------------------
   // buff对齐方式 - 未知。
   public final static int EGmBuffAlign_Unknown = 0;
   // buff对齐方式 - 重心点对齐。
   public final static int EGmBuffAlign_Center = 1;
   // buff对齐方式 - 头顶。
   public final static int EGmBuffAlign_MaxY = 2;
   // buff对齐方式 - 脚底。
   public final static int EGmBuffAlign_MinY = 3;

   //------------------------------------------------------------
   // 离线消息类型 - 未知。
   public final static int EGmOfflineMessageType_Unknown = 0;
   // 离线消息类型 - 变成仆从。
   public final static int EGmOfflineMessageType_BecomeFootman = 1;
   // 离线消息类型 - 仆从逃逸。
   public final static int EGmOfflineMessageType_FootmanEscape = 2;
   // 离线消息类型 - 仆从改变领主。
   public final static int EGmOfflineMessageType_FootmanChangeLaird = 3;
   // 离线消息类型 - 防御成功。
   public final static int EGmOfflineMessageType_DefenceSuccess = 4;
   // 离线消息类型 - 恐怖大王突袭。
   public final static int EGmOfflineMessageType_TerrorKingRaid = 5;
   // 离线消息类型 - 领主收税。
   public final static int EGmOfflineMessageType_LairdTax = 6;
   // 离线消息类型 - 唤醒蝴蝶。
   public final static int EGmOfflineMessageType_WakenButterfly = 7;
   // 离线消息类型 - 交易成功。
   public final static int EGmOfflineMessageType_TransactionSuccess = 8;
   // 离线消息类型 - 属臣成为你的领主。
   public final static int EGmOfflineMessageType_FootmanBecomeLaird = 9;
   // 离线消息类型 - 领主拿走蝴蝶仓库物品。
   public final static int EGmOfflineMessageType_ButterflyWarehouse = 10;

   //------------------------------------------------------------
   // 技能消耗类型 - 未知。
   public final static int EGmSkillExpend_Unknown = 0;
   // 技能消耗类型 - 生命值。
   public final static int EGmSkillExpend_Hp = 1;
   // 技能消耗类型 - 魔法值。
   public final static int EGmSkillExpend_Mp = 2;

   //------------------------------------------------------------
   // 加速事件类型 - 未知。
   public final static int EGmAccelerateEventType_Unknown = 0;
   // 加速事件类型 - 工人加速。
   public final static int EGmAccelerateEventType_Worker = 1;
   // 加速事件类型 - 训练位置加速。
   public final static int EGmAccelerateEventType_TrainingPlace = 2;

   //------------------------------------------------------------
   // 新手引导触发类型 - 未知。
   public final static int EGmStudyCondition_Unknown = 0;
   // 新手引导触发类型 - 第一次进入游戏。
   public final static int EGmStudyCondition_FirstEnter = 1;
   // 新手引导触发类型 - 首次进入地图。
   public final static int EGmStudyCondition_FirstEnterMap = 2;
   // 新手引导触发类型 - 首次地图胜利离开。
   public final static int EGmStudyCondition_MapWin = 3;
   // 新手引导触发类型 - 首次地图失败离开。
   public final static int EGmStudyCondition_MapLose = 4;
   // 新手引导触发类型 - 首次出现某种敌人。
   public final static int EGmStudyCondition_Slave = 5;
   // 新手引导触发类型 - 首次丢失种子。
   public final static int EGmStudyCondition_FirstLostSeed = 6;
   // 新手引导触发类型 - 第一次放塔在路上。
   public final static int EGmStudyCondition_BuildTowerOnRoad = 7;
   // 新手引导触发类型 - 首次塔数大于塔位。
   public final static int EGmStudyCondition_TowerPlaceOverflow = 8;
   // 新手引导触发类型 - 首次有虫子眩晕。
   public final static int EGmStudyCondition_FirstDizzy = 9;
   // 新手引导触发类型 - 首次掉落箱子。
   public final static int EGmStudyCondition_FirstDropBox = 10;
   // 新手引导触发类型 - 首次诱捕胜利。
   public final static int EGmStudyCondition_FirstDefenseSuccess = 11;
   // 新手引导触发类型 - 首次突袭胜利。
   public final static int EGmStudyCondition_FirstRaidSuccess = 12;
   // 新手引导触发类型 - 首次进入外太空场景。
   public final static int EGmStudyCondition_FirstEnterDefenseWorld = 13;
   // 新手引导触发类型 - 首次进入培养营。
   public final static int EGmStudyCondition_FirstEnterTrainingScene = 14;
   // 新手引导触发类型 - 首次进入奴隶营。
   public final static int EGmStudyCondition_FirstEnterSlaveScene = 15;
   // 新手引导触发类型 - 首次进入布阵场景。
   public final static int EGmStudyCondition_FirstEnterEmbattleScene = 16;
   // 新手引导触发类型 - 首次进入突袭备战场景。
   public final static int EGmStudyCondition_FirstEnterRaidPreparationScene = 17;
   // 新手引导触发类型 - 首次进入突袭场景。
   public final static int EGmStudyCondition_FirstEnterRaidScene = 18;

   //------------------------------------------------------------
   // 技能buff互斥 - 未知。
   public final static int EGmSkillBuffMutex_Unknown = 0;
   // 技能buff互斥 - 兼容。
   public final static int EGmSkillBuffMutex_Join = 1;
   // 技能buff互斥 - 互斥。
   public final static int EGmSkillBuffMutex_Metux = 2;

   //------------------------------------------------------------
   // NPC种族 - 未知。
   public final static int EGmNpcRace_Unknown = 0;
   // NPC种族 - 甲虫家族。
   public final static int EGmNpcRace_Beetle = 1;
   // NPC种族 - 蜻蜓家族。
   public final static int EGmNpcRace_Odonate = 2;
   // NPC种族 - 螳螂家族。
   public final static int EGmNpcRace_Mantis = 3;
   // NPC种族 - 竹节家族。
   public final static int EGmNpcRace_Phasmidae = 4;
   // NPC种族 - 马蜂家族。
   public final static int EGmNpcRace_Bee = 5;
   // NPC种族 - 毛毛虫族。
   public final static int EGmNpcRace_Caterpillar = 6;
   // NPC种族 - 虫草家族。
   public final static int EGmNpcRace_Slurperon = 7;
   // NPC种族 - 蜘蛛家族。
   public final static int EGmNpcRace_Spider = 8;
   // NPC种族 - 蚂蚁家族。
   public final static int EGmNpcRace_Ant = 9;
   // NPC种族 - 蟑螂家族。
   public final static int EGmNpcRace_Roach = 10;
   // NPC种族 - 蜗牛家族。
   public final static int EGmNpcRace_Snail = 11;
   // NPC种族 - 萤火虫族。
   public final static int EGmNpcRace_Firefly = 12;
   // NPC种族 - 菜青虫族。
   public final static int EGmNpcRace_PierisRapae = 13;
   // NPC种族 - 蚊子家族。
   public final static int EGmNpcRace_Mosquito = 14;
   // NPC种族 - 蝴蝶家族。
   public final static int EGmNpcRace_Butterfly = 15;
   // NPC种族 - 人族。
   public final static int EGmNpcRace_Human = 16;

   //------------------------------------------------------------
   // 技能类型 - 未知。
   public final static int EGmSkillType_Unknown = 0;
   // 技能类型 - 塔技能。
   public final static int EGmSkillType_TowerSkill = 1;
   // 技能类型 - 神技。
   public final static int EGmSkillType_GodSkill = 2;

   //------------------------------------------------------------
   // 新鲜事触发条件 - 未知。
   public final static int EGmFeedCondition_Unknown = 0;
   // 新鲜事触发条件 - 玩家等级达到N级。
   public final static int EGmFeedCondition_PlayerLevel = 1;
   // 新鲜事触发条件 - 虫虫达到某等级。
   public final static int EGmFeedCondition_Tower = 3;
   // 新鲜事触发条件 - 建筑达到某等级。
   public final static int EGmFeedCondition_Building = 4;
   // 新鲜事触发条件 - 一血。
   public final static int EGmFeedCondition_FirstBlood = 5;
   // 新鲜事触发条件 - 地图上榜。
   public final static int EGmFeedCondition_MapRanking = 6;

   //------------------------------------------------------------
   // 道具使用效果 - 未知。
   public final static int EGmPropEffect_Unknown = 0;
   // 道具使用效果 - 激活防守虫虫。
   public final static int EGmPropEffect_ActivateFort = 1;
   // 道具使用效果 - 激活建筑。
   public final static int EGmPropEffect_ActivateBuilding = 2;
   // 道具使用效果 - 激活地图点。
   public final static int EGmPropEffect_ActivateMap = 3;
   // 道具使用效果 - 进入隐藏地图。
   public final static int EGmPropEffect_AccessHiddenMap = 4;
   // 道具使用效果 - 获得物品包。
   public final static int EGmPropEffect_GetItemBag = 5;
   // 道具使用效果 - 改变属性。
   public final static int EGmPropEffect_ChangeProperty = 6;
   // 道具使用效果 - 激活技能。
   public final static int EGmPropEffect_ActivateGodSkill = 7;
   // 道具使用效果 - 延长技能有效时间。
   public final static int EGmPropEffect_DelaySkillTime = 8;

   //------------------------------------------------------------
   // 技能结算类型 - 未知。
   public final static int EGmSkillClosing_Unknown = 0;
   // 技能结算类型 - 立即结算。
   public final static int EGmSkillClosing_Instant = 1;
   // 技能结算类型 - 延迟结算。
   public final static int EGmSkillClosing_Delay = 2;

   //------------------------------------------------------------
   // 电影暂停 - 未知。
   public final static int EGmMoviePause_Unknown = 0;
   // 电影暂停 - 有电影暂停。
   public final static int EGmMoviePause_True = 1;
   // 电影暂停 - 无电影暂停。
   public final static int EGmMoviePause_False = 2;

   //------------------------------------------------------------
   // 引导类型 - 未知。
   public final static int EGmGuideType_Unknown = 0;
   // 引导类型 - 电影。
   public final static int EGmGuideType_Movie = 1;
   // 引导类型 - 消息。
   public final static int EGmGuideType_Message = 2;

   //------------------------------------------------------------
   // 角色等阶 - 未知。
   public final static int EGmNpcClass_Unknown = 0;
   // 角色等阶 - 普通虫子。
   public final static int EGmNpcClass_Common = 1;
   // 角色等阶 - 神虫子。
   public final static int EGmNpcClass_Class1 = 2;
   // 角色等阶 - 超神虫子。
   public final static int EGmNpcClass_Class2 = 3;

   //------------------------------------------------------------
   // 服务器状态 - 未知。
   public final static int EGmServerStatus_Unknown = 0;
   // 服务器状态 - 在线。
   public final static int EGmServerStatus_Online = 1;
   // 服务器状态 - 离线。
   public final static int EGmServerStatus_Offline = 2;

   //------------------------------------------------------------
   // 账号状态 - 未知。
   public final static int EGmAccountStatus_Unknown = 0;
   // 账号状态 - 封锁。
   public final static int EGmAccountStatus_Close = 1;
   // 账号状态 - 冻结。
   public final static int EGmAccountStatus_Freezing = 2;
   // 账号状态 - 激活。
   public final static int EGmAccountStatus_Activation = 3;

   //------------------------------------------------------------
   // 角色状态 - 未知。
   public final static int EGmRoleStatus_Unknown = 0;
   // 角色状态 - 离线。
   public final static int EGmRoleStatus_Offline = 1;
   // 角色状态 - 在线。
   public final static int EGmRoleStatus_Online = 2;
   // 角色状态 - 删除。
   public final static int EGmRoleStatus_Delete = 3;
   // 角色状态 - 冻结。
   public final static int EGmRoleStatus_Freezing = 4;
   // 角色状态 - 激活。
   public final static int EGmRoleStatus_Activation = 5;

   //------------------------------------------------------------
   // 角色标记 - 未知。
   public final static int EGmRoleDetailFlag_Unknown = 0x0;
   // 角色标记 - 进入地图记录。
   public final static int EGmRoleDetailFlag_EnterMapRecord = 0x0001;
   // 角色标记 - 进入突袭记录。
   public final static int EGmRoleDetailFlag_EnterRaidRecord = 0x0002;
   // 角色标记 - 角色升级标记。
   public final static int EGmRoleDetailFlag_LevelUpRecord = 0x0004;
   // 角色标记 - 蝴蝶窝升级标记。
   public final static int EGmRoleDetailFlag_ButterflyLevelUpRecord = 0x0008;

   //------------------------------------------------------------
   // 地图是否激活 - 未知。
   public final static int EGmMapActivation_Unknown = 0;
   // 地图是否激活 - 激活。
   public final static int EGmMapActivation_True = 1;
   // 地图是否激活 - 非激活。
   public final static int EGmMapActivation_False = 2;

   //------------------------------------------------------------
   // 奴隶营房间激活 - 未知。
   public final static int EGmSlaveRoomActivation_Unknown = 0;
   // 奴隶营房间激活 - 激活塔。
   public final static int EGmSlaveRoomActivation_True = 1;
   // 奴隶营房间激活 - 非激活塔。
   public final static int EGmSlaveRoomActivation_False = 2;

   //------------------------------------------------------------
   // 布阵所选地图的规模 - 未知。
   public final static int EGmEmbattleScale_Unknown = 0;
   // 布阵所选地图的规模 - 微型。
   public final static int EGmEmbattleScale_Mini = 1;
   // 布阵所选地图的规模 - 小型。
   public final static int EGmEmbattleScale_Small = 2;
   // 布阵所选地图的规模 - 中型。
   public final static int EGmEmbattleScale_Medium = 3;
   // 布阵所选地图的规模 - 大型。
   public final static int EGmEmbattleScale_Large = 4;
   // 布阵所选地图的规模 - 超大型。
   public final static int EGmEmbattleScale_ExtraLarge = 5;
   // 布阵所选地图的规模 - 巨型。
   public final static int EGmEmbattleScale_Giant = 6;

   //------------------------------------------------------------
   // 布阵所选地图出兵口数量 - 未知。
   public final static int EGmEmbattleCrossing_Unkonwn = 0;
   // 布阵所选地图出兵口数量 - 1个。
   public final static int EGmEmbattleCrossing_One = 1;
   // 布阵所选地图出兵口数量 - 2个。
   public final static int EGmEmbattleCrossing_Two = 2;
   // 布阵所选地图出兵口数量 - 3个。
   public final static int EGmEmbattleCrossing_Three = 3;
   // 布阵所选地图出兵口数量 - 4个。
   public final static int EGmEmbattleCrossing_Four = 4;
   // 布阵所选地图出兵口数量 - 5个。
   public final static int EGmEmbattleCrossing_Five = 5;
   // 布阵所选地图出兵口数量 - 更多。
   public final static int EGmEmbattleCrossing_More = 6;

   //------------------------------------------------------------
   // 角色占领状态 - 未知。
   public final static int EGmOccupyStatus_Unknown = 0;
   // 角色占领状态 - 未占领的。
   public final static int EGmOccupyStatus_UnOccupied = 1;
   // 角色占领状态 - 已占领的。
   public final static int EGmOccupyStatus_Occupied = 2;

   //------------------------------------------------------------
   // 统治关系类型 - 未知。
   public final static int EGmOverlordRelation_Unknown = 0;
   // 统治关系类型 - 我的领主。
   public final static int EGmOverlordRelation_Laird = 1;
   // 统治关系类型 - 我的仆从。
   public final static int EGmOverlordRelation_Footman = 2;

   //------------------------------------------------------------
   // 社交关系 - 未知。
   public final static int EGmCommunityRelation_Unknown = 0;
   // 社交关系 - 好友。
   public final static int EGmCommunityRelation_Friend = 1;
   // 社交关系 - 陌生人。
   public final static int EGmCommunityRelation_Stranger = 2;

   //------------------------------------------------------------
   // BUFF - 未知。
   public final static int EGmBuff_Unknown = 0;
   // BUFF - 眩晕。
   public final static int EGmBuff_Vertigo = 1;

   //------------------------------------------------------------
   // 任务操作 - 未知。
   public final static int EGmTaskOperation_Unknown = 0;
   // 任务操作 - 完成提交。
   public final static int EGmTaskOperation_Complete = 1;
   // 任务操作 - 任务取消。
   public final static int EGmTaskOperation_Cancel = 2;

   //------------------------------------------------------------
   // 集合标志 - 未知。
   public final static int EGmCollectionFlag_Unknown = 0;
   // 集合标志 - 新开启。
   public final static int EGmCollectionFlag_Open = 1;
   // 集合标志 - 升级。
   public final static int EGmCollectionFlag_Upgrade = 2;
   // 集合标志 - 降级。
   public final static int EGmCollectionFlag_Degrade = 3;

   //------------------------------------------------------------
   // 状态效果 - 未知。
   public final static int EGmBufferEffect_Unknown = 0;
   // 状态效果 - 改变属性。
   public final static int EGmBufferEffect_ChangeProperty = 1;
   // 状态效果 - 顶种子。
   public final static int EGmBufferEffect_CarrySeed = 2;

   //------------------------------------------------------------
   // 管理员命令改变玩家属性 - 未知。
   public final static int EGmManagerChangeRoleProperty_Unknown = 0;
   // 管理员命令改变玩家属性 - 添加天火点。
   public final static int EGmManagerChangeRoleProperty_AddPointFire = 1;
   // 管理员命令改变玩家属性 - 添加灵气点。
   public final static int EGmManagerChangeRoleProperty_AddPointReiki = 2;
   // 管理员命令改变玩家属性 - 添加精华点。
   public final static int EGmManagerChangeRoleProperty_AddPointCream = 3;
   // 管理员命令改变玩家属性 - 添加神树经验。
   public final static int EGmManagerChangeRoleProperty_AddExperience = 4;
   // 管理员命令改变玩家属性 - 添加统治力。
   public final static int EGmManagerChangeRoleProperty_AddOverlord = 5;
   // 管理员命令改变玩家属性 - 添加繁荣点。
   public final static int EGmManagerChangeRoleProperty_AddProsperity = 6;
   // 管理员命令改变玩家属性 - 添加一级诱捕动员令。
   public final static int EGmManagerChangeRoleProperty_AddDefenseUnbind1 = 7;
   // 管理员命令改变玩家属性 - 添加二级诱捕动员令。
   public final static int EGmManagerChangeRoleProperty_AddDefenseUnbind2 = 8;
   // 管理员命令改变玩家属性 - 添加三级诱捕动员令。
   public final static int EGmManagerChangeRoleProperty_AddDefenseUnbind3 = 9;
   // 管理员命令改变玩家属性 - 添加一级突袭动员令。
   public final static int EGmManagerChangeRoleProperty_AddRaidUnbind1 = 10;
   // 管理员命令改变玩家属性 - 添加二级突袭动员令。
   public final static int EGmManagerChangeRoleProperty_AddRaidUnbind2 = 11;
   // 管理员命令改变玩家属性 - 添加三级突袭动员令。
   public final static int EGmManagerChangeRoleProperty_AddRaidUnbind3 = 12;

   //------------------------------------------------------------
   // 管理员指令 - 未知。
   public final static int EGmManagerCommand_Unknown = 0;
   // 管理员指令 - 添加神树经验。
   public final static int EGmManagerCommand_AddExperience = 1;
   // 管理员指令 - 添加统治力。
   public final static int EGmManagerCommand_AddOverlord = 2;
   // 管理员指令 - 添加繁荣点。
   public final static int EGmManagerCommand_AddProsperity = 3;
   // 管理员指令 - 添加天火点。
   public final static int EGmManagerCommand_AddPointFire = 4;
   // 管理员指令 - 添加灵气点。
   public final static int EGmManagerCommand_AddPointReiki = 5;
   // 管理员指令 - 添加精华点。
   public final static int EGmManagerCommand_AddPointCream = 6;
   // 管理员指令 - 添加奴隶。
   public final static int EGmManagerCommand_AddSlave = 7;
   // 管理员指令 - 添加好友。
   public final static int EGmManagerCommand_AddFriend = 8;
   // 管理员指令 - 添加仆从。
   public final static int EGmManagerCommand_AddFootman = 9;
   // 管理员指令 - 清除工人工作时间。
   public final static int EGmManagerCommand_ClearWorkerTime = 10;
   // 管理员指令 - 添加道具。
   public final static int EGmManagerCommand_AddProp = 11;
   // 管理员指令 - 开启地图。
   public final static int EGmManagerCommand_OpenMap = 12;
   // 管理员指令 - 开启家园所有建筑。
   public final static int EGmManagerCommand_ActiveHomeBuilding = 13;
   // 管理员指令 - 添加动员令。
   public final static int EGmManagerCommand_AddToken = 14;
   // 管理员指令 - 激活所有的塔。
   public final static int EGmManagerCommand_ActiveAllFort = 15;
   // 管理员指令 - 升级家园建筑。
   public final static int EGmManagerCommand_UpgradeHomeBuilding = 16;
   // 管理员指令 - 升级角色塔。
   public final static int EGmManagerCommand_UpgradeFort = 17;
   // 管理员指令 - 添加装备。
   public final static int EGmManagerCommand_AddEquip = 18;

   //------------------------------------------------------------
   // 蝴蝶状态 - 未知。
   public final static int EGmButterflyStatus_Unknown = 0;
   // 蝴蝶状态 - 工作状态。
   public final static int EGmButterflyStatus_Working = 1;
   // 蝴蝶状态 - 睡眠状态。
   public final static int EGmButterflyStatus_Sleeping = 2;

   //------------------------------------------------------------
   // 是否可赚 - 未知。
   public final static int EGmNpcCanCatch_Unknown = 0;
   // 是否可赚 - 可抓抓捕。
   public final static int EGmNpcCanCatch_True = 1;
   // 是否可赚 - 不可抓捕。
   public final static int EGmNpcCanCatch_False = 2;

   //------------------------------------------------------------
   // 家园事件 - 未知事件。
   public final static int EGmHomeEvent_Unknown = 0;
   // 家园事件 - 家园解锁。
   public final static int EGmHomeEvent_Unlock = 1;
   // 家园事件 - 家园升级。
   public final static int EGmHomeEvent_Upgrade = 2;

   //------------------------------------------------------------
   // 防御塔事件 - 未知。
   public final static int EGmFortEvent_Unknown = 0;
   // 防御塔事件 - 防御塔解锁。
   public final static int EGmFortEvent_Unlock = 1;
   // 防御塔事件 - 防御塔升级。
   public final static int EGmFortEvent_Upgrade = 2;
   // 防御塔事件 - 技能升级。
   public final static int EGmFortEvent_SkillUpgrade = 3;

   //------------------------------------------------------------
   // 获得物品事件 - 未知。
   public final static int EGmGetItemEvent_Unknown = 0;
   // 获得物品事件 - 诱敌获得。
   public final static int EGmGetItemEvent_Defense = 1;
   // 获得物品事件 - 礼品获得。
   public final static int EGmGetItemEvent_Gift = 2;
   // 获得物品事件 - 翻牌获得。
   public final static int EGmGetItemEvent_TurnOverCard = 3;
   // 获得物品事件 - 训练塔花费。
   public final static int EGmGetItemEvent_TrainingFortCost = 4;

   //------------------------------------------------------------
   // 消耗精华事件类型 - 未知。
   public final static int EGmCreamCostEvent_Unknown = 0;
   // 消耗精华事件类型 - 开启训练营水晶位置。
   public final static int EGmCreamCostEvent_UnlockCrystalPlace = 1;
   // 消耗精华事件类型 - 家园工人解锁。
   public final static int EGmCreamCostEvent_UnlockHomeWorker = 2;
   // 消耗精华事件类型 - 训练营位置解锁。
   public final static int EGmCreamCostEvent_UnlockTrainingPlace = 3;
   // 消耗精华事件类型 - 地图的塔位解锁。
   public final static int EGmCreamCostEvent_UnlockMapFortPlace = 4;
   // 消耗精华事件类型 - 诱捕失败时保留奴隶。
   public final static int EGmCreamCostEvent_FailureKeepSlave = 5;
   // 消耗精华事件类型 - 购买物品。
   public final static int EGmCreamCostEvent_BuyItem = 6;
   // 消耗精华事件类型 - 购买战斗令牌。
   public final static int EGmCreamCostEvent_BuyToken = 7;
   // 消耗精华事件类型 - 翻牌花费精华。
   public final static int EGmCreamCostEvent_TurnOverCardCost = 8;
   // 消耗精华事件类型 - 从礼包中获得精华。
   public final static int EGmCreamCostEvent_EarnCreamByGift = 9;
   // 消耗精华事件类型 - 翻牌获得精华。
   public final static int EGmCreamCostEvent_EarnCreamByTurnOverCard = 10;

   //------------------------------------------------------------
   // 消耗精华目标类型 - 未知。
   public final static int EGmCreamCostAimType_Unknown = 0;
   // 消耗精华目标类型 - 训练营水晶位置。
   public final static int EGmCreamCostAimType_CrystalPlace = 1;
   // 消耗精华目标类型 - 家园工人。
   public final static int EGmCreamCostAimType_HomeWorker = 2;
   // 消耗精华目标类型 - 训练营位置。
   public final static int EGmCreamCostAimType_TrainingPlace = 3;
   // 消耗精华目标类型 - 地图塔位。
   public final static int EGmCreamCostAimType_MapFortPlace = 4;
   // 消耗精华目标类型 - 诱捕地图失败时保留奴隶。
   public final static int EGmCreamCostAimType_MapFailureKeepSlave = 5;
   // 消耗精华目标类型 - 物品。
   public final static int EGmCreamCostAimType_Item = 6;
   // 消耗精华目标类型 - 突袭令。
   public final static int EGmCreamCostAimType_RaidToken = 7;
   // 消耗精华目标类型 - 诱捕令。
   public final static int EGmCreamCostAimType_DefenseToken = 8;
   // 消耗精华目标类型 - 翻牌。
   public final static int EGmCreamCostAimType_TurnOverCard = 9;
   // 消耗精华目标类型 - 精华。
   public final static int EGmCreamCostAimType_Cream = 10;

   //------------------------------------------------------------
   // 角色新手引导状态 - 未知。
   public final static int EGmRoleTutorialStatus_Unknown = 0;
   // 角色新手引导状态 - 完成。
   public final static int EGmRoleTutorialStatus_Completed = 1;
   // 角色新手引导状态 - 未完成。
   public final static int EGmRoleTutorialStatus_Uncomplete = 2;

   //------------------------------------------------------------
   // 跳过新手引导 - 未知。
   public final static int EGmIgnoreRoleTutorial_Unknown = 0;
   // 跳过新手引导 - 跳过。
   public final static int EGmIgnoreRoleTutorial_True = 1;
   // 跳过新手引导 - 不跳过。
   public final static int EGmIgnoreRoleTutorial_False = 2;

   //------------------------------------------------------------
   // 货币 - 未知。
   public final static int EGmCurrency_Unknown = 0;
   // 货币 - 灵气。
   public final static int EGmCurrency_Reiki = 1;
   // 货币 - 精华。
   public final static int EGmCurrency_Cream = 2;

   //------------------------------------------------------------
   // 折扣 - 未知。
   public final static int EGmDiscount_Unknown = 0;
   // 折扣 - 不打折。
   public final static int EGmDiscount_Disable = 1;
   // 折扣 - 好友打折。
   public final static int EGmDiscount_Friend = 2;
   // 折扣 - 所有人打折。
   public final static int EGmDiscount_Everybody = 3;

   //------------------------------------------------------------
   // 奴隶交易查询条件 - 未知。
   public final static int EGmTradeSlaveQueryCondition_Unknown = 0;
   // 奴隶交易查询条件 - 选择一级。
   public final static int EGmTradeSlaveQueryCondition_SelectLevel1 = 0x00000001;
   // 奴隶交易查询条件 - 选择二级。
   public final static int EGmTradeSlaveQueryCondition_SelectLevel2 = 0x00000002;
   // 奴隶交易查询条件 - 选择三级。
   public final static int EGmTradeSlaveQueryCondition_SelectLevel3 = 0x00000004;
   // 奴隶交易查询条件 - 选择四级。
   public final static int EGmTradeSlaveQueryCondition_SelectLevel4 = 0x00000008;
   // 奴隶交易查询条件 - 选择五级。
   public final static int EGmTradeSlaveQueryCondition_SelectLevel5 = 0x00000010;
   // 奴隶交易查询条件 - 选择六级。
   public final static int EGmTradeSlaveQueryCondition_SelectLevel6 = 0x00000020;
   // 奴隶交易查询条件 - 选择小兵。
   public final static int EGmTradeSlaveQueryCondition_SelectCommon = 0x00001000;
   // 奴隶交易查询条件 - 选择Boss。
   public final static int EGmTradeSlaveQueryCondition_SelectBoss = 0x00002000;
   // 奴隶交易查询条件 - 选择灵气。
   public final static int EGmTradeSlaveQueryCondition_SelectReiki = 0x00004000;
   // 奴隶交易查询条件 - 选择精华。
   public final static int EGmTradeSlaveQueryCondition_SelectCream = 0x00008000;
   // 奴隶交易查询条件 - 选择只看好友。
   public final static int EGmTradeSlaveQueryCondition_SelectOnlyFriend = 0x00010000;
   // 奴隶交易查询条件 - 查询我的交易。
   public final static int EGmTradeSlaveQueryCondition_SelectMyself = 0x00020000;

   //------------------------------------------------------------
   // 物品类型 - 未知。
   public final static int EGmItemType_Unknown = 0;
   // 物品类型 - 道具。
   public final static int EGmItemType_Prop = 1;
   // 物品类型 - 精华。
   public final static int EGmItemType_Cream = 2;

   //------------------------------------------------------------
   // 市场的售卖类型 - 未知。
   public final static int EGmMarketSellType_Unknown = 0;
   // 市场的售卖类型 - 出售一天。
   public final static int EGmMarketSellType_OneDay = 1;
   // 市场的售卖类型 - 出售三天。
   public final static int EGmMarketSellType_ThreeDay = 2;
   // 市场的售卖类型 - 出售一周。
   public final static int EGmMarketSellType_AWeek = 3;

   //------------------------------------------------------------
   // 令牌类型 - 未知。
   public final static int EGmMapTokenType_Unknown = 0;
   // 令牌类型 - 诱捕令牌。
   public final static int EGmMapTokenType_Defense = 1;
   // 令牌类型 - 突袭令牌。
   public final static int EGmMapTokenType_Raid = 2;

   //------------------------------------------------------------
   // 交易类型 - 未知。
   public final static int EGmTradeType_Unknown = 0;
   // 交易类型 - 购买奴隶。
   public final static int EGmTradeType_BuySlave = 1;
   // 交易类型 - 卖出奴隶。
   public final static int EGmTradeType_SellSlave = 2;

   //------------------------------------------------------------
   // 拍卖单状态 - 未知。
   public final static int EGmBillStatus_Unknown = 0;
   // 拍卖单状态 - 售卖中。
   public final static int EGmBillStatus_Selling = 1;
   // 拍卖单状态 - 已售卖。
   public final static int EGmBillStatus_SuccessfulTrade = 2;
   // 拍卖单状态 - 过期的。
   public final static int EGmBillStatus_outOfDate = 3;

   //------------------------------------------------------------
   // 物品使用 - 未知。
   public final static int EGmPropUse_Unknown = 0;
   // 物品使用 - 可使用。
   public final static int EGmPropUse_True = 1;
   // 物品使用 - 不可使用。
   public final static int EGmPropUse_False = 2;

   //------------------------------------------------------------
   // 新手引导暂停游戏 - 未知。
   public final static int EGmStudyPauseGame_Unknown = 0;
   // 新手引导暂停游戏 - 暂停。
   public final static int EGmStudyPauseGame_True = 1;
   // 新手引导暂停游戏 - 不暂停。
   public final static int EGmStudyPauseGame_False = 2;

   //------------------------------------------------------------
   // 训练营灵气池位置类型 - 未知。
   public final static int EGmTrainingPlace_Unknown = 0;
   // 训练营灵气池位置类型 - 自己的灵气池。
   public final static int EGmTrainingPlace_Own = 1;
   // 训练营灵气池位置类型 - 领主的灵气池。
   public final static int EGmTrainingPlace_Superior = 2;
   // 训练营灵气池位置类型 - 属臣的灵气池。
   public final static int EGmTrainingPlace_Vassal = 3;
   // 训练营灵气池位置类型 - 好友的灵气池。
   public final static int EGmTrainingPlace_Friend = 4;

   //------------------------------------------------------------
   // 地图隐藏类型 - 未知。
   public final static int EGmMapVisible_Unknown = 0;
   // 地图隐藏类型 - 可见。
   public final static int EGmMapVisible_True = 1;
   // 地图隐藏类型 - 隐藏。
   public final static int EGmMapVisible_False = 2;

   //------------------------------------------------------------
   // 地图完成类型 - 未知。
   public final static int EGmMapFinishType_Unknown = 0;
   // 地图完成类型 - 使用一级令牌通关。
   public final static int EGmMapFinishType_TokenLevel1 = 1;
   // 地图完成类型 - 使用二级令牌通关。
   public final static int EGmMapFinishType_TokenLevel2 = 2;
   // 地图完成类型 - 使用三级令牌通关。
   public final static int EGmMapFinishType_TokenLevel3 = 3;

   //------------------------------------------------------------
   // 波系数类型 - 未知。
   public final static int EGmMapWaveProperty_Unknown = 0;
   // 波系数类型 - 改变血量。
   public final static int EGmMapWaveProperty_ChangeHp = 1;
   // 波系数类型 - 改变移动速度。
   public final static int EGmMapWaveProperty_ChangeSpeed = 2;
   // 波系数类型 - 改变防御力。
   public final static int EGmMapWaveProperty_ChangeDefensePower = 3;
   // 波系数类型 - 改变攻击力。
   public final static int EGmMapWaveProperty_ChangeAttackPower = 4;

   //------------------------------------------------------------
   // 漂流瓶是否隐藏用户名 - 未知。
   public final static int EGmHiddenUserName_Unknown = 0;
   // 漂流瓶是否隐藏用户名 - 隐藏。
   public final static int EGmHiddenUserName_True = 1;
   // 漂流瓶是否隐藏用户名 - 不隐藏。
   public final static int EGmHiddenUserName_False = 2;

   //------------------------------------------------------------
   // 漂流瓶是否可见 - 未知。
   public final static int EGmCurrentBottleVisible_Unknown = 0;
   // 漂流瓶是否可见 - 漂流瓶可见。
   public final static int EGmCurrentBottleVisible_True = 1;
   // 漂流瓶是否可见 - 漂流瓶不可见。
   public final static int EGmCurrentBottleVisible_False = 2;

   //------------------------------------------------------------
   // 地图难度等级 - 未知。
   public final static int EGmMapDifficulty_Unknown = 0;
   // 地图难度等级 - 地图难度等级1。
   public final static int EGmMapDifficulty_Level1 = 1;
   // 地图难度等级 - 地图难度等级2。
   public final static int EGmMapDifficulty_Level2 = 2;
   // 地图难度等级 - 地图难度等级3。
   public final static int EGmMapDifficulty_Level3 = 3;
   // 地图难度等级 - 地图难度等级4。
   public final static int EGmMapDifficulty_Level4 = 4;
   // 地图难度等级 - 地图难度等级5。
   public final static int EGmMapDifficulty_Level5 = 5;

   //------------------------------------------------------------
   // 玩家反馈 - 未知。
   public final static int EGmSuggestion_Unknown = 0;
   // 玩家反馈 - 错误。
   public final static int EGmSuggestion_Bug = 1;
   // 玩家反馈 - 改进。
   public final static int EGmSuggestion_Improve = 2;
   // 玩家反馈 - 建议。
   public final static int EGmSuggestion_Suggest = 3;

   //------------------------------------------------------------
   // 奖励类型 - 未知。
   public final static int EGmReward_Unknown = 0;
   // 奖励类型 - 灵气。
   public final static int EGmReward_Reiki = 1;
   // 奖励类型 - 精华。
   public final static int EGmReward_Cream = 2;
   // 奖励类型 - 经验。
   public final static int EGmReward_Experience = 3;
   // 奖励类型 - 物品。
   public final static int EGmReward_Prop = 4;

   //------------------------------------------------------------
   // 漂流瓶类型 - 未知。
   public final static int EGmCurrentBottle_Unknown = 0;
   // 漂流瓶类型 - 广告瓶。
   public final static int EGmCurrentBottle_Advertisment = 1;
   // 漂流瓶类型 - 玩家扔的瓶子。
   public final static int EGmCurrentBottle_Player = 2;

   //------------------------------------------------------------
   // 抽奖奖品类型 - 未知。
   public final static int EGmAward_Unknown = 0;
   // 抽奖奖品类型 - 灵气。
   public final static int EGmAward_Reiki = 1;
   // 抽奖奖品类型 - 精华。
   public final static int EGmAward_Cream = 2;
   // 抽奖奖品类型 - 经验。
   public final static int EGmAward_Experience = 3;
   // 抽奖奖品类型 - 物品。
   public final static int EGmAward_Prop = 4;
   // 抽奖奖品类型 - 天火点。
   public final static int EGmAward_FirePoint = 5;

   //------------------------------------------------------------
   // 登录在线类型 - 未知。
   public final static int EGmLoginOnline_Unknown = 0;
   // 登录在线类型 - 在线。
   public final static int EGmLoginOnline_Online = 1;
   // 登录在线类型 - 离线。
   public final static int EGmLoginOnline_Offline = 2;

   //------------------------------------------------------------
   // 登录模式类型 - 未知。
   public final static int EGmLoginMode_Unknown = 0;
   // 登录模式类型 - 创建。
   public final static int EGmLoginMode_Create = 1;
   // 登录模式类型 - 链接。
   public final static int EGmLoginMode_Connect = 2;
   // 登录模式类型 - 断开。
   public final static int EGmLoginMode_Disconnect = 3;

   //------------------------------------------------------------
   // 登录检测类型 - 未知。
   public final static int EGmLoginCheck_Unknown = 0;
   // 登录检测类型 - 检测。
   public final static int EGmLoginCheck_True = 1;
   // 登录检测类型 - 非检测。
   public final static int EGmLoginCheck_No = 2;

   //------------------------------------------------------------
   // 奖品分库类型 - 未知。
   public final static int EGmAwardLibrary_Unknown = 0;
   // 奖品分库类型 - 每日翻牌挖宝。
   public final static int EGmAwardLibrary_DailyOverCard = 1;
   // 奖品分库类型 - 节日翻牌挖宝。
   public final static int EGmAwardLibrary_FestalOverCard = 2;
   // 奖品分库类型 - 自己挖宝1-9级。
   public final static int EGmAwardLibrary_SelfWork1 = 3;
   // 奖品分库类型 - 自己挖宝10-19级。
   public final static int EGmAwardLibrary_SelfWork10 = 4;
   // 奖品分库类型 - 自己挖宝20-29级。
   public final static int EGmAwardLibrary_SelfWork20 = 5;
   // 奖品分库类型 - 自己挖宝30-39级。
   public final static int EGmAwardLibrary_SelfWork30 = 6;
   // 奖品分库类型 - 自己挖宝40-49级。
   public final static int EGmAwardLibrary_SelfWork40 = 7;
   // 奖品分库类型 - 自己挖宝50-59级。
   public final static int EGmAwardLibrary_SelfWork50 = 8;
   // 奖品分库类型 - 自己挖宝60-69级。
   public final static int EGmAwardLibrary_SelfWork60 = 9;
   // 奖品分库类型 - 在线礼包1。
   public final static int EGmAwardLibrary_OnlineReward1 = 10;
   // 奖品分库类型 - 在线礼包2。
   public final static int EGmAwardLibrary_OnlineReward2 = 11;
   // 奖品分库类型 - 在线礼包3。
   public final static int EGmAwardLibrary_OnlineReward3 = 12;
   // 奖品分库类型 - 在线礼包4。
   public final static int EGmAwardLibrary_OnlineReward4 = 13;
   // 奖品分库类型 - 在线礼包5。
   public final static int EGmAwardLibrary_OnlineReward5 = 14;
   // 奖品分库类型 - 在线礼包6。
   public final static int EGmAwardLibrary_OnlineReward6 = 15;
   // 奖品分库类型 - 给领主挖宝1-9级。
   public final static int EGmAwardLibrary_LairdWork1 = 16;
   // 奖品分库类型 - 给领主挖宝10-19级。
   public final static int EGmAwardLibrary_LairdWork10 = 17;
   // 奖品分库类型 - 给领主挖宝20-29级。
   public final static int EGmAwardLibrary_LairdWork20 = 18;
   // 奖品分库类型 - 给领主挖宝30-39级。
   public final static int EGmAwardLibrary_LairdWork30 = 19;
   // 奖品分库类型 - 给领主挖宝40-49级。
   public final static int EGmAwardLibrary_LairdWork40 = 20;
   // 奖品分库类型 - 给领主挖宝50-59级。
   public final static int EGmAwardLibrary_LairdWork50 = 21;
   // 奖品分库类型 - 给领主挖宝60-69级。
   public final static int EGmAwardLibrary_LairdWork60 = 22;
   // 奖品分库类型 - 属臣挖宝1-9级。
   public final static int EGmAwardLibrary_FootmanWork1 = 23;
   // 奖品分库类型 - 属臣挖宝10-19级。
   public final static int EGmAwardLibrary_FootmanWork10 = 24;
   // 奖品分库类型 - 属臣挖宝20-29级。
   public final static int EGmAwardLibrary_FootmanWork20 = 25;
   // 奖品分库类型 - 属臣挖宝30-39级。
   public final static int EGmAwardLibrary_FootmanWork30 = 26;
   // 奖品分库类型 - 属臣挖宝40-49级。
   public final static int EGmAwardLibrary_FootmanWork40 = 27;
   // 奖品分库类型 - 属臣挖宝50-59级。
   public final static int EGmAwardLibrary_FootmanWork50 = 28;
   // 奖品分库类型 - 属臣挖宝60-69级。
   public final static int EGmAwardLibrary_FootmanWork60 = 29;
   // 奖品分库类型 - Vip蝴蝶挖宝1-9级。
   public final static int EGmAwardLibrary_VipWork1 = 30;
   // 奖品分库类型 - Vip蝴蝶挖宝10-19级。
   public final static int EGmAwardLibrary_VipWork10 = 31;
   // 奖品分库类型 - Vip蝴蝶挖宝20-29级。
   public final static int EGmAwardLibrary_VipWork20 = 32;
   // 奖品分库类型 - Vip蝴蝶挖宝30-39级。
   public final static int EGmAwardLibrary_VipWork30 = 33;
   // 奖品分库类型 - Vip蝴蝶挖宝40-49级。
   public final static int EGmAwardLibrary_VipWork40 = 34;
   // 奖品分库类型 - Vip蝴蝶挖宝50-59级。
   public final static int EGmAwardLibrary_VipWork50 = 35;
   // 奖品分库类型 - Vip蝴蝶挖宝60-69级。
   public final static int EGmAwardLibrary_VipWork60 = 36;
   // 奖品分库类型 - 签到每日奖励1。
   public final static int EGmAwardLibrary_RewardSignDay1 = 30;
   // 奖品分库类型 - 签到每日奖励2。
   public final static int EGmAwardLibrary_RewardSignDay2 = 31;
   // 奖品分库类型 - 签到每日奖励3。
   public final static int EGmAwardLibrary_RewardSignDay3 = 32;
   // 奖品分库类型 - 签到每日奖励4。
   public final static int EGmAwardLibrary_RewardSignDay4 = 33;
   // 奖品分库类型 - 签到阶段奖励2天。
   public final static int EGmAwardLibrary_RewardSignStage2 = 34;
   // 奖品分库类型 - 签到阶段奖励5天。
   public final static int EGmAwardLibrary_RewardSignStage5 = 35;
   // 奖品分库类型 - 签到阶段奖励10天。
   public final static int EGmAwardLibrary_RewardSignStage10 = 36;
   // 奖品分库类型 - 签到阶段奖励20天。
   public final static int EGmAwardLibrary_RewardSignStage20 = 37;
   // 奖品分库类型 - 签到阶段奖励满月。
   public final static int EGmAwardLibrary_RewardSignStage31 = 38;

   //------------------------------------------------------------
   // 订单状态 - 未知。
   public final static int EGmOrderStatus_Unknown = 0;
   // 订单状态 - 打开。
   public final static int EGmOrderStatus_Open = 1;
   // 订单状态 - 订购。
   public final static int EGmOrderStatus_Order = 2;
   // 订单状态 - 付费。
   public final static int EGmOrderStatus_Pay = 3;
   // 订单状态 - 发货。
   public final static int EGmOrderStatus_Send = 4;
   // 订单状态 - 关闭。
   public final static int EGmOrderStatus_Close = 5;

   //------------------------------------------------------------
   // 订单测试 - 未知。
   public final static int EGmOrderTest_Unknown = 0;
   // 订单测试 - 是。
   public final static int EGmOrderTest_Yes = 1;
   // 订单测试 - 否。
   public final static int EGmOrderTest_No = 2;

   //------------------------------------------------------------
   // 礼物类型 - 未知。
   public final static int EGmGiftType_Unknown = 0;
   // 礼物类型 - 精华。
   public final static int EGmGiftType_Cream = 1;
   // 礼物类型 - 道具。
   public final static int EGmGiftType_Prop = 2;
   // 礼物类型 - NPC。
   public final static int EGmGiftType_Fort = 3;

   //------------------------------------------------------------
   // 进入地图排行 - 道具。
   public final static int EGmEnterMapRank_Unknown = 0;
   // 进入地图排行 - 进入。
   public final static int EGmEnterMapRank_Yes = 1;
   // 进入地图排行 - 未进入。
   public final static int EGmEnterMapRank_No = 2;

   //------------------------------------------------------------
   // 订单付费类型 - 未知。
   public final static int EGmOrderPay_Unknown = 0;
   // 订单付费类型 - 正常支付。
   public final static int EGmOrderPay_Normal = 1;
   // 订单付费类型 - 赠送支付。
   public final static int EGmOrderPay_Send = 2;
   // 订单付费类型 - 索引支付。
   public final static int EGmOrderPay_Query = 3;

   //------------------------------------------------------------
   // 订单物品类型 - 未知。
   public final static int EGmOrderItem_Unknown = 0;
   // 订单物品类型 - 付费1。
   public final static int EGmOrderItem_Item1 = 1;
   // 订单物品类型 - 付费2。
   public final static int EGmOrderItem_Item2 = 2;
   // 订单物品类型 - 付费3。
   public final static int EGmOrderItem_Item3 = 3;
   // 订单物品类型 - 付费4。
   public final static int EGmOrderItem_Item4 = 4;
   // 订单物品类型 - 付费5。
   public final static int EGmOrderItem_Item5 = 5;

   //------------------------------------------------------------
   // 礼物可见 - 未知。
   public final static int EGmGiftVisibel_Unknown = 0;
   // 礼物可见 - 有礼物。
   public final static int EGmGiftVisibel_Yes = 1;
   // 礼物可见 - 没有礼物。
   public final static int EGmGiftVisibel_No = 2;

   //------------------------------------------------------------
   // 两个玩家之间的关系 - 未知。
   public final static int EGmRelationShip_Unknown = 0;
   // 两个玩家之间的关系 - 领主。
   public final static int EGmRelationShip_Laird = 1;
   // 两个玩家之间的关系 - 属臣。
   public final static int EGmRelationShip_Footman = 2;
   // 两个玩家之间的关系 - 好友。
   public final static int EGmRelationShip_Friend = 3;
   // 两个玩家之间的关系 - 自己。
   public final static int EGmRelationShip_Self = 4;

   //------------------------------------------------------------
   // 成就分组奖励状态 - 未知。
   public final static int EGmAchievementGroupStatus_Unknown = 0;
   // 成就分组奖励状态 - 处理。
   public final static int EGmAchievementGroupStatus_Process = 1;
   // 成就分组奖励状态 - 成功。
   public final static int EGmAchievementGroupStatus_Success = 2;

   //------------------------------------------------------------
   // 成就领取状态 - 未知。
   public final static int EGmAchievementGroupRewardStatus_Unknown = 0;
   // 成就领取状态 - 已领取。
   public final static int EGmAchievementGroupRewardStatus_True = 1;
   // 成就领取状态 - 未领取。
   public final static int EGmAchievementGroupRewardStatus_False = 2;

   //------------------------------------------------------------
   // 成就状态 - 未知。
   public final static int EGmAchievementStatus_Unknown = 0;
   // 成就状态 - 处理。
   public final static int EGmAchievementStatus_Process = 1;
   // 成就状态 - 成功。
   public final static int EGmAchievementStatus_Success = 2;

   //------------------------------------------------------------
   // 成就条件 - 未知。
   public final static int EGmAchievementCondition_Unknown = 0;
   // 成就条件 - 建造塔。
   public final static int EGmAchievementCondition_MapFortPlace = 1;
   // 成就条件 - 杀死士兵。
   public final static int EGmAchievementCondition_MapSoliderKill = 2;
   // 成就条件 - 捕获士兵。
   public final static int EGmAchievementCondition_MapSoliderCatch = 3;
   // 成就条件 - 掉落箱子。
   public final static int EGmAchievementCondition_MapDropItem = 4;

   //------------------------------------------------------------
   // 成就条件状态 - 未知。
   public final static int EGmAchievementConditionStatus_Unknown = 0;
   // 成就条件状态 - 处理。
   public final static int EGmAchievementConditionStatus_Process = 1;
   // 成就条件状态 - 成功。
   public final static int EGmAchievementConditionStatus_Success = 2;

   //------------------------------------------------------------
   // 计数类型 - 未知。
   public final static int EGmCountType_Unknown = 0;
   // 计数类型 - 角色。
   public final static int EGmCountType_Npc = 1;

   //------------------------------------------------------------
   // 计数命令 - 未知。
   public final static int EGmCountAction_Unknown = 0;
   // 计数命令 - 建造塔。
   public final static int EGmCountAction_MapFortPlace = 1;
   // 计数命令 - 杀死士兵。
   public final static int EGmCountAction_MapSoliderKill = 2;
   // 计数命令 - 捕获士兵。
   public final static int EGmCountAction_MapSoliderCatch = 3;
   // 计数命令 - 掉落箱子。
   public final static int EGmCountAction_MapDropItem = 4;

   //------------------------------------------------------------
   // 公告类型 - 未知。
   public final static int EGmRoleMessage_Unknown = 0;
   // 公告类型 - 系统类型。
   public final static int EGmRoleMessage_System = 1;
   // 公告类型 - 玩家类型。
   public final static int EGmRoleMessage_Game = 2;

   //------------------------------------------------------------
   // 公告事件类型 - 未知。
   public final static int EGmMessageEvent_Unknown = 0;
   // 公告事件类型 - 抽奖获得精华。
   public final static int EGmMessageEvent_GetCreamByCard = 1;
   // 公告事件类型 - 刷新地图记录。
   public final static int EGmMessageEvent_RefreshMapRecord = 2;
   // 公告事件类型 - 统治力达到榜首。
   public final static int EGmMessageEvent_OverlordFirst = 3;
   // 公告事件类型 - 玩家进入。
   public final static int EGmMessageEvent_PlayerEnter = 4;
   // 公告事件类型 - 突袭单独玩家成功。
   public final static int EGmMessageEvent_RaidPlayerWin = 5;
   // 公告事件类型 - 突袭有领主玩家成功。
   public final static int EGmMessageEvent_RaidSlaveWin = 6;
   // 公告事件类型 - 拿属臣物品。
   public final static int EGmMessageEvent_TakeItem = 7;

   //------------------------------------------------------------
   // 排行榜类型 - 未知的。
   public final static int EGmRank_Unknown = 0;
   // 排行榜类型 - 玩家级别排行榜。
   public final static int EGmRank_Level = 1;
   // 排行榜类型 - 玩家灵气排行榜。
   public final static int EGmRank_Reiki = 2;
   // 排行榜类型 - 玩家繁荣度排行榜。
   public final static int EGmRank_Prosperity = 3;
   // 排行榜类型 - 玩家布阵评分排行榜。
   public final static int EGmRank_EmbattleGrade = 4;
   // 排行榜类型 - 玩家统治力排行榜。
   public final static int EGmRank_Overlord = 5;

   //------------------------------------------------------------
   // 地图变更 - 未知。
   public final static int EGmMapChange_Unknown = 0;
   // 地图变更 - 不能变更。
   public final static int EGmMapChange_None = 1;
   // 地图变更 - 玩家变更。
   public final static int EGmMapChange_User = 2;

   //------------------------------------------------------------
   // 格子类型 - 未知。
   public final static int EGmMapCell_Unknown = 0;
   // 格子类型 - 阻挡点。
   public final static int EGmMapCell_Block = 1;
   // 格子类型 - 道路点。
   public final static int EGmMapCell_Road = 2;
   // 格子类型 - 炮台点。
   public final static int EGmMapCell_Fort = 4;
   // 格子类型 - 士兵点。
   public final static int EGmMapCell_Solider = 8;
   // 格子类型 - 改造点。
   public final static int EGmMapCell_Place = 16;

   //------------------------------------------------------------
   // 产生的来源 - 未知。
   public final static int EGmWarehouseProduce_Unknown = 0;
   // 产生的来源 - 自己产生。
   public final static int EGmWarehouseProduce_Self = 1;
   // 产生的来源 - 给领主干活儿产生。
   public final static int EGmWarehouseProduce_ForLaird = 2;
   // 产生的来源 - 属臣给你干活儿产生。
   public final static int EGmWarehouseProduce_Footman = 3;
   // 产生的来源 - Vip生产。
   public final static int EGmWarehouseProduce_Vip = 4;

   //------------------------------------------------------------
   // 抽奖分组类型 - 未知。
   public final static int EGmAwardgroup_Unknown = 0;
   // 抽奖分组类型 - 每日翻牌挖宝。
   public final static int EGmAwardgroup_DailyOverCard = 1;
   // 抽奖分组类型 - 节日翻牌挖宝。
   public final static int EGmAwardgroup_FestalOverCard = 2;
   // 抽奖分组类型 - 派属臣挖宝。
   public final static int EGmAwardgroup_FootmanWork = 3;
   // 抽奖分组类型 - 给领主干活儿。
   public final static int EGmAwardgroup_LairdWork = 4;
   // 抽奖分组类型 - 自己挖宝。
   public final static int EGmAwardgroup_SelfWork = 5;
   // 抽奖分组类型 - 在线奖励。
   public final static int EGmAwardgroup_OnlineReward = 6;
   // 抽奖分组类型 - 每日签到。
   public final static int EGmAwardgroup_RewardSignDay = 7;
   // 抽奖分组类型 - 阶段签到。
   public final static int EGmAwardgroup_RewardSignStage = 8;
   // 抽奖分组类型 - VIP蝴蝶工作。
   public final static int EGmAwardgroup_VipWork = 9;

   //------------------------------------------------------------
   // 布阵格子类型 - 未知。
   public final static int EGmEmbattleCell_Unknown = 0;
   // 布阵格子类型 - 放置。
   public final static int EGmEmbattleCell_Place = 1;
   // 布阵格子类型 - 实体。
   public final static int EGmEmbattleCell_Npc = 2;
   // 布阵格子类型 - 物品。
   public final static int EGmEmbattleCell_Prop = 3;

   //------------------------------------------------------------
   // 布阵放置类型 - 未知。
   public final static int EGmEmbattlePlace_Unknown = 0;
   // 布阵放置类型 - 可。
   public final static int EGmEmbattlePlace_True = 1;
   // 布阵放置类型 - 否。
   public final static int EGmEmbattlePlace_False = 2;

   //------------------------------------------------------------
   // 地图结果 - 未知。
   public final static int EGmMapResult_Unknown = 0;
   // 地图结果 - 成功。
   public final static int EGmMapResult_Success = 1;
   // 地图结果 - 失败。
   public final static int EGmMapResult_Failure = 2;

   //------------------------------------------------------------
   // 老玩家是否登陆过 - 未知。
   public final static int EGmOldAccountLogin_Unknown = 0;
   // 老玩家是否登陆过 - 登陆过。
   public final static int EGmOldAccountLogin_True = 1;
   // 老玩家是否登陆过 - 未登陆。
   public final static int EGmOldAccountLogin_False = 2;

   //------------------------------------------------------------
   // 布阵状态 - 未知。
   public final static int EGmEmbattleStatus_Unknown = 0;
   // 布阵状态 - 可使用的。
   public final static int EGmEmbattleStatus_CanUse = 1;
   // 布阵状态 - 使用过的。
   public final static int EGmEmbattleStatus_Used = 2;

   //------------------------------------------------------------
   // 签到状态 - 未知。
   public final static int EGmSignatureStatus_Unknown = 0;
   // 签到状态 - 已签到。
   public final static int EGmSignatureStatus_Sign = 1;
   // 签到状态 - 已补签。
   public final static int EGmSignatureStatus_Resign = 2;
   // 签到状态 - 不能签到。
   public final static int EGmSignatureStatus_CanNotSign = 4;
   // 签到状态 - 未签到。
   public final static int EGmSignatureStatus_HaveNot = 3;

   //------------------------------------------------------------
   // 签到进度 - 未知。
   public final static int EGmSignatureLevel_Unknown = 0;
   // 签到进度 - 两天。
   public final static int EGmSignatureLevel_TwoDay = 1;
   // 签到进度 - 五天。
   public final static int EGmSignatureLevel_FiveDay = 2;
   // 签到进度 - 十天。
   public final static int EGmSignatureLevel_TenDay = 3;
   // 签到进度 - 二十天。
   public final static int EGmSignatureLevel_TwentyDay = 4;
   // 签到进度 - 整月。
   public final static int EGmSignatureLevel_FullMonth = 5;

   //------------------------------------------------------------
   // 签到进度状态 - 未知。
   public final static int EGmSignatureLevelStatus_Unknown = 0;
   // 签到进度状态 - 完成。
   public final static int EGmSignatureLevelStatus_Complete = 1;
   // 签到进度状态 - 未完成。
   public final static int EGmSignatureLevelStatus_Uncomplete = 2;

   //------------------------------------------------------------
   // 角色神技激活状态 - 未知。
   public final static int EGmRoleSkillActivation_Unknown = 0;
   // 角色神技激活状态 - 可以激活但没有激活。
   public final static int EGmRoleSkillActivation_Available = 1;
   // 角色神技激活状态 - 已激活。
   public final static int EGmRoleSkillActivation_True = 2;
   // 角色神技激活状态 - 未激活。
   public final static int EGmRoleSkillActivation_False = 3;

   //------------------------------------------------------------
   // 签到操作 - 未知。
   public final static int EGmSignatureOperation_Unknown = 0;
   // 签到操作 - 查询。
   public final static int EGmSignatureOperation_Query = 1;
   // 签到操作 - 签到。
   public final static int EGmSignatureOperation_Sign = 2;
   // 签到操作 - 补签。
   public final static int EGmSignatureOperation_Resign = 3;
   // 签到操作 - 领取。
   public final static int EGmSignatureOperation_Receive = 4;

   //------------------------------------------------------------
   // NPC样式初始化是否显示 - 未知。
   public final static int EGmStyleInitialize_Unknown = 0;
   // NPC样式初始化是否显示 - 初始显示。
   public final static int EGmStyleInitialize_True = 1;
   // NPC样式初始化是否显示 - 初始不显示。
   public final static int EGmStyleInitialize_False = 2;

   //------------------------------------------------------------
   // 玩家布阵地图是否被突袭过 - 未知。
   public final static int EGmBeenRaid_Unknown = 0;
   // 玩家布阵地图是否被突袭过 - 被突袭过。
   public final static int EGmBeenRaid_True = 1;
   // 玩家布阵地图是否被突袭过 - 没有被突袭过。
   public final static int EGmBeenRaid_False = 2;

   //------------------------------------------------------------
   // 角色的防御塔是否可用 - 未知。
   public final static int EGmFortAvailable_Unknown = 0;
   // 角色的防御塔是否可用 - 防御塔可用。
   public final static int EGmFortAvailable_True = 1;
   // 角色的防御塔是否可用 - 防御塔不可用。
   public final static int EGmFortAvailable_False = 2;

   //------------------------------------------------------------
   // 角色的离线消息状态 - 未知。
   public final static int EGmOfflineMessageStatus_Unknown = 0;
   // 角色的离线消息状态 - 已读。
   public final static int EGmOfflineMessageStatus_Read = 1;
   // 角色的离线消息状态 - 创建。
   public final static int EGmOfflineMessageStatus_Create = 2;

   //------------------------------------------------------------
   // 布阵地图激活 - 未知。
   public final static int EGmEmbattleActivation_Unknown = 0;
   // 布阵地图激活 - 激活。
   public final static int EGmEmbattleActivation_True = 1;
   // 布阵地图激活 - 未激活。
   public final static int EGmEmbattleActivation_False = 2;

   //------------------------------------------------------------
   // 布阵地图是否布过阵 - 未知。
   public final static int EGmMapEmbattled_Unknown = 0;
   // 布阵地图是否布过阵 - 已布阵。
   public final static int EGmMapEmbattled_True = 1;
   // 布阵地图是否布过阵 - 未布阵。
   public final static int EGmMapEmbattled_False = 2;

   //------------------------------------------------------------
   // 是否选择过英雄 - 未知。
   public final static int EGmSelectedHero_Unknown = 0;
   // 是否选择过英雄 - 已选择。
   public final static int EGmSelectedHero_True = 1;
   // 是否选择过英雄 - 未选择。
   public final static int EGmSelectedHero_False = 2;

   //------------------------------------------------------------
   // 蝴蝶仓库格子激活 - 未知。
   public final static int EGmWarehouseGridActivation_Unknown = 0;
   // 蝴蝶仓库格子激活 - 已激活。
   public final static int EGmWarehouseGridActivation_True = 1;
   // 蝴蝶仓库格子激活 - 未激活。
   public final static int EGmWarehouseGridActivation_False = 2;

   //------------------------------------------------------------
   // 蝴蝶仓库格子状态 - 未知。
   public final static int EGmWarehouseGridStatus_Unknown = 0;
   // 蝴蝶仓库格子状态 - 空闲中。
   public final static int EGmWarehouseGridStatus_Free = 1;
   // 蝴蝶仓库格子状态 - 使用中。
   public final static int EGmWarehouseGridStatus_Using = 2;
   // 蝴蝶仓库格子状态 - 完成产出。
   public final static int EGmWarehouseGridStatus_Finished = 3;

   //------------------------------------------------------------
   // 突袭迎战方式 - 未知。
   public final static int EGmRaidBeginQuest_Unknown = 0;
   // 突袭迎战方式 - 家园请求。
   public final static int EGmRaidBeginQuest_InHome = 1;
   // 突袭迎战方式 - 布阵请求。
   public final static int EGmRaidBeginQuest_InEmbattle = 2;

   //------------------------------------------------------------
   // 消耗类型 - 未知。
   public final static int EGmExpendType_Unknown = 0;
   // 消耗类型 - 灵气。
   public final static int EGmExpendType_Reiki = 1;
   // 消耗类型 - 道具。
   public final static int EGmExpendType_Prop = 2;

   //------------------------------------------------------------
   // 物品类型 - 未知。
   public final static int EGmPropGroup_Unknown = 0;
   // 物品类型 - 道具。
   public final static int EGmPropGroup_Prop = 1;
   // 物品类型 - 材料。
   public final static int EGmPropGroup_Material = 2;
   // 物品类型 - 其他。
   public final static int EGmPropGroup_Item = 3;
   // 物品类型 - 装备。
   public final static int EGmPropGroup_Equip = 4;

   //------------------------------------------------------------
   // 物品可否出售 - 未知。
   public final static int EGmPropSell_Unknown = 0;
   // 物品可否出售 - 可出售。
   public final static int EGmPropSell_True = 1;
   // 物品可否出售 - 不可出售。
   public final static int EGmPropSell_False = 2;

   //------------------------------------------------------------
   // 登录来源 - 未知。
   public final static int EGmLoginSource_Unknown = 0;
   // 登录来源 - 本地登录。
   public final static int EGmLoginSource_Local = 1;
   // 登录来源 - 平台登录。
   public final static int EGmLoginSource_Platform = 2;

   //------------------------------------------------------------
   // 需要同步好友 - 未知。
   public final static int EGmNeedSyncFriend_Unknown = 0;
   // 需要同步好友 - 需要同步。
   public final static int EGmNeedSyncFriend_True = 1;
   // 需要同步好友 - 不需要同步。
   public final static int EGmNeedSyncFriend_False = 2;

   //------------------------------------------------------------
   // 装备品质 - 未知。
   public final static int EGmEquipQuality_Unknown = 0;
   // 装备品质 - 白色。
   public final static int EGmEquipQuality_White = 1;
   // 装备品质 - 绿色。
   public final static int EGmEquipQuality_Green = 2;
   // 装备品质 - 蓝色。
   public final static int EGmEquipQuality_Blue = 3;
   // 装备品质 - 紫色。
   public final static int EGmEquipQuality_Purple = 4;
   // 装备品质 - 金色。
   public final static int EGmEquipQuality_Gold = 5;

   //------------------------------------------------------------
   // 装备增强类型 - 未知。
   public final static int EGmEquipPowerful_Unknown = 0;
   // 装备增强类型 - 攻击力。
   public final static int EGmEquipPowerful_PowerPoint = 1;
   // 装备增强类型 - 攻击间隔。
   public final static int EGmEquipPowerful_SpeedPoint = 2;
   // 装备增强类型 - 攻击距离。
   public final static int EGmEquipPowerful_DistancePoint = 3;
   // 装备增强类型 - 血量。
   public final static int EGmEquipPowerful_HpPoint = 4;
   // 装备增强类型 - 攻击力比例。
   public final static int EGmEquipPowerful_PowerRate = 5;
   // 装备增强类型 - 攻击间隔比例。
   public final static int EGmEquipPowerful_SpeedRate = 6;
   // 装备增强类型 - 攻击距离比例。
   public final static int EGmEquipPowerful_DistanceRate = 7;
   // 装备增强类型 - 血量比例。
   public final static int EGmEquipPowerful_HpRate = 8;
   // 装备增强类型 - 技能等级。
   public final static int EGmEquipPowerful_SkillLevel = 9;
   // 装备增强类型 - 专属附加攻击。
   public final static int EGmEquipPowerful_AttackPowerRate = 10;

   //------------------------------------------------------------
   // 装备技能状态 - 未知。
   public final static int EGmEquipSkillStatus_Unknown = 0;
   // 装备技能状态 - 未开启。
   public final static int EGmEquipSkillStatus_Close = 1;
   // 装备技能状态 - 已开启。
   public final static int EGmEquipSkillStatus_Open = 2;

   //------------------------------------------------------------
   // 聊天频道类型 - 未知。
   public final static int EGmChatChannel_Unknown = 0;
   // 聊天频道类型 - 系统频道。
   public final static int EGmChatChannel_System = 1;
   // 聊天频道类型 - 世界频道。
   public final static int EGmChatChannel_World = 2;
   // 聊天频道类型 - 私人频道。
   public final static int EGmChatChannel_Personal = 3;
   // 聊天频道类型 - 好友信息频道。
   public final static int EGmChatChannel_Friend = 4;
   // 聊天频道类型 - 所有信息。
   public final static int EGmChatChannel_All = 5;

   //------------------------------------------------------------
   // 装备位置 - 未知。
   public final static int EGmEquipPlace_Unknown = 0;
   // 装备位置 - 武器。
   public final static int EGmEquipPlace_Weapon = 1;
   // 装备位置 - 翅膀。
   public final static int EGmEquipPlace_Wing = 2;
   // 装备位置 - 头部。
   public final static int EGmEquipPlace_Head = 3;
   // 装备位置 - 手部。
   public final static int EGmEquipPlace_Hand = 4;
   // 装备位置 - 身体。
   public final static int EGmEquipPlace_Body = 5;
   // 装备位置 - 脚部。
   public final static int EGmEquipPlace_Foot = 6;
   // 装备位置 - 时装。
   public final static int EGmEquipPlace_Dress = 7;

   //------------------------------------------------------------
   // 收到的调戏消息的类型 - 未知的类型。
   public final static int EGmMolestNotify_Unknown = 0;
   // 收到的调戏消息的类型 - 调戏发起者收到的消息。
   public final static int EGmMolestNotify_SponsorMessage = 1;
   // 收到的调戏消息的类型 - 收到调戏者收到的消息。
   public final static int EGmMolestNotify_ReceipientMessage = 2;
   // 收到的调戏消息的类型 - 收到调戏者好友收到的消息。
   public final static int EGmMolestNotify_ReceipientFriendMessage = 3;
}
