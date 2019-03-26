##游戏元素：
界面左侧是一个大的Panel，是游戏地图。

右侧有两个Panel，上面是人物属性，下面是信息输出。

人物属性有：角色类型；等级；经验值；攻防血蓝；装备。

信息输出内容为：战斗信息；物品掉落与拾取；升级信息等。

左侧大地图上随机分布各个等级怪物。怪物有三个等级（即三种怪物），
第三级为唯一BOSS。

击杀BOSS游戏结束，击杀小怪可以升级、掉落装备、加经验。

升级加攻加防加血限且回满血。

脱离战斗后人与怪物均回血。

装备分为两种：一种剑，一种盾。各自有三个等级的装备，掉落概率逐渐降低。

同一种装备同一时间只可以装备一件，捡起新的后自动替换掉旧的。

角色有三个技能，第一个普攻，CD 0.5s；第二个Buff/DeBuff技能，
使得之后的5次攻击有加成，CD10s； 第三个大招，CD20s

##设计模式：
- 工厂模式：怪物、装备的生成
- 状态模式：脱战后回血；buff与debuff
- 装饰者模式：装备加成
- 观察者模式：人物信息（血）的变化
- 单例模式：日志打印；工厂单例

##必选功能的体现：
- 角色类型系统 ： 开局有两种角色供选择。骑士和战士。骑士有buff技能。战士有debuff技能。
- 角色装备加成功能 ： 剑加攻，盾加防。
- 武器类型与加强系统 ： 类型为剑/盾， 加强为三种等级的装备。
- 角色升级体系 ： 升级。
- 技能升级体系及技能组合体系 ： 技能有熟练度，用一次加一点经验，也分三级。
技能间的合作则是Buff/DeBuff技能。